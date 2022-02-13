package empresaMicros;

import java.util.ArrayList;
import java.util.HashSet;	//BORRAR

public class Micro {
	private int idMicro;
	private boolean[] asientos; //LA CANTIDAD DE ASIENTOS ES ESTÁTICO
	
	//VARIABLE AUXILIAR
	private HashSet<Integer> asientosLibres;
	
	Micro(int idMicro, int cantAsientos){
		this.idMicro = idMicro; 
		 setCantAsientos(cantAsientos);
		asientos = new boolean[cantAsientos];
		asientosLibres = new HashSet<>();
		
		for(int i=0; i<asientos.length; i++) {
			 asientos[i] = true;					//TRUE = LIBRE
			 asientosLibres.add(i);
		 }
	}
	
	//SETTERS USADOS
	
	private void setCantAsientos(int cantAsientos) {
		if(cantAsientos < 1)
			throw new RuntimeException("La cantidad de asientos debe ser mayor a 0");
	}
	
	//MÉTODOS PRINCIPALES
	
	boolean ocupado(int nroAsiento) {
		return nroAsiento>=0 && nroAsiento<asientos.length && !asientos[nroAsiento];
	}
	
	void ocuparAsiento(Integer nroAsiento) { 
		if(!ocupado(nroAsiento)) {
			asientos[nroAsiento] = false;
			asientosLibres.remove(nroAsiento);
		}
	}
	
	int cantAsientosLibres() {
		return asientosLibres.size();
	}
	
	void liberarAsiento(Integer nroAsiento) {
		if(ocupado(nroAsiento)) {
			asientos[nroAsiento] = true;
			asientosLibres.add(nroAsiento);
		}
	}
	
	int verAsientoLibre() {
		if(!asientosLibres.isEmpty())
			return asientosLibres.iterator().next();
		throw new RuntimeException("No hay asientos libres");
	}
	
	void cambiarMicro(Micro b) {
		while(tieneAsientosLibres() && b.tieneAsientosOcupados()) {
			ocuparAsiento(verAsientoLibre());
			b.liberarAsiento(b.verAsientoOcupado());
		}
	}
	
	//MÉTODOS AUXILIARES
	
	private boolean tieneAsientosLibres() {
		return !asientosLibres.isEmpty();
	}
	
	private boolean tieneAsientosOcupados() {
		boolean encontro=false;
		int i=0;
		while(!encontro && i < asientos.length) {
			if(asientos[i] == false)
				encontro = true;
			i++;
		}
		return encontro;
	}
	
	private int verAsientoOcupado() {
		boolean encontro=false;
		int i = 0;
		int asiento = -1;
		while(!encontro && i < asientos.length) {
			if(asientos[i] == false) {
				asiento = i;
				encontro = true;
			}
			i++;
		}
		return asiento;
	}
	
}

package empresaMicros;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	private HashMap<Integer,Micro> micros; //ACCESO A LOS MICROS POR SU ID
	private ArrayList<Viaje> viajes;			 //SOLO REGISTRA VIAJES
	
	Empresa(){
		micros = new HashMap<>();
		viajes =  new ArrayList<>();
	}
	
	//MÉTODOS PRINCIPALES
	
	void ocuparAsiento(Integer idMicro, int nroAsiento) {
		if(!asientoOcupado(idMicro, nroAsiento))
			micros.get(idMicro).ocuparAsiento(nroAsiento);
	}
	
	int cantAsientosLibres(Integer idMicro) {
		if(estaMicro(idMicro))
			return micros.get(idMicro).cantAsientosLibres();
		else
			throw new RuntimeException("El micro no existe");
	}
	
	void liberarAsiento(Integer idMicro, int nroAsiento) {
		if(estaMicro(idMicro)) {
			micros.get(idMicro).liberarAsiento(nroAsiento);
		}
	}
	
	void cambiarMicro(Integer idMicroA, Integer idMicroB) {
		if(estaMicro(idMicroA) && estaMicro(idMicroB)) {
			Micro a = micros.get(idMicroA);
			Micro b = micros.get(idMicroB);
			a.cambiarMicro(b);
		}
	}
	
	boolean asientoOcupado(Integer idMicro, int nroAsiento) {
		return estaMicro(idMicro) && micros.get(idMicro).ocupado(nroAsiento);
	}
	
	int verAsientoLibre(Integer idMicro) {
		if(estaMicro(idMicro))
			return micros.get(idMicro).verAsientoLibre();
		throw new RuntimeException("El micro no existe");
	}
	
	void agregarMicro(Integer idMicro, int cantAsientos) {
		micros.put(idMicro, new Micro(idMicro,cantAsientos));
	}
	
	void registrarViaje(Integer idMicro, Fecha fecha, String destino, double costoPorAsiento ) {
		if(estaMicro(idMicro))
			viajes.add(new Viaje(micros.get(idMicro), fecha, destino, costoPorAsiento));
	}
	
	//MÉTODO AUXILIAR
	
	private boolean estaMicro(Integer idMicro) {
		return micros.containsKey(idMicro);
	}

}

package empresaMicros;

public class Fecha {
	
	private int dia;
	private int mes;
	private int anio;
	
	Fecha(int d, int m, int a){
		setDia(d); 
		setMes(m);
		setAnio(a);
	}

	private void setDia(int dia) { //SUPONEMOS QUE TODOS LOS MESES TIENEN 30 DIAS
		if(dia > 0 && dia < 31)
			this.dia = dia;
		else
			throw new RuntimeException("Los d�as son del 1 al 31");
	}

	private void setMes(int mes) {
		if(mes > 0 && mes < 13)
			this.mes = mes;
		else
			throw new RuntimeException("Los meses son de 1 a 12");
	}

	private void setAnio(int a�o) {
		if(a�o > 1900)
			this.anio = a�o;
		else
			throw new RuntimeException("Los a�os deben ser mayores a 1900");
	}
	
}

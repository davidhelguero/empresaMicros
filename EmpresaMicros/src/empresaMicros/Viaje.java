package empresaMicros;

public class Viaje {
	private Micro micro;
	private Fecha fecha;
	private String destino;
	private double costoPorAsiento;
		
	Viaje(Micro micro, Fecha fecha, String destino, double costoPorAsiento){
		this.micro = micro;
		this.fecha = fecha;
		setDestino(destino);
		setCostoPorAsiento(costoPorAsiento);
	}
	
	private void setCostoPorAsiento(double costoPorAsiento) {
		if(costoPorAsiento >= 0)
			this.costoPorAsiento = costoPorAsiento;
		else
			throw new RuntimeException("El costo por asiento debe ser mayor a 0");
	}

	private void setDestino(String destino) {
		if(!destino.isBlank())
			this.destino = destino;
		else
			throw new RuntimeException("El destino no puede estar vacío");
	}

	public Micro getMicro() {
		return micro;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public String getDestino() {
		return destino;
	}

	public double getCostoPorAsiento() {
		return costoPorAsiento;
	}
	
	
}

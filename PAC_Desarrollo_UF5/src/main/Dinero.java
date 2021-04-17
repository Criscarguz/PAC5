package main;

public abstract class Dinero {
	
															// CLASE ABSTRACTA DINERO // VARIABLES PROTEGIDAS DINERO //

	protected double dinero;
	protected String description;
	
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

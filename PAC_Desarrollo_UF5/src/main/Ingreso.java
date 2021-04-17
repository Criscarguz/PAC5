package main;

public class Ingreso extends Dinero {
	
																		// CLASE INGRESO //

	public Ingreso (double ingreso, String description) {
		this.dinero = ingreso;
		this.description = description;
				
	}

	@Override
	public String toString() {
		return "Cantidad=" + dinero + ", Concepto=" + description + "]";
	}
	
	
	
}

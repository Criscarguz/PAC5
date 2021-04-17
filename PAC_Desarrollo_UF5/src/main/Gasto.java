package main;

public class Gasto extends Dinero {

																	// CLASE GASTO //

	public Gasto(double gasto, String description) {
		
		this.dinero = gasto;
		this.description = description;
		
	}

	@Override
	public String toString() {
		return "Cantidad=" + dinero + ", Concepto=" + description + "]";
	}
		

}

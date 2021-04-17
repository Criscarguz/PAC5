package main;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
																// CLASE CUENTA // VARIABLES PRIVADAS //

	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;
	
	public Cuenta( Usuario usuario) {

		this.usuario = usuario;
		gastos = new ArrayList <Gasto>(); 
		ingresos = new ArrayList <Ingreso>();  
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public double addIngresos(String description, double cantidad) {
		
		Ingreso ingreso = new Ingreso(cantidad, description);
		ingresos.add(ingreso);
		setSaldo(getSaldo() + cantidad);
				
		return getSaldo();
	}
	public double addGastos(String description, double cantidad) {
		
		Gasto gasto = new Gasto(cantidad, description);
		gastos.add(gasto);
		setSaldo(getSaldo() - cantidad);
		
		return getSaldo();
	}
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", usuario=" + usuario + ", gastos=" + gastos + ", ingresos=" + ingresos
				+ "]";
	}
	
	
}

package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce el nombre del usuario: ");
		usuario.setNombre(s.next());
		System.out.println("Introduce la edad del usuario: ");
		usuario.setEdad(s.nextInt());
	
														//		CASO DEL DNI		 //
		
		boolean matchFound = false;

		while (!matchFound){
			System.out.println("Introduce el DNI del usuario: ");
			String dni = s.next();
			Pattern pattern = Pattern.compile("^\\d{8}-?[a-zA-Z]{1}$", Pattern.CASE_INSENSITIVE); //Control de excepciones
			Matcher matcher = pattern.matcher(dni); 
			matchFound = matcher.find(); // Línea que cambia a true el boolean si la expresión cumple.

			if(!matchFound) {			
				System.out.println("Introduce el DNI del usuario valido");
			} else {
				usuario.setDni(dni);
			}
		}
		
		System.out.println(usuario.toString());
		
		String descripcionEntrada;
		double cantidadEntrada;
		int eleccionMenu;
		Cuenta cuenta = new Cuenta(usuario);
		boolean salir = false;
	
		do {
																// 			MENÚ 	 	//
			System.out.println("Realiza una nueva acción:");
			System.out.println("1. Introduce un nuevo gasto");
			System.out.println("2. Introduce un nuevo ingreso");
			System.out.println("3. Mostrar gastos");
			System.out.println("4. Mostrar ingresos");
			System.out.println("5. Mostrar saldo");
			System.out.println("0. Salir del programa");
			eleccionMenu = s.nextInt();
			
			switch(eleccionMenu) {
				case 1:
												// 		CASO DE INTRODUCIR NUEVO GASTO		 //
					System.out.println("Introduce la descripción ");
					descripcionEntrada = s.next();
					System.out.println ("Introduce la cantidad ");
					cantidadEntrada = s.nextDouble();
					System.out.println ("Saldo actual: " + cuenta.addGastos( descripcionEntrada, cantidadEntrada) + "€" );

					break;
					
				case 2:
												// 		CASO INTRODUCIR NUEVO INGRESO 		//
					System.out.println("Introduce la descripción ");
					descripcionEntrada = s.next();
					System.out.println ("Introduce la cantidad ");
					cantidadEntrada = s.nextDouble();
					System.out.println ("Saldo actual: " + cuenta.addIngresos( descripcionEntrada, cantidadEntrada) + "€" );
					break;
					
				case 3:
													//		 CASO MOSTRAR GASTOS 		//
					List<Gasto> gastos = cuenta.getGastos();
					Iterator it = gastos.iterator();
					while (it.hasNext()) {
						Gasto g = (Gasto) it.next();
						System.out.println (g.toString());
					}
					break;
					
				case 4:
													// 		CASO MOSTRAR INGRESOS 		//
					List<Ingreso> ingresos = cuenta.getIngresos();
					Iterator it1 = ingresos.iterator();
					while (it1.hasNext()) {
						Ingreso i = (Ingreso) it1.next();
						System.out.println (i.toString());
					}
					break;
					
				case 5:
														//		CASO MOSTRAR SALDO 		//
					System.out.println ("Saldo actual: " + cuenta.getSaldo() +"€" );
					break;
					
				case 0:
											// 		OPCIÓN INCORRECTA DE LA APLICACIÓN		 //
					salir = true;
					break;
					default:
						System.out.println("Opción incorrecta.");
			}
			
		} while (!salir);
		
													// 		SALIDA DE LA APLICACIÓN 		//
		System.out.println("Fin del programa.\r\nGracias por utilizar la aplicación.");
	}

}

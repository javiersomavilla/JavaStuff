package problemas.p2;

import problemas.p2.exceptions.VehiculoYaExistente;
import problemas.p2.vehiculos.Camion;
import problemas.p2.vehiculos.Coche;
import problemas.p2.vehiculos.Furgoneta;
import problemas.p2.vehiculos.Microbus;

public class Main {

	private static TiendaAlquiler tienda;
	
	public static void main(String[] args) {
		creaTienda();
		
		try {
			addVehiculos();
		} catch (VehiculoYaExistente e) {
			System.out.println("Alguno de los vehiculos ya existe...");
			System.out.println(e.getMessage());
		}
		
		System.out.println(tienda.muestraTienda());
		
		System.out.println(tienda.calculaAlquiler(5));
	}
	
	private static void creaTienda() {
		tienda = new TiendaAlquiler();				
	}
	
	private static void addVehiculos() throws VehiculoYaExistente {
		addCoches();
		addMicrobuses();
		addFurgonetas();
		addCamiones();
	}
	
	private static void addCoches() throws VehiculoYaExistente {
		Coche c1 = new Coche("coche1", 1, 1);
		Coche c2 = new Coche("coche2", 2, 2);
		Coche c3 = new Coche("coche3", 3, 3);
		Coche c4 = new Coche("coche4", 4, 4);
		tienda.addVehiculo(c1);
		tienda.addVehiculo(c2);
		tienda.addVehiculo(c3);
		tienda.addVehiculo(c4);
	}
	
	private static void addMicrobuses() throws VehiculoYaExistente {
		Microbus m1 = new Microbus("microbus1", 1, 1);
		Microbus m2 = new Microbus("microbus2", 2, 2);
		Microbus m3 = new Microbus("microbus3", 3, 3);
		Microbus m4 = new Microbus("microbus4", 4, 4);
		tienda.addVehiculo(m1);
		tienda.addVehiculo(m2);
		tienda.addVehiculo(m3);
		tienda.addVehiculo(m4);
	}
	
	private static void addFurgonetas() throws VehiculoYaExistente {
		Furgoneta f1 = new Furgoneta("furgoneta1", 1, 1);
		Furgoneta f2 = new Furgoneta("furgoneta2", 2, 2);
		Furgoneta f3 = new Furgoneta("furgoneta3", 3, 3);
		Furgoneta f4 = new Furgoneta("furgoneta4", 4, 4);
		tienda.addVehiculo(f1);
		tienda.addVehiculo(f2);
		tienda.addVehiculo(f3);
		tienda.addVehiculo(f4);
	}
	
	private static void addCamiones() throws VehiculoYaExistente {
		Camion c1 = new Camion("camion1", 1, 1);
		Camion c2 = new Camion("camion2", 2, 2);
		Camion c3 = new Camion("camion3", 3, 3);
		Camion c4 = new Camion("camion4", 4, 4);
		tienda.addVehiculo(c1);
		tienda.addVehiculo(c2);
		tienda.addVehiculo(c3);
		tienda.addVehiculo(c4);
	}
}

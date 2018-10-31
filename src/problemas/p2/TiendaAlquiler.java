package problemas.p2;

import java.util.LinkedList;

import problemas.p2.exceptions.VehiculoNoEncontrado;
import problemas.p2.exceptions.VehiculoYaExistente;
import problemas.p2.vehiculos.*;

public class TiendaAlquiler {
	
	// ATTRIBUTES
	private LinkedList<Vehiculo> vehiculos;
	
	// CONSTRUCTOR
	public TiendaAlquiler() {
		this.vehiculos = new LinkedList<>();
	}
	
	// METHODS
	public void addVehiculo(Vehiculo v) throws VehiculoYaExistente{
		try {
			buscaVehiculoPorMatricular(v.getMatricula());
			throw new VehiculoNoEncontrado(v.getMatricula());
		} catch (VehiculoNoEncontrado e) {
			this.vehiculos.add(v);
		}
	}
	
	public Vehiculo buscaVehiculoPorMatricular(String matricula) throws VehiculoNoEncontrado{
		Vehiculo v = null;
		
		boolean encontrado = false;
		for(int i=0; i<vehiculos.size() && !encontrado; i++) {
			if(vehiculos.get(i).getMatricula().equalsIgnoreCase(matricula)) {
				encontrado = true;
				v = vehiculos.get(i);
			}
		}
		
		if(!encontrado) {
			throw new VehiculoNoEncontrado(matricula);
		}else {
			return v;
		}
	}
	
	public double obtenerPrecioAlquiler(String matricula) throws VehiculoNoEncontrado{
		Vehiculo v = buscaVehiculoPorMatricular(matricula);
		if(v != null) {
			return v.precioAlquiler();
		}else {
			throw new VehiculoNoEncontrado(matricula);
		}
	}
	
	public String calculaAlquiler(int nDias) {
		String str = "-------------------------------------------\n";
		str += "-- ALQUILER DE VEHICULOS PARA "+nDias+" dia(s)\n";		
		str += "-------------------------------------------\n";
		
		for(Vehiculo v: vehiculos) {
			str+="MATRICULA: " + v.getMatricula()+"\tPRECIO: "+v.calculaAlquiler(nDias)+"\n";
		}
		
		return str;
	}
	
	public String muestraTienda() {
		String str = "------------------------------------------------------------------------------------------\n";
		str += "-- TIENDA\n";		
		str += "------------------------------------------------------------------------------------------\n";
		
		for(Vehiculo v: vehiculos) {
			str += v.toString()+"\n";
		}
		
		return str;
	}
}

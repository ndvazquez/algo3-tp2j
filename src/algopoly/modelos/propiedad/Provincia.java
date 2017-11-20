package algopoly.modelos.propiedad;

import java.util.ArrayList;
import java.util.Arrays;

public enum Provincia {
	// nombre (precio,[Casa,Hotel],[alqSim,alq1Casa,alq2Casa,Hotel])
	
	BSAS_SUR (20000, new Integer[]{0, 5000, 5000,8000}, new Integer[]{2000,3000,3500,5000}),
	
	BSAS_NORTE (25000, new Integer[]{0, 5500, 5500,9000}, new Integer[]{2500,3500,4000,6000}),
	
	CORDOBA_SUR (18000, new Integer[]{0, 2000, 2000,3000}, new Integer[]{1000,1500,2500,3000}),
	
	CORDOBA_NORTE (20000, new Integer[]{0, 2200, 2200,3500}, new Integer[]{1300,1800,2900,3500}),
	
	SANTA_FE (15000, new Integer[]{0, 4000}, new Integer[]{1500,3500}),
	
	SALTA_SUR (23000, new Integer[]{0, 4500, 4500,7500}, new Integer[]{2000,3250,3850,5500}),
	
	SALTA_NORTE (23000, new Integer[]{0, 4500, 4500,7500}, new Integer[]{2000,3250,3850,5500}),
	
	NEUQUEN (17000, new Integer[]{0, 4800}, new Integer[]{1800,3800}),
	
	TUCUMAN (25000, new Integer[]{0, 7000}, new Integer[]{2500,4500});
	
	private final Integer precio;
	private final ArrayList<Edificio> edificios;
	
	Provincia(Integer precio, Integer[] precioEdificio, Integer[] alquiler) {
		this.precio = precio;
		int len = precioEdificio.length;
		this.edificios = new ArrayList<>();
		
		for (int i = 0; i < len; i++) {
			if ( i == 0 ) {
				Vacio vacio = new Vacio(precioEdificio[i], alquiler[i]);
				edificios.add(vacio);
			}
			else if ( i == 1 ) {
				Casa casa1 = new Casa(precioEdificio[i], alquiler[i]);
				edificios.add(casa1);
			}
			else if ( i == 2 ) {
				Casa casa2 = new Casa(precioEdificio[i], alquiler[i]);
				edificios.add(casa2);
			}
			else if ( i == 3 ) {
				Hotel hotel = new Hotel(precioEdificio[i], alquiler[i]);
				edificios.add(hotel);
			}
		}
	}
	
	public Integer precio() {
		return precio;
	}
	
	public ArrayList<Edificio> getEdificios() {
		return this.edificios;
	}
}
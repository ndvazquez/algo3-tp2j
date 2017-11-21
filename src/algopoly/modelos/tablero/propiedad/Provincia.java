package algopoly.modelos.tablero.propiedad;

import java.util.ArrayList;

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
		this.edificios = new ArrayList<>();
	
		this.edificios.add( new Vacio(precioEdificio[0], alquiler[0]) );
		this.edificios.add( new Casa(precioEdificio[1], alquiler[1]) );
		if ( alquiler.length > 2) {
			this.edificios.add( new Casa(precioEdificio[2], alquiler[2]) );
			this.edificios.add( new Hotel(precioEdificio[3], alquiler[3]) );
		}
	}

	public Integer precio() {
		return precio;
	}

	public Edificio vacio() {
		return this.edificios.get(0);
	}

	public Edificio hotel() {
		return this.edificios().get(3);
	}
	
	public ArrayList<Edificio> edificios()  {
		return this.edificios;
	}
	
}
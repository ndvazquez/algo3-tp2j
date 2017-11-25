package algopoly.modelos.tablero.barrios;

import java.util.ArrayList;

public enum Provincia {
	// nombre (precio,[Casa,Hotel],[alqSim,alq1Casa,alq2Casa,Hotel])
	
	BSAS_SUR (20000, new Vacio(0,2000), new Casa(5000, 3000), new Casa(5000, 3500), new Hotel(8000,5000)),
	
	BSAS_NORTE (25000, new Vacio(0, 2500), new Casa(5500, 3500), new Casa(5500, 4000), new Hotel(9000,6000)),
	
	CORDOBA_SUR (18000, new Vacio(0, 1000), new Casa(2000, 1500), new Casa(2000, 2500), new Hotel(3000,3000)),
	
	CORDOBA_NORTE (20000, new Vacio(0, 1300), new Casa(2200, 1800), new Casa(2200, 2900), new Hotel(3500,3500)),
	
	SANTA_FE (15000, new Vacio(0, 1500), new Casa(4000, 3500), null, null),
	
	SALTA_SUR (23000, new Vacio(0, 2000), new Casa(4500, 3250), new Casa(4500, 3850), new Hotel(7500,5500)),
	
	SALTA_NORTE (23000, new Vacio(0,  2000), new Casa(4500, 3250), new Casa(4500, 3850), new Hotel(7500,5500)),
	
	NEUQUEN (17000, new Vacio(0, 1800), new Casa(4800, 3800), null, null),
	
	TUCUMAN (25000, new Vacio(0, 2500), new Casa(7000, 4500), null, null);
	
	private final Integer precio;
	
	private final ArrayList<Inmueble> edificios;
	
	Provincia(Integer precio, Inmueble vacio, Inmueble casa1, Inmueble casa2, Inmueble hotel) {
		this.precio = precio;
		this.edificios = new ArrayList<>();
	
		this.edificios.add( vacio );
		this.edificios.add( casa1 );
		if ( casa2 != null ) {
			this.edificios.add( casa2 );
			this.edificios.add( hotel );
		}
	}

	public Integer precio() {
		return this.precio;
	}

	public Inmueble vacio() {
		return this.edificios.get(0);
	}

	public Inmueble hotel() {
		return this.edificios().get(3);
	}
	
	public ArrayList<Inmueble> edificios()  {
		return this.edificios;
	}
	
}
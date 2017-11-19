package algopoly.modelos.propiedad;

import java.util.ArrayList;
import java.util.Arrays;

public enum Provincia {
	// nombre (precio,[Casa,Hotel],[alqSim,alq1Casa,alq2Casa,Hotel])
	
	BSAS_SUR (20000, new Integer[]{5000,8000}, new Integer[]{2000,3000,3500,5000}),
	
	BSAS_NORTE (25000, new Integer[]{5500,9000}, new Integer[]{2500,3500,4000,6000}),
	
	CORDOBA_SUR (18000, new Integer[]{2000,3000}, new Integer[]{1000,1500,2500,3000}),
	
	CORDOBA_NORTE (20000, new Integer[]{2200,3500}, new Integer[]{1300,1800,2900,3500}),
	
	SANTA_FE (15000, new Integer[]{4000}, new Integer[]{1500,3500}),
	
	SALTA_SUR (23000, new Integer[]{4500,7500}, new Integer[]{2000,3250,3850,5500}),
	
	SALTA_NORTE (23000, new Integer[]{4500,7500}, new Integer[]{2000,3250,3850,5500}),
	
	NEUQUEN (17000, new Integer[]{4800}, new Integer[]{1800,3800}),
	
	TUCUMAN (25000, new Integer[]{7000}, new Integer[]{2500,4500});
	
	private final Integer precio;
	private final ArrayList<Integer> construccion;
	private final ArrayList<Integer> alquiler;
	
	Provincia(Integer precio, Integer[] construccion, Integer[] alquiler) {
		this.precio = precio;
		this.construccion = new ArrayList<>(Arrays.asList(construccion));
		this.alquiler = new ArrayList<>(Arrays.asList(alquiler));
	}
	
	public Integer precio() {
		return precio;
	}
	
	public ArrayList<Integer> construcciones() {
		return this.construccion;
	}
	
	public ArrayList<Integer> alquileres() {
		return this.alquiler;
	}
	
	Integer precioConstruccion(Integer tipoConstruccion) {
		return this.construccion.get(tipoConstruccion);
	}
	
	Integer alquiler(Integer tipoConstruccion) {
		return this.alquiler.get(tipoConstruccion);
	}
}

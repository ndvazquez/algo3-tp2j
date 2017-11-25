package algopoly.modelos.tablero.casilleros.compania;

import algopoly.modelos.tablero.casilleros.Casillero;

public class Subte extends Compania implements Casillero {
	
	private static final Integer PRECIO_SUBTE = 40000;
	private static final Integer IMP_SUBTE = 600;
	private static final Integer IMP_SUBTE_DOBLE = 1100;

	public Subte() {
		this.precio = PRECIO_SUBTE;
		this.impuesto = IMP_SUBTE;
		this.impuestoDoble = IMP_SUBTE_DOBLE;
		this.estado = new SinPropietario();
	}

	@Override
	public String getNombre() {
		return "SUBTE";
	}
}

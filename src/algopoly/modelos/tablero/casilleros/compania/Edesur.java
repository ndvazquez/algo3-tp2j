package algopoly.modelos.tablero.casilleros.compania;

import algopoly.modelos.tablero.casilleros.Casillero;

public class Edesur extends Compania implements Casillero {

	private static final Integer PRECIO_EDESUR = 35000;
	private static final Integer IMP_EDESUR = 500;
	private static final Integer IMP_EDESUR_DOBLE = 1000;

	public Edesur() {
		this.precio = PRECIO_EDESUR;
		this.impuesto = IMP_EDESUR;
		this.impuestoDoble = IMP_EDESUR_DOBLE;
		this.estado = new SinPropietario();
	}

	@Override
	public String getNombre() {
		return "EDESUR";
	}
}

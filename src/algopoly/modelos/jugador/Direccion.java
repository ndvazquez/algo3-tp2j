package algopoly.modelos.jugador;

import java.util.ArrayList;

public class Direccion {

	@Override
	public boolean equals(Object obj) {
		Direccion other = (Direccion) obj;
		if (valueX != other.valueX)
			return false;
		if (valueY != other.valueY)
			return false;
		return true;
	}

	private static Direccion norte;
	private static Direccion sur;
	private static Direccion este;
	private static Direccion oeste;

	private int valueX;
	private int valueY;

	static {
		norte = new Direccion(0, 1);
		sur = new Direccion(0, -1);
		este = new Direccion(1, 0);
		oeste = new Direccion(-1, 0);
	}

	private Direccion(int valX, int valY) {
		this.valueX = valX;
		this.valueY = valY;
	}

	public static Direccion norte() {
		return norte;
	}

	public static Direccion sur() {
		return sur;
	}

	public static Direccion este() {
		return este;
	}

	public static Direccion oeste() {
		return oeste;
	}
	
	private static ArrayList<Direccion> direcciones;
	static {
		direcciones = new ArrayList<Direccion>();
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.norte());
		direcciones.add(Direccion.norte());
		direcciones.add(Direccion.norte());
		direcciones.add(Direccion.norte());
		direcciones.add(Direccion.norte());
	}
	

	public static Direccion getDireccion(Integer indice) {
		return direcciones.get(indice);
	}

}

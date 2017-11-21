package algopoly.modelos.jugador;

import java.util.ArrayList;

public class Posicion {

	public static final Posicion SALIDA = new Posicion(200, 200);
	public static final Posicion QUINI6 = new Posicion(100, 200); 
	public static final Posicion BSAS_SUR = new Posicion(30, 200); 
	public static final Posicion EDESUR = new Posicion(-40, 200); 
	public static final Posicion BSAS_NORTE = new Posicion(-100, 200); 
	public static final Posicion CARCEL = new Posicion(-200, 200);
	public static final Posicion CORDOBA_SUR = new Posicion(-200, 100); 
	public static final Posicion AVANCE_DINAMICO = new Posicion(-200, 30); 
	public static final Posicion SUBTE = new Posicion(-200, -40); 
	public static final Posicion CORDOBA_NORTE = new Posicion(-200, -100); 
	public static final Posicion IMPUESTO_DE_LUJO = new Posicion(-200, -200);
	public static final Posicion SANTA_FE = new Posicion(-100, -200); 
	public static final Posicion AYSA = new Posicion(-40, -200); 
	public static final Posicion SALTA_NORTE = new Posicion(30, -200); 
	public static final Posicion SALTA_SUR = new Posicion(100, -200); 
	public static final Posicion POLICIA = new Posicion(200, -200); 
	public static final Posicion TREN = new Posicion(200, -100); 
	public static final Posicion NEUQUEN = new Posicion(200, -40); 
	public static final Posicion RETROCESO_DINAMICO = new Posicion(200, 30); 
	public static final Posicion TUCUMAN = new Posicion(200, 100); 

	private int x;
	private int y;

	public Posicion(int posX, int posY) {
		this.x = posX;
		this.y = posY;
	}

	public int getX() { return x; }

	public int getY() { return y; }

	public static Integer cantidadPosiciones() {
		return posiciones.size();
	}

	public static Posicion getPosicionSiguiente(Posicion actual) {
		return posiciones.get((posiciones.lastIndexOf(actual) + 1) % posiciones.size());
	}

	public static Posicion getPosicionAnterior(Posicion actual) {
		return posiciones.get(Math.floorMod((posiciones.lastIndexOf(actual) - 1), posiciones.size()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public static Integer cantidadCasillerosEntre(Posicion pos1, Posicion pos2) {
		int position1 = posiciones.lastIndexOf(pos1);
		int position2 = posiciones.lastIndexOf(pos2);
		if (position1 <= position2)
			return position2 - position1;
		return posiciones.size() - (position2 - position1);
	}

	private static ArrayList<Posicion> posiciones;
	static {
		posiciones = new ArrayList<Posicion>();
		posiciones.add(SALIDA);
		posiciones.add(QUINI6);
		posiciones.add(BSAS_SUR);
		posiciones.add(EDESUR);
		posiciones.add(BSAS_NORTE);
		posiciones.add(CARCEL); 
		posiciones.add(CORDOBA_SUR);
		posiciones.add(AVANCE_DINAMICO);
		posiciones.add(SUBTE);
		posiciones.add(CORDOBA_NORTE);
		posiciones.add(IMPUESTO_DE_LUJO);
		posiciones.add(SANTA_FE);
		posiciones.add(AYSA);
		posiciones.add(SALTA_NORTE);
		posiciones.add(SALTA_SUR);
		posiciones.add(POLICIA);
		posiciones.add(TREN);
		posiciones.add(NEUQUEN);
		posiciones.add(RETROCESO_DINAMICO);
		posiciones.add(TUCUMAN);
	}

}

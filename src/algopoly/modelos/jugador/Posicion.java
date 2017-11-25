package algopoly.modelos.jugador;

public class Posicion {

	private int x;
	private int y;

	public Posicion(int posX, int posY) {
		this.x = posX;
		this.y = posY;
	}

	public int getX() { 
		return this.x; 
	}

	public int getY() { 
		return this.y; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Posicion other = (Posicion) obj;
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		return true;
	}

}


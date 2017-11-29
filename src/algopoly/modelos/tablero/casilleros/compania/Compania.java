package algopoly.modelos.tablero.casilleros.compania;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.Casillero;

public abstract class Compania implements Casillero {

	protected Integer precio;
	protected Jugador propietario;
	protected Integer impuesto;
	protected Integer impuestoDoble;
	protected Estado estado;
	protected Compania companiaPar;

	@Override
	public void recibirJugador(Jugador jugador) {
		jugador.setMensajes(String.format("\tCayó en el casillero %s.\n", this.getNombre()));

		this.estado.recibirJugador(jugador, this);
	}

	public boolean soyTuDuenio(Jugador jugador) {
		return jugador.equals(this.propietario);
	}

	public void setSinPropietario(){
		this.propietario = null;
		this.estado = new SinPropietario();
	}

	public void setPropietario(Jugador jugador) {
		this.propietario = jugador;
		this.estado = new ConPropietario();
	}

	public void setCompaniaPar(Compania compania) {
		this.companiaPar = compania;
	}
	
	public Integer getPrecio() {
		return this.precio;
	}

	public static boolean tienenMismoDuenio(Compania compania1, Compania compania2) {
		if (compania1 == null || compania2 == null) {
			return false;
		}
		return compania1.propietario.equals(compania1.propietario);
	}

	public abstract String getNombre();

}

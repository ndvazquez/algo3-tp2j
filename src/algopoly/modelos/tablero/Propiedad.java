package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public abstract class Propiedad implements Casillero {
	
	private Jugador propietario;

	private Integer precio;

	public Propiedad(Integer precio){
		this.precio = precio;
	}

	public void recibirJugador(Jugador jugador) {
		jugador.comprarPropiedad(this);
		this.propietario = jugador;
	}
	
	public Jugador getPropietario() {
		return this.propietario;
	}

	public Integer getPrecio(){
		return this.precio;
	}
}

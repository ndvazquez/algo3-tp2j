package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public class PropiedadSimple implements Casillero, Propiedad {
	
	private Jugador propietario;

	private Integer precio;

	public PropiedadSimple(Integer precio){
		this.precio = precio;
	}

	@Override
	public void recibirJugador(Jugador jugador) {
		jugador.comprarPropiedad(this);
		this.propietario = jugador;
	}

	@Override
	public Jugador getPropietario() {
		return this.propietario;
	}

	@Override
	public Integer getPrecio(){
		return this.precio;
	}


}

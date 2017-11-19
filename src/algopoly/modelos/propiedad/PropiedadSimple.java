package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class PropiedadSimple implements Casillero, Propiedad {
	
	private Jugador propietario;

	private Integer precio;
	
	private Integer precioCasa;
	
	private EstadoPropiedad estado;

	private Integer alquiler;

	public PropiedadSimple(Integer precio, Integer precioCasa){
		this.precio = precio;
		this.precioCasa = precioCasa;
		this.estado = new SinPropietario();
	}

	@Override
	public void recibirJugador(Jugador jugador) {
		if ( this.estado.tienePropietario() ) {
    		jugador.pagarAlquiler(this.getPropietario(), this);
    	} else {
    		jugador.comprarPropiedad(this);
            this.propietario = jugador;
            this.estado = new ConPropietario();
    	}
	}

	@Override
	public Jugador getPropietario() {
		return this.propietario;
	}

	@Override
	public Integer getPrecio(){
		return this.precio;
	}

	@Override
	public Integer getPrecioCasa() {
		return this.precioCasa;
	}

	@Override
	public Integer getPrecioAlquiler() {
		return this.alquiler;
	}
	
	public boolean construir() {
		
		// verificar jugador puede comprar
		if (this.estado.puedeConstruir()) {
			this.propietario.comprarCasa(this);
			return true;
		}
		return false;
	}
}
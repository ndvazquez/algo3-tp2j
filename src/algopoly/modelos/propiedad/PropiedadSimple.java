package algopoly.modelos.propiedad;

import java.util.ArrayList;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class PropiedadSimple implements Casillero, Propiedad {
	
	private Jugador propietario;

	private Integer precio;
	
	private EstadoPropiedad estado;
	
	private Integer cantidadEdificios;
	
	private ArrayList<Edificio> edificios;

	public PropiedadSimple(Integer precio, ArrayList<Edificio> edificios) {
		this.precio = precio;
		this.estado = new SinPropietario();
		this.edificios = edificios;
		this.cantidadEdificios = 0;
	}

	public PropiedadSimple(Integer precio, Integer precioCasa){
		this.precio = precio;
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
	public Integer getPrecioEdificio() {
		Edificio edificio = this.edificios.get(this.cantidadEdificios + 1);
		return edificio.getPrecio();
	}

	@Override
	public Integer getPrecioAlquiler() {
		Edificio edificio = this.edificios.get(this.cantidadEdificios);
		return edificio.getAlquiler();
	}
	
	public void construir() {
		
		if (this.cantidadEdificios < 1) {
			Integer precio = this.getPrecioEdificio();
			if ( this.propietario.comprar(precio) )
				this.cantidadEdificios += 1;
		}
	}
}
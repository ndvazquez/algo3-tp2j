package algopoly.modelos.propiedad;

import java.util.ArrayList;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class PropiedadSimple implements Casillero, Propiedad {
	
	private Jugador propietario;

	private Integer precio;
	
	private Integer precioCasa;
	
	private EstadoPropiedad estado;
	
	private Integer cantidadEdificios;

	private ArrayList<Integer> alquiler;

	public PropiedadSimple(Integer precio, ArrayList<Integer> construcciones, ArrayList<Integer> alquileres) {
		this.precio = precio;
		this.precioCasa = construcciones.get(0);
		this.alquiler = alquileres;
		this.estado = new SinPropietario();
		this.cantidadEdificios = 0;
	}

	public PropiedadSimple(Integer precio, Integer precioCasa){
		this.precio = precio;
		this.precioCasa = precioCasa;
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
		return this.alquiler.get(this.cantidadEdificios);
	}
	
	public void construir() {
		
		if (this.cantidadEdificios < 1) {
			if ( this.propietario.puedeComprar(this.getPrecioCasa())) { 
				this.propietario.comprar(this.getPrecioCasa());
				this.cantidadEdificios = 1;
			}
		}
	}
}
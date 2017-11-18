package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public class PropiedadSimple implements Casillero, Propiedad {
	
	private Jugador propietario;

	private Integer precio;
	
	private Integer precioCasa;
	
	private Integer precioHotel;
	
	private Construccion construccion;

	public PropiedadSimple(Integer precio, Integer precioCasa, Integer precioHotel){
		this.precio = precio;
		this.precioCasa = precioCasa;
		this.precioHotel = precioHotel;
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

	@Override
	public Integer getPrecioCasa() {
		return this.precioCasa;
	}

	@Override
	public Integer getPrecioHotel() {
		return this.precioHotel;
	}

	@Override
	public void construir() {
		this.construccion = new Casa();
	}

	@Override
	public Integer getPrecioAlquiler() {
		return Cte.BSAS_SUR_ALQUILER_1CASA;
	}


}

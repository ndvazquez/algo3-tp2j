package algopoly.modelos.tablero;

import java.util.HashMap;

import algopoly.modelos.excepciones.PropiedadSinJugadorError;
import algopoly.modelos.jugador.Jugador;

public class PropiedadRegional implements Casillero, Propiedad {

    private Jugador propietario;

    private Integer precio;

    private Region region;
    
    private Integer precioCasa;
    
    private Integer precioHotel;
    
    private Construccion construccion;

    public PropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
        this.precio = precio;
        this.region = region;
        this.precioCasa = precioCasa;
        this.precioHotel = precioHotel;
    }
    
    @Override
    public void recibirJugador(Jugador jugador) {
    	Jugador jugadorPrueba;
    	try {
    		// Si ya fue comprada
    		jugadorPrueba = this.getPropietario();
    		if ( jugadorPrueba == null ) {
    			throw new PropiedadSinJugadorError();
    		}
    		jugador.pagarAlquiler(jugadorPrueba, this);
    	} 
    	catch (PropiedadSinJugadorError excep) {
    		// Si no fue comprada
    		jugador.comprarPropiedad(this);
            this.propietario = jugador;
            this.construccion = new NoConstruccion();
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
    public Integer getPrecioHotel() {
    	return this.precioHotel;
    }
    
    @Override 
    public Integer getPrecioAlquiler() {
    	// obtener alquiler segun construccion
    	return Cte.BSAS_SUR_ALQUILER_SIMPLE;
    }
    
    @Override
    public void construir() {
    	this.construccion = new Casa();
    }
}
package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class PropiedadRegional implements Casillero, Propiedad {

    private Jugador propietario;
    private Region region;
    private Integer precio;
    private Integer precioCasa;
    private Integer precioHotel;
    private EstadoPropiedad estado;

    public PropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
    	this.precio = precio;
        this.region = region;
        this.precioCasa = precioCasa;
        this.precioHotel = precioHotel;
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
 
    public Integer getPrecioHotel() {
    	return this.precioHotel;
    }
    
    @Override 
    public Integer getPrecioAlquiler() {
    	// obtener alquiler segun construccion
    	return 0;
    }

	@Override
	public void construir() {
	}
}

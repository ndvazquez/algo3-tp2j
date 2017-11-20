package algopoly.modelos.propiedad;

import java.util.ArrayList;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class PropiedadRegional implements Casillero, Propiedad {

    private Jugador propietario;
    
    private Region region;
    
    private Integer precio;
    
    private Integer precioCasa;
    
    private Integer precioHotel;
    
    private EstadoPropiedad estado;

	private ArrayList<Edificio> edificios;
	
	private Integer cantidadEdificios;

    public PropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
    	this.precio = precio;
        this.region = region;
        this.precioCasa = precioCasa;
        this.precioHotel = precioHotel;
        this.estado = new SinPropietario();
    }
    
    public PropiedadRegional(Integer precio, Region region, ArrayList<Edificio> edificios){
    	this.precio = precio;
        this.region = region;
        this.edificios = edificios;
        this.estado = new SinPropietario();
        this.cantidadEdificios = 0;
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

	@Override
	public void construir() {
		
		// if region
		// if 2 casas --> hotel else no puede construir hotel
		// if puede comprar
		// no mas de 2 casas o 1 hotel
	}
}

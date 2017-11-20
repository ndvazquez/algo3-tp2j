package algopoly.modelos.propiedad;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class PropiedadRegional implements Casillero, Propiedad {

    private Jugador propietario;
    
    private Provincia provinciaComplemento;
    
    private EstadoPropiedad estado;

    private Edificio edificio;
	
	private Integer cantidadEdificios;

	private Provincia provincia;
	
    public PropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
        this.estado = new SinPropietario(this);
    }

    public PropiedadRegional(Provincia provincia, Provincia provinciaComplemento){
    	this.provincia = provincia;
    	this.provinciaComplemento = provinciaComplemento;
        this.estado = new SinPropietario(this);
        this.cantidadEdificios = 0;
    }

    @Override
    public void recibirJugador(Jugador jugador) {

    	this.estado.comprarPropiedad(jugador);
		
		this.estado.pagarAlquiler(jugador);
    }

    @Override
    public Jugador getPropietario() {
        return this.propietario;
    }

    @Override
    public Integer getPrecio(){
        return this.provincia.precio();
    }

    @Override
    public Integer getPrecioEdificio() {
    	return this.edificio.getPrecio();
    }

    @Override 
    public Integer getPrecioAlquiler() {
    	return this.edificio.getAlquiler();
    }

	@Override
	public void construir() {
		
		// if region
		// if 2 casas --> hotel else no puede construir hotel
		// if puede comprar
		// no mas de 2 casas o 1 hotel
	}

	@Override
	public void setPropietario(Jugador jugador) {
		this.propietario = jugador;
		this.estado = new ConPropietario(this);
		this.edificio = this.provincia.vacio();
	}
}

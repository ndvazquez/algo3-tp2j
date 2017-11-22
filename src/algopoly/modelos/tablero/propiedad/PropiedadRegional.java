package algopoly.modelos.tablero.propiedad;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Casillero;

public class PropiedadRegional implements Casillero, Propiedad {

    private Jugador propietario;
    
    private Provincia provinciaComplemento;
    
    private EstadoPropiedad estado;

    private Edificio edificio;
	
	private Integer cantidadEdificios;

	private Provincia provincia;

    public PropiedadRegional(Provincia provincia, Provincia provinciaComplemento){
    	this.provincia = provincia;
    	this.provinciaComplemento = provinciaComplemento;
        this.estado = new SinPropietario();
        this.cantidadEdificios = 0;
    }

    @Override
    public void recibirJugador(Jugador jugador) {

    	this.estado.comprarPropiedad(jugador, this);
		
		this.estado.pagarAlquiler(jugador, this);
    }

    @Override
    public Jugador getPropietario() {
        return this.propietario;
    }
    
    @Override
	public void setPropietario(Jugador jugador) {
		this.estado = new ConPropietario();
		this.edificio = this.provincia.vacio();
		this.propietario = jugador;
	}

    @Override
    public Integer getPrecio(){
        return this.provincia.precio();
    }

    @Override 
    public Integer getPrecioAlquiler() {
    	return this.edificio.getAlquiler();
    }
    
    @Override
    public Provincia getProvincia() {
    	return this.provincia;
    }

    @Override
	public boolean esEstaProvincia(Provincia estaProvincia) {
    	return this.provincia.name().equals(estaProvincia.name());
    }
    
    @Override
	public void construir(Edificio edificio) {
    	this.edificio = edificio;
		this.cantidadEdificios += 1;
    }
    
    public boolean estaCompleta() {
    	return this.propietario.getPropiedad(this.provinciaComplemento) != null;
    }

	@Override
	public void construirCasa() {
		
		if ( this.estaCompleta() && this.cantidadEdificios < 2) {
			this.estado = new RegionCompleta();
			this.estado.construirCasa(this);
		}
	}
	
	@Override
	public void construirHotel() {
		
		Propiedad propiedadComplemento = this.propietario.getPropiedad(this.provinciaComplemento);
		
		if ( this.estaCompleta() && this.cantidadEdificios == 2 && propiedadComplemento.cantidadEdificios() == 2 ) {
			this.estado.construirHotel(this);
		}
	}

	@Override
	public Integer cantidadEdificios() {
		return this.cantidadEdificios;
	}
}

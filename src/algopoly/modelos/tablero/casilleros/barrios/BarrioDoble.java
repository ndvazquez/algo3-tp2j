package algopoly.modelos.tablero.casilleros.barrios;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.Casillero;

public class BarrioDoble implements Casillero, Barrio {

    private Jugador propietario;
    
    private Provincia provinciaComplemento;
    
    private EstadoBarrio estado;

    private Inmueble edificio;
	
	private Integer cantidadEdificios;

	private Provincia provincia;

    public BarrioDoble(Provincia provincia, Provincia provinciaComplemento){
    	this.provincia = provincia;
    	this.provinciaComplemento = provinciaComplemento;
        this.estado = new SinPropietario();
        this.cantidadEdificios = 0;
    }

	@Override
	public String getNombre(){
		return this.provincia.name();
	}

    @Override
    public void recibirJugador(Jugador jugador) {
		jugador.setMensajes(String.format("\tCayó en el casillero %s.\n", this.provincia.name()));
		this.estado.pagarAlquiler(jugador, this);
    }

    @Override
    public void comprarBarrio(Jugador jugador) {
    	this.estado.comprarBarrio(jugador, this);
    }
    
    @Override
    public Jugador getPropietario() {
        return this.propietario;
    }

	@Override
	public void setSinPropietario(){
		this.propietario = null;
		this.estado = new SinPropietario();
		this.edificio = this.provincia.vacio();
		this.cantidadEdificios = 0;
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
	public Integer getPrecioDeVenta(){
		return (this.edificio.getPrecio() + this.getPrecio());
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
	public void construir(Inmueble edificio) {
    	this.edificio = edificio;
		this.cantidadEdificios += 1;
    }
    
    public boolean estaCompleta() {
    	return this.propietario.getBarrio(this.provinciaComplemento) != null;
    }

	@Override
	public boolean construirCasa() {
		
		if ( this.estaCompleta() && this.cantidadEdificios < 2) {
			this.estado = new BarrioCompleto();
			this.estado.construirCasa(this);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean construirHotel() {
		
		Barrio barrioComplemento = this.propietario.getBarrio(this.provinciaComplemento);
		
		if ( this.cantidadEdificios == 2 && barrioComplemento.cantidadEdificios() == 2 ) {
			this.estado.construirHotel(this);
			return true;
		}
		return false;
	}

	@Override
	public Integer cantidadEdificios() {
		return this.cantidadEdificios;
	}
	
	@Override
	public Inmueble getInmuebleActual() {
		return this.edificio;
	}

	@Override
	public void resetBarrio() {
		this.cantidadEdificios = 0;
		this.edificio = this.provincia.vacio();
	}


}

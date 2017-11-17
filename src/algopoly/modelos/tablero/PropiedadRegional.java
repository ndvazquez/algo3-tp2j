package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public class PropiedadRegional implements Casillero, Propiedad {

    private Jugador propietario;

    private Integer precio;

    private Region region;

    public PropiedadRegional(Integer precio, Region region){
        this.precio = precio;
        this.region = region;
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
}

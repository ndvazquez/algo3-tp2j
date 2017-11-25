package algopoly.modelos.tablero.casilleros;

import algopoly.modelos.jugador.Jugador;

public class Ticket {

    private Integer premio;

    public Ticket(Integer valor){
        this.premio = valor;
    }

    public void darPremioAJugador(Jugador jugador){
        jugador.cobrar(this.premio);
    }
}

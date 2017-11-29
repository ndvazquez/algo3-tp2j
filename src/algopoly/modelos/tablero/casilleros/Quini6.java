package algopoly.modelos.tablero.casilleros;

import algopoly.modelos.jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Quini6 implements Casillero {

    private static final String NOMBRE = "QUINI6";

    private HashMap<Jugador, Queue<Ticket>> premios;
    
    private Ticket ticketNoPremio;

    public Quini6(ArrayList<Jugador> jugadores) {
        this.premios = new HashMap<>();

        this.ticketNoPremio = new Ticket(0);

        for (Jugador jugador: jugadores) {
            Queue<Ticket> tickets = new LinkedList<>();
            Ticket ticketPrimerPremio = new Ticket(50000);
            Ticket ticketSegundoPremio = new Ticket(30000);

            tickets.add(ticketPrimerPremio);
            tickets.add(ticketSegundoPremio);

            this.premios.put(jugador, tickets);
        }
    }

    @Override
    public String getNombre(){
        return NOMBRE;
    }

    private void premiarJugador(Jugador jugador){
        Ticket ticket = this.premios.get(jugador).remove();

        ticket.darPremioAJugador(jugador);

        this.premios.get(jugador).add(this.ticketNoPremio);
    }

    @Override
    public void recibirJugador(Jugador jugador){
        jugador.setMensajes(String.format("\tCayó en el casillero %s.\n", NOMBRE));
        this.premiarJugador(jugador);
    }

}

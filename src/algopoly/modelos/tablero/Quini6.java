package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Quini6 implements Casillero {

    private HashMap<Jugador, Queue<Ticket>> jugadores;
    private Ticket ticketNoPremio;

    public Quini6() {
        this.jugadores = new HashMap<>();
        this.ticketNoPremio = new Ticket(0);
    }

    @Override
    public void recibirJugador(Jugador jugador){
        if(!jugadores.containsKey(jugador)) {
            Queue<Ticket> tickets = new LinkedList<>();
            Ticket ticketPrimerPremio = new Ticket(50000);
            Ticket ticketSegundoPremio = new Ticket(30000);

            tickets.add(ticketPrimerPremio);
            tickets.add(ticketSegundoPremio);

            jugadores.put(jugador, tickets);
        }
        int premio = jugadores.get(jugador).remove().getPremio();
        jugadores.get(jugador).add(ticketNoPremio);

        jugador.incrementarCapital(premio);
    }

}

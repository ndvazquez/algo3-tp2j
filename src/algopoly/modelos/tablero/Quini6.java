package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Quini6 implements Casillero {

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

            premios.put(jugador, tickets);
        }
    }

    @Override
    public void recibirJugador(Jugador jugador){
        int premio = premios.get(jugador).remove().getPremio();

        premios.get(jugador).add(ticketNoPremio);

        jugador.cobrar(premio);
    }

}

package algopoly.controladores;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.jugador.Jugador;
import algopoly.vistas.VistaConsola;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algopoly.modelos.tablero.Tablero;
import algopoly.vistas.VistaDados;
import algopoly.vistas.VistaInformacion;
import algopoly.vistas.VistaTablero;

public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    private final VistaDados vistaDados;
    private final VistaInformacion vistaInformacion;
    private final VistaConsola vistaConsola;
    
    public BotonMoverHandler(VistaTablero vista, Tablero tablero, VistaDados vistaDados,
                             VistaInformacion vistaInformacion, VistaConsola vistaConsola) {
        this.vista = vista;
        this.tablero = tablero;
        this.vistaDados = vistaDados;
        this.vistaInformacion = vistaInformacion;
        this.vistaConsola = vistaConsola;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador = tablero.jugadorActual();
        try {
            this.tablero.proximoTurno();
        } catch(JugadorSinPlataException e) {
            this.tablero.eliminarJugador(jugador);
            if (this.tablero.terminoLaPartida()) {
                System.exit(0); 
            }
        }
        String nombreJugador = jugador.getNombre();
        this.vistaConsola.update("Ha jugado: " + nombreJugador);
    	this.vista.update();
    	this.vistaDados.update();
    	this.vistaInformacion.update();
    }
}


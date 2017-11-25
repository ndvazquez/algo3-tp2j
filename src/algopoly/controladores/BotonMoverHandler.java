package algopoly.controladores;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.jugador.Jugador;
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
    
    public BotonMoverHandler(VistaTablero vista, Tablero tablero, VistaDados vistaDados, VistaInformacion vistaInformacion) {
        this.vista = vista;
        this.tablero = tablero;
        this.vistaDados = vistaDados;
        this.vistaInformacion = vistaInformacion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador perdedor = tablero.jugadorActual();
        try {
            this.tablero.proximoTurno();
        } catch(JugadorSinPlataException e){
            this.tablero.eliminarJugador(perdedor);
            if(this.tablero.terminoLaPartida()){
                System.exit(0);
            }
        }
    	this.vista.update();
    	this.vistaDados.update();
    	this.vistaInformacion.update();
    }
}


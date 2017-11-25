package algopoly.controladores;

import algopoly.modelos.tablero.Tablero;
import algopoly.vistas.VistaInformacion;
import algopoly.vistas.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPagarFianzaHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    private final VistaInformacion vistaInformacion;
    
    public BotonPagarFianzaHandler(VistaTablero vista, Tablero tablero, VistaInformacion vistaInformacion) {
        this.vista = vista;
        this.tablero = tablero;
        this.vistaInformacion = vistaInformacion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	// accion + update vista
    }

}

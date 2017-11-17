package algopoly.vistas.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algopoly.modelos.tablero.Tablero;
import algopoly.vistas.VistaTablero;

public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    
    public BotonMoverHandler(VistaTablero vista, Tablero tablero) {
        this.vista = vista;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	this.tablero.proximoTurno();
    	this.vista.update();
    }
}


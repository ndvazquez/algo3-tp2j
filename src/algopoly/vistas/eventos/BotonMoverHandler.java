package algopoly.vistas.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algopoly.modelos.tablero.Tablero;
import algopoly.vistas.VistaDados;
import algopoly.vistas.VistaTablero;

public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    private final VistaDados vistaDados;
    
    public BotonMoverHandler(VistaTablero vista, Tablero tablero, VistaDados vistaDados) {
        this.vista = vista;
        this.tablero = tablero;
        this.vistaDados = vistaDados;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	this.tablero.proximoTurno();
    	this.vista.update();
    	this.vistaDados.update();
    }
}


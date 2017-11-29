package algopoly.controladores;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.Carcel;
import algopoly.vistas.VistaInformacion;
import algopoly.vistas.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
		Jugador jugador = tablero.jugadorActual();
    	
    	Integer capital = jugador.getCapital();
    	
    	if(capital >= Carcel.FIANZA) {
    		jugador.pagarFianza();
    		
    		Integer nuevoCapital = jugador.getCapital();
    		
    		if(capital != nuevoCapital) {
    			Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle("Pagar Fianza");
        		alert.setHeaderText(jugador.getNombre() + " sale de la Carcel");
        		alert.setContentText("Monto pagado: " + Carcel.FIANZA + "\nCapital luego de pagar la fianza: " + jugador.getCapital());
        		
        		alert.showAndWait();
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Pagar Fianza");
    		alert.setHeaderText("Capital Insuficiente");
    		
    		alert.showAndWait();
    	}
    	
    	vista.update(); // update imagen 
		vistaInformacion.update(); // update plata
    }

}

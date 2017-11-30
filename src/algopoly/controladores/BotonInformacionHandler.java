package algopoly.controladores;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.barrios.Barrio;
import algopoly.modelos.tablero.casilleros.compania.Compania;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class BotonInformacionHandler implements EventHandler<ActionEvent> {

	private final Tablero tablero;

	public BotonInformacionHandler(Tablero tablero) {
	        this.tablero = tablero;
	    }

	@Override
	public void handle(ActionEvent actionEvent) {
		Jugador j = this.tablero.jugadorActual();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Información");
		alert.setHeaderText(j.getNombre());
		
		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);

		int i = 0;
		Label label1 = new Label("Plata: "  + j.getCapital());
		expContent.add(label1, 0, i); 
		i += 1;
		
		Label label2 = new Label("Barrios: ");
		expContent.add(label2, 0, i);
		for (Barrio b : j.getBarrios()) {
			i += 1;
			expContent.add(new Label(b.getProvincia().name()), 2, i);
		}

		i += 1;
		Label label3 = new Label("Compañías: ");
		expContent.add(label3, 0, i);
		for (Compania c : j.getCompanias()) {
			i += 1;
			expContent.add(new Label(c.getNombre()), 2, i);
		}
		
		
		alert.getDialogPane().setExpandableContent(expContent);
		alert.showAndWait();
	}
}


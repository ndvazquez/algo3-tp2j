package algopoly.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.barrios.Barrio;
import algopoly.vistas.VistaInformacion;
import algopoly.vistas.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceDialog;

public class BotonComprarCasaHandler implements EventHandler<ActionEvent> {

	private final VistaTablero vista;
	private final Tablero tablero;
	private final VistaInformacion vistaInformacion;

	public BotonComprarCasaHandler(VistaTablero vista, Tablero tablero, VistaInformacion vistaInformacion) {
		this.vista = vista;
		this.tablero = tablero;
		this.vistaInformacion = vistaInformacion;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		Jugador jugador = tablero.jugadorActual();
		Collection<Barrio> barrios = jugador.getBarrios();

		List<String> choices = new ArrayList<>();
		for (Barrio barrio : barrios) {
			choices.add(barrio.getProvincia().name());
		}

		ChoiceDialog<String> dialog = new ChoiceDialog<>("", choices);
		dialog.setTitle("Compra de casa");
		dialog.setHeaderText("Elija en que barrio desea comprar una casa");
		dialog.setContentText("Barrios disponibles:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			for (Barrio barrio : barrios) {
				if (barrio.getProvincia().name().equals(result.get())) { // compara para ver que barrio eligió
					barrio.construirCasa();
				}
			}
		}

		vista.update(); // update imagen casa
		vistaInformacion.update(); // update plata
	}

}

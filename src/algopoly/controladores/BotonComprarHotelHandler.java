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

public class BotonComprarHotelHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    private final VistaInformacion vistaInformacion;
    
    public BotonComprarHotelHandler(VistaTablero vista, Tablero tablero, VistaInformacion vistaInformacion) {
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
		dialog.setTitle("Compra de Hotel");
		dialog.setHeaderText("Elija en qué barrio desea comprar un hotel");
		dialog.setContentText("Barrios disponibles:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			for (Barrio barrio : barrios) {
				if (barrio.getProvincia().name().equals(result.get())) { // compara para ver que barrio eligiÃ³
					barrio.construirHotel();
				}
			}
		}

		vista.update(); // update imagen hotel
		vistaInformacion.update(); // update plata
    }

}

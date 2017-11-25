package algopoly.controladores;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.barrios.Barrio;
import algopoly.vistas.VistaInformacion;
import algopoly.vistas.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BotonVenderTerrenoHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    private final VistaInformacion vistaInformacion;
    
    public BotonVenderTerrenoHandler(VistaTablero vista, Tablero tablero, VistaInformacion vistaInformacion) {
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

        ArrayList<Barrio> barriosAux = new ArrayList<>();
        for (Barrio barrio: barrios) {
            barriosAux.add(barrio);
        }
        ChoiceDialog<String> dialog = new ChoiceDialog<>("", choices);
        dialog.setTitle("Venta de un barrio");
        dialog.setHeaderText("Elija que barrio quiere vender.");
        dialog.setContentText("Barrios disponibles:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            for (Barrio barrio : barriosAux) {
                if (barrio.getProvincia().name().equals(result.get())) { // compara para ver que barrio eligió
                    jugador.venderBarrio(barrio);
                }
            }
        }

        vista.update();
        vistaInformacion.update();
    }

}

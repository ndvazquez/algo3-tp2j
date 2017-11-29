package algopoly.controladores;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.compania.Compania;
import algopoly.vistas.VistaInformacion;
import algopoly.vistas.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BotonVenderCompaniaHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    private final VistaInformacion vistaInformacion;
    
    public BotonVenderCompaniaHandler(VistaTablero vista, Tablero tablero, VistaInformacion vistaInformacion) {
        this.vista = vista;
        this.tablero = tablero;
        this.vistaInformacion = vistaInformacion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador = tablero.jugadorActual();
        Collection<Compania> companias = jugador.getCompanias();

        List<String> choices = new ArrayList<>();
        for (Compania compania : companias) {
            choices.add(compania.getNombre());
        }
        ArrayList<Compania> companiasAux = new ArrayList<>();
        companiasAux.addAll(companias);
        ChoiceDialog<String> dialog = new ChoiceDialog<>("", choices);
        dialog.setTitle("Venta de una compañía");
        dialog.setHeaderText("Elija que compañía quiere vender.");
        dialog.setContentText("Compañías disponibles:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            for (Compania compania : companiasAux) {
                if (compania.getNombre().equals(result.get())) { // compara para ver que compania eligió
                    jugador.venderCompania(compania);
                }
            }
        }

        vista.update();
        vistaInformacion.update();
    }

}

package algopoly.controladores;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.compania.Compania;
import algopoly.vistas.VistaConsola;
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
    private final VistaConsola vistaConsola;
    
    public BotonVenderCompaniaHandler(VistaTablero vista, Tablero tablero, VistaInformacion vistaInformacion,
                                      VistaConsola vistaConsola) {
        this.vista = vista;
        this.tablero = tablero;
        this.vistaInformacion = vistaInformacion;
        this.vistaConsola = vistaConsola;
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
        dialog.setTitle("Venta de una compania");
        dialog.setHeaderText("Elija que compania quiere vender.");
        dialog.setContentText("Companias disponibles:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            for (Compania compania : companiasAux) {
                if (compania.getNombre().equals(result.get())) { // compara para ver que compania eligió
                    jugador.venderCompania(compania);
                    String nombreJugador = jugador.getNombre();
                    String nombreCompania = compania.getNombre();
                    String mensaje = String.format("%s vendió la compañía %s.", nombreJugador, nombreCompania);
                    this.vistaConsola.update(mensaje);
                }
            }
        }

        vista.update();
        vistaInformacion.update();
    }

}

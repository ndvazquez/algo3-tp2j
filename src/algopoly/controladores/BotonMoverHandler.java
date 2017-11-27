package algopoly.controladores;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.jugador.Jugador;
import algopoly.vistas.VistaConsola;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Alert.AlertType;
import algopoly.modelos.tablero.Tablero;
import algopoly.vistas.VistaDados;
import algopoly.vistas.VistaInformacion;
import algopoly.vistas.VistaTablero;

public class BotonMoverHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    private final VistaDados vistaDados;
    private final VistaInformacion vistaInformacion;
    private final VistaConsola vistaConsola;

    public BotonMoverHandler(VistaTablero vista, Tablero tablero, VistaDados vistaDados,
                             VistaInformacion vistaInformacion, VistaConsola vistaConsola) {
        this.vista = vista;
        this.tablero = tablero;
        this.vistaDados = vistaDados;
        this.vistaInformacion = vistaInformacion;
        this.vistaConsola = vistaConsola;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugador = tablero.jugadorActual();
        try {
            this.tablero.proximoTurno();
        } catch(JugadorSinPlataException e) {
            this.tablero.eliminarJugador(jugador);
        }

        String valorTirada = jugador.getUltimaTirada().toString();
        String nombreJugador = jugador.getNombre();
        String nombreCasillero = jugador.getCasilleroActual().getNombre();
        String mensaje = String.format("%s tiró %s y cayó en el casillero %s.\n-----------", nombreJugador,
                valorTirada, nombreCasillero);

        this.vistaConsola.update(mensaje);
    	this.vista.update();
    	this.vistaDados.update();
    	this.vistaInformacion.update();
    	if (this.tablero.terminoLaPartida()) {
        	this.mostrarGanador();
        	System.exit(0);
        }
    }

	private void mostrarGanador() {
		Jugador j = this.tablero.getGanador();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ganador");
		alert.setHeaderText(j.getNombre() + " ha ganado la partida!!!");
		
		DialogPane dp = alert.getDialogPane();
		dp.getStyleClass().remove("alert");
		alert.showAndWait();
	}
}


package algopoly.controladores;

import java.util.Optional;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.barrios.Barrio;
import algopoly.modelos.tablero.casilleros.compania.Compania;
import algopoly.vistas.VistaConsola;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
            if (Barrio.class.isAssignableFrom(jugador.getCasilleroActual().getClass()) &&
            		((Barrio)jugador.getCasilleroActual()).getPropietario() == null) {
				this.opcionComprarBarrio();
			} else if (Compania.class.isAssignableFrom(jugador.getCasilleroActual().getClass()) &&
            		((Compania)jugador.getCasilleroActual()).getPropietario() == null) {
				this.opcionComprarCompania();
			}
        } catch(JugadorSinPlataException e) {
            this.tablero.eliminarJugador(jugador);
        }

        String mensaje = jugador.getMensajes();

        this.vistaConsola.update(mensaje);
    	this.vista.update();
    	this.vistaDados.update();
    	this.vistaInformacion.update();
    	if (this.tablero.terminoLaPartida()) {
        	this.mostrarGanador();
        	System.exit(0);
    	}
    }

	private void opcionComprarBarrio() {
		Jugador j = this.tablero.jugadorAnterior();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Compra de barrio");
		alert.setHeaderText(j.getNombre());
		alert.setContentText("¿Desea comprar el barrio: " + j.getCasilleroActual().getNombre() + "?");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			((Barrio)j.getCasilleroActual()).comprarBarrio(j);
		}
	}
	
	private void opcionComprarCompania() {
		Jugador j = this.tablero.jugadorAnterior();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Compra de compañía");
		alert.setHeaderText(j.getNombre());
		alert.setContentText("¿Desea comprar la compañía: " + j.getCasilleroActual().getNombre() + "?");
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			((Compania)j.getCasilleroActual()).comprarCompania(j);
		}
	}

	private void mostrarGanador() {
		Jugador j = this.tablero.getGanador();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Ganador");
		alert.setHeaderText(j.getNombre() + " ha ganado la partida!!!");
		ImageView iv = new ImageView(new Image("file:src/algopoly/vistas/imagenes/winner.gif"));
		alert.setGraphic(iv);
		DialogPane dp = alert.getDialogPane();
		dp.getStyleClass().remove("alert");
		alert.showAndWait();
	}
}


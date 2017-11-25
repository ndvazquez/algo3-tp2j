package algopoly.vistas;

import java.util.List;

import algopoly.modelos.jugador.Direccion;
import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;
import algopoly.modelos.tablero.Tablero;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class VistaTablero {

	private Tablero tablero;
	Canvas canvas;

	public VistaTablero(Tablero tablero, Canvas canvas) {
		this.tablero = tablero;
		this.canvas = canvas;
	}

	public void dibujar() {
		this.dibujarFormas();
	}

	private void dibujarFormas() {
		this.clean();
		List<Jugador> jugadores = this.tablero.getJugadores();
		dibujarRobot(jugadores.get(0), Color.GREEN, 260, 220, 220, 260);
		/*** Esto hay que modificarlo, lo dejo así para probar a mano que termina la partida ***/
		if(jugadores.size() >= 2)
			dibujarRobot(jugadores.get(1), Color.BLUE, 240, 240, 240, 240);
		if(jugadores.size() == 3)
			dibujarRobot(jugadores.get(2), Color.FUCHSIA, 220, 260, 260, 220);

	}

	private void dibujarRobot(Jugador jugador, Color color, int oeste, int sur, int este, int norte) {
		int offset;

		Posicion posicion = jugador.getPosicion();
		Direccion direccion = Direccion.getDireccion(Posicion.getIndice(posicion));

		if (direccion.equals(Direccion.norte()) || direccion.equals(Direccion.sur())) {
			if (direccion.equals(Direccion.norte()))
				offset = norte;
			else
				offset = sur;
			canvas.getGraphicsContext2D().setFill(color);
			canvas.getGraphicsContext2D().fillOval(posicion.getX() + offset, posicion.getY() + 250, Jugador.RADIO,
					Jugador.RADIO);
		} else {
			if (direccion.equals(Direccion.oeste()))
				offset = oeste;
			else
				offset = este;
			canvas.getGraphicsContext2D().setFill(color);
			canvas.getGraphicsContext2D().fillOval(posicion.getX() + 250, posicion.getY() + offset, Jugador.RADIO,
					Jugador.RADIO);
		}
		
	}

	public void clean() {
		Image image = new Image("file:src/algopoly/vistas/imagenes/tablero.jpg");
		canvas.getGraphicsContext2D().drawImage(image, 0, 0, 500, 500);
	}

	public void update() {
		this.dibujar();
	}

}

package algopoly.vistas;

import java.util.List;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaInformacion {

	private Tablero tablero;
	Canvas canvas;

	public VistaInformacion(Tablero tablero, Canvas canvas) {
		this.tablero = tablero;
		this.canvas = canvas;
	}

	public void dibujar() {
		this.clean();
			canvas.getGraphicsContext2D().setFont(Font.font("verdana", FontWeight.BOLD, 15));
			List<Jugador> jugadores = this.tablero.getJugadores();
			Jugador actual = this.tablero.jugadorActual();
			canvas.getGraphicsContext2D().setFill(Color.PURPLE);
			canvas.getGraphicsContext2D().fillText("Turno: " + actual.getNombre() , 0, 50);
			Jugador j = jugadores.get(0);
			canvas.getGraphicsContext2D().setFill(Color.GREEN);
			canvas.getGraphicsContext2D().fillText(j.getNombre() , 0, 100);
			canvas.getGraphicsContext2D().fillText("Plata: " + j.getCapital(), 0, 120);
			canvas.getGraphicsContext2D().fillText("Propiedades: " + j.getCantidadPropiedades(), 0, 140);
			j = jugadores.get(1);
			canvas.getGraphicsContext2D().setFill(Color.BLUE);
			canvas.getGraphicsContext2D().fillText(j.getNombre(), 0, 200);
			canvas.getGraphicsContext2D().fillText("Plata: " + j.getCapital(), 0, 220);
			canvas.getGraphicsContext2D().fillText("Propiedades: " + j.getCantidadPropiedades(), 0, 240);
			j = jugadores.get(2);
			canvas.getGraphicsContext2D().setFill(Color.FUCHSIA);
			canvas.getGraphicsContext2D().fillText(j.getNombre(), 0, 300);
			canvas.getGraphicsContext2D().fillText("Plata: " + j.getCapital(), 0, 320);
			canvas.getGraphicsContext2D().fillText("Propiedades: " + j.getCantidadPropiedades(), 0, 340);
	}


	public void clean() {
		canvas.getGraphicsContext2D().setFill(Color.LIGHTPINK);
		canvas.getGraphicsContext2D().fillRect(0, 0, 150, 500);
	}

	public void update() {
		this.dibujar();
	}

}

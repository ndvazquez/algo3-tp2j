package algopoly.vistas;

import java.util.List;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.Carcel;
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
			
			int y = 100;
			imprimirInformacion(jugadores.get(0), Color.GREEN, y);
			imprimirInformacion(jugadores.get(1), Color.BLUE, y += 110);
			imprimirInformacion(jugadores.get(2), Color.FUCHSIA, y += 110);
	}


	private void imprimirInformacion(Jugador j, Color color, Integer y) {
		canvas.getGraphicsContext2D().setFill(color);
		canvas.getGraphicsContext2D().fillText(j.getNombre() , 0, y += 20);
		canvas.getGraphicsContext2D().setFill(Color.RED);
		if (!j.sigoEnJuego()) {
			canvas.getGraphicsContext2D().fillText("FUERA DE JUEGO", 0, y += 20);
		} else if (j.getCasilleroActual().getClass().equals(Carcel.class)) {
			canvas.getGraphicsContext2D().fillText("ENCARCELADO", 0, y += 20);
		}
		canvas.getGraphicsContext2D().setFill(color);
		canvas.getGraphicsContext2D().fillText("Plata: " + j.getCapital(), 0, y += 20); 
		canvas.getGraphicsContext2D().fillText("Barrios: " + j.getCantidadBarrios().toString(), 0, y += 20);
		canvas.getGraphicsContext2D().fillText("Compañías: " + j.getCantidadCompanias().toString(), 0, y += 20);
		
	}

	public void clean() {
		canvas.getGraphicsContext2D().setFill(Color.LIGHTPINK);
		canvas.getGraphicsContext2D().fillRect(0, 0, 150, 500);
	}

	public void update() {
		this.dibujar();
	}

}

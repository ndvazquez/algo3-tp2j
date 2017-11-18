package algopoly.vistas;


import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;

public class VistaDados {

    private Tablero tablero;
	private Canvas canvas;

    public VistaDados(Tablero tablero, Canvas canvasDados) {
        this.tablero = tablero;
        this.canvas = canvasDados;
    }

	public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        this.clean();
        Jugador jugador = this.tablero.jugadorAcutal();
        canvas.getGraphicsContext2D().setFill(Color.FUCHSIA);
        canvas.getGraphicsContext2D().setFont(Font.font("verdana", FontWeight.BOLD, 20));
        canvas.getGraphicsContext2D().fillText(jugador.getUltimaTirada().toString(), 25,25);
        // reemplazar por imagenes luego
    }

   
	public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.BLACK);
        canvas.getGraphicsContext2D().fillRect(0,0,50,50);
    }

    public void update() {
        this.dibujar();
    }

}

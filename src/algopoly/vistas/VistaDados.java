package algopoly.vistas;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Collection;

import algopoly.modelos.jugador.Dado;
import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.Carcel;

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
        Jugador jugador = this.tablero.jugadorAnterior();
        
        int y = 5;
        Collection<Dado> dados = jugador.getUltimaTiradaEnDados();
        for (Dado dado : dados) {
        	if (!jugador.getCasilleroActual().getClass().equals(Carcel.class) && jugador.sigoEnJuego()) {
	        	String imgPath = "file:src/algopoly/vistas/imagenes/dado" + dado.getUltimaTirada().toString() + ".jpg";
	        	canvas.getGraphicsContext2D().drawImage(new Image(imgPath,90,90,true,true), 5, y);
	        	y = y + 100;
        	}
        }
        
        
    }

	public void clean() {
		canvas.getGraphicsContext2D().setFill(Color.WHITE);
		canvas.getGraphicsContext2D().fillRoundRect(0, 0, 100, 200, 10, 10);
	}

	public void update() {
		this.dibujar();
	}

}

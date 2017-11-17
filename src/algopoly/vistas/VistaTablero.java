package algopoly.vistas;

import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Direccion;
import algopoly.modelos.tablero.Posicion;
import algopoly.modelos.tablero.Tablero;

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
        dibujarRobot(jugadores.get(0), Color.DARKBLUE, 260, 220, 220, 260);
        dibujarRobot(jugadores.get(1), Color.GREEN, 240, 240, 240, 240);
        dibujarRobot(jugadores.get(2), Color.FUCHSIA, 220, 260, 260, 220);
	        
    }

    private void dibujarRobot(Jugador jugador, Color color, int oeste, int sur, int este, int norte) {
    	int offset;
    	
    	Direccion direccion = this.tablero.obtenerDireccion(jugador.getPosicion());
    	Posicion posicion = this.tablero.obtenerPosicion(jugador.getPosicion());
    	
    	if (direccion.equals(Direccion.norte()) || direccion.equals(Direccion.sur())) {
    		if (direccion.equals(Direccion.norte()))
        		offset = norte;
        	else 
        		offset = sur;
    		canvas.getGraphicsContext2D().setFill(color);
	        canvas.getGraphicsContext2D().fillOval(posicion.getX() + offset, posicion.getY() + 250, jugador.RADIO, jugador.RADIO);
        } else {
        	if (direccion.equals(Direccion.oeste()))
        		offset = oeste;
        	else 
        		offset = este;
	        canvas.getGraphicsContext2D().setFill(color);
	        canvas.getGraphicsContext2D().fillOval(posicion.getX() + 250, posicion.getY() + offset, jugador.RADIO, jugador.RADIO);
        }
    	
    	/*Integer ultimaTirada = tablero.jugadorAcutal().getUltimaTirada();
    	if (ultimaTirada != 0)
    		canvas.getGraphicsContext2D().drawImage(Dado.getImage(ultimaTirada), 250,250);*/
	}

	public void clean() {
    	Image image = new Image("file:src/algopoly/vistas/imagenes/tablero.jpg");
        canvas.getGraphicsContext2D().drawImage(image, 0, 0, 500, 500);
    }

    public void update() {
        this.dibujar();
    }

}

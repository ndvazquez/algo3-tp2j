package algopoly.vistas;

import java.util.List;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Direccion;
import algopoly.modelos.tablero.Posicion;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.Casillero;
import algopoly.modelos.tablero.casilleros.barrios.Barrio;
import algopoly.modelos.tablero.casilleros.barrios.Casa;
import algopoly.modelos.tablero.casilleros.barrios.Hotel;
import algopoly.modelos.tablero.casilleros.barrios.Inmueble;
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
		dibujarRobot(jugadores.get(1), Color.BLUE, 240, 240, 240, 240);
		dibujarRobot(jugadores.get(2), Color.FUCHSIA, 220, 260, 260, 220);
		
		dibujarCasas();

	}

	private void dibujarCasas() {
		int offsetX = 230;
		int offsetY = 230;
		
		List<Casillero> barrios = tablero.obtenerBarrios();
		for (Casillero barrio : barrios) {
			Posicion pos = tablero.getPosicionCasillero(barrio);
			Direccion direccion = Direccion.getDireccion(Tablero.obtenerTablero().getNumeroDeCasillero(barrio));

			Image imagen1 = null;
			Image imagen2 = null;
			
			StringBuilder imgPath = new StringBuilder("file:src/algopoly/vistas/imagenes/");
			Inmueble inm = ((Barrio) barrio).getInmuebleActual();
			
			if (inm != null && inm.getClass().equals(Casa.class)) {
				imgPath.append("casa.png");
				imagen1 = new Image(imgPath.toString(), 30, 30, true, true);
				if (((Barrio) barrio).cantidadEdificios() ==  2) {
					imagen2 = new Image(imgPath.toString(), 30, 30, true, true);
				}
			} else if (inm != null && inm.getClass().equals(Hotel.class)) {
				imgPath.append("hotel.png");
				imagen1 = new Image(imgPath.toString(), 50, 50, true, true);
			}
			
			if (direccion.equals(Direccion.norte())) {
				canvas.getGraphicsContext2D().drawImage(imagen1, pos.getX()+200, pos.getY()+offsetY);
				canvas.getGraphicsContext2D().drawImage(imagen2, pos.getX()+200, pos.getY()+offsetY + 30);
			} else if (direccion.equals(Direccion.sur())) {
				canvas.getGraphicsContext2D().drawImage(imagen1, pos.getX()+280, pos.getY()+offsetY);
				canvas.getGraphicsContext2D().drawImage(imagen2, pos.getX()+280, pos.getY()+offsetY + 30);
			} else if (direccion.equals(Direccion.oeste())) {
				canvas.getGraphicsContext2D().drawImage(imagen1, pos.getX()+offsetX, pos.getY()+200);
				canvas.getGraphicsContext2D().drawImage(imagen2, pos.getX()+offsetX + 30, pos.getY()+200);
			} else if (direccion.equals(Direccion.este())) {
				canvas.getGraphicsContext2D().drawImage(imagen1, pos.getX()+offsetX, pos.getY()+280);
				canvas.getGraphicsContext2D().drawImage(imagen2, pos.getX()+offsetX + 30, pos.getY()+280);
			}
		}
	}


	private void dibujarRobot(Jugador jugador, Color color, int oeste, int sur, int este, int norte) {
		int offset;
		if (jugador.sigoEnJuego()) {
			Posicion posicion = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());
			Direccion direccion = Direccion.getDireccion(Tablero.obtenerTablero().getNumeroDeCasillero(jugador.getCasilleroActual()));
	
			if (direccion.equals(Direccion.norte()) || direccion.equals(Direccion.sur())) {
				if (direccion.equals(Direccion.norte())) {
					offset = norte;
				} else {
					offset = sur;
				}
				canvas.getGraphicsContext2D().setFill(color);
				canvas.getGraphicsContext2D().fillOval(posicion.getX() + offset, posicion.getY() + 250, Jugador.RADIO,
						Jugador.RADIO);
			} else {
				if (direccion.equals(Direccion.oeste())) {
					offset = oeste;
				} else {
					offset = este;
				}
				canvas.getGraphicsContext2D().setFill(color);
				canvas.getGraphicsContext2D().fillOval(posicion.getX() + 250, posicion.getY() + offset, Jugador.RADIO,
						Jugador.RADIO);
			}
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

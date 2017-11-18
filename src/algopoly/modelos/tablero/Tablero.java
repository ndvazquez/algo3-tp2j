package algopoly.modelos.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algopoly.modelos.jugador.Jugador;

public class Tablero {

	private ArrayList<Jugador> jugadores;
	private ArrayList<Casillero> casilleros;
	private ArrayList<Direccion> direcciones;
	private ArrayList<Posicion> posiciones;
	private Integer turnoActual;

	public Tablero() {
		jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador());
		jugadores.add(new Jugador());
		jugadores.add(new Jugador());

		turnoActual = (new Random().nextInt(3));

		this.armarCasilleros();
		this.armarListaDirecciones();
		this.armarListaPosiciones();
	}

	private void armarCasilleros() {
		Carcel carcel = new Carcel();

		Servicios serviciosTrenSubte = new Servicios();
		Compania tren = new Compania(38000, 450, 800, serviciosTrenSubte);
		Compania subte = new Compania(40000, 600, 1100, serviciosTrenSubte);
		serviciosTrenSubte.agregarParDeCompanias(tren, subte);

		Servicios serviciosEdesurAysa = new Servicios();
		Compania edesur = new Compania(35000, 500, 1000, serviciosEdesurAysa);
		Compania aysa = new Compania(30000, 300, 500, serviciosEdesurAysa);
		serviciosEdesurAysa.agregarParDeCompanias(edesur, aysa);

		casilleros = new ArrayList<Casillero>();
		// salida
		casilleros.add(new Quini6());
		// bsassur
		casilleros.add(edesur);
		// bsasnorte
		casilleros.add(carcel);
		// cordoba
		casilleros.add(new AvanceDinamico());
		casilleros.add(subte);
		// cordoba
		// impuesto
		// santafe
		casilleros.add(aysa);
		// salta
		// salta
		casilleros.add(new Policia(carcel));
		casilleros.add(tren);
		// neuquen
		casilleros.add(new RetrocesoDinamico());
		// tucuman1
	}

	public void moverJugador(Jugador jugador) {

	}

	public void ganador() {

	}

	public Jugador jugadorAcutal() {
		return this.jugadores.get(this.turnoActual);
	}

	public void proximoTurno() {
		this.turnoActual = (this.turnoActual + 1) % 3;
		Jugador jugador = this.jugadorAcutal();
		jugador.iniciarTurno();
		// Casillero casilleroActual = casilleros.get(jugador.getPosicion() %
		// this.casilleros.size());
		// casilleroActual.recibirJugador(jugador);
	}

	public List<Jugador> getJugadores() {
		return this.jugadores;
	}

	public Posicion obtenerPosicion(Integer posicion) {
		return this.posiciones.get(posicion % posiciones.size());
	}

	public Direccion obtenerDireccion(Integer posicion) {
		return this.direcciones.get(posicion % direcciones.size());
	}

	private void armarListaPosiciones() {
		this.posiciones = new ArrayList<Posicion>();
		posiciones.add(new Posicion(200, 200)); // salida
		posiciones.add(new Posicion(100, 200)); // quini 6
		posiciones.add(new Posicion(30, 200)); // bs as sur
		posiciones.add(new Posicion(-40, 200)); // edesur
		posiciones.add(new Posicion(-100, 200)); // bs as norte
		posiciones.add(new Posicion(-200, 200)); // carcel
		posiciones.add(new Posicion(-200, 100)); // cordoba sur
		posiciones.add(new Posicion(-200, 30)); // avance dinamico
		posiciones.add(new Posicion(-200, -40)); // subte
		posiciones.add(new Posicion(-200, -100)); // cordoba norte
		posiciones.add(new Posicion(-200, -200)); // impuesto de lujo
		posiciones.add(new Posicion(-100, -200)); // santa fe
		posiciones.add(new Posicion(-40, -200)); // aysa
		posiciones.add(new Posicion(30, -200)); // salta norte
		posiciones.add(new Posicion(100, -200)); // salta sur
		posiciones.add(new Posicion(200, -200)); // policia
		posiciones.add(new Posicion(200, -100)); // tren
		posiciones.add(new Posicion(200, -40)); // neuquen
		posiciones.add(new Posicion(200, 30)); // retroceso
		posiciones.add(new Posicion(200, 100)); // tucuman
	}

	private void armarListaDirecciones() {
		this.direcciones = new ArrayList<Direccion>();
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.oeste());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.sur());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.este());
		direcciones.add(Direccion.norte());
		direcciones.add(Direccion.norte());
		direcciones.add(Direccion.norte());
		direcciones.add(Direccion.norte());
		direcciones.add(Direccion.norte());
	}
}

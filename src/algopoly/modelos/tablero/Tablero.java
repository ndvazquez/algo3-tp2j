package algopoly.modelos.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;
import algopoly.modelos.tablero.casilleros.AvanceDinamico;
import algopoly.modelos.tablero.casilleros.Carcel;
import algopoly.modelos.tablero.casilleros.Casillero;
import algopoly.modelos.tablero.casilleros.ImpuestoDeLujo;
import algopoly.modelos.tablero.casilleros.Policia;
import algopoly.modelos.tablero.casilleros.Quini6;
import algopoly.modelos.tablero.casilleros.RetrocesoDinamico;
import algopoly.modelos.tablero.casilleros.Salida;
import algopoly.modelos.tablero.casilleros.barrios.BarrioFactory;
import algopoly.modelos.tablero.casilleros.barrios.Provincia;
import algopoly.modelos.tablero.casilleros.compania.Aysa;
import algopoly.modelos.tablero.casilleros.compania.Compania;
import algopoly.modelos.tablero.casilleros.compania.Edesur;
import algopoly.modelos.tablero.casilleros.compania.Subte;
import algopoly.modelos.tablero.casilleros.compania.Tren;

public class Tablero {

	private ArrayList<Jugador> jugadores;
	private static ArrayList<Casillero> casilleros;
	public static Tablero tablero = new Tablero();
	private Integer turnoActual;
	private Integer turnosJugados;

	public Tablero() {
		jugadores = new ArrayList<>();

		Jugador jugador1 = new Jugador();
		jugador1.setNombre("Alan");

		Jugador jugador2 = new Jugador();
		jugador2.setNombre("Barbara");

		Jugador jugador3 = new Jugador();
		jugador3.setNombre("Linus");

		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);

		turnosJugados = 0;
		turnoActual = (new Random().nextInt(3));

		this.armarCasilleros();
		jugador1.setCasilleroActual(casilleros.get(0));
		jugador2.setCasilleroActual(casilleros.get(0));
		jugador3.setCasilleroActual(casilleros.get(0));
	}

	private void armarCasilleros() {
		Carcel carcel = new Carcel();

		Compania tren = new Tren();
		Compania subte = new Subte();
		tren.setCompaniaPar(subte);
		subte.setCompaniaPar(tren);

		Compania edesur = new Edesur();
		Compania aysa = new Aysa();
		edesur.setCompaniaPar(aysa);
		aysa.setCompaniaPar(edesur);

		BarrioFactory barrioFactory = new BarrioFactory();

		casilleros = new ArrayList<>();

		casilleros.add(new Salida()); // salida
		casilleros.add(new Quini6(this.jugadores));
		casilleros.add(barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE));// bsassur
		casilleros.add(edesur);
		casilleros.add(barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR));// bsasnorte
		casilleros.add(carcel);
		casilleros.add(barrioFactory.crearBarrioDoble(Provincia.CORDOBA_SUR, Provincia.CORDOBA_NORTE)); // cordoba
		casilleros.add(new AvanceDinamico());
		casilleros.add(subte);
		casilleros.add(barrioFactory.crearBarrioDoble(Provincia.CORDOBA_NORTE, Provincia.CORDOBA_SUR)); // cordoba
		casilleros.add(new ImpuestoDeLujo()); // impuesto
		casilleros.add(barrioFactory.crearBarrioSimple(Provincia.SANTA_FE)); // santafe
		casilleros.add(aysa);
		casilleros.add(barrioFactory.crearBarrioDoble(Provincia.SALTA_SUR, Provincia.SALTA_NORTE)); // salta
		casilleros.add(barrioFactory.crearBarrioDoble(Provincia.SALTA_NORTE, Provincia.SALTA_SUR));// salta
		casilleros.add(new Policia(carcel));
		casilleros.add(tren);
		casilleros.add(barrioFactory.crearBarrioSimple(Provincia.NEUQUEN));// neuquen
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(barrioFactory.crearBarrioSimple(Provincia.TUCUMAN)); // tucuman1
	}

	
	
	public Jugador jugadorActual() {
		return this.jugadores.get(this.turnoActual);
	}

	public Jugador jugadorAnterior() {
		int posicion = 0;
		if (!this.turnoActual.equals(0)) { 
			posicion = ((this.turnoActual - 1) % this.jugadores.size());
		} else {
			posicion = this.jugadores.size()-1;
		}
		return this.jugadores.get(posicion);
	}

	public void proximoTurno() {
		Jugador jugador = this.jugadorActual();
		if (jugador.sigoEnJuego()) {
			jugador.iniciarTurno();
			this.turnosJugados++;
		}
		if (jugador.getUltimaTirada().equals(0) || !jugador.sacoDoble() || this.turnosJugados.equals(2) ||!jugador.sigoEnJuego()) {
			this.turnoActual = (this.turnoActual + 1) % this.jugadores.size();
			this.turnosJugados = 0;
		}
	}

	public List<Jugador> getJugadores() {
		return this.jugadores;
	}

	public void eliminarJugador(Jugador jugador) {
		jugador.fueraDeJuego();
	}

	public boolean terminoLaPartida() {
		return this.jugadores.size() == 1;
	}
	
	public Casillero obtenerCasilleroSiguiente(Casillero casilleroActual) {
		return casilleros.get((casilleros.indexOf(casilleroActual) + 1) % casilleros.size());
	}

	public Casillero obtenerCasilleroAnterior(Casillero casilleroActual) {
		return casilleros.get(Math.floorMod((casilleros.indexOf(casilleroActual) - 1), casilleros.size()));
	}

	public Posicion getPosicionCasillero(Casillero casilleroActual) {
		return posiciones.get(casilleros.indexOf(casilleroActual));
	}

	public Casillero obtenerCasillero(Posicion pos) {
		return casilleros.get(posiciones.indexOf(pos));
	}

	public static Tablero obtenerTablero() {
		return tablero;
	}

	public static final Posicion SALIDA = new Posicion(200, 200);
	public static final Posicion QUINI6 = new Posicion(100, 200);
	public static final Posicion BSAS_SUR = new Posicion(30, 200);
	public static final Posicion EDESUR = new Posicion(-40, 200);
	public static final Posicion BSAS_NORTE = new Posicion(-100, 200);
	public static final Posicion CARCEL = new Posicion(-200, 200);
	public static final Posicion CORDOBA_SUR = new Posicion(-200, 100);
	public static final Posicion AVANCE_DINAMICO = new Posicion(-200, 30);
	public static final Posicion SUBTE = new Posicion(-200, -40);
	public static final Posicion CORDOBA_NORTE = new Posicion(-200, -100);
	public static final Posicion IMPUESTO_DE_LUJO = new Posicion(-200, -200);
	public static final Posicion SANTA_FE = new Posicion(-100, -200);
	public static final Posicion AYSA = new Posicion(-40, -200);
	public static final Posicion SALTA_NORTE = new Posicion(30, -200);
	public static final Posicion SALTA_SUR = new Posicion(100, -200);
	public static final Posicion POLICIA = new Posicion(200, -200);
	public static final Posicion TREN = new Posicion(200, -100);
	public static final Posicion NEUQUEN = new Posicion(200, -40);
	public static final Posicion RETROCESO_DINAMICO = new Posicion(200, 30);
	public static final Posicion TUCUMAN = new Posicion(200, 100);

	private static ArrayList<Posicion> posiciones;
	static {
		posiciones = new ArrayList<>();
		posiciones.add(SALIDA);
		posiciones.add(QUINI6);
		posiciones.add(BSAS_SUR);
		posiciones.add(EDESUR);
		posiciones.add(BSAS_NORTE);
		posiciones.add(CARCEL);
		posiciones.add(CORDOBA_SUR);
		posiciones.add(AVANCE_DINAMICO);
		posiciones.add(SUBTE);
		posiciones.add(CORDOBA_NORTE);
		posiciones.add(IMPUESTO_DE_LUJO);
		posiciones.add(SANTA_FE);
		posiciones.add(AYSA);
		posiciones.add(SALTA_NORTE);
		posiciones.add(SALTA_SUR);
		posiciones.add(POLICIA);
		posiciones.add(TREN);
		posiciones.add(NEUQUEN);
		posiciones.add(RETROCESO_DINAMICO);
		posiciones.add(TUCUMAN);
	}

	public Integer getNumeroDeCasillero(Casillero casilleroActual) {
		return casilleros.indexOf(casilleroActual);
	}
}

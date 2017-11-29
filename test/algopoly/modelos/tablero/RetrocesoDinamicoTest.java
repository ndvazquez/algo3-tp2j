package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.Casillero;

import org.junit.Assert;
import org.junit.Test;

public class RetrocesoDinamicoTest {

	/*** Tests dados 2 - 6 ***/
	@Test
	public void test01JugadorCaeEnRetrocesoDinamicoTirando2Retrocede2MenosSuCantidaddDePropiedades() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador(); // propiedades = 0
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(2)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.TREN);
	}

	@Test
	public void test02JugadorCaeEnRetrocesoDinamicoTirando3Retrocede3MenosSuCantidaddDePropiedades() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador(); // propiedades = 0
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(3)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());
		// cae en policia -> va a la carcel
		Assert.assertEquals(indiceFinal, Tablero.CARCEL);
	}

	@Test
	public void test03JugadorCaeEnRetrocesoDinamicoTirando4Retrocede4MenosSuCantidaddDePropiedades() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador(); // propiedades = 0
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(4)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.SALTA_SUR);
	}

	@Test
	public void test04JugadorCaeEnRetrocesoDinamicoTirando5Retrocede5MenosSuCantidaddDePropiedades() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador(); // propiedades = 0
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(5)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.SALTA_NORTE);
	}

	@Test
	public void test05JugadorCaeEnRetrocesoDinamicoTirando6Retrocede6MenosSuCantidaddDePropiedades() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador(); // propiedades = 0
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(6)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.AYSA);
	}

	/*** Tests dados 7 - 10 ***/
	@Test
	public void test06JugadorCaeEnRetrocesoTirando7RetrocedeSuCantidadDeEfectivoModuloLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador();
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(7)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.SALTA_NORTE);
	}

	@Test
	public void test07JugadorCaeEnRetrocesoTirando8RetrocedeSuCantidadDeEfectivoModuloLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador();
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(8)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.RETROCESO_DINAMICO);
	}

	@Test
	public void test08JugadorCaeEnRetrocesoTirando9RetrocedeSuCantidadDeEfectivoModuloLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador();
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(9)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.NEUQUEN);
	}

	@Test
	public void test09JugadorCaeEnRetrocesoTirando10RetrocedeSuCantidadDeEfectivoModuloLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador();
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(10)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.RETROCESO_DINAMICO);
	}

	/*** Tests dados 11 - 12 ***/
	@Test
	public void test010JugadorCaeEnRetrocesoTirando11RetrocedeLaTiradaMenos2() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador();
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(11)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.CORDOBA_NORTE);
	}

	@Test
	public void test011JugadorCaeEnRetrocesoTirando12RetrocedeLaTiradaMenos2() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugadorPrueba = new Jugador();
		Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(12)) {
			valor = jugadorPrueba.tirar();
		}
		Casillero retrocesoDinamico = tablero.obtenerCasillero(Tablero.RETROCESO_DINAMICO);
		jugadorPrueba.setCasilleroActual(retrocesoDinamico);
		retrocesoDinamico.recibirJugador(jugadorPrueba);
		Posicion indiceFinal = tablero.getPosicionCasillero(jugadorPrueba.getCasilleroActual());

		Assert.assertEquals(indiceFinal, Tablero.SUBTE);
	}
}

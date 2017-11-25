package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;
import algopoly.modelos.tablero.casilleros.Casillero;
import algopoly.modelos.tablero.casilleros.barrios.BarrioSimple;

import org.mockito.Mockito;

import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {

	/*** Tests dados 2 - 6 ***/
	@Test
	public void test01JugadorCaeEnAvanceDinamicoSacando2SuPosicionSeIncrementa2MenosQueLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		
		Integer valor = jugador.tirar();
		while (!valor.equals(2)) {
			valor = jugador.tirar();
		}
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);
		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = tablero.getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.AVANCE_DINAMICO);
	}

	@Test
	public void test02JugadorCaeEnAvanceDinamicoSacando3SuPosicionSeIncrementa2MenosQueLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		Integer valor = jugador.tirar();
		while (!valor.equals(3)) {
			valor = jugador.tirar();
		}
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.SUBTE);
	}

	@Test
	public void test03JugadorCaeEnAvanceDinamicoSacando4SuPosicionSeIncrementa2MenosQueLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		Integer valor = jugador.tirar();
		while (!valor.equals(4)) {
			valor = jugador.tirar();
		}
		
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());
		
		Assert.assertEquals(posicionFinal, Tablero.CORDOBA_NORTE);
	}

	@Test
	public void test04JugadorCaeEnAvanceDinamicoSacando5SuPosicionSeIncrementa2MenosQueLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		Integer valor = jugador.tirar();
		while (!valor.equals(5)) {
			valor = jugador.tirar();
		}		

		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.IMPUESTO_DE_LUJO);
	}

	@Test
	public void test05JugadorCaeEnAvanceDinamicoSacando6SuPosicionSeIncrementa2MenosQueLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		Integer valor = jugador.tirar();
		while (!valor.equals(6)) {
			valor = jugador.tirar();
		}
		
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.SANTA_FE);
	}

	/*** Tests dados 7 - 10 ***/
	@Test
	public void test06JugadorCaeEnAvanceDinamicoTirando7AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador(); // plata inicial 100000
		Integer valor = jugador.tirar();
		while (!valor.equals(7)) {
			valor = jugador.tirar();
		}
		
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.AYSA);
	}

	@Test
	public void test07JugadorCaeEnAvanceDinamicoTirando8AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador(); // plata inicial 100000
		Integer valor = jugador.tirar();
		while (!valor.equals(8)) {
			valor = jugador.tirar();
		}
		
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.AVANCE_DINAMICO);
	}

	@Test
	public void test08JugadorCaeEnAvanceDinamicoTirando9AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador(); // plata inicial 100000
		Integer valor = jugador.tirar();
		while (!valor.equals(9)) {
			valor = jugador.tirar();
		}
		
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.SUBTE);
	}

	@Test
	public void test09JugadorCaeEnAvanceDinamicoTirando10AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador(); // plata inicial 100000
		Integer valor = jugador.tirar();
		while (!valor.equals(10)) {
			valor = jugador.tirar();
		}
		
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.AVANCE_DINAMICO);
	}

	/*** Tests dados 11 -12 ***/
	@Test
	public void test10JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDePropiedadesSinPropiedades() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador(); // barrios = 0
		Integer valor = jugador.tirar();
		while (!valor.equals(11)) {
			valor = jugador.tirar();
		}
		
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());
		// cae en Retroceso Dinamico y retrocede: 11-2
		Assert.assertEquals(posicionFinal, Tablero.CORDOBA_NORTE);
	}

	@Test
	public void test11JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDeBarriosConBarrios() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		jugador.comprarBarrio(Mockito.mock(BarrioSimple.class));
		Integer valor = jugador.tirar();
		while (!valor.equals(11)) {
			valor = jugador.tirar();
		}
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.NEUQUEN);
	}

	@Test
	public void test12JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDeBarriosConBarriosMayorA11() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		for (int i=0; i<20; i++) {
			jugador.comprarBarrio(Mockito.mock(BarrioSimple.class));
		}
		Integer valor = jugador.tirar();
		while (!valor.equals(11)) {
			valor = jugador.tirar();
		}
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.AVANCE_DINAMICO);
	}

	@Test
	public void test13JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDeBarriosSinBarrios() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador(); // barrios = 0
		Integer valor = jugador.tirar();
		while (!valor.equals(12)) {
			valor = jugador.tirar();
		}
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		Assert.assertEquals(posicionFinal, Tablero.TUCUMAN);
	}

	@Test
	public void test14JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDeBarriosConPropiedades() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		jugador.comprarBarrio(Mockito.mock(BarrioSimple.class));
		Integer valor = jugador.tirar();
		while (!valor.equals(12)) {
			valor = jugador.tirar();
		}
		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());

		 // cae en retroceso dinamico -> retrocede 12 - 10
		Assert.assertEquals(posicionFinal, Tablero.SUBTE);
	}

	@Test
	public void test15JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDeBarriosConPropiedadesMayorA12() {
		Tablero tablero = Tablero.obtenerTablero();
		Jugador jugador = new Jugador();
		for (int i=0; i<20; i++){
			jugador.comprarBarrio(Mockito.mock(BarrioSimple.class));
		}
		Integer valor = jugador.tirar();
		while (!valor.equals(12)) {
			valor = jugador.tirar();
		}

		Casillero avanceDinamico = tablero.obtenerCasillero(Tablero.AVANCE_DINAMICO);

		jugador.setCasilleroActual(avanceDinamico);
		avanceDinamico.recibirJugador(jugador);
		Posicion posicionFinal = Tablero.obtenerTablero().getPosicionCasillero(jugador.getCasilleroActual());
		
		Assert.assertEquals(posicionFinal, Tablero.AVANCE_DINAMICO);
	}
}

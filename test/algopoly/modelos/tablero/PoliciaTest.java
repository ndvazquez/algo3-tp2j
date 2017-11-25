package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

import org.junit.Assert;
import org.junit.Test;

public class PoliciaTest {

	@Test
	public void test01JugadorCaeEnPoliciaYVaALaCarcel() {
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		Jugador jugadorPrueba = new Jugador();

		policia.recibirJugador(jugadorPrueba);

		Assert.assertEquals(jugadorPrueba.getCasilleroActual(), carcel);
	}

	@Test
	public void test02JugadorCaeEnPoliciaYNoSePuedeMover() {
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		Jugador jugadorPrueba = new Jugador();

		policia.recibirJugador(jugadorPrueba);
		
		int tirada = jugadorPrueba.tirar();
		
		Assert.assertEquals(tirada, 0);
	}

}
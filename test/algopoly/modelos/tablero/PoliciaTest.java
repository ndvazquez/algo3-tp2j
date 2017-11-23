package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;

import org.junit.Assert;
import org.junit.Test;

public class PoliciaTest {

	@Test
	public void test01JugadorCaeEnPoliciaYVaALaCarcel() {
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		Jugador jugadorPrueba = new Jugador();

		policia.recibirJugador(jugadorPrueba);

		Assert.assertEquals(jugadorPrueba.getPosicion(), Posicion.CARCEL);
	}

	@Test
	public void test02JugadorCaeEnPoliciaYNoSePuedeMover() {
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		Jugador jugadorPrueba = new Jugador();

		policia.recibirJugador(jugadorPrueba);
		
	
		Posicion posicionInicial = jugadorPrueba.getPosicion();
		
		jugadorPrueba.mover(1);
		
		Posicion posicionFinal = jugadorPrueba.getPosicion();
		
		Assert.assertEquals(posicionFinal, posicionInicial);
	}

}
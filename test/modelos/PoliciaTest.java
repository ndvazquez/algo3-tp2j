package modelos;

import org.junit.Assert;
import org.junit.Test;

import modelos.Carcel;
import modelos.Jugador;
import modelos.Policia;

public class PoliciaTest {
	
	@Test
	public void test01JugadorCaeEnPoliciaYVaALaCarcel() {

		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		Jugador jugadorPrueba = new Jugador();

		policia.recibirJugador(jugadorPrueba);

		Assert.assertEquals(jugadorPrueba.getPosicion(), 5);
	}

	@Test
	public void tets02JugadorCaeEnPoliciaYNoSePuedeMover() {
 	
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		Jugador jugadorPrueba = new Jugador();
		
		policia.recibirJugador(jugadorPrueba);
		
		Assert.assertFalse(jugadorPrueba.puedeMoverse());
	}

}
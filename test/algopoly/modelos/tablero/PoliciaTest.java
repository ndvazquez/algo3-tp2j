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

		Assert.assertEquals(jugadorPrueba.getPosicion(), Carcel.POSICION);
		Assert.assertFalse(jugadorPrueba.puedeMoverse());
	}

	@Test
	public void test02JugadorCaeEnPoliciaYNoSePuedeMover() {
 	
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel);
		Jugador jugadorPrueba = new Jugador();
		
		policia.recibirJugador(jugadorPrueba);
		
		Assert.assertFalse(jugadorPrueba.puedeMoverse());
	}

}
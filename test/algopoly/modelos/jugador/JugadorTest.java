package algopoly.modelos.jugador;

import org.junit.Assert;
import org.junit.Test;


public class JugadorTest {

	@Test
	public void test01JugadorEsEncarceladoYHabilitadoLuegoPuedeMoverseYEjecutarAcciones() {
		
		Jugador jugador = new Jugador();
		
		jugador.encarcelar();
		jugador.habilitar();
		
		Assert.assertTrue(jugador.puedeMoverse());
		Assert.assertTrue(jugador.puedeEjecutarAcciones());
	}

}
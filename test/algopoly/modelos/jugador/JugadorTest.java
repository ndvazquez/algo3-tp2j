package algopoly.modelos.jugador;

import org.junit.Assert;
import org.junit.Test;


public class JugadorTest {

	@Test
	public void test01JugadorEsEncarceladoYHabilitadoLuegoPuedeMoverse() {
		
		Jugador jugador = new Jugador();
		
		jugador.encarcelar();
		jugador.habilitar();
		
		Posicion posicionActual = jugador.getPosicion();
		
		jugador.mover(1);
		
		Posicion posicionNueva = Posicion.getPosicionSiguiente(posicionActual);
		
		Assert.assertEquals(posicionNueva, jugador.getPosicion());
	}

}

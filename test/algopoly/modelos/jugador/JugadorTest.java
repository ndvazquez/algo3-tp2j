package algopoly.modelos.jugador;

import org.junit.Assert;
import org.junit.Test;

import algopoly.modelos.propiedad.PropiedadSimple;
import algopoly.modelos.propiedad.Provincia;


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

package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class PropiedadTest {

	@Test
	public void test01jugadorCaeEnUnaPropiedadYSeConvierteEnPropietario() {

		Jugador jugadorPrueba = new Jugador();
		Propiedad propiedad = Mockito.mock(Propiedad.class);

		Mockito.doCallRealMethod().when(propiedad).recibirJugador(jugadorPrueba);
		Mockito.doCallRealMethod().when(propiedad).getPropietario();
		propiedad.recibirJugador(jugadorPrueba);

		int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();

		Assert.assertEquals(cantidadPropiedades, 1);
		Assert.assertEquals(propiedad.getPropietario(), jugadorPrueba);
	}

}


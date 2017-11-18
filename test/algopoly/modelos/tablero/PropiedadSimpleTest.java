package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;


public class PropiedadSimpleTest {

	@Test
	public void test01jugadorCaeEnUnaPropiedadSimpleYSeConvierteEnPropietario() {

		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedadSimple = new PropiedadSimple(0, 0, 0);


		propiedadSimple.recibirJugador(jugadorPrueba);

		int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();

		Assert.assertEquals(cantidadPropiedades, 1);
		Assert.assertEquals(propiedadSimple.getPropietario(), jugadorPrueba);
	}

}


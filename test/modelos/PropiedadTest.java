package modelos;

import org.junit.Test;
import org.junit.Assert;
import modelos.Jugador;
import modelos.Propiedad;

public class PropiedadTest {
	
	@Test
	public void test01jugadorCaeEnUnaPropiedadYSeConvierteEnPropietario() {
		
		Jugador jugadorPrueba = new Jugador();
		Propiedad propiedad = new Propiedad();
		
		propiedad.recibirJugador(jugadorPrueba);
		
		int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();
		
		Assert.assertEquals(cantidadPropiedades, 1);
		Assert.assertEquals(propiedad.getPropietario(), jugadorPrueba);
	}

}

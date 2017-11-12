package modelos;

import org.junit.Test;
import org.junit.Assert;
import modelos.Jugador;
import modelos.Propiedad;

public class PropiedadTest {
	
	@Test
	public void jugadorCaeEnUnaPropiedadYSeConvierteEnPropietario() {
		
		Jugador jugadorPrueba = new Jugador();
		Propiedad propiedad = new Propiedad();
		
		propiedad.recibirJugador(jugadorPrueba);
		
		Assert.assertEquals(propiedad.getPropietario(), jugadorPrueba);
	}

}

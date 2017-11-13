package modelos;

import org.junit.Assert;
import org.junit.Test;

public class EncarceladoTest {
	
	
	@Test
	public void testPuedeMoverseEsFalseEnEstadoEncarcelado() {
		
		Encarcelado encarcelado = new Encarcelado();
		
		Assert.assertFalse(encarcelado.puedeMoverse());
	}
	
	@Test
	public void testPuedeEjecutarAccionesEsFalseEnEstadoEncarcelado() {
		
		Encarcelado encarcelado = new Encarcelado();
		
		Assert.assertFalse(encarcelado.puedeEjecutarAcciones());
	}
	
	
}
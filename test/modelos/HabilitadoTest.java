package modelos;

import org.junit.Assert;
import org.junit.Test;

public class HabilitadoTest {
	
	@Test
	public void testPuedeMoverseEsTrueEnEstadoHabilitado() {
		
		Habilitado habilitado = new Habilitado();
		
		Assert.assertTrue(habilitado.puedeMoverse());
	}
	
	@Test
	public void testPuedeEjecutarAccionesEsTrueEnEstadoHabilitado() {
		
		Habilitado habilitado = new Habilitado();
		
		Assert.assertTrue(habilitado.puedeEjecutarAcciones());
	}
	
}
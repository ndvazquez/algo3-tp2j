package modelos;

import org.junit.Assert;
import org.junit.Test;

public class EncarceladoYEsperoUnTurnoTest {
	
	
	@Test
	public void testPuedeMoverseEsFalseEnEstadoEncarceladoYEsperoUnTurno() {
		
		EncarceladoYEsperoUnTurno encarceladoConUnTurno = new EncarceladoYEsperoUnTurno();
		
		Assert.assertFalse(encarceladoConUnTurno.puedeMoverse());
		
	}
	
	@Test
	public void testPuedeEjecutarAccionesEsTrueEnEstadoEncarceladoYEsperoUnTurno() {
		
		EncarceladoYEsperoUnTurno encarceladoConTurno = new EncarceladoYEsperoUnTurno();
		
		Assert.assertTrue(encarceladoConTurno.puedeEjecutarAcciones());
	}
}
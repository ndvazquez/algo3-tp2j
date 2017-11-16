package algopoly.modelos.jugador;

import org.junit.Assert;
import org.junit.Test;

public class HabilitadoTest {

	@Test
	public void test01PuedeMoverseEsTrueEnEstadoHabilitado() {
		
		Habilitado habilitado = new Habilitado();
		
		Assert.assertTrue(habilitado.puedeMoverse());
	}
	
	@Test
	public void test02PuedeEjecutarAccionesEsTrueEnEstadoHabilitado() {
		
		Habilitado habilitado = new Habilitado();
		
		Assert.assertTrue(habilitado.puedeEjecutarAcciones());
	}

	@Test
	public void test03IniciarTurnoNoTieneEfectoEnEstadoHabilitado() {

		Habilitado habilitado = new Habilitado();

		habilitado.iniciarTurno();

		Assert.assertTrue(habilitado.puedeEjecutarAcciones());
		Assert.assertTrue(habilitado.puedeMoverse());
	}

}
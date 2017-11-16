package algopoly.modelos.jugador;

import org.junit.Assert;
import org.junit.Test;

public class EncarceladoTest {
	
	
	@Test
	public void test01PuedeMoverseEsFalseEnEstadoEncarcelado() {
		
		Jugador jugador = new Jugador();
		
		Encarcelado encarcelado = new Encarcelado(jugador);
		
		Assert.assertFalse(encarcelado.puedeMoverse());
	}
	
	@Test
	public void test02PuedeEjecutarAccionesEsFalseEnEstadoEncarceladoSiNoPasoNingunTurno() {
		
		Jugador jugador = new Jugador();
		
		Encarcelado encarcelado = new Encarcelado(jugador);
		
		Assert.assertFalse(encarcelado.puedeEjecutarAcciones());
	}
	
	@Test
	public void test03PuedeEjecutarAccionesEsFalseEnEstadoEncarceladoSiPasoUnTurno() {
		
		Jugador jugador = new Jugador();
		
		Encarcelado encarcelado = new Encarcelado(jugador);
		
		encarcelado.iniciarTurno();
		
		Assert.assertFalse(encarcelado.puedeEjecutarAcciones());
		
	}
	
	@Test
	public void test04PuedeEjecutarAccionesEsTrueEnEstadoEncarceladoSiPasoMasDeUnTurno() {
		
		Jugador jugador = new Jugador();
		
		Encarcelado encarcelado = new Encarcelado(jugador);
		
		encarcelado.iniciarTurno();
		encarcelado.iniciarTurno();
		
		Assert.assertTrue(encarcelado.puedeEjecutarAcciones());
	}
	
	@Test
	public void test05IniciarTurnoAumentaEnUnoElContadorDeTurnosEnCarcel() {
		
		Jugador jugador = new Jugador();
		
		Encarcelado encarcelado = new Encarcelado(jugador);
		
		encarcelado.iniciarTurno();
		
		Assert.assertEquals(1, encarcelado.getTurnosEnCarcel().intValue());
	}
}
package modelos;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
	
	/* Tests correspondientes a la entrega del 16/11 */
	
	@Test
	public void testJugadorCaeEnCarcelYNoPuedeEjecutarAccionesNiMoverseDuranteElPrimerTurno() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);
		
		jugador.iniciarTurno();
		
		Assert.assertFalse(jugador.puedeEjecutarAcciones());
		Assert.assertFalse(jugador.puedeMoverse());
	}
	
	@Test
	public void testJugadorCaeEnCarcelYAPartirDelSegundoTurnoPuedePagarFianzaYMoverse() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		
		Assert.assertTrue(jugador.puedeMoverse());
	}

	@Test
	public void testJugadorCaeEnCarcelYNoPuedePagarFianzaPorFaltaDeFondosLuegoNoPuedeMoverse() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.incrementarCapital(-60000);
		
		jugador.pagarFianza();
		
		Assert.assertFalse(jugador.puedeMoverse());
	}
	
	/* Tests Complementarios */
	
	@Test
	public void testJugadorEncarceladoQuedaHabilitadoLuegoDeCuatroTurnos() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		Assert.assertTrue(jugador.puedeEjecutarAcciones());
		Assert.assertTrue(jugador.puedeMoverse());
	}
	
	@Test
	public void testPagarFianzaResta45000PesosAlCapitalDelJugador() {
		
		Jugador jugador = new Jugador();
		
		jugador.pagarFianza();
		
		Integer capitalFinal = new Integer(55000);
		
		assertEquals(0, capitalFinal.compareTo(jugador.getCapital()));
	}
	
	@Test
	public void testPagarFianzaNoModificaElCapitalDelJugadorSiElMismoEsMenorA45000Pesos() {
		
		Jugador jugador = new Jugador();
		
		jugador.incrementarCapital(-60000);
		
		jugador.pagarFianza();
		
		Integer capitalFinal = new Integer(40000);
		
		assertEquals(0, capitalFinal.compareTo(jugador.getCapital()));
	}
	
	@Test
	public void testPagarFianzaNoHaceNadaSiElJugadorNoEsperoNingunTurnoEnLaCarcel() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);
		
		jugador.pagarFianza();
		
		Integer capitalFinal = new Integer(100000);
		
		assertEquals(0, capitalFinal.compareTo(jugador.getCapital()));
	}
	
	@Test
	public void testPagarFianzaLiberaAlJugadorQueSalioDeLaCarcelEsperandoCuatroTurnos() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();				//Luego de esto jugador queda libre
		
		jugador.caerEnCasillero(carcel);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.pagarFianza();
		
		Assert.assertTrue(jugador.puedeEjecutarAcciones());
		Assert.assertTrue(jugador.puedeMoverse());
		
	}
	
	@Test
	public void testEsperarCuatroTurnosLiberaJugadorQueSalioDeLaCarcelPagandoFianza() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		
		jugador.caerEnCasillero(carcel);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		Assert.assertTrue(jugador.puedeEjecutarAcciones());
		Assert.assertTrue(jugador.puedeMoverse());
	}
	
	@Test
	public void testJugadorSaleDeLaCarcelEsperandoCuatroTurnosPasanDosTurnosYPuedeMoverse() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		jugador.iniciarTurno();				// Luego de esto jugador queda libre
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		Assert.assertTrue(jugador.puedeMoverse());
		
	}
	
	@Test
	public void testJugadorSaleDeLaCarcelPagandoFianzaPasanDosTurnosYPuedeMoverse() {
	
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		jugador.caerEnCasillero(carcel);	
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		Assert.assertTrue(jugador.puedeMoverse());
	
	}

}
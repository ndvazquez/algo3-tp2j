package algopoly.modelos.tablero;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
	
	/* Tests correspondientes a la entrega del 16/11 */
	
	@Test
	public void test01JugadorCaeEnCarcelYNoPuedeEjecutarAccionesNiMoverseDuranteElPrimerTurno() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		jugador.iniciarTurno();
		
		Assert.assertFalse(jugador.puedeEjecutarAcciones());
		Assert.assertFalse(jugador.puedeMoverse());
	}
	
	@Test
	public void test02JugadorCaeEnCarcelYAPartirDelSegundoTurnoPuedePagarFianzaYMoverse() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		
		Assert.assertTrue(jugador.puedeMoverse());
	}

	@Test(expected = JugadorSinPlataException.class)
	public void test03JugadorCaeEnCarcelYNoPuedePagarFianzaPorFaltaDeFondosLuegoNoPuedeMoverse() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagar(60000);
		jugador.pagarFianza();
	}
	
	/* Tests Complementarios */
	
	@Test
	public void test04JugadorEncarceladoQuedaHabilitadoLuegoDeCuatroTurnos() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		for(int i = 0; i < 4; i++) {
			
			jugador.iniciarTurno();
		}
		
		Assert.assertTrue(jugador.puedeEjecutarAcciones());
		Assert.assertTrue(jugador.puedeMoverse());
	}
	
	@Test
	public void test05PagarFianzaResta45000PesosAlCapitalDelJugador() {
		
		Jugador jugador = new Jugador();
		Integer capitalFinal = new Integer(55000);
		
		jugador.pagarFianza();
		
		Assert.assertEquals(0, capitalFinal.compareTo(jugador.getCapital()));
	}
	
	@Test
	public void test06PagarFianzaNoHaceNadaSiElCapitalDelJugadorEsMenorA45000Pesos() {
		
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Integer capitalFinal = new Integer(40000);
		
		carcel.recibirJugador(jugador);
		
		jugador.pagar(60000);
		jugador.pagarFianza();
		
		Assert.assertEquals(capitalFinal.intValue(), jugador.getCapital().intValue());
		Assert.assertFalse(jugador.puedeMoverse());
	}
	
	@Test
	public void test07PagarFianzaNoHaceNadaSiElJugadorNoEsperoNingunTurnoEnLaCarcel() {
		
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		Integer capitalFinal = new Integer(100000);
		
		carcel.recibirJugador(jugador);
		jugador.pagarFianza();
		
		Assert.assertEquals(capitalFinal.intValue(), jugador.getCapital().intValue());
		Assert.assertFalse(jugador.puedeMoverse());
	}
	
	@Test
	public void test08PagarFianzaLiberaAlJugadorQueSalioDeLaCarcelEsperandoCuatroTurnos() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		
		for(int i = 0; i < 4; i++) {
			
			jugador.iniciarTurno();
		}
		
		carcel.recibirJugador(jugador);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		
		Assert.assertTrue(jugador.puedeEjecutarAcciones());
		Assert.assertTrue(jugador.puedeMoverse());
		
	}
	
	@Test
	public void test09EsperarCuatroTurnosLiberaJugadorQueSalioDeLaCarcelPagandoFianza() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		carcel.recibirJugador(jugador);
		
		for(int i = 0; i < 4; i++) {
			
			jugador.iniciarTurno();
		}
		
		Assert.assertTrue(jugador.puedeEjecutarAcciones());
		Assert.assertTrue(jugador.puedeMoverse());
	}
}
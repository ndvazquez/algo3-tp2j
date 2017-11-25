package algopoly.modelos.tablero;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.Carcel;
import algopoly.modelos.tablero.casilleros.Casillero;

import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
	

	/* Tests correspondientes a la entrega del 16/11 */
	
	@Test
	public void test01JugadorCaeEnCarcelYNoPuedeMoverseDuranteElPrimerTurno() {
		Tablero tablero = new Tablero();
		Jugador jugador = tablero.jugadorActual();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		jugador.iniciarTurno();
		
		Casillero posicionActual = jugador.getCasilleroActual();
		
		jugador.iniciarTurno();
		
		Casillero posicionNueva = jugador.getCasilleroActual();
		
		Assert.assertEquals(posicionNueva, posicionActual);
}

	
	@Test
	public void test02JugadorCaeEnCarcelYAPartirDelSegundoTurnoPuedePagarUnaFianzaYLuegoPuedeMoverse() {
		Tablero tablero = new Tablero();
		Jugador jugador = tablero.jugadorActual();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		
		Casillero posicionActual = jugador.getCasilleroActual();
		
		jugador.iniciarTurno();
		
		Casillero posicionNueva = jugador.getCasilleroActual();
		
		Assert.assertNotEquals(posicionActual, posicionNueva);
	}

	@Test(expected = JugadorSinPlataException.class)
	public void test03JugadorCaeEnCarcelYNoPuedePagarFianzaPorFaltaDeFondosLuegoNoPuedeMoverse() {
		Tablero tablero = new Tablero();
		Jugador jugador = tablero.jugadorActual();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagar(99999);
		jugador.pagarFianza();
	}
	
	/* Tests Complementarios */
	
	@Test
	public void test04JugadorEncarceladoQuedaHabilitadoLuegoDeCuatroTurnosLuegoPuedeMoverse() {
		Tablero tablero = new Tablero();
		Jugador jugador = tablero.jugadorActual();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		for(int i = 0; i < 4; i++) {
			
			jugador.iniciarTurno();
		}
		
		Casillero posicionActual = jugador.getCasilleroActual();
		jugador.iniciarTurno();
		Casillero posicionNueva = jugador.getCasilleroActual();
		
		Assert.assertNotEquals(posicionActual, posicionNueva);
	}
	
	@Test
	public void test05PagarFianzaResta45000PesosAlCapitalDelJugador() {
		Tablero tablero = new Tablero();
		Jugador jugador = tablero.jugadorActual();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		
		Integer capitalInicial = jugador.getCapital();
		
		jugador.pagarFianza();
		
		Integer capitalFinal = jugador.getCapital();
		
		Assert.assertEquals(capitalFinal.intValue(), capitalInicial - Carcel.FIANZA);
	}
		
	@Test
	public void test06PagarFianzaNoHaceNadaSiElJugadorNoEsperoNingunTurnoEnLaCarcel() {
		Tablero tablero = new Tablero();
		Jugador jugador = tablero.jugadorActual();
		Carcel carcel = new Carcel();

		Integer capitalInicial = jugador.getCapital();
		
		carcel.recibirJugador(jugador);
		jugador.pagarFianza();
		
		Integer capitalFinal = jugador.getCapital();
		
		Assert.assertEquals(capitalFinal, capitalInicial);
	}
	
	@Test
	public void test07PagarFianzaLiberaAlJugadorQueSalioDeLaCarcelEsperandoCuatroTurnos() {

		Tablero tablero = new Tablero();
		Jugador jugador = tablero.jugadorActual();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		
		for(int i = 0; i < 4; i++) {
			
			jugador.iniciarTurno();
		}
		
		carcel.recibirJugador(jugador);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		
		Casillero posicionActual = jugador.getCasilleroActual();
		jugador.iniciarTurno();
		Casillero posicionNueva = jugador.getCasilleroActual();
		
		Assert.assertNotEquals(posicionActual, posicionNueva);
		
	}
	
	@Test
	public void test08EsperarCuatroTurnosLiberaJugadorQueSalioDeLaCarcelPagandoFianza() {

		Tablero tablero = new Tablero();
		Jugador jugador = tablero.jugadorActual();		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		carcel.recibirJugador(jugador);
		
		for(int i = 0; i < 4; i++) {
			
			jugador.iniciarTurno();
		}
		
		Casillero posicionActual = jugador.getCasilleroActual();
		jugador.iniciarTurno();
		Casillero posicionNueva = jugador.getCasilleroActual();
		
		Assert.assertNotEquals(posicionActual, posicionNueva);
	}
}
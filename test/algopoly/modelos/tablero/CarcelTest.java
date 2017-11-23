package algopoly.modelos.tablero;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;

import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
	
	private static final Integer FIANZA = 45000;

	/* Tests correspondientes a la entrega del 16/11 */
	
	@Test
	public void test01JugadorCaeEnCarcelYNoPuedeMoverseDuranteElPrimerTurno() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		jugador.iniciarTurno();
		
		Posicion posicionActual = jugador.getPosicion();
		
		jugador.mover(1);
		
		Posicion posicionNueva = jugador.getPosicion();
		
		Assert.assertEquals(posicionNueva, posicionActual);
}

	
	@Test
	public void test02JugadorCaeEnCarcelYAPartirDelSegundoTurnoPuedePagarUnaFianzaYLuegoPuedeMoverse() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		jugador.pagarFianza();
		
		Posicion posicionActual = jugador.getPosicion();
		
		jugador.mover(1);
	
		Posicion posicionNueva = Posicion.getPosicionSiguiente(posicionActual);
		
		Assert.assertEquals(posicionNueva, jugador.getPosicion());
	}

	@Test(expected = JugadorSinPlataException.class)
	public void test03JugadorCaeEnCarcelYNoPuedePagarFianzaPorFaltaDeFondosLuegoNoPuedeMoverse() {
		
		Jugador jugador = new Jugador();
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
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		
		for(int i = 0; i < 4; i++) {
			
			jugador.iniciarTurno();
		}
		
		Posicion posicionInicial = jugador.getPosicion();
		
		jugador.mover(1);
		
		Posicion posicionFinal = Posicion.getPosicionSiguiente(posicionInicial);
		Assert.assertEquals(posicionFinal, jugador.getPosicion());
	}
	
	@Test
	public void test05PagarFianzaResta45000PesosAlCapitalDelJugador() {
		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.recibirJugador(jugador);
		jugador.iniciarTurno();
		jugador.iniciarTurno();
		
		
		Integer capitalInicial = jugador.getCapital();
		
		jugador.pagarFianza();
		
		Integer capitalFinal = jugador.getCapital();
		
		Assert.assertEquals(capitalFinal.intValue(), capitalInicial - FIANZA);
	}
		
	@Test
	public void test06PagarFianzaNoHaceNadaSiElJugadorNoEsperoNingunTurnoEnLaCarcel() {
		
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador();
		
		Integer capitalInicial = jugador.getCapital();
		
		carcel.recibirJugador(jugador);
		jugador.pagarFianza();
		
		Integer capitalFinal = jugador.getCapital();
		
		Assert.assertEquals(capitalFinal, capitalInicial);
	}
	
	@Test
	public void test07PagarFianzaLiberaAlJugadorQueSalioDeLaCarcelEsperandoCuatroTurnos() {
		
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
		
		Posicion posicionInicial = jugador.getPosicion();
		
		jugador.mover(1);
		
		Posicion posicionFinal = Posicion.getPosicionSiguiente(posicionInicial);
		
		Assert.assertEquals(posicionFinal, jugador.getPosicion());
		
	}
	
	@Test
	public void test08EsperarCuatroTurnosLiberaJugadorQueSalioDeLaCarcelPagandoFianza() {
		
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
		
		Posicion posicionInicial = jugador.getPosicion();
		
		jugador.mover(1);
		
		Posicion posicionFinal = Posicion.getPosicionSiguiente(posicionInicial);
		
		Assert.assertEquals(posicionFinal, jugador.getPosicion());
	}
}
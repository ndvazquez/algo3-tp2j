package algopoly.modelos.jugador;

import org.junit.Assert;
import org.junit.Test;

public class EncarceladoTest {
	
	private static final Integer FIANZA = 45000;
	
	@Test
	public void test01TirarEnEstadoEncarceladoDevuelve0() {
		
		Encarcelado encarcelado = new Encarcelado(new Jugador());
		
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		
		Integer resultado = encarcelado.tirar(dado1, dado2);
		
		Assert.assertEquals(0, resultado.intValue());
	}
	
	@Test
	public void test02PagarFianzaNoTieneEfectoSobreElCapitalDelJugadorDuranteElPrimerTurno() {
		
		Jugador jugador = new Jugador();
		Encarcelado encarcelado = new Encarcelado(jugador);
		
		Integer capitalInicial = jugador.getCapital();
		
		encarcelado.iniciarTurno();
		encarcelado.pagarFianza();
		
		Integer capitalFinal = jugador.getCapital();
		
		Assert.assertEquals(capitalFinal, capitalInicial);
	}
	
	@Test
	public void test03TestPagarFianzaModificaElCapitalDelJugadorAPartirDelSegundoTurno() {
		
		Jugador jugador = new Jugador();
		Encarcelado encarcelado = new Encarcelado(jugador);
		
		Integer capitalInicial = jugador.getCapital();
		
		encarcelado.iniciarTurno();
		encarcelado.iniciarTurno();
		
		encarcelado.pagarFianza();
		
		Integer capitalFinal = jugador.getCapital();
		
		Assert.assertEquals(capitalFinal.intValue(), capitalInicial - FIANZA);
		
	}
}
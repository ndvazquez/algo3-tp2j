package algopoly.modelos.tablero;

import org.junit.Assert;

import org.junit.Test;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.ImpuestoDeLujo;

public class ImpuestoDeLujoTest {

	@Test
	public void test01JugadorCaeEnImpuestoDeLujoYSuCapitalSeReduceEnUn10PorCiento() {
		
		Jugador jugador = new Jugador();
		ImpuestoDeLujo impuestoDeLujo = new ImpuestoDeLujo();
		Integer capitalInicial = jugador.getCapital();
		
		impuestoDeLujo.recibirJugador(jugador);
		Integer capitalFinal = capitalInicial - (capitalInicial / 10);
		
		Assert.assertEquals(capitalFinal, jugador.getCapital());
	}
}

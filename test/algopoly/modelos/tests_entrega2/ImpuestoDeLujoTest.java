package algopoly.modelos.tests_entrega2;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.ImpuestoDeLujo;
import org.junit.Assert;
import org.junit.Test;

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

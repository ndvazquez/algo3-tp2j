package algopoly.modelos.jugador;

import org.junit.Assert;
import org.junit.Test;

public class HabilitadoTest {

	@Test
	public void test01JugadorHabilitadoTiraLosDadosYLaTiradaEsUnValorEntre1Y12() {
		
		Habilitado habilitado = new Habilitado(new Jugador());
		
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		
		Integer resultado = habilitado.tirar(dado1, dado2);
		
		Assert.assertTrue(resultado > 0 && resultado < 13);
	}

}
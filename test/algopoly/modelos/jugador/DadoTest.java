package algopoly.modelos.jugador;

import org.junit.Assert;
import org.junit.Test;

public class DadoTest {
	
	@Test
	public void test01TirarDadoEsUnNumeroEntre1Y6() {
		Dado dado = new Dado();
		
		int valor = dado.tirar();
		
		boolean esCorrecto = (valor >=1 && valor <= 6);
		
		Assert.assertTrue(esCorrecto);
	}
}

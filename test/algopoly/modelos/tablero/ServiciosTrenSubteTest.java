package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.compania.Compania;
import algopoly.modelos.tablero.compania.Subte;
import algopoly.modelos.tablero.compania.Tren;

import org.junit.Assert;
import org.junit.Test;

public class ServiciosTrenSubteTest {

	private static final Integer PRECIO_TREN = 38000;
	private static final Integer IMP_TREN = 450;
	private static final Integer IMP_TREN_DOBLE = 800;
	
	private static final Integer PRECIO_SUBTE = 40000;
	private static final Integer IMP_SUBTE = 600;
	private static final Integer IMP_SUBTE_DOBLE = 1100;
	
	/** Tests 11 - 12 segunda entrega **/
	@Test
	public void test01JugadorCaeEnSubteYAhoraTiene40000PesosMenos() {
		Jugador jugador = new Jugador();
		
		Compania subte = new Subte();

		subte.recibirJugador(jugador);

		int plataFinal = jugador.getCapital();

		Assert.assertEquals((100000 - PRECIO_SUBTE), plataFinal);
		Assert.assertTrue(subte.soyTuDuenio(jugador));
	}

	@Test
	public void test02JugadorCaeEnTrenYAhoraTiene38000PesosMenos() {
		Jugador jugador = new Jugador();

		Compania tren = new Tren();

		tren.recibirJugador(jugador);

		int plataFinal = jugador.getCapital();

		Assert.assertEquals((100000 - PRECIO_TREN), plataFinal);
		Assert.assertTrue(tren.soyTuDuenio(jugador));
	}

	@Test
	public void test03JugadorCaeEnTrenAdquiridaPorOtroJugadorQueNoEsDuenioDeSubteSuDineroSeReduce450PorLosDados() {
		Compania tren = new Tren();

		Jugador jugador = new Jugador();
		tren.recibirJugador(jugador); // jugador compra tren

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		tren.recibirJugador(otroJugador); // otro jugador cae en tren

		int plataFinal = otroJugador.getCapital();
		Assert.assertEquals((100000 - (IMP_TREN * otroJugador.getUltimaTirada())), plataFinal);
	}

	@Test
	public void test04JugadorCaeEnTrenAdquiridaPorOtroJugadorQueEsDuenioDeSubteSuDineroSeReduce800PorLosDados() {
		Compania tren = new Tren();
		Compania subte = new Subte();
		tren.setCompaniaPar(subte);
		subte.setCompaniaPar(tren);
		

		Jugador jugador = new Jugador();
		tren.recibirJugador(jugador); // jugador compra tren
		subte.recibirJugador(jugador); // jugador compra subte

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		tren.recibirJugador(otroJugador); // otro jugador cae en tren

		int plataFinal = otroJugador.getCapital();
		Assert.assertEquals((100000 - (IMP_TREN_DOBLE * otroJugador.getUltimaTirada())), plataFinal);
	}

	@Test
	public void test05JugadorCaeEnTrenAdquiridaPorSiMismoSuDineroNoSeReduce() {
		Compania tren = new Tren();
		Compania subte = new Subte();
		tren.setCompaniaPar(subte);
		subte.setCompaniaPar(tren);
		

		Jugador jugador = new Jugador();
		tren.recibirJugador(jugador); // jugador compra tren
		subte.recibirJugador(jugador); // jugador compra subte

		int plataInicial = jugador.getCapital();
		jugador.tirar();
		tren.recibirJugador(jugador);
		int plataFinal = jugador.getCapital();

		Assert.assertEquals(plataInicial, plataFinal);
	}

	@Test
	public void test06JugadorCaeEnSubteAdquiridaPorSiMismoSuDineroNoSeReduce() {
		Compania tren = new Tren();
		Compania subte = new Subte();
		tren.setCompaniaPar(subte);
		subte.setCompaniaPar(tren);
		

		Jugador jugador = new Jugador();
		tren.recibirJugador(jugador); // jugador compra tren
		subte.recibirJugador(jugador); // jugador compra subte

		int plataInicial = jugador.getCapital();
		jugador.tirar();
		subte.recibirJugador(jugador);
		int plataFinal = jugador.getCapital();

		Assert.assertEquals(plataInicial, plataFinal);
	}

	@Test
	public void test07JugadorCaeEnSubteAdquiridaPorOtroJugadorQueNoEsDuenioDeTrenSuDineroSeReduce600PorDados() {
		Compania subte = new Subte();

		Jugador jugador = new Jugador();
		subte.recibirJugador(jugador); // jugador compra subte

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		subte.recibirJugador(otroJugador);
		int plataFinal = otroJugador.getCapital();

		Assert.assertEquals(100000 - (IMP_SUBTE * otroJugador.getUltimaTirada()), plataFinal);
	}

	@Test
	public void test08JugadorCaeEnSubteAdquiridaPorOtroJugadorQueEsDuenioDeTrenSuDineroSeReduce1100PorDados() {
		Compania tren = new Tren();
		Compania subte = new Subte();
		tren.setCompaniaPar(subte);
		subte.setCompaniaPar(tren);
		
		Jugador jugador = new Jugador();
		tren.recibirJugador(jugador); // jugador compra tren
		subte.recibirJugador(jugador); // jugador compra subte

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		subte.recibirJugador(otroJugador);
		int plataFinal = otroJugador.getCapital();

		Assert.assertEquals(100000 - (IMP_SUBTE_DOBLE * otroJugador.getUltimaTirada()), plataFinal);
	}

}

package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

import org.junit.Assert;
import org.junit.Test;

public class ServiciosTrenSubteTest {

	private static final Integer PRECIO_SUBTE = 40000;
	private static final Integer IMP_SUBTE = 600;
	private static final Integer IMP_SUBTE_DOBLE = 1100;

	private static final Integer PRECIO_TREN = 38000;
	private static final Integer IMP_TREN = 450;
	private static final Integer IMP_TREN_DOBLE = 800;

	/** Tests 11 - 12 segunda entrega **/
	@Test
	public void test01JugadorCaeEnSubteYAhoraTiene40000PesosMenos() {
		Jugador jugador = new Jugador();

		Servicios servicios = new Servicios();
		Compania subte = new Compania(PRECIO_SUBTE, IMP_SUBTE, IMP_SUBTE_DOBLE, servicios);

		subte.recibirJugador(jugador);

		int plataFinal = jugador.getCapital();

		Assert.assertEquals((100000 - PRECIO_SUBTE), plataFinal);
		Assert.assertTrue(subte.soyTuDueño(jugador));
	}

	@Test
	public void test02JugadorCaeEnTrenYAhoraTiene38000PesosMenos() {
		Jugador jugador = new Jugador();

		Servicios servicios = new Servicios();
		Compania tren = new Compania(PRECIO_TREN, IMP_TREN, IMP_TREN_DOBLE, servicios);

		tren.recibirJugador(jugador);

		int plataFinal = jugador.getCapital();

		Assert.assertEquals((100000 - PRECIO_TREN), plataFinal);
		Assert.assertTrue(tren.soyTuDueño(jugador));
	}

	@Test
	public void test03JugadorCaeEnTrenAdquiridaPorOtroJugadorQueNoEsDueñoDeSubteSuDineroSeReduce450PorLosDados() {
		Servicios servicios = new Servicios();
		Compania tren = new Compania(PRECIO_TREN, IMP_TREN, IMP_TREN_DOBLE, servicios);

		Jugador jugador = new Jugador();
		tren.recibirJugador(jugador); // jugador compra tren

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		tren.recibirJugador(otroJugador); // otro jugador cae en tren

		int plataFinal = otroJugador.getCapital();
		Assert.assertEquals((100000 - (IMP_TREN * otroJugador.getUltimaTirada())), plataFinal);
	}

	@Test
	public void test04JugadorCaeEnTrenAdquiridaPorOtroJugadorQueEsDueñoDeSubteSuDineroSeReduce800PorLosDados() {
		Servicios servicios = new Servicios();
		Compania tren = new Compania(PRECIO_TREN, IMP_TREN, IMP_TREN_DOBLE, servicios);
		Compania subte = new Compania(PRECIO_SUBTE, IMP_SUBTE, IMP_SUBTE_DOBLE, servicios);

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
		Servicios servicios = new Servicios();
		Compania tren = new Compania(PRECIO_TREN, IMP_TREN, IMP_TREN_DOBLE, servicios);
		Compania subte = new Compania(PRECIO_SUBTE, IMP_SUBTE, IMP_SUBTE_DOBLE, servicios);

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
		Servicios servicios = new Servicios();
		Compania tren = new Compania(PRECIO_TREN, IMP_TREN, IMP_TREN_DOBLE, servicios);
		Compania subte = new Compania(PRECIO_SUBTE, IMP_SUBTE, IMP_SUBTE_DOBLE, servicios);

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
	public void test07JugadorCaeEnSubteAdquiridaPorOtroJugadorQueNoEsDueñoDeTrenSuDineroSeReduce600PorDados() {
		Servicios servicios = new Servicios();
		Compania subte = new Compania(PRECIO_SUBTE, IMP_SUBTE, IMP_SUBTE_DOBLE, servicios);

		Jugador jugador = new Jugador();
		subte.recibirJugador(jugador); // jugador compra subte

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		subte.recibirJugador(otroJugador);
		int plataFinal = otroJugador.getCapital();

		Assert.assertEquals(100000 - (IMP_SUBTE * otroJugador.getUltimaTirada()), plataFinal);
	}

	@Test
	public void test08JugadorCaeEnSubteAdquiridaPorOtroJugadorQueEsDueñoDeTrenSuDineroSeReduce1100PorDados() {
		Servicios servicios = new Servicios();
		Compania tren = new Compania(PRECIO_TREN, IMP_TREN, IMP_TREN_DOBLE, servicios);
		Compania subte = new Compania(PRECIO_SUBTE, IMP_SUBTE, IMP_SUBTE_DOBLE, servicios);

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

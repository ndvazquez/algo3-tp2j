package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.servicios.Compania;
import algopoly.modelos.tablero.servicios.Servicios;

import org.junit.Assert;
import org.junit.Test;

public class ServiciosAysaEdesurTest {

	private static final Integer PRECIO_AYSA = 30000;
	private static final Integer IMP_AYSA = 300;
	private static final Integer IMP_AYSA_DOBLE = 500;

	private static final Integer PRECIO_EDESUR = 35000;
	private static final Integer IMP_EDESUR = 500;
	private static final Integer IMP_EDESUR_DOBLE = 1000;

	/** Tests 16 - 17 segunda entrega **/
	@Test
	public void test01JugadorCaeEnAysaYAhoraTiene30000PesosMenos() {
		Jugador jugador = new Jugador();

		Servicios servicios = new Servicios();
		Compania aysa = new Compania(PRECIO_AYSA, IMP_AYSA, IMP_AYSA_DOBLE, servicios);

		aysa.recibirJugador(jugador);

		int plataFinal = jugador.getCapital();

		Assert.assertEquals((100000 - PRECIO_AYSA), plataFinal);
		Assert.assertTrue(aysa.soyTuDueño(jugador));
	}

	@Test
	public void test02JugadorCaeEnEdesurYAhoraTiene35000PesosMenos() {
		Jugador jugador = new Jugador();

		Servicios servicios = new Servicios();
		Compania edesur = new Compania(PRECIO_EDESUR, IMP_EDESUR, IMP_EDESUR_DOBLE, servicios);

		edesur.recibirJugador(jugador);

		int plataFinal = jugador.getCapital();

		Assert.assertEquals((100000 - PRECIO_EDESUR), plataFinal);
		Assert.assertTrue(edesur.soyTuDueño(jugador));
	}

	@Test
	public void test03JugadorCaeEnEdesurAdquiridaPorOtroJugadorQueNoEsDueñoDeAysaSuDineroSeReduce500PorLosDados() {
		Servicios servicios = new Servicios();
		Compania edesur = new Compania(PRECIO_EDESUR, IMP_EDESUR, IMP_EDESUR_DOBLE, servicios);

		Jugador jugador = new Jugador();
		edesur.recibirJugador(jugador); // jugador compra edesur

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		edesur.recibirJugador(otroJugador); // otro jugador cae en edesur

		int plataFinal = otroJugador.getCapital();
		Assert.assertEquals((100000 - (IMP_EDESUR * otroJugador.getUltimaTirada())), plataFinal);
	}

	@Test
	public void test04JugadorCaeEnEdesurAdquiridaPorOtroJugadorQueEsDueñoDeAysaSuDineroSeReduce1000PorLosDados() {
		Servicios servicios = new Servicios();
		Compania edesur = new Compania(PRECIO_EDESUR, IMP_EDESUR, IMP_EDESUR_DOBLE, servicios);
		Compania aysa = new Compania(PRECIO_AYSA, IMP_AYSA, IMP_AYSA_DOBLE, servicios);

		Jugador jugador = new Jugador();
		edesur.recibirJugador(jugador); // jugador compra edesur
		aysa.recibirJugador(jugador); // jugador compra aysa

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		edesur.recibirJugador(otroJugador); // otro jugador cae en edesur

		int plataFinal = otroJugador.getCapital();
		Assert.assertEquals((100000 - (IMP_EDESUR_DOBLE * otroJugador.getUltimaTirada())), plataFinal);
	}

	@Test
	public void test05JugadorCaeEnEdesurAdquiridaPorSiMismoSuDineroNoSeReduce() {
		Servicios servicios = new Servicios();
		Compania edesur = new Compania(PRECIO_EDESUR, IMP_EDESUR, IMP_EDESUR_DOBLE, servicios);
		Compania aysa = new Compania(PRECIO_AYSA, IMP_AYSA, IMP_AYSA_DOBLE, servicios);

		Jugador jugador = new Jugador();
		edesur.recibirJugador(jugador); // jugador compra edesur
		aysa.recibirJugador(jugador); // jugador compra aysa

		int plataInicial = jugador.getCapital();
		jugador.tirar();
		jugador.caerEnCasillero(edesur);
		int plataFinal = jugador.getCapital();

		Assert.assertEquals(plataInicial, plataFinal);
	}

	@Test
	public void test06JugadorCaeEnAysaAdquiridaPorSiMismoSuDineroNoSeReduce() {
		Servicios servicios = new Servicios();
		Compania edesur = new Compania(PRECIO_EDESUR, IMP_EDESUR, IMP_EDESUR_DOBLE, servicios);
		Compania aysa = new Compania(PRECIO_AYSA, IMP_AYSA, IMP_AYSA_DOBLE, servicios);

		Jugador jugador = new Jugador();
		edesur.recibirJugador(jugador); // jugador compra edesur
		aysa.recibirJugador(jugador); // jugador compra aysa

		int plataInicial = jugador.getCapital();
		jugador.tirar();
		aysa.recibirJugador(jugador);
		int plataFinal = jugador.getCapital();

		Assert.assertEquals(plataInicial, plataFinal);
	}

	@Test
	public void test07JugadorCaeEnAysaAdquiridaPorOtroJugadorQueNoEsDueñoDeEdesurSuDineroSeReduce300PorDados() {
		Servicios servicios = new Servicios();
		Compania aysa = new Compania(PRECIO_AYSA, IMP_AYSA, IMP_AYSA_DOBLE, servicios);

		Jugador jugador = new Jugador();
		aysa.recibirJugador(jugador); // jugador compra aysa

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		aysa.recibirJugador(otroJugador);
		int plataFinal = otroJugador.getCapital();

		Assert.assertEquals(100000 - (IMP_AYSA * otroJugador.getUltimaTirada()), plataFinal);
	}

	@Test
	public void test08JugadorCaeEnAysaAdquiridaPorOtroJugadorQueEsDueñoDeEdesurSuDineroSeReduce500PorDados() {
		Servicios servicios = new Servicios();
		Compania edesur = new Compania(PRECIO_EDESUR, IMP_EDESUR, IMP_EDESUR_DOBLE, servicios);
		Compania aysa = new Compania(PRECIO_AYSA, IMP_AYSA, IMP_AYSA_DOBLE, servicios);

		Jugador jugador = new Jugador();
		edesur.recibirJugador(jugador); // jugador compra edesur
		aysa.recibirJugador(jugador); // jugador compra aysa

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		aysa.recibirJugador(otroJugador);
		int plataFinal = otroJugador.getCapital();

		Assert.assertEquals(100000 - (IMP_AYSA_DOBLE * otroJugador.getUltimaTirada()), plataFinal);
	}

}

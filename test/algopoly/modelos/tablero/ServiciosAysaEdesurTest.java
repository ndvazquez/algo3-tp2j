package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.compania.Aysa;
import algopoly.modelos.tablero.casilleros.compania.Compania;
import algopoly.modelos.tablero.casilleros.compania.Edesur;

import org.junit.Assert;
import org.junit.Test;

public class ServiciosAysaEdesurTest {

	private static final Integer PRECIO_EDESUR = 35000;
	private static final Integer IMP_EDESUR = 500;
	private static final Integer IMP_EDESUR_DOBLE = 1000;

	private static final Integer PRECIO_AYSA = 30000;
	private static final Integer IMP_AYSA = 300;
	private static final Integer IMP_AYSA_DOBLE = 500;

	/** Tests 16 - 17 segunda entrega **/
	@Test
	public void test01JugadorCaeEnAysaYAhoraTiene30000PesosMenos() {
		Jugador jugador = new Jugador();

		Compania aysa = new Aysa();

		aysa.recibirJugador(jugador);

		int plataFinal = jugador.getCapital();

		Assert.assertEquals((100000 - PRECIO_AYSA), plataFinal);
		Assert.assertTrue(aysa.soyTuDuenio(jugador));
	}

	@Test
	public void test02JugadorCaeEnEdesurYAhoraTiene35000PesosMenos() {
		Jugador jugador = new Jugador();

		Compania edesur = new Edesur();

		edesur.recibirJugador(jugador);

		int plataFinal = jugador.getCapital();

		Assert.assertEquals((100000 - PRECIO_EDESUR), plataFinal);
		Assert.assertTrue(edesur.soyTuDuenio(jugador));
	}

	@Test
	public void test03JugadorCaeEnEdesurAdquiridaPorOtroJugadorQueNoEsDuenioDeAysaSuDineroSeReduce500PorLosDados() {
		Compania edesur = new Edesur();

		Jugador jugador = new Jugador();
		edesur.recibirJugador(jugador); // jugador compra edesur

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		edesur.recibirJugador(otroJugador); // otro jugador cae en edesur

		int plataFinal = otroJugador.getCapital();
		Assert.assertEquals((100000 - (IMP_EDESUR * otroJugador.getUltimaTirada())), plataFinal);
	}

	@Test
	public void test04JugadorCaeEnEdesurAdquiridaPorOtroJugadorQueEsDuenioDeAysaSuDineroSeReduce1000PorLosDados() {
		Compania edesur = new Edesur();
		Compania aysa = new Aysa();
		edesur.setCompaniaPar(aysa);
		aysa.setCompaniaPar(edesur);
		
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
		Compania edesur = new Edesur();
		Compania aysa = new Aysa();
		edesur.setCompaniaPar(aysa);
		aysa.setCompaniaPar(edesur);
		
		Jugador jugador = new Jugador();
		edesur.recibirJugador(jugador); // jugador compra edesur
		aysa.recibirJugador(jugador); // jugador compra aysa

		int plataInicial = jugador.getCapital();
		jugador.tirar();
		edesur.recibirJugador(jugador);
		int plataFinal = jugador.getCapital();

		Assert.assertEquals(plataInicial, plataFinal);
	}

	@Test
	public void test06JugadorCaeEnAysaAdquiridaPorSiMismoSuDineroNoSeReduce() {
		Compania edesur = new Edesur();
		Compania aysa = new Aysa();
		edesur.setCompaniaPar(aysa);
		aysa.setCompaniaPar(edesur);
		
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
	public void test07JugadorCaeEnAysaAdquiridaPorOtroJugadorQueNoEsDuenioDeEdesurSuDineroSeReduce300PorDados() {
		Compania aysa = new Aysa();

		Jugador jugador = new Jugador();
		aysa.recibirJugador(jugador); // jugador compra aysa

		Jugador otroJugador = new Jugador();
		otroJugador.tirar();
		aysa.recibirJugador(otroJugador);
		int plataFinal = otroJugador.getCapital();

		Assert.assertEquals(100000 - (IMP_AYSA * otroJugador.getUltimaTirada()), plataFinal);
	}

	@Test
	public void test08JugadorCaeEnAysaAdquiridaPorOtroJugadorQueEsDuenioDeEdesurSuDineroSeReduce500PorDados() {
		Compania edesur = new Edesur();
		Compania aysa = new Aysa();
		edesur.setCompaniaPar(aysa);
		aysa.setCompaniaPar(edesur);
		
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

package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.propiedad.Cte;
import algopoly.modelos.propiedad.PropiedadSimple;

import org.junit.Assert;
import org.junit.Test;


public class PropiedadSimpleTest {
	
	@Test
	public void test01jugadorCaeEnUnaPropiedadSimpleYSeConvierteEnPropietario() {

		Jugador jugador = new Jugador();
		PropiedadSimple propiedadSimple = new PropiedadSimple(0, 0);

		propiedadSimple.recibirJugador(jugador);

		int cantidadPropiedades = jugador.getCantidadPropiedades();

		Assert.assertEquals(cantidadPropiedades, 1);
		Assert.assertEquals(propiedadSimple.getPropietario(), jugador);
	}

	@Test
	public void test02jugadorConstruyeCasaEnPropiedadSimple() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple neuquen = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		neuquen.recibirJugador(jugadorPrueba);

		jugadorPrueba.comprarCasa(neuquen);

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(78200, capital);
	}
	
	@Test
	public void test03jugadorCaeEnPropiedadDeOtroJugadorYPagaAlquielerSimple() {
		
		Jugador jugador1 = new Jugador();
		PropiedadSimple neuquen = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		neuquen.recibirJugador(jugador1);

		Jugador jugador2 = new Jugador();
		neuquen.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(84800 , capital1); // +1800
		Assert.assertEquals(98200 , capital2); // -1800
	}
	
	@Test
	public void test04jugadorCaeEnPropiedadDeOtroJugadorConCasaYPagaAlquielerConCasa() {
		
		Jugador jugador1 = new Jugador();
		PropiedadSimple neuquen = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		neuquen.recibirJugador(jugador1);
		jugador1.comprarCasa(neuquen);

		Jugador jugador2 = new Jugador();
		neuquen.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(82000 , capital1); // +4800
		Assert.assertEquals(96200 , capital2); // -4800
	}
	
	@Test
	public void test05jugadorNoPuedeComprarMasDeUnaConstruccion() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple neuquen = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		neuquen.recibirJugador(jugadorPrueba);
		jugadorPrueba.comprarCasa(neuquen);
		jugadorPrueba.comprarCasa(neuquen);
		
		int capital = jugadorPrueba.getCapital();
		
		Assert.assertEquals(78200, capital);
	}
	
	
}


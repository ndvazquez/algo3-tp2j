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

		jugadorPrueba.comprarConstruccion(neuquen);

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

		Assert.assertEquals(83000 , capital1); // +1800 = 84800
		Assert.assertEquals(100000 , capital2); // -1800 = 98200
	}
	
	@Test
	public void test04jugadorCaeEnPropiedadDeOtroJugadorConCasaYPagaAlquielerConCasa() {
		
		Jugador jugador1 = new Jugador();
		PropiedadSimple neuquen = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		neuquen.recibirJugador(jugador1);
		jugador1.comprarConstruccion(neuquen);

		Jugador jugador2 = new Jugador();
		neuquen.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(78200 , capital1); // +4800 = 82000
		Assert.assertEquals(100000 , capital2); // -4800 = 96200
	}
	
	@Test
	public void test05jugadorNoPuedeComprarMasDeUnaConstruccion() {
		
		Jugador jugador = new Jugador();
		PropiedadSimple propiedadSimple = new PropiedadSimple(0, 0);

		propiedadSimple.recibirJugador(jugador);
		
		propiedadSimple.construir(); // 1 casa
		
		Assert.assertFalse(propiedadSimple.construir()); // no puede construir 2 veces
	}
	
	
}


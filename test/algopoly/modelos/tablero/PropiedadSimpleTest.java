package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.propiedad.Cte;
import algopoly.modelos.propiedad.PropiedadSimple;

import org.junit.Assert;
import org.junit.Test;


public class PropiedadSimpleTest {
	
	
	@Test
	public void test01jugadorCaeEnUnaPropiedadSimpleYSeConvierteEnPropietario() {

		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedadSimple = new PropiedadSimple(0, 0);

		propiedadSimple.recibirJugador(jugadorPrueba);

		int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();

		Assert.assertEquals(cantidadPropiedades, 1);
		Assert.assertEquals(propiedadSimple.getPropietario(), jugadorPrueba);
	}
	
	@Test
	public void test02jugadorCaeEnNeuquenYCompra() {

		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		propiedad.recibirJugador(jugadorPrueba);
		
		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(83000, capital);
	}
	/*
	@Test
	public void test03jugadorConstruyeCasaEnNeuquen() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		propiedad.recibirJugador(jugadorPrueba);

		jugadorPrueba.comprarCasa(propiedad);

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(78200, capital);
	}
	
	@Test
	public void test04jugadorCaeEnNeuquenDeOtroJugadorYPagaAlquieler() {
		
		Jugador jugador1 = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		propiedad.recibirJugador(jugador1);

		Jugador jugador2 = new Jugador();
		propiedad.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(84800 , capital1); // +1800
		Assert.assertEquals(98200 , capital2); // -1800
	}
	
	@Test
	public void test05jugadorCaeEnNeuquenDeOtroJugadorConCasaYPagaAlquieler() {
		Jugador jugador1 = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		propiedad.recibirJugador(jugador1);
		jugador1.comprarCasa(propiedad);

		Jugador jugador2 = new Jugador();
		propiedad.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(82000 , capital1); // +4800
		Assert.assertEquals(96200 , capital2); // -4800
	}
	
	@Test
	public void test06jugadorNoPuedeComprarMasDeUnaConstruccionEnNeuquen() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.NEUQUEN, Cte.NEUQUEN_CASA);

		propiedad.recibirJugador(jugadorPrueba);
		jugadorPrueba.comprarCasa(propiedad);
		jugadorPrueba.comprarCasa(propiedad); // -0
		
		int capital = jugadorPrueba.getCapital();
		
		Assert.assertEquals(78200, capital);
	}
	
	@Test
	public void test07jugadorCaeEnSantaFeYCompra() {

		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.SANTA_FE, Cte.SANTA_FE_CASA);

		propiedad.recibirJugador(jugadorPrueba);
		
		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(85000, capital);
	}
	@Test
	public void test08jugadorConstruyeCasaEnSantaFe() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.SANTA_FE, Cte.SANTA_FE_CASA);

		propiedad.recibirJugador(jugadorPrueba);

		jugadorPrueba.comprarCasa(propiedad);

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(81000, capital);
	}
	/*
	@Test
	public void test09jugadorCaeEnSantaFeDeOtroJugadorYPagaAlquieler() {
		
		Jugador jugador1 = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.SANTA_FE, Cte.SANTA_FE_CASA);

		propiedad.recibirJugador(jugador1);

		Jugador jugador2 = new Jugador();
		propiedad.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(82500 , capital1); // +1500
		Assert.assertEquals(98500 , capital2); // -1500
	}
	
	@Test
	public void test10jugadorCaeEnSantaFeDeOtroJugadorConCasaYPagaAlquieler() {
		Jugador jugador1 = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.SANTA_FE, Cte.SANTA_FE);

		propiedad.recibirJugador(jugador1);
		jugador1.comprarCasa(propiedad);

		Jugador jugador2 = new Jugador();
		propiedad.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(84500 , capital1); // 3500
		Assert.assertEquals(96500 , capital2); // -3500
	}

	@Test
	public void test11jugadorNoPuedeComprarMasDeUnaConstruccionEnSantaFe() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Cte.SANTA_FE, Cte.SANTA_FE_CASA);

		propiedad.recibirJugador(jugadorPrueba);
		jugadorPrueba.comprarCasa(propiedad);
		jugadorPrueba.comprarCasa(propiedad); // -0
		
		int capital = jugadorPrueba.getCapital();
		
		Assert.assertEquals(81000, capital);
	}
	*/
}


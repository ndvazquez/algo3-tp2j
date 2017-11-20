package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.propiedad.PropiedadSimple;
import algopoly.modelos.propiedad.Provincia;

import org.junit.Assert;
import org.junit.Test;


public class PropiedadSimpleTest {
	
	
	@Test
	public void test01jugadorCaeEnUnaPropiedadSimpleYSeConvierteEnPropietario() {

		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugadorPrueba);

		int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();

		Assert.assertEquals(cantidadPropiedades, 1);
		Assert.assertEquals(propiedad.getPropietario(), jugadorPrueba);
	}
	
	@Test
	public void test02jugadorCaeEnNeuquenYCompra() {

		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugadorPrueba);
		
		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(83000, capital);
	}
	
	@Test
	public void test03jugadorConstruyeCasaEnNeuquen() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugadorPrueba);

		propiedad.construir();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(78200, capital);
	}
	
	@Test
	public void test04jugadorCaeEnNeuquenDeOtroJugadorYPagaAlquieler() {
		
		Jugador jugador1 = new Jugador();
		PropiedadSimple propiedad = new PropiedadSimple(Provincia.NEUQUEN);

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
		PropiedadSimple propiedad = new PropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugador1);
		propiedad.construir();

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
		PropiedadSimple propiedad = new PropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugadorPrueba);
		propiedad.construir();
		propiedad.construir(); // -0
		
		int capital = jugadorPrueba.getCapital();
		
		Assert.assertEquals(78200, capital);
	}
}


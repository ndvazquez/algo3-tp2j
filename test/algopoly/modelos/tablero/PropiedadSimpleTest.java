package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.propiedad.PropiedadFactory;
import algopoly.modelos.tablero.propiedad.PropiedadSimple;
import algopoly.modelos.tablero.propiedad.Provincia;

import org.junit.Assert;
import org.junit.Test;


public class PropiedadSimpleTest {
	
	
	@Test
	public void test01JugadorCaeEnUnaPropiedadSimpleYSeConvierteEnPropietario() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = propiedadFactory.crearPropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugadorPrueba);

		int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();
        int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(cantidadPropiedades, 1);
		Assert.assertEquals(propiedad.getPropietario(), jugadorPrueba);
        Assert.assertEquals(83000, capital);
	}
	
	@Test
	public void test02JugadorConstruyeCasaEnNeuquen() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = propiedadFactory.crearPropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugadorPrueba);

		propiedad.construirCasa();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(78200, capital);
	}
	
	@Test
	public void test03JugadorCaeEnNeuquenDeOtroJugadorYPagaAlquiler() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugador1 = new Jugador();
		PropiedadSimple propiedad = propiedadFactory.crearPropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugador1);

		Jugador jugador2 = new Jugador();
		propiedad.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(84800 , capital1); // +1800
		Assert.assertEquals(98200 , capital2); // -1800
	}
	
	@Test
	public void test04JugadorCaeEnNeuquenDeOtroJugadorConCasaYPagaAlquiler() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugador1 = new Jugador();
		PropiedadSimple propiedad = propiedadFactory.crearPropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugador1);
		propiedad.construirCasa();

		Jugador jugador2 = new Jugador();
		propiedad.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(82000 , capital1); // +4800
		Assert.assertEquals(96200 , capital2); // -4800
	}

	@Test
	public void test05JugadorNoPuedeComprarMasDeUnaConstruccionEnNeuquen() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorPrueba = new Jugador();
		PropiedadSimple propiedad = propiedadFactory.crearPropiedadSimple(Provincia.NEUQUEN);

		propiedad.recibirJugador(jugadorPrueba);
		propiedad.construirCasa();
		propiedad.construirCasa(); // -0
		
		int capital = jugadorPrueba.getCapital();
		
		Assert.assertEquals(78200, capital);
	}
	
	@Test
	public void test06JugadorIntercambiaPropiedadSimpleConOtroLuegoUnTercerJugadorCaeEnDichaPropiedadYElAlquilerVaAlNuevoPropietario() {
		
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		PropiedadSimple neuquen = propiedadFactory.crearPropiedadSimple(Provincia.NEUQUEN);
		PropiedadSimple santaFe = propiedadFactory.crearPropiedadSimple(Provincia.SANTA_FE);
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		
		neuquen.recibirJugador(jugador1);
		santaFe.recibirJugador(jugador2);
		
		Integer capitalInicialJugador1 = jugador1.getCapital();
		
		jugador1.intercambiarPropiedad(neuquen, santaFe, jugador2);
		
		santaFe.recibirJugador(jugador3);
		
		Integer capitalFinalJugador1 = jugador1.getCapital();
		Integer alquilerSantaFe = santaFe.getPrecioAlquiler();
		
		Assert.assertEquals(capitalFinalJugador1.intValue(), capitalInicialJugador1 + alquilerSantaFe);
	}
	
	@Test
	public void test07JugadorVendePropiedadSimpleLuegoOtroJugadorPuedeComprarla() {
		
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		PropiedadSimple neuquen = propiedadFactory.crearPropiedadSimple(Provincia.NEUQUEN);
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		neuquen.recibirJugador(jugador1);
		
		jugador1.venderPropiedad(neuquen);
		
		neuquen.recibirJugador(jugador2);
		
		Jugador propietarioDeNeuquen = neuquen.getPropietario();
		
		Assert.assertEquals(propietarioDeNeuquen, jugador2);
	}
}


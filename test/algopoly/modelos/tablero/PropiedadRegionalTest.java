package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.propiedad.PropiedadFactory;
import algopoly.modelos.tablero.propiedad.PropiedadRegional;
import algopoly.modelos.tablero.propiedad.Provincia;

import org.junit.Assert;
import org.junit.Test;

public class PropiedadRegionalTest {

	@Test
	public void test01JugadorCaeEnUnaPropiedadRegionalYSeVuelvePropietario(){
		PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador();
        PropiedadRegional propiedadSimple = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);

        propiedadSimple.recibirJugador(jugadorPrueba);

        int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();
		int capital = jugadorPrueba.getCapital();

        Assert.assertEquals(cantidadPropiedades, 1);
        Assert.assertEquals(propiedadSimple.getPropietario(), jugadorPrueba);
		Assert.assertEquals(80000, capital);
    }
	
	@Test
	public void test02JugadorConstruyeCasa() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugadorPrueba);
		propiedad2.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(50000, capital);
	}
	
	@Test
	public void test03JugadorConstruyeDosCasas() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugadorPrueba);
		propiedad2.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();
		propiedad1.construirCasa();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(45000, capital);
	}
	
	@Test
	public void test04JugadorConstruyeHotel() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugadorPrueba);
		propiedad2.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();
		propiedad1.construirCasa();
		
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		
		propiedad1.construirHotel();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(26000, capital);
	}
	
	@Test
	public void test05JugadorNoPuedeComprarCasaSinPropiedadRegionalCompleta() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		
		propiedad1.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();

		int capital = jugadorPrueba.getCapital();
		int cant = propiedad1.cantidadEdificios();

		Assert.assertEquals(0, cant);
		Assert.assertEquals(80000, capital);
	}
	
	@Test
	public void test06JugadorCaeEnPropiedadDeOtroJugadorYPagaAlquiler() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PropiedadRegional propiedad = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);

		propiedad.recibirJugador(jugador1);
		propiedad.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(82000 , capital1); 
		Assert.assertEquals(98000 , capital2); 
	}
	
	@Test
	public void test07JugadorCaeEnPropiedadDeOtroJugadorConCasaYPagaAlquiler() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugador1);
		propiedad2.recibirJugador(jugador1);

		propiedad1.construirCasa();
		propiedad1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();
		int cant = propiedad1.cantidadEdificios();

		Assert.assertEquals(1, cant);

		Assert.assertEquals(53000, capital1);
		Assert.assertEquals(97000, capital2);
	}

	@Test
	public void test08JugadorCaeEnPropiedadDeOtroJugadorConDosCasasYPagaAlquiler() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugador1);
		propiedad2.recibirJugador(jugador1);

		propiedad1.construirCasa();
		propiedad1.construirCasa();
		
		propiedad1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();
		int cant = propiedad1.cantidadEdificios();

		Assert.assertEquals(2, cant);

		Assert.assertEquals(48500, capital1);
		Assert.assertEquals(96500, capital2);
	}
	
	@Test
	public void test09JugadorCaeEnPropiedadDeOtroJugadorConHotelYPagaAlquiler() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugador1);
		propiedad2.recibirJugador(jugador1);

		propiedad1.construirCasa();
		propiedad1.construirCasa();
		
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		
		int cant1 = propiedad1.cantidadEdificios();
		int cant2 = propiedad2.cantidadEdificios();
		
		propiedad1.construirHotel();
		
		propiedad1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(2, cant1);
		Assert.assertEquals(2, cant2);

		Assert.assertEquals(31000, capital1);
		Assert.assertEquals(95000, capital2);
	}

	@Test
	public void test10JugadorNoPuedeComprarHotelSinDosCasas() {
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugadorPrueba);
		propiedad2.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();
		propiedad1.construirHotel();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(50000, capital);
	}

    @Test
    public void test11JugadorConstruyeHotelTeniendoUnoCompradoEnLaOtraProvinciaYSuCapitalNoSeReduce() {
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador();
        PropiedadRegional propiedad1 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
        PropiedadRegional propiedad2 = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);

        propiedad1.recibirJugador(jugadorPrueba);
        propiedad2.recibirJugador(jugadorPrueba);

        propiedad1.construirCasa();
        propiedad1.construirCasa();

        propiedad2.construirCasa();
        propiedad2.construirCasa();

        propiedad1.construirHotel();
        propiedad2.construirHotel();

        int capital = jugadorPrueba.getCapital();

        Assert.assertEquals(26000, capital);
    }
}

package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.propiedad.PropiedadRegional;
import algopoly.modelos.propiedad.Provincia;
import algopoly.modelos.propiedad.Region;

import org.junit.Assert;
import org.junit.Test;

public class PropiedadRegionalTest {

	@Test
	public void test01UnJugadorCaeEnUnaPropiedadRegionalYSeVuelvePropietario(){
        Region region = new Region();
        Jugador jugadorPrueba = new Jugador();
        PropiedadRegional propiedadSimple = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);

        propiedadSimple.recibirJugador(jugadorPrueba);

        int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();

        Assert.assertEquals(cantidadPropiedades, 1);
        Assert.assertEquals(propiedadSimple.getPropietario(), jugadorPrueba);
    }
	
	@Test
	public void test02jugadorCaeEnPropiedadYCompra() {

		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);

		propiedad.recibirJugador(jugadorPrueba);
		
		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(80000, capital);
	}
	
	@Test
	public void test03jugadorConstruyeCasa() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = new PropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugadorPrueba);
		propiedad2.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(50000, capital);
	}
	
	@Test
	public void test04jugadorConstruyeDosCasa() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = new PropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugadorPrueba);
		propiedad2.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();
		propiedad1.construirCasa();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(45000, capital);
	}
	
	@Test
	public void test05jugadorConstruyeHotel() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = new PropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
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
	public void test06jugadorNoPuedeComprarCasaSinPropiedadRegionalCompleta() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		
		propiedad1.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();

		int capital = jugadorPrueba.getCapital();
		int cant = propiedad1.cantidadEdificios();

		//Assert.assertEquals(80000, capital); 
		
		//Assert.assertEquals(0, cant);
	}
	
	@Test
	public void test07jugadorCaeEnPropiedadDeOtroJugadorYPagaAlquieler() {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PropiedadRegional propiedad = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);

		propiedad.recibirJugador(jugador1);
		propiedad.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(82000 , capital1); 
		Assert.assertEquals(98000 , capital2); 
	}
	
	@Test
	public void test08jugadorCaeEnPropiedadDeOtroJugadorConCasaYPagaAlquieler() {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PropiedadRegional propiedad1 = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = new PropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugador1);
		propiedad2.recibirJugador(jugador1);

		propiedad1.construirCasa();
		propiedad1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(53000, capital1);
		Assert.assertEquals(97000, capital2);
	}

	@Test
	public void test09jugadorCaeEnPropiedadDeOtroJugadorConDosCasaYPagaAlquieler() {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PropiedadRegional propiedad1 = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = new PropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugador1);
		propiedad2.recibirJugador(jugador1);

		propiedad1.construirCasa();
		propiedad1.construirCasa();
		
		propiedad1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(48500, capital1);
		Assert.assertEquals(96500, capital2);
	}
	
	@Test
	public void test10jugadorCaeEnPropiedadDeOtroJugadorConHotelYPagaAlquieler() {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PropiedadRegional propiedad1 = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = new PropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugador1);
		propiedad2.recibirJugador(jugador1);

		propiedad1.construirCasa();
		propiedad1.construirCasa();
		
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		
		propiedad1.construirHotel();
		
		propiedad1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(31000, capital1);
		Assert.assertEquals(95000, capital2);
	}

	@Test
	public void test11jugadorNoPuedeComprarHotelSinDosCasas() {
		
		Jugador jugadorPrueba = new Jugador();
		PropiedadRegional propiedad1 = new PropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		PropiedadRegional propiedad2 = new PropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		propiedad1.recibirJugador(jugadorPrueba);
		propiedad2.recibirJugador(jugadorPrueba);

		propiedad1.construirCasa();
		propiedad1.construirHotel();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(50000, capital);
	}
	
}

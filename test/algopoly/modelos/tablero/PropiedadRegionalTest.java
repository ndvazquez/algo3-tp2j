package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.propiedad.Cte;
import algopoly.modelos.propiedad.PropiedadRegional;
import algopoly.modelos.propiedad.Region;

import org.junit.Assert;
import org.junit.Test;

public class PropiedadRegionalTest {

	@Test
	public void test01UnJugadorCaeEnUnaPropiedadRegionalYSeVuelvePropietario(){
        Region region = new Region();
        Jugador jugadorPrueba = new Jugador();
        PropiedadRegional propiedadSimple = new PropiedadRegional(0, region, 0, 0);

        propiedadSimple.recibirJugador(jugadorPrueba);

        int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();

        Assert.assertEquals(cantidadPropiedades, 1);
        Assert.assertEquals(propiedadSimple.getPropietario(), jugadorPrueba);
    }
	/*
	@Test
	public void test02JugadorPoseePropiedadRegionalYConstruyeUnaCasa() {

		Jugador jugadorPrueba = new Jugador();
		Region regionSur = new Region();
		Region regionNorte = new Region();

		PropiedadRegional bsAsSur = new PropiedadRegional(20000, regionSur, 5000, 8000);
		PropiedadRegional bsAsNorte = new PropiedadRegional(25000, regionNorte, 5500, 9000);

		bsAsSur.recibirJugador(jugadorPrueba);
		bsAsNorte.recibirJugador(jugadorPrueba);

		jugadorPrueba.comprarCasa(bsAsSur);

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(50000, capital);
	}

	@Test
	public void test03JugadorPoseeCasaEnPropiedadYCobraAlquielerAJugador2() {

		Jugador jugador1 = new Jugador();
		Region regionSur = new Region();
		Region regionNorte = new Region();

		PropiedadRegional bsAsSur = new PropiedadRegional(Cte.BSAS_SUR, regionSur, Cte.BSAS_SUR_CASA, Cte.BSAS_SUR_HOTEL);
		PropiedadRegional bsAsNorte = new PropiedadRegional(Cte.BSAS_NORTE, regionNorte, Cte.BSAS_NORTE_CASA, Cte.BSAS_NORTE_HOTEL);

		bsAsSur.recibirJugador(jugador1);
		bsAsNorte.recibirJugador(jugador1);

		jugador1.comprarCasa(bsAsSur);
		jugador1.comprarCasa(bsAsNorte);

		Jugador jugador2 = new Jugador();
		bsAsSur.recibirJugador(jugador2);

		int capital = jugador2.getCapital();
		
		Assert.assertEquals(97000, capital);
	}

	@Test
	public void test04JugadorPoseePropiedadRegionalYConstruyeDosCasa() {

		Jugador jugadorPrueba = new Jugador();
		Region regionSur = new Region();
		Region regionNorte = new Region();

		PropiedadRegional bsAsSur = new PropiedadRegional(20000, regionSur, 5000, 8000);
		PropiedadRegional bsAsNorte = new PropiedadRegional(25000, regionNorte, 5500, 9000);

		bsAsSur.recibirJugador(jugadorPrueba);
		bsAsNorte.recibirJugador(jugadorPrueba);

		jugadorPrueba.comprarCasa(bsAsSur);
		jugadorPrueba.comprarCasa(bsAsSur);
		jugadorPrueba.comprarCasa(bsAsNorte);
		jugadorPrueba.comprarCasa(bsAsNorte);
		
		int capital = jugadorPrueba.getCapital();
		
		Assert.assertEquals(34000, capital);
	}

	@Test
	public void test05JugadorPoseePropiedadRegionalYConstruyeHotel() {

		Jugador jugadorPrueba = new Jugador();
		Region regionSur = new Region();
		Region regionNorte = new Region();

		PropiedadRegional bsAsSur = new PropiedadRegional(20000, regionSur, 5000, 8000);
		PropiedadRegional bsAsNorte = new PropiedadRegional(25000, regionNorte, 5500, 9000);

		bsAsSur.recibirJugador(jugadorPrueba);
		bsAsNorte.recibirJugador(jugadorPrueba);

		jugadorPrueba.comprarCasa(bsAsSur);
		jugadorPrueba.comprarCasa(bsAsSur);
		jugadorPrueba.comprarCasa(bsAsNorte);
		jugadorPrueba.comprarCasa(bsAsNorte);

		jugadorPrueba.comprarHotel(bsAsSur);

		int capital = jugadorPrueba.getCapital();

		//Assert.assertEquals(1, surHotel);
		//Assert.assertEquals(2, norteCasas);
		Assert.assertEquals(29000, capital);
	}

	@Test
	public void test06JugadorPoseePropiedadRegionalYNoPuedeConstruirHotel() {

		Jugador jugadorPrueba = new Jugador();
		Region regionSur = new Region();
		Region regionNorte = new Region();
		
		PropiedadRegional bsAsSur = new PropiedadRegional(20000, regionSur, 5000, 8000);
		PropiedadRegional bsAsNorte = new PropiedadRegional(25000, regionNorte, 5500, 9000);

		bsAsSur.recibirJugador(jugadorPrueba);
		bsAsNorte.recibirJugador(jugadorPrueba);

		jugadorPrueba.comprarCasa(bsAsSur);
		jugadorPrueba.comprarHotel(bsAsSur);

		int capital = jugadorPrueba.getCapital();

		//Assert.assertEquals(1, surCasas);
		//Assert.assertEquals(0, norteCasas);
		Assert.assertEquals(50000, capital); // no compro hotel
	}

	@Test
	public void test07JugadorNoPoseePropiedadRegionalYNoPuedeConstruirCasa() {

		Jugador jugadorPrueba = new Jugador();
		Region regionSur = new Region();
		PropiedadRegional bsAsSur = new PropiedadRegional(20000, regionSur, 5000, 8000);

		bsAsSur.recibirJugador(jugadorPrueba);
		jugadorPrueba.comprarCasa(bsAsSur);

		int capital = jugadorPrueba.getCapital();

		// assert que no puede construir
		Assert.assertEquals(50000, capital); // no compro hotel
	}
	*/
}

package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class PropiedadRegionalTest {
	
	@Test
    public void test01UnJugadorCaeEnUnaPropiedadRegionalYSeVuelvePropietario(){
        Region region = new Region(Region.ZONASUR);
        Jugador jugadorPrueba = new Jugador();
        PropiedadRegional propiedadSimple = new PropiedadRegional(0, region);


        propiedadSimple.recibirJugador(jugadorPrueba);

        int cantidadPropiedades = jugadorPrueba.getCantidadPropiedades();

        Assert.assertEquals(cantidadPropiedades, 1);
        Assert.assertEquals(propiedadSimple.getPropietario(), jugadorPrueba);
    }
	
	@Test
	public void test02JugadorPoseePropiedadRegionalYConstruyeUnaCasa() {
		
		Jugador jugadorPrueba = new Jugador();
		Region regionSur = new Region(Region.ZONASUR);
		Region regionNorte = new Region(Region.ZONANORTE);
		
		PropiedadRegional bsAsSur = new PropiedadRegional(20000, regionSur, 5000, 8000);
		PropiedadRegional bsAsNorte = new PropiedadRegional(25000, regionNorte, 5500, 9000);
		
		bsAsSur.recibirJugador(jugadorPrueba);
		bsAsNorte.recibirJugador(jugadorPrueba);
		
		jugadorPrueba.comprarConstruccion(bsAsSur);

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(50000, capital);
	}
	
	@Test
	public void test03JugadorPoseeCasaEnPropiedadYCobraAlquielerAJugador2() {
		
		Jugador jugador1 = new Jugador();
		Region regionSur = new Region(Region.ZONASUR);
		Region regionNorte = new Region(Region.ZONANORTE);
		
		PropiedadRegional bsAsSur = new PropiedadRegional(Cte.BSAS_SUR, regionSur, Cte.BSAS_SUR_CASA, Cte.BSAS_SUR_HOTEL);
		PropiedadRegional bsAsNorte = new PropiedadRegional(Cte.BSAS_NORTE, regionNorte, Cte.BSAS_NORTE_CASA, Cte.BSAS_NORTE_HOTEL);
		
		bsAsSur.recibirJugador(jugador1);
		bsAsNorte.recibirJugador(jugador1);
		
		jugador1.comprarConstruccion(bsAsSur);
		jugador1.comprarConstruccion(bsAsNorte);
		
		Jugador jugador2 = new Jugador();
		bsAsSur.recibirJugador(jugador2);
		
		int capital = jugador2.getCapital();

		Assert.assertEquals(98000, capital);
	}
}

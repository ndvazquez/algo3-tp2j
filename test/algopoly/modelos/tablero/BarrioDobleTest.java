package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.barrios.BarrioDoble;
import algopoly.modelos.tablero.casilleros.barrios.BarrioFactory;
import algopoly.modelos.tablero.casilleros.barrios.Provincia;

import org.junit.Assert;
import org.junit.Test;

public class BarrioDobleTest {

	@Test
	public void test01JugadorCaeEnUnaPropiedadRegionalYSeVuelvePropietario(){
		BarrioFactory barrioFactory = new BarrioFactory();
        Jugador jugadorPrueba = new Jugador();
        BarrioDoble barrio = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);

        barrio.recibirJugador(jugadorPrueba);

        int cantidadPropiedades = jugadorPrueba.getCantidadBarrios();
		int capital = jugadorPrueba.getCapital();

        Assert.assertEquals(cantidadPropiedades, 1);
        Assert.assertEquals(barrio.getPropietario(), jugadorPrueba);
		Assert.assertEquals(80000, capital);
    }
	
	@Test
	public void test02JugadorConstruyeCasa() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugadorPrueba = new Jugador();
		BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		BarrioDoble barrio2 = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		barrio1.recibirJugador(jugadorPrueba);
		barrio2.recibirJugador(jugadorPrueba);

		barrio1.construirCasa();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(50000, capital);
	}
	
	@Test
	public void test03JugadorConstruyeDosCasas() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugadorPrueba = new Jugador();
		BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		BarrioDoble barrio2 = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		barrio1.recibirJugador(jugadorPrueba);
		barrio2.recibirJugador(jugadorPrueba);

		barrio1.construirCasa();
		barrio1.construirCasa();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(45000, capital);
	}
	
	@Test
	public void test04JugadorConstruyeHotel() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugadorPrueba = new Jugador();
		BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		BarrioDoble barrio2 = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		barrio1.recibirJugador(jugadorPrueba);
		barrio2.recibirJugador(jugadorPrueba);

		barrio1.construirCasa();
		barrio1.construirCasa();
		
		barrio2.construirCasa();
		barrio2.construirCasa();
		
		barrio1.construirHotel();

		int capital = jugadorPrueba.getCapital();

		Assert.assertEquals(26000, capital);
	}
	
	@Test
	public void test05JugadorNoPuedeComprarCasaSinPropiedadRegionalCompleta() {
		BarrioFactory propiedadFactory = new BarrioFactory();
		Jugador jugadorPrueba = new Jugador();
		BarrioDoble barrio1 = propiedadFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		
		barrio1.recibirJugador(jugadorPrueba);

		barrio1.construirCasa();

		int capital = jugadorPrueba.getCapital();
		int cant = barrio1.cantidadEdificios();

		Assert.assertEquals(0, cant);
		Assert.assertEquals(80000, capital);
	}
	
	@Test
	public void test06JugadorCaeEnPropiedadDeOtroJugadorYPagaAlquiler() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		
		barrio1.recibirJugador(jugador1);
		barrio1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(82000 , capital1); 
		Assert.assertEquals(98000 , capital2); 
	}
	
	@Test
	public void test07JugadorCaeEnPropiedadDeOtroJugadorConCasaYPagaAlquiler() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		BarrioDoble barrio2 = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		barrio1.recibirJugador(jugador1);
		barrio2.recibirJugador(jugador1);

		barrio1.construirCasa();
		barrio1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();
		int cant = barrio1.cantidadEdificios();

		Assert.assertEquals(1, cant);

		Assert.assertEquals(53000, capital1);
		Assert.assertEquals(97000, capital2);
	}

	@Test
	public void test08JugadorCaeEnPropiedadDeOtroJugadorConDosCasasYPagaAlquiler() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		BarrioDoble barrio2 = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		barrio1.recibirJugador(jugador1);
		barrio2.recibirJugador(jugador1);

		barrio1.construirCasa();
		barrio1.construirCasa();
		
		barrio1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();
		int cant = barrio1.cantidadEdificios();

		Assert.assertEquals(2, cant);

		Assert.assertEquals(48500, capital1);
		Assert.assertEquals(96500, capital2);
	}
	
	@Test
	public void test09JugadorCaeEnPropiedadDeOtroJugadorConHotelYPagaAlquiler() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		BarrioDoble barrio2 = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		barrio1.recibirJugador(jugador1);
		barrio2.recibirJugador(jugador1);

		barrio1.construirCasa();
		barrio1.construirCasa();
		
		barrio2.construirCasa();
		barrio2.construirCasa();
		
		int cant1 = barrio1.cantidadEdificios();
		int cant2 = barrio2.cantidadEdificios();
		
		barrio1.construirHotel();
		
		barrio1.recibirJugador(jugador2);

		int capital1 = jugador1.getCapital();
		int capital2 = jugador2.getCapital();

		Assert.assertEquals(2, cant1);
		Assert.assertEquals(2, cant2);

		Assert.assertEquals(31000, capital1);
		Assert.assertEquals(95000, capital2);
	}

	@Test
	public void test10JugadorNoPuedeComprarHotelSinDosCasas() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();
		BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		BarrioDoble barrio2 = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		barrio1.recibirJugador(jugador1);
		barrio2.recibirJugador(jugador1);

		barrio1.construirCasa();
		barrio1.construirHotel();

		int capital = jugador1.getCapital();

		Assert.assertEquals(50000, capital);
	}

    @Test
    public void test11JugadorConstruyeHotelTeniendoUnoCompradoEnLaOtraProvinciaYSuCapitalNoSeReduce() {
    	BarrioFactory barrioFactory = new BarrioFactory();
        Jugador jugador1 = new Jugador();
        BarrioDoble barrio1 = barrioFactory.crearBarrioDoble(Provincia.BSAS_SUR, Provincia.BSAS_NORTE);
		BarrioDoble barrio2 = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		
		barrio1.recibirJugador(jugador1);
		barrio2.recibirJugador(jugador1);

        barrio1.construirCasa();
        barrio1.construirCasa();

        barrio2.construirCasa();
        barrio2.construirCasa();

        barrio1.construirHotel();
        barrio2.construirHotel();

        int capital = jugador1.getCapital();

        Assert.assertEquals(26000, capital);
    }
    
    @Test
	public void test12JugadorIntercambiaPropiedadRegionalConOtroLuegoUnTercerJugadorCaeEnDichaPropiedadYElAlquilerVaAlNuevoPropietario() {
		
    	BarrioFactory barrioFactory = new BarrioFactory();
		BarrioDoble buenosAiresNorte = barrioFactory.crearBarrioDoble(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
		BarrioDoble cordobaNorte = barrioFactory.crearBarrioDoble(Provincia.CORDOBA_NORTE, Provincia.CORDOBA_SUR);
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		
		buenosAiresNorte.recibirJugador(jugador1);
		cordobaNorte.recibirJugador(jugador2);
		
		jugador1.intercambiarBarrio(buenosAiresNorte, cordobaNorte, jugador2);
		
		Integer capitalInicialJugador1 = jugador1.getCapital();

		cordobaNorte.recibirJugador(jugador3);
		
		Integer capitalFinalJugador1 = jugador1.getCapital();
		Integer alquilerSantaFe = cordobaNorte.getPrecioAlquiler();
		
		Assert.assertEquals(capitalFinalJugador1.intValue(), capitalInicialJugador1 + alquilerSantaFe);
	}
    
}

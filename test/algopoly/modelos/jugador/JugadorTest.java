package algopoly.modelos.jugador;

import algopoly.modelos.tablero.casilleros.compania.Compania;
import algopoly.modelos.tablero.casilleros.compania.Subte;
import org.junit.Assert;
import org.junit.Test;

import algopoly.modelos.tablero.casilleros.barrios.BarrioFactory;
import algopoly.modelos.tablero.casilleros.barrios.BarrioSimple;
import algopoly.modelos.tablero.casilleros.barrios.Provincia;


public class JugadorTest {

	@Test
	public void test01JugadorEsEncarceladoYHabilitadoLuegoPuedeMoverse() {
		
		Jugador jugador = new Jugador();
		
		jugador.encarcelar();
		jugador.habilitar();
		
		int tirada = jugador.tirar();
		
		Assert.assertNotEquals(tirada, 0);
	}

	@Test
	public void test02JugadorSeQuedaSinDineroYVendePropiedad(){
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();

		BarrioSimple barrioCobrar = barrioFactory.crearBarrioSimple(Provincia.BSAS_NORTE);

		BarrioSimple barrioVender = barrioFactory.crearBarrioSimple(Provincia.BSAS_SUR);

		barrioCobrar.recibirJugador(jugador2);
		barrioVender.recibirJugador(jugador1);

		for(int i = 0; i < 33; i++){
			barrioCobrar.recibirJugador(jugador1);
		}

		int capitalFinal = jugador1.getCapital();
		int cantidadBarrios = jugador1.getCantidadBarrios();

		Assert.assertEquals(14500, capitalFinal);
		Assert.assertEquals(0, cantidadBarrios);

	}

	@Test
	public void test03JugadorSeQuedaSinDineroYVendePropiedadUnSegundoJugadorLaCompraYUnTerceroPagaAlSegundo(){
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();

		BarrioSimple barrioCobrar = barrioFactory.crearBarrioSimple(Provincia.BSAS_NORTE);

		BarrioSimple barrioVender = barrioFactory.crearBarrioSimple(Provincia.BSAS_SUR);

		barrioCobrar.recibirJugador(jugador2); //capital jugador2 == 75000
		barrioVender.recibirJugador(jugador1);

		for(int i = 0; i < 33; i++){
			barrioCobrar.recibirJugador(jugador1);
		}
		// capital jugador2 == 75000 + 82500 = 157500
		barrioVender.recibirJugador(jugador2); // capital jugador2 == 137500
		barrioVender.recibirJugador(jugador3); // capital jugador2 == 139500

		int capitalFinaljugador2 = jugador2.getCapital();
		int capitalFinaljugador3 = jugador3.getCapital();

		Assert.assertEquals(barrioVender.getPropietario(), jugador2);
		Assert.assertEquals(139500, capitalFinaljugador2);
		Assert.assertEquals(98000, capitalFinaljugador3);

	}

	@Test
	public void test04JugadorSeQuedaSinDineroAlPagarAlquilerYVendeSuCompania(){
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();

		BarrioSimple barrioCobrar = barrioFactory.crearBarrioSimple(Provincia.BSAS_NORTE);

		Compania companiaAVender = new Subte();

		barrioCobrar.recibirJugador(jugador2);
		companiaAVender.recibirJugador(jugador1); // capital jugador1 == 60000;

		for(int i = 0; i < 25; i++){
			barrioCobrar.recibirJugador(jugador1);
		}

		int capitalFinalJugador1 = jugador1.getCapital(); //capital jugador1 == 31500

		Assert.assertEquals(31500, capitalFinalJugador1);
	}
	
	@Test
	public void test05JugadorSeQuedaFueraDeJuegoSinBarriosSinCompaniasYSinCapital() {
		BarrioFactory barrioFactory = new BarrioFactory();
		Jugador jugador1 = new Jugador();

		BarrioSimple barrio1 = barrioFactory.crearBarrioSimple(Provincia.SANTA_FE);
		barrio1.recibirJugador(jugador1);
		
		Compania compania = new Subte();
		compania.recibirJugador(jugador1);
		
		int cantidadBarriosInicial = jugador1.getCantidadBarrios();
		int cantidadCompaniasInicial = jugador1.getCantidadCompanias();
		
		jugador1.fueraDeJuego();
		
		int cantidadBarrioFinal = jugador1.getCantidadBarrios();
		int cantidadCompaniasFinal = jugador1.getCantidadCompanias();
		
		int capitalFinal = jugador1.getCapital();
		
		Assert.assertEquals(1, cantidadBarriosInicial);
		Assert.assertEquals(1, cantidadCompaniasInicial);
		
		Assert.assertEquals(0, cantidadBarrioFinal);
		Assert.assertEquals(0, cantidadCompaniasFinal);
		
		Assert.assertEquals(0, capitalFinal);
	}

}

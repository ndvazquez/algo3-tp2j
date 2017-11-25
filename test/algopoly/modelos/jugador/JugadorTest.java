package algopoly.modelos.jugador;

import algopoly.modelos.tablero.propiedad.PropiedadFactory;
import algopoly.modelos.tablero.propiedad.PropiedadSimple;
import algopoly.modelos.tablero.propiedad.Provincia;
import org.junit.Assert;
import org.junit.Test;


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
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();

		PropiedadSimple propiedadCobrar = propiedadFactory.crearPropiedadSimple(Provincia.BSAS_NORTE);

		PropiedadSimple propiedadVender = propiedadFactory.crearPropiedadSimple(Provincia.BSAS_SUR);

		propiedadCobrar.recibirJugador(jugador2);
		propiedadVender.recibirJugador(jugador1);

		for(int i = 0; i < 33; i++){
			propiedadCobrar.recibirJugador(jugador1);
		}

		int capitalFinal = jugador1.getCapital();
		int cantidadPropiedades = jugador1.getCantidadPropiedades();

		Assert.assertEquals(14500, capitalFinal);
		Assert.assertEquals(0, cantidadPropiedades);

	}

	@Test
	public void test03JugadorSeQuedaSinDineroYVendePropiedadUnSegundoJugadorLaCompraYUnTerceroPagaAlSegundo(){
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();

		PropiedadSimple propiedadCobrar = propiedadFactory.crearPropiedadSimple(Provincia.BSAS_NORTE);

		PropiedadSimple propiedadVender = propiedadFactory.crearPropiedadSimple(Provincia.BSAS_SUR);

		propiedadCobrar.recibirJugador(jugador2); //capital jugador2 == 75000
		propiedadVender.recibirJugador(jugador1);

		for(int i = 0; i < 33; i++){
			propiedadCobrar.recibirJugador(jugador1);
		}
		// capital jugador2 == 75000 + 82500 = 157500
		propiedadVender.recibirJugador(jugador2); // capital jugador2 == 137500
		propiedadVender.recibirJugador(jugador3); // capital jugador2 == 139500

		int capitalFinaljugador2 = jugador2.getCapital();
		int capitalFinaljugador3 = jugador3.getCapital();

		Assert.assertEquals(propiedadVender.getPropietario(), jugador2);
		Assert.assertEquals(139500, capitalFinaljugador2);
		Assert.assertEquals(98000, capitalFinaljugador3);



	}

}

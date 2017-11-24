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
		
		Posicion posicionActual = jugador.getPosicion();
		
		jugador.mover(1);
		
		Posicion posicionNueva = Posicion.getPosicionSiguiente(posicionActual);
		
		Assert.assertEquals(posicionNueva, jugador.getPosicion());
	}

	@Test
	public void test02JugadorSeQuedaSinDineroYVendePropiedad(){
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		Jugador jugadorSinPlata = new Jugador();
		Jugador jugadorPropietario = new Jugador();

		PropiedadSimple propiedadCobrar = propiedadFactory.crearPropiedadSimple(Provincia.BSAS_NORTE);

		PropiedadSimple propiedadVender = propiedadFactory.crearPropiedadSimple(Provincia.BSAS_SUR);

		propiedadCobrar.recibirJugador(jugadorPropietario);
		propiedadVender.recibirJugador(jugadorSinPlata);

		for(int i = 0; i < 33; i++){
			propiedadCobrar.recibirJugador(jugadorSinPlata);
		}

		int capitalFinal = jugadorSinPlata.getCapital();
		int cantidadPropiedades = jugadorSinPlata.getCantidadPropiedades();

		Assert.assertEquals(14500, capitalFinal);
		Assert.assertEquals(0, cantidadPropiedades);


	}

}

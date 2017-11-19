package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
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
}

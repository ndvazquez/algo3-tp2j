package algopoly.modelos.tests_entrega2;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.propiedad.PropiedadFactory;
import algopoly.modelos.tablero.propiedad.PropiedadRegional;
import algopoly.modelos.tablero.propiedad.Provincia;
import org.junit.Assert;
import org.junit.Test;

public class EdificiosYAlquileresPropiedadRegionalTest {

    @Test
    public void test01JugadorConstruyeCasa() {
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
    public void test02JugadorConstruyeDosCasas() {
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
    public void test03JugadorConstruyeHotel() {
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
    public void test04JugadorNoPuedeComprarCasaSinPropiedadRegionalCompleta() {
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
    public void test05JugadorCaeEnPropiedadDeOtroJugadorYPagaAlquiler() {
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
    public void test06JugadorCaeEnPropiedadDeOtroJugadorConCasaYPagaAlquiler() {
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
    public void test07JugadorCaeEnPropiedadDeOtroJugadorConDosCasasYPagaAlquiler() {
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
    public void test08JugadorCaeEnPropiedadDeOtroJugadorConHotelYPagaAlquiler() {
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
    public void test09JugadorNoPuedeComprarHotelSinDosCasas() {
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
    public void test10JugadorConstruyeHotelTeniendoUnoCompradoEnLaOtraProvinciaYSuCapitalNoSeReduce() {
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

    @Test
    public void test11JugadorIntercambiaPropiedadRegionalConOtroLuegoUnTercerJugadorCaeEnDichaPropiedadYElAlquilerVaAlNuevoPropietario() {

        PropiedadFactory propiedadFactory = new PropiedadFactory();
        PropiedadRegional buenosAiresNorte = propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR);
        PropiedadRegional cordobaNorte = propiedadFactory.crearPropiedadRegional(Provincia.CORDOBA_NORTE, Provincia.CORDOBA_SUR);

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();

        buenosAiresNorte.recibirJugador(jugador1);
        cordobaNorte.recibirJugador(jugador2);

        jugador1.intercambiarPropiedad(buenosAiresNorte, cordobaNorte, jugador2);

        Integer capitalInicialJugador1 = jugador1.getCapital();

        cordobaNorte.recibirJugador(jugador3);

        Integer capitalFinalJugador1 = jugador1.getCapital();
        Integer alquilerSantaFe = cordobaNorte.getPrecioAlquiler();

        Assert.assertEquals(capitalFinalJugador1.intValue(), capitalInicialJugador1 + alquilerSantaFe);
    }
}

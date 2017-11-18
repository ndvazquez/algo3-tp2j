package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

import org.junit.Assert;
import org.junit.Test;

public class ComprarPropiedadesTest {

    @Test
    public void test01UnJugadorCompraBuenosAiresZonaSurYSuCapitalSeReduce(){
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Region regionBuenosAires = new Region();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad buenosAiresZonaSur = propiedadFactory.crearPropiedadRegional(20000, regionBuenosAires, 0, 0); // valor = 20000

        jugadorPrueba.comprarPropiedad(buenosAiresZonaSur);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(80000, capitalFinal);

    }

    @Test
    public void test02UnJugadorCompraBuenosAiresZonaNorteYSuCapitalSeReduce(){
        Region regionBuenosAires = new Region();
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad buenosAiresZonaNorte = propiedadFactory.crearPropiedadRegional(25000, regionBuenosAires, 0, 0); // valor = 25000

        jugadorPrueba.comprarPropiedad(buenosAiresZonaNorte);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(75000, capitalFinal);

    }

    @Test
    public void test03UnJugadorCompraCordobaSurYSuCapitalSeReduce(){
        Region regionCordoba = new Region();
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad cordobaSur = propiedadFactory.crearPropiedadRegional(18000, regionCordoba, 0, 0); // valor = 18000

        jugadorPrueba.comprarPropiedad(cordobaSur);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(82000, capitalFinal);

    }

    @Test
    public void test04UnJugadorCompraCordobaNorteYSuCapitalSeReduce(){
        Region regionCordoba = new Region();
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad cordobaNorte = propiedadFactory.crearPropiedadRegional(20000, regionCordoba, 0, 0); // valor = 20000

        jugadorPrueba.comprarPropiedad(cordobaNorte);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(80000, capitalFinal);
    }

    @Test
    public void test05UnJugadorCompraSantaFeYSuCapitalSeReduce(){
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad santaFe = propiedadFactory.crearPropiedadSimple(15000, 0, 0); // valor = 15000

        jugadorPrueba.comprarPropiedad(santaFe);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(85000, capitalFinal);
    }

    @Test
    public void test06UnJugadorCompraSaltaNorteYSuCapitalSeReduce(){
        Region regionSalta = new Region();
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad saltaNorte = propiedadFactory.crearPropiedadRegional(23000, regionSalta, 0, 0); // valor = 23000

        jugadorPrueba.comprarPropiedad(saltaNorte);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(77000, capitalFinal);
    }

    @Test
    public void test07UnJugadorCompraSaltaSurYSuCapitalSeReduce(){
        Region regionSalta = new Region();
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad saltaSur = propiedadFactory.crearPropiedadRegional(23000, regionSalta, 0, 0); // valor = 23000

        jugadorPrueba.comprarPropiedad(saltaSur);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(77000, capitalFinal);
    }

    @Test
    public void test08UnJugadorCompraNeuquenYSuCapitalSeReduce(){
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad neuquen = propiedadFactory.crearPropiedadSimple(17000, 0, 0); // valor = 17000

        jugadorPrueba.comprarPropiedad(neuquen);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals( 83000, capitalFinal);
    }

    @Test
    public void test09UnJugadorCompraTucumanYSuCapitalSeReduce(){
        PropiedadFactory propiedadFactory = new PropiedadFactory();
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Propiedad tucuman = propiedadFactory.crearPropiedadSimple(25000, 0, 0); // valor = 25000

        jugadorPrueba.comprarPropiedad(tucuman);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(75000, capitalFinal);
    }
}

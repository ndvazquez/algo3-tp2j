package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class ComprarPropiedadesTest {

    @Test
    public void test01UnJugadorCompraBuenosAiresZonaSurYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        BuenosAiresZonaSur buenosAiresZonaSur = new BuenosAiresZonaSur(); // valor = 20000

        jugadorPrueba.comprarPropiedad(buenosAiresZonaSur);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(80000, capitalFinal);

    }

    @Test
    public void test02UnJugadorCompraBuenosAiresZonaNorteYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        BuenosAiresZonaNorte buenosAiresZonaNorte = new BuenosAiresZonaNorte(); // valor = 25000

        jugadorPrueba.comprarPropiedad(buenosAiresZonaNorte);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(75000, capitalFinal);

    }

    @Test
    public void test03UnJugadorCompraCordobaSurYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        CordobaSur cordobaSur = new CordobaSur(); // valor = 18000

        jugadorPrueba.comprarPropiedad(cordobaSur);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(82000, capitalFinal);

    }

    @Test
    public void test04UnJugadorCompraCordobaNorteYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        CordobaNorte cordobaNorte = new CordobaNorte(); // valor = 20000

        jugadorPrueba.comprarPropiedad(cordobaNorte);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(80000, capitalFinal);
    }

    @Test
    public void test05UnJugadorCompraSantaFeYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        SantaFe santaFe = new SantaFe(); // valor = 15000

        jugadorPrueba.comprarPropiedad(santaFe);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(85000, capitalFinal);
    }

    @Test
    public void test06UnJugadorCompraSaltaNorteYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        SaltaNorte saltaNorte = new SaltaNorte(); // valor = 23000

        jugadorPrueba.comprarPropiedad(saltaNorte);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(77000, capitalFinal);
    }

    @Test
    public void test07UnJugadorCompraSaltaSurYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        SaltaSur saltaSur = new SaltaSur(); // valor = 23000

        jugadorPrueba.comprarPropiedad(saltaSur);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(77000, capitalFinal);
    }

    @Test
    public void test08UnJugadorCompraNeuquenYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Neuquen neuquen = new Neuquen(); // valor = 17000

        jugadorPrueba.comprarPropiedad(neuquen);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals( 83000, capitalFinal);
    }

    @Test
    public void test09UnJugadorCompraTucumanYSuCapitalSeReduce(){
        Jugador jugadorPrueba = new Jugador(); // capital inicial = 100000
        Tucuman tucuman = new Tucuman(); // valor = 25000

        jugadorPrueba.comprarPropiedad(tucuman);

        int capitalFinal = jugadorPrueba.getCapital();

        Assert.assertEquals(75000, capitalFinal);
    }
}

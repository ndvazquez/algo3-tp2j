package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Quini6Test {

    @Test
    public void test01UnJugadorCaeEnQuini6PorPrimeraVez() {
        Quini6 quini6 = new Quini6();

        Jugador jugadorPrueba = new Jugador();

        quini6.recibirJugador(jugadorPrueba);

        int capitalJugador = jugadorPrueba.getCapital();

        Assert.assertEquals(150000, capitalJugador);
    }

    @Test
    public void test02UnJugadorCaeEnQuini6PorSegundaVez() {
        Quini6 quini6 = new Quini6();

        Jugador jugadorPrueba = new Jugador();

        for (int i = 0; i < 2; i++) {
            quini6.recibirJugador(jugadorPrueba);
        }

        int capitalJugador = jugadorPrueba.getCapital();

        Assert.assertEquals(capitalJugador, 180000);
    }

    @Test
    public void test03UnJugadorCaeEnQuini6MasDeDosVeces() {
        Quini6 quini6 = new Quini6();

        Jugador jugadorPrueba = new Jugador();

        for (int i = 0; i < 5; i++) {
            quini6.recibirJugador(jugadorPrueba);
        }

        int capitalJugador = jugadorPrueba.getCapital();

        Assert.assertEquals(capitalJugador, 180000);
    }
}

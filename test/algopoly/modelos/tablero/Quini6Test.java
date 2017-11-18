package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Quini6Test {

    @Test
    public void test01UnJugadorCaeEnQuini6PorPrimeraVez() {
        Jugador jugadorPrueba = new Jugador();
        ArrayList<Jugador> jugadores = new ArrayList<>();

        jugadores.add(jugadorPrueba);

        Quini6 quini6 = new Quini6(jugadores);

        quini6.recibirJugador(jugadorPrueba);

        int capitalJugador = jugadorPrueba.getCapital();

        Assert.assertEquals(150000, capitalJugador);
    }

    @Test
    public void test02UnJugadorCaeEnQuini6PorSegundaVez() {
        Jugador jugadorPrueba = new Jugador();
        ArrayList<Jugador> jugadores = new ArrayList<>();

        jugadores.add(jugadorPrueba);

        Quini6 quini6 = new Quini6(jugadores);

        for (int i = 0; i < 2; i++) {
            quini6.recibirJugador(jugadorPrueba);
        }

        int capitalJugador = jugadorPrueba.getCapital();

        Assert.assertEquals(capitalJugador, 180000);
    }

    @Test
    public void test03UnJugadorCaeEnQuini6MasDeDosVeces() {
        Jugador jugadorPrueba = new Jugador();
        ArrayList<Jugador> jugadores = new ArrayList<>();

        jugadores.add(jugadorPrueba);

        Quini6 quini6 = new Quini6(jugadores);

        for (int i = 0; i < 5; i++) {
            quini6.recibirJugador(jugadorPrueba);
        }

        int capitalJugador = jugadorPrueba.getCapital();

        Assert.assertEquals(capitalJugador, 180000);
    }
}

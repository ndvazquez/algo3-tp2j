package modelos;

import org.junit.Assert;
import org.junit.Test;

public class RetrocesoDinamicoTest {
    /*** Tests dados 2 - 6 ***/
    @Test
    public void test01JugadorCaeEnRetrocesoDinamicoTirando2Retrocede2MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        jugadorPrueba.setUltimaTirada(2);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (2 - 0), indiceFinal);
    }

    @Test
    public void test02JugadorCaeEnRetrocesoDinamicoTirando3Retrocede3MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        jugadorPrueba.setUltimaTirada(3);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (3 - 0), indiceFinal);
    }

    @Test
    public void test03JugadorCaeEnRetrocesoDinamicoTirando4Retrocede4MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        jugadorPrueba.setUltimaTirada(4);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (4 - 0), indiceFinal);
    }

    @Test
    public void test04JugadorCaeEnRetrocesoDinamicoTirando5Retrocede5MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        jugadorPrueba.setUltimaTirada(5);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (5 - 0), indiceFinal);
    }

    @Test
    public void test05JugadorCaeEnRetrocesoDinamicoTirando6Retrocede6MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        jugadorPrueba.setUltimaTirada(6);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (6 - 0), indiceFinal);
    }

    /*** Tests dados 7 - 10 ***/
    @Test
    public void test06JugadorCaeEnRetrocesoTirando7RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        jugadorPrueba.setUltimaTirada(7);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - 100000 % 7, indiceFinal);
    }

    @Test
    public void test07JugadorCaeEnRetrocesoTirando8RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        jugadorPrueba.setUltimaTirada(8);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - 100000 % 8, indiceFinal);
    }


    @Test
    public void test08JugadorCaeEnRetrocesoTirando9RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        jugadorPrueba.setUltimaTirada(9);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - 100000 % 9, indiceFinal);
    }

    @Test
    public void test09JugadorCaeEnRetrocesoTirando10RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        jugadorPrueba.setUltimaTirada(10);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - 100000 % 10, indiceFinal);
    }

    /*** Tests dados 11 - 12 ***/
    @Test
    public void test010JugadorCaeEnRetrocesoTirando11RetrocedeLaTiradaMenos2(){
        Jugador jugadorPrueba = new Jugador();
        jugadorPrueba.setUltimaTirada(11);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (11 - 2), indiceFinal);
    }

    @Test
    public void test011JugadorCaeEnRetrocesoTirando12RetrocedeLaTiradaMenos2(){
        Jugador jugadorPrueba = new Jugador();
        jugadorPrueba.setUltimaTirada(12);
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (12 - 2), indiceFinal);
    }
}
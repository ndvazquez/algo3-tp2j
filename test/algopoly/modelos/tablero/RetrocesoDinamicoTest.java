package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

import org.junit.Assert;
import org.junit.Test;

public class RetrocesoDinamicoTest {

	/*** Tests dados 2 - 6 ***/
    @Test
    public void test01JugadorCaeEnRetrocesoDinamicoTirando2Retrocede2MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(2))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (2 - 0), indiceFinal);
    }

    @Test
    public void test02JugadorCaeEnRetrocesoDinamicoTirando3Retrocede3MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(3))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (3 - 0), indiceFinal);
    }

    @Test
    public void test03JugadorCaeEnRetrocesoDinamicoTirando4Retrocede4MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(4))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (4 - 0), indiceFinal);
    }

    @Test
    public void test04JugadorCaeEnRetrocesoDinamicoTirando5Retrocede5MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(5))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (5 - 0), indiceFinal);
    }

    @Test
    public void test05JugadorCaeEnRetrocesoDinamicoTirando6Retrocede6MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(6))
			valor = jugadorPrueba.tirar();
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
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(7))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - 100000 % 7, indiceFinal);
    }

    @Test
    public void test07JugadorCaeEnRetrocesoTirando8RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(8))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - 100000 % 8, indiceFinal);
    }


    @Test
    public void test08JugadorCaeEnRetrocesoTirando9RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(9))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - 100000 % 9, indiceFinal);
    }

    @Test
    public void test09JugadorCaeEnRetrocesoTirando10RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(10))
			valor = jugadorPrueba.tirar();
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
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(11))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (11 - 2), indiceFinal);
    }

    @Test
    public void test011JugadorCaeEnRetrocesoTirando12RetrocedeLaTiradaMenos2(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(12))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        int indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        int indiceFinal = jugadorPrueba.getPosicion();

        Assert.assertEquals(indiceActual - (12 - 2), indiceFinal);
    }
}
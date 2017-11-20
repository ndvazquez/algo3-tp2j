package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;

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

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 2 - 0);
    }

    @Test
    public void test02JugadorCaeEnRetrocesoDinamicoTirando3Retrocede3MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(3))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 3 - 0);
    }

    @Test
    public void test03JugadorCaeEnRetrocesoDinamicoTirando4Retrocede4MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(4))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 4 - 0);
    }

    @Test
    public void test04JugadorCaeEnRetrocesoDinamicoTirando5Retrocede5MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(5))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 5 - 0);
    }

    @Test
    public void test05JugadorCaeEnRetrocesoDinamicoTirando6Retrocede6MenosSuCantidaddDePropiedades() {
        Jugador jugadorPrueba = new Jugador(); // propiedades = 0
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(6))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 6 - 0);
    }

    /*** Tests dados 7 - 10 ***/
    @Test
    public void test06JugadorCaeEnRetrocesoTirando7RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(7))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 100000 % 7);
    }

    @Test
    public void test07JugadorCaeEnRetrocesoTirando8RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(8))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 100000 % 8);
    }


    @Test
    public void test08JugadorCaeEnRetrocesoTirando9RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(9))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 100000 % 9);
    }

    @Test
    public void test09JugadorCaeEnRetrocesoTirando10RetrocedeSuCantidadDeEfectivoModuloLaTirada(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(10))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 100000 % 10);
    }

    /*** Tests dados 11 - 12 ***/
    @Test
    public void test010JugadorCaeEnRetrocesoTirando11RetrocedeLaTiradaMenos2(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(11))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 11 - 2);
    }

    @Test
    public void test011JugadorCaeEnRetrocesoTirando12RetrocedeLaTiradaMenos2(){
        Jugador jugadorPrueba = new Jugador();
        Integer valor = jugadorPrueba.tirar();
		while (!valor.equals(12))
			valor = jugadorPrueba.tirar();
        RetrocesoDinamico retrocesoDinamico = new RetrocesoDinamico();

        Posicion indiceActual = jugadorPrueba.getPosicion();
        retrocesoDinamico.recibirJugador(jugadorPrueba);
        Posicion indiceFinal = jugadorPrueba.getPosicion();

        int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
        Assert.assertEquals(diferencia, 12 - 2);
    }
}
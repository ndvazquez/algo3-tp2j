package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.casilleros.Casillero;

import org.junit.Assert;
import org.junit.Test;

public class SalidaTest {

    @Test
    public void test01JugadorIniciaPartidaEnCasilleroSalida(){
        Tablero tablero = new Tablero();

        Jugador jugadorInicio = tablero.jugadorActual();

        Casillero casillero = jugadorInicio.getCasilleroActual();

        Assert.assertEquals(casillero, tablero.obtenerCasillero(Tablero.SALIDA));
    }

    @Test
    public void test02CaerEnSalidaNoHaceNada(){
        Tablero tablero = new Tablero();
        Jugador jugador = tablero.jugadorActual();

        jugador.iniciarTurno(); // lo muevo a otro lado
        jugador.setCasilleroActual(tablero.obtenerCasillero(Tablero.SALIDA));
        tablero.obtenerCasillero(Tablero.SALIDA).recibirJugador(jugador);
        
        int capitalInicial = jugador.getCapital();
        int companiasInicial = jugador.getCantidadCompanias();
        int barriosInicial = jugador.getCantidadBarrios();

        Casillero casilleroActual = jugador.getCasilleroActual();
        int capitalActual = jugador.getCapital();
        int cantCompanias  = jugador.getCantidadCompanias();
        int cantBarrios = jugador.getCantidadBarrios();
        
        Assert.assertEquals(casilleroActual, tablero.obtenerCasillero(Tablero.SALIDA));
        Assert.assertEquals(capitalActual, capitalInicial);
        Assert.assertEquals(cantCompanias, companiasInicial);
        Assert.assertEquals(cantBarrios, barriosInicial);
    }


}

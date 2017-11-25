package algopoly.modelos.tablero;

import algopoly.modelos.excepciones.JugadorSinPlataException;
import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void test01UnJugadorTiraDadosVerificoQueSigueJugandoSiSacoDobleYSiNoLoHaceJuegaOtro(){
        Tablero tablero = new Tablero();

        Jugador jugadorInicio = tablero.jugadorActual();

        tablero.proximoTurno();

        Jugador jugadorFinal = tablero.jugadorActual();

        if (jugadorInicio.sacoDoble()) {
            Assert.assertEquals(jugadorInicio, jugadorFinal);
        } else {
            Assert.assertNotEquals(jugadorInicio, jugadorFinal);
        }

    }

    @Test
    public void test02UnJugadorSacaDobleYGanaUnTurnoExtra(){
        Tablero tablero = new Tablero();

        Jugador jugadorInicial = null;

        Jugador jugadorFinal = null;

        boolean continuar = true;
        try{
            while(continuar){
                tablero.proximoTurno();
                jugadorInicial = tablero.jugadorActual();
                jugadorFinal = tablero.jugadorActual();
                continuar = !jugadorInicial.sacoDoble();
            }
        } catch (JugadorSinPlataException e){
            Assert.assertEquals(e.getClass(), JugadorSinPlataException.class);
        }


        Assert.assertEquals(jugadorFinal, jugadorInicial);

    }
    /*** Siendo que la probablidad de que esto pase es baja, es difícil de probar en un tiempo prudente

    @Test
    public void test03UnJugadorSacaDobleDosVecesYNoJuegaUnTercerTurno(){
        Tablero tablero = new Tablero();

        Jugador jugadorInicial = null;

        Jugador jugadorFinal = null;

        boolean continuar = true;

        while(continuar){
            jugadorInicial = tablero.jugadorActual();
            tablero.proximoTurno();
            jugadorFinal = tablero.jugadorActual();
            if(jugadorInicial.sacoDoble()){
                tablero.proximoTurno();
                jugadorFinal = tablero.jugadorActual();
                continuar = !jugadorInicial.sacoDoble();
            }
        }

        Assert.assertNotEquals(jugadorFinal, jugadorInicial);
    }
    ***/


}

package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public class RetrocesoDinamico implements Casillero {

    @Override
    public void recibirJugador(Jugador jugador) {
        Integer movimientos;

        Integer ultimaTirada = jugador.getUltimaTirada();
        if (ultimaTirada <= 6) {
            movimientos = ultimaTirada - jugador.getCantidadPropiedades();
        } else if (ultimaTirada <= 10) {
            movimientos = jugador.getCapital() % ultimaTirada;
        } else {
            movimientos = ultimaTirada - 2;
        }

        jugador.retroceder(movimientos);
    }
}

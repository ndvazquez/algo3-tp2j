package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;

public class AvanceDinamico implements Casillero {

    @Override
    public void recibirJugador(Jugador jugador) {
        Integer movimientos;

        Integer ultimaTirada = jugador.getUltimaTirada();
        if (ultimaTirada <= 6) {
            movimientos = ultimaTirada - 2;
        } else if (ultimaTirada <= 10) {
            movimientos = jugador.getCapital() % ultimaTirada;
        } else {
            movimientos = ultimaTirada - jugador.getCantidadPropiedades();
        }

        jugador.avanzar(movimientos);
    }

}

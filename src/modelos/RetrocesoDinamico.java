package modelos;

public class RetrocesoDinamico implements Casillero {

    @Override
    public void recibirJugador(Jugador jugador) {
        Integer movimientos = null;

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

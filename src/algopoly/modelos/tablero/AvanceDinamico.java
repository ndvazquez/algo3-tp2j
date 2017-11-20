package algopoly.modelos.tablero;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import algopoly.modelos.jugador.Jugador;

public class AvanceDinamico implements Casillero {

	private Map<Integer, Function<Jugador, Integer>> funciones;
	
	public AvanceDinamico() {
		funciones = new HashMap<Integer, Function<Jugador, Integer>>();
		for (int i = 1; i <= 6; i++) {
			funciones.put(i, j -> j.getUltimaTirada() - 2);
		}
		for (int i = 7; i <= 10; i++) {
			funciones.put(i, j -> j.getCapital() % j.getUltimaTirada());
		}
		for (int i = 11; i <= 12; i++) {
			funciones.put(i, j -> j.getUltimaTirada() - j.getCantidadPropiedades());
		}
	}
	
	@Override
    public void recibirJugador(Jugador jugador) {
        jugador.avanzar(this.funciones.get(jugador.getUltimaTirada()).apply(jugador));
    }

}


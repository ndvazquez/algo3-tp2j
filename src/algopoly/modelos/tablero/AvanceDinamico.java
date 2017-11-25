
package algopoly.modelos.tablero;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import algopoly.modelos.jugador.Jugador;

public class AvanceDinamico implements Casillero {

	private Map<Integer, Function<Jugador, Integer>> funciones;
	
	public AvanceDinamico() {
		this.funciones = new HashMap<>();
		for (int i = 1; i <= 6; i++) {
			this.funciones.put(i, j -> j.getUltimaTirada() - 2);
		}
		for (int i = 7; i <= 10; i++) {
			this.funciones.put(i, j -> j.getCapital() % j.getUltimaTirada());
		}
		for (int i = 11; i <= 12; i++) {
			this.funciones.put(i, j -> j.getUltimaTirada() - j.getCantidadBarrios());
		}
	}
	
	@Override
    public void recibirJugador(Jugador jugador) {
        jugador.mover(this.funciones.get(jugador.getUltimaTirada()).apply(jugador));
    }

}


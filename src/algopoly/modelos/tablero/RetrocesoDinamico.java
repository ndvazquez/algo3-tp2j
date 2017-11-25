package algopoly.modelos.tablero;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import algopoly.modelos.jugador.Jugador;

public class RetrocesoDinamico implements Casillero {
	
	private Map<Integer, Function<Jugador, Integer>> funciones;
	
	public RetrocesoDinamico() {
		this.funciones = new HashMap<>();
		for (int i = 1; i <= 6; i++) {
			this.funciones.put(i, j -> j.getUltimaTirada() - j.getCantidadPropiedades());
		}
		for (int i = 7; i <= 10; i++) {
			this.funciones.put(i, j -> j.getCapital() % j.getUltimaTirada());
		}
		for (int i = 11; i <= 12; i++) {
			this.funciones.put(i, j -> j.getUltimaTirada() - 2);
		}
	}
	
	@Override
    public void recibirJugador(Jugador jugador) {
		Integer cantidadDeMovimientos = this.funciones.get(jugador.getUltimaTirada()).apply(jugador);
		if (cantidadDeMovimientos <= 0) return;
		Casillero proximoCasillero = this;
		for (int i = 0; i < cantidadDeMovimientos; i++) {
			proximoCasillero = Tablero.obtenerTablero().obtenerCasilleroAnterior(proximoCasillero);
		}
		jugador.setCasilleroActual(proximoCasillero);
		proximoCasillero.recibirJugador(jugador);
    }
	
	

}

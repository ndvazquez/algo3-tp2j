package algopoly.modelos.tablero.servicios;

import algopoly.modelos.jugador.Jugador;

public class ConPropietario implements Estado {

	public void recibirJugador(Jugador jugador, Compania compania) {
		Integer impuesto = compania.getServicios().obtenerImpuesto(compania, jugador);

		impuesto = jugador.equals(compania.getPropietario()) ? 0 : impuesto;
		
		jugador.incrementarCapital((-jugador.getUltimaTirada() * impuesto));
		compania.getPropietario().incrementarCapital(jugador.getUltimaTirada() * impuesto);
	}
}

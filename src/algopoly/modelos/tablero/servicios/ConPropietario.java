package algopoly.modelos.tablero.servicios;

import algopoly.modelos.jugador.Jugador;

public class ConPropietario implements Estado {

	@Override
	public void recibirJugador(Jugador jugador, Compania compania) {
		Integer impuesto = compania.getServicios().obtenerImpuesto(compania, jugador);

		impuesto = jugador.equals(compania.getPropietario()) ? 0 : impuesto;
		
		jugador.pagar((jugador.getUltimaTirada() * impuesto));
		compania.getPropietario().cobrar(jugador.getUltimaTirada() * impuesto);
	}
}

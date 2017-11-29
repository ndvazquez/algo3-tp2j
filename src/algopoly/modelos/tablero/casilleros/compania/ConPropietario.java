package algopoly.modelos.tablero.casilleros.compania;

import algopoly.modelos.jugador.Jugador;

public class ConPropietario implements Estado {

	@Override
	public void recibirJugador(Jugador jugador, Compania compania) {
		Integer impuesto = compania.impuesto;
		
		impuesto = Compania.tienenMismoDueño(compania, compania.companiaPar) ? compania.impuestoDoble : impuesto;
		impuesto = jugador.equals(compania.propietario) ? 0 : impuesto;
		
		jugador.pagar((jugador.getUltimaTirada() * impuesto));
		compania.propietario.cobrar(jugador.getUltimaTirada() * impuesto);
	}
}

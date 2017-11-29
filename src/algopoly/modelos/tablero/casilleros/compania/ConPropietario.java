package algopoly.modelos.tablero.casilleros.compania;

import algopoly.modelos.jugador.Jugador;

public class ConPropietario implements Estado {

	@Override
	public void recibirJugador(Jugador jugador, Compania compania) {
		if(!compania.propietario.equals(jugador)){
			Integer impuesto = compania.impuesto;

			impuesto = Compania.tienenMismoDueño(compania, compania.companiaPar) ? compania.impuestoDoble : impuesto;
			impuesto = jugador.equals(compania.propietario) ? 0 : impuesto;

			Integer montoFinal = (jugador.getUltimaTirada() * impuesto);
			jugador.pagar(montoFinal);
			compania.propietario.cobrar(montoFinal);
			jugador.setMensajes(String.format("\t%s pagó %d a %s.\n", jugador.getNombre(), montoFinal,
					compania.propietario.getNombre()));
		}
	}
}

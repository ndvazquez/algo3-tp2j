package algopoly.modelos.tablero.servicios;

import java.util.ArrayList;
import java.util.Collection;

import algopoly.modelos.jugador.Jugador;

public class Servicios {

	private Collection<Compania> companias;

	public Servicios() {
		companias = new ArrayList<Compania>();
	}

	public void agregarCompania(Compania compania) {
		this.companias.add(compania);
	}

	public Integer obtenerImpuesto(Compania companiaOrig, Jugador jugador) {
		Integer impuesto = companiaOrig.getImpuesto();
		this.companias.remove(companiaOrig);

		if (!this.companias.isEmpty()
				&& this.companias.stream().allMatch(c -> companiaOrig.getPropietario().equals(c.getPropietario()))) {
			impuesto = companiaOrig.getImpuestoDoble();
		}

		this.companias.add(companiaOrig);
		return impuesto;
	}

}

package algopoly.modelos.tablero;

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

	public void cobrarImpuesto(Compania companiaOrig, Jugador jugador) {
		Integer impuesto = companiaOrig.getImpuesto();
		this.companias.remove(companiaOrig);

		// si todas las companias tienen el mismo dueño -> uso el impuesto doble en
		// lugar del simple
		if (!this.companias.isEmpty()
				&& this.companias.stream().allMatch(c -> companiaOrig.getPropietario().equals(c.getPropietario()))) {
			impuesto = companiaOrig.getImpuestoDoble();
		}

		impuesto = jugador.equals(companiaOrig.getPropietario()) ? 0 : impuesto;

		jugador.incrementarCapital(-(jugador.getUltimaTirada() * impuesto));
		companiaOrig.getPropietario().incrementarCapital(jugador.getUltimaTirada() * impuesto);

		this.companias.add(companiaOrig);
	}

}

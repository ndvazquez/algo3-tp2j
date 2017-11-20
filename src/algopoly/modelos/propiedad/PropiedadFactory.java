package algopoly.modelos.propiedad;

import java.util.ArrayList;

public class PropiedadFactory {

    public PropiedadSimple crearPropiedadSimple(Integer precio, ArrayList<Edificio> edificios){
        return new PropiedadSimple(precio, edificios);
    }

    public PropiedadRegional crearPropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
        return new PropiedadRegional(precio, region, precioCasa, precioHotel);
    }

	public Propiedad crearPropiedadSimple(Integer precio, Integer precio2) {
		return new PropiedadSimple(precio, precio2);
	}
}

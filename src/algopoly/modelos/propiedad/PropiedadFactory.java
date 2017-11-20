package algopoly.modelos.propiedad;

public class PropiedadFactory {

    public PropiedadSimple crearPropiedadSimple(Provincia provincia){
        return new PropiedadSimple(provincia);
    }

    public PropiedadRegional crearPropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
        return new PropiedadRegional(precio, region, precioCasa, precioHotel);
    }

	public Propiedad crearPropiedadSimple(Integer precio, Integer precio2) {
		return new PropiedadSimple(precio, precio2);
	}
}

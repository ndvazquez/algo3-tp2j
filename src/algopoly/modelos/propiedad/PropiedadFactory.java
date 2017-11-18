package algopoly.modelos.propiedad;

public class PropiedadFactory {

    public PropiedadSimple crearPropiedadSimple(Integer precio, Integer precioCasa){
        return new PropiedadSimple(precio, precioCasa);
    }

    public PropiedadRegional crearPropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
        return new PropiedadRegional(precio, region, precioCasa, precioHotel);
    }
}

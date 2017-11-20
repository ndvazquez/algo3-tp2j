package algopoly.modelos.tablero.propiedad;

public class PropiedadFactory {

    public PropiedadSimple crearPropiedadSimple(Provincia provincia){
        return new PropiedadSimple(provincia);
    }

    public PropiedadRegional crearPropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
        return new PropiedadRegional(precio, region, precioCasa, precioHotel);
    }

}

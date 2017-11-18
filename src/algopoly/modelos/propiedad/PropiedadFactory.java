package algopoly.modelos.tablero;

public class PropiedadFactory {

    public PropiedadSimple crearPropiedadSimple(Integer precio, Integer precioCasa, Integer precioHotel){
        return new PropiedadSimple(precio, precioCasa, precioHotel);
    }

    public PropiedadRegional crearPropiedadRegional(Integer precio, Region region, Integer precioCasa, Integer precioHotel){
        return new PropiedadRegional(precio, region, precioCasa, precioHotel);
    }
}

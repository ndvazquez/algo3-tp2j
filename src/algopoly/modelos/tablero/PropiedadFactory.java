package algopoly.modelos.tablero;

public class PropiedadFactory {

    public PropiedadSimple crearPropiedadSimple(Integer precio){
        return new PropiedadSimple(precio);
    }

    public PropiedadRegional crearPropiedadRegional(Integer precio, Region region){
        return new PropiedadRegional(precio, region);
    }
}

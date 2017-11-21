package algopoly.modelos.tablero.propiedad;

public class PropiedadFactory {

    public PropiedadSimple crearPropiedadSimple(Provincia provincia){
        return new PropiedadSimple(provincia);
    }

    public PropiedadRegional crearPropiedadRegional(Provincia provincia, Provincia provinciaComplemento){
        return new PropiedadRegional(provincia, provinciaComplemento);
    }

}

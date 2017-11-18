package algopoly.modelos.tablero;

public class PropiedadRegional extends PropiedadSimple implements Casillero, Propiedad{

    private Region region;

    public PropiedadRegional(Integer precio, Region region){
        super(precio);
        this.region = region;
    }

}

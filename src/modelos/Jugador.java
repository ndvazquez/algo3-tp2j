package modelos;

public class Jugador {
    private int capital;

    public Jugador() { this.capital = 100000; }

    public void incrementarCapital(int aumento){
        this.capital += aumento;
    }

    public int getCapital(){
        return this.capital;
    }
}

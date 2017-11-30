package algopoly.vistas;

import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.Carcel;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.Date;


public class VistaConsola {

    private Label consola;
    private ListView panel;
    private Integer numeroJugada;

    public VistaConsola(Label consola, ListView panel){
        this.consola = consola;
        this.panel = panel;
        this.numeroJugada = 0;
        this.update("");
    }

    public void update(String nuevoTexto){
        this.numeroJugada++;
        String jugada = String.format("Jugada %d.\n", numeroJugada);
        this.consola.setText(String.format("%s\n%s\n%s",this.consola.getText(), nuevoTexto,jugada));
        this.panel.scrollTo(0);
    }

}

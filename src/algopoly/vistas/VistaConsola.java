package algopoly.vistas;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class VistaConsola {
    private Label consola;
    private ListView panel;
    public VistaConsola(Label consola, ListView panel){
        this.consola = consola;
        this.panel = panel;
    }

    public void update(String nuevoTexto){
        this.consola.setText(this.consola.getText() + "\n" + nuevoTexto);
        this.panel.scrollTo(0);

    }
}

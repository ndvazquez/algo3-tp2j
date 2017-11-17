package algopoly.vistas.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import algopoly.vistas.BarraDeMenu;

public class AplicacionOnKeyPressEventHandler implements EventHandler<KeyEvent> {

    private Stage stage;
    private BarraDeMenu menuBar;

    public AplicacionOnKeyPressEventHandler(Stage stage, BarraDeMenu menuBar) {
        this.stage = stage;
        this.menuBar = menuBar;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ESCAPE) {
            stage.setMaximized(true);
            menuBar.aplicacionMaximizada();
        }
    }
}

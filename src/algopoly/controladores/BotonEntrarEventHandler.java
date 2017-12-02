package algopoly.controladores;

import algopoly.vistas.VistaInformacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    VistaInformacion vistaInformacion;
    
    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena, VistaInformacion vistaInformacion) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.vistaInformacion = vistaInformacion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        vistaInformacion.dibujar();
    }

}

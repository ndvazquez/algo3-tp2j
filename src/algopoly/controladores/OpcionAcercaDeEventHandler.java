package algopoly.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("AlgoPoly");
        String mensaje = "75.07 Algoritmos y  programación III. \n\n Nicolas Vazquez \n Camila Serra \n Eliana Gamarra \n Javier Albarracin";
        alert.setContentText(mensaje);
        alert.show();
    }
}

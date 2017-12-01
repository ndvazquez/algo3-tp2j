package algopoly.vistas;

import algopoly.controladores.AplicacionOnKeyPressEventHandler;
import algopoly.modelos.tablero.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Algopoly extends Application {



	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {

		stage.setTitle("AlgoPoly");

		Tablero tablero = new Tablero();

		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, tablero);
		Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);

		AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage,
				contenedorPrincipal.getBarraDeMenu());
		escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

		ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego, tablero, contenedorPrincipal.vistaInformacion);
		Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

		stage.setScene(escenaBienvenidos);
		stage.setFullScreen(true);

		stage.show();
	}


}

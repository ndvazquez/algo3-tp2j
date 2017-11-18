package algopoly.vistas;

import algopoly.modelos.tablero.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import algopoly.vistas.eventos.BotonMoverHandler;

public class ContenedorPrincipal extends BorderPane {

	BarraDeMenu menuBar;
	VistaTablero vistaTablero;
	Canvas canvasCentral;
	VBox contenedorCentral;
	VistaDados vistaDados;

	public ContenedorPrincipal(Stage stage, Tablero tablero) {
		this.setMenu(stage);
		this.setCentro(tablero);
		this.setConsola();
		this.setBotonera(tablero);
	}

	private void setBotonera(Tablero tablero) {

		Canvas canvasDados = new Canvas(50,50);
		vistaDados = new VistaDados(tablero, canvasDados);
		
		Button botonMover = new Button();
		botonMover.setText("Proximo turno");
		BotonMoverHandler moveButtonHandler = new BotonMoverHandler(vistaTablero, tablero, vistaDados);
		botonMover.setOnAction(moveButtonHandler);
		
		VBox contenedorVertical = new VBox(botonMover, canvasDados);
		contenedorVertical.setSpacing(10);
		contenedorVertical.setPadding(new Insets(15));

		this.setLeft(contenedorVertical);

	}

	private void setMenu(Stage stage) {
		this.menuBar = new BarraDeMenu(stage);
		this.setTop(menuBar);
	}

	private void setCentro(Tablero tablero) {
		canvasCentral = new Canvas(500, 500);
		vistaTablero = new VistaTablero(tablero, canvasCentral);
		vistaTablero.dibujar();

		contenedorCentral = new VBox(canvasCentral);
		contenedorCentral.setAlignment(Pos.CENTER);
		contenedorCentral.setSpacing(20);
		contenedorCentral.setPadding(new Insets(25));
		Image imagen = new Image("file:src/algopoly/vistas/imagenes/game.jpeg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		contenedorCentral.setBackground(new Background(imagenDeFondo));

		this.setCenter(contenedorCentral);
	}

	private void setConsola() {

		// TODO cambiar por el modelo de Consola...
		Label etiqueta = new Label();
		etiqueta.setText("consola...");
		etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
		etiqueta.setTextFill(Color.WHITE);

		VBox contenedorConsola = new VBox(etiqueta);
		contenedorConsola.setSpacing(10);
		contenedorConsola.setPadding(new Insets(15));
		contenedorConsola.setStyle("-fx-background-color: black;");

		this.setBottom(contenedorConsola);
	}

	public BarraDeMenu getBarraDeMenu() {
		return menuBar;
	}

}

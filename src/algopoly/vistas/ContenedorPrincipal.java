package algopoly.vistas;

import algopoly.modelos.tablero.Tablero;
import algopoly.vistas.eventos.BotonMoverHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;


public class ContenedorPrincipal extends BorderPane {

	BarraDeMenu menuBar;
	VistaTablero vistaTablero;
	Canvas canvasCentral;
	VBox contenedorCentral;
	VistaDados vistaDados;
	VistaInformacion vistaInformacion;
	MediaPlayer mediaPlayer;

	public ContenedorPrincipal(Stage stage, Tablero tablero) {
		this.setMenu(stage);
		this.setCentro(tablero);
		this.setInformacionJugadores(tablero);
		this.setBotonera(tablero);
		this.setConsola(tablero);
		this.mediaPlayer = new MediaPlayer(new Media(new File("music.wav").toURI().toString()));
		mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
		mediaPlayer.setAutoPlay(true);

	}

	private void setBotonera(Tablero tablero) {

		Canvas canvasDados = new Canvas(100,200);
		vistaDados = new VistaDados(tablero, canvasDados);
		
		Button botonMover = new Button();
		botonMover.setText("Proximo turno");
		BotonMoverHandler moveButtonHandler = new BotonMoverHandler(vistaTablero, tablero, vistaDados, vistaInformacion);
		botonMover.setOnAction(moveButtonHandler);
		
		Button botonVenderTerreno = new Button();
		botonVenderTerreno.setText("Vender terreno");
		BotonMoverHandler venderTerrenoHandler = new BotonMoverHandler(vistaTablero, tablero, vistaDados, vistaInformacion);
		botonVenderTerreno.setOnAction(venderTerrenoHandler);
		
		Button botonVenderCompania = new Button();
		botonVenderCompania.setText("Vender compañia");
		BotonMoverHandler venderCompaniaHandler = new BotonMoverHandler(vistaTablero, tablero, vistaDados, vistaInformacion);
		botonVenderCompania.setOnAction(venderCompaniaHandler);
		
		Button botonIntercambiar = new Button();
		botonIntercambiar.setText("Intercambiar propiedad");
		BotonMoverHandler intercambiarHandler = new BotonMoverHandler(vistaTablero, tablero, vistaDados, vistaInformacion);
		botonIntercambiar.setOnAction(intercambiarHandler);
		
		Button botonComprarCasa = new Button();
		botonComprarCasa.setText("Comprar casa");
		BotonMoverHandler comprarCasaHandler = new BotonMoverHandler(vistaTablero, tablero, vistaDados, vistaInformacion);
		botonComprarCasa.setOnAction(comprarCasaHandler);
		
		Button botonComprarHotel = new Button();
		botonComprarHotel.setText("Comprar hotel");
		BotonMoverHandler comprarHotelHandler = new BotonMoverHandler(vistaTablero, tablero, vistaDados, vistaInformacion);
		botonComprarHotel.setOnAction(comprarHotelHandler);
		
		VBox contenedorVertical = new VBox(botonMover, botonVenderTerreno, botonVenderCompania, botonIntercambiar, botonComprarCasa, botonComprarHotel, canvasDados);
		contenedorVertical.setPadding(new Insets(30));
		contenedorVertical.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		contenedorVertical.setSpacing(10);
		
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
	
	private void setInformacionJugadores(Tablero tablero) {
		
		Canvas canvasInfo = new Canvas(150, 500);
		vistaInformacion = new VistaInformacion(tablero, canvasInfo);
		vistaInformacion.dibujar();
		
		VBox contenedorVertical = new VBox(canvasInfo);
		
		contenedorVertical.setSpacing(10);
		contenedorVertical.setPadding(new Insets(30));
		contenedorVertical.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, null, null)));
		
		this.setRight(contenedorVertical);

	}
	
	private void setConsola(Tablero tablero) {

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


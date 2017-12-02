package algopoly.vistas;


import algopoly.controladores.BotonEntrarEventHandler;
import algopoly.modelos.tablero.Tablero;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena, Tablero tablero, VistaInformacion vista) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/algopoly/vistas/imagenes/game.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        
        TextField jugador1 = new TextField();
    	jugador1.setMaxWidth(300);
    	jugador1.setText("Jugador1");
    	jugador1.setOnKeyReleased(new EventHandler <KeyEvent>() {
            public void handle(KeyEvent k) {
                tablero.getJugadores().get(0).setNombre(jugador1.getText().equals("") ? "Jugador1" : jugador1.getText());
            } 
        });
    	
    	TextField jugador2 = new TextField();
    	jugador2.setMaxWidth(300);
    	jugador2.setText("Jugador2");
    	jugador2.setOnKeyReleased(new EventHandler <KeyEvent>() {
            public void handle(KeyEvent k) {
                tablero.getJugadores().get(1).setNombre(jugador2.getText().equals("") ? "Jugador2" : jugador2.getText());
            }
        });
    	
    	TextField jugador3 = new TextField();
    	jugador3.setMaxWidth(300);
    	jugador3.setText("Jugador3");
    	jugador3.setOnKeyReleased(new EventHandler <KeyEvent>() {
            public void handle(KeyEvent k) {
                tablero.getJugadores().get(2).setNombre(jugador3.getText().equals("") ? "Jugador3" : jugador3.getText());
            }
        });
    	
        Button botonEntrar = new Button();
        botonEntrar.setText("Iniciar Nueva Partida");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiqueta.setText("Bienvenidos a ALGOPOLY");
        etiqueta.setTextFill(Color.web("#66A7C5"));
        Image imagen2 = new Image("file:src/algopoly/vistas/imagenes/logo.png");
        ImageView iv = new ImageView(imagen2);
        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena, vista);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(iv, jugador1, jugador2, jugador3, botonEntrar);
    }


}

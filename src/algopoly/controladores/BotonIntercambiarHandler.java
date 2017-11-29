package algopoly.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.tablero.Tablero;
import algopoly.modelos.tablero.casilleros.barrios.Barrio;
import algopoly.vistas.VistaInformacion;
import algopoly.vistas.VistaTablero;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BotonIntercambiarHandler implements EventHandler<ActionEvent> {

    private final VistaTablero vista;
    private final Tablero tablero;
    private final VistaInformacion vistaInformacion;
    
    public BotonIntercambiarHandler(VistaTablero vista, Tablero tablero, VistaInformacion vistaInformacion) {
        this.vista = vista;
        this.tablero = tablero;
        this.vistaInformacion = vistaInformacion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	
    	Jugador jugador = tablero.jugadorActual();
    	
    	Button botonAceptar = new Button();
    	botonAceptar.setText("Aceptar");
    	botonAceptar.setDisable(true);
    	
    	ChoiceBox<String> barriosDeEsteJugador = new ChoiceBox<>();
    	ChoiceBox<String> oponentesDeEsteJugador = new ChoiceBox<>();
    	ChoiceBox<String> barriosDelOponente = new ChoiceBox<>();
    	
    	/** Seleccion de Barrios del Jugador Actual **/
		Collection<Barrio> barrios = jugador.getBarrios();
		List<String> propsDeEsteJugador = new ArrayList<>();
		
		for (Barrio barrio : barrios) {
			propsDeEsteJugador.add(barrio.getProvincia().name());
		}
		
		barriosDeEsteJugador.getItems().addAll(propsDeEsteJugador);
		
		
		/** Si es el ultimo campo que completo, habilitar el boton Aceptar **/
		
		barriosDeEsteJugador.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		      @Override
		      public void changed(ObservableValue<? extends String> observableValue, String nombrePorDefecto, String nombreSeleccionado) {
		    	  
		    	if(oponentesDeEsteJugador.getValue() != null && barriosDelOponente != null) {
		    		botonAceptar.setDisable(false);
		    	}
		      }
		    });
		
		
		/** Seleccion de Oponente con quien hacer el intercambio **/
		
		Collection<Jugador> oponentes = tablero.getJugadores();
		List<String> nombresDeOponentes = new ArrayList<>();
		
		for(Jugador oponente : oponentes) {
			nombresDeOponentes.add(oponente.getNombre());
		}
		
		nombresDeOponentes.remove(jugador.getNombre());
		oponentesDeEsteJugador.getItems().addAll(nombresDeOponentes);
		
		
		/** Seleccion de barrio del Oponente - si es el ultimo campo que completo, habilitar el boton Aceptar **/
		
		oponentesDeEsteJugador.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		      @Override
		      public void changed(ObservableValue<? extends String> observableValue, String nombrePorDefecto, String nombreSeleccionado) {
		    	  
		    	Jugador oponente = tablero.getJugadorPorNombre(nombreSeleccionado);
		    	
		    	barriosDelOponente.getItems().removeAll(barriosDelOponente.getItems());
		    	  
		    	Collection<Barrio> barrios = oponente.getBarrios();
		  		List<String> propsDelOponente = new ArrayList<>();
		  		
		  		for (Barrio barrio : barrios) {
		  			propsDelOponente.add(barrio.getProvincia().name());
		  		}
		  		
		  		barriosDelOponente.getItems().addAll(propsDelOponente);
		  		
		  		if(barriosDeEsteJugador.getValue() != null && barriosDelOponente.getValue() != null) {
		    		botonAceptar.setDisable(false);
		  		}
		      }
		    });
		
		/** Si es el ultimo campo que completo, habilitar el boton Aceptar **/
		
		barriosDelOponente.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		      @Override
		      public void changed(ObservableValue<? extends String> observableValue, String nombrePorDefecto, String nombreSeleccionado) {
		    	  
		    	if(barriosDeEsteJugador.getValue() != null && oponentesDeEsteJugador != null) {
		    		botonAceptar.setDisable(false);
		    	}
		      }
		    });
		
		

		/** Set up de la ventana **/
    	
    	Stage stage = new Stage();
    	stage.setTitle("Intercambiar Barrio");
    	
    	GridPane grid = new GridPane();
    	grid.setPadding(new Insets(10, 10, 10, 10));
    	grid.setVgap(8);
    	grid.setHgap(10);
    	
    	Label elegirPropEsteJugador = new Label("Elija un barrio a intercambiar:");
    	Label elegirOtroJugador = new Label("Elija un jugador con quien hacer el intercambio:");
    	Label elegirPropOtroJugador = new Label("Elija un barrio a recibir en el intercambio:");
    	
    	
    	
    	/** Manejar el intercambio  **/
    	botonAceptar.setOnAction(new EventHandler<ActionEvent>() {
    		
    		@Override
    		public void handle(ActionEvent event) {
    			
    			String nombreBarrioACeder = barriosDeEsteJugador.getValue();
    			String nombreJugadorQueIntercambia = oponentesDeEsteJugador.getValue();
    			String nombreBarrioARecibir = barriosDelOponente.getValue();
    			
    			Barrio barrioACeder = jugador.getBarrioPorNombre(nombreBarrioACeder);
    			Jugador jugadorQueIntercambia = tablero.getJugadorPorNombre(nombreJugadorQueIntercambia);
    			Barrio barrioARecibir = jugadorQueIntercambia.getBarrioPorNombre(nombreBarrioARecibir);
    			
    			/** Ordenar con gridpanes 
    			 * 
    			 * **/
    			
    			jugador.intercambiarBarrio(barrioACeder, barrioARecibir, jugadorQueIntercambia);
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Intercambio");
    			alert.setHeaderText("Intercambio Realizado!");
    			alert.setContentText(jugador.getNombre() 
    									+ " intercambio " + nombreBarrioACeder 
    									+ " por " + nombreBarrioARecibir 
    									+ " con " + nombreJugadorQueIntercambia);
    			
    			alert.showAndWait();
    			
    			stage.close();
    		}
    	});
    	
    	/** Mas Setup **/
    	
    	barriosDeEsteJugador.setMaxWidth(Double.MAX_VALUE);
    	oponentesDeEsteJugador.setMaxWidth(Double.MAX_VALUE);
    	barriosDelOponente.setMaxWidth(Double.MAX_VALUE);
    	botonAceptar.setMaxWidth(Double.MAX_VALUE);
    	
    	
    	GridPane.setConstraints(elegirPropEsteJugador, 0, 0);
    	GridPane.setConstraints(barriosDeEsteJugador, 1, 0);
    	GridPane.setConstraints(elegirOtroJugador, 0, 1);
    	GridPane.setConstraints(oponentesDeEsteJugador, 1, 1);
    	GridPane.setConstraints(elegirPropOtroJugador, 0, 2);
    	GridPane.setConstraints(barriosDelOponente, 1, 2);
    	GridPane.setConstraints(botonAceptar, 0, 4, 1, 1, HPos.CENTER, VPos.BOTTOM);
    	
    	grid.getChildren().addAll(elegirPropEsteJugador, 
    			barriosDeEsteJugador,
    			elegirOtroJugador,
    			oponentesDeEsteJugador,
    			elegirPropOtroJugador,
    			barriosDelOponente,
    			botonAceptar);
    	
    	Scene scene = new Scene(grid, 500, 150);
    	stage.setScene(scene);
    	stage.show();
    	
		vista.update(); // update imagen casa
		vistaInformacion.update(); // update plata
    }

}

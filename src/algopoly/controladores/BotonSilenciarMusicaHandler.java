package algopoly.controladores;

import javafx.scene.media.MediaPlayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonSilenciarMusicaHandler implements EventHandler<ActionEvent> {

    private final MediaPlayer mediaPlayer;

    public BotonSilenciarMusicaHandler( MediaPlayer reproductor){
        this.mediaPlayer = reproductor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MediaPlayer reproductor = this.mediaPlayer;
        if(reproductor.getStatus() == MediaPlayer.Status.PLAYING) reproductor.stop();
        else reproductor.play();
    }
}

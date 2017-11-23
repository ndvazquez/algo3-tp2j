package algopoly.vistas;
public class SoundPlayer {
	
	/**
	 * Reproductor de clips. Utiliza threads para poder reproducir los sonidos
	 * independientemente del thread en el que se ejecuta el juego.
	 * 
	 * Utilizar sonidos .wav de 16 bits.
	 * 
	 * Caso de uso basico:
	 * 
	 * SoundPlayer player = new SoundPlayer();
	 * 
	 * player.playSound("ruta_del_sonido");
	 * 
	 * listo.
	 * */
	
	public void playSound(String path) {
		
		Thread soundThread = new Thread(new SoundRunnable(path));
		soundThread.start();
	}
	
	public static class SoundRunnable implements Runnable {
		
		private String path;
		
		public SoundRunnable(String path) {
			this.path = path;
		}
		
		@Override
		public void run() {
			ClipPlayer player1 = new ClipPlayer();
			player1.play(path);
		}
	}
	
	
	
	/**
	 * 
	 * Programita para probarlo
	 * 
    public static void main(String[] args) {
    	
    	SoundPlayer player = new SoundPlayer();
    	
    	player.playSound(INSERTE_RUTA_DEL_SONIDO_AQUI);
    }
	*/
}

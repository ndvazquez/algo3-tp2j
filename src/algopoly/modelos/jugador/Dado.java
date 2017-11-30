package algopoly.modelos.jugador;

import java.util.Random;

public class Dado {

	private Integer ultimaTirada;
	
	public Dado() {
		this.ultimaTirada = 0;
	}
	
	public Integer tirar() {
		Random rand = new Random();
		this.ultimaTirada = 1+rand.nextInt(6);
		return this.ultimaTirada;
	}

	public Integer getUltimaTirada() {
		return this.ultimaTirada;
	}

	public void setTiradaNula() {
		this.ultimaTirada = 0;		
	}

}

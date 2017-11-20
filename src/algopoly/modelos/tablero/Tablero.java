package algopoly.modelos.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;

public class Tablero {

	private ArrayList<Jugador> jugadores;
	private ArrayList<Casillero> casilleros;
	private Integer turnoActual;

	public Tablero() {
		jugadores = new ArrayList<Jugador>();
		jugadores.add(new Jugador());
		jugadores.add(new Jugador());
		jugadores.add(new Jugador());

		turnoActual = (new Random().nextInt(3));

		this.armarCasilleros();
	}

	private void armarCasilleros() {
		Carcel carcel = new Carcel();

		Servicios serviciosTrenSubte = new Servicios();
		Compania tren = new Compania(38000, 450, 800, serviciosTrenSubte);
		Compania subte = new Compania(40000, 600, 1100, serviciosTrenSubte);

		Servicios serviciosEdesurAysa = new Servicios();
		Compania edesur = new Compania(35000, 500, 1000, serviciosEdesurAysa);
		Compania aysa = new Compania(30000, 300, 500, serviciosEdesurAysa);

		casilleros = new ArrayList<Casillero>();
		casilleros.add(new PropiedadSimple(10)); // salida
		casilleros.add(new Quini6(this.jugadores));
		casilleros.add(new PropiedadSimple(10));// bsassur
		casilleros.add(edesur);
		casilleros.add(new PropiedadSimple(10));// bsasnorte
		casilleros.add(carcel);
		casilleros.add(new PropiedadSimple(10)); // cordoba
		casilleros.add(new AvanceDinamico());
		casilleros.add(subte);
		casilleros.add(new PropiedadSimple(10)); // cordoba
		casilleros.add(new PropiedadSimple(10)); // impuesto
		casilleros.add(new PropiedadSimple(10)); // santafe
		casilleros.add(aysa);
		casilleros.add(new PropiedadSimple(10)); // salta
		casilleros.add(new PropiedadSimple(10));// salta
		casilleros.add(new Policia(carcel));
		casilleros.add(tren);
		casilleros.add(new PropiedadSimple(10));// neuquen
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(new PropiedadSimple(10)); // tucuman1
	}

	public void ganador() {

	}

	public Jugador jugadorAcutal() {
		return this.jugadores.get(this.turnoActual);
	}

	public void proximoTurno() {
		this.turnoActual = (this.turnoActual + 1) % 3;
		Jugador jugador = this.jugadorAcutal();
		jugador.iniciarTurno();

		Casillero casilleroActual = casilleros.get(Posicion.getIndice(jugador.getPosicion()));
		casilleroActual.recibirJugador(jugador);

		// esto por ahi es mejor que vaya en otro lado
		if (casilleroActual.getClass().equals(AvanceDinamico.class)
				|| casilleroActual.getClass().equals(RetrocesoDinamico.class)) {
			casilleroActual = casilleros.get(Posicion.getIndice(jugador.getPosicion()));
			casilleroActual.recibirJugador(jugador);
		}
	}

	public List<Jugador> getJugadores() {
		return this.jugadores;
	}

}

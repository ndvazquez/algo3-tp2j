package algopoly.modelos.tablero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;
import algopoly.modelos.tablero.servicios.Compania;
import algopoly.modelos.tablero.servicios.Servicios;
import algopoly.modelos.tablero.propiedad.PropiedadFactory;
import algopoly.modelos.tablero.propiedad.Provincia;

public class Tablero {

	private ArrayList<Jugador> jugadores;
	private ArrayList<Casillero> casilleros;
	private Integer turnoActual;
	private Integer turnosJugados;

	public Tablero() {
		jugadores = new ArrayList<Jugador>();
		Jugador jugador1 = new Jugador();
		jugador1.setNombre("Alan");

		Jugador jugador2 = new Jugador();
		jugador2.setNombre("Barbara");

		Jugador jugador3 = new Jugador();
		jugador3.setNombre("Linus");

		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadores.add(jugador3);

		turnosJugados = 0;
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
		PropiedadFactory propiedadFactory = new PropiedadFactory();
		casilleros = new ArrayList<Casillero>();
		casilleros.add(new Salida()); // salida
		casilleros.add(new Quini6(this.jugadores));
		casilleros.add(propiedadFactory.crearPropiedadRegional(Provincia.BSAS_SUR, Provincia.BSAS_NORTE));// bsassur
		casilleros.add(edesur);
		casilleros.add(propiedadFactory.crearPropiedadRegional(Provincia.BSAS_NORTE, Provincia.BSAS_SUR));// bsasnorte
		casilleros.add(carcel);
		casilleros.add(propiedadFactory.crearPropiedadRegional(Provincia.CORDOBA_SUR, Provincia.CORDOBA_NORTE)); // cordoba
		casilleros.add(new AvanceDinamico());
		casilleros.add(subte);
		casilleros.add(propiedadFactory.crearPropiedadRegional(Provincia.CORDOBA_NORTE, Provincia.CORDOBA_SUR)); // cordoba
		casilleros.add(new ImpuestoDeLujo()); // impuesto
		casilleros.add(propiedadFactory.crearPropiedadSimple(Provincia.SANTA_FE)); // santafe
		casilleros.add(aysa);
		casilleros.add(propiedadFactory.crearPropiedadRegional(Provincia.SALTA_SUR, Provincia.SALTA_NORTE)); // salta
		casilleros.add(propiedadFactory.crearPropiedadRegional(Provincia.SALTA_NORTE, Provincia.SALTA_SUR));// salta
		casilleros.add(new Policia(carcel));
		casilleros.add(tren);
		casilleros.add(propiedadFactory.crearPropiedadSimple(Provincia.NEUQUEN));// neuquen
		casilleros.add(new RetrocesoDinamico());
		casilleros.add(propiedadFactory.crearPropiedadSimple(Provincia.TUCUMAN)); // tucuman1
	}

	public Jugador jugadorActual() {
		return this.jugadores.get(this.turnoActual);
	}

	public void proximoTurno() {

		this.turnosJugados++;
		Jugador jugador = this.jugadorActual();
		jugador.iniciarTurno();

		Casillero casilleroActual = casilleros.get(Posicion.getIndice(jugador.getPosicion()));
		// esto por ahi es mejor que vaya en otro lado
		if(!casilleroActual.getClass().equals(Carcel.class)){
			casilleroActual.recibirJugador(jugador);
		}

		// esto por ahi es mejor que vaya en otro lado
		if (casilleroActual.getClass().equals(AvanceDinamico.class)
				|| casilleroActual.getClass().equals(RetrocesoDinamico.class)) {
			casilleroActual = casilleros.get(Posicion.getIndice(jugador.getPosicion()));
			casilleroActual.recibirJugador(jugador);
		}

		if (!jugador.sacoDoble() || this.turnosJugados.equals(2)){
			this.turnoActual = (this.turnoActual + 1) % this.jugadores.size();
			this.turnosJugados = 0;
		}
	}

	public List<Jugador> getJugadores() {
		return this.jugadores;
	}

	public void eliminarJugador(Jugador jugador){
		this.jugadores.remove(jugador);
        this.turnoActual = (this.turnoActual + 1) % 3;
        this.turnosJugados = 0;
	}

	public boolean terminoLaPartida(){
		return this.jugadores.size() == 1;
	}
}

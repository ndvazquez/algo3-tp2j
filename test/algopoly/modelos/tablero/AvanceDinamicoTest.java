
package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {

	/*** Tests dados 2 - 6 ***/
	@Test
	public void test01JugadorCaeEnAvanceDinamicoSacando2SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		jugador.setUltimaTirada(2);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (2 - 2), indiceFinal);
	}

	@Test
	public void test02JugadorCaeEnAvanceDinamicoSacando3SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		jugador.setUltimaTirada(3);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (3 - 2), indiceFinal);
	}

	@Test
	public void test03JugadorCaeEnAvanceDinamicoSacando4SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		jugador.setUltimaTirada(4);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (4 - 2), indiceFinal);
	}

	@Test
	public void test04JugadorCaeEnAvanceDinamicoSacando5SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		jugador.setUltimaTirada(5);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (5 - 2), indiceFinal);
	}

	@Test
	public void test05JugadorCaeEnAvanceDinamicoSacando6SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		jugador.setUltimaTirada(6);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (6 - 2), indiceFinal);
	}

	/*** Tests dados 7 - 10 ***/
	@Test
	public void test06JugadorCaeEnAvanceDinamicoTirando7AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Jugador jugador = new Jugador(); // plata inicial 100000
		jugador.setUltimaTirada(7);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (100000 % 7), indiceFinal);
	}

	@Test
	public void test07JugadorCaeEnAvanceDinamicoTirando8AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Jugador jugador = new Jugador(); // plata inicial 100000
		jugador.setUltimaTirada(8);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (100000 % 8), indiceFinal);
	}

	@Test
	public void test08JugadorCaeEnAvanceDinamicoTirando9AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Jugador jugador = new Jugador(); // plata inicial 100000
		jugador.setUltimaTirada(9);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (100000 % 9), indiceFinal);
	}

	@Test
	public void test09JugadorCaeEnAvanceDinamicoTirando10AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Jugador jugador = new Jugador(); // plata inicial 100000
		jugador.setUltimaTirada(10);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (100000 % 10), indiceFinal);
	}

	/*** Tests dados 11 -12 ***/
	@Test
	public void test10JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDePropiedadesSinPropiedades() {
		Jugador jugador = new Jugador(); // propiedades = 0
		jugador.setUltimaTirada(11);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (11 - 0), indiceFinal);
	}

	@Test
	public void test11JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDePropiedadesConPropiedades() {
		Jugador jugador = new Jugador(); 
		jugador.comprarPropiedad(new Propiedad());
		jugador.setUltimaTirada(11);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (11 - 1), indiceFinal);
	}
	
	@Test
	public void test12JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDePropiedadesConPropiedadesMayorA11() {
		Jugador jugador = new Jugador(); 
		for (int i=0; i<20; i++)
			jugador.comprarPropiedad(new Propiedad());
		jugador.setUltimaTirada(11);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (11 - 20), indiceFinal);
	}
	
	@Test
	public void test13JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDePropiedadesSinPropiedades() {
		Jugador jugador = new Jugador(); // propiedades = 0
		jugador.setUltimaTirada(12);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (12 - 0), indiceFinal);
	}
	
	@Test
	public void test14JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDePropiedadesConPropiedades() {
		Jugador jugador = new Jugador(); 
		jugador.comprarPropiedad(new Propiedad());
		jugador.setUltimaTirada(12);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (12 - 1), indiceFinal);
	}
	
	@Test
	public void test15JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDePropiedadesConPropiedadesMayorA12() {
		Jugador jugador = new Jugador(); 
		for (int i=0; i<20; i++)
			jugador.comprarPropiedad(new Propiedad());
		jugador.setUltimaTirada(12);
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		int indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		int indiceFinal = jugador.getPosicion();

		Assert.assertEquals(indiceActual + (12 - 20), indiceFinal);
	}
}

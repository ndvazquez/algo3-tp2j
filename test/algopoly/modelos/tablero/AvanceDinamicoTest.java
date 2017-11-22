package algopoly.modelos.tablero;

import algopoly.modelos.jugador.Jugador;
import algopoly.modelos.jugador.Posicion;
import algopoly.modelos.tablero.propiedad.PropiedadSimple;

import org.mockito.Mockito;

import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {

	/*** Tests dados 2 - 6 ***/
	@Test
	public void test01JugadorCaeEnAvanceDinamicoSacando2SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		
		Integer valor = jugador.tirar();
		while (!valor.equals(2)) {
			valor = jugador.tirar();
		}
		
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 2-2);
	}

	@Test
	public void test02JugadorCaeEnAvanceDinamicoSacando3SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		Integer valor = jugador.tirar();
		while (!valor.equals(3)) {
			valor = jugador.tirar();
		}
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 3-2);
	}

	@Test
	public void test03JugadorCaeEnAvanceDinamicoSacando4SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		Integer valor = jugador.tirar();
		while (!valor.equals(4)) {
			valor = jugador.tirar();
		}
		
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();
		
		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 4 - 2);
	}

	@Test
	public void test04JugadorCaeEnAvanceDinamicoSacando5SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		Integer valor = jugador.tirar();
		while (!valor.equals(5)) {
			valor = jugador.tirar();
		}		

		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 5 - 2);
	}

	@Test
	public void test05JugadorCaeEnAvanceDinamicoSacando6SuPosicionSeIncrementa2MenosQueLaTirada() {
		Jugador jugador = new Jugador();
		Integer valor = jugador.tirar();
		while (!valor.equals(6)) {
			valor = jugador.tirar();
		}
		
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 6 - 2);
	}

	/*** Tests dados 7 - 10 ***/
	@Test
	public void test06JugadorCaeEnAvanceDinamicoTirando7AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Jugador jugador = new Jugador(); // plata inicial 100000
		Integer valor = jugador.tirar();
		while (!valor.equals(7)) {
			valor = jugador.tirar();
		}
		
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 100000 % 7);
	}

	@Test
	public void test07JugadorCaeEnAvanceDinamicoTirando8AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Jugador jugador = new Jugador(); // plata inicial 100000
		Integer valor = jugador.tirar();
		while (!valor.equals(8)) {
			valor = jugador.tirar();
		}
		
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 100000 % 8);
	}

	@Test
	public void test08JugadorCaeEnAvanceDinamicoTirando9AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Jugador jugador = new Jugador(); // plata inicial 100000
		Integer valor = jugador.tirar();
		while (!valor.equals(9)) {
			valor = jugador.tirar();
		}
		
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 100000 % 9);
	}

	@Test
	public void test09JugadorCaeEnAvanceDinamicoTirando10AvanzaSuCantidadDeEfectivoModuloLaTirada() {
		Jugador jugador = new Jugador(); // plata inicial 100000
		Integer valor = jugador.tirar();
		while (!valor.equals(10)) {
			valor = jugador.tirar();
		}
		
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 100000 % 10);
	}

	/*** Tests dados 11 -12 ***/
	@Test
	public void test10JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDePropiedadesSinPropiedades() {
		Jugador jugador = new Jugador(); // propiedades = 0
		Integer valor = jugador.tirar();
		while (!valor.equals(11)) {
			valor = jugador.tirar();
		}
		
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 11 - 0);
	}

	@Test
	public void test11JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDePropiedadesConPropiedades() {
		Jugador jugador = new Jugador();
		jugador.comprarPropiedad(Mockito.mock(PropiedadSimple.class));
		Integer valor = jugador.tirar();
		while (!valor.equals(11)) {
			valor = jugador.tirar();
		}
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 11 - 1);
	}

	@Test
	public void test12JugadorCaeEnAvanceDinamicoTirando11Avanza11MenosSuCantidadDePropiedadesConPropiedadesMayorA11() {

		Jugador jugador = new Jugador();
		for (int i=0; i<20; i++) {
			jugador.comprarPropiedad(Mockito.mock(PropiedadSimple.class));
		}
		Integer valor = jugador.tirar();
		while (!valor.equals(11)) {
			valor = jugador.tirar();
		}
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, Posicion.cantidadPosiciones() + (11 - 20));
	}

	@Test
	public void test13JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDePropiedadesSinPropiedades() {
		Jugador jugador = new Jugador(); // propiedades = 0
		Integer valor = jugador.tirar();
		while (!valor.equals(12)) {
			valor = jugador.tirar();
		}
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 12 - 0);
	}

	@Test
	public void test14JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDePropiedadesConPropiedades() {
		Jugador jugador = new Jugador();
		jugador.comprarPropiedad(Mockito.mock(PropiedadSimple.class));
		Integer valor = jugador.tirar();
		while (!valor.equals(12)) {
			valor = jugador.tirar();
		}
		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();

		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, 12 - 1);
	}

	@Test
	public void test15JugadorCaeEnAvanceDinamicoTirando12Avanza12MenosSuCantidadDePropiedadesConPropiedadesMayorA12() {
		Jugador jugador = new Jugador();
		for (int i=0; i<20; i++){
			jugador.comprarPropiedad(Mockito.mock(PropiedadSimple.class));
		}
		Integer valor = jugador.tirar();
		while (!valor.equals(12)) {
			valor = jugador.tirar();
		}

		AvanceDinamico avanceDinamico = new AvanceDinamico();

		Posicion indiceActual = jugador.getPosicion();
		avanceDinamico.recibirJugador(jugador);
		Posicion indiceFinal = jugador.getPosicion();
		
		int diferencia = Posicion.cantidadCasillerosEntre(indiceActual, indiceFinal);
		Assert.assertEquals(diferencia, Posicion.cantidadPosiciones() + (12 - 20));
	}
}

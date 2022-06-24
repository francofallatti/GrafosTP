package Test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import Main.Espia;
import Main.Juego;

public class JuegoTest {
	
	private Juego juego;
	private Espia espia1;
	private Espia espia2;
	
	@Before 
	public void SetUp() {
		juego = Juego.iniciarJuego();
		espia1 = new Espia("Espia1");
		espia2 = new Espia("Espia2");
		juego.agregarEspia(espia1.getNombre());	
		juego.agregarEspia(espia2.getNombre());	
		juego.cargarEncuentros();
		juego.agregarEncuentro(8.0, espia1.getNombre(), espia2.getNombre());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarEspiasErrorTest() {
		juego.agregarEspia(null);
		juego.agregarEspia("");
	}
	
	@Test
	public void getEspiasTest() {
		Juego juego2 = Juego.iniciarJuego();
		assertEquals(juego2.getEspias(), new HashSet<Espia>());
	}
}

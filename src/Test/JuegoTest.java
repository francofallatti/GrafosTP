package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Grafos.GrafoConPeso;
import Main.Espia;
import Main.Juego;

public class JuegoTest {
	
	private Juego juego;
	private Espia espia1;
	private Espia espia2;
	
	@Before 
	public void SetUp() {
		juego = juego.iniciarJuego();
		GrafoConPeso grafoEspias = new GrafoConPeso(5);
		juego.agregarEspia("Espia1");	
		juego.agregarEspia("Espia2");	
		juego.cargarEncuentros();
		juego.agregarEncuentro(8.0, "Espia1", "Espia2");
		juego.jugar();
		espia1 = new Espia("Espia1");
		espia2 = new Espia("Espia1");
		
	}
	@Test
	public void puedenEncontrarseTest() {
		espia1 = new Espia("Espia1");
		espia2 = new Espia("Espia1");
		assertFalse(juego.puedenEncontrarse(espia1, espia2));
	}
	
	@Test
	public void getEspiasTest() {
		Juego juego2 = juego.iniciarJuego();
		assertEquals(juego2.getEspias(), null);
	}
	
	@Test
	public void getEspiasKeyTest() {
		
	}
	
	@Test
	public void getGrafoTest() {
		
	}
}

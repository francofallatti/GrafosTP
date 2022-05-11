package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Main.Espia;

public class EspiaTest {

	private Espia espia;
	
	@Before
	public void SetUp() {
		espia = new Espia("Espia1");
	}
	
	@Test
	public void tieneMesajeFalseTest() {
		assertFalse(espia.tieneMensaje());
	}
	
	@Test
	public void recibirMensajeTest() {
		espia.recibirMensaje("Mensaje para el espia");
		assertTrue(espia.tieneMensaje());
	}
	@Test
	public void getNombreTest() {
		assertEquals("Espia1",espia.getNombre());
	}
	@Test
	public void getMensajeTest() {
		espia.recibirMensaje("Mensaje para el espia");
		assertEquals("Mensaje para el espia",espia.getMensaje());
	}
}

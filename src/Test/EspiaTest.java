package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Main.Espia;

public class EspiaTest {

	private Espia espia;
	
	@Before
	public void SetUp() {
		espia = new Espia("Juan");
	}
	
	@Test
	public void getNombreTest() {
		assertEquals("Juan",espia.getNombre());
	}

}

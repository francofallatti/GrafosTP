package Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Grafos.GrafoConPeso;

public class GrafoConPesoTest {

	private GrafoConPeso grafoConPeso;

	@Before
	public void SetUp() {
		grafoConPeso = new GrafoConPeso(5);
		grafoConPeso.agregarArista(1, 2);
		grafoConPeso.agregarPesoArista(0.3, 1, 2);
	}
	
	@Test
	public void PesoEntreAristasTest() {
		Asserts.EqualsDouble(0.3, grafoConPeso.getPesoDeAristas(1, 2));
	}

	@Test
	public void PesoEntreAristasNotEqualsTest() {
		Asserts.NotEqualsDouble(0.2, grafoConPeso.getPesoDeAristas(1, 2));
	}

	@Test
	public void getPesosDeAristasNotEqualsTest() {
		assertNotEquals(0.4,grafoConPeso.getPesosDeAristas(1));
	}
	@Test
	public void pesosTest() {
		GrafoConPeso grafoConPeso2 = new GrafoConPeso(2);
		grafoConPeso2.agregarArista(0, 1);
		grafoConPeso2.agregarPesoArista(0, 0, 1);
		assertTrue(grafoConPeso2.getPesoDeAristas(0, 1) == 0);
	}
	
}

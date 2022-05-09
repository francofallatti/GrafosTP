package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Grafos.Grafo;
import Grafos.GrafoConPeso;
import Test.Asserts;

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
	public void getPesosDeAristasTest() {
		double[] pesos = new double[] { 0.3 };
		assertEquals(pesos, grafoConPeso.getPesosDeAristas(1));
	}
	@Test
	public void getPesosDeAristasNotEqualsTest() {
		assertNotEquals(0.4,grafoConPeso.getPesosDeAristas(1));
	}

}

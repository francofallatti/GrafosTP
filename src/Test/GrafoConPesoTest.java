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
	@Test
	public void getMatrizConPesosTest() {
		GrafoConPeso grafoConPeso2 = new GrafoConPeso(2);
		grafoConPeso2.agregarArista(0, 1);
		grafoConPeso2.agregarPesoArista(0, 0, 1);
		assertEquals(0, grafoConPeso2.getMatrizConPesos());
	}
	
	@Test
	public void toStringTest() {
		GrafoConPeso grafoConPeso2 = new GrafoConPeso(2);
		grafoConPeso2.agregarArista(0, 1);
		grafoConPeso2.agregarPesoArista(0, 0, 1);
		String s= "0.0 0.0\n0.0 0.0";
		assertEquals(s,((String) grafoConPeso2.toString()));
	}
}

package Test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Grafos.Grafo;

public class GrafosTest {

	private Grafo grafo;

	@Before
	public void SetUp() {
		grafo = new Grafo(5);
	}

	@Test
	public void aristaExistenteTest() {
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(2, 3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest() {
		grafo.agregarArista(5, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest() {
		grafo.agregarArista(2, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest() {
		grafo.agregarArista(2, 5);
	}
	@Test(expected = IllegalArgumentException.class)
	public void VerifDIstintodTest() {
		grafo.agregarArista(2, 2);
	}

	@Test
	public void aristaOpuestaTest() {
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(3, 2));

	}

	@Test
	public void aristaInexistenteTest() {
		grafo.agregarArista(2, 3);
		assertFalse(grafo.existeArista(1, 4));

	}

	@Test
	public void tamanoTest() {
		assertEquals(grafo.tamano(), 5);
	}

	@Test
	public void tamanoNotEqualsTest() {
		assertNotEquals(grafo.tamano(), 10);
	}

	@Test
	public void getVecinosTest() {
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		Set<Integer> vecinoSet = new HashSet<Integer>();
		vecinoSet.add(1);
		vecinoSet.add(2);

		assertEquals(vecinoSet, grafo.getVecinos(0));
	}

	@Test
	public void getVecinosNotEqualsTest() {
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		Set<Integer> vecinoSet = new HashSet<Integer>();
		vecinoSet.add(1);
		vecinoSet.add(2);
		vecinoSet.add(3);

		assertNotEquals(vecinoSet, grafo.getVecinos(0));
	}

	@Test
	public void eliminarAristaTest() {
		grafo.agregarArista(1, 2);
		grafo.eliminarArista(1, 2);
		assertFalse(grafo.existeArista(1, 2));
	}

}

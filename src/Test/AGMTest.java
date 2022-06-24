package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Grafos.AGMinimo;
import Grafos.GrafoConPeso;

public class AGMTest {
	
	private AGMinimo agm;
	private AGMinimo agmSimulado;
	private GrafoConPeso gTest;
	private GrafoConPeso g;
	
	@Before 
	public void SetUp() {
		g = new GrafoConPeso(9);
		g.agregarArista(0, 1);
		g.agregarArista(1, 2);
		g.agregarArista(0, 7);
		g.agregarArista(1, 7);
		g.agregarArista(2, 8);
		g.agregarArista(7, 8);
		g.agregarArista(7, 6);
		g.agregarArista(8, 6);
		g.agregarArista(6, 5);
		g.agregarArista(2, 5);
		g.agregarArista(3, 5);
		g.agregarArista(3, 4);
		g.agregarArista(5, 4);
		g.agregarArista(2, 3);
		g.agregarPesoArista(4, 0, 1);
		g.agregarPesoArista(8, 1, 2);
		g.agregarPesoArista(8, 0, 7);
		g.agregarPesoArista(12, 1, 7);
		g.agregarPesoArista(3, 2, 8);
		g.agregarPesoArista(6, 7, 8);
		g.agregarPesoArista(1, 7, 6);
		g.agregarPesoArista(5, 8, 6);
		g.agregarPesoArista(3, 6, 5);
		g.agregarPesoArista(4, 2, 5);
		g.agregarPesoArista(13, 3, 5);
		g.agregarPesoArista(9, 3, 4);
		g.agregarPesoArista(10, 5, 4);
		g.agregarPesoArista(6, 2, 3);
		
		gTest = new GrafoConPeso(9);
	}
	@Test
	public void kruskalTest() {
		gTest.agregarArista(7, 6);
		gTest.agregarArista(2, 8);
		gTest.agregarArista(6, 5);
		gTest.agregarArista(2, 5);
		gTest.agregarArista(0, 1);
		gTest.agregarArista(2, 3);
		gTest.agregarArista(0, 7);
		gTest.agregarArista(3, 4);
		
		gTest.agregarPesoArista(1, 7, 6);
		gTest.agregarPesoArista(3, 2, 8);
		gTest.agregarPesoArista(3, 6, 5);
		gTest.agregarPesoArista(4, 2, 5);
		gTest.agregarPesoArista(4, 0, 1);
		gTest.agregarPesoArista(6, 2, 3);
		gTest.agregarPesoArista(8, 0, 7);
		gTest.agregarPesoArista(9, 3, 4);
		agm = AGMinimo.kruskal(g);
		agmSimulado = AGMinimo.kruskal(gTest);
		assertEquals(agm, agmSimulado);
	}
	@Test
	public void primTest() {
		gTest.agregarArista(0, 1);	//AyB
		gTest.agregarArista(1, 2);	//ByC
		gTest.agregarArista(2, 8);	//CyI
		gTest.agregarArista(2, 5);	//CyF
		gTest.agregarArista(6, 5);	//GyF
		gTest.agregarArista(7, 6);	//HyG
		gTest.agregarArista(2, 3);	//CyD
		gTest.agregarArista(3, 4);	//DyE
		
		gTest.agregarPesoArista(4, 0, 1);	//AyB
		gTest.agregarPesoArista(8, 1, 2);	//ByC
		gTest.agregarPesoArista(3, 2, 8);	//CyI
		gTest.agregarPesoArista(4, 2, 5);	//CyF
		gTest.agregarPesoArista(3, 6, 5);	//GyF
		gTest.agregarPesoArista(1, 7, 6);	//HyG
		gTest.agregarPesoArista(6, 2, 3);	//CyD
		gTest.agregarPesoArista(9, 3, 4);	//DyE
		agm = AGMinimo.prim(g);
		agmSimulado = AGMinimo.prim(gTest);
		assertEquals(agm, agmSimulado);
	}
}

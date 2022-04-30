package Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Grafos.Grafo;

public class GrafosTest {

	@Test
	public void aristaExistenteTest (){
		
	    Grafo grafo = new Grafo(5);
	    grafo.agregarArista(2, 3);
	    assertTrue(grafo.existeArista(2, 3));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest ()
	{
	    Grafo grafo = new Grafo(5);
	    grafo.agregarArista(5, 2);
	}
	@Test (expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest (){
	    Grafo grafo = new Grafo(5);
	    grafo.agregarArista(2, -1);
	}
	@Test (expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest ()
	{
	    Grafo grafo = new Grafo(5);
	    grafo.agregarArista(2, 5);
	}
	
	@Test
	public void aristaOpuestaTest () {
	    
		Grafo grafo = new Grafo(5);
	    grafo.agregarArista(2, 3);
	    assertTrue(grafo.existeArista(3, 2));
	    
	}
	
	@Test
	public void aristaInexistenteTest () {
		
	    Grafo grafo = new Grafo(5);
	    grafo.agregarArista(2, 3);
	    assertFalse(grafo.existeArista(1, 4));
	    
	}

}

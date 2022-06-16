package Grafos;

import java.util.LinkedList;
import java.util.List;

public class AGMinimo {

	private GrafoConPeso grafo;
	private Integer cantVertices;

	private AGMinimo(GrafoConPeso g) {
		grafo = new GrafoConPeso(g.tamano());
		cantVertices = g.tamano();
	}

	public Integer cantVertices() {
		return cantVertices;
	}
	
	public void agregarPesoArista(double peso, int i, int j) {
		grafo.agregarPesoArista(peso, i, j);
	}

	public static AGMinimo prim(GrafoConPeso g) {
		AGMinimo agm = new AGMinimo(g);
		List<Integer> vertVisitados = new LinkedList<Integer>();
		vertVisitados.add(0);
		return prim(agm, g, vertVisitados);
	}

	public static AGMinimo prim(AGMinimo agm, GrafoConPeso g, List<Integer> vertVisitados) {
		if(vertVisitados.size() == g.tamano()-1) {
			return agm;
		}
		else {
			Integer i = vertVisitados.size()-1;
			Tupla<Double, Integer> aristaMin = g.dameAristaMin(i);
			agm.agregarPesoArista(aristaMin.getE1(), i, aristaMin.getE2());
			vertVisitados.add(aristaMin.getE2());
			return prim(agm, g, vertVisitados);
		}
	}

}

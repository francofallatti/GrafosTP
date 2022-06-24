package Grafos;

import java.util.LinkedList;
import java.util.List;

public class AGMinimo extends GrafoConPeso {

	private AGMinimo(Integer cantVertices) {
		super(cantVertices);
	}
	
	public static AGMinimo kruskal(GrafoConPeso g) {
		AGMinimo agm = new AGMinimo(g.tamano());
		List<AristaConPeso> aristasVisitadas = new LinkedList<AristaConPeso>(); // Et
		List<Integer> vertVisitados = new LinkedList<Integer>();
		return kruskal(agm, g, aristasVisitadas, vertVisitados, 1);
	}

	private static AGMinimo kruskal(AGMinimo agm, GrafoConPeso g, List<AristaConPeso> aristasVisitadas,
			List<Integer> vertVisitados, Integer i) {
		if (i == g.tamano()) {
			return agm;
		} else {
			AristaConPeso aristaMin = g.dameAristaMin(aristasVisitadas, vertVisitados);
			agm.agregarArista(aristaMin.getExtremo1(), aristaMin.getExtremo2());
			agm.agregarPesoArista(aristaMin.getPeso(), aristaMin.getExtremo1(), aristaMin.getExtremo2());
			aristasVisitadas.add(aristaMin);
			if (!vertVisitados.contains(aristaMin.getExtremo1())) {
				vertVisitados.add(aristaMin.getExtremo1());
			}
			if (!vertVisitados.contains(aristaMin.getExtremo2())) {
				vertVisitados.add(aristaMin.getExtremo2());
			}
			return kruskal(agm, g, aristasVisitadas, vertVisitados, i++);
		}
	}

	public static AGMinimo prim(GrafoConPeso g) {
		AGMinimo agm = new AGMinimo(g.tamano());
		List<AristaConPeso> aristasVisitadas = new LinkedList<AristaConPeso>(); // Et
		List<Integer> vertVisitados = new LinkedList<Integer>();
		vertVisitados.add(0);
		System.out.println(agm.tamano());
		return prim(agm, g, vertVisitados, 1, aristasVisitadas);
	}

	private static AGMinimo prim(AGMinimo agm, GrafoConPeso g, List<Integer> vertVisitados,	Integer i, List<AristaConPeso> av) {
		if (vertVisitados.size() == g.tamano() && BFS.esConexo(agm)) {
			return agm;
		} else {
			AristaConPeso aristaMin = g.dameAristaMinPrim(av, vertVisitados);
			agm.agregarArista(aristaMin.getExtremo1(), aristaMin.getExtremo2());
			agm.agregarPesoArista(aristaMin.getPeso(), aristaMin.getExtremo1(), aristaMin.getExtremo2());
			av.add(aristaMin);
			if (!vertVisitados.contains(aristaMin.getExtremo1())) {
				vertVisitados.add(aristaMin.getExtremo1());
			}
			if (!vertVisitados.contains(aristaMin.getExtremo2())) {
				vertVisitados.add(aristaMin.getExtremo2());
			}
			return prim(agm, g, vertVisitados, vertVisitados.size(), av);
		}
	}

}

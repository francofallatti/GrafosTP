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
		return kruskal(agm, g, aristasVisitadas, vertVisitados);
	}

	private static AGMinimo kruskal(AGMinimo agm, GrafoConPeso g, List<AristaConPeso> aristasVisitadas,
			List<Integer> vertVisitados) {
		if (vertVisitados.size() == g.tamano() && BFS.esConexo(agm)) {
			return agm;
		} else {
			AristaConPeso aristaMin = g.dameAristaMinKruskal(aristasVisitadas, vertVisitados, agm);
			agm.agregarArista(aristaMin.getExtremo1(), aristaMin.getExtremo2());
			agm.agregarPesoArista(aristaMin.getPeso(), aristaMin.getExtremo1(), aristaMin.getExtremo2());
			aristasVisitadas.add(aristaMin);
			if (!vertVisitados.contains(aristaMin.getExtremo1())) {
				vertVisitados.add(aristaMin.getExtremo1());
			}
			if (!vertVisitados.contains(aristaMin.getExtremo2())) {
				vertVisitados.add(aristaMin.getExtremo2());
			}
			return kruskal(agm, g, aristasVisitadas, vertVisitados);
		}
	}

	public static AGMinimo prim(GrafoConPeso g) {
		AGMinimo agm = new AGMinimo(g.tamano());
		List<AristaConPeso> aristasVisitadas = new LinkedList<AristaConPeso>(); // Et
		List<Integer> vertVisitados = new LinkedList<Integer>(); // Vt
		vertVisitados.add(0);
		return prim(agm, g, vertVisitados, aristasVisitadas);
	}

	private static AGMinimo prim(AGMinimo agm, GrafoConPeso g, List<Integer> vertVisitados, List<AristaConPeso> av) {
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
			return prim(agm, g, vertVisitados, av);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}

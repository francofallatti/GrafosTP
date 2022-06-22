package Grafos;

import java.util.LinkedList;
import java.util.List;

public class AGMinimo {

	private GrafoConPeso agm;
	private Integer cantVertices;

	private AGMinimo(Integer cantVertices) {
		this.agm = new GrafoConPeso(cantVertices);
		this.cantVertices = cantVertices;
	}

	private void agregarArista(int i, int j) {
		agm.agregarArista(i, j);
	}

	private void agregarPesoArista(double peso, int i, int j) {
		agm.agregarPesoArista(peso, i, j);
	}

	public static AGMinimo kruskal(GrafoConPeso g) {
		AGMinimo agm = new AGMinimo(g.tamano());
		List<AristaConPeso> aristasVisitadas = new LinkedList<AristaConPeso>(); // Et
		List<Integer> vertVisitados = new LinkedList<Integer>();
		return kruskal(agm, g, aristasVisitadas, vertVisitados);
	}

	private static AGMinimo kruskal(AGMinimo agm, GrafoConPeso g, List<AristaConPeso> aristasVisitadas,
			List<Integer> vertVisitados) {
		if (vertVisitados.size() == g.tamano()) {
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
			return kruskal(agm, g, aristasVisitadas, vertVisitados);
		}
	}

	public static AGMinimo prim(GrafoConPeso g) {
		AGMinimo agm = new AGMinimo(g.tamano());
		List<Integer> vertVisitados = new LinkedList<Integer>();
		vertVisitados.add(0);
		return prim(agm, g, vertVisitados);
	}

	private static AGMinimo prim(AGMinimo agm, GrafoConPeso g, List<Integer> vertVisitados) {
		if (vertVisitados.size() == g.tamano()) {
			return agm;
		} else {
			AristaConPeso aristaMin = g.dameAristaMin(vertVisitados);
			agm.agregarArista(aristaMin.getExtremo1(), aristaMin.getExtremo2());
			agm.agregarPesoArista(aristaMin.getPeso(), aristaMin.getExtremo1(), aristaMin.getExtremo2());
			if (!vertVisitados.contains(aristaMin.getExtremo1())) {
				vertVisitados.add(aristaMin.getExtremo1());
			}
			if (!vertVisitados.contains(aristaMin.getExtremo2())) {
				vertVisitados.add(aristaMin.getExtremo2());
			}
			return prim(agm, g, vertVisitados);
		}
	}

	public Integer cantVertices() {
		return cantVertices;
	}

	public List<AristaConPeso> getAristas() {
		return agm.getAristas();
	}

}

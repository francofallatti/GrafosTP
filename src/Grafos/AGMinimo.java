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

	public Integer cantVertices() {
		return cantVertices;
	}
	
	public void agregarPesoArista(double peso, int i, int j) {
		agm.agregarPesoArista(peso, i, j);
	}

	public static AGMinimo prim(GrafoConPeso g) {
		AGMinimo agm = new AGMinimo(g.tamano());
		List<Integer> vertVisitados = new LinkedList<Integer>();
		vertVisitados.add(0);
		return prim(agm, g, vertVisitados);
	}

	public static AGMinimo prim(AGMinimo agm, GrafoConPeso g, List<Integer> vertVisitados) {
		if(vertVisitados.size() == g.tamano()) {
			return agm;
		}
		else {
			AristaConPeso aristaMin = g.dameAristaMin(vertVisitados);
			agm.agregarPesoArista(aristaMin.getPeso(), aristaMin.getExtremo1(), aristaMin.getExtremo2());
			if(!vertVisitados.contains(aristaMin.getExtremo1())) {
				vertVisitados.add(aristaMin.getExtremo1());
			}
			if(!vertVisitados.contains(aristaMin.getExtremo2())) {
				vertVisitados.add(aristaMin.getExtremo2());
			}
			return prim(agm, g, vertVisitados);
		}
	}

}

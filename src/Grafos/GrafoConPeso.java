package Grafos;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GrafoConPeso extends Grafo {
	private double[][] matrizConPesos;
	private LinkedList<AristaConPeso> aristas;

	public GrafoConPeso(int n) {
		super(n);
		matrizConPesos = new double[n][n];
		aristas = new LinkedList<AristaConPeso>();
	}

	public void agregarPesoArista(double peso, int i, int j) {
		if (super.existeArista(i, j)) {
			matrizConPesos[i][j] = peso;
			matrizConPesos[j][i] = peso;
			aristas.add(new AristaConPeso(i, j, peso));
		}
	}

	public List<AristaConPeso> getAristas() {
		return aristas;
	}

	public void ordenarAristas() {
		Collections.sort(aristas);
	}

	public AristaConPeso dameAristaMinKruskal(List<AristaConPeso> aristasVisitadas, List<Integer> vertVisitados,
			AGMinimo agm) {
		Double aristaMin = Double.MAX_VALUE;
		AristaConPeso ret = null;
		for (AristaConPeso a : aristas) {
			if (a.getPeso() <= aristaMin && !aristasVisitadas.contains(a) && !agm.formaCiclo(a, vertVisitados)) {
				ret = a;
				aristaMin = a.getPeso();
			}
		}
		return ret;
	}

	public AristaConPeso dameAristaMinPrim(List<AristaConPeso> aristasVisitadas, List<Integer> vertVisitados) {
		Double aristaMin = Double.MAX_VALUE;
		AristaConPeso ret = null;
		for (Integer v : vertVisitados) {
			if (dameAristaMinVert(v, aristasVisitadas) != null
					&& dameAristaMinVert(v, aristasVisitadas).getPeso() <= aristaMin
					&& !aristasVisitadas.contains(dameAristaMinVert(v, aristasVisitadas))
					&& !((vertVisitados.contains(dameAristaMinVert(v, aristasVisitadas).getExtremo1())
							&& vertVisitados.contains(dameAristaMinVert(v, aristasVisitadas).getExtremo2())))) {
				aristaMin = dameAristaMinVert(v, aristasVisitadas).getPeso();
				ret = dameAristaMinVert(v, aristasVisitadas);
			}
		}
		return ret;

	}

	// devuelve la aristaMin con un extremo en v
	private AristaConPeso dameAristaMinVert(Integer v, List<AristaConPeso> aristasVisitadas) {
		AristaConPeso ret = null;
		Double aristaMin = Double.MAX_VALUE;
		for (AristaConPeso a : aristas) {
			if (a.tieneUnExtremoEn(v) && a.getPeso() <= aristaMin && !aristasVisitadas.contains(a)) {
				ret = a;
				aristaMin = a.getPeso();
			}
		}
		return ret;
	}

	public boolean formaCiclo(AristaConPeso a, List<Integer> vertVisitados) {
		boolean ret = false;
		for (Integer vv : vertVisitados) {
			ret = ret || (BFS.alcanzables(this, vv).contains(a.getExtremo1())
					&& BFS.alcanzables(this, vv).contains(a.getExtremo2()));
		}
		return ret;
	}
}

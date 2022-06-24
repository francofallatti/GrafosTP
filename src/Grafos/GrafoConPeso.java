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
			//ordenarAristas();
		}
	}

	public List<AristaConPeso> getAristas() {
		return aristas;
	}

	private void ordenarAristas() {
		Collections.sort(aristas);
	}

	/*
	 * public AristaConPeso dameSigAristaMin(AristaConPeso arista) { return
	 * aristas.get(aristas.indexOf(arista) + 1); }
	 */
	public AristaConPeso dameAristaMin(List<AristaConPeso> aristasVisitadas, List<Integer> vertVisitados) {
		int i = 0;
		while (i < aristas.size()) { // las aristas estan ordenadas
			if (aristasVisitadas.contains(aristas.get(i))) {
				i++;
			} else {
				if (!formaCiclo(aristas.get(i), vertVisitados)) {
					return aristas.get(i);
				} else {
					i++;
				}
			}
		}
		return null;
	}

	public AristaConPeso dameAristaMinPrim(List<AristaConPeso> aristasVisitadas, List<Integer> vertVisitados) {
		//int i = 0;
		System.out.println(aristas);
		Double aristaMin = Double.MAX_VALUE;
		AristaConPeso ret = null;
		
		for(Integer v : vertVisitados) {
			if(dameAristaMinVert(v,aristasVisitadas) != null && dameAristaMinVert(v,aristasVisitadas).getPeso() <= aristaMin && !aristasVisitadas.contains(dameAristaMinVert(v,aristasVisitadas)) && !((vertVisitados.contains(dameAristaMinVert(v,aristasVisitadas).getExtremo1())
					&& vertVisitados.contains(dameAristaMinVert(v,aristasVisitadas).getExtremo2())))) {
				aristaMin = dameAristaMinVert(v,aristasVisitadas).getPeso();
				ret = dameAristaMinVert(v,aristasVisitadas);
			}
		}
		/*
		while (i < aristas.size()) { // las aristas estan ordenadas
			System.out.println(aristas.get(i));
			if (aristasVisitadas.contains(aristas.get(i))) {
				i++;
			} else {
				if (aristas.get(i).getPeso() < aristaMin && ((!vertVisitados.contains(aristas.get(i).getExtremo1())
						&& vertVisitados.contains(aristas.get(i).getExtremo2()))
						|| (vertVisitados.contains(aristas.get(i).getExtremo1())
								&& !vertVisitados.contains(aristas.get(i).getExtremo2())))) {
					ret = aristas.get(i);
					aristaMin = aristas.get(i).getPeso();
					i++;
				} else {
					i++;
				}
			}
		}
		*/
		return ret;
		
	}
	
	public AristaConPeso dameAristaMinVert(Integer v, List<AristaConPeso> aristasVisitadas) {	//devuelve la aristaMin con un extremo en v
		AristaConPeso ret = null;
		Double aristaMin = Double.MAX_VALUE;
		for(AristaConPeso a : aristas) {
			if(a.tieneUnExtremoEn(v) && a.getPeso() <= aristaMin && !aristasVisitadas.contains(a)) {
				ret = a;
				aristaMin = a.getPeso();
			}
		}
		return ret;
	}

	public boolean formaCiclo(AristaConPeso a, List<Integer> vertVisitados) {
		boolean ret = false;
		for (Integer vv : vertVisitados) {
			ret = ret || (BFS.alcanzables(this, a.getExtremo1()).contains(vv)
					&& BFS.alcanzables(this, a.getExtremo2()).contains(vv));
		}
		return ret;

	}
	/*
	 * public AristaConPeso dameAristaMin(List<Integer> visitados) { AristaConPeso
	 * ret = null; Double aristaMin = Double.MAX_VALUE; for (AristaConPeso ap :
	 * aristas) { if (ap.getPeso() < aristaMin &&
	 * ((!visitados.contains(ap.getExtremo1()) &&
	 * visitados.contains(ap.getExtremo2())) ||
	 * (visitados.contains(ap.getExtremo1()) &&
	 * !visitados.contains(ap.getExtremo2())))) { ret = ap; aristaMin =
	 * ap.getPeso(); } } return ret; }
	 */
}

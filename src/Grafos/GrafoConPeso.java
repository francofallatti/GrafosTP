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

	private void ordenarAristas() {
		Collections.sort(aristas);
	}

	public AristaConPeso dameAristaMin(List<Integer> visitados) {
		AristaConPeso ret = null;
		Double aristaMin = Double.MAX_VALUE;
		for (AristaConPeso ap : aristas) {
			if (ap.getPeso() < aristaMin
					&& ((!visitados.contains(ap.getExtremo1()) && visitados.contains(ap.getExtremo2()))
							|| (visitados.contains(ap.getExtremo1()) && !visitados.contains(ap.getExtremo2())))) {
				ret = ap;
				aristaMin = ap.getPeso();
			}
		}
		return ret;
	}

}

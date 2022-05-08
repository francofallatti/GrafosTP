package Grafos;

import java.security.spec.MGF1ParameterSpec;
import java.util.HashSet;
import java.util.Set;

public class AGMinimo extends GrafoConPeso {

	public AGMinimo(int n) {
		super(n);
	}

	public static AGMinimo kruskal(GrafoConPeso g) {
		double[][] matrizInicial = g.getMatrizConPesos();
		AGMinimo ret = new AGMinimo(matrizInicial.length);
		double Et = Double.MAX_VALUE;// ET := ∅
		Set<Integer> aux = new HashSet<Integer>();// aristas que ya est´an en Et
		for (int i = 1; i < matrizInicial.length; i++) {// i := 1 mientras i ≤ n − 1 hacer
			Set<Integer> vecinos = g.getVecinos(i);
			Integer j = 0;
			for (Integer vecino : vecinos) {
				Set<Integer> alcanzables = BFS.alcanzables(g, i);
				if (Et > matrizInicial[i][vecino] && alcanzables.contains(i) && !g.mismaComponente(g, i, vecino.intValue())) {// si hay ciclo
					Et = matrizInicial[i][vecino];// ET := ET or {e}
					j = vecino;
				}
			}
			ret.agregarArista(i, j);
			return ret;
		} // i := i + 1
		return ret;// retornar T = (V, Et )
	}
/**
	private boolean hayCiclo() {
		if(aux==null) {
			return false;
		}
		if(!g.mismaComponente(g, i, vecino.intValue()){
			return false;
		}
		return true;
	}**/

	public static AGMinimo prim(GrafoConPeso g) {
		double[][] matrizInicial = g.getMatrizConPesos();
		Integer tamaño = matrizInicial.length - 1;
		AGMinimo ret = new AGMinimo(tamaño);

		for (int i = 1; i <= matrizInicial.length; i++) { // recorro los vértices
			Set<Integer> vecinos = g.getVecinos(i);
			Double aristaMin = Double.MAX_VALUE;
			Integer j = 0;
			for (Integer vecino : vecinos) { // recorro los vecinos del vértice i
				if (matrizInicial[i][vecino] < aristaMin) {
					aristaMin = matrizInicial[i][vecino];
					j = vecino;
				}
			}

			ret.agregarArista(i, j);
		}
		return ret;
	}
}

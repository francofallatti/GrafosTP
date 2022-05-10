package Grafos;

import java.util.Set;

public class AGMinimo extends GrafoConPeso {

	public AGMinimo(int n) {
		super(n);
	}

	public static AGMinimo prim(GrafoConPeso g) {
		double[][] matrizInicial = g.getMatrizConPesos();
		Integer tamaño = g.tamano();
		AGMinimo ret = new AGMinimo(tamaño);
		boolean[] visitados = new boolean[tamaño];
		visitados[0] = true;
		for (int i = 0; i < matrizInicial.length; i++) { // recorro los vértices
			Set<Integer> vecinos = g.getVecinos(i);
			Double aristaMin = Double.MAX_VALUE;
			Integer j = 0;
			if(visitados[i] == true) {
				for (Integer vecino : vecinos) { // recorro los vecinos del vértice i
					if (matrizInicial[i][vecino] < aristaMin && visitados[vecino] == false) {
						aristaMin = matrizInicial[i][vecino];
						j = vecino;
					}
				}
			}
			if(visitados[i] == false) {
				for (Integer vecino : vecinos) { // recorro los vecinos del vértice i
					if (matrizInicial[i][vecino] < aristaMin && visitados[vecino] == true) {
						aristaMin = matrizInicial[i][vecino];
						j = vecino;
					}
				}
			}
			System.out.println(i);
			System.out.println(j);
			visitados[j] = true;
			ret.agregarArista(i, j);
			ret.agregarPesoArista(aristaMin, i, j);
		}
		return ret;
	}
	
	/*
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
				if (Et > matrizInicial[i][vecino] && alcanzables.contains(i) ) {// si hay ciclo
					Et = matrizInicial[i][vecino];// ET := ET or {e}
					j = vecino;
				}
			}
			ret.agregarArista(i, j);
			return ret;
		} // i := i + 1
		return ret;// retornar T = (V, Et )
	}
	*/
}

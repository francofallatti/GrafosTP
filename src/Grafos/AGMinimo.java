package Grafos;

import java.util.Set;

public class AGMinimo extends GrafoConPeso {
	
	public AGMinimo(int n) {
		super(n);
	}

	public static AGMinimo prim(GrafoConPeso g) {
		double[][] matrizInicial = g.getMatrizConPesos();
		Integer tamaño = matrizInicial.length-1;
		AGMinimo ret = new AGMinimo(tamaño);
		
		for (int i = 1; i <= matrizInicial.length ; i++) {	//recorro los vértices
			Set<Integer> vecinos = g.getVecinos(i);
			Double aristaMin = Double.MAX_VALUE;
			Integer j = 0;
			for (Integer vecino : vecinos) {	//recorro los vecinos del vértice i
				if (matrizInicial[i][vecino] < aristaMin && !(BFS.alcanzables(ret, i).contains(vecino))) {
					aristaMin = matrizInicial[i][vecino];
					j = vecino;
				}
			}
			
			ret.agregarArista(i, j);
		}
		return ret;
	}
}

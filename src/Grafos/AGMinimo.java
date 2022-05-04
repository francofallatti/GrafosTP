package Grafos;

import java.util.Set;

public class AGMinimo extends GrafoConPeso {
	
	public AGMinimo(int n) {
		super(n);
	}

	public static AGMinimo prim(GrafoConPeso g) {
		double[][] matrizInicial = g.getMatrizConPesos();
		Integer tama�o = matrizInicial.length-1;
		AGMinimo ret = new AGMinimo(tama�o);
		
		for (int i = 1; i <= matrizInicial.length ; i++) {	//recorro los v�rtices
			Set<Integer> vecinos = g.getVecinos(i);
			Double aristaMin = Double.MAX_VALUE;
			Integer j = 0;
			for (Integer vecino : vecinos) {	//recorro los vecinos del v�rtice i
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

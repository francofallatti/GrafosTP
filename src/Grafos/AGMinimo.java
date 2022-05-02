package Grafos;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AGMinimo extends GrafoConPeso {

	public AGMinimo(int n) {
		super(n);
	}

	public static AGMinimo prim(GrafoConPeso g) {
		AGMinimo ret = new AGMinimo(g.tamano());
		Set<Integer> visitados = new HashSet<Integer>();
		//elijo un vertice al azar
		Integer vertice = new Random().nextInt(g.tamano());
		Integer verticeSig = 0;
		visitados.add(vertice);
		double aristaDeMenorPeso = 2;
		int i = 1;
		while(i < g.tamano()) {
			for (Integer vecino : g.getVecinos(vertice)) {
				if(!visitados.contains(vecino) && g.getPesosDeAristas(vertice)[vecino] < aristaDeMenorPeso) {
					aristaDeMenorPeso = g.getPesosDeAristas(vertice)[vecino];
					verticeSig = vecino;
				}
			}
			visitados.add(verticeSig);
		}
		i++;
	}
}

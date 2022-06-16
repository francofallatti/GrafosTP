package Grafos;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GrafoConPeso extends Grafo {
	private double[][] matrizConPesos;

	public GrafoConPeso(int n) {
		super(n);
		matrizConPesos = new double[n][n];
	}

	public void agregarPesoArista(double peso, int i, int j) {
		if (super.existeArista(i, j)) {
			matrizConPesos[i][j] = peso;
			matrizConPesos[j][i] = peso;
		}

	}

	public List<Integer> vecinosOrdenados(Integer i) {
		List<Integer> ret = new LinkedList<Integer>();
		Set<Integer> vecinos = getVecinos(i);
		for (Integer vecino : vecinos) {
			if (ret.size() == 0) {
				ret.add(vecino);
			}
			for (int vecinoOrdenado = 0; vecinoOrdenado < ret.size(); vecinoOrdenado++) {
				if (matrizConPesos[i][vecino] < matrizConPesos[i][ret.get(vecinoOrdenado)]) {
					ret.add(vecinoOrdenado, vecino);
				}
			}
		}
		return ret;
	}

	@Override
	public String toString() {
		StringBuffer ret = new StringBuffer();
		for (int i = 0; i < matrizConPesos.length; i++) {
			for (int j = 0; j < matrizConPesos[i].length; j++) {
				ret.append((matrizConPesos[i][j] + " "));
			}

			ret.append("\n");
		}
		return ret.toString();
	}
	
	public Tupla<Double, Integer> dameAristaMin(int i) {
		Set<Integer> vecinos = getVecinos(i);
		Double aristaMin = Double.MAX_VALUE;
		Integer verticeAsociado = 0;
		for(Integer v : vecinos) {
			if(getPesoDeAristas(i, v)<aristaMin) {
				aristaMin = getPesoDeAristas(i, v);
				verticeAsociado = v;
			}
		}
		return new Tupla<Double, Integer>(aristaMin, verticeAsociado);
	}
	
	public boolean formaCiclo(int i, int j) {
		return BFS.alcanzables(this, i).contains(j);
	}
	
	public Tupla<Double, Integer> dameAristaMin(List<Integer> visitados) {
			Integer n = 0;
			while(n<visitados.size()) {
				if(!visitados.contains(dameAristaMin(n).getE2())) {
					n=visitados.size();
					return dameAristaMin(n);
				} else {
					n++;
				}
			}
		return null;
	}

	public double[][] getMatrizConPesos() {
		return matrizConPesos;
	}

	public double[] getPesosDeAristas(int i) {
		return matrizConPesos[i];
	}

	public double getPesoDeAristas(int i, int j) {
		return matrizConPesos[i][j];
	}
}

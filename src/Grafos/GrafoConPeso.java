package Grafos;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GrafoConPeso extends Grafo {
	private double[][] matrizConPesos;
	// private List<Double> pesosDeAristas;
	// private List<Tupla<Integer, Integer>> aristas;
	// private Double minActual;

	public GrafoConPeso(int n) {
		super(n);
		matrizConPesos = new double[n][n];
		/*
		 * aristas = new LinkedList<Tupla<Integer,Integer>>(); pesosDeAristas = new
		 * LinkedList<Double>(); minActual = Double.MAX_VALUE;
		 */
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

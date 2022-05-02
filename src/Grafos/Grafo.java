package Grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {

	// Implementacion lista de vecinos
	private ArrayList<HashSet<Integer>> _listaDeVecinos;

	public Grafo(int n) {
		_listaDeVecinos = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < n; i++) {
			_listaDeVecinos.add(new HashSet<Integer>());
		}
	}

	public void agregarArista(int i, int j) {
		verifDistintos(i, j);
		verifVertice(i);
		verifVertice(j);

		_listaDeVecinos.get(i).add(j);
		_listaDeVecinos.get(j).add(i);
	}

	public void eliminarArista(int i, int j) {
		verifDistintos(i, j);
		verifVertice(i);
		verifVertice(j);

		_listaDeVecinos.get(i).remove(j);
		_listaDeVecinos.get(j).remove(i);
	}

	public boolean existeArista(int i, int j) {
		verifDistintos(i, j);
		verifVertice(i);
		verifVertice(j);

		return _listaDeVecinos.get(i).contains(j);
	}

	// cant de vertices
	public int tamano() {
		return _listaDeVecinos.size();
	}

	// vecinos de un vertice
	public Set<Integer> getVecinos(int i) {
		return _listaDeVecinos.get(i);
	}

	// Exepciones
	private void verifDistintos(int i, int j) {
		if (i == j) {
			throw new IllegalArgumentException("Los Vertices tienen que ser distintos " + i + "=" + j);
		}
	}

	private void verifVertice(int i) {
		if (i >= _listaDeVecinos.size() || i < 0) {
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
		}
	}
}

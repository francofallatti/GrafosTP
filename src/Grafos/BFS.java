package Grafos;


import java.util.HashSet;

import java.util.LinkedList;

import java.util.List;

import java.util.Set;


public class BFS {


	private static List<Integer> L;

	private static boolean[] marcados;

	
	// Dado un grafo, retorna True si es conexo

	// Genera una excepcion IllegalArgumentException si el grafo es nulo

	public static boolean esConexo(Grafo g) {

		if (g==null)

			throw new IllegalArgumentException("El grafo no puede ser nulo!");

		if (g.tamano()==0)

			return true;

		return alcanzables(g,0).size()==g.tamano();

	}


	// Retorna un conjunto conteniendo todos los vertices alcanzables

	// en un grafo, desde un vertice origen dado

	public static Set<Integer> alcanzables(Grafo g, int origen) {

		Set<Integer> ret = new HashSet<Integer>();

		
		// Inicializar las estructuras para la busqueda

		inicializarBusqueda(g, origen);

		
		while (L.size()>0) {

			int i = seleccionarYMarcarVertice(ret);

			agregarVecinosNoMarcados(g, i);

			removerSeleccionado();

		}

		
		return ret;

	}

	
	// Retorna la distancia desde el origen al destino

	// en el grafo g

	public static int distancia(Grafo g, int origen, int destino) {

		throw new RuntimeException("Metodo aun no implementado");

	}


	private static void removerSeleccionado() {

		L.remove(0);

	}


	private static int seleccionarYMarcarVertice(Set<Integer> ret) {

		int i = L.get(0);

		marcados[i] = true;

		ret.add(i);

		return i;

	}


	private static void agregarVecinosNoMarcados(Grafo g, int i) {

		for (int vecino: g.getVecinos(i)) {

			if (!marcados[vecino] && !L.contains(vecino))

				L.add(vecino);

		}

	}


	private static void inicializarBusqueda(Grafo g, int origen) {

		L = new LinkedList<Integer>();

		L.add(origen);

		marcados = new boolean[g.tamano()];

	}


}


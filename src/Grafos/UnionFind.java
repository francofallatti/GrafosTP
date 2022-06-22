package Grafos;

public class UnionFind {
	private Integer[] arreglo;
	private Grafo g;

	public UnionFind(GrafoConPeso g) {
		this.g = g;
		this.arreglo = new Integer[g.tamano()];
	}
	
	public void ordenarArreglo() {	//el arreglo contiene el padre de cada vertice
		
	}
}

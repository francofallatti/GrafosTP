package Grafos;
/*
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
*/

public class GrafoConPeso extends Grafo {
	private double[][] matrizConPesos;
	//private List<Double> pesosDeAristas;
	//private List<Tupla<Integer, Integer>> aristas;
	//private Double minActual;

	public GrafoConPeso(int n) {
		super(n);
		matrizConPesos = new double[n][n];
		/*
		aristas = new LinkedList<Tupla<Integer,Integer>>();
		pesosDeAristas = new LinkedList<Double>();
		minActual = Double.MAX_VALUE;
		*/
	}
	
	public GrafoConPeso() {
		super();
	}
	
	public void agregarPesoArista(double peso, int i, int j) {
		if(super.existeArista(i, j)) {
			matrizConPesos[i][j] = peso;
			/*
			if(peso < pesosDeAristas.get(0)) {
				aristas.add(0, (new Tupla<Integer, Integer>(i, j)));
				pesosDeAristas.add(0, peso);
			}
			else {
				
			}
			*/
		}
		
	} 
	
	public double[][] getMatrizConPesos() {
		return matrizConPesos;
	}
	
	public double[] getPesosDeAristas(int i) {
		return matrizConPesos[i];
	}

	public boolean mismaComponente(Grafo g, int i, int vecino) {
		if(g.padre(i)==g.padre(vecino)){
			return true;
		}
		return false;
	}
}

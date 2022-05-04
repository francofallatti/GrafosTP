package Grafos;

public class GrafoConPeso extends Grafo {
	private double[][] matrizConPesos;

	public GrafoConPeso(int n) {
		super(n);
		matrizConPesos = new double[n][n];
	}
	
	public void agregarPesoArista(double peso, int i, int j) {
		if(super.existeArista(i, j)) {
			matrizConPesos[i][j] = peso;
		}
	} 
	
	public double[][] getMatrizConPesos() {
		return matrizConPesos;
	}
	
	public double[] getPesosDeAristas(int i) {
		return matrizConPesos[i];
	}
}

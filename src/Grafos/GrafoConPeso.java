package Grafos;

public class GrafoConPeso extends Grafo {
	private double[][] grafoConPeso;

	public GrafoConPeso(int n) {
		super(n);
		grafoConPeso = new double[n][n];
	}
	
	public void agregarPesoArista(double peso, int i, int j) {
		if(super.existeArista(i, j)) {
			grafoConPeso[i][j] = peso;
		}
	} 
	
	public double[] getPesosDeAristas(int i) {
		return grafoConPeso[i];
	}
}

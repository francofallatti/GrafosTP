package Grafos;

public class Tupla<K,V> {
	K valor1;
	V valor2;
	Tupla(K valor1, V valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	
	public K getX() {
		return valor1;
	}
	
	public V getY() {
		return valor2;
	}
	
}

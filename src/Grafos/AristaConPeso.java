package Grafos;

public class AristaConPeso implements Comparable<AristaConPeso> {
	private Integer extremo1;
	private Integer extremo2;
	private Double peso;

	public AristaConPeso(Integer e1, Integer e2, Double p) {
		extremo1 = e1;
		extremo2 = e2;
		peso = p;
	}

	public boolean tieneUnExtremoEn(Integer i) {
		return extremo1 == i || extremo2 == i;
	}

	public Integer getExtremo1() {
		return extremo1;
	}

	public Integer getExtremo2() {
		return extremo2;
	}

	public Double getPeso() {
		return peso;
	}

	@Override
	public int compareTo(AristaConPeso o) {
		if(this.getPeso() > o.getPeso()) {
			return 1;
		}
		if(this.getPeso() < o.getPeso()) {
			return -1;
		}
		return 0;
	}
}

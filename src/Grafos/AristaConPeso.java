package Grafos;

public class AristaConPeso {
	Integer extremo1;
	Integer extremo2;
	Double peso;
	
	public AristaConPeso(Integer e1, Integer e2, Double p){
		extremo1=e1;
		extremo2=e2;
		peso=p;
	}
	
	public boolean tieneUnExtremoEn(Integer i) {
		return extremo1==i || extremo2==i;
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
}

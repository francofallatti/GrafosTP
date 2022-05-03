package Main;

import java.util.Set;

public class Espias {
	Set<String> espias;
	
	
	public void agregarEspia(String s) {
		if(!espias.contains(s)) {
			espias.add(s);
		}
	}
}

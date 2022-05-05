package Main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Grafos.GrafoConPeso;

public class Juego {
	private Set<Espia> espias;
	private HashMap<Espia, Integer> espia_NumeroDeVertice;
	private String mensaje;
	private GrafoConPeso grafoEspias;
	
	
	public Juego() {
		espias = new HashSet<Espia>();
		mensaje = "Este es un mensaje para los espías";
		grafoEspias = new GrafoConPeso();
	}
	
	public void agregarEspia(String nombreEspia) {
		Espia nuevo = new Espia(nombreEspia);
		espias.add(nuevo);
		grafoEspias.agregarVertice();
	}
	
	public boolean puedenEncontrarse(Espia espia1, Espia espia2) {
		return grafoEspias.existeArista(espia_NumeroDeVertice.get(espia1), espia_NumeroDeVertice.get(espia2));
	}
}

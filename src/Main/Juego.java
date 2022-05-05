package Main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Grafos.AGMinimo;
import Grafos.GrafoConPeso;

public class Juego {
	private Set<Espia> espias;
	private Map<Espia, Integer> espia_NumeroDeVertice;
	private String mensaje;
	private GrafoConPeso grafoEspias;
	private AGMinimo juego;
	
	
	public Juego() {
		espias = new HashSet<Espia>();
		mensaje = "Este es un mensaje para los espías";
		grafoEspias = new GrafoConPeso();
		espia_NumeroDeVertice = new HashMap<Espia, Integer>(); 
	}
	
	public void jugar() {
		juego = AGMinimo.prim(grafoEspias);
	}
	
	public void agregarEspia(String nombreEspia) {
		Espia nuevo = new Espia(nombreEspia);
		espia_NumeroDeVertice.put(nuevo, espia_NumeroDeVertice.size());
		espias.add(nuevo);
		grafoEspias.agregarVertice();
	}
	
	public void agregarEncuentro(Double probabilidadIntercepcion, Espia espia1, Espia espia2) {
		grafoEspias.agregarArista(espia_NumeroDeVertice.get(espia1), espia_NumeroDeVertice.get(espia2));
		grafoEspias.agregarPesoArista(probabilidadIntercepcion, espia_NumeroDeVertice.get(espia1), espia_NumeroDeVertice.get(espia2));
	}
	
	public boolean puedenEncontrarse(Espia espia1, Espia espia2) {
		return grafoEspias.existeArista(espia_NumeroDeVertice.get(espia1), espia_NumeroDeVertice.get(espia2));
	}
}

package Main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import Grafos.AGMinimo;
import Grafos.GrafoConPeso;

public class Juego {
	private Map<String,Espia> espias;
	private Map<Espia, Integer> espia_NumeroDeVertice;

	private String mensaje;
	private GrafoConPeso grafoEspias;
	private AGMinimo juego;

	private Juego() {
		espias = new HashMap<String,Espia>();
		mensaje = "Este es un mensaje para los esp�as";
		espia_NumeroDeVertice = new HashMap<Espia, Integer>();
	}
	
	public static Juego iniciarJuego() {
		Juego juego = new Juego();
		return juego;
	}

	public AGMinimo jugar() {
		juego = AGMinimo.prim(grafoEspias);
		return juego;
	}
	
	public Double getProbabilidadIntercepcion(int i, int j) {
		return juego.getMatrizConPesos()[i][j];
	}
	
	public void cargarEncuentros() {
		grafoEspias = new GrafoConPeso(espias.size());
	}

	public void agregarEspia(String nombreEspia) {
		if (nombreEspia == null || nombreEspia == "") {
			throw new IllegalArgumentException("Se espera el nombre de un espia");
		} else {
			Espia nuevo = new Espia(nombreEspia);
			espia_NumeroDeVertice.put(nuevo, espia_NumeroDeVertice.size());
			espias.put(nombreEspia, nuevo);
		}
		
	}
	public void agregarEncuentro(Double probabilidadIntercepcion, String espia1, String espia2) {
		grafoEspias.agregarArista(espia_NumeroDeVertice.get(espias.get(espia1)), espia_NumeroDeVertice.get(espias.get(espia2)));
		grafoEspias.agregarPesoArista(probabilidadIntercepcion, espia_NumeroDeVertice.get(espias.get(espia1)),
				espia_NumeroDeVertice.get(espias.get(espia2)));
	}

	public boolean puedenEncontrarse(Espia espia1, Espia espia2) {
		return grafoEspias.existeArista(espia_NumeroDeVertice.get(espia1), espia_NumeroDeVertice.get(espia2));
	}

	public Map<String,Espia> getEspias() {
		return espias;
	}
	
	public Integer numeroVertice(String espia) {
		Espia e = new Espia(espia);
		return espia_NumeroDeVertice.get(e);
	}
	
	public String getNombreEspia(int i) {
	    for(Entry<Espia, Integer> entry: espia_NumeroDeVertice.entrySet()) {
	      if(entry.getValue() == i) {
	        return entry.getKey().getNombre();
	      }
	    }
		return "";
	  }
	
	
	
	public Set<String> getEspiasKey() {
		return espias.keySet();
	}
	
	public GrafoConPeso getGrafo() {
		return grafoEspias;
	}
}

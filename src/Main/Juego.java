package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Grafos.AGMinimo;
import Grafos.BFS;
import Grafos.GrafoConPeso;
import Grafos.Implementacion;

public class Juego {
	private Map<String, Espia> espias;
	private Map<Integer, Espia> numeroDeVertice_espia;
	private Map<Espia, Integer> espia_NumeroDeVertice;
	private GrafoConPeso grafoEspias;
	private AGMinimo juego;

	private Juego() {
		espias = new HashMap<String, Espia>();
		espia_NumeroDeVertice = new HashMap<Espia, Integer>();
		numeroDeVertice_espia = new HashMap<Integer, Espia>();
	}

	public static Juego iniciarJuego() {
		Juego juego = new Juego();
		return juego;
	}

	public AGMinimo jugar(Implementacion i) {
		if (i == Implementacion.Prim) {
			juego = AGMinimo.prim(grafoEspias);
		} else {
			juego = AGMinimo.kruskal(grafoEspias);
		}
		return juego;
	}
	
	public boolean sePuedeCrearAGM() {
		return BFS.esConexo(grafoEspias);
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
			numeroDeVertice_espia.put(numeroDeVertice_espia.size(), nuevo);
		}

	}

	public void agregarEncuentro(Double probabilidadIntercepcion, String espia1, String espia2) {
		grafoEspias.agregarArista(espia_NumeroDeVertice.get(espias.get(espia1)),
				espia_NumeroDeVertice.get(espias.get(espia2)));
		grafoEspias.agregarPesoArista(probabilidadIntercepcion, espia_NumeroDeVertice.get(espias.get(espia1)),
				espia_NumeroDeVertice.get(espias.get(espia2)));
	}

	public boolean puedenEncontrarse(Espia espia1, Espia espia2) {
		return grafoEspias.existeArista(espia_NumeroDeVertice.get(espia1), espia_NumeroDeVertice.get(espia2));
	}

	public Integer numeroVertice(String espia) {
		return espia_NumeroDeVertice.get(espias.get(espia));
	}

	public String getNombreEspia(Integer i) {
		if (numeroDeVertice_espia.get(i) != null) {
			return numeroDeVertice_espia.get(i).getNombre();
		} else {
			throw new IllegalArgumentException("El espía no existe");
		}
	}

	public Set<String> getNombreEspias() {
		return espias.keySet();
	}

	public Set<Espia> getEspias() {
		return espia_NumeroDeVertice.keySet();
	}

	public Espia getEspia(String s) {
		return espias.get(s);
	}

}

package Main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Grafos.AGMinimo;
import Grafos.GrafoConPeso;

public class Juego {
	private static Set<Espia> espias;
	private static Map<Espia, Integer> espia_NumeroDeVertice;
	private String mensaje;
	private static GrafoConPeso grafoEspias;
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

	public static void agregarEspia(String nombreEspia) {
		if (nombreEspia == null || nombreEspia == "") {
			throw new IllegalArgumentException("Se espera el nombre de un espia");
		} else {
			Espia nuevo = new Espia(nombreEspia);
			espia_NumeroDeVertice.put(nuevo, espia_NumeroDeVertice.size());
			espias.add(nuevo);
			grafoEspias.agregarVertice();

		}
	}

	public void agregarEncuentro(Double probabilidadIntercepcion, Espia espia1, Espia espia2) {
		grafoEspias.agregarArista(espia_NumeroDeVertice.get(espia1), espia_NumeroDeVertice.get(espia2));
		grafoEspias.agregarPesoArista(probabilidadIntercepcion, espia_NumeroDeVertice.get(espia1),
				espia_NumeroDeVertice.get(espia2));
	}

	public boolean puedenEncontrarse(Espia espia1, Espia espia2) {
		return grafoEspias.existeArista(espia_NumeroDeVertice.get(espia1), espia_NumeroDeVertice.get(espia2));
	}

	public static Set<Espia> getEspias() {
		return espias;
	}
}

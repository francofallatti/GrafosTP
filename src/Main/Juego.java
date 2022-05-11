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
	private Map<String, Espia> espias;
	private Map<Integer, Espia> numeroDeVertice_espia;
	private Map<Espia, Integer> espia_NumeroDeVertice;
	private String mensaje;
	private GrafoConPeso grafoEspias;
	private AGMinimo juego;

	private Juego() {
		espias = new HashMap<String, Espia>();
		mensaje = "Este es un mensaje para los espías";
		espia_NumeroDeVertice = new HashMap<Espia, Integer>();
		numeroDeVertice_espia = new HashMap<Integer, Espia>();
	}

	public static Juego iniciarJuego() {
		Juego juego = new Juego();
		return juego;
	}

	public AGMinimo jugar() {
		juego = AGMinimo.prim(grafoEspias);
		numeroDeVertice_espia.get(0).recibirMensaje(mensaje);
		for (int i = 0; i < juego.getMatrizConPesos().length; i++) {
			for (int j = 1; j < juego.getMatrizConPesos().length; j++) {
				if (i != j) {
					if (juego.existeArista(i, j) && numeroDeVertice_espia.get(i).tieneMensaje()) {
						numeroDeVertice_espia.get(j).recibirMensaje(mensaje);
					}
					if (juego.existeArista(i, j) && numeroDeVertice_espia.get(j).tieneMensaje()) {
						numeroDeVertice_espia.get(i).recibirMensaje(mensaje);
					}
				}
			}
		}
		return juego;
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

	public GrafoConPeso getGrafo() {
		return grafoEspias;
	}

	public Double getProbabilidadIntercepcion(int i, int j) {
		return juego.getMatrizConPesos()[i][j];
	}

	public Espia getEspia(String s) {
		return espias.get(s);
	}

	public boolean mensajeEntregado(int i) {
		if( numeroDeVertice_espia.get(i).tieneMensaje()==true ){
			return true;
		}
		return false;
	}
}

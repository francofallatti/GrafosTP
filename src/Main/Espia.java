package Main;


public class Espia {
	private String espia;
	private Boolean tieneMensaje;
	
	public Espia(String nombre) {
		this.espia = nombre;
	}
	
	public boolean tieneMensaje() {
		return tieneMensaje;
	}

	public String getNombre() {
		return espia;
	}
	
}

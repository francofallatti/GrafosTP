package Main;


public class Espia {
	private String espia;
	private Boolean tieneMensaje;
	private String mensaje;
	
	public Espia(String nombre) {
		this.espia = nombre;
	}
	
	public void recibirMensaje(String mensajeRecibido) {
		mensaje = mensajeRecibido;
		tieneMensaje = true;
	}
	
	public boolean tieneMensaje() {
		return tieneMensaje;
	}

	public String getNombre() {
		return espia;
	}

	public String getMensaje() {
		return mensaje;
	}
	
}

package aula11;

public class RN_Usuario extends Subject {
	
	private String estado;
	
	public void setEstado(String s) {
		this.estado = s;
		this.notificar();
	}
	
	public String getEstado() {
		return this.estado;
	}
}

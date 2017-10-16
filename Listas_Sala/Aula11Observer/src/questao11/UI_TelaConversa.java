package questao11;

public class UI_TelaConversa extends Observer {
	
	private String id;
	protected RN_Usuario regras;
	
	public UI_TelaConversa(RN_Usuario regras, String id) {
		this.id = id;
		this.regras = regras;
		regras.attach(this);
	}

	@Override
	public void update() {
		System.out.println(id+" notificado:\n"+regras.getEstado()+"\n");
	}

}

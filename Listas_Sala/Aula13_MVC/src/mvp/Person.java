package mvp;

import java.util.Observable;

public class Person extends Observable {
	public Person() {
	}
	
	public Person(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		System.out.println("getName");
		return _name;
	}
	
	public String getClassificacao() {
		return _classificacao;
	}
	
	public void setName(String name)
	{
		System.out.println("setName");
		name = name.replaceAll("[^A-Za-z ]", "").replaceAll("( )+", " ");
		_name = name.substring(0, 1).toUpperCase() + name.substring(1);
		int tamanho = _name.length();
		if (tamanho < 5)
			_classificacao = "curto";
		else if (tamanho < 10)
			_classificacao = "medio";
		else _classificacao = "longo";
		super.setChanged();
		super.notifyObservers();
	}
	
	private String _name;
	private String _classificacao;
}

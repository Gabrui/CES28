package aula10_ref0;

// Atividade: Como fazer então para garantir que a classe Application tenha uma e apenas uma instância?
public class Application {
	public void run () {
		
	}

	// ---------- Constructor --------------------
	/*
	 * A resposta é tornar o construtor padrão privado ou protegido,
	 *  de modo que sem construtor padrão público clientes não possam criar quaisquer instâncias.
	 */
	private     Application() {
		// No initialization required
	}    // constructor: Application

	// ---------- Operations --------------------
	/*
	 * A resposta é tornar o construtor padrão privado ou protegido, 
	 * de modo que sem construtor padrão público clientes não possam
	 *  criar quaisquer instâncias.
	 */
	public static Application    getApplication() {   
		return theApplication;       
	}    // method: getApplication

	// Others methods protected by singleton-ness would be here
	// …

	// ---------- Attributes --------------------  
	private static final Application    theApplication = new Application();

}    // class: Application


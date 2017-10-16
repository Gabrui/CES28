package questao6;


public class MyApplication {

	private MessageService _service;
	
	public MyApplication(MessageService service) {
		this._service = service;
	}
	
	public void processMessages(String message, String receiver) {
		// Do some msg validation, manipulation logic etc.
		_service.sendEmail(message, receiver);
	}
	
}

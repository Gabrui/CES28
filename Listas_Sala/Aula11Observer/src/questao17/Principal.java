package questao17;


public class Principal {

	public static void main(String[] args) {
		PublishSubscriber PB = new PublishSubscriber();
		Subject sub1 = new Subject();
		Subject sub2 = new Subject();
		Observador obs1 = new Observador("obs1");
		Observador obs2 = new Observador("obs2"); 
		// faça o registro para PB ser notificado se sub1 ou sub2 mudarem
		PB.adiconaPublisher(sub1, "geral");
		PB.adiconaPublisher(sub2, "geral");
		
		PB.addSubscriber(obs1, "geral");
		PB.addSubscriber(obs2, "geral");
		
		// faça o registro para obs1 e obs2 serem notificarem se PB mudar
		// agora faça um demo de comunicação:
		sub1.setEstado("msg do sub1");  // PB observa sub1 e recebe a mensagem.
		/* nesse momento PB repassa a mensagem para obs1 e obs2, que ao receber imprimem a mensagem. Aparece na tela:
		 obs1: recebi “msg do sub1”
		 obs2: recebi “msg do sub1”
		*/

		// analogamente, agora sub2 é mudado
		sub2.setEstado("msg do sub2");
		/* nesse momento PB repassa a mensagem para obs1 e obs2, que ao receber imprimem a mensagem. Aparece na tela:
		obs1: recebi “msg do sub2”
		obs2: recebi “msg do sub2”
		*/
	}

}

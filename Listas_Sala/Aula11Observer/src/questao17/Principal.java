package questao17;

import java.util.Observable;

public class Principal {

	public static void main(String[] args) {
		PublishSubscriber PB = new PublishSubscriber();
		Subject sub1 = new Subject();
		Subject sub2 = new Subject();
		Observador obs1 = new Observable();
		Observador obs2 = new Observer(); 
		// faça o registro para PB ser notificado se sub1 ou sub2 mudarem
		sub1.addObserver(PB);
		sub2.addObserver(PB);
		
		// faça o registro para obs1 e obs2 serem notificarem se PB mudar
		// agora faça um demo de comunicação:
		sub1.setValue("msg do sub1");  // PB observa sub1 e recebe a mensagem.
		/* nesse momento PB repassa a mensagem para obs1 e obs2, que ao receber imprimem a mensagem. Aparece na tela:
		 obs1: recebi “msg do sub1”
		 obs2: recebi “msg do sub1”
		*/

		// analogamente, agora sub2 é mudado
		sub2.setValue("msg do sub2");
		/* nesse momento PB repassa a mensagem para obs1 e obs2, que ao receber imprimem a mensagem. Aparece na tela:
		obs1: recebi “msg do sub2”
		obs2: recebi “msg do sub2”
		*/
	}

}

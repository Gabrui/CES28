package hookClass;

/*
 O hook class é quando uma classe implementa um algoritmo e
  algumas partes do algoritmo é delegado para uma outra classe,
   por relação de agregação, que implementa essas partes de formas
    diferentes. Essa outra classe é a hook class. Portanto, a diferença
     entre o hook method e o hook class é que um utiliza a propriedade 
     de herança para implementar o hook method e o outro utiliza a relação
      entre classes, por exemplo, agregação para implementar uma hook class.
 */
public class ControladorPouso {
	
	private EstrategiasPouso est;
	
	public void setEstrategiaPouso(EstrategiasPouso est) {
		this.est = est;
	}
	
	public void executaPouso() {
		int d = est.calculaVelocidadeOtima(100, 3000);
		System.out.println(d);
	}
}

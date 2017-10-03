package aula10_ref4_pool;


public class Main {
	// ---------- Operations --------------------
public static void        main(String[] args) throws InterruptedException {
    	ApplicationTest t1 = new ApplicationTest();
    	ApplicationTest t2 = new ApplicationTest();
    	ApplicationTest t3 = new ApplicationTest();
    	
    	Thread r1 = new Thread(t1);
    	Thread r2 = new Thread(t2);
    	Thread r3 = new Thread(t3);
    	System.out.println("Programa inicializado!");
    	r1.start();
    	r2.start();
    	//r3.start();
}  // method: main

} // class: Main

package aula10_ref2;

public class Main {
	// ---------- Operations --------------------
public static void        main(String[] args) throws InterruptedException {
    	ApplicationTest t1 = new ApplicationTest();
    	ApplicationTest t2 = new ApplicationTest();
    	
    	Thread r1 = new Thread(t1);
    	Thread r2 = new Thread(t2);
    	r1.start();
    	Thread.sleep(3000);
    	r2.start();
}  // method: main

} // class: Main

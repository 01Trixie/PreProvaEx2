package view;
 import java.util.concurrent.Semaphore;
 import controller.ClassController;
public class Principal {
	
	public static void main(String[] args) {
		
		int permissao = 1;

		Semaphore semaforo = new Semaphore(permissao);
		
		for(int ThreadId = 0; ThreadId < 20; ThreadId++) {
			Thread tSJF = new ClassController(ThreadId, semaforo);
			tSJF.start();
			
		}
	}

}

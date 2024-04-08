package controller;
import java.util.concurrent.Semaphore;


public class ClassController extends Thread{
	private int ThreadId;
	private Semaphore semaforo;

	public ClassController(int ThreadId, Semaphore semaforo) {
		this.ThreadId = ThreadId;
		this.semaforo = semaforo;
	}
	public void run() {
		processoSJF();
	}
	
	public void processoSJF(){
		int cta = 0;
		while(cta < 1) {
			cta +=1;
			System.out.println("A thread #" + ThreadId + " chegou.");
			try {
				semaforo.acquire();
				saida();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}
	private void saida() {
		int duracao = (int) ((Math.random()*4.1)+ 116);
		try {
			sleep(duracao);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("A thread #" + ThreadId + " saiu.");
	}
}

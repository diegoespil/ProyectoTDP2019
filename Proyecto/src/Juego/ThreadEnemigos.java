package Juego;

public class ThreadEnemigos extends Thread{

	private Juego juego;

	public ThreadEnemigos(Juego j) {
		this.juego = j;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.mover();
		}
	}
}

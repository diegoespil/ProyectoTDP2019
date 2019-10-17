package Juego;

import Entidad.Disparo.Disparo;

public class ThreadDisparo extends Thread{

	private Juego juego;
	private Disparo disparo;
	private static volatile boolean llego;

	public ThreadDisparo(Juego j) {
		this.juego = j;
		this.disparo = juego.getDisparo();
		llego = false;
	}

	public void run() {
		while(llego){
			System.out.println("estoy ejecutando el hilo");
			llego = juego.canMove(disparo);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		if (!llego){ 
			
			juego.eliminar(disparo);
			
		}
	} 
	public synchronized void iniciar(){
		llego=true;
		this.start();
	}
	public synchronized void detener(){
		llego=false;
		try {
			this.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
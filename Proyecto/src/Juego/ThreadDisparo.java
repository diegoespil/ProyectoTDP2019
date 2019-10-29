package Juego;

import Entidad.Disparo.Disparo;

public class ThreadDisparo extends Thread{

	private Juego juego;
	private Disparo disparo;
	private static volatile boolean llego;
	private volatile int cont;

	public ThreadDisparo(Juego j) {
		this.juego = j;
		this.disparo = juego.getDisparo();
		llego = false;
		cont = 0;
	}

	public void run() {
		while(llego){
			//System.out.println("estoy ejecutando el hilo");
			if(cont<60){
				llego = juego.canMove(disparo);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cont++;
			}
			else{
				juego.actualizarGrilla(disparo);
				cont = 0;
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
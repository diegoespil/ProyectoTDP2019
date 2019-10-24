package Juego;

import Entidad.Integrante.Enemigo.Enemigo;

public class ThreadEnemigos extends Thread{

	private Juego juego;
	private Enemigo enemigo;

	public ThreadEnemigos(Juego j) {
		this.juego = j;
		this.enemigo = juego.getEnemigo();
	}

	public void run() {
		while(enemigo.getVida()>0){
			System.out.println("estoy ejecutando el hilo");
			if ((enemigo.getVida()<=0)){
				juego.eliminarEnemigo(enemigo);
				
			}
			else{
				juego.canMove(enemigo);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			   
		}
	} 
}
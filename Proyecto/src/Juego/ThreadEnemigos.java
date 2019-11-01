package Juego;

import Entidad.Integrante.Enemigo.Enemigo;

public class ThreadEnemigos extends Thread{

	private Juego juego;
	private Enemigo enemigo;
	private volatile int cont;

	public ThreadEnemigos(Juego j) {
		this.juego = j;
		this.enemigo = juego.getEnemigo();
		cont = 0;
	}

	public void run() {
		while(enemigo.getVida()>0){
			//System.out.println("estoy ejecutando el hilo");
			if ((enemigo.getVida()<=0)){
				juego.eliminarEnemigo(enemigo);
				
			}
			else{
				if(cont<60){
					if (juego.canMove(enemigo) ){
						cont++;
					}
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				else{
					juego.actualizarGrilla(enemigo);
					cont = 0;
				}
				
			}
			
			   
		}
	} 
}
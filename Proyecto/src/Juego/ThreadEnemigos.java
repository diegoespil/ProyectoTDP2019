package Juego;

import Entidad.Entidad;
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
			if ((enemigo.getVida()<=0)){
				juego.eliminarEnemigo(enemigo);	
			}
			else{
				if(cont<60){
					Entidad sig = juego.getSiguiente(enemigo,-1);
					if (sig == null ){
						juego.mover(enemigo, -1);
						cont++;
					}
					else{
						juego.aceptarVisitor(sig, enemigo);
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				else{
					juego.enRango(enemigo,-1);
					juego.actualizarGrilla(enemigo,-1);
					cont = 0;
				}
				
			}	   
		}
	} 
}
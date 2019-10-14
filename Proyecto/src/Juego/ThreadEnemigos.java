package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;

public class ThreadEnemigos extends Thread{

	private Juego juego;
	private Vector<Enemigo> enemigos;

	public ThreadEnemigos(Juego j, Vector<Enemigo> enemigos) {
		this.juego = j;
		this.enemigos = enemigos;
	}

	public void run() {
		while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				moverEnemigos();
//				int dir = enemigo.getDireccion();
//				if (juego.canMove(enemigo,dir)) {
//					System.out.println("Puedo moverme");
//					juego.mover(dir);
//				}
		}
	}

	private void moverEnemigos() {
		synchronized(enemigos){
			Iterator<Enemigo> iEnemigos = enemigos.iterator();
			while(iEnemigos.hasNext()) {
				Enemigo e = iEnemigos.next();
				e.mover(2);
			}
		}
		
	} 
}

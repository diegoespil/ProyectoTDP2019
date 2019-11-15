package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;

public class ThreadRango extends Thread{

	private Juego juego;
	private ThreadEnemigos te;
	private Vector<Enemigo>  enemigos;
	
	public ThreadRango(Juego j, ThreadEnemigos te) {
		this.juego = j;
		this.te = te;
		enemigos = null;
	}
	
	public void run() {
		while(true){
			enemigos = te.getEnemigos();
			for (Enemigo e : enemigos){
				juego.enRango(e,-1);
			}
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
}

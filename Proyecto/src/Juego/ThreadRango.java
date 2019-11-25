package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;

public class ThreadRango extends Thread{

	private Juego juego;
	private ThreadEnemigos te;
	private ThreadPersonaje tp;
	private Vector<Enemigo>  enemigos;
	private Vector<Personaje>  personajes;
	private boolean suspend;
	
	public ThreadRango(Juego j, ThreadEnemigos te, ThreadPersonaje tp) {
		this.juego = j;
		this.te = te;
		this.tp = tp;
		enemigos = null;
		personajes = null;
		suspend = false;
	}
	
	public void run() {
		while(true){
			System.out.println("while true ThreadRango");
			synchronized(this) {
				while(suspend)
					try {
						wait();
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			}
			enemigos = te.getEnemigos();
			for (Enemigo e : enemigos){
				juego.enRango(e,-1);
			}
			personajes = tp.getPersonajes();
			for (Personaje e1 : personajes){
				juego.enRango(e1,1);
			}
			try {
				this.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
	
	public void suspended() {
		suspend = true;
	}
	
	synchronized void resumen() {
		suspend = false;
		notify();
	}
}

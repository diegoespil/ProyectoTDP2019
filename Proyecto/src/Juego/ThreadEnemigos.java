package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Entidad;
import Entidad.Integrante.Enemigo.Enemigo;

public class ThreadEnemigos extends Thread{

	private Juego juego;
	private Vector<Enemigo>  enemigos;
	private Vector<Enemigo> eliminados;
	private boolean suspend;
	//private volatile int cont;

	public ThreadEnemigos(Juego j) {
		this.juego = j;
		eliminados = new Vector<Enemigo>();
		enemigos = new Vector<Enemigo>();
		//cont = 0;
		suspend = false;
	}

	public void run() {
		while(true){
			synchronized(this) {
				while(suspend)
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			Iterator<Enemigo> lista = enemigos.iterator();
			while(lista.hasNext()){
				Enemigo enemigo = lista.next();
				if ((enemigo.getVida()<=0)){
					juego.eliminarEnemigo(enemigo);	
					eliminados.add(enemigo);
				}
				else{
					int cont = enemigo.getContPasos();
					//juego.enRango(enemigo,-1);
					Entidad sig = juego.getSiguiente(enemigo,-1);
					if(cont<60) {
						//Entidad sig = juego.getSiguiente(enemigo,-1);
						if (sig == null){
							juego.mover(enemigo, -1);
							enemigo.setContPasos(cont+1);
						}
					}
					else {
						
						if (sig == null){
							juego.actualizarGrilla(enemigo,-1);
						}
						//juego.enRango(enemigo,-1);
						enemigo.setContPasos(0);
					}	
				}	  
			}
			try {
				this.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Enemigo e1: eliminados)
				enemigos.remove(e1);
			eliminados.removeAllElements();
		} 
	}
	
	public void insertarEnemigo(Enemigo e){
		enemigos.add(e);
	}
	
	public Vector<Enemigo> getEnemigos(){
		return enemigos;
	}
	
	public void suspended() {
		suspend = true;
	}
	
	synchronized void resumen() {
		suspend = false;
		notify();
	}
}
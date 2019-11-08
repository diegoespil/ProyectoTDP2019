package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Entidad;
import Entidad.Integrante.Enemigo.Enemigo;

public class ThreadEnemigos extends Thread{

	private Juego juego;
	private Vector<Enemigo>  enemigos;
	private Vector<Enemigo> eliminados;
	private volatile int cont;

	public ThreadEnemigos(Juego j) {
		this.juego = j;
		eliminados = new Vector<Enemigo>();
		enemigos = new Vector<Enemigo>();
		cont = 0;
	}

	public void run() {
		while(true){
			Iterator<Enemigo> lista = enemigos.iterator();
			while(lista.hasNext()){
				Enemigo enemigo = lista.next();
				if ((enemigo.getVida()<=0)){
					juego.eliminarEnemigo(enemigo);	
					eliminados.add(enemigo);
				}
				else{
					juego.enRango(enemigo,-1);
					if(cont<60) {
						Entidad sig = juego.getSiguiente(enemigo,-1);
						if (sig == null){
							juego.mover(enemigo, -1);
							cont++;
						}
					}
					else {
						juego.actualizarGrilla(enemigo,-1);
						cont = 0;
					}	
				}	   
			}
			try {
				this.sleep(50);
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
}
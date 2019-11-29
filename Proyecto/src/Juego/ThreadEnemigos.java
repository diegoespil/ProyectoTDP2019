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
				//System.out.println("Estoy en ThreadEnemigos");
				Enemigo enemigo = lista.next();
				//System.out.println("Vida de "+enemigo+": "+enemigo.getVida());
				//System.out.println("Posicion de "+enemigo+": "+enemigo.getPos());
				if ((enemigo.getVida()<=0)){
					if (enemigo.getPremio()!=null)
						juego.dropPremio(enemigo.getPremio(),enemigo.getPos());
					juego.eliminarEnemigo(enemigo);	
					eliminados.add(enemigo);
				}
				else{
					int cont = enemigo.getContPasos();
					//juego.enRango(enemigo,-1);
					Entidad sig = juego.getSiguiente(enemigo,-1);
					if(sig != null){ //solo para debuguear
						//System.out.println("Para "+enemigo.toString()+": sig es "+sig.toString());
					}
					else //System.out.println("Para "+enemigo.toString()+": sig es nulo");
					if(cont<60) {
						//Entidad sig = juego.getSiguiente(enemigo,-1);
						if (sig == null){
							for(int i=0; i<enemigo.getVelocidad(); i++){
								juego.mover(enemigo, -1);
							}
							enemigo.setContPasos(cont+enemigo.getVelocidad());
						}
					}
					else {
						
						if (sig == null){
							juego.actualizarGrilla(enemigo,-1);
							//System.out.println("Avanza enemigo ");
						}
						//juego.enRango(enemigo,-1);
						enemigo.setContPasos(0);
					}	
				}	  
			}
			try {
				this.sleep(300);
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
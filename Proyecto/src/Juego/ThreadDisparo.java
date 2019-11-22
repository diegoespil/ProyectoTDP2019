package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;


public class ThreadDisparo extends Thread{

	private Juego juego;
	private Vector<Disparo>  disparos;
	private Vector<Disparo> eliminados;
	private boolean suspend;
	//private volatile int cont;

	public ThreadDisparo(Juego j) {
		this.juego = j;
		disparos = new Vector<Disparo>();
		eliminados = new Vector<Disparo>();
		suspend = false;
		//cont = 0;
	}

	public void run() {
		while(true) {
			synchronized(this) {
				while(suspend)
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			Vector<Disparo> lista = (Vector<Disparo>) disparos.clone();
			for (Disparo d : lista){
				//Disparo d = lista.next();
				if(!d.llego()){
					int cont = d.getContPasos();
					Entidad sig = juego.getSiguiente(d, d.getMovimiento());
					if (sig != null) 
						juego.aceptarVisitor(sig, d);
					if(cont<60){
						 juego.mover(d,d.getMovimiento());
						 d.setContPasos(cont+1);
					}
					else{
						juego.actualizarDisparo(d,d.getMovimiento());
						sig = juego.getSiguiente(d, d.getMovimiento());
						if (sig != null) 
							juego.aceptarVisitor(sig, d);
						d.setContPasos(0);
						}
				}
				else{ 
					eliminados.add(d);
					juego.eliminar(d);
				}
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Disparo d1: eliminados)
				disparos.remove(d1);
			eliminados.removeAllElements();
		}
	}
				 
	public synchronized void iniciar(){
		this.start();
	}
	public synchronized void detener(){
		try {
			this.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void insertarDisparo(Disparo d){
		disparos.add(d);
	}
	
	public void suspended() {
		suspend = true;
	}
	
	synchronized void resumen() {
		suspend = false;
		notify();
	}
}
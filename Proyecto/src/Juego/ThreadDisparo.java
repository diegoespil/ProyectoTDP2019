package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;


public class ThreadDisparo extends Thread{

	private Juego juego;
	private Vector<Disparo>  disparos;
	private Vector<Disparo> eliminados;
	private volatile int cont;

	public ThreadDisparo(Juego j) {
		this.juego = j;
		disparos = new Vector<Disparo>();
		eliminados = new Vector<Disparo>();
		cont = 0;
	}

	public void run() {
		while(true) {
			Vector<Disparo> lista = (Vector<Disparo>) disparos.clone();
			for (Disparo d : lista){
				//Disparo d = lista.next();
				if(!d.llego()){
					if(cont<60){
						 juego.mover(d,d.getMovimiento());
						 cont++;
					}
					else{
						juego.actualizarDisparo(d,d.getMovimiento());
						Entidad sig = juego.getSiguiente(d, d.getMovimiento());
						if (sig != null) 
							juego.aceptarVisitor(sig, d);
						cont = 0;
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
}
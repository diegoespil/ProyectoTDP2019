package Juego;

import java.util.Iterator;
import java.util.Vector;
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
			Iterator<Disparo> lista = disparos.iterator();
			while(lista.hasNext()){
				Disparo d = lista.next();
				if(!d.llego()){
					if(cont<60){
						 juego.canMove(d,d.getMovimiento());
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
							cont++;
					}
					else{
						juego.actualizarDisparo(d,d.getMovimiento());
						System.out.println(d+"est+a en: "+d.getPos());
						cont = 0;
						}
				}
				else{ 
					eliminados.add(d);
					juego.eliminar(d);
				}
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
package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Entidad;
import Entidad.Integrante.Integrante;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;

public class ThreadPersonaje extends Thread{

	private Juego juego;
	private Vector<Personaje> personajes;
	private Vector<Personaje> personajesAInsertar;
	private Vector<Personaje> eliminados;
	private volatile int cont;
	private boolean suspend;

	public ThreadPersonaje(Juego j) {
		this.juego = j;
		personajes = new Vector<Personaje>();
		eliminados = new Vector<Personaje>();
		personajesAInsertar = new Vector<Personaje>();
		cont = 0;
		suspend = false;
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
			Iterator<Personaje> p = personajes.iterator();
			while(p.hasNext()) {
				System.out.println("Estoy en ThreadPersonaje");
				Personaje personaje = p.next();
				System.out.println("Posicion de personaje: "+personaje.getPos());
				System.out.println("Vida de personaje: "+personaje.getVida());
				//juego.enRango(personaje,1);
				if (personaje.getVida()<=0){
					System.out.println("Personaje muerto");
					eliminados.add(personaje);
					juego.eliminar(personaje);
				}
				/*	else{
						if(cont<60){
							if (juego.canMove(e,0) ){
								cont++;
							}
							try {
								Thread.sleep(25);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							
						}
						else{
							juego.actualizarGrilla(e,0);
							cont = 0;
						}*/
				try {
					this.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
			for(Personaje p_elim: eliminados)
				personajes.remove(p_elim);
			eliminados.removeAllElements();
			for(Personaje p_inser: personajesAInsertar)
				personajes.add(p_inser);
			personajesAInsertar.removeAllElements();
		}
	}
		 
	public void insertarPersonaje(Personaje p){
		personajesAInsertar.add(p);
	}
	
	public Vector<Personaje> getPersonajes(){
		return personajes;
	}
	
	public void suspended() {		
		System.out.println("Suspended Personaje");
		suspend = true;
	}
	
	synchronized void resumen() {
		System.out.println("Resumen Personaje");
		suspend = false;
		notify();
	}
}
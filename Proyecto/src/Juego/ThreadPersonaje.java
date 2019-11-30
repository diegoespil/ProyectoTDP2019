package Juego;
import java.util.Iterator;
import java.util.Vector;
import Entidad.Integrante.Personaje.Personaje;

public class ThreadPersonaje extends Thread{

	private Juego juego;
	private Vector<Personaje> personajes;
	private Vector<Personaje> personajesAInsertar;
	private Vector<Personaje> eliminados;
	private boolean suspend;

	public ThreadPersonaje(Juego j) {
		this.juego = j;
		personajes = new Vector<Personaje>();
		eliminados = new Vector<Personaje>();
		personajesAInsertar = new Vector<Personaje>();
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
				//System.out.println("Estoy en ThreadPersonaje");
				Personaje personaje = p.next();//System.out.println("Posicion de personaje: "+personaje.getPos());
				//System.out.println("Vida de personaje: "+personaje.getVida());
				if (personaje.getVida()<=0){
					//System.out.println("Personaje muerto");
					eliminados.add(personaje);
					juego.eliminar(personaje);
				}
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
		//System.out.println("Suspended Personaje");
		suspend = true;
	}
	
	synchronized void resumen() {
		//System.out.println("Resumen Personaje");
		suspend = false;
		notify();
	}
	
	synchronized void removeAll() {
		for(Personaje p_elim: eliminados)
			personajes.remove(p_elim);
	}
}
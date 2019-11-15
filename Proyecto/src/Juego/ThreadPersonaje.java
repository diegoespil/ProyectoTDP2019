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

	public ThreadPersonaje(Juego j) {
		this.juego = j;
		personajes = new Vector<Personaje>();
		eliminados = new Vector<Personaje>();
		personajesAInsertar = new Vector<Personaje>();
		cont = 0;
	}

	public void run() {
		while(true) {
			Iterator<Personaje> p = personajes.iterator();
			while(p.hasNext()) {
				Personaje personaje = p.next();
				System.out.println("Personaje: "+personaje==null);
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				juego.enRango(personaje,1);
				System.out.println("Luego de ver el rango del personaje");
				if (personaje.getVida()<=0){
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
}
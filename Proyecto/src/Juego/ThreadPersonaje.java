package Juego;

import java.util.Vector;

import Entidad.Entidad;
import Entidad.Integrante.Integrante;
import Entidad.Integrante.Enemigo.Enemigo;

public class ThreadPersonaje extends Thread{

	private Juego juego;
	private Vector<Entidad> personajes;
	private volatile int cont;

	public ThreadPersonaje(Juego j) {
		this.juego = j;
		personajes = new Vector<Entidad>();
		cont = 0;
	}

	public void run() {
		while(true) {
			System.out.println("cantidad de perseonajes "+juego.getPersonajes().size());
			for(Integrante e: juego.getPersonajes()) {
				System.out.println("personaje "+e.getVida());
				while(e.getVida()>0){
					juego.enRango(e,1);
					if ((e.getVida()<=0)){
						juego.eliminar(e);
						
					}
					else{
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
						}
						
					}	   
				}
			}
		} 
	}
}
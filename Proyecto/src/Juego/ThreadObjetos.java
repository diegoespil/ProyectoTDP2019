package Juego;

import java.util.Iterator;
import java.util.Vector;

import Entidad.Entidad;
import Entidad.Objeto.Objeto;

public class ThreadObjetos extends Thread {

	private Juego juego;
	private Vector<Objeto> Objetos;
	private Vector<Objeto> ObjetosAInsertar;
	private Vector<Objeto> eliminados;
	private boolean suspend;

	public ThreadObjetos(Juego j) {
		this.juego = j;
		Objetos = new Vector<Objeto>();
		eliminados = new Vector<Objeto>();
		ObjetosAInsertar = new Vector<Objeto>();
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
			Iterator<Objeto> p = Objetos.iterator();
			while(p.hasNext()) {
				//System.out.println("Estoy en ThreadObjeto");
				Objeto objeto = p.next();//System.out.println("Posicion de Objeto: "+Objeto.getPos());
				//System.out.println("Vida de Objeto: "+Objeto.getVida());
				if (objeto.getVida()<=0){
					//System.out.println("Objeto muerto");
					eliminados.add(objeto);
					juego.eliminar(objeto);
				}
				else{
					if(objeto.esTransitable()){
						int x = objeto.getPos().x;
						int y = objeto.getPos().y;
						if(juego.hayEntidad(x, y)){
							Entidad pisando = juego.getEntidad(x, y);
							juego.aceptarVisitor(pisando, objeto);
						}
					}
				}
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
			for(Objeto p_elim: eliminados)
				Objetos.remove(p_elim);
			eliminados.removeAllElements();
			for(Objeto p_inser: ObjetosAInsertar)
				Objetos.add(p_inser);
			ObjetosAInsertar.removeAllElements();
		}
	}
		 
	public void insertarObjeto(Objeto p){
		ObjetosAInsertar.add(p);
	}
	
	public Vector<Objeto> getObjetos(){
		return Objetos;
	}
	
	public void suspended() {		
		//System.out.println("Suspended Objeto");
		suspend = true;
	}
	
	synchronized void resumen() {
		//System.out.println("Resumen Objeto");
		suspend = false;
		notify();
	}
}
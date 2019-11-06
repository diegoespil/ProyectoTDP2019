package Juego;

import java.util.LinkedList;

import Entidad.Disparo.Disparo;
import Entidad.Disparo.DisparoEnemigo;
import Entidad.Disparo.DisparoPersonaje;

public class ThreadDisparo extends Thread{

	private Juego juego;
	private LinkedList<Disparo>  disparosPersonaje;
	private LinkedList<Disparo>  disparosEnemigo;
	//private static volatile boolean llego;
	private volatile int cont;

	public ThreadDisparo(Juego j) {
		this.juego = j;
		disparosPersonaje = new LinkedList<Disparo>();
		disparosEnemigo = new LinkedList<Disparo>();
		//llego = false;
		cont = 0;
	}

	public void run() {
		while( !disparosPersonaje.isEmpty() || !disparosEnemigo.isEmpty() ){
			if(!disparosPersonaje.isEmpty()){
				for (Disparo d : disparosPersonaje){
					if(!d.llego()){
						if(cont<60){
							boolean movio = juego.canMoveDer(d);
							d.setLlego(movio);
							System.out.println("Hilo disapros : canMoveDer="+movio+"cont = "+cont);
							try {
								Thread.sleep(20);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							cont++;
						}
						else{
							juego.actualizarGrilla(d);
							cont = 0;
						}
					}
					else{ 
						//disparosPersonaje.remove(d);
						//juego.eliminar(d);
					}
						
				}
			}
			
		    //if(!disparosEnemigo.isEmpty()){
		    	//for(Disparo d : disparosEnemigo){
		    		
		    	//}
		}
			
		
		/*while(llego){
			if(cont<60){
				llego = juego.canMove(disparo);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cont++;
			}
			else{
				juego.actualizarGrilla(disparo);
				cont = 0;
			}
				
		}
		if (!llego){ 
			
			juego.eliminar(disparo);
			*/
			
		
	} 
	public synchronized void iniciar(){
		//llego=true;
		this.start();
	}
	public synchronized void detener(){
		//llego=false;
		try {
			this.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void insertarDisparoPersonaje(Disparo d){
		disparosPersonaje.add(d);
	}
	public void insertarDisparoEnemigo(Disparo d){
		disparosEnemigo.add(d);
	}
}
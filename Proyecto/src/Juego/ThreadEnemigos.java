package Juego;

import Entidad.Integrante.Enemigo.Enemigo;

public class ThreadEnemigos extends Thread{

	private Juego juego;
	private Enemigo enemigo;

	public ThreadEnemigos(Juego j) {
		this.juego = j;
		this.enemigo = juego.getEnemigo();
	}

	public void run() {
		while(!enemigo.estaMuerto()){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int dir = enemigo.getDireccion();
				if (juego.canMove(enemigo,dir)) {
					System.out.println("Puedo moverme");
					juego.mover(dir);
				}
		}
	} 
}

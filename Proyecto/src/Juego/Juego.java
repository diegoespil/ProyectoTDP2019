package Juego;

import java.awt.Point;
import javax.swing.JLabel;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;
import Gui.miVentanaJuego;
import Visitador.VisitorEnemigo;

public class Juego extends Thread{
	private Enemigo enemigo;
	private miVentanaJuego gui;
	private int puntaje;
	private int monedas;
	
	public Juego(miVentanaJuego gui) {
		this.monedas = 200;
		this.gui = gui;
		enemigo = new Poseido(12,5,10,5,2,20,30); //(x,y,velocidad,danio,alcance,puntaje,monedas) 
		gui.setGrilla(enemigo.getPos(), enemigo.getGrafico(enemigo.getDireccion()));
		this.puntaje = 0;
	}
	
	public void mover(int dir){
		System.out.println("mover");
		gui.celdaVacia(enemigo.getPos());
		enemigo.mover(dir);
		gui.setGrilla(enemigo.getPos(), enemigo.getGrafico(dir));
	}
	
	public boolean canMove(Enemigo e, int dir) {
		boolean can = false;
		Point pos = e.getPos();
		JLabel grilla [][] = gui.getGrilla();
		System.out.println("Direccion: "+dir);
		System.out.println("Posicion x: "+pos.x+" pos y: "+pos.y);
		switch (dir) {
			case 0: {
				if ((pos.y != 0)&&(grilla[pos.y-1][pos.x].getIcon() == null)) {
						System.out.println("Can to "+dir+"(up)");
						can = true;
						break;
					}
				else {
					//visitor de la entidad contraria a la colision
					e.accept(new VisitorEnemigo());
				}
			}
			case 1: {
				if ((pos.y != 7)&&(grilla[pos.y+1][pos.x].getIcon() == null)) {
						System.out.println("Can to "+dir+"(down)" );
						can=true; 
						break;
					}
				}
			case 2: {
				if ((pos.x != 0)&&(grilla[pos.y][pos.x-1].getIcon() == null)){
						System.out.println("Can to "+dir+"(left)");
						can=true;
						break;
					}
				}
		}
		return can;
	}

	public Enemigo getEnemigo() {
		return this.enemigo;
	}
	
	public void eliminarEnemigo(Enemigo e) {
		e.setMuerto();
		this.puntaje +=e.getPuntaje();
		gui.actualizarPuntaje(puntaje);	
	}
	
	public int getMoneda() {
		return this.monedas;
	}
	
	public void setMonedas(int monedas) {
		this.monedas += monedas;
	}
}


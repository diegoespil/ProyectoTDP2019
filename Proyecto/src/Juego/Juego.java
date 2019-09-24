package Juego;

import java.awt.Point;
import java.util.Random;

import javax.swing.JLabel;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;
import Entidad.Integrante.Personaje.Mike;
import Entidad.Integrante.Personaje.Personaje;
import Gui.miVentanaJuego;

public class Juego {
	private Enemigo enemigo;
	private Personaje personaje;
	private miVentanaJuego gui;
	
	public Juego(miVentanaJuego gui) {
		/* modifiqu� el constructor de Enemigo para que incluya el par�metro puntaje,
		 * por eso esta declaraci�n de new Poseido tiene un par�metro extra.
		 * Ese cero al final corresponde al puntaje.
		 * -Bernardo
		 */
		this.gui = gui;
		enemigo = new Poseido(12,5,10,5,2,20,30); //(x,y,velocidad,danio,alcance,puntaje,monedas) 
		gui.setGrilla(enemigo.getPos(), enemigo.getGrafico());
		
		
		
		personaje = new Mike(1,6, 5, 6, 10);
	}
	
	public void mover(int dir){
		System.out.println("mover");
		gui.celdaVacia(enemigo.getPos());
		enemigo.mover(dir);
		gui.setGrilla(enemigo.getPos(), enemigo.getGrafico());
	}
	
	public boolean canMove(Enemigo e, int dir) {
		boolean can = false;
		Point pos = e.getPos();
		JLabel grilla [][] = gui.getGrilla();
		System.out.println("Direccion: "+dir);
		System.out.println("Posicion x: "+pos.x+" pos y: "+pos.y);
		switch (dir) {
			case 0: {if ((pos.y != 0) && (grilla[pos.y-1][pos.x].getIcon() == null)) {System.out.println("Can to "+dir);can = true;break;}}
			case 1: {if ((pos.y != 7) && (grilla[pos.y+1][pos.x].getIcon() == null)) {System.out.println("Can to "+dir);can=true; break;}}
			case 2: {if ((pos.x != 0) && (grilla[pos.y][pos.x-1].getIcon() == null)) {System.out.println("Can to "+dir);can=true; break;}}
			case 3: {if ((pos.x != 12) && (grilla[pos.y][pos.x+1].getIcon() == null)) {System.out.println("Can to "+dir);can=true; break;}}
		}
		return can;
	}


	public Enemigo getEnemigo() {
		return this.enemigo;
	}
}

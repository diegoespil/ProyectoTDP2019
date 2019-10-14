package Juego;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Entidad.Entidad;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;
import Entidad.Objeto.Objeto;
import Gui.miVentanaJuego;
import Juego.Nivel.Nivel;
import Juego.Nivel.Nivel1;
import Visitador.VisitorEnemigo;

public class Juego extends Thread{
	private Enemigo enemigo;
	private Vector<Enemigo> enemigos;
	private Vector<Objeto> objetos;
	private Nivel nivel;
	private miVentanaJuego gui;
	private int puntaje;
	private int monedas;
	
	public Juego(miVentanaJuego gui) {
		this.gui = gui;
		this.enemigos = new Vector<Enemigo>();
		this.objetos = new Vector<Objeto>();
		this.nivel = new Nivel1(this);
		this.monedas = 200;
		agregarEnemigos();
//		enemigo = new Poseido(12,5,10,5,2,20,30); //(x,y,velocidad,danio,alcance,puntaje,monedas) 
//		gui.setGrilla(enemigo.getPos(), enemigo.getGrafico());
		this.puntaje = 0;
	}
	
	private void agregarEnemigos() {
		for(int i = 0;i < 4; i++) {
			Enemigo e = nivel.getEnemigo();
			if (e!=null) {
				this.enemigos.add(e);
				gui.getContentPane().add(e.getGrafico());
			}
		}
		
	}

//	public void mover(int dir){
//		System.out.println("mover");
////		gui.celdaVacia(enemigo.getPos());
////		enemigo.mover(dir);
////		gui.setGrilla(enemigo.getPos(), enemigo.getGrafico());
//	}
	
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
	
	public void colisionEnemigoObstaculos(Entidad e, int dir) {
		int x = e.getPos().x;
		int y = e.getPos().y;
		Rectangle rEnemigo = new Rectangle(x,y);
	}

	public void colisionEnemigoPersonaje(Entidad e, int dir) {
		
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
	
	public miVentanaJuego getGui() {
		return this.gui;
	}
}


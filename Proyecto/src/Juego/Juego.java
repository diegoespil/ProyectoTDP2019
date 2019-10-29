package Juego;

import java.awt.Image;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;
import Entidad.Objeto.ConVida.Auto;
import Entidad.Objeto.ConVida.ObjetoConVida;
import Entidad.Objeto.Temporal.ObjetoTemporal;
import Gui.miVentanaJuego;
import Juego.Nivel.Nivel;
import Juego.Nivel.Nivel1;
import Visitador.VisitorEnemigo;

public class Juego extends Thread{
	private Enemigo enemigo;
	private Disparo disparo;
	private miVentanaJuego gui;
	private int puntaje;
	private int monedas;
	private JLabel enemi;
	private JLabel shoot;
	private Entidad [][] grilla;
	private Nivel nivel;
	
	public Juego(miVentanaJuego gui) {
		this.nivel = new Nivel1(this);
		this.monedas = 200;
		this.gui = gui;
		//gui.setGrilla(enemigo.getPos(),enemi); //, enemigo.getGrafico(enemigo.getDireccion()));
		this.puntaje = 0;
		grilla = new Entidad[8][13];
		cargarEnemigos();
		cargarObjetos();
//		try {
//			getObstaculos();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
	}
	
	public void run(){
		
	}
	
	public void mover(int dir){ //NO EST� EN USO
		//gui.celdaVacia(enemigo.getPos());
		enemigo.mover(2);
		gui.setGrilla(enemigo.getPos(),enemi);// enemigo.getGrafico(dir));
	}
	
	public boolean canMove(Entidad e) {
		Point pos = e.getPos();
		Entidad siguiente = grilla[pos.x][pos.y-1];
		if ((pos.x != 0)&&(siguiente == null)){
			e.setPosicion(pos.x, (pos.y)-1);
			gui.mover(e);
			return true;
		}
		else {
			siguiente.accept(e.getVisitor());
			return false;
		}
	}
	
	/*public boolean canMove(Enemigo e, int dir) {
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
	} */

	public Enemigo getEnemigo() {
		return this.enemigo;
	}
	public Disparo getDisparo() {
		return disparo;
	}
	
	public void eliminarEnemigo(Enemigo e) {
		e.setMuerto();
		this.puntaje +=e.getPuntaje();
		gui.celdaVacia(enemi);
		//gui.actualizarPuntaje(puntaje); ACA LO ACTUALIZAMOS EL PUNTAJE EN LA GUI
	}
	
	public int getMoneda() {
		return this.monedas;
	}
	
	public void setMonedas(int monedas) {
		this.monedas += monedas;
	}
	
	public Entidad[][] getGrilla(){
		return grilla;
	}
	
	public void insertarEnemigo(Enemigo e){
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = e;
		enemigo = e;
	}
	public void insertarDisparo(Disparo d){
		int x =(int) d.getPos().getX();
		int y =(int) d.getPos().getY();
		grilla[x][y] = d;
		disparo = d;
	}
	public void eliminar(Entidad e){
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = null;
		gui.celdaVacia(e.getLabel());
	}
}

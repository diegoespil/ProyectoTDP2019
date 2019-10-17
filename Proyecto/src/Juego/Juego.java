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
	
	public Juego(miVentanaJuego gui) {
		this.monedas = 200;
		this.gui = gui;
		//gui.setGrilla(enemigo.getPos(),enemi); //, enemigo.getGrafico(enemigo.getDireccion()));
		this.puntaje = 0;
		grilla = new Entidad[8][13];
		try {
			getObstaculos();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void mover(int dir){ //NO ESTÁ EN USO
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
	
	public void getObstaculos() throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader("Archivo//Mapa1.txt");
		BufferedReader b = new BufferedReader(f);
		int fila = 0;
		while ((cadena = b.readLine()) != null) {
			procesarLinea(cadena, fila);
			fila++;
		}
		b.close();
	}

	private void procesarLinea(String cadena, int fila) {
		String arr[] = cadena.split(",");
		for (int i = 0; i < arr.length; i++) {
			switch(arr[i]) {
			/*case "fuego" : { grilla[fila][i] = new Fuego(fila,i,10);
							break;
			}*/
			case "auto" : { grilla[fila][i] = new Auto(fila,i,100);
							grilla[fila][i].setImage("Imagenes//auto-fuego1.png");
							break;
				
			}	
			case "auto2" : { grilla[fila][i] = new Auto(fila,i,100);
							grilla[fila][i].setImage("Imagenes//auto-fuego2.png");
							break;

            }
			case "auto3" : { grilla[fila][i] = new Auto(fila,i,100);
							grilla[fila][i].setImage("Imagenes/auto-fuego3.png");
							break;
			}
			
			}
		}
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

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
	private Subscriber gui;
	private int puntaje;
	private int monedas;
	private JLabel enemi;
	private JLabel shoot;
	private Entidad [][] grilla;
	
	public Juego(miVentanaJuego gui) {
		this.monedas = 200;
		this.gui = gui;
		this.puntaje = 0;
		grilla = new Entidad[8][13];
		try {
			getObstaculos();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void actualizarGrilla(Entidad e){
		Point pos = e.getPos();
		if(pos.y != 0){
			e.setPosicion(pos.x, (pos.y)-1);
			gui.update(e);
		}
		
	}
	
	public boolean canMove(Entidad e) {
		Point pos = e.getPos();
		if(pos.y != 0){
			Entidad siguiente = grilla[pos.x][pos.y-1];
			if ((pos.x != 0)&&(siguiente == null)){
				gui.update(e.getLabel());
				return true;
			}
			else {
				siguiente.accept(e.getVisitor());
				if(siguiente.getVida()<=0){
					eliminar(siguiente);
				}
				return false;
			}
		}
		else return false; //en este caso el jugador PERDIÓ
	}

	public Enemigo getEnemigo() {
		return this.enemigo;
	}
	public Disparo getDisparo() {
		return disparo;
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
			case "auto" : { 
				Auto a = crearAuto(fila,i,1300);
				grilla[fila][i] = a;
				break;
				
			}	
			case "auto2" : {  
				Auto a = crearAuto(fila,i,1300);
				grilla[fila][i] = a;
				break;

            }
			case "auto3" : { 
				Auto a = crearAuto(fila,i,1300);
				grilla[fila][i] = a;
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
	public Auto crearAuto(int x, int y, int vida){
		Auto a = new Auto(x,y,vida);
		ImageIcon img = new ImageIcon("Imagenes//auto-fuego1.png");
		JLabel label = new JLabel();
		label.setBounds(a.getPos().y*60, a.getPos().x*60, 60, 60);
		label.setIcon(new ImageIcon(img.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		label.setVisible(true);
		a.setLabel(label);
		return a;
	}
	public void eliminar(Entidad e){
		e.setVida(0);
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = null;
		gui.update(e);
	}
	public void eliminarEnemigo(Enemigo e){
		puntaje += e.getPuntaje();
		e.setVida(0);
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = null;
		gui.update(e);
	}
}

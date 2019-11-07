package Juego;

import java.awt.Image;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Creadores.CreadorConVida.CreadorAuto;
import Creadores.CreadorEntidad.CreadorEntidad;
import Creadores.CreardorEnemigo.CreadorPoseido;
import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Disparo.DisparoEnemigo;
import Entidad.Disparo.DisparoPersonaje;
import Entidad.Integrante.Integrante;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Poseido;
import Entidad.Objeto.ConVida.Auto;
import Entidad.Objeto.ConVida.ObjetoConVida;
import Entidad.Objeto.Temporal.ObjetoTemporal;
import Gui.miVentanaJuego;
import Juego.Nivel.Nivel;
import Juego.Nivel.Nivel1;
import Tienda.Tienda;
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
	private Tienda shop;
	private ThreadEnemigos threadEnemigos;
	private ThreadDisparo threadDisparo;
	private ThreadPersonaje threadPersonaje;
	private Vector<Integrante> personajes;

	public Juego(miVentanaJuego gui) {
		this.nivel = new Nivel1(this);
		this.monedas = 20000;
		this.gui = gui;
		this.puntaje = 0;
		shop = new Tienda(this);
		grilla = new Entidad[8][13];
		//cargarEnemigos();
		//cargarObjetos();
		personajes = new Vector<Integrante>();
		try {
			getObstaculos();
		} catch (IOException e) {
			e.printStackTrace();
		}
		insertarEnemigo2();
		threadEnemigos = new ThreadEnemigos(this);
		threadEnemigos.start();
		//threadPersonaje = new ThreadPersonaje(this);
		//threadPersonaje.start();
		threadDisparo = new ThreadDisparo(this);
	/*	
		for(int i = 0; i<4 ;i++){
			Disparo disparo = new DisparoPersonaje(i,1,10,1);
			insertar(disparo);
			threadDisparo.insertarDisparo(disparo);
		}
		
		for(int i = 0; i<4 ;i++){
			Disparo disparo = new DisparoEnemigo(i,12,10,1);
			insertar(disparo);
			threadDisparo.insertarDisparo(disparo);
		}
		
		*/
		threadDisparo.iniciar();
	}

	public void run(){

	}

	public void actualizarGrilla(Entidad e,int dir){
		Point pos = e.getPos();
		System.out.println("pos "+pos.x+" "+pos.y);
		if(pos.y > 0 && pos.y<=12){
			e.setPosicion(pos.x, (pos.y)+dir);
		}
	}

	public boolean canMove(Entidad e,int dir ) {
		Point pos = e.getPos();
		if(pos.y > 0 && pos.y<=12){
			Entidad siguiente = grilla[pos.x][pos.y+dir];
			if (siguiente == null){
				gui.update(e.getLabel(),+dir);
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
		else return false; //en este caso el jugador PERDIO
	}
	
	/*
	public boolean canMoveDer(Entidad e){
		Point pos = e.getPos();
		if(pos.y != 12){
			Entidad siguiente = grilla[pos.x][pos.y+1];
			if (siguiente == null){
				gui.update(e.getLabel(),1);
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
		else return false; 
	}*/
	
	
	public boolean enRango(Integrante i,int dir) {
    	Point pos = i.getPos();
		int j = i.getAlcance();
		for(int k= 0;k<j && (pos.y>0 && pos.y<12);k++) {		
			Entidad siguiente = grilla[pos.x][pos.y+(k*dir)];
			if(siguiente != null) {
				siguiente.accept(i.getVisitor());
				Disparo disparo = i.getDisparo();
				if(disparo != null){
					System.out.println("tengo disparo");
					threadDisparo.insertarDisparo(disparo);
					insertar(disparo);
				}
				return true;
			}			
		}
		return false;
	}
	/*
	public boolean enRangoPersonaje(Integrante i) {
		Point pos = i.getPos();
		int j = i.getAlcance();
		for(int k= 0;k<j && pos.y!=12;k++) {		
			Entidad siguiente = grilla[pos.x][pos.y+k];
			if(siguiente != null) {
				siguiente.accept(i.getVisitor());
				Disparo disparo = i.getDisparo();
				if(disparo != null){
					threadDisparo.insertarDisparoPersonaje(disparo);
					insertar(disparo);
				}
				return true;
			}			
		}
		return false;
	}
	
    public boolean enRangoEnemigo(Integrante i) {Vector
    	Point pos = i.getPos();
		int j = i.getAlcance();
		for(int k= 0;k<j && pos.y!=0;k++) {		
			Entidad siguiente = grilla[pos.x][pos.y-k];
			if(siguiente != null) {
				siguiente.accept(i.getVisitor());
				return true;
			}			
		}
		return false;
	}
*/
	public Enemigo getEnemigo() {
		return this.enemigo;
	}
	public Disparo getDisparo() {
		return disparo;
	}

	public int getMonedas() {
		return this.monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	
	public Tienda getTienda() {
		return shop;
	}

	public Entidad[][] getGrilla(){
		return grilla;
	}
	
	public boolean hayEntidad(int x,int y) {
		return grilla[x][y] != null;
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
		CreadorEntidad creador = new CreadorAuto();
		for (int i = 0; i < arr.length; i++) {
			switch(arr[i]) {
			/*case "fuego" : { grilla[fila][i] = new Fuego(fila,i,10);
							break;
			}*/
			case "auto" : {
				Entidad a = creador.crear();
				a.setPosicion(fila, i);
				insertar(a);
				break;
			}
			case "auto2" : {
				Entidad a = creador.crear();
				a.setPosicion(fila, i);
				insertar(a);
				break;

            }
			case "auto3" : {
				Entidad a = creador.crear();
				a.setPosicion(fila, i);
				insertar(a);
			}
			}
		}
	}

	public void insertar(Entidad e){
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = e;
		gui.insertar(e.getLabel(),x*60,y*60);
	}
	
	public void insertarEnemigo2(){
		CreadorPoseido cp = new CreadorPoseido();
		Enemigo e = cp.crear();
		e.setPosicion(4, 12);
		insertar(e);
		this.enemigo = e;
	}
	
	public void insertarPersonaje(int x,int y) {
		Entidad nueva = shop.getProximo();
		if(nueva != null ) {
			monedas = monedas - shop.finalizarCompra();
			shop.quitarProximo();
			grilla[x][y] = nueva;
			nueva.setPosicion(x, y);
			gui.insertar(nueva.getLabel(), x*60, y*60);
			personajes.add((Integrante)nueva);
			System.out.println("monedas "+monedas);
		}
	}
	
	public void insertarDisparo(Disparo d){
		int x =(int) d.getPos().getX();
		int y =(int) d.getPos().getY();
		grilla[x][y] = d;
		disparo = d;
	}
	public void eliminar(Entidad e){
		e.setVida(0);
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = null;
		gui.quitarLabel(e.getLabel());
	}
	public void eliminarEnemigo(Enemigo e){
		puntaje += e.getPuntaje();
		e.setVida(0);
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = null;
		gui.quitarLabel(e.getLabel());
	}
	
	public Vector<Integrante> getPersonajes(){
		return personajes;
	}
}

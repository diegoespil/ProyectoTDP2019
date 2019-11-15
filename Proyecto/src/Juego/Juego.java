package Juego;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JLabel;
import Creadores.CreadorConVida.CreadorAuto;
import Creadores.CreadorEntidad.CreadorEntidad;
import Creadores.CreardorEnemigo.CreadorPoseido;
import Creadores.CreardorEnemigo.CreadorRuso;
import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Disparo.DisparoEnemigo;
import Entidad.Disparo.DisparoPersonaje;
import Entidad.Integrante.Integrante;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Objeto.ConVida.Auto;
import Gui.miVentanaJuego;
import Juego.Nivel.Nivel;
import Juego.Nivel.Nivel1;
import Tienda.Tienda;

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
		grilla = new Entidad[8][14];
		threadEnemigos = new ThreadEnemigos(this);
		
		cargarEnemigos();
		//cargarObjetos();
		personajes = new Vector<Integrante>();
		try {
			getObstaculos();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//insertarEnemigo2();
		
		//threadPersonaje = new ThreadPersonaje(this);
		//threadPersonaje.start();
		threadDisparo = new ThreadDisparo(this);
		

		//for(int i = 0; i<4 ;i++){
		
		/*Disparo disparo = new DisparoPersonaje(4,1,1000,1);
		gui.insertar(disparo.getLabel(),disparo.getPos().x*60,disparo.getPos().y*60);
		threadDisparo.insertarDisparo(disparo); */
		/*for(int i = 0; i<6 ;i++){
			Disparo disparo = new DisparoPersonaje(i,1,10,1);
			gui.insertar(disparo.getLabel(),disparo.getPos().x*60,disparo.getPos().y*60);
			threadDisparo.insertarDisparo(disparo);
		}
		
		/*
		for(int i = 0; i<4 ;i++){
			Disparo disparo = new DisparoEnemigo(i,12,10,1);
			gui.insertar(disparo.getLabel(),disparo.getPos().x*60,disparo.getPos().y*60);
			threadDisparo.insertarDisparo(disparo);
		}*/
	
		threadDisparo.iniciar();
		threadEnemigos.start();
		
	}
	
	public void cargarEnemigos() {
		int cont = 2;
		Vector<Enemigo> enemigos = nivel.getOleada1();
		for(Enemigo e : enemigos) {
			e.setPosicion(cont, 12);
			insertar(e);
			threadEnemigos.insertarEnemigo(e);
			cont++;
		}
	}

	public void actualizarGrilla(Entidad e,int dir){
		Point pos = e.getPos();
		int oldX = pos.x;
		int oldY = pos.y;
		System.out.println("pos "+pos.x+" "+pos.y);
		if(pos.y > 0 && pos.y<=12){
			int newX = pos.x;
			int newY = pos.y+dir;
			e.setPosicion(newX, newY);
			grilla[newX][newY] = e;
			grilla[oldX][oldY] = null;
		}
	}
	
	public void actualizarDisparo(Disparo e,int dir){
		Point pos = e.getPos();
		int newX = pos.x;
		int newY = pos.y+dir;
		if(newY >= 13) e.setLlego(true);
		else e.setPosicion(newX, newY);
		
	}

	public Entidad getSiguiente(Entidad e, int dir){
		Point pos = e.getPos();
		Entidad siguiente = null;
		if(pos.y > 0 && pos.y<=12)
			siguiente = grilla[pos.x][pos.y+dir];
		return siguiente;
	}
	public void mover(Entidad e, int dir){
		if (e != null) gui.update(e.getLabel(),+dir);
	}
	public void aceptarVisitor(Entidad aceptador, Entidad visitante){
		aceptador.accept(visitante.getVisitor());
		if(aceptador.getVida()<=0){ //esta parte deberï¿½a sacarse y hacerse en otro lado
			eliminar(aceptador); System.out.println("murió algo");
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
	
	public boolean enRango(Integrante i,int dir) {
    	Point pos = i.getPos();
		int j = i.getAlcance();
		for(int k= 1;k<=j && pos.y+(k*dir)>0 && pos.y<=12;k++) {	
			Entidad siguiente = grilla[pos.x][pos.y+(k*dir)];
			if(siguiente != null) {
				aceptarVisitor(siguiente,i);
				System.out.println("revisïo rango");
				Disparo disparo = i.getDisparo();
				if(disparo != null) System.out.println("tengo disparo");
				else System.out.println("disparo es nulo");
				if(disparo != null){
					threadDisparo.insertarDisparo(disparo);
					
					System.out.println("disparo insertado");
					
					gui.insertar(disparo.getLabel(),disparo.getPos().x*60,disparo.getPos().y*60);
				}
				return true;
			}
		}
		return false;
	}

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
		Entidad ent =  grilla[x][y];
		if (ent!=null){
			System.out.println(ent);
		}
		else System.out.println("hay nulo");
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
		//CreadorRuso cp = new CreadorRuso();
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

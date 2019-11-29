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
import Creadores.CreadorTemporal.CreadorAtaqueX2;
import Creadores.CreardorEnemigo.CreadorPoseido;
import Creadores.CreardorEnemigo.CreadorRuso;
import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Disparo.DisparoEnemigo;
import Entidad.Disparo.DisparoPersonaje;
import Entidad.Integrante.Integrante;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Integrante.State.Ataque;
import Entidad.Integrante.State.Normal;
import Entidad.Objeto.ConVida.Auto;
import Entidad.Objeto.Temporal.PowerupEnMapa.AtaqueX2;
import Entidad.Objeto.Temporal.ObjetoTemporal;
import Gui.miVentanaJuego;
import Juego.Nivel.Nivel;
import Juego.Nivel.Nivel1;
import Juego.Oleada.Oleada;
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
	private ThreadRango threadRango; //nuevo
	private ThreadDisparo threadDisparo;
	private ThreadPersonaje threadPersonaje;
	private Vector<Integrante> personajes;
	private boolean fin;
	private AtaqueX2 power;
	private ObjetoTemporal powerupguardado;

	public Juego(miVentanaJuego gui) {
		this.fin = false;
		this.nivel = new Nivel1(this);
		this.monedas = 20000;
		this.gui = gui;
		this.puntaje = 0;
		shop = new Tienda(this);
		grilla = new Entidad[8][14];
		threadEnemigos = new ThreadEnemigos(this);
		threadPersonaje = new ThreadPersonaje(this);
		threadRango = new ThreadRango(this, threadEnemigos,threadPersonaje);
		//cargarEnemigos(nivel.getOleada(4)); el que anda
		CreadorAtaqueX2 cr = new CreadorAtaqueX2();
		insertarEnemigo2( (ObjetoTemporal) cr.crear());
		
		
		
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
		threadRango.start();
		threadPersonaje.start();
		this.start();
	}
	
	public void levantarPowerup(){
		CreadorAtaqueX2 ca = new CreadorAtaqueX2(); 
		powerupguardado = (ObjetoTemporal) ca.crear();
		//borrar reporte, es solo para testear imprimiendo por consola
		String reporte;
		if (powerupguardado == null) reporte = "nulo";
		else reporte = powerupguardado.toString();
		System.out.println("powerup guardado: "+reporte);
	}
	
	public void dropPremio(ObjetoTemporal o, Point p) {
		o.setPosicion(p.x,p.y);
		gui.insertar(o.getLabel(), p.x*60, p.y*60);
		
	}
	
	public void asignarPowerup(int x, int y) {
		Entidad e = grilla[y][x];
		if(powerupguardado != null){
			aceptarVisitor(e,powerupguardado);
			System.out.println("asignarPowerup() envio visitor");
		}
		
	}
	
	public void cargarEnemigos(Oleada oleada) {
		int cont = 0;
		Vector<Enemigo> enemigos = oleada.getEnemigos();
		for(Enemigo e : enemigos) {
			e.setPosicion(cont*2, 12);
			insertar(e);
			threadEnemigos.insertarEnemigo(e);
			cont++;
			
		}
	}

	public synchronized void actualizarGrilla(Entidad e,int dir){
		//System.out.println("Actualizar grilla");
		//System.out.println("Entidad "+e+" pos "+e.getPos());
		Point pos = e.getPos();
		int oldX = pos.x;
		int oldY = pos.y;
		////System.out.println("pos "+pos.x+" "+pos.y);
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
		if(newY == 0) e.setLlego(true);
		else e.setPosicion(newX, newY);
		
	}
	
	public boolean hayEnemigos() {
		return !this.threadEnemigos.getEnemigos().isEmpty();
	}
	
	public void run() {
		while (!fin) {
			if (!hayEnemigos()) {
				Oleada oleada = nivel.getOleada(4);
				if (oleada == null) { //termine el nivel
					this.nivel = this.nivel.subirNivel();
					if (this.nivel == null) { //termino el juego
						fin = true;
					} else
						oleada = nivel.getOleada(4);
				}
				cargarEnemigos(oleada);
			}
		}
	}

	public Entidad getSiguiente(Entidad e, int dir){
		Point pos = e.getPos();
		Entidad siguiente = null;
		//System.out.println("Get posicion(): soy "+e);
		//System.out.println("Posicion siguiente a x: "+pos.x+" y: "+pos.y+" en direccion: "+dir);
		////System.out.println("Grilla en posicion "+grilla[pos.x][pos.y]);
		////System.out.println("Grilla en posicion siguiente"+grilla[pos.x][pos.y+dir]);
		if(pos.y > 0 && pos.y<=12) {
			//System.out.println("Pos y entre 0 y 12");
			//System.out.println("Antes de setear siguiente: "+siguiente);
			siguiente = grilla[pos.x][pos.y+dir];
			//System.out.println("despues de setear siguiente: "+grilla[pos.x][pos.y+dir]);
			//System.out.println("Despues de setear siguiente: "+siguiente);
		}
		//System.out.println("Posicion siguiente tiene "+siguiente);
		return siguiente;
	}
	public void mover(Entidad e, int dir){
		if (e != null) gui.updateLabel(e.getLabel(),+dir);
	}
	public void aceptarVisitor(Entidad aceptador, Entidad visitante){
		if(aceptador != null && visitante != null){
			aceptador.accept(visitante.getVisitor());
			if(aceptador.getVida()<=0)
				eliminar(aceptador);
		}
	}
	
	public synchronized boolean enRango(Integrante i,int dir) {
    	Point pos = i.getPos();
		int j = i.getAlcance();
		
		////System.out.println("Soy: "+i.toString());
		for(int k= 1;k<=j && pos.y+(k*dir)>=0 && pos.y+(k*dir)<=12;k++) {
			////System.out.println("En rango: pos y "+(pos.y+(k*dir)));
			Entidad siguiente = grilla[pos.x][pos.y+(k*dir)];
			if(siguiente != null) {
				aceptarVisitor(siguiente,i);
				//System.out.println("la vida del siguiente es: "+siguiente.getVida());
				////System.out.println("revis�o rango");
				Disparo disparo = i.getDisparo();
				//if(disparo != null) //System.out.println("tengo disparo");
				//else //System.out.println("disparo es nulo");
				if(disparo != null){
					i.setState(new Ataque(i));
					i.getState().disparar();
					gui.insertar(disparo.getLabel(),disparo.getPos().x*60+30,disparo.getPos().y*60+30);
					threadDisparo.insertarDisparo(disparo);					
					////System.out.println("disparo insertado
					////System.out.println("Personaje "+i+"posicion x "+pos.x+"y "+pos.y);
					////System.out.println("disparo insertado");
				}
				return true;
			}
		}
		i.setState(new Normal(i));
		i.getState().mover();
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
			//System.out.println(ent);
		}
		//else //System.out.println("hay nulo");
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
	
	public void insertarEnemigo2(ObjetoTemporal pw){
		//CreadorPoseido cp = new CreadorPoseido();
		
		CreadorRuso cp = new CreadorRuso();
		Enemigo e = cp.crear();
		e.setPosicion(1, 12);
		e.setPremio(pw);
		threadEnemigos.insertarEnemigo(e);
		insertar(e);
		//this.enemigo = e;
	}
	
	public void comprarPersonaje(int x,int y) {
		Entidad nueva = shop.getProximo();
		if(nueva != null ) {
			monedas = monedas - shop.finalizarCompra();
			shop.quitarProximo();
			gui.updateContadores(puntaje, monedas);
			grilla[x][y] = nueva;
			nueva.setPosicion(x, y);
			gui.insertar(nueva.getLabel(), x*60, y*60);
			personajes.add((Integrante)nueva);
			this.threadPersonaje.insertarPersonaje((Personaje) nueva);
			//System.out.println("Inserte personaje en x y "+x+" "+y);
		}
	}
	
	public void comprarObjeto(int x,int y) {
		Entidad nueva = shop.getProximo();
		if(nueva != null ) {
			monedas = monedas - shop.finalizarCompra();
			shop.quitarProximo();
			gui.updateContadores(puntaje, monedas);
			grilla[x][y] = nueva;
			nueva.setPosicion(x, y);
			gui.insertar(nueva.getLabel(), x*60, y*60);
		}
	}
	
	public boolean esPersonaje() {
		return shop.getEsPersonaje();
	}
	public boolean comprando(){
		return shop.getProximo() != null;
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
	
	public void eliminarDisparo(Entidad e){
		e.setVida(0);
		gui.quitarLabel(e.getLabel());
	}
	
	public void eliminarEnemigo(Enemigo e){
		puntaje += e.getPuntaje();
		monedas += e.getMonedas();
		e.setVida(0);
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = null;
		gui.quitarLabel(e.getLabel());
		gui.updateContadores(puntaje, monedas);
	}
	
	public Vector<Integrante> getPersonajes(){
		return personajes;
	}
	
	
	public void detenerJuego() {
			threadDisparo.suspended();
			threadPersonaje.suspended();
			threadEnemigos.suspended();
			threadRango.suspended();			
	}
	
	public void reanudarJuego() {

		threadDisparo.resumen();
		threadPersonaje.resumen();
		threadEnemigos.resumen();
		threadRango.resumen();
	}
}
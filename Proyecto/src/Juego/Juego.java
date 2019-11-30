package Juego;

import java.awt.Point;
import java.util.Vector;
import Creadores.CreadorTemporal.CreadorAtaqueX2;
<<<<<<< HEAD
=======
import Creadores.CreadorTemporal.CreadorFuego;
import Creadores.CreardorEnemigo.CreadorPoseido;
import Creadores.CreardorEnemigo.CreadorRuso;
>>>>>>> da9a54a68d57df2b0f9fa4cf32d110bfbe3c1226
import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.Integrante;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;
import Entidad.Integrante.State.Ataque;
import Entidad.Integrante.State.Normal;
import Entidad.Objeto.Objeto;
<<<<<<< HEAD
=======
import Entidad.Objeto.ConVida.Auto;
import Entidad.Objeto.Temporal.PowerupEnMapa.AtaqueX2;
import Entidad.Objeto.Temporal.PowerupEnMapa.PowerupEnMapa;
import Entidad.Objeto.Temporal.Fuego;
>>>>>>> da9a54a68d57df2b0f9fa4cf32d110bfbe3c1226
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
	private Entidad [][] grilla;
	private Nivel nivel;
	private Oleada oleada;
	private Tienda shop;
	private ThreadEnemigos threadEnemigos;
	private ThreadRango threadRango;
	private ThreadDisparo threadDisparo;
	private ThreadPersonaje threadPersonaje;
<<<<<<< HEAD
	//private Vector<Integrante> personajes;
	private boolean fin;
	private ObjetoTemporal powerupguardado;
	
=======
	private ThreadObjetos threadObjetos;
	private Vector<Integrante> personajes;
	private boolean fin;
	private AtaqueX2 power;
	private PowerupEnMapa powerupguardado;

>>>>>>> da9a54a68d57df2b0f9fa4cf32d110bfbe3c1226
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
		threadObjetos = new ThreadObjetos(this);
		threadRango = new ThreadRango(this, threadEnemigos,threadPersonaje);
		this.oleada = nivel.getOleada(4);
		nivel.setOleada(oleada);
		cargarObjetos();
		cargarEnemigos(oleada);
<<<<<<< HEAD
		//personajes = new Vector<Integrante>();
=======
		//cargarObjetos();
		personajes = new Vector<Integrante>();
		try {
			getObstaculos();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//prueba
		CreadorFuego cf = new CreadorFuego();
		Fuego fuego = (Fuego) cf.crear();
		fuego.setPosicion(0, 9);
		gui.insertar(fuego.getLabel(), fuego.getPos().x*60, fuego.getPos().y*60);
		threadObjetos.insertarObjeto(fuego);
		threadObjetos.start();
		//prueba
>>>>>>> da9a54a68d57df2b0f9fa4cf32d110bfbe3c1226
		threadDisparo = new ThreadDisparo(this);		
		threadDisparo.iniciar();
		threadEnemigos.start();
		threadRango.start();
		threadPersonaje.start();
		this.start();
	}
	
	public void levantarPowerup(){
		CreadorAtaqueX2 ca = new CreadorAtaqueX2(); 
		powerupguardado = (PowerupEnMapa) ca.crear();
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
			if(powerupguardado.getAsignado()){
				powerupguardado = null;
			}
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
	
	public void cargarObjetos() {
		Vector<Objeto> objetos = nivel.getObjetos();
		for(Objeto o : objetos)
			insertar(o);
	}

	public synchronized void actualizarGrilla(Entidad e,int dir){
		Point pos = e.getPos();
		int oldX = pos.x;
		int oldY = pos.y;
		if(pos.y > 0 && pos.y<=12){
			int newX = pos.x;
			int newY = pos.y+dir;
			e.setPosicion(newX, newY);
			grilla[newX][newY] = e;
			grilla[oldX][oldY] = null;
		}
		else {
			if(pos.y == 0)
				fin = true;
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
	
	@SuppressWarnings("static-access")
	public void run() {
		while (!fin) {
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!hayEnemigos()) {
				Oleada oleada = nivel.getOleada(4);
				nivel.setOleada(oleada);
				if (oleada == null && nivel.subirNivel() != null) { 
					ganoNivel();
					if (this.nivel == null) { 
						fin = true;
					} else {
						this.nivel.setOleada(null);
						oleada = nivel.getOleada(4);
					}
				}
				cargarEnemigos(oleada);
			}
		}
		if(fin)
			finalizarPartida();
	}
	
	public void ganoNivel() {
		grilla = new Entidad[8][14];
		this.fin = false;
		gui.ganoNivel();
		threadEnemigos.removeAll();
		threadPersonaje.removeAll();
		threadDisparo.removeAll();
		nivel = nivel.subirNivel();
		cargarObjetos();
		cargarEnemigos(oleada);
		this.oleada = nivel.getOleada(4);
		nivel.setOleada(oleada);
		
	}
	
	public void finalizarPartida() {
		String estado = "";
		if(hayEnemigos())
			estado = "perdido";
		else
			estado = "ganado";
		gui.finalizoPartida(estado);
	}

	public Entidad getSiguiente(Entidad e, int dir){
		Point pos = e.getPos();
		Entidad siguiente = null;
		if(pos.y > 0 && pos.y<=12) {
			siguiente = grilla[pos.x][pos.y+dir];
		}
		return siguiente;
	}
	public void mover(Entidad e, int dir){
		if (e != null) gui.updateLabel(e.getLabel(),+dir);
	}
	public void aceptarVisitor(Entidad aceptador, Entidad visitante){
		if(aceptador != null && visitante != null){
			aceptador.accept(visitante.getVisitor());
			//if(aceptador.getVida()<=0)
			//	eliminar(aceptador);
		}
	}
	
	public synchronized boolean enRango(Integrante i,int dir) {
    	Point pos = i.getPos();
		int j = i.getAlcance();
		for(int k= 1;k<=j && pos.y+(k*dir)>=0 && pos.y+(k*dir)<=12;k++) {
			Entidad siguiente = grilla[pos.x][pos.y+(k*dir)];
			if(siguiente != null) {
				aceptarVisitor(siguiente,i);
				Disparo disparo = i.getDisparo();
				if(disparo != null){
					i.setState(new Ataque(i));
					i.getState().disparar();
					gui.insertar(disparo.getLabel(),disparo.getPos().x*60+30,disparo.getPos().y*60+30);
					threadDisparo.insertarDisparo(disparo);					
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
		return grilla[x][y] != null;
<<<<<<< HEAD
=======
	}
	
	public Entidad getEntidad(int x, int y){
		Entidad ent = null;
		try{
			ent = grilla[x][y];
		}catch (ArrayIndexOutOfBoundsException e){
			ent = null;
		}
		return ent;
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
				Objeto a = (Objeto) creador.crear();
				a.setPosicion(fila, i);
				insertar(a);
				threadObjetos.insertarObjeto(a);
				break;
			}
			case "auto2" : {
				Objeto a = (Objeto) creador.crear();
				a.setPosicion(fila, i);
				insertar(a);
				threadObjetos.insertarObjeto(a);
				break;

            }
			case "auto3" : {
				Objeto a = (Objeto) creador.crear();
				a.setPosicion(fila, i);
				insertar(a);
				threadObjetos.insertarObjeto(a);
			}
			}
		}
>>>>>>> da9a54a68d57df2b0f9fa4cf32d110bfbe3c1226
	}

	/*
	 * Inserta una nueva entidad al juego.
	 */
	public void insertar(Entidad e){
		int x =(int) e.getPos().getX();
		int y =(int) e.getPos().getY();
		grilla[x][y] = e;
		gui.insertar(e.getLabel(),x*60,y*60);
	}
	
	/*
	 * Realiza la compra de un personaje y luego lo inserta en el mapa.
	 */
	public void comprarPersonaje(int x,int y) {
		Entidad nueva = shop.getProximo();
		if(nueva != null ) {
			monedas = monedas - shop.finalizarCompra();
			shop.quitarProximo();
			gui.updateContadores(puntaje, monedas);
			grilla[x][y] = nueva;
			nueva.setPosicion(x, y);
			gui.insertar(nueva.getLabel(), x*60, y*60);
			this.threadPersonaje.insertarPersonaje((Personaje) nueva);
			System.out.println("COMPRAR ::: cantidad de personajes en lista de personajes  "+threadPersonaje.getPersonajes().size());
		}
	}
	
	/*
	 * Realiza la compra de un objeto y luego lo inserta en el mapa.
	 */
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
	
	/*
	 * Consulta a la tienda si lo que se va a comprar es un personaje. 
	 */
	public boolean esPersonaje() {
		return shop.getEsPersonaje();
	}
	
	/*
	 * Consulta a la tienda si se inserto el personaje o objeto comprado.
	 */
	public boolean comprando(){
		return shop.getProximo() != null;
	}
	
	/*
	 * Elimina una entidad del juego.
	 */
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
	
	/*
	 * Detiene el juego para realizar una compra.
	 */
	public void detenerJuego() {
			threadDisparo.suspended();
			threadPersonaje.suspended();
			threadEnemigos.suspended();
			threadRango.suspended();			
	}
	/*
	 * Reanuda el juego luego de detenerlo para comprar.
	 */
	public void reanudarJuego() {
		threadDisparo.resumen();
		threadPersonaje.resumen();
		threadEnemigos.resumen();
		threadRango.resumen();
	}
}
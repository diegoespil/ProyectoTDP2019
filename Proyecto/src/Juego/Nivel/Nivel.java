package Juego.Nivel;

import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Objeto.Objeto;
import Juego.Juego;

public abstract class Nivel {
	
	protected Vector<Enemigo> enemigos;
	protected Vector<Objeto> objetos;
	protected Juego juego;
	protected int cantEnemigos;
	protected int cantObjetos;
	
	public Nivel(Juego j){
		juego = j;
		enemigos = new Vector<Enemigo>();
		objetos = new Vector<Objeto>();
		cargarNivel();
		System.out.println("Cantidad de enemigos: "+this.cantEnemigos);
	}
	
	public abstract Enemigo getEnemigo();
	
	public abstract Objeto getObjeto();
	
	public int cantEnemigos() {
		return cantEnemigos;
	}
	
	public int cantObjetos(){
		return cantObjetos;
	}
	
	public abstract void cargarNivel();
	
	public abstract Nivel subirNivel();
	
}

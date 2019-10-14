package Juego.Nivel;

import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;
import Juego.Juego;

public abstract class Nivel {
	
	protected Vector<Enemigo> enemigos;
	protected Juego juego;
	protected int cantEnemigos;
	
	public Nivel(Juego j){
		juego = j;
		enemigos = new Vector<Enemigo>();
		cargarNivel();
		System.out.println("Cantidad de enemigos: "+this.cantEnemigos);
	}
	
	public abstract Enemigo getEnemigo();
	
	public int cantEnemigos() {
		return cantEnemigos;
	}
	
	public abstract void cargarNivel();
	
	public abstract Nivel subirNivel();
	
}

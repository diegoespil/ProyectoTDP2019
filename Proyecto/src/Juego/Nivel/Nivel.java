package Juego.Nivel;

import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Objeto.Objeto;
import Juego.Juego;

public abstract class Nivel {
	
	protected Vector<Enemigo> oleada1;
	protected Vector<Enemigo> oleada2;
	protected Vector<Enemigo> oleada3;
	protected Vector<Objeto> objetos;
	protected Juego juego;
	
	public Nivel(Juego j){
		juego = j;
		oleada1 = new Vector<Enemigo>();
		oleada2 = new Vector<Enemigo>();
		oleada3 = new Vector<Enemigo>();
		objetos = new Vector<Objeto>();
		cargarNivel();
	}
	
	public Vector<Enemigo> getOleada1(){
		return this.oleada1;
	}
	
	public Vector<Enemigo> getOleada2(){
		return this.oleada2;
	}
	
	public Vector<Enemigo> getOleada3(){
		return this.oleada3;
	}
	
	public Vector<Objeto> getObjetos(){
		return this.objetos;
	}
	
	protected abstract void cargarNivel();
	
	public abstract Nivel subirNivel();
	
}

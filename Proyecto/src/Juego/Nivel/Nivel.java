package Juego.Nivel;

import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Objeto.Objeto;
import Juego.Juego;
import Juego.Oleada.Oleada;

public abstract class Nivel {
	
	protected Vector<Enemigo> enemigos;
	protected Vector<Objeto> objetos;
	protected Juego juego;
	protected Oleada oleada;
	
	public Nivel(Juego j){
		juego = j;
		enemigos = new Vector<Enemigo>();
		objetos = new Vector<Objeto>();
		oleada = null;
		cargarNivel();
	}
	
	public abstract Oleada getOleada(int cant);
	
	
	public Vector<Objeto> getObjetos(){
		return this.objetos;
	}
	
	protected abstract void cargarNivel();
	
	public abstract Nivel subirNivel();
	
}

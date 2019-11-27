package Juego.Oleada;

import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;

public abstract class Oleada {
	
	protected int cantidad_enemigos;
	protected Vector<Enemigo> enemigos;
	
	public Oleada (Vector<Enemigo> enemigos, int cant) {
		this.cantidad_enemigos = cant;
		this.enemigos = enemigos;
	}
	
	public abstract Oleada getSiguiente(Vector<Enemigo> enemigos,int cant);
	
	public abstract Vector<Enemigo> getEnemigos();
	
	public void setCantidad(int cant) {
		this.cantidad_enemigos=cant;
	}
}

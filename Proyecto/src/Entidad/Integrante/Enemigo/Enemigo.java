
package Entidad.Integrante.Enemigo;

import Entidad.Integrante.Integrante;
import Visitador.Visitor;
import Visitador.VisitorEnemigo;

public abstract class Enemigo extends Integrante {

	protected int velocidad,puntaje, monedas;
	
	
	public Enemigo(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x,y,danio,alcance,100);
		this.velocidad = velocidad;
		this.puntaje = puntaje;
		this.monedas = monedas;
		miVisitor = new VisitorEnemigo(this);
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public int getMonedas() {
		return monedas;
	}
	
	public void accept(Visitor v) {
		v.visitEnemigo(this);
	}
	
	
	

}



package Entidad.Integrante.Enemigo;

import java.util.Random;

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
/*	
	public int getDireccion() {
		Random r = new Random();			
		int dir = r.nextInt(3);
		return dir;
	}
*/	
	public void mover(int dir){	
		switch (dir) {
			case 0 :{ //Arriba
				setPosicion(pos.x,pos.y - 1);
				break;}
			case 1 :{ //Abajo
				setPosicion(pos.x,pos.y + 1);
				break;}
			case 2 :{ //Izquierda
				setPosicion(pos.x  - 1,pos.y);
				break;}
		}
	//	cambiarGrafico(dir);
	}
	
	public void accept(Visitor v) {
		v.visitEnemigo(this);
	}
	
	
	

}


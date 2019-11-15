
package Entidad.Integrante.Enemigo;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;
import Visitador.Visitor;
import Visitador.VisitorEnemigo;

public abstract class Enemigo extends Integrante {

	protected int velocidad,puntaje,monedas,contPasos;
	protected ObjetoTemporal powerUp;
	
	
	public Enemigo(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x,y,danio,alcance,100);
		this.velocidad = velocidad;
		this.puntaje = puntaje;
		this.monedas = monedas;
		miVisitor = new VisitorEnemigo(this); 
		powerUp = null;
		contPasos = 0;
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
	public int getContPasos(){
		return contPasos;
	}
	public void setContPasos(int i){
		contPasos = i;
	}
	public void accept(Visitor v) {
		v.visitEnemigo(this);
	}
	
	public void setPowerUp(ObjetoTemporal pwu) {
		powerUp = pwu;
	}
	

}


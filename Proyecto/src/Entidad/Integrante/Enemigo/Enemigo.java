package Entidad.Integrante.Enemigo;

import Entidad.Integrante.Integrante;

public abstract class Enemigo extends Integrante {

	protected int velocidad,puntaje;
	
	public Enemigo(int x, int y, int velocidad, int puntaje) {
		super(x,y);
		this.velocidad = velocidad;
		this.puntaje = puntaje;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	public void mover(int dir){	
		switch (dir) {
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - velocidad);
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + velocidad);
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - velocidad, pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + velocidad, pos.y);
				break;
		}
		cambiarGrafico(dir);
	}
}

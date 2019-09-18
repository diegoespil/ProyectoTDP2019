package Entidad.Integrantes.Enemigo;

import Entidad.Integrantes.Integrantes;

public abstract class Enemigo extends Integrantes {

	protected int velocidad;
	
	public Enemigo(int x, int y, int velocidad) {
		super(x,y);
		this.velocidad = velocidad;
	}
	
	public int getVelocidad() {
		return velocidad;
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

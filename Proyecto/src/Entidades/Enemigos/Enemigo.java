package Entidades.Enemigos;

import Entidades.Entidad;

public abstract class Enemigo extends Entidad {

	protected int damage,reach,points,speed;
	
	public Enemigo(int dmg, int rch, int pts, int speed, int x, int y) {
		super(speed, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void mover(int x, int y) {
		
	}

	public void atacar(Entidad entidad){
		
	}

}

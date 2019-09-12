package Entidades.Personajes;

import Entidades.Entidad;

public abstract class Personaje extends Entidad {

	protected int damage, reach, price, size;
	
	public Personaje(int dmg, int rch, int pri, int size, int x, int y) {
		super(x, y);
		
	}
	
	
}

package Entidad.Integrante.Personaje;

import Entidad.Integrante.Integrante;

public abstract class Personaje extends Integrante {
	
	protected int precio;
	
	public Personaje(int x, int y){
		super(x,y);
	}
	public Personaje(int x, int y, int dmg, int alc, int pre){
		super(x,y);
		//dato = dmg;
		//alcance = alc;
		precio = pre;
	}
	
	public int getPrecio() {
		return precio;
	}

}

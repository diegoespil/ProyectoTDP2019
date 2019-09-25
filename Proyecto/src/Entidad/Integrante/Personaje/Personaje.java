package Entidad.Integrante.Personaje;

import Entidad.Integrante.Integrante;

public abstract class Personaje extends Integrante {
	
	protected static int precio;
	
	
	public Personaje(int x, int y, int dmg, int alc, int pre){
		super(x,y,dmg,alc);
		precio = pre;
	}
	
	protected static int getPrecio() {
		return 0;
	}
	
	
	public abstract int getDanio();
	
	public abstract int getAlcance();

}


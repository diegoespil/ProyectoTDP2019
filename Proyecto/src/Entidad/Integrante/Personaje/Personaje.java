package Entidad.Integrante.Personaje;

import Entidad.Integrante.Integrante;

public abstract class Personaje extends Integrante {
	
	protected int vida;
	
	public Personaje(int x, int y, int dmg, int alc){
		super(x,y,dmg,alc);
		vida = 100;
	}
	
	public abstract int getDanio();
	
	public abstract int getAlcance();
	
	public abstract int getVida();

}


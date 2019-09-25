package Entidad.Integrante.Personaje;

import Entidad.Integrante.Integrante;

public abstract class Personaje extends Integrante {
	
	protected int vida;
	
	public Personaje(int x, int y, int dmg, int alc,int vida){
		super(x,y,dmg,alc);
		this.vida = vida;
	}
	
	public abstract int getDanio();
	
	public abstract int getAlcance();
	
	public abstract int getVida();

}


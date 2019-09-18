package Entidad.Integrantes.Personaje;

import Entidad.Integrantes.Integrantes;

public abstract class Personaje extends Integrantes {
	
	protected int daño, alcance, precio;
	
	public Personaje(int x, int y){
		super(x,y);
	}
	public Personaje(int x, int y, int dmg, int alc, int pre){
		super(x,y);
		daño = dmg;
		alcance = alc;
		precio = pre;
	}
	

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getAlcance() {
		return alcance;
	}

	public int getPrecio() {
		return precio;
	}

}

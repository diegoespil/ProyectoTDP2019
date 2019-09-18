package Entidad.Integrantes.Personaje;

import Entidad.Integrantes.Integrantes;

public abstract class Personaje extends Integrantes {
	
	protected int da�o, alcance, precio;
	
	public Personaje(int x, int y){
		super(x,y);
	}
	public Personaje(int x, int y, int dmg, int alc, int pre){
		super(x,y);
		da�o = dmg;
		alcance = alc;
		precio = pre;
	}
	

	public int getDa�o() {
		return da�o;
	}

	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}

	public int getAlcance() {
		return alcance;
	}

	public int getPrecio() {
		return precio;
	}

}

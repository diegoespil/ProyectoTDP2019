package Entidad.Integrante;

import Entidad.Entidad;

public abstract class Integrante extends Entidad{

	protected int danio, alcance;
	
	public Integrante(int x, int y, int d, int a) {
		super(x,y);
		danio=d;
		alcance=a;
	}
	
	public int getDanio() {
		return danio;
	}
	
	public void setDanio(int danio) {
		this.danio = danio;
	}
	
	public int getAlcance() {
		return alcance;
	}
}
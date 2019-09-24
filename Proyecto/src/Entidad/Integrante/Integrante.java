package Entidad.Integrante;

import Entidad.Entidad;

public abstract class Integrante extends Entidad{

	protected int dato, alcance;
	
	public Integrante(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Integrante(int x, int y, int d, int a) {
		super(x,y);
		dato=d;
		alcance=a;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public int getAlcance() {
		return alcance;
	}


	


}

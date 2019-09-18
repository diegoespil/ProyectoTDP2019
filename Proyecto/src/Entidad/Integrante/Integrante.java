package Entidad.Integrante;

import Entidad.Entidad;

public abstract class Integrante extends Entidad{

	protected int daño, alcance;
	
	public Integrante(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Integrante(int x, int y, int d, int a) {
		super(x,y);
		daño=d;
		alcance=a;
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


	


}

package Entidad.Integrante;

import Entidad.Entidad;

public abstract class Integrante extends Entidad{

	protected int da�o, alcance;
	
	public Integrante(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Integrante(int x, int y, int d, int a) {
		super(x,y);
		da�o=d;
		alcance=a;
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


	


}

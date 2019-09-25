package Entidad.Integrante;

import Entidad.Entidad;

public abstract class Integrante extends Entidad{

	protected int danio, alcance;
	protected boolean muerto;
	
	
	public Integrante(int x, int y, int d, int a) {
		super(x,y);
		danio=d;
		alcance=a;
		this.muerto =false;
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

	public boolean estaMuerto(){
		return this.muerto;
	}
	
	public void setMuerto() {
		this.muerto = true;
	}
<<<<<<< HEAD

}

=======
}
>>>>>>> 955fe1835417d987ba7ab704e9d0907d8b68e2d5

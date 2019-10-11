package Entidad.Integrante;

import Entidad.Entidad;

public abstract class Integrante extends Entidad{

	protected int danio, alcance;
	protected boolean muerto;
	
	
	public Integrante(int x, int y, int d, int a, int vida) {
		super(x,y,vida);
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

	public void afectar(Entidad e) {}
	
	public void atacar(Entidad e) {
		e.setVida(e.getVida()-danio);
	}
	
}

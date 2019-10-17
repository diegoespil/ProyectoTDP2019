package Entidad.Disparo;

import Entidad.Entidad;


public abstract class Disparo extends Entidad {

	protected int danio,velocidad;

	public Disparo(int x, int y, int danio,int velocidad) {
		super(x, y,Integer.MAX_VALUE);
		this.danio = danio ;
		this.velocidad = velocidad;
	}
	
	public void atacar(Entidad e) { }
	
	public void afectar(Entidad e) {
		e.setVida(e.getVida()-danio);	
	}


}

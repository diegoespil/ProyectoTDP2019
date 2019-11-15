package Entidad.Disparo;

import Entidad.Entidad;


public abstract class Disparo extends Entidad {

	protected int danio,velocidad,contPasos;
	protected boolean llego;
	protected int mueve;

	public Disparo(int x, int y, int danio,int velocidad,int dir) {
		super(x, y,Integer.MAX_VALUE);
		this.danio = danio ;
		this.velocidad = velocidad;
		llego = false;
		mueve = dir;
		contPasos = 0;
	}
	
	public boolean llego(){
		return llego;
	}
	public void setLlego(boolean l){
		llego = l;
	}
	public int getContPasos(){
		return contPasos;
	}
	public void setContPasos(int i){
		contPasos = i;
	}
	public void atacar(Entidad e) { }
	
	public void afectar(Entidad e) {
		e.setVida(e.getVida()-danio);
		llego = true;
	}
	
	public int getMovimiento() {
		return mueve;
	}


}

package Entidad.Integrante;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.State.State;

public abstract class Integrante extends Entidad{

	protected int danio, alcance;
	protected State estado;
	protected Disparo miDisparo;
	
	public Integrante(int x, int y, int d, int a, int vida) {
		super(x,y,vida);
		danio=d;
		alcance=a;
		estado=null;
		miDisparo = null;
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
	
	public State getEstado(){
		return estado;
	}
	
	public void setEstado(State s){
		estado = s;
	}
	
	public Disparo getDisparo(){
		return miDisparo;
	}
	

	public void afectar(Entidad e) {}
	
	public void atacar(Entidad e) {
		e.setVida(e.getVida()-danio);
	}
	
}

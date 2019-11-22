package Entidad.Integrante;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.State.Ataque;
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

	public Disparo getDisparo(){
		return miDisparo;
	}
	

	public void afectar(Entidad e) {}
	
	public void atacar(Entidad e) {
		setState(new Ataque(this));
		getState().disparar();
		e.setVida(e.getVida()-danio);
	}
	
	public State getState() {
		return estado;
	}
	
	public void setState(State s) {
		estado = s;
	}
	
}

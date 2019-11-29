package Entidad.Integrante;

import java.awt.Color;

import javax.swing.BorderFactory;

import Entidad.Entidad;
import Entidad.Disparo.Disparo;
import Entidad.Integrante.State.Ataque;
import Entidad.Integrante.State.State;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public abstract class Integrante extends Entidad{

	protected int danio, alcance;
	protected State estado;
	protected Disparo miDisparo;
	protected ObjetoTemporal powerup;
	
	public Integrante(int x, int y, int d, int a, int vida) {
		super(x,y,vida);
		danio=d;
		alcance=a;
		estado=null;
		miDisparo = null;
		powerup = null;
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

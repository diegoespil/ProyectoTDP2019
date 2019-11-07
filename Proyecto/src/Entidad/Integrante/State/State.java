package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;

public abstract class State {
	
	protected Integrante integrante;
	
	public State(Integrante i) {
		integrante = i;
	}
	
	public abstract void activarPowerup();
		
	public abstract void mover();

	public abstract void disparar();
	
	public abstract void detener();
	
}

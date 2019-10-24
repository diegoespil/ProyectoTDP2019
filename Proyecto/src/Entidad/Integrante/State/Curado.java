package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class Curado implements State{

	protected Integrante integrante;
	
	public Curado(Integrante i){
		integrante = i;
	}

	public void asignarPowerup() {
		if (integrante.getVida()<=75){
			integrante.setVida(integrante.getVida()+25);
		}
	}

	public void quitarPowerup() {
	}
	
}

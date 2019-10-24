package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class AtaqueDuplicado implements State{

	protected Integrante integrante;
	protected int danioAux;
	
	public AtaqueDuplicado(Integrante i){
		integrante = i;
		danioAux = integrante.getDanio();
	}

	public void asignarPowerup() {
		integrante.setDanio(danioAux*2);
	}

	public void quitarPowerup() {
		integrante.setDanio(danioAux);
	}
	
}

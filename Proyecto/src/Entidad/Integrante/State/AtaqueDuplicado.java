package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class AtaqueDuplicado extends State{

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

	@Override
	public void activarPowerup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detener() {
		// TODO Auto-generated method stub
		
	}
	
}
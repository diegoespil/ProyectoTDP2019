package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;


public class PowerUp extends State{

	public PowerUp(Integrante i) {
		super(i);
	}

	public void activarPowerup(ObjetoTemporal pwu) {
	}

	public void mover() {}

	public void disparar() {}

	public void detener() {}

}

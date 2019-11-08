package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class Normal extends State {

	public Normal(Integrante i) {
		super(i);
	}

	public void activarPowerup() {}

	public void mover() {
		integrante.cambiarEstado(0);
	}

	public void disparar() {}

	public void detener() {}

	public void activarPowerup(ObjetoTemporal pwu) {}

}

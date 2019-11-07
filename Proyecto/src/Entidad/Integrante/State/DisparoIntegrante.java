package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;

public class DisparoIntegrante extends State {

	public DisparoIntegrante(Integrante i) {
		super(i);
	}


	public void activarPowerup() { }

	public void mover() { }

	public void disparar() {
		integrante.cambiarEstado(1);
	}

	public void detener() {}

}

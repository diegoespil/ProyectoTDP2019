package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class Ataque extends State {

	public Ataque(Integrante i) {
		super(i);
	}

	public void mover() { }

	public void disparar() {
		integrante.cambiarEstado(1);
	}

	public void detener() {}
	
	public void activarPowerup(ObjetoTemporal pwu) {}

}

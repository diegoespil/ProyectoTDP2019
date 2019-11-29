package PowerUp;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class Curado extends PowerUp{

	protected Integrante integrante;
	
	public Curado(Integrante i){
		super(i);
	}

	public void activarPowerup(ObjetoTemporal pwu) {
		if (integrante.getVida()<=75){
			integrante.setVida(integrante.getVida()+25);
		}
		integrante.changeState(null);
	}
}

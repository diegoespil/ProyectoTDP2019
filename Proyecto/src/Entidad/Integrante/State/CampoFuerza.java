package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class CampoFuerza extends PowerUp  {

	public CampoFuerza(Integrante i)  {
		super(i);
	}
	
	public void activarPowerup(ObjetoTemporal pwu) {
		int vidaAnterior = integrante.getVida();
		integrante.setVida(Integer.MAX_VALUE);
		integrante.cambiarEstado(3);
		 try {
	            Thread.sleep(5*1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
		integrante.setVida(vidaAnterior);
		integrante.cambiarEstado(0);
		integrante.changeState(null);;
	}

}

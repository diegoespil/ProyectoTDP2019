package Entidad.Integrante.State;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class AtaqueDuplicado extends PowerUp{
	
	public AtaqueDuplicado(Integrante i) {
		super(i);
	}
	
	public void activarPowerup(ObjetoTemporal pwu) {
		int danioAnterior = integrante.getDanio();
		integrante.setDanio(danioAnterior*2);
		integrante.cambiarEstado(3);
		 try {
	            Thread.sleep(5*1000);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
		integrante.setDanio(danioAnterior);
		integrante.cambiarEstado(0);
		integrante.setState(new Normal(integrante));
		
	}
	
	
}
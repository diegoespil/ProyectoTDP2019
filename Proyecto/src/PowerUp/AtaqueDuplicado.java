package PowerUp;

import java.awt.Color;

import javax.swing.BorderFactory;

import Entidad.Integrante.Integrante;
import Entidad.Integrante.State.Normal;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class AtaqueDuplicado extends PowerUp{
	
	protected int danioAnterior;
	
	public AtaqueDuplicado(Integrante i, int d) {
		super(i,d);
		danioAnterior = integrante.getDanio();
	}
	
	public void run(){
		desactivar();
	}
	
	public void activar() {		
		integrante.setDanio(danioAnterior*2);
		integrante.cambiarEstado(3);
		integrante.getLabel().setBorder(BorderFactory.createEtchedBorder(Color.GREEN, Color.GREEN));
	}
	public void desactivar(){
		integrante.setDanio(danioAnterior);
		integrante.cambiarEstado(0);
		integrante.setState(new Normal(integrante));		
		integrante.getLabel().setBorder(null);
	}
	
	
}
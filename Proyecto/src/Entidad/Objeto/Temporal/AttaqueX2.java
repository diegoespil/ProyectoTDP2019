package Entidad.Objeto.Temporal;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import Entidad.Entidad;
import Entidad.Integrante.Integrante;
import Entidad.Integrante.State.AtaqueDuplicado;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class AttaqueX2 extends ObjetoTemporal {
	
	public AttaqueX2(int x, int y, int tiempo){
		super(x,y,tiempo);
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(this.getImage(0));
		label.setVisible(true);
		label.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		this.setLabel(label);
	}

	public void afectar(Entidad e) { }
	
	public void activar(Integrante i) {
		i.setState(new AtaqueDuplicado(i));
		i.getState().activarPowerup(this);
	}

}

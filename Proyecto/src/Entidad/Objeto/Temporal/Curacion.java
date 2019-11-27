package Entidad.Objeto.Temporal;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import Entidad.Entidad;

public class Curacion extends ObjetoTemporal {

	public Curacion(int x,int y,int tiempo) {
		super(x,y,tiempo);
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(this.getImage(0));
		label.setVisible(true);
		label.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		this.setLabel(label);
	}
	
	public void afectar(Entidad e) {
		
	}


}

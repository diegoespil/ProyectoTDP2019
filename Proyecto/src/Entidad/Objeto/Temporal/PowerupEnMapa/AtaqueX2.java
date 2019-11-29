package Entidad.Objeto.Temporal.PowerupEnMapa;

import java.awt.Color;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import Entidad.Integrante.Integrante;
import PowerUp.AtaqueDuplicado;
import PowerUp.PowerUp;

public class AtaqueX2 extends PowerupEnMapa {
	
	public AtaqueX2(int x, int y, int tiempo){
		super(x,y,tiempo);
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(this.getImage(0));
		label.setVisible(true);
		label.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		this.setLabel(label);
	}
	
	public void activar(Integrante i) {
		Timer t = new Timer();
		PowerUp atqx2 = new AtaqueDuplicado(i,5);
		int duracion_ms = atqx2.getDuracion()*1000;
		atqx2.activar();
		t.schedule(atqx2, duracion_ms);
	}

}

package Entidad.Integrante.Enemigo;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Rata extends Enemigo{

	public Rata(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x, y, velocidad, danio, alcance, puntaje,monedas);
		this.image[0] = new ImageIcon("Imagenes/rata_normal.gif");
		this.image[1] = new ImageIcon("Imagenes/rata_ataque.gif");
		this.image[2] = new ImageIcon("Imagenes/rata_muerto.gif");
		this.image[3] = new ImageIcon("Imagenes/rata_quemado.gif");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(this.getImage(0));
		label.setVisible(true);
		label.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		this.setLabel(label);
	}
	
}


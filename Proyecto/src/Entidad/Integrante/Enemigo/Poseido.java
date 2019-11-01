package Entidad.Integrante.Enemigo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Poseido extends Enemigo {

	public Poseido(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x, y, velocidad, danio, alcance, puntaje, monedas);
		ImageIcon img = new ImageIcon("Imagenes/poseido_caminar.gif");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(new ImageIcon(img.getImage()));
		label.setVisible(true);
		this.setLabel(label);
	//	this.image[0] = new ImageIcon("Imagenes/malo1_up.png");
	//	this.image[1] = new ImageIcon("Imagenes/malo1_down.png");
	//	this.image[2] = new ImageIcon("Imagenes/malo_izq.png");
	}

}


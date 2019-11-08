package Entidad.Integrante.Enemigo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Perro extends Enemigo{

	public Perro(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x, y, velocidad, danio, alcance, puntaje,monedas);
		this.image[0] = new ImageIcon("Imagenes/perro_mover.gif");
		this.image[1] = new ImageIcon("Imagenes/perro_disparo.gif");
		this.image[2] = new ImageIcon("Imagenes/perro_muerto.gif");
		this.image[3] = new ImageIcon("Imagenes/perro_quemado.gif");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(this.getImage(0));
		label.setVisible(true);
		this.setLabel(label);
	}

}

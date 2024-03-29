package Entidad.Integrante.Enemigo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Entidad;
import Entidad.Disparo.DisparoEnemigo;
import Entidad.Objeto.Temporal.ObjetoTemporal;

public class Ruso extends Enemigo {

	public Ruso(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x, y, velocidad, danio, alcance, puntaje,monedas);
		this.image[0] = new ImageIcon("Imagenes/ruso_mover.gif");
		this.image[1] = new ImageIcon("Imagenes/ruso_disparo.gif");
		this.image[2] = new ImageIcon("Imagenes/ruso_muerto.gif");
		this.image[3] = new ImageIcon("Imagenes/ruso_quemado.gif");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(this.getImage(0));
		label.setVisible(true);
		this.setLabel(label);
	}
	
	public void atacar(Entidad e) {
		miDisparo = new DisparoEnemigo(pos.x,pos.y,danio,1);
	}

}

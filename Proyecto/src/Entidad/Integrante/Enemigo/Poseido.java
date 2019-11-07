package Entidad.Integrante.Enemigo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Entidad;
import Entidad.Disparo.DisparoEnemigo;

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
	
	public void atacar(Entidad e){
		miDisparo = new DisparoEnemigo(pos.x,pos.y-1,danio,1);
		System.out.println("cree disparo "+miDisparo);
	}

}


package Entidad.Integrante.Personaje;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Entidad;
import Entidad.Disparo.DisparoPersonaje;

public class Hopper extends Personaje {

	protected final static int precio = 100;
	
	public Hopper(int x, int y, int dmg, int alc) {
		super(x, y, dmg, alc);
		this.image[0] = new ImageIcon("Imagenes/hopper_normal.gif");
		this.image[1] = new ImageIcon("Imagenes/hopper_ataque.gif");
		this.image[2] = new ImageIcon("Imagenes/hopper_muerto.gif");
		this.image[3] = new ImageIcon("Imagenes/hopper_campo.gif");
		this.image[4] = new ImageIcon("Imagenes/hopper_ataque.gif");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(this.getImage(0));
		label.setVisible(true);
		label.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		this.setLabel(label);
	}
	
	public static int getPrecio() {
		return precio;
	}
	
	public int getDanio() {
		return danio;
	}
	
	public int getAlcance() {
		return alcance;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void atacar(Entidad e) {
		miDisparo = new DisparoPersonaje(pos.x,pos.y,danio,1);
	}
	

}

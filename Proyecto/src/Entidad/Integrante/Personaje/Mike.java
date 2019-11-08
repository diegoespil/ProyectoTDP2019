package Entidad.Integrante.Personaje;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mike extends Personaje {

	protected final static int precio = 70;
	
	public Mike(int x, int y,int danio, int alcance) {
		super(x,y,danio,alcance);
		this.image[0] = new ImageIcon("Imagenes/mike_normal.gif");
		this.image[1] = new ImageIcon("Imagenes/mike_ataque.gif");
		this.image[2] = new ImageIcon("Imagenes/mike_muerto.gif");
		this.image[3] = new ImageIcon("Imagenes/mike_campo.gif");
		this.image[4] = new ImageIcon("Imagenes/mike_ataquex2.gif");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(this.getImage(0));
		label.setVisible(true);
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
	
}

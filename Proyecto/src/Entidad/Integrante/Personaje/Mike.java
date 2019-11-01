package Entidad.Integrante.Personaje;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mike extends Personaje {

	protected final static int precio = 70;
	
	public Mike(int x, int y,int danio, int alcance) {
		super(x,y,danio,alcance);
		ImageIcon img = new ImageIcon("Imagenes/mike.gif");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(new ImageIcon(img.getImage()));
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

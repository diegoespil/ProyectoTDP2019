package Entidad.Integrante.Personaje;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dustin extends Personaje {
	
	protected final static int precio = 50;

	public Dustin(int x, int y, int dmg, int alc) {
		super(x, y, dmg, alc);
		ImageIcon img = new ImageIcon("Imagenes/dustin.png");
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

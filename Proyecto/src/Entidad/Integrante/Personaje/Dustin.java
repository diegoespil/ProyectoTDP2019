package Entidad.Integrante.Personaje;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dustin extends Personaje {
	
	protected final static int precio = 50;

	public Dustin(int x, int y, int dmg, int alc) {
		super(x, y, dmg, alc);
		this.image[0] = new ImageIcon("Imagenes/dustin_normal.gif");
		this.image[1] = new ImageIcon("Imagenes/dustin_ataque.gif");
		this.image[2] = new ImageIcon("Imagenes/dustin_muerto.gif");
		this.image[3] = new ImageIcon("Imagenes/dustin_campo.gif");
		this.image[4] = new ImageIcon("Imagenes/dustin_ataquex2.gif");
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

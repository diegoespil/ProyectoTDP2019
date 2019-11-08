package Entidad.Integrante.Personaje;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Disparo.Disparo;
import Entidad.Disparo.DisparoPersonaje;

public class Lucas extends Personaje {

	protected final static int precio = 70;
	
	public Lucas(int x, int y, int dmg, int alc) {
		super(x, y, dmg, alc);
		this.image[0] = new ImageIcon("Imagenes/lucas_normal.gif");
		this.image[1] = new ImageIcon("Imagenes/lucas_ataque.gif");
		this.image[2] = new ImageIcon("Imagenes/lucas_muerto.gif");
		this.image[3] = new ImageIcon("Imagenes/lucas_campo.gif");
		this.image[4] = new ImageIcon("Imagenes/lucas_ataque.gif");
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
	
	public void atacar() {
		miDisparo = new DisparoPersonaje(pos.x,pos.y+1,danio,1);
		;
	}

}

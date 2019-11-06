package Entidad.Integrante.Personaje;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Entidad;
import Entidad.Disparo.DisparoPersonaje;

public class Hopper extends Personaje {

	protected final static int precio = 100;
	
	public Hopper(int x, int y, int dmg, int alc) {
		super(x, y, dmg, alc);
		ImageIcon img = new ImageIcon("Imagenes/hopper.png");
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
	
	public void atacar(Entidad e) {
		miDisparo = new DisparoPersonaje(pos.x,pos.y+1,danio,1);
	}
	

}

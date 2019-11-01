package Entidad.Integrante.Personaje;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Disparo.Disparo;
import Entidad.Disparo.DisparoPersonaje;

public class Lucas extends Personaje {

	protected final static int precio = 70;
	
	public Lucas(int x, int y, int dmg, int alc) {
		super(x, y, dmg, alc);
		ImageIcon img = new ImageIcon("Imagenes/lucas.png");
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
	
	public void atacar() {
		miDisparo = new DisparoPersonaje(pos.x,pos.y+1,danio,1);
		;
	}

}

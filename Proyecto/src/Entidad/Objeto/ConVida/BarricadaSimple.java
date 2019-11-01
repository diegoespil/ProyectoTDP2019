package Entidad.Objeto.ConVida;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BarricadaSimple extends ObjetoConVida{

	protected final static int precio = 30;
	
	public BarricadaSimple(int x, int y,int vida) {
		super(x, y,vida);
		ImageIcon img = new ImageIcon("Imagenes//barricada1.png");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(new ImageIcon(img.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		label.setVisible(true);
		this.setLabel(label);
	}

	public static int getPrecio() {
		return precio;
	}
	
	public int getVida() {
		return vida;
	}
}

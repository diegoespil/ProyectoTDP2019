package Entidad.Objeto.Temporal;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidad.Entidad;

public class Portal extends ObjetoTemporal{

	protected final static int precio = 100;
	
	public Portal(int x, int y,int tiempo) {
		super(x, y,tiempo);
		ImageIcon img = new ImageIcon("Imagenes//portal.png");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 60, 60);
		label.setIcon(new ImageIcon(img.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		label.setVisible(true);
		this.setLabel(label);
	}
	
	public static int getPrecio() {
		return precio;
	}

	@Override
	public void afectar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}

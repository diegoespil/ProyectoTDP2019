package Entidad.Disparo;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitador.Visitor;
import Visitador.VisitorDisparoPersonaje;
import Visitador.VisitorEnemigo;

public class DisparoPersonaje extends Disparo {

	public DisparoPersonaje(int x, int y, int danio,int velocidad) {
		super(x, y,danio,velocidad);	
		//ImageIcon img = new ImageIcon("Imagenes/poseido_caminar.gif");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 10, 5);
		//label.setIcon(new ImageIcon(img.getImage()));
		label.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.RED));
		label.setVisible(true);
		label.setVisible(true);
		this.setLabel(label);
		miVisitor = new VisitorDisparoPersonaje(this);
	}

	public void accept(Visitor v) {
		v.visitDisparoPersonaje(this);
	}
}

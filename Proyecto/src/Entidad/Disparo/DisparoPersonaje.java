package Entidad.Disparo;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import Visitador.Visitor;
import Visitador.VisitorDisparoPersonaje;

public class DisparoPersonaje extends Disparo {

	public DisparoPersonaje(int x, int y, int danio,int velocidad) {
		super(x, y,danio,velocidad,1);	
		JLabel label = new JLabel();
		label.setBounds(0, 0, 10, 5);
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

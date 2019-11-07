package Entidad.Disparo;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import Visitador.Visitor;
import Visitador.VisitorDisparoEnemigo;
import Visitador.VisitorDisparoPersonaje;

public class DisparoEnemigo extends Disparo {
	
	public DisparoEnemigo(int x, int y, int danio,int velocidad) {
		super(x, y,danio,velocidad,-1);
		miVisitor = new VisitorDisparoEnemigo(this);
		JLabel label = new JLabel();
		label.setBounds(0, 0, 10, 5);
		label.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.RED));
		label.setVisible(true);
		label.setVisible(true);
		this.setLabel(label);
		miVisitor = new VisitorDisparoEnemigo(this);
	}

	public void accept(Visitor v) {
		v.visitDisparoEnemigo(this);
	}
	
}

package Entidad;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Entidad {
	
	protected String nombre;
	protected int vida;
	protected JLabel grafico;
	protected Icon image [];
	protected int velocidad;
	protected Point pos;
	
	
	public Entidad(int x, int y, int velocidad) {
		this.pos = new Point(x,y);
		this.velocidad = velocidad;
		image = new Icon[4];
	}
	
}

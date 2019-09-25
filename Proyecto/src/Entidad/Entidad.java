package Entidad;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Entidad {
	
	protected String nombre;
	protected int vida;
	protected ImageIcon grafico;
	protected ImageIcon image [];
	protected Point pos;
	protected final int width = 60;
	protected final int height = 60;
	
	public Entidad(int x, int y) {
		this.pos = new Point(x,y);
		image = new ImageIcon[4];
	}

	public Point getPos() {
		return pos;
	}
	
	public void setPosicion(int x, int y) {
		this.pos.x = x;
		this.pos.y = y;
	}
	
	protected void cambiarGrafico(int dir){
		if(this.grafico != null){
			this.grafico.setImage(this.image[dir].getImage());
		}
	}
	
	public ImageIcon getGrafico(int dir) {		
		return this.image[dir];
	}
}


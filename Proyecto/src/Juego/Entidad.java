package Entidades;

import java.awt.Point;

import javax.swing.JLabel;

public abstract class Entidad {

	protected int life;
	protected JLabel image;
	protected Point position;
	
	public Entidad(int life, int x, int y) {
		this.position = new Point(x,y);
		this.life = life;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public Point getPosition() {
		return this.position; 
	}
	
	public JLabel getImage() {
		return this.image;
	}
	
	public abstract void setLife(int life);
	
	public abstract void setImage(JLabel image);
	
	

}

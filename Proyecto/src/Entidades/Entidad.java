package Entidades;

import java.awt.Point;

import javax.swing.JLabel;

public abstract class Entidad {

	protected int life;
	protected JLabel image;
	protected int speed;
	protected Point position;
	
	public Entidad(int speed, int x, int y) {
		this.position = new Point(x,y);
		this.speed = speed;
		this.life = 100;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public Point getPosition() {
		return this.position; 
	}
	
	public JLabel getImage() {
		return this.image;
	}
	
	public abstract void setLife(int life);
	
	public abstract void setImage(JLabel image);
	
	public abstract void atacar(Entidad entidad);
	
	public void mover(int x, int y) {
		
	}
}

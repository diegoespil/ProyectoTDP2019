package Entidad;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitador.Visitor;

public abstract class Entidad {
	
	protected String nombre;
	protected ImageIcon [] image;
	protected JLabel label;
	protected Point pos;
	protected final int width = 60;
	protected final int height = 60;
	protected Visitor miVisitor;
	protected int vida;
	
	public Entidad(int x, int y, int vida){
		this.pos = new Point(x,y);
		miVisitor = null;
		this.vida = vida; 
		image = new ImageIcon[5];
		label = null;
	}

	public Point getPos() {
		return pos;
	}
	
	public void setPosicion(int x, int y) {
		pos.move(x, y);
	}
	
	public ImageIcon getImage(int estado) {
		return image[estado];
	}


	public void setImage(ImageIcon i,int estado) {
		image[estado] = i ;
	}
	
	public void cambiarEstado(int estado) {
		label.setIcon(image[estado]);
	}
	
	public JLabel getLabel(){
		return label;
	}
	
	public void setLabel(JLabel l) {
		label = l;
	}
	
	public abstract void accept(Visitor v);
	
	public abstract void atacar(Entidad e);
	
	public abstract void afectar(Entidad e);
	
	public int getVida() {
		return vida;
	}
	 
	public void setVida(int v) {
		vida = v;
	}
	
	public Visitor getVisitor() {
		return miVisitor;
	}
	
}


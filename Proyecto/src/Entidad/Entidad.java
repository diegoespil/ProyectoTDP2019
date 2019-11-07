package Entidad;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitador.Visitor;

public abstract class Entidad {
	
	protected String nombre;
	protected ImageIcon image;
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
		image = null;
		label = null;
	}

	public Point getPos() {
		return pos;
	}
	
	public void setPosicion(int x, int y) {
		//this.pos.x = x;
		//this.pos.y = y;
		pos.move(x, y);
	}
/*	
	protected ImageIcon cambiarGrafico(int dir){
		if(this.grafico != null){
			this.grafico.setImage(this.image[dir].getImage());
		}
		return this.grafico;
	}
	*/
	public ImageIcon getImage() {		
		return this.image;
	}
	
	public void setImage(String ruta) {
		image = new ImageIcon(ruta);
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


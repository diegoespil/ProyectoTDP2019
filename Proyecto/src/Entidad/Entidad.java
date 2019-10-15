package Entidad;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitador.Visitor;

public abstract class Entidad {
	
	protected String nombre;
	protected ImageIcon grafico;
	protected ImageIcon image [];
//	protected JLabel grafico;
//	protected Icon images [];
	protected Point pos;
	protected final int width = 60;
	protected final int height = 60;
	protected Visitor miVisitor;
	protected int vida;
	
	public Entidad(int x, int y, int vida){
		this.pos = new Point(x,y);
		image = new ImageIcon[4];
//		images = new Icon[4];
		miVisitor = null;
		this.vida = vida; 
	}

	public Point getPos() {
		return pos;
	}
	
	public void setPosicion(int x, int y) {
		this.pos.x = x;
		this.pos.y = y;
	}
	
	protected ImageIcon cambiarGrafico(int dir){
		if(this.grafico != null){
			this.grafico.setImage(this.image[dir].getImage());
//	public JLabel getGrafico() {
//		if(this.grafico == null){
//			this.grafico = new JLabel(this.images[0]);
//			this.grafico.setBounds(this.pos.x, this.pos.y, this.width, this.height);
		}
		return this.grafico;
	}
	
	public ImageIcon getGrafico(int dir) {		
		return this.image[dir];
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
}


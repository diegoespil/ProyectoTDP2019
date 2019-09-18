package Entidad;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Entidad {
	
	protected String nombre;
	protected int vida;
	protected JLabel grafico;
	protected Icon image [];
	protected Point pos;
	protected final int width = 60;
	protected final int height = 60;
	
	public Entidad(int x, int y) {
		this.pos = new Point(x,y);
		
		image = new Icon[4];
	}

	public Point getPos() {
		return pos;
	}
	
	protected void cambiarGrafico(int dir){
		if(this.grafico != null){
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}

	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}
}

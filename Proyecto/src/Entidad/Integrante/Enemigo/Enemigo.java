
package Entidad.Integrante.Enemigo;

import java.util.Random;

import Entidad.Integrante.Integrante;
import Visitador.Visitor;

public abstract class Enemigo extends Integrante {

	protected int velocidad,puntaje, monedas;
	
	
	public Enemigo(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x,y,danio,alcance,100);
		this.velocidad = velocidad;
		this.puntaje = puntaje;
		this.monedas = monedas;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public abstract int getPuntaje();
	
	public abstract int getMonedas();
	
	public int getDireccion() {
		Random r = new Random();			
		int dir = r.nextInt(3);
		return dir;
	}
	
	public void mover(int dir){	
		System.out.println("Posicion: "+pos.x+" "+pos.y);
		System.out.println("Enemigo mover");
		switch (dir) {
			case 0 : //Arriba
			{	System.out.println("Arriba");
				setPosicion(pos.x,pos.y - 1);
				break;}
			case 1 :{ //Abajo
				System.out.println("Abajo");
				setPosicion(pos.x,pos.y + 1);
				break;}
			case 2 :{ //Izquierda
				System.out.println("Izquierda");
				setPosicion(pos.x  - 1,pos.y);
				//pos.setLocation(pos.x-1, pos.y);
				break;}
		}
		cambiarGrafico(dir);
		System.out.println("Posicion: x:"+pos.x+" y:"+pos.y);
//		if(this.grafico != null){
//			this.grafico.setIcon(this.images[dir]);
//			this.grafico.setBounds(this.pos.x, this.pos.y, this.images[dir].getIconWidth(), this.images[dir].getIconHeight());
//		}
	}
	
	public void accept(Visitor v) {
		v.visitEnemigo(this);
	}
	

}


package Entidad.Integrante.Enemigo;

import javax.swing.ImageIcon;

public class Poseido extends Enemigo {

	public Poseido(int x, int y, int velocidad, int danio, int alcance, int puntaje, int monedas) {
		super(x, y, velocidad, danio, alcance, puntaje, monedas);
		this.image[0] = new ImageIcon("Imagenes/malo1_up.png");
		this.image[1] = new ImageIcon("Imagenes/malo1_down.png");
		this.image[2] = new ImageIcon("Imagenes/malo1_izq.png");
		this.image[3] = new ImageIcon("Imagenes/malo1_der.png");
	}

	public int getPuntaje() {
		return this.puntaje;
	}
	
	public int getMonedas() {
		return this.monedas;
	}
}


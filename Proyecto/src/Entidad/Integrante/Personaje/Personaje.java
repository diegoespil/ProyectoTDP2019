package Entidad.Integrante.Personaje;

import Entidad.Integrante.Integrante;
import Visitador.Visitor;

public abstract class Personaje extends Integrante {
	
	public Personaje(int x, int y, int dmg, int alc){
		super(x,y,dmg,alc,100);
		
	}
	
	public void accept(Visitor v) {
		v.visitPersonaje(this);
	}
	
	

}


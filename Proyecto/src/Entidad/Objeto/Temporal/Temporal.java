package Entidad.Objeto.Temporal;

import Entidad.Objeto.Objeto;

public abstract class Temporal extends Objeto {

	protected int tiempo; //segundos que dura
	
	public Temporal(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public Temporal(int x, int y, int t){
		super(x,y);
		tiempo = t;
	}
	
	public int getTiempo(){
		return tiempo;
	}
	

}

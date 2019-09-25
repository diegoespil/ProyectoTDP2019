package Entidad.Objeto.Temporal;

import Entidad.Objeto.Objeto;

public abstract class ObjetoTemporal extends Objeto {

	protected int tiempo; //segundos que dura
	
	public ObjetoTemporal(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public ObjetoTemporal(int x, int y, int t){
		super(x,y);
		tiempo = t;
	}
	
	public int getTiempo(){
		return tiempo;
	}
	

}

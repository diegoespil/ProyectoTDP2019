package Entidad.Objeto.Temporal;

import Entidad.Objeto.Objeto;
import Visitador.Visitor;

public abstract class ObjetoTemporal extends Objeto {

	protected int tiempo; 
	
	public ObjetoTemporal(int x, int y,int tiempo) {
		super(x, y,Integer.MAX_VALUE);
		this.tiempo = tiempo;
	}
	
	public int getTiempo(){
		return tiempo;
	}
	
	public void accept(Visitor v) {
		v.visitObjetosTemporal(this);
	}
	

}

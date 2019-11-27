package Entidad.Objeto.Temporal;

import Entidad.Integrante.Integrante;
import Entidad.Objeto.Objeto;
import Visitador.Visitor;

public abstract class ObjetoTemporal extends Objeto {

	protected int tiempo;
	protected boolean asignado;
	
	public ObjetoTemporal(int x, int y,int tiempo) {
		super(x, y,Integer.MAX_VALUE);
		this.tiempo = tiempo;
		asignado = false;
	}
	
	public int getTiempo(){
		return tiempo;
	}
	
	public void accept(Visitor v) {
		v.visitObjetosTemporal(this);
	}
	
	public boolean getAsignado() {
		return asignado;
	}
	
	public void setAsignado(boolean a) {
		asignado = a;
	}

	public abstract void activar(Integrante i);
}

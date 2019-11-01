package Tienda;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Juego.Juego;


public class Tienda {
	
	protected Juego juego;
	protected Entidad proxACrear;
	
	public Tienda(Juego j) {
		juego = j;
	}
	
	public void crear(CreadorEntidad creador, int precio){
		if (alcanza(precio)){
			juego.setMonedas( juego.getMonedas()-precio);
			Entidad nuevo = creador.crear();
			proxACrear = nuevo;
		}
	}
	
	public Entidad getProximo(){
		return proxACrear;
	}
	
	public void quitarProximo(){
		proxACrear = null;
	}

	private boolean alcanza(int precio){
		if(juego.getMonedas() >= precio)
			return true;
		else
			return false;
	}

}
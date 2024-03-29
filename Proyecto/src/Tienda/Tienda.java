package Tienda;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Juego.Juego;


public class Tienda {
	
	protected Juego juego;
	protected Entidad proxACrear;
	protected int aCobrar ;
	protected boolean esPersonaje;
	
	public Tienda(Juego j) {
		juego = j;
		aCobrar = 0;
		esPersonaje = false;

	}
	
	public void crear(CreadorEntidad creador, int precio){
		if (alcanza(precio) ){
			aCobrar = precio;
			//juego.setMonedas( juego.getMonedas()-precio);
			proxACrear = creador.crear();
			System.out.println(proxACrear);
		}
	}
	
	public Entidad getProximo(){
		return proxACrear;
	}
	
	public int finalizarCompra() {
		return aCobrar;
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
	
	public boolean getEsPersonaje() {
		return esPersonaje;
	}
	
	public void setEsPersonaje(boolean es) {
		esPersonaje = es;
	}

}
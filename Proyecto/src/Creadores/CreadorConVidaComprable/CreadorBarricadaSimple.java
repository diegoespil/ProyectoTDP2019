package Creadores.CreadorConVidaComprable;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Objeto.ConVida.BarricadaSimple;
import Entidad.Objeto.ConVida.ObjetoConVida;

public class CreadorBarricadaSimple extends CreadorEntidad {

	public ObjetoConVida crear() {
		BarricadaSimple nuevo = new BarricadaSimple(0,0,100);
		return nuevo;
	}

}

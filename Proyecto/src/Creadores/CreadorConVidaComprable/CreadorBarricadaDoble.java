package Creadores.CreadorConVidaComprable;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Objeto.ConVida.BarricadaDoble;
import Entidad.Objeto.ConVida.ObjetoConVida;

public class CreadorBarricadaDoble extends CreadorEntidad{

	public ObjetoConVida crear() {
		BarricadaDoble nuevo = new BarricadaDoble(0,0,100);
		return nuevo;
	}

}

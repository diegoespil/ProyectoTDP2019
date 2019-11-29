package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Entidad.Objeto.Temporal.PowerupEnMapa.AtaqueX2;

public class CreadorAtaqueX2 extends CreadorEntidad{


	public Entidad crear() {
		AtaqueX2 nuevo = new AtaqueX2(0,0,5);
		return nuevo;
	}

}

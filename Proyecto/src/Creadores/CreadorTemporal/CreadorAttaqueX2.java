package Creadores.CreadorTemporal;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Entidad;
import Entidad.Objeto.Temporal.AttaqueX2;

public class CreadorAttaqueX2 extends CreadorEntidad{


	public Entidad crear() {
		AttaqueX2 nuevo = new AttaqueX2(0,0,5);
		return nuevo;
	}

}

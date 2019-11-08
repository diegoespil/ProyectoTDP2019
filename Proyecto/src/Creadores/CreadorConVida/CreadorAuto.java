package Creadores.CreadorConVida;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Objeto.ConVida.Auto;
import Entidad.Objeto.ConVida.ObjetoConVida;

public class CreadorAuto extends CreadorEntidad {

	public ObjetoConVida crear(){
		return new Auto(0,0,100);
	}
}

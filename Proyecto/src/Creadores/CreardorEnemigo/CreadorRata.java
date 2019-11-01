package Creadores.CreardorEnemigo;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Rata;

public class CreadorRata extends CreadorEntidad{
	
	public Enemigo crear(){
		Enemigo ene = new Rata(0,0,4,5,1,20,5); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}

package Creadores.CreardorEnemigo;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Ruso;

public class CreadorRuso extends CreadorEntidad{
	
	public Enemigo crear(){
		Enemigo ene = new Ruso(0,0,2,25,12,100,75); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}

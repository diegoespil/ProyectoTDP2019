package Creadores.CreardorEnemigo;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Enemigo.Demogorgon;
import Entidad.Integrante.Enemigo.Enemigo;

public class CreadorDemogorgon extends CreadorEntidad{
	
	public Enemigo crear(){
		Enemigo ene = new Demogorgon(0,0,2,30,1,150,100); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}

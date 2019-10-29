package Creadores.CreardorEnemigo;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Demogorgon;

public class CreadorDemogorgon extends CreadorEnemigo{
	
	public Enemigo crearEnemigo(){
		Enemigo ene = new Demogorgon(0,0,2,30,1,150,100); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}

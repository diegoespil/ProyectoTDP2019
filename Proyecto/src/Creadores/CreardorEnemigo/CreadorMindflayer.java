package Creadores.CreardorEnemigo;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Mindflayer;

public class CreadorMindflayer extends CreadorEnemigo{
	
	public Enemigo crearEnemigo(){
		Enemigo ene = new Mindflayer(0,0,1,50,2,300,150); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}

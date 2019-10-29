package Creadores.CreardorEnemigo;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Perro;

public class CreadorPerro extends CreadorEnemigo{
	
	public Enemigo crearEnemigo(){
		Enemigo ene = new Perro(0,0,5,10,1,40,10); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}

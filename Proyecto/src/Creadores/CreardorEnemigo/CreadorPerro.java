package Creadores.CreardorEnemigo;

import Creadores.CreadorEntidad.CreadorEntidad;
import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Enemigo.Perro;

public class CreadorPerro extends CreadorEntidad{
	
	public Enemigo crear(){
		Enemigo ene = new Perro(0,0,5,10,1,40,10); //(x,y,vel,danio,alc,ptje,monedas)
		return ene;
	}

}

package Juego.Nivel;

import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import Entidad.Integrante.Enemigo.Enemigo;
import Entidad.Integrante.Personaje.Personaje;

public abstract class Nivel {
	
	protected Vector<Enemigo> enemigos;
	protected Vector<Personaje> personajes;
	
	public Nivel(){
		enemigos = new Vector<Enemigo>();
		personajes = new Vector<Personaje>();
	}
	
	public abstract Nivel subirNivel();
	
}

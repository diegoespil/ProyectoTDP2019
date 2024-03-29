package Juego.Nivel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import Creadores.CreadorConVida.CreadorAuto;
import Creadores.CreadorEntidad.CreadorEntidad;
import Creadores.CreadorTemporal.CreadorAtaqueX2;
import Creadores.CreardorEnemigo.CreadorDemogorgon;
import Creadores.CreardorEnemigo.CreadorMindflayer;
import Creadores.CreardorEnemigo.CreadorPerro;
import Creadores.CreardorEnemigo.CreadorPoseido;
import Creadores.CreardorEnemigo.CreadorRata;
import Creadores.CreardorEnemigo.CreadorRuso;
import Entidad.Entidad;
import Entidad.Integrante.Enemigo.*;
import Entidad.Objeto.Objeto;
import Entidad.Objeto.ConVida.Auto;
import Entidad.Objeto.ConVida.ObjetoConVida;
import Entidad.Objeto.Temporal.PowerupEnMapa.AtaqueX2;
import Gui.miVentanaJuego;
import Juego.Juego;
import Juego.Oleada.Oleada;
import Juego.Oleada.Oleada1;

public class Nivel1 extends Nivel {
	
	protected Nivel nivelSiguiente;
	
	public Nivel1(Juego j) {
		super(j);
		nivelSiguiente = new Nivel2(this.juego);
	}
	

	public Nivel subirNivel() {
		
		return nivelSiguiente;
	}

	
	protected void cargarNivel() {
		initEnemigos();
		initObjetos();
	}

	private void initObjetos() {
		try {
			getObstaculos();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getObstaculos() throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader("Archivo//Mapa1.txt");
		BufferedReader b = new BufferedReader(f);
		int fila = 0;
		while ((cadena = b.readLine()) != null) {
			procesarLinea(cadena, fila);
			fila++;
		}
		b.close();
	}

	private void procesarLinea(String cadena, int fila) {
		String arr[] = cadena.split(",");
		CreadorEntidad creador = new CreadorAuto();
		for (int i = 0; i < arr.length; i++) {
			switch(arr[i]) {
			case "auto" : {
				ObjetoConVida a = (ObjetoConVida) creador.crear();
				a.setPosicion(fila, i);
				objetos.add(a);
				break;
			}
			case "auto2" : {
				ObjetoConVida a = (ObjetoConVida) creador.crear();
				a.setPosicion(fila, i);
				objetos.add(a);
				break;

            }
			case "auto3" : {
				ObjetoConVida a = (ObjetoConVida) creador.crear();
				a.setPosicion(fila, i);
				objetos.add(a);
				break;
			}
			}
		}
	}

	private void initEnemigos() {
		try{
			String cadena;
			File file = new File("src//Juego//Nivel//Nivel1");
			FileReader f = new FileReader(file.getAbsolutePath());
			BufferedReader b = new BufferedReader(f);
			int linea = 1;
			while ((cadena = b.readLine()) != null) {
				String arr[] = cadena.split(",");
				for (int i = 0; i < arr.length; i++) {
					switch (arr[i]) {
						case "rata": {CreadorEntidad rata = new CreadorRata();
										Enemigo e = (Enemigo) rata.crear();
										enemigos.add(e);
										CreadorAtaqueX2 creador = new CreadorAtaqueX2();
										AtaqueX2 attaque = (AtaqueX2) creador.crear() ;
										e.setPremio(attaque);
										break;
									}
						case "ruso": {CreadorEntidad ruso = new CreadorRuso();
										Enemigo e = (Enemigo) ruso.crear();
										enemigos.add(e);
										break;
									}
						case "perro": {CreadorEntidad perro = new CreadorPerro();
										Enemigo e = (Enemigo) perro.crear();
										enemigos.add(e);
										break;
									}
						case "demogorgon": {CreadorEntidad demogorgon = new CreadorDemogorgon();
											Enemigo e = (Enemigo) demogorgon.crear();
											enemigos.add(e);
											break;
					}
						case "mindflayer": {CreadorEntidad mindflayer = new CreadorMindflayer();
											Enemigo e = (Enemigo) mindflayer.crear();
											enemigos.add(e);
											break;
					}
						case "poseido": {CreadorEntidad poseido = new CreadorPoseido();
										Enemigo e = (Enemigo) poseido.crear();
										enemigos.add(e);
										break;
										}
					}
				}
				linea++;
			}
			b.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Oleada getOleada(int cant) {
		if (this.oleada == null)
			return new Oleada1(enemigos,cant);
		else
			return this.oleada.getSiguiente(enemigos,cant);
	}


	@Override
	public void setOleada(Oleada oleada) {
		this.oleada = oleada;
		
	}

	
}

package Mapa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class iniMapa {

	private String[][] obstaculos;

	public iniMapa() {
		obstaculos = new String[8][13];

	}

	public String[][] getObstaculos() throws FileNotFoundException, IOException {
		String cadena;
		// File file = new File("Mapa1.txt");
		FileReader f = new FileReader(
				"C:\\Users\\Silvestre\\Documents\\GitHub\\ProyectoTDP2019\\Proyecto\\src\\Mapa1.txt");
		BufferedReader b = new BufferedReader(f);
		int fila = 0;
		while ((cadena = b.readLine()) != null) {
			procesarLinea(cadena, fila);

			fila++;
		}
		b.close();
		return obstaculos;
	}

	void procesarLinea(String cadena, int fila) {
		String arr[] = cadena.split(",");
		for (int i = 0; i < arr.length; i++) {
			obstaculos[fila][i] = arr[i];
		}
	}
}

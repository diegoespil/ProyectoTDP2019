package Juego;

import javax.swing.JLabel;

import Entidad.Entidad;

public interface Subscriber {
	
	public void update(Entidad e);
	public void update(JLabel label);
}

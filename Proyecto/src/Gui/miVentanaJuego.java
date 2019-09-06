package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Mapa.iniMapa;

@SuppressWarnings("serial")
public class miVentanaJuego extends JFrame {

	// private JPanel contentPane;
	private JLabel[][] grilla;
	private String[][] obstaculo;
	JPanel menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miVentanaJuego frame = new miVentanaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public miVentanaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu = new JPanel();
		menu.setBackground(Color.WHITE);
		menu.setLayout(null);
		setBounds(100, 100, 800, 640);
		setContentPane(menu);
		grilla = new JLabel[10][20];
		inicializarGrilla();
		crearGrilla();
	}

	protected void crearGrilla() {
		iniMapa matriz = new iniMapa();
		String palabra;
		try {
			obstaculo = matriz.getObstaculos();
			for (int i = 0; i < obstaculo.length; i++)
				for (int j = 0; j < obstaculo[i].length; j++) {
					palabra = obstaculo[i][j];
					if (palabra.equals("adoquin")) {
						ImageIcon adoquin = new ImageIcon("Imagenes\\adoquin.png");
						grilla[i][j].setIcon(
								new ImageIcon(adoquin.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					} else {
						if (palabra.equals("asfalto")) {
							ImageIcon asfalto = new ImageIcon("Imagenes\\asfalto.png");
							grilla[i][j].setIcon(
									new ImageIcon(asfalto.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
						}
					}
				}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void inicializarGrilla() {
		for (int i = 0; i < grilla.length; i++)
			for (int j = 0; j < grilla[i].length; j++) {
				grilla[i][j] = new JLabel();
				grilla[i][j].setBounds(j * 60, i * 60, 60, 60);
				menu.add(grilla[i][j]);
			}
	}

}

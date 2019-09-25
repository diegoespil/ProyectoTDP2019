package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class miVentanaMenu extends JFrame {
	/**
	 * Lanza la ventana.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miVentanaMenu frame = new miVentanaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea una nueva ventana.
	 */
	public miVentanaMenu() {
		/*
		 * Se crea un nuevo panel y se lo configura. 
		 */
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel menu = new JPanel();
		menu.setBackground(Color.BLACK);
		menu.setLayout(null);
		setBounds(250, 100, 800, 600);
		setResizable(false);
		setContentPane(menu);
		ImageIcon fondo = new ImageIcon("Imagenes//Stranger-Things-Logo-PNG-Clipart.png");
		Clip sonido;
		try {
			sonido = AudioSystem.getClip();
			File a = new File("Imagenes//music.wav");
			sonido.open(AudioSystem.getAudioInputStream(a));
			sonido.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		}

		JButton btnIniciar = new JButton("");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miVentanaJuego juego = new miVentanaJuego();
				juego.setVisible(true);
				setVisible(false);
			}
		});
		btnIniciar.setContentAreaFilled(false);
		btnIniciar.setBorder(null);
		btnIniciar.setBorderPainted(false);
		btnIniciar.setBounds(281, 310, 270, 50);
		ImageIcon iniciar = new ImageIcon("Imagenes//iniciar.png");
		btnIniciar.setIcon(new ImageIcon(iniciar.getImage().getScaledInstance(260, 50, Image.SCALE_DEFAULT)));
		menu.add(btnIniciar);

		JButton btnOpciones = new JButton("");
		btnOpciones.setContentAreaFilled(false);
		btnOpciones.setBorder(null);
		btnOpciones.setBorderPainted(false);
		btnOpciones.setBounds(281, 385, 270, 50);
		ImageIcon opciones = new ImageIcon("Imagenes//opciones.png");
		btnOpciones.setIcon(new ImageIcon(opciones.getImage().getScaledInstance(260, 50, Image.SCALE_DEFAULT)));
		menu.add(btnOpciones);

		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(null);
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(281, 465, 270, 50);
		ImageIcon salir = new ImageIcon("Imagenes//salir.png");
		btnSalir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(260, 50, Image.SCALE_DEFAULT)));
		menu.add(btnSalir);

		JLabel label = new JLabel("");
		label.setBounds(84, 11, 679, 271);
		label.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(679, 271, Image.SCALE_SMOOTH)));
		menu.add(label);
	}
}

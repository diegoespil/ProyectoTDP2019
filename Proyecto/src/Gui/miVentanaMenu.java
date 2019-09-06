package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class miVentanaMenu extends JFrame {

	// private JPanel contentPane;

	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public miVentanaMenu() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel menu = new JPanel();
		menu.setBackground(Color.BLACK);
		menu.setLayout(null);
		setBounds(100, 100, 1024, 600);
		setContentPane(menu);

		JButton btnIniciar = new JButton("iniciar");
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
		btnIniciar.setBounds(383, 311, 270, 50);
		ImageIcon iniciar = new ImageIcon("Imagenes\\iniciar.png");
		btnIniciar.setIcon(new ImageIcon(iniciar.getImage().getScaledInstance(260, 50, Image.SCALE_DEFAULT)));
		menu.add(btnIniciar);

		JButton btnOpciones = new JButton("Opciones");
		btnOpciones.setContentAreaFilled(false);
		btnOpciones.setBorder(null);
		btnOpciones.setBorderPainted(false);
		btnOpciones.setBounds(383, 386, 270, 50);
		ImageIcon opciones = new ImageIcon("Imagenes\\opciones.png");
		btnOpciones.setIcon(new ImageIcon(opciones.getImage().getScaledInstance(260, 50, Image.SCALE_DEFAULT)));
		menu.add(btnOpciones);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(null);
		btnSalir.setBorderPainted(false);
		btnSalir.setBounds(383, 466, 270, 50);
		ImageIcon salir = new ImageIcon("Imagenes\\salir.png");
		btnSalir.setIcon(new ImageIcon(salir.getImage().getScaledInstance(260, 50, Image.SCALE_DEFAULT)));
		menu.add(btnSalir);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Imagenes\\Stranger-Things-Logo-PNG-Clipart.png"));
		label.setBounds(186, 11, 679, 271);
		menu.add(label);
	}
}

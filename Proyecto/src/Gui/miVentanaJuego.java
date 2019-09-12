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
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu = new JPanel();
		menu.setOpaque(false);
		menu.setBackground(Color.WHITE);
		menu.setLayout(null);
		setBounds(300, 50, 800, 500);
		setResizable(false);
		setContentPane(menu);
		ImageIcon once = new ImageIcon("Imagenes\\once.png");
		ImageIcon dustin = new ImageIcon("Imagenes\\dustin.png");
		ImageIcon micke = new ImageIcon("Imagenes\\micke.png");
		ImageIcon lucas = new ImageIcon("Imagenes\\lucas.png");
		ImageIcon hoppe = new ImageIcon("Imagenes\\hoppe.png");
		ImageIcon malo1 = new ImageIcon("Imagenes\\malo1.png");
		ImageIcon malo2 = new ImageIcon("Imagenes\\malo2.png");
		grilla = new JLabel[8][13];
		inicializarGrilla();
		crearGrilla();
		JLabel fondo = new JLabel();
		fondo.setEnabled(false);
		fondo.setBounds(0, 65, 800, 360);
		ImageIcon iconFondo = new ImageIcon("Imagenes\\Fondo.jpg");
		JButton btnNewButton = new JButton("Once");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grilla[4][0].setIcon(new ImageIcon(once.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				grilla[4][0].setVisible(true);
				menu.repaint();
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon(once.getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));
		btnNewButton.setBounds(0, 417, 132, 54);
		menu.add(btnNewButton);
		fondo.setIcon(new ImageIcon(iconFondo.getImage().getScaledInstance(800, 342, Image.SCALE_SMOOTH)));
		menu.add(fondo);

		JLabel lblNewLabel = new JLabel("New label");
		ImageIcon cielo = new ImageIcon("Imagenes\\cielo.jpg");
		lblNewLabel.setIcon(new ImageIcon(cielo.getImage().getScaledInstance(800, 102, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(0, 0, 800, 102);
		menu.add(lblNewLabel);

		JButton btnDustin = new JButton("Dustin");
		btnDustin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grilla[3][0].setIcon(new ImageIcon(dustin.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				grilla[3][0].setVisible(true);
				menu.repaint();
			}
		});
		btnDustin.setFocusable(false);
		btnDustin.setBounds(131, 417, 132, 54);
		btnDustin.setIcon(new ImageIcon(dustin.getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));
		menu.add(btnDustin);

		JButton btnMicke = new JButton("Micke");
		btnMicke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grilla[5][0].setIcon(new ImageIcon(micke.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				grilla[5][0].setVisible(true);
				menu.repaint();
			}
		});
		btnMicke.setFocusable(false);
		btnMicke.setBounds(263, 417, 132, 54);
		btnMicke.setIcon(new ImageIcon(micke.getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));
		menu.add(btnMicke);

		JButton btnLucas = new JButton("Lucas");
		btnLucas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grilla[6][0].setIcon(new ImageIcon(lucas.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				grilla[6][0].setVisible(true);
				menu.repaint();
			}
		});
		btnLucas.setFocusable(false);
		btnLucas.setBounds(393, 417, 132, 54);
		btnLucas.setIcon(new ImageIcon(lucas.getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));
		menu.add(btnLucas);

		JButton btnHoppe = new JButton("Hoppe");
		btnHoppe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grilla[2][0].setIcon(new ImageIcon(hoppe.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				grilla[2][0].setVisible(true);
				menu.repaint();
			}
		});
		btnHoppe.setFocusable(false);
		btnHoppe.setBounds(524, 417, 132, 54);
		btnHoppe.setIcon(new ImageIcon(hoppe.getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));
		menu.add(btnHoppe);

		JButton button = new JButton("Malos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grilla[2][12].setIcon(new ImageIcon(malo2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				grilla[2][12].setVisible(true);
				grilla[4][12].setIcon(new ImageIcon(malo1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				grilla[4][12].setVisible(true);
			}
		});
		button.setFocusable(false);
		button.setBounds(652, 417, 132, 54);
		menu.add(button);

	}

	protected void crearGrilla() {
		iniMapa matriz = new iniMapa();
		String palabra;
		try {
			obstaculo = matriz.getObstaculos();
			for (int i = 0; i < obstaculo.length; i++)
				for (int j = 0; j < obstaculo[i].length; j++) {
					palabra = obstaculo[i][j];
					if (palabra.equals("auto")) {
						ImageIcon auto = new ImageIcon("Imagenes\\auto-fuego1.png");
						grilla[i][j]
								.setIcon(new ImageIcon(auto.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					} else {
						if (palabra.equals("auto2")) {
							ImageIcon auto2 = new ImageIcon("Imagenes\\auto-fuego2.png");
							grilla[i][j].setIcon(
									new ImageIcon(auto2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
						} else {
							if (palabra.equals("vacio")) {
								grilla[i][j].setVisible(false);
							} else {
								if (palabra.equals("auto3")) {
									ImageIcon auto3 = new ImageIcon("Imagenes\\auto-fuego3.png");
									grilla[i][j].setIcon(new ImageIcon(
											auto3.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
								} else {
									if (palabra.equals("fuego")) {
										ImageIcon fuego = new ImageIcon("Imagenes\\fuego.png");
										grilla[i][j].setIcon(new ImageIcon(
												fuego.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
									} else {
										if (palabra.equals("once")) {
											ImageIcon once = new ImageIcon("Imagenes\\once.png");
											grilla[i][j].setIcon(new ImageIcon(
													once.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
										}
									}
								}
							}
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

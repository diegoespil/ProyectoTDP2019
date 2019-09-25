package Gui;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class miVentanaTienda extends JFrame {

	private imagenfondo contentPane;
	private ImageIcon once = new ImageIcon("Imagenes//once_tienda.png");
	private ImageIcon dustin = new ImageIcon("Imagenes//dustin_tienda.png");
	private ImageIcon micke = new ImageIcon("Imagenes//micke_tienda.png");
	private ImageIcon lucas = new ImageIcon("Imagenes//lucas_tienda.png");
	private ImageIcon hopper = new ImageIcon("Imagenes//hopper_tienda.png");
	private ImageIcon barricada_1 = new ImageIcon("Imagenes//barricada1.png");
	private ImageIcon barricada_2 = new ImageIcon("Imagenes//barricada2.png");
	private ImageIcon gas = new ImageIcon("Imagenes//gas.png");
	private ImageIcon portal_trampa = new ImageIcon("Imagenes//portal.png");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miVentanaTienda frame = new miVentanaTienda();
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
	public miVentanaTienda() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 100, 600, 450);
		contentPane = new imagenfondo();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		contentPane.setBackground("Imagenes//fondoTienda.png");
		
		
		setContentPane(contentPane);
		
		JLabel lblPersonajes = new JLabel("Personajes");
		lblPersonajes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPersonajes.setForeground(Color.WHITE);
		lblPersonajes.setBounds(65, 75, 82, 24);
		contentPane.add(lblPersonajes);
		
		JLabel lblObjetos = new JLabel("Objetos");
		lblObjetos.setForeground(Color.WHITE);
		lblObjetos.setBounds(65, 252, 58, 14);
		contentPane.add(lblObjetos);
		
		JRadioButton rbDustin = new JRadioButton("");
		rbDustin.setBackground(Color.BLACK);
		rbDustin.setBounds(137, 205, 25, 25);
		contentPane.add(rbDustin);
		
		JRadioButton  rbLucas = new JRadioButton ("");
		rbLucas.setBackground(Color.BLACK);
		rbLucas.setBounds(65, 205, 25, 25);
		contentPane.add(rbLucas);
		
		JRadioButton  rbMicke = new JRadioButton ("");
		rbMicke.setBackground(Color.BLACK);
		rbMicke.setBounds(212, 205, 25, 25);
		contentPane.add(rbMicke);
		
		JRadioButton rbHoppe = new JRadioButton ("");
		rbHoppe.setBackground(Color.BLACK);
		rbHoppe.setBounds(364, 205, 25, 25);
		contentPane.add(rbHoppe);
		
		JRadioButton  rbOnce = new JRadioButton ("");
		rbOnce.setBackground(Color.BLACK);
		rbOnce.setBounds(290, 205, 25, 25);
		contentPane.add(rbOnce);
		
		JRadioButton  rbBarricada1 = new JRadioButton ("BarricadaX1");
		rbBarricada1.setForeground(Color.WHITE);
		rbBarricada1.setBackground(Color.BLACK);
		rbBarricada1.setBounds(8, 345, 115, 23);
		contentPane.add(rbBarricada1);
		
		JRadioButton rbGasVenenoso = new JRadioButton ("Gas Venenoso");
		rbGasVenenoso.setForeground(Color.WHITE);
		rbGasVenenoso.setBackground(Color.BLACK);
		rbGasVenenoso.setBounds(241, 345, 120, 23);
		contentPane.add(rbGasVenenoso);
		
		JRadioButton  rbBarricada2 = new JRadioButton ("BarricadaX2");
		rbBarricada2.setForeground(Color.WHITE);
		rbBarricada2.setBackground(Color.BLACK);
		rbBarricada2.setBounds(127, 345, 112, 23);
		contentPane.add(rbBarricada2);
		
		JRadioButton rbPortal = new JRadioButton("Portal Trampa");
		rbPortal.setForeground(Color.WHITE);
		rbPortal.setBackground(Color.BLACK);
		rbPortal.setBounds(356, 345, 135, 23);
		contentPane.add(rbPortal);
		
		ButtonGroup botones_tienda = new ButtonGroup();
		
		botones_tienda.add(rbDustin);
		botones_tienda.add(rbLucas);
		botones_tienda.add(rbMicke);
		botones_tienda.add(rbHoppe);
		botones_tienda.add(rbOnce);
		botones_tienda.add(rbBarricada1);
		botones_tienda.add(rbGasVenenoso);
		botones_tienda.add(rbBarricada2);
		botones_tienda.add(rbPortal);
		
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBuy.setBounds(485, 397, 89, 23);
		contentPane.add(btnBuy);
		
		JLabel Lucas = new JLabel("");
		Lucas.setHorizontalAlignment(SwingConstants.CENTER);
		Lucas.setBackground(Color.LIGHT_GRAY);
		Lucas.setIcon(new ImageIcon(lucas.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		Lucas.setBounds(44, 120, 60, 60);
		contentPane.add(Lucas);
		
		JLabel Dustin = new JLabel("");
		Dustin.setIcon(new ImageIcon(dustin.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		Dustin.setBounds(119, 120, 60, 60);
		contentPane.add(Dustin);
		
		JLabel Micke = new JLabel("");
		Micke.setIcon(new ImageIcon(micke.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		Micke.setBounds(194, 120, 60, 60);
		contentPane.add(Micke);
		
		JLabel Once = new JLabel("");
		Once.setIcon(new ImageIcon(once.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		Once.setBounds(269, 120, 60, 60);
		contentPane.add(Once);
		
		JLabel Hopper = new JLabel("");
		Hopper.setIcon(new ImageIcon(hopper.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		Hopper.setEnabled(true);
		Hopper.setBounds(344, 120, 60, 60);
		contentPane.add(Hopper);
		
		JLabel lblLucas = new JLabel("Lucas");
		lblLucas.setForeground(Color.WHITE);
		lblLucas.setBounds(60, 185, 45, 14);
		contentPane.add(lblLucas);
		
		JLabel lblDustin = new JLabel("Dustin");
		lblDustin.setForeground(Color.WHITE);
		lblDustin.setBounds(130, 185, 45, 14);
		contentPane.add(lblDustin);
		
		JLabel lblMicke = new JLabel("Micke");
		lblMicke.setForeground(Color.WHITE);
		lblMicke.setBounds(205, 185, 45, 14);
		contentPane.add(lblMicke);
		
		JLabel lblOnce = new JLabel("Once");
		lblOnce.setForeground(Color.WHITE);
		lblOnce.setBounds(282, 185, 45, 14);
		contentPane.add(lblOnce);
		
		JLabel lblHopper = new JLabel("Hopper");
		lblHopper.setForeground(Color.WHITE);
		lblHopper.setBounds(354, 185, 45, 14);
		contentPane.add(lblHopper);
		
		JLabel barricada1 = new JLabel("");
		barricada1.setHorizontalAlignment(SwingConstants.CENTER);
		barricada1.setBackground(Color.LIGHT_GRAY);
		barricada1.setIcon(new ImageIcon(barricada_1.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		barricada1.setBounds(44, 277, 60, 60);
		contentPane.add(barricada1);
		
		JLabel barricada2 = new JLabel("");
		barricada2.setHorizontalAlignment(SwingConstants.CENTER);
		barricada2.setBackground(Color.LIGHT_GRAY);
		barricada2.setIcon(new ImageIcon(barricada_2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		barricada2.setBounds(137, 277, 60, 60);
		contentPane.add(barricada2);
		
		JLabel gas_venenoso = new JLabel("");
		gas_venenoso.setHorizontalAlignment(SwingConstants.CENTER);
		gas_venenoso.setBackground(Color.LIGHT_GRAY);
		gas_venenoso.setIcon(new ImageIcon(gas.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		gas_venenoso.setBounds(242, 277, 60, 60);
		contentPane.add(gas_venenoso);
		
		JLabel portal = new JLabel("");
		portal.setHorizontalAlignment(SwingConstants.CENTER);
		portal.setBackground(Color.LIGHT_GRAY);
		portal.setIcon(new ImageIcon(portal_trampa.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		portal.setBounds(358, 277, 60, 60);
		contentPane.add(portal);
	}
}


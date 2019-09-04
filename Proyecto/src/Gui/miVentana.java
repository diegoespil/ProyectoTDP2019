package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class miVentana extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miVentana frame = new miVentana();
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
	public miVentana() {
		JLabel [][] grafica = new JLabel [7][10];
		JPanel principal = new JPanel();
		principal.setLayout(null);
		JPanel matriz = new JPanel();
	
		matriz.setBounds(226,25,700, 500);
		matriz.setBackground(Color.GRAY);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		
		setContentPane(principal);
		principal.add(matriz);
		
		

	}

}

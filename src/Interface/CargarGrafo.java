package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Main.Espia;
import Main.Juego;

public class CargarGrafo {

	private JFrame frame;
	private Juego juego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public CargarGrafo(boolean b, Juego j) {
		juego = j;
		initialize(b);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(boolean b) {
		frame = new JFrame();
		frame.setVisible(b);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblEspiasAEncontrarse = new JLabel("Espias a encontrarse:");
		lblEspiasAEncontrarse.setForeground(Color.WHITE);
		lblEspiasAEncontrarse.setBackground(Color.WHITE);
		lblEspiasAEncontrarse.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblEspiasAEncontrarse.setBounds(20, 106, 181, 14);
		frame.getContentPane().add(lblEspiasAEncontrarse);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(211, 103, 131, 20);
		frame.getContentPane().add(comboBox);
		DefaultComboBoxModel<String> espias = new DefaultComboBoxModel<String>();
		espias.addAll(juego.getEspiasKey());
		comboBox.setModel(espias);
		
		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setBounds(211, 141, 131, 20);
		frame.getContentPane().add(comboBox2);
		comboBox2.setModel(espias);
	

		JButton btnGuardar = new JButton("Guardar Encuentro");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGuardar.setBounds(211, 186, 131, 23);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(211, 220, 131, 23);
		frame.getContentPane().add(btnFinalizar);

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnGuardar) {
					System.out.println("Espias: " + juego.getEspias());
					juego.agregarEncuentro(0.1, comboBox.getSelectedItem().toString(), comboBox2.getSelectedItem().toString());
					System.out.println("Espias a encontrarse: " + comboBox.getSelectedItem().toString() + "y"+ comboBox2.getSelectedItem().toString());
				}
			}
		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ImprimirGrafo imprimirGrafo = new ImprimirGrafo(true);
				frame.setVisible(false);
			}
		});

	}

	public JFrame getFrame() {
		return frame;
	}
}

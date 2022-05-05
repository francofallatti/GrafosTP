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
	private JTextField nombreEspia;

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
	public CargarGrafo(boolean b) {
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

		JLabel lblNDeLosEspias = new JLabel("Nombre de los espias:");
		lblNDeLosEspias.setForeground(Color.WHITE);
		lblNDeLosEspias.setBackground(Color.WHITE);
		lblNDeLosEspias.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblNDeLosEspias.setBounds(20, 47, 181, 14);
		frame.getContentPane().add(lblNDeLosEspias);

		JButton btnCargar = new JButton("Cargar");

		nombreEspia = new JTextField(); // captura los nombres de los espias

		nombreEspia.setBounds(211, 45, 131, 20);
		frame.getContentPane().add(nombreEspia);
		nombreEspia.setColumns(10);

		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCargar.setBounds(352, 44, 72, 23);
		frame.getContentPane().add(btnCargar);

		JLabel lblEspiasAEncontrarse = new JLabel("Espias a encontrarse:");
		lblEspiasAEncontrarse.setForeground(Color.WHITE);
		lblEspiasAEncontrarse.setBackground(Color.WHITE);
		lblEspiasAEncontrarse.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblEspiasAEncontrarse.setBounds(20, 106, 181, 14);
		frame.getContentPane().add(lblEspiasAEncontrarse);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(211, 103, 131, 20);
		frame.getContentPane().add(comboBox);
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setBounds(211, 141, 131, 20);
		frame.getContentPane().add(comboBox2);

		JButton btnGuardar = new JButton("Guardar Encuentro");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGuardar.setBounds(211, 186, 131, 23);
		frame.getContentPane().add(btnGuardar);

		// functions
		btnCargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnCargar && !nombreEspia.getText().isEmpty()) {
					Juego.agregarEspia(nombreEspia.getText());
					System.out.println(nombreEspia.getText());
					comboBox.addItem(nombreEspia.getText());
					comboBox2.addItem(nombreEspia.getText());
				}
				borrar();

			}

			public void borrar() {
				nombreEspia.setText(null);
			}

		});

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnGuardar) {
					System.out.println("Espias a encontrarse: " + Juego.getEspias());
					
				}
			}
		});

	}

	private JComboBox<String> InsertarItem(JComboBox CB) {
		for (Espia s : Juego.getEspias()) {
			CB.addItem(s);
		}
		return CB;

	}
}

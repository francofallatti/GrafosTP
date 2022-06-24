package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Main.Juego;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Grafos.AGMinimo;

public class CargarGrafo {

	private JFrame frame;
	private Juego juego;

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
	 * @wbp.parser.entryPoint
	 */
	public CargarGrafo(boolean b, Juego j) {
		juego = j;
		juego.cargarEncuentros();
		initialize(b);
	}

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
		lblEspiasAEncontrarse.setBounds(140, 24, 163, 14);
		frame.getContentPane().add(lblEspiasAEncontrarse);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(151, 49, 131, 20);
		frame.getContentPane().add(comboBox);
		DefaultComboBoxModel<String> espias = new DefaultComboBoxModel<String>();
		espias.addAll(juego.getNombreEspias());
		comboBox.setModel(espias);

		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setBounds(151, 80, 131, 20);
		frame.getContentPane().add(comboBox2);
		DefaultComboBoxModel<String> espias2 = new DefaultComboBoxModel<String>();
		espias2.addAll(juego.getNombreEspias());
		comboBox2.setModel(espias2);

		JButton btnGuardar = new JButton("Guardar Encuentro");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGuardar.setBounds(151, 193, 131, 23);
		frame.getContentPane().add(btnGuardar);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(293, 227, 131, 23);
		frame.getContentPane().add(btnFinalizar);

		JLabel lblProbabilidadDeIntercepcion = new JLabel("probabilidad de intercepcion:");
		lblProbabilidadDeIntercepcion.setForeground(Color.WHITE);
		lblProbabilidadDeIntercepcion.setFont(new Font("Joystix", Font.PLAIN, 11));
		lblProbabilidadDeIntercepcion.setBackground(Color.WHITE);
		lblProbabilidadDeIntercepcion.setBounds(111, 137, 217, 14);
		frame.getContentPane().add(lblProbabilidadDeIntercepcion);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, 20.0, 1.0));
		spinner.setBounds(151, 162, 131, 20);
		frame.getContentPane().add(spinner);

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnGuardar) {
					if (comboBox.getSelectedItem().toString().equals(comboBox2.getSelectedItem().toString())) {
						JOptionPane.showMessageDialog(frame, "Los espías deben ser diferentes!", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						juego.agregarEncuentro((Double) spinner.getValue(), comboBox.getSelectedItem().toString(),
								comboBox2.getSelectedItem().toString());
						System.out.println("Espias a encontrarse: " + comboBox.getSelectedItem().toString() + "y"
								+ comboBox2.getSelectedItem().toString());
					}
				}
			}
		});

		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AGMinimo resultado = juego.jugar();
				ResultadosInterface ri = new ResultadosInterface(true, resultado, juego);
				frame.setVisible(false);
			}
		});

	}

	public JFrame getFrame() {
		return frame;
	}
}

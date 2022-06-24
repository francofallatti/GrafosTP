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
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class CargarGrafo {

	private JFrame frame;
	private Juego juego;
	private DefaultTableModel modeloTabla;
	private JTable table;

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
	
	public CargarGrafo(boolean b, Juego j) {
		modeloTabla = new DefaultTableModel();
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
		lblEspiasAEncontrarse.setBounds(151, 10, 163, 14);
		lblEspiasAEncontrarse.setForeground(Color.WHITE);
		lblEspiasAEncontrarse.setBackground(Color.WHITE);
		frame.getContentPane().add(lblEspiasAEncontrarse);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(48, 26, 131, 20);
		frame.getContentPane().add(comboBox);
		DefaultComboBoxModel<String> espias = new DefaultComboBoxModel<String>();
		espias.addAll(juego.getNombreEspias());

		comboBox.setModel(espias);

		JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.setBounds(246, 26, 131, 20);
		frame.getContentPane().add(comboBox2);
		DefaultComboBoxModel<String> espias2 = new DefaultComboBoxModel<String>();
		espias2.addAll(juego.getNombreEspias());
		comboBox2.setModel(espias2);

		JButton btnGuardar = new JButton("Guardar Encuentro");
		btnGuardar.setBounds(151, 98, 131, 23);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().add(btnGuardar);

		JButton btnFinalizar = new JButton("Cargar encuentros");
		btnFinalizar.setBounds(293, 227, 131, 23);
		frame.getContentPane().add(btnFinalizar);

		JLabel lblProbabilidadDeIntercepcion = new JLabel("Probabilidad de intercepcion:");
		lblProbabilidadDeIntercepcion.setBounds(137, 48, 217, 14);
		lblProbabilidadDeIntercepcion.setForeground(Color.WHITE);
		lblProbabilidadDeIntercepcion.setBackground(Color.WHITE);
		frame.getContentPane().add(lblProbabilidadDeIntercepcion);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(171, 73, 86, 20);
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, 20.0, 1.0));
		frame.getContentPane().add(spinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(48, 138, 329, 78);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableColumnModel mt = new DefaultTableColumnModel();
		table.setColumnModel(mt);
		modeloTabla.addColumn("Espia 1");
		modeloTabla.addColumn("Espia 2");
		modeloTabla.addColumn("Probabilidad de intercepción");
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(32);
		table.getColumnModel().getColumn(1).setPreferredWidth(32);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		
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
						modeloTabla.addRow(new String[] {comboBox.getSelectedItem().toString(),
								comboBox2.getSelectedItem().toString(), spinner.getValue().toString()});
					}
				}
			}
		});

		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!juego.sePuedeCrearAGM()) {
					JOptionPane.showMessageDialog(frame, "El grafo debe ser conexo!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					OpcionAGMInterface ii = new OpcionAGMInterface(true, juego);
					frame.setVisible(false);
				}
			}
		});

	}

	public JFrame getFrame() {
		return frame;
	}
}

package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Main.Juego;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CargarEspias {

	private JFrame frame;
	private JTextField nombreEspia;
	private Juego juego;
	private JTable table;
	private DefaultTableModel m;

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
	public CargarEspias(boolean b, Juego j) {
		m = new DefaultTableModel();
		juego = j;
		initialize(b);
	}

	private void initialize(boolean b) {
		frame = new JFrame();
		frame.setVisible(b);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNDeLosEspias = new JLabel("Nombre de los espias:");
		lblNDeLosEspias.setBounds(20, 47, 181, 14);
		lblNDeLosEspias.setForeground(Color.WHITE);
		lblNDeLosEspias.setBackground(Color.WHITE);
		frame.getContentPane().add(lblNDeLosEspias);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(352, 44, 72, 23);

		nombreEspia = new JTextField();
		nombreEspia.setBounds(181, 44, 131, 20);
		frame.getContentPane().add(nombreEspia);
		nombreEspia.setColumns(10);

		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().add(btnCargar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(211, 220, 131, 23);
		frame.getContentPane().add(btnFinalizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 103, 286, 106);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(m);
		m.addColumn("Espias cargados");

		btnCargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btnCargar && !nombreEspia.getText().isEmpty()) {
					juego.agregarEspia(nombreEspia.getText());
					m.addRow(new String[] {nombreEspia.getText()});
				}
				borrar();
			}
			public void borrar() {
				nombreEspia.setText(null);
			}
		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarGrafo cg = new CargarGrafo(true, juego);
				frame.setVisible(false);
			}
		});

	}
}

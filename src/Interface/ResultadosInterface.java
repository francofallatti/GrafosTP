package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Grafos.AGMinimo;
import Main.Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class ResultadosInterface {

	private JFrame frame;
	private AGMinimo resultado;
	private Juego juego;
	private JTable table_1;

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
	public ResultadosInterface(boolean b, AGMinimo res, Juego j) {
		resultado = res;
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

		JLabel lblNewLabel = new JLabel("RESULTADOS:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblNewLabel.setBounds(163, 11, 87, 14);
		frame.getContentPane().add(lblNewLabel);

		table_1 = new JTable();
		table_1.setBounds(62, 42, 299, 164);
		// frame.add(new JScrollPane(table_1), BorderLayout.CENTER);
		frame.getContentPane().add(table_1, BorderLayout.CENTER);
		DefaultTableModel model = new DefaultTableModel();
		for (Integer i = 0; i < resultado.getMatrizConPesos().length; i++) {
			model.addColumn(i);
			System.out.println(i + "i");
		}

		for (Integer i = 0; i < resultado.getMatrizConPesos().length; i++) {
			for (Integer j = 1; j < resultado.getMatrizConPesos().length; j++) {
				if (i != j) {
					if (resultado.existeArista(i, j)) {
						model.addRow(new Object[] {juego.getNombreEspia(i) , juego.getNombreEspia(j), resultado.getMatrizConPesos()[i][j], });
					} else {
						model.addRow(new Object[] { juego.getNombreEspia(i), juego.getNombreEspia(j), 0 });
					}
				}
			}
		}
		table_1.setModel(model);
		System.out.println(resultado.toString());

	}
	
}

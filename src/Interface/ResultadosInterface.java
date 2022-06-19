package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Grafos.AGMinimo;
import Grafos.AristaConPeso;
import Main.Juego;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultadosInterface {

	private JFrame frame;
	private AGMinimo resultado;
	private Juego juego;
	private JTable table;
	private JScrollPane scrollPane;

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

	public ResultadosInterface(boolean b, AGMinimo res, Juego j) {
		resultado = res;
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

		JLabel lblNewLabel = new JLabel("RESULTADOS:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Joystix", Font.PLAIN, 12));
		lblNewLabel.setBounds(163, 11, 87, 14);
		frame.getContentPane().add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 414, 183);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Espia");
		model.addColumn("Espia");
		model.addColumn("Probabilidad de intercepcion");
		
		for(AristaConPeso ap : resultado.getAristas()) {
			model.addRow(new Object[] { juego.getNombreEspia(ap.getExtremo1()), juego.getNombreEspia(ap.getExtremo2()),
					ap.getPeso() });
		}
		
		table.setModel(model);
		System.out.println(resultado.toString());

	}
}

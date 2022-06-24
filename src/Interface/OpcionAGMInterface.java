package Interface;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Grafos.AGMinimo;
import Grafos.GrafoConPeso;
import Grafos.Implementacion;
import Main.Juego;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcionAGMInterface {

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
	public OpcionAGMInterface(boolean b, Juego j) {
		juego = j;
		initialize(b);
	}

	private void initialize(boolean b) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(b);
		
		JLabel lblElijaUnTipo = new JLabel("Elija un tipo de implementacion");
		lblElijaUnTipo.setBounds(139, 50, 181, 14);
		frame.getContentPane().add(lblElijaUnTipo);
		
		JComboBox<Implementacion> comboBox = new JComboBox<Implementacion>();
		comboBox.setBounds(139, 100, 145, 22);
		frame.getContentPane().add(comboBox);
		DefaultComboBoxModel<Implementacion> model = new DefaultComboBoxModel<Implementacion>(); 
		model.addElement(Implementacion.Prim);
		model.addElement(Implementacion.Kruskal);
		comboBox.setModel(model);
		JButton btnVerResultado = new JButton("Ver resultado");
		btnVerResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AGMinimo agm = juego.jugar((Implementacion) model.getSelectedItem());
				ResultadosInterface ri = new ResultadosInterface(true, agm, juego);
				frame.setVisible(false);
			}
		});
		btnVerResultado.setBounds(147, 167, 124, 23);
		frame.getContentPane().add(btnVerResultado);
	}
}

package aplicacao_swing;

import java.awt.BorderLayout;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.util.List;

import modelo.Item;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class TelaEquiparPersonagem3 extends JFrame {

	private JPanel contentPane;
	public static JTextArea inventario;
	public static JTextArea itensEquip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEquiparPersonagem3 frame = new TelaEquiparPersonagem3();
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
	public TelaEquiparPersonagem3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button equipar = new Button("Equipar");
		equipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeItem = JOptionPane.showInputDialog("Informe o nome do Item: ");
					Fachada.equiparItem(nomeItem);
					inventario.setText("");
					itensEquip.setText("");
					funcaoItem();
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		equipar.setBounds(455, 145, 107, 40);
		contentPane.add(equipar);
		
		Button desequipar = new Button("Desequipar");
		desequipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeItem = JOptionPane.showInputDialog("Informe o nome do Item: ");
					Fachada.desequiparItem(nomeItem);
					inventario.setText("");
					itensEquip.setText("");
					funcaoItem();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		desequipar.setBounds(455, 193, 107, 40);
		contentPane.add(desequipar);
		
		JLabel lblItensEquipado = new JLabel("Itens equipado");
		lblItensEquipado.setBounds(70, 30, 89, 22);
		contentPane.add(lblItensEquipado);
		
		JLabel label_3 = new JLabel("Invent\u00E1rio");
		label_3.setBounds(299, 30, 75, 22);
		contentPane.add(label_3);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(239, 63, 196, 188);
		contentPane.add(scrollPane_1);
		
		inventario = new JTextArea();
		inventario.setEditable(false);
		scrollPane_1.setViewportView(inventario);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 63, 196, 188);
		contentPane.add(scrollPane);
		
		itensEquip = new JTextArea();
		scrollPane.setViewportView(itensEquip);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(463, 101, 99, 25);
		contentPane.add(btnNewButton);
		
		funcaoItem();
		
		
		
	}
	public static void funcaoItem() {
		List<Item> itensEquipado = Fachada.itensEquipadoPersonagem();
		for(Item i: itensEquipado) {
			String aux = itensEquip.getText();
			itensEquip.setText(aux+i.getNome()+"\n");
		}
		
		List<Item> Inventario = Fachada.itensInventarioPersonagem();
		for(Item i: Inventario) {
			String aux = inventario.getText();
			inventario.setText(aux+i.getNome()+"\n");
		}
	}
}

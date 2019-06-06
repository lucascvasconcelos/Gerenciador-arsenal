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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class TelaEquiparPersonagem extends JFrame {

	private JPanel contentPane;
	public static JComboBox inventario;
	public static JComboBox itensEquip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEquiparPersonagem frame = new TelaEquiparPersonagem();
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
	public TelaEquiparPersonagem() {
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
					Fachada.equiparItem(String.valueOf(inventario.getSelectedItem()));
					inventario.removeAll();
					itensEquip.removeAll();
					funcaoItem();
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		equipar.setBounds(455, 145, 107, 40);
		contentPane.add(equipar);
		
		Button desequipar = new Button("Desequipar");
		desequipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.desequiparItem(String.valueOf(inventario.getSelectedItem()));
					inventario.removeAll();
					itensEquip.removeAll();
					funcaoItem();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
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
		
		inventario = new JComboBox();
		scrollPane_1.setViewportView(inventario);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 63, 196, 188);
		contentPane.add(scrollPane);
		
		itensEquip = new JComboBox();
		scrollPane.setViewportView(itensEquip);
		
		funcaoItem();
		
		
		
		
	}
	public static void funcaoItem() {
		List<Item> itensEquipado = Fachada.itensEquipadoPersonagem();
		for(Item i: itensEquipado) {
			itensEquip.addItem(i.getNome());
		}
		
		List<Item> Inventario = Fachada.itensInventarioPersonagem();
		for(Item i: Inventario) {
			inventario.addItem(i.getNome());
		}
	}
}

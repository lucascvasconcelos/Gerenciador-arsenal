package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Item;
import modelo.Vendedor;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class TelaCompra extends JFrame {

	private JPanel contentPane;
	public JComboBox<String> vendedores;
	public JButton btnNewButton;
	public JButton btnComprar;
	public JLabel nomeVendedor;
	public JLabel itens;
	public JComboBox<String> itensVendedor;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCompra frame = new TelaCompra();
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
	public TelaCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 244, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		vendedores = new JComboBox<String>();
		vendedores.setBounds(10, 38, 199, 20);
		contentPane.add(vendedores);
		
		btnNewButton = new JButton("Selecionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itensVendedor.removeAllItems();
				String nomeVend = String.valueOf(vendedores.getSelectedItem());
				for(Item i: Fachada.listarItemVendedor(nomeVend)) {					
					nomeVendedor.setText(nomeVend);
					itens.setText("Itens - "+nomeVend);
					itensVendedor.addItem(i.getNome());
				}
				
			}
		});
		btnNewButton.setBounds(64, 64, 99, 23);
		contentPane.add(btnNewButton);
		
		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
                    Fachada.comprarItem(String.valueOf(itensVendedor.getSelectedItem()));
                    JOptionPane.showMessageDialog(null, "Item comprado com sucesso!\n"+String.valueOf(itensVendedor.getSelectedItem()));
                     
                }
                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
			}
		});
		btnComprar.setBounds(64, 189, 89, 23);
		contentPane.add(btnComprar);
		
		nomeVendedor = new JLabel("Vendedor");
		nomeVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		nomeVendedor.setBounds(10, 13, 199, 14);
		contentPane.add(nomeVendedor);
		
		itens = new JLabel("Itens vendedor");
		itens.setHorizontalAlignment(SwingConstants.CENTER);
		itens.setBounds(10, 140, 199, 14);
		contentPane.add(itens);
		
		itensVendedor = new JComboBox<String>();
		itensVendedor.setBounds(10, 165, 199, 20);
		contentPane.add(itensVendedor);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(92, 238, 117, 25);
		contentPane.add(btnSair);
		
		for(Vendedor v: Fachada.listarVendedor()) {
			vendedores.addItem(v.getNome());
		}
	}
}

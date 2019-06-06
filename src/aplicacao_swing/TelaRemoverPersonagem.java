package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Personagem;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaRemoverPersonagem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverPersonagem frame = new TelaRemoverPersonagem();
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
	public TelaRemoverPersonagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(86, 77, 145, 24);
		contentPane.add(comboBox);
		for(Personagem p:Fachada.listaPersonagem()){
			comboBox.addItem(p.getNome());
		}
		
		
		JLabel lblEscolhaOPersonagem = new JLabel("Escolha o personagem que deseja remover");
		lblEscolhaOPersonagem.setBounds(60, 36, 318, 15);
		contentPane.add(lblEscolhaOPersonagem);
		
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Personagem p = Fachada.removerPersonagem(String.valueOf(comboBox.getSelectedItem()));
					//comboBox.removeItem(String.valueOf(comboBox.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "Personagem excluido com sucesso: " + p);
					dispose();
					TelaListagemPersonagem j = new TelaListagemPersonagem();
					j.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btnRemover.setBounds(124, 134, 117, 25);
		contentPane.add(btnRemover);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBackground(Color.RED);
		btnSair.setForeground(Color.DARK_GRAY);
		btnSair.setBounds(282, 198, 117, 25);
		contentPane.add(btnSair);
	}
}

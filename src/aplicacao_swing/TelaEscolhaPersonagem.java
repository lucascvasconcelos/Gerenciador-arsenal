package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Conta;
import modelo.Personagem;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaEscolhaPersonagem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEscolhaPersonagem frame = new TelaEscolhaPersonagem();
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
	public TelaEscolhaPersonagem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscolhaSeuPersonagem = new JLabel("Escolha seu personagem");
		lblEscolhaSeuPersonagem.setBounds(33, 41, 228, 15);
		contentPane.add(lblEscolhaSeuPersonagem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(33, 79, 169, 24);
		contentPane.add(comboBox);
		for(Personagem p:Fachada.listaPersonagem()){
			comboBox.addItem(p.getNome());
		}
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(comboBox.getSelectedItem());
				try {
					Fachada.selecionarPersonagem(String.valueOf(comboBox.getSelectedItem()));
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSelecionar.setBounds(85, 121, 117, 25);
		contentPane.add(btnSelecionar);
		
		JButton button = new JButton("Sair");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(Color.RED);
		button.setBounds(293, 197, 117, 25);
		contentPane.add(button);
		
	}
}

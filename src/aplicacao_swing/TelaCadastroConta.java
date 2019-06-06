package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Conta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCadastroConta extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JTextField email;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroConta frame = new TelaCadastroConta();
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
	public TelaCadastroConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(51, 34, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmaill = new JLabel("Emaill");
		lblEmaill.setBounds(51, 103, 70, 15);
		contentPane.add(lblEmaill);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(51, 167, 70, 15);
		contentPane.add(lblSenha);
		
		usuario = new JTextField();
		usuario.setBounds(51, 61, 212, 19);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(51, 130, 212, 19);
		contentPane.add(email);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeUsuario = usuario.getText();
				String emailUsuario = email.getText();
				String senhaUsuario = String.valueOf(senha.getPassword());
				try {
					Conta c = Fachada.criarConta(nomeUsuario, senhaUsuario, emailUsuario);
					JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso: " + c);
//					TelaPrincipal telaPrincipal = new TelaPrincipal();
//					JFrame frameTelaPrincipal = telaPrincipal.callback(true);
//					frameTelaPrincipal.setVisible(true);
					dispose();
//					usuario.setText("");
//					email.setText("");
//					senha.setText("");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnCadastrar.setBounds(292, 150, 117, 25);
		contentPane.add(btnCadastrar);
		
		senha = new JPasswordField();
		senha.setEchoChar('*');
		senha.setBounds(51, 194, 212, 19);
		contentPane.add(senha);
		
		JButton button = new JButton("Sair");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(Color.RED);
		button.setBounds(302, 191, 117, 25);
		contentPane.add(button);
	}
}

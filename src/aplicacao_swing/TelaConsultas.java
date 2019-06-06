package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class TelaConsultas extends JFrame {

	private JPanel contentPane;
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultas frame = new TelaConsultas();
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
	public TelaConsultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Personagem da conta que possui determinado tipo");
		btnNewButton.setBounds(44, 255, 498, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String descTipo = JOptionPane.showInputDialog("Informe o nome do Tipo de personagem: ");
				textArea.setText(Fachada.consultarContasPorTipoPersonagem(descTipo));
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnConsultarContasQue = new JButton("Consultar contas que possuem determinado item");
		btnConsultarContasQue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String nomeItem = JOptionPane.showInputDialog("Informe o nome do item: ");
				textArea.setText(Fachada.consultarContasPorItem(nomeItem));
			}
		});
		btnConsultarContasQue.setBounds(44, 292, 498, 25);
		contentPane.add(btnConsultarContasQue);
		
		JButton button_1 = new JButton("Quantidade de um item determinado na conta atual");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeItem = JOptionPane.showInputDialog("Informe o nome do item: ");
					textArea.setText("qtd de itens = "+Fachada.qtdItensPersonagensContas(nomeItem));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_1.setBounds(44, 327, 498, 25);
		contentPane.add(button_1);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(429, 364, 117, 25);
		btnNewButton_1.setBackground(Color.RED);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(12, 12, 560, 209);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
	}
}

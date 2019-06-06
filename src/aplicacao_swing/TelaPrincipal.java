package aplicacao_swing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programa��o Orientada a Objetos
 * Prof. Fausto Maranh�o Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmListar;
	private JMenu mnConsulta;
	private JMenu mnTelefone;
	private JMenu mnPessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();


		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Fachada.inicializar();
				try {
					frmPrincipal.setContentPane(new FundoTela("jogo.jpeg"));
					
				} catch (Exception e) {
				}
				try {
//					Fachada.login(null, null);
					Fachada.adicionarTipoPersonagem("Guerreiro");
					Fachada.adicionarTipoPersonagem("Mago");
					Fachada.adicionarTipoPersonagem("Arqueiro");
					Fachada.criarItem("Espada do Zodiaco", 1, 100, 0, 0, 50, "Espada");
					Fachada.criarItem("Armadura do Zodiaco", 1, 0, 100, 10, 50, "Armadura");
					Fachada.criarItem("Capacete do Zodiaco", 1, 0, 50, 0, 50, "Capacete");
					Fachada.criarItem("Escudo do Zodiaco", 1, 100, 200, 5, 50, "Escudo");
					Fachada.criarConta("admin", "admin", "email");
					Fachada.login("admin", "admin");
					Fachada.criarPersonagem("Administrador", "Guerreiro");
					Fachada.selecionarPersonagem("Administrador");
					Fachada.adicionarItemPersonagem("Espada do Zodiaco");
					Fachada.adicionarItemPersonagem("Armadura do Zodiaco");
					Fachada.criarVendedor("Vendedor de Armas");
					Fachada.adicionarItemVendedor("Vendedor de Armas", "Espada do Zodiaco");
//					Fachada.criarVendedor("Vendedor de Armaduras");
					Fachada.criarVendedor("Vendedor de Capacetes");
//					Fachada.criarVendedor("Vendedor de Escudos");
//					Fachada.adicionarItemVendedor("Vendedor de Armaduras", "Armadura do Zodi�co");
					Fachada.adicionarItemVendedor("Vendedor de Capacetes", "Capacete do Zodiaco");
//					Fachada.adicionarItemVendedor("Vendedor de Escudos", "Escudo do Zodi�co");
//					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "sistema inicializado !");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				Fachada.finalizar();
				JOptionPane.showMessageDialog(null, "sistema finalizado !");
			}
		});
		frmPrincipal.setTitle("Jogo");
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);

		mnPessoa = new JMenu("Conta");
		menuBar.add(mnPessoa);

		mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroConta j = new TelaCadastroConta();
				j.setVisible(true);
				
			}

		});
		mnPessoa.add(mntmCadastrar);
		

		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mntmConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultas j = new TelaConsultas();
				j.setVisible(true);
			}
		});
		mnPessoa.add(mntmConsultas);

		
		mntmListar = new JMenuItem("Login");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin j = new TelaLogin();
				j.setVisible(true);
			}
		});
		mnPessoa.add(mntmListar);
		
		JMenuItem mntmLogof = new JMenuItem("Logof");
		mntmLogof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogof j = new TelaLogof();
				j.setVisible(true);
			}
		});
		mnPessoa.add(mntmLogof);



		mnTelefone = new JMenu("Personagem");
		menuBar.add(mnTelefone);
		JMenuItem mntmCriar = new JMenuItem("Adicionar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCriarPersonagem j = new TelaCriarPersonagem();
				j.setVisible(true);
			}
		});
		mnTelefone.add(mntmCriar);

		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemPersonagem j = new TelaListagemPersonagem();
				j.setVisible(true);
			}
		});
		mnTelefone.add(mntmListar_1);
		
		JMenuItem mntmEscolher = new JMenuItem("Escolher Personagem");
		mntmEscolher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscolhaPersonagem j = new TelaEscolhaPersonagem();
				j.setVisible(true);
			}
		});
		mnTelefone.add(mntmEscolher);
		
		JMenuItem mntmRemover = new JMenuItem("Remover Personagem");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverPersonagem j = new TelaRemoverPersonagem();
				j.setVisible(true);
			}
		});
		mnTelefone.add(mntmRemover);
		
		JMenuItem mntmEquipar = new JMenuItem("Equipar Personagem");
		mntmEquipar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEquiparPersonagem3 j = new TelaEquiparPersonagem3();
				j.setVisible(true);
			}
		});
		mnTelefone.add(mntmEquipar);
		
		JMenuItem mntmVendedor = new JMenuItem("Comprar Itens");
		mntmVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCompra j = new TelaCompra();
				j.setVisible(true);
			}
		});
		mnTelefone.add(mntmVendedor);
	

	}
	
	public JFrame callback(boolean opcao) {
		return opcao ? frmPrincipal : null;		
	}
}

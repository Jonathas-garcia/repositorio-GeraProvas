package br.edu.unicid.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;

import br.edu.unicid.view.Assuntos.AtivarAssunto;
import br.edu.unicid.view.Assuntos.CadastrarAssunto;
import br.edu.unicid.view.Assuntos.InativarAssunto;
import br.edu.unicid.view.Assuntos.ListarAssunto;
import br.edu.unicid.view.NivelDificuldade.AtivarNivel;
import br.edu.unicid.view.NivelDificuldade.CadastrarNivel;
import br.edu.unicid.view.NivelDificuldade.InativarNivel;
import br.edu.unicid.view.NivelDificuldade.ListarNiveis;
import br.edu.unicid.view.Prova.GerarProva;
import br.edu.unicid.view.Prova.Prova;
import br.edu.unicid.view.Questao.AtivarQuestao;
import br.edu.unicid.view.Questao.CadastrarQuestao;
import br.edu.unicid.view.Questao.CadastrarQuestaoDissertativa;
import br.edu.unicid.view.Questao.InativarQuestao;
import br.edu.unicid.view.Questao.PainelSelecionaAssunto;

public class Telas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 257622228681212571L;
	/**
	 * 
	 */
	private JMenuBar menuBar;
	private JMenu mnDisciplina;
	private JMenu novaQuestao;
	private JMenu mnProva;
	private JMenu nivelDific;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// DEFINE OS COMPONENTES GRÁFICOS COM O TEMA DO WINDOWS
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telas frame = new Telas();
					frame.setVisible(true);
					frame.setTitle("Phoenix GeraProvas");
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Telas() {

		setBounds(100, 100, 800, 600);


		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem novo = new JMenuItem("Incluir - Objetiva ");
		JMenuItem questaoDissertativa = new JMenuItem("Incluir - Dissertativa");
		JMenuItem editarQuestao = new JMenuItem("Editar ");
		JMenuItem ativarQuestao = new JMenuItem("Ativar");
		JMenuItem inativarQuestao = new JMenuItem("Inativar");
		JMenuItem InativarAssunto = new JMenuItem("Inativar");
		JMenuItem ativarAssunto = new JMenuItem("Ativar");
		JMenuItem incluirAssunto = new JMenuItem("Incluir  ");
		JMenuItem editarAssunto = new JMenuItem("Editar");
		JMenuItem InativarNivel = new JMenuItem("Inativar");
		JMenuItem ativarNivel = new JMenuItem("Ativar");
		JMenuItem incluirNivel = new JMenuItem("Incluir  ");
		JMenuItem editarNivel = new JMenuItem("Editar");
		JMenuItem criar = new JMenuItem("Criar");

		JMenuItem gerar = new JMenuItem("Gerar");

		// CHAMA TELA CADASTRAR QUESTAO
		novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarQuestao frame = new CadastrarQuestao();
				frame.setVisible(true);
				frame.setTitle("Cadastrar Questão");
			}
		});

		// CHAMA TELA CADASTRAR QUESTAO DISSERTATIVA

		questaoDissertativa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadastrarQuestaoDissertativa frame = new CadastrarQuestaoDissertativa();
				frame.setVisible(true);
			}
		});

		// ALTERAR QUESTAO

		editarQuestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PainelSelecionaAssunto frame;
				try {
					frame = new PainelSelecionaAssunto();
					frame.setVisible(true);
					frame.setTitle("Editar Questao");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		// CHAMA TELA INATIVAR QUESTAO
		inativarQuestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InativarQuestao frame = new InativarQuestao();
				frame.setVisible(true);
				frame.setTitle("Inativar Questao");
			}
		});

		// CHAMA TELA ATIVAR QUESTAO
		ativarQuestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtivarQuestao frame = new AtivarQuestao();
				frame.setVisible(true);
				frame.setTitle("AtivarQuestao");

			}
		});
		// CHAMA TELA INCLUIR ASSUNTO
		incluirAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastrarAssunto frame = new CadastrarAssunto();
				frame.setVisible(true);
				frame.setTitle("Incluir Assunto");

			}
		});

		// EDITAR ASSUNTO
		editarAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarAssunto frame = new ListarAssunto();
				frame.setTitle("Editar Assunto");
				frame.setVisible(true);
			}
		});

		// INATIVAR ASSUNTO

		InativarAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InativarAssunto frame = new InativarAssunto();
				frame.setTitle("Inativar Assunto");
				frame.setVisible(true);

			}
		});

		// ATIVAR ASSUNTO

		ativarAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtivarAssunto frame = new AtivarAssunto();
				frame.setTitle("Ativar Assunto");
				frame.setVisible(true);
			}
		});

		// EDITAR NIVEL
		editarNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarNiveis frame = new ListarNiveis();
				frame.setTitle("Editar Nivel de Dificuldade");
				frame.setVisible(true);

			}
		});

		// INCLUIR NIVEL
		incluirNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarNivel frame = new CadastrarNivel();
				frame.setTitle("Cadastrar Nivel");
				frame.setVisible(true);

			}
		});

		// INATIVAR NIVEL
		InativarNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InativarNivel frame = new InativarNivel();

				frame.setTitle("Inativar Nivel de Dificuldade");
				frame.setVisible(true);
			}
		});

		// ATIVAR NIVEL

		ativarNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtivarNivel frame = new AtivarNivel();
				frame.setTitle("Ativar Nivel de Dificuldade");
				frame.setVisible(true);
			}
		});

		// CRIAR PROVA
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Prova frame = new Prova();
				frame.setTitle("Criar Prova");
				frame.setVisible(true);
			}
		});

		mnDisciplina = new JMenu("Assunto");
		mnDisciplina.setSelectedIcon(new ImageIcon("imagens/teacher.png"));
		menuBar.add(mnDisciplina);
		mnDisciplina.add(incluirAssunto);
		mnDisciplina.addSeparator();
		mnDisciplina.add(editarAssunto);
		mnDisciplina.addSeparator();
		mnDisciplina.add(InativarAssunto);
		mnDisciplina.addSeparator();
		mnDisciplina.add(ativarAssunto);

		nivelDific = new JMenu("Nivel Dificuldade");
		menuBar.add(nivelDific);
		nivelDific.add(incluirNivel);
		nivelDific.addSeparator();
		nivelDific.add(editarNivel);
		nivelDific.addSeparator();
		nivelDific.add(InativarNivel);
		nivelDific.addSeparator();
		nivelDific.add(ativarNivel);

		novaQuestao = new JMenu("Quest\u00E3o");
		menuBar.add(novaQuestao);
		novaQuestao.add(novo);
		novaQuestao.addSeparator();
		novaQuestao.add(questaoDissertativa);
		novaQuestao.addSeparator();
		novaQuestao.add(editarQuestao);
		novaQuestao.addSeparator();
		novaQuestao.add(inativarQuestao);
		novaQuestao.addSeparator();
		novaQuestao.add(ativarQuestao);

		mnProva = new JMenu("Prova");
		menuBar.add(mnProva);
		mnProva.add(criar);
		getContentPane().setLayout(null);

//		JLabel lblNomeDoProfessor = new JLabel("Bem-vindo Professor ");
//		lblNomeDoProfessor.setFont(new Font("Comic Sans MS", Font.ITALIC, 13));
//		lblNomeDoProfessor.setBounds(560, 516, 214, 14);
//		getContentPane().add(lblNomeDoProfessor);

//		JLabel lblNewLabel_3 = new JLabel("New label");
//		lblNewLabel_3.setIcon(new ImageIcon("imagens/28.png"));
//		lblNewLabel_3.setBounds(514, 209, 260, 320);
//		getContentPane().add(lblNewLabel_3);

		JButton atlAssunto = new JButton("");
		atlAssunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarAssunto frame = new CadastrarAssunto();
				frame.setVisible(true);
				frame.setTitle("Cadastrar Assunto");
			}
		});
		atlAssunto.setToolTipText("Cadastrar Questão");
		atlAssunto.setIcon(new ImageIcon("imagens/PROF.jpg"));
		atlAssunto.setBounds(0, 0, 62, 59);
		getContentPane().add(atlAssunto);

		JButton atlNivel = new JButton("");
		atlNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarNivel frame = new CadastrarNivel();
				frame.setTitle("Cadastrar Nivel");
				frame.setVisible(true);
			}
		});
		atlNivel.setIcon(new ImageIcon("imagens/nivel.jpg"));
		atlNivel.setBounds(61, 0, 62, 59);
		getContentPane().add(atlNivel);

		JButton atlQuestao = new JButton("");
		atlQuestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarQuestao frame = new CadastrarQuestao();
				frame.setVisible(true);
				frame.setTitle("Cadastrar Questão");
			}
		});
		atlQuestao.setToolTipText("Cadastrar Questão");
		atlQuestao.setIcon(new ImageIcon("imagens/QQQ.jpg"));
		atlQuestao.setBounds(122, 0, 62, 59);
		getContentPane().add(atlQuestao);

		JButton atlProva = new JButton("");
		atlProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerarProva frame = new GerarProva();
				frame.setTitle("Gerar Prova");
				frame.setVisible(true);
			}
		});
		atlProva.setToolTipText("Criar Prova");
		atlProva.setIcon(new ImageIcon("imagens/PROVA.jpg"));
		atlProva.setBounds(182, 0, 62, 59);
		getContentPane().add(atlProva);
	}

	@SuppressWarnings("unused")
	private static void addPopup(final Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

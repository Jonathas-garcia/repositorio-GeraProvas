package br.edu.unicid.view.Questao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.QuestaoDAO;

public class InativarQuestao extends JFrame {
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabela;
	private JButton btnExcluir;
	private JButton btnExibir;
	private JButton apagar;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblCa;
	private JTextField textField_1;
	private JButton btnPesquisar;
	private String caAl;
	private String nomeAluno;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InativarQuestao frame = new InativarQuestao();
					frame.setVisible(true);
					frame.setTitle("Inativar Questao");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InativarQuestao() {
		// montar janela
		tabela = new JTable(modelo);
		JScrollPane barraRoll = new JScrollPane(tabela);
		modelo.addColumn("COD");
		modelo.addColumn("PERGUNTA");
		modelo.addColumn("ASSUNTO");
		modelo.addColumn("NIVEL");
		modelo.addColumn("DATA");

		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
		setBounds(100, 100, 853, 541);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 10, 817, 448);
		contentPane.add(scrollPane);

		btnExcluir = new JButton("Inativar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int cod = (int) tabela.getValueAt(linhaSelecionada, 0);
					try {
						QuestaoDAO dao = new QuestaoDAO();
						dao.inativar(cod);
						modelo.removeRow(linhaSelecionada);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA");
				}
			}
		});
		btnExcluir.setBounds(738, 469, 89, 23);
		contentPane.add(btnExcluir);

		btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int cod = (int) tabela.getValueAt(linhaSelecionada, 0);
					try {
						ExibirQuestao frame = new ExibirQuestao();
						QuestaoDAO dao = new QuestaoDAO();
						Questao questao = dao.exibirQuestao(cod);
						frame.testando(questao);
						frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA");
				}

			}
		});
		btnExibir.setBounds(639, 469, 89, 23);
		contentPane.add(btnExibir);

		apagar = new JButton("Filtro");
		apagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				pesquisar(modelo);
			}
		});
		apagar.setBounds(10, 469, 89, 23);
		//contentPane.add(apagar);
		
		
		
		modelo.setNumRows(0); // zerar as linhas da tabela
		try {
			QuestaoDAO dao = new QuestaoDAO();

			for (Questao c : dao.todasQuestoes()) {
				modelo.addRow(
						new Object[] { c.getCod(), c.getPergunta(), c.getAssunto(), c.getNivelDific(), c.getData() });

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// METODO QUE INSERE OS DADOS NA TABELA

	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0); // zerar as linhas da tabela
		try {
			QuestaoDAO dao = new QuestaoDAO();

			for (Questao c : dao.todasQuestoes()) {
				modelo.addRow(
						new Object[] { c.getCod(), c.getPergunta(), c.getAssunto(), c.getNivelDific(), c.getData() });

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	
	
}

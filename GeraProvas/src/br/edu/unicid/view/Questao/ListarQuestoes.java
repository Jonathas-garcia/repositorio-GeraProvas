package br.edu.unicid.view.Questao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;
import br.edu.unicid.dao.QuestaoDAO;

public class ListarQuestoes extends JFrame {
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabela;
	private JButton btnEditar;
	private JButton btnExibir;
	private JButton btnFiltro;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblCa;
	private JTextField textField_1;
	private JButton btnPesquisar;
	private String caAl;
	private String nomeAluno;
	private JButton voltar;
	private JButton pesquisar;
	public String pesquisa;
	public static void main(String[] args) {

		ListarQuestoes frame = new ListarQuestoes();
		frame.setVisible(true);

	}

	public ListarQuestoes() {

		// montar janela
		tabela = new JTable(modelo);
		JScrollPane barraRoll = new JScrollPane(tabela);
		modelo.addColumn("COD");
		modelo.addColumn("PERGUNTA");
		modelo.addColumn("ASSUNTO");
		modelo.addColumn("NIVEL");
		modelo.addColumn("DATA");
		modelo.addColumn("X ULTILIZADA");

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

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhaSelecionada = -1;
				linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int cod = (int) tabela.getValueAt(linhaSelecionada, 0);
					
					try {
						
						QuestaoDAO dao = new QuestaoDAO();
						Questao questao2 = dao.tabelaExclui(cod);
						String tipo = questao2.getTipo();
						String tipoChar = tipo.substring(0, 1);
						if (tipoChar.equals("D")){
							AlterarQuestaoDissertativa frame = new AlterarQuestaoDissertativa();
							Questao questao = dao.exibirQuestaoDissertativa(cod);
							frame.testando(questao);
							frame.setVisible(true);
							frame.setTitle("Alterar Questao");
						}
						else {
							AlterarQuestao frame = new AlterarQuestao();
							Questao questao = dao.exibirQuestao(cod);
							frame.testando(questao);
							frame.setVisible(true);
							frame.setTitle("Alterar Questao");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA");
				}

			}
		});
		btnEditar.setBounds(639, 469, 89, 23);
		contentPane.add(btnEditar);

		btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int cod = (int) tabela.getValueAt(linhaSelecionada, 0);
					
					try {
						
						QuestaoDAO dao = new QuestaoDAO();
						Questao questao2 = dao.tabelaExclui(cod);
						String tipo = questao2.getTipo();
						String tipoChar = tipo.substring(0, 1);
						if (tipoChar.equals("D")){
							ExibirQuestaoDissertativa frame = new ExibirQuestaoDissertativa();
							Questao questao = dao.exibirQuestaoDissertativa(cod);
							frame.testando(questao);
							frame.setVisible(true);
							frame.setTitle("Questao");
						}
						else {
						ExibirQuestao frame = new ExibirQuestao();
						Questao questao = dao.exibirQuestao(cod);
						frame.testando(questao);
						frame.setVisible(true);
						frame.setTitle("Questao");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA");
				}
			}

		});
		btnExibir.setBounds(534, 469, 89, 23);
		contentPane.add(btnExibir);

		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		voltar.setBounds(740, 471, 89, 23);
		contentPane.add(voltar);

		pesquisar = new JButton("Pesquisar");
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janelaPesquisar();

			}
		});
		pesquisar.setBounds(10, 469, 89, 23);
		contentPane.add(pesquisar);

		// METODO QUE INSERE OS DADOS NA TABELA

	}
	
	public void janelaPesquisar() {
		JFrame frame3 = new JFrame();
		frame3.setVisible(true);
		frame3.setTitle("Filtro de Questões");
		frame3.setResizable(false);
		frame3.setLayout(null);
		frame3.setSize(272, 336);
		frame3.setLocation(100, 100);

		JComboBox nivel = new JComboBox();
		nivel.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		nivel.setBounds(10, 79, 232, 22);
		contentPane.add(nivel);

		JComboBox assunto = new JComboBox();
		assunto.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		assunto.setBounds(10, 157, 232, 22);
		try {
			AssuntoDAO dao = new AssuntoDAO();
			for (Assunto a : dao.listarAssuntos()) {
				assunto.addItem(a.getTexto());
			}

			NivelDificuldadeDAO dao2 = new NivelDificuldadeDAO();
			for (NivelDificuldade n : dao2.listarNiveis()) {
				nivel.addItem(n.getTexto());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		contentPane.add(assunto);

		JLabel lblNewLabel = new JLabel("Selecione um Assunto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 122, 168, 16);
		contentPane.add(lblNewLabel);

		JTextField dataInicial = new JTextField();
		dataInicial.setBounds(10, 226, 86, 20);
		
		contentPane.add(dataInicial);
		dataInicial.setColumns(10);

		JLabel label_1 = new JLabel("\u00E1");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(122, 226, 24, 16);
		contentPane.add(label_1);

		JTextField dataFinal = new JTextField();
		dataFinal.setColumns(10);
		
		dataFinal.setBounds(156, 226, 86, 20);
		contentPane.add(dataFinal);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataI = dataInicial.getText();
				String dataF = dataFinal.getText();
		
				String valorNivel = (String) nivel.getSelectedItem();
				String valorAssunto = (String) assunto.getSelectedItem();
				System.out.println("tfyutf" + dataF);	
			
				
				
				if (dataI.length() == 10 || dataF.length() == 10  ){
					if (valorNivel == "Todos" && valorAssunto != "Todos") {
						pesquisa = "SELECT cod ,pergunta assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND assunto = \""
								+ valorAssunto + "\" AND data BETWEEN ('"+dataI +"') AND ('"+dataF +"') ";
							
					}
	
					else if (valorAssunto == "Todos" && valorNivel != "Todos") {
						pesquisa = "SELECT cod ,pergunta assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND nivelDific = \""
								+ valorNivel + "\" AND data BETWEEN ('"+dataI +"') AND ('"+dataF +"') ";
						filtro(pesquisa);
						frame3.setVisible(false);
					}
	
					else if (valorAssunto != "Todos" && valorNivel != "Todos") {
						pesquisa = "SELECT cod ,pergunta assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND nivelDific =\""
								+ valorNivel + "\" AND assunto=\"" + valorAssunto + "\" AND data BETWEEN ('"+dataI +"') AND ('"+dataF +"') ";
						filtro((pesquisa));
						frame3.setVisible(false);
	
					} else if (valorAssunto == "Todos" && valorNivel == "Todos") {
						pesquisa = "SELECT cod ,pergunta assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND data BETWEEN ('"+dataI +"') AND ('"+dataF +"') ";
						filtro((pesquisa));
						frame3.setVisible(false);
					}
					
				}
				
				else if (dataI.equals("") && dataF.equals("")) {
					
					/*if (res1 == "Todos" && res2 != "Todos") {
						pesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND assunto = \""
								+ res2 + "\"";
							
					}
	
					else if (res2 == "Todos" && res1 != "Todos") {
						pesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND nivelDific = \""
								+ res1 + "\"";
						filtrarQuestoes(pesquisa);
						frame3.setVisible(false);
					}
	
					else if (res2 != "Todos" && res1 != "Todos") {
						pesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND nivelDific =\""
								+ res1 + "\" AND assunto=\"" + res2 + "\"";
						filtrarQuestoes(pesquisa);
						frame3.setVisible(false);
	
					} else if (res2 == "Todos" && res1 == "Todos") {
						pesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1  ";
						filtrarQuestoes(pesquisa);
						frame3.setVisible(false);
					}*/
					
					
					if (valorNivel.equals("Todos") && !valorAssunto.equals("Todos")) {
						pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND assunto = \"" + valorAssunto + "\"";
					}

					else if(valorAssunto.equals("Todos") && !valorNivel.equals("Todos")) {
						pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific = \"" + valorNivel + "\"";
					}

					else if (!valorAssunto.equals("Todos") && !valorNivel.equals("Todos")) {
						pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific =\"" + valorNivel + "\" AND assunto=\""
								+ valorAssunto + "\"";

					} else if (valorAssunto.equals("Todos") && valorNivel.equals("Todos")){
						pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1";
						System.out.println("cheg");
					}
					
				}


				else {
					JOptionPane.showMessageDialog(null, "FORMATO DA DATA DEVE SER: 00/00/0000");
				}
				
				filtro((pesquisa));
				frame3.setVisible(false);

				
			}
		});
		btnListar.setBounds(149, 263, 97, 25);
		contentPane.add(btnListar);

		JLabel lblSelecioneUmNivel = new JLabel("Selecione um Nivel");
		lblSelecioneUmNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecioneUmNivel.setBounds(65, 38, 139, 16);
		contentPane.add(lblSelecioneUmNivel);

		JButton btnVoltarPesquisa = new JButton("Voltar");
		btnVoltarPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3.setVisible(false);
			}
		});
		btnVoltarPesquisa.setBounds(10, 264, 89, 23);
		contentPane.add(btnVoltarPesquisa);

		JLabel lblDataDeCadastro = new JLabel(
				"Periodo de cadastro  da  quest\u00E3o");
		lblDataDeCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDeCadastro.setBounds(10, 199, 232, 16);
		contentPane.add(lblDataDeCadastro);

		

		frame3.getContentPane().add(lblSelecioneUmNivel);
		frame3.getContentPane().add(btnVoltarPesquisa);
		frame3.getContentPane().add(lblDataDeCadastro);
		frame3.getContentPane().add(dataInicial);
		frame3.getContentPane().add(label_1);
		frame3.getContentPane().add(dataFinal);
		frame3.getContentPane().add(nivel);
		frame3.getContentPane().add(assunto);
		frame3.getContentPane().add(btnListar);
		frame3.getContentPane().add(lblNewLabel);

	}
	
	

	public void filtro(String pesquisa) {
		System.out.println(pesquisa);
		modelo.setNumRows(0);
		try {
			QuestaoDAO dao = new QuestaoDAO();
			for (Questao c : dao.filtrarQuestaoEditar(pesquisa)) {
				modelo.addRow(
						new Object[] { c.getCod(), c.getPergunta(), c.getAssunto(), c.getNivelDific(), c.getData(),c.getQtdUtilidzada() });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

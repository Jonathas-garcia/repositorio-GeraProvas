package br.edu.unicid.view.Prova;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;
import br.edu.unicid.dao.QuestaoDAO;
import br.edu.unicid.view.Questao.ExibirQuestao;
import br.edu.unicid.view.Questao.ExibirQuestaoDissertativa;

public class Prova extends JFrame {
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloRemove;
	private JTable tabelaRemove;
	private JTable tabela;
	private JButton btnExibir;
	private JButton apagar;
	private JButton voltar;
	private JButton teste;

	// TELA PESQUISA

	public String pesquisa;

	ArrayList<Integer> i = new ArrayList<>(); // CONTADOR DE QUESTOES
	ArrayList<Integer> vetorRemonta = new ArrayList<>(); // para remontar
	int j = 0;// CONTROLA ONDE O CODIGO DA QUESTAO SERA SALVO NO VETOR
	int quantidadeQuestoes = -1; // CONTROLA A QUANTIDADE DE QUESTOES NA PROVA
	int atualizaQtd = 0; // mostra a quantidade de questoes que foram
							// selecionadas
	int controlaColunas = 0;// CONTROLAR COLUNAS DA TABELA
							// REMOVE
	private JButton btnNewButton;

	private JTextField qtdSelecionada;

	public static void main(String[] args) {
		try {
			// DEFINE OS COMPONENTES GRÁFICOS COM O TEMA DO WINDOWS
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		Prova frame = new Prova();
		frame.setVisible(true);
		frame.setTitle("Criar Prova");

	}

	public Prova() {
		
		modeloRemove = new DefaultTableModel(){

			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		modelo = new DefaultTableModel(){

			@Override
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		// montar janela
		tabela = new JTable(modelo);
		 
		modelo.addColumn("COD");
		modelo.addColumn("PERGUNTA");
		modelo.addColumn("TIPO");
		modelo.addColumn("ASSUNTO");
		modelo.addColumn("NIVEL");
		modelo.addColumn("DATA");
		modelo.addColumn("QTD. UTILIZADA ");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);

		setBounds(100, 100, 853, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 10, 817, 448);
		contentPane.add(scrollPane);

		qtdSelecionada = new JTextField();
		qtdSelecionada.setBounds(293, 470, 39, 20);
		contentPane.add(qtdSelecionada);
		qtdSelecionada.setColumns(10);

		btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int cod = (int) tabela.getValueAt(linhaSelecionada, 0);
					String tipo = (String) tabela.getValueAt(linhaSelecionada, 2);
					String tipoChar = tipo.substring(0, 1);
					try {
						
						QuestaoDAO dao = new QuestaoDAO();
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
		btnExibir.setBounds(639, 469, 89, 23);
		contentPane.add(btnExibir);

		apagar = new JButton("Pesquisar");
		apagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				janelaPesquisar();
			}
		});
		apagar.setBounds(10, 469, 89, 23);
		contentPane.add(apagar);

		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		voltar.setBounds(738, 469, 89, 23);
		contentPane.add(voltar);

		teste = new JButton("Selecionar");
		teste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			
				
				int linhaSelecionada = -1;
				linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada >= 0) {
					
					
					int cod = (int) tabela.getValueAt(linhaSelecionada, 0);
					try {
						ExibirQuestao frame = new ExibirQuestao();
						QuestaoDAO dao = new QuestaoDAO();
						Questao questao = dao.exibirQuestao(cod);

						int a = questao.getCod();
						if(i.contains(a)){
							JOptionPane.showMessageDialog(null, "Questão já adicionada");
						}
						else {
							atualizaQtd++;
							qtdSelecionada.setText(Integer.toString(atualizaQtd));
							i.add(a);
							j++;
							quantidadeQuestoes++;
							modelo.removeRow(linhaSelecionada);
							
							
							
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					
					JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA");
					
				}

			}
		});
		teste.setBounds(441, 469, 89, 23);
		contentPane.add(teste);

		btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					int codAdiciona;
					QuestaoDAO dao = new QuestaoDAO();
					for (int z = 0; z < i.size(); z++){
			
					Questao questaoAux = dao.tabelaExclui(i.get(z));
					String charAT = questaoAux.getTipo().substring(0, 1);
					codAdiciona = questaoAux.getCod();
					if (charAT.equals("D")){
						i.remove(z);
						i.add(codAdiciona);
						}
					}
					
					ConfirmaProva frame = new ConfirmaProva();
					frame.setVisible(true);
					frame.exibir(i, quantidadeQuestoes);
					frame.pesquisar(i, quantidadeQuestoes);
					frame.retornaCodigo(i, quantidadeQuestoes);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		btnNewButton.setBounds(342, 469, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("O i esta composto por :  " + i); // mesmo ele tendo valores nao esta funcionando
				removerQuestao();
				excluiQuestaoSelecionada(i, quantidadeQuestoes);

			}
		});
		btnRemover.setBounds(540, 469, 89, 23);
		contentPane.add(btnRemover);

		JLabel lblQtdSelecionada = new JLabel("Qtd Selecionada:");
		lblQtdSelecionada.setBounds(194, 473, 89, 14);
		contentPane.add(lblQtdSelecionada);
	}

	// METODO QUE INSERE OS DADOS NA TABELA

	public void excluiQuestaoSelecionada(ArrayList<Integer> i,
			int quantidadeQuestoes) {
		modeloRemove.setNumRows(0); // zerar as linhas da tabela
		try {
			QuestaoDAO dao = new QuestaoDAO();

			for (int d = 0; d <= quantidadeQuestoes; d++) {
				Questao questao = dao.tabelaExclui(i.get(d));
				modeloRemove.addRow(new Object[] { questao.getCod(), questao.getPergunta(),
						questao.getTipo(), questao.getAssunto(), questao.getNivelDific(),
						questao.getData(), questao.getQtdUtilidzada() });

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// JANELA REMOVE QUESTAO

	public void removerQuestao() {

		JFrame frame2 = new JFrame();
		frame2.setTitle("Remover Questão");
		frame2.setVisible(true);

		frame2.setLayout(null);

		frame2.setBounds(0, 0, 853, 534);

		if (controlaColunas == 0) { // a tela de remover tem que criar uma
									// tabela pra ela
			
			
			tabelaRemove = new JTable(modeloRemove);

			modeloRemove.addColumn("COD");
			modeloRemove.addColumn("PERGUNTA");
			modeloRemove.addColumn("TIPO");
			modeloRemove.addColumn("ASSUNTO");
			modeloRemove.addColumn("NIVEL");
			modeloRemove.addColumn("DATA");
			modeloRemove.addColumn("QTD. UTILIZADA");
			tabelaRemove.getColumnModel().getColumn(0).setPreferredWidth(30);
			tabelaRemove.getColumnModel().getColumn(1).setPreferredWidth(300);
			tabelaRemove.getColumnModel().getColumn(2).setPreferredWidth(100);
			setBounds(100, 100, 853, 534);
		}

		JScrollPane scrollPaneRemover = new JScrollPane(tabelaRemove);
		scrollPaneRemover.setBounds(10, 10, 817, 448);
		frame2.getContentPane().add(scrollPaneRemover);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = tabelaRemove.getSelectedRow();
				if (linhaSelecionada >= 0) {

					int cod = (int) tabelaRemove
							.getValueAt(linhaSelecionada, 0);

					for (int controla = 0; controla < +i.size(); controla++) {
						if (i.get(controla) == cod) {
							i.remove(controla);
							JOptionPane.showMessageDialog(null,	"Questao Removida");
							modeloRemove.removeRow(linhaSelecionada);
							quantidadeQuestoes--;
							atualizaQtd--;
							qtdSelecionada.setText(Integer
									.toString(atualizaQtd));
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA");
					atualizaQtd++;
					
				}
			}
		});

		btnRemover.setBounds(639, 469, 89, 23);
		frame2.getContentPane().add(btnRemover);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
			}
		});

		btnVoltar.setBounds(738, 469, 89, 23);
		frame2.getContentPane().add(btnVoltar);

		controlaColunas++;
	}

	// janela pesuisar ----------------------------------------
	
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
						pesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND assunto = \""
								+ valorAssunto + "\" AND data BETWEEN ('"+dataI +"') AND ('"+dataF +"') ";
							
					}
	
					else if (valorAssunto == "Todos" && valorNivel != "Todos") {
						pesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND nivelDific = \""
								+ valorNivel + "\" AND data BETWEEN ('"+dataI +"') AND ('"+dataF +"') ";
						filtrarQuestoes(pesquisa);
						frame3.setVisible(false);
					}
	
					else if (valorAssunto != "Todos" && valorNivel != "Todos") {
						pesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND nivelDific =\""
								+ valorNivel + "\" AND assunto=\"" + valorAssunto + "\" AND data BETWEEN ('"+dataI +"') AND ('"+dataF +"') ";
						filtrarQuestoes(pesquisa);
						frame3.setVisible(false);
	
					} else if (valorAssunto == "Todos" && valorNivel == "Todos") {
						pesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND data BETWEEN ('"+dataI +"') AND ('"+dataF +"') ";
						filtrarQuestoes(pesquisa);
						frame3.setVisible(false);
					}
					
				}
				
				else if (dataI.equals("") && dataF.equals("")) {
					
							
					
					if (valorNivel.equals("Todos") && !valorAssunto.equals("Todos")) {
						pesquisa = "SELECT `cod`, `pergunta`, `tipo`,`assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND assunto = \"" + valorAssunto + "\"";
					}

					else if(valorAssunto.equals("Todos") && !valorNivel.equals("Todos")) {
						pesquisa = "SELECT `cod`, `pergunta`,`tipo`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific = \"" + valorNivel + "\"";
					}

					else if (!valorAssunto.equals("Todos") && !valorNivel.equals("Todos")) {
						pesquisa = "SELECT `cod`, `pergunta`, `tipo`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific =\"" + valorNivel + "\" AND assunto=\""
								+ valorAssunto + "\"";

					} else if (valorAssunto.equals("Todos") && valorNivel.equals("Todos")){
						pesquisa = "SELECT `cod`, `pergunta`,`tipo`,  `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1";
						System.out.println("cheg");
					}
					
				}


				else {
					JOptionPane.showMessageDialog(null, "FORMATO DA DATA DEVE SER: 00/00/0000");
				}
				
				filtrarQuestoes(pesquisa);
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

	public void filtrarQuestoes(String pesquisa) {
		modelo.setNumRows(0);
		System.out.println(pesquisa);
		try {
			QuestaoDAO dao = new QuestaoDAO();
			for (Questao c : dao.filtrarQuestoesProva(pesquisa)) {
				modelo.addRow(new Object[] { c.getCod(), c.getPergunta(),
						c.getTipo(), c.getAssunto(), c.getNivelDific(),
						c.getData(), c.getQtdUtilidzada() });
			} // alterar a data para a data da ultima vez que foi ultilizada

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void remontar(ArrayList<Integer> remontarProva){
		
		i = remontarProva; //TRAZ DE VOLTA OS VALORES JÁ ADICIONADOS - PARA TESTAR EXECUTE PROVA , ADICIONE QUESTOES, CLIQUE EM SALVAR,
							//NA NOVA TELA CLIQUE EM REMONTAR, AGORA TENTE REMOVER ALGUMA QUESTAO , A TABELA NAO IRA APRESENTAR
							//NENHUM VALOR , MAIS NO CONSOLE IFORMARA QUE O ARRAY i TEM VALORES ADICIONADOS.
		atualizaQtd = atualizaQtd + remontarProva.size();
		qtdSelecionada.setText(Integer.toString(atualizaQtd)); // ATUALIZA A TELA DE QUANTIDADE
		
	}

}

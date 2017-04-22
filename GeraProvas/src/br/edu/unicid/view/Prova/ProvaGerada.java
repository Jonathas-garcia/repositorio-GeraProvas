package br.edu.unicid.view.Prova;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.QuestaoDAO;
import br.edu.unicid.view.Telas;
import br.edu.unicid.view.Questao.ExibirQuestao;

public class ProvaGerada extends JFrame {
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloRemove;
	private JTable tabelaRemove;
	private JTable tabela;
	private JButton btnExibir;
	private JButton voltar;
	private String textoPesquisa;
	private String textoAssunto;
	private String textoNivel;
	int quantidadeQuestoes;
	int quantidadeDissertativa;
	// TELA PESQUISA



	ArrayList<Integer> i = new ArrayList<>(); // CONTADOR DE QUESTOES
	

	public static void main(String[] args) {
		try {
			// DEFINE OS COMPONENTES GRÁFICOS COM O TEMA DO WINDOWS
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		
		ProvaGerada frame = new ProvaGerada();
		frame.setVisible(true);
		frame.setTitle("Criar Prova");

	}

	public ProvaGerada() {
	
		
		
		
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
						frame.setTitle("Questao");
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

		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
			}
		});
		voltar.setBounds(738, 469, 89, 23);
		contentPane.add(voltar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = tabela.getSelectedRow();
				tabela.removeRowSelectionInterval(linhaSelecionada, 0);
			

			}
		});
		btnRemover.setBounds(540, 469, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// instancia um objeto da classe Randon para gerar um numero
				Random gerador = new Random();
				// declaracao de variaveis
				int qtdOptativa = quantidadeQuestoes - quantidadeDissertativa;
				int auxDissertativa = 0;
				int numero;
				int cod;
				int somaLinhas;
				int linhasTabela = modelo.getRowCount();
				String tipo;
				String compara;
				//contar quantas dissertativas temos na tabela
				for (int c = 1; c < linhasTabela; c++){
					String auxS = (String) modelo.getValueAt(c, 2);
					String auxC = auxS.substring(0, 1);
					if (auxC.equals("D")){
					auxDissertativa++;
					}
				}
				
				
				if(quantidadeQuestoes>linhasTabela){
					JOptionPane.showMessageDialog(null, "A quantidade de questões é insuficiente");
					setVisible(false);
				
					Telas frame = new Telas();
					frame.setVisible(true);
				}
				
				else if(auxDissertativa < quantidadeDissertativa){
					JOptionPane.showMessageDialog(null, "A quantidade de questões dissertativas é insuficiente");
					setVisible(false);
					Telas frame = new Telas();
					frame.setVisible(true);
				}
				
				else {
					
				
					for (int aux = 0; aux < quantidadeQuestoes; ){
						somaLinhas = modelo.getRowCount(); //pega a quantidade de linhas da coluna
						numero = gerador.nextInt(somaLinhas);// escolhe um numero aleatorio de 0 ate o valor total de linhas
						cod = (int) tabela.getValueAt(numero, 0);// seleciona uma questao a partir do numero aletorio
						tipo = (String) modelo.getValueAt(numero, 2);// pega o tipo de questao que foi selecionada
						compara = tipo.substring(0, 1);// pega o primeiro caracter do tipo de questao
						
						
						if (compara.equals("O") && qtdOptativa> 0){//se a questao e optativa, adiciona ao array de questoes
							i.add(cod);
							qtdOptativa--;
							modelo.removeRow(numero);
							aux++;
							
						
							}
						
						else if (compara.equals("D") && quantidadeDissertativa > 0){//se e optativa adciona
							i.add(cod);
							modelo.removeRow(numero);
							aux++;
							quantidadeDissertativa--;
							
							}
						else{              //se a questao randominaza for optativa e o limite de optativa ja tiver sido 
											//atingido, ele exclui e prosegue com a selecao
				
							modelo.removeRow(numero);
							
						}
					}
				
				try { 
					quantidadeQuestoes--;
							int codAdiciona;
							QuestaoDAO dao = new QuestaoDAO();
							for (int z = 0; z < i.size(); z++){
					
							Questao questao = dao.tabelaExclui(i.get(z));
							String charAT = questao.getTipo().substring(0, 1);
							codAdiciona = questao.getCod();
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
				
				setVisible(false);
			}
				
			
				
			
		});
		btnGerar.setBounds(432, 469, 89, 23);
		contentPane.add(btnGerar);
		
	
		if(quantidadeQuestoes>0){
			JOptionPane.showMessageDialog(null, "message");
			}	
		}


	
		
		
	



		

	public void pesquisaGerada(String assuntosSalvos , ArrayList<String> niveisSalvos, int qtdUtilizada, int qtdQuestoes, int qtdDissertativas) {
		quantidadeQuestoes = qtdQuestoes;
		quantidadeDissertativa = qtdDissertativas;
		
		
		String txtAssunto = assuntosSalvos;
		
		for (int h = 0; h < niveisSalvos.size(); h++){
			textoNivel = niveisSalvos.get(h);
			textoPesquisa = "SELECT cod ,pergunta ,tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE estatus = 1 AND qtdUtilizada <= "+ qtdUtilizada + " AND assunto =  \"" + txtAssunto+ "\"  AND nivelDific =  \"" + textoNivel+ "\"";		

		try {
			QuestaoDAO dao = new QuestaoDAO();
			for (Questao c : dao.filtrarQuestoes2(textoPesquisa)) {
				modelo.addRow(new Object[] { c.getCod(), c.getPergunta(),
						c.getTipo(), c.getAssunto(), c.getNivelDific(),
						c.getData(), c.getQtdUtilidzada() });		
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
		
	
		
	
		
	}
	
}

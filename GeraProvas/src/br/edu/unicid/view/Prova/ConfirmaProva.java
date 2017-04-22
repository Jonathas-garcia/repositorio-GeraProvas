package br.edu.unicid.view.Prova;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.QuestaoDAO;

public class ConfirmaProva extends JFrame {

	private DefaultTableModel modelo;
	private JPanel contentPane;
	private JTable tabela;
	private TextArea textArea;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	private JButton btnRefazer;
	private JButton btnNewButton_1;
	private JButton btnSalvarProva;
	private JLabel lblConfirmarProva;
	private JTextField valorNomeProva;
	private JLabel lblTitulo;
	private JLabel lblTurma;
	private JTextField valorTurma;
	private JLabel lblDiaDaAplicao;
	private JTextField diaAplic;
	private JLabel lblListaDeQuestes;
	private JButton salvaPontuacao;
	private JLabel lblNotaDaProva;
	private JTextField notaProva;
	ArrayList<Integer> codigoQuestao = new ArrayList<>();
	ArrayList<Integer> remontarProva = new ArrayList<>();
	ArrayList<Double> notasQuestoes = new ArrayList<>();
	int quantidadeNotas;// auxilia o metodo de pegar o codigo ds questoes
	int aux = 0;
	static ConfirmaProva frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ConfirmaProva();
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
	public ConfirmaProva() {

		modelo = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int col) {
				if (col == 2) {
					return true;
				} else {
					return false;
				}
			}
		};

		tabela = new JTable(modelo);
		
		modelo.addColumn("PERGUNTA");
		modelo.addColumn("TIPO");
		modelo.addColumn("VALOR DA QUESTÃO");

		tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(50);

		setBounds(100, 100, 978, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new TextArea();
		textArea.setBounds(10, 44, 456, 414);
		contentPane.add(textArea);

		scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(482, 44, 480, 297);
		contentPane.add(scrollPane);

		btnRefazer = new JButton("Remontar");
		btnRefazer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				remontarProva = codigoQuestao;// CRIA UM ARRAY AUXILIAR PARA USAR DE PARAMETRO
				Prova remontar = new  Prova();
				remontar.remontar(remontarProva); // METODO DA CLASSE PROVA COPIA PARA I OS VALORES JA ADICIONADOS
				remontar.setVisible(true);
				setVisible(false);
			}
		});
		btnRefazer.setBounds(10, 493, 99, 23);
		contentPane.add(btnRefazer);

		btnNewButton_1 = new JButton("Gerar Gabarito");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame();
				frame.setVisible(true);
				frame.setResizable(false);
				frame.getContentPane().setLayout(null);
				frame.setSize(334, 419);
				frame.setLocation(100, 100);

				TextArea textGabarito = new TextArea();
				JScrollPane scr = new JScrollPane(textGabarito);
				textGabarito.setBounds(10, 36, 298, 290);
				// textGabarito.setLineWrap(true);
				frame.getContentPane().add(textGabarito);

				try {
					QuestaoDAO dao = new QuestaoDAO();
					for (int a = 0; a <= codigoQuestao.size()-1; a++) {
						Questao questao = dao.previaProva(codigoQuestao.get(a));

						System.out.println(questao.getTipo());

						if (questao.getTipo().equalsIgnoreCase("Dissertativa")) {
							System.out.println("Entrou dissertativa");
							textGabarito.append("\nQuestao Dissertativa: " + (a + 1) + "\n");
							textGabarito.append("\n");
							textGabarito.append("Resposta Esperada: " + questao.getRespEsperada());
							textGabarito.append("\n");

						} else if (questao.getTipo().equalsIgnoreCase("optativa/Imagem")) {
							System.out.println("if(questao.getImgAltA()!=null){");
							textGabarito.append("\nQuestao: " + (a + 1) + "\n");
							textGabarito.append(questao.getPergunta());
							textGabarito.append("\n");
							textGabarito.append("Alternativa: " + questao.getAltCorreta());
							textArea.append("\n");
						} else if (questao.getTipo().equalsIgnoreCase("optativa")) {
							System.out.println(" questao.getTipo().equalsIgnoreCase(optativa)");
							textGabarito.append("\nQuestao: " + (a + 1) + "\n");
							textGabarito.append(questao.getPergunta());
							textGabarito.append("\n");
							textGabarito.append("Alternativa: " + questao.getAltCorreta());
							textGabarito.append("\n");
						} else if (questao.getTipo().equalsIgnoreCase("dissertativa/Imagem")) {
							System.out.println("else");
							textGabarito.append("\nQuestao: " + (a + 1) + "\n");
							textGabarito.append("IMAGEM");

							textGabarito.append("\n");
							textGabarito.append("\n");
						}

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Button salvarGabarito = new Button("Gerar");
				salvarGabarito.setBounds(121, 349, 70, 22);
				salvarGabarito.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Questao questao = null;
						ArrayList<Questao> questoes = new ArrayList<>();
						try {
							QuestaoDAO dao = new QuestaoDAO();
							for (int a = 0; a <= codigoQuestao.size() - 1; a++) {
								questao = dao.previaProva(codigoQuestao.get(a));
								questoes.add(questao);
							}
							gerarPDFGabarito(questoes);
						

						} catch (Exception f) {
							f.printStackTrace();
						}
						frame.setVisible(false);
					}
					
				});
				frame.getContentPane().add(salvarGabarito);

				JLabel lblGabarito = new JLabel("Gabarito");
				lblGabarito.setFont(new Font("Tunga", Font.PLAIN, 21));
				lblGabarito.setBounds(121, 11, 187, 14);
				frame.getContentPane().add(lblGabarito);

				btnSalvarProva.setEnabled(true);
			}
		});
		btnNewButton_1.setBounds(714, 493, 119, 23);
		contentPane.add(btnNewButton_1);

		btnSalvarProva = new JButton("Salvar Prova");
		btnSalvarProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questao questao = null;
				ArrayList<Questao> questoes = new ArrayList<>();
				try {
					QuestaoDAO dao = new QuestaoDAO();
					for (int a = 0; a <= codigoQuestao.size() - 1; a++) {
						questao = dao.previaProva(codigoQuestao.get(a));
						questoes.add(questao);
					}
					gerarPDF(questoes);
				

				} catch (Exception f) {
					f.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnSalvarProva.setEnabled(false);
		btnSalvarProva.setBounds(843, 493, 119, 23);
		contentPane.add(btnSalvarProva);

		lblConfirmarProva = new JLabel("Previa");
		lblConfirmarProva.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirmarProva.setBounds(205, 11, 240, 14);
		contentPane.add(lblConfirmarProva);

		valorNomeProva = new JTextField();
		valorNomeProva.setBounds(579, 402, 373, 20);
		contentPane.add(valorNomeProva);
		valorNomeProva.setColumns(10);

		lblTitulo = new JLabel("Nome da Prova:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTitulo.setBounds(472, 404, 94, 14);
		contentPane.add(lblTitulo);

		lblTurma = new JLabel(" Turma:");
		lblTurma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTurma.setBounds(472, 444, 97, 14);
		contentPane.add(lblTurma);

		valorTurma = new JTextField();
		valorTurma.setBounds(614, 438, 108, 20);
		contentPane.add(valorTurma);
		valorTurma.setColumns(10);

		lblDiaDaAplicao = new JLabel("Dia da Aplica\u00E7\u00E3o:");
		lblDiaDaAplicao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaDaAplicao.setBounds(732, 444, 119, 14);
		contentPane.add(lblDiaDaAplicao);

		diaAplic = new JTextField();
		diaAplic.setColumns(10);
		diaAplic.setBounds(844, 438, 108, 20);
		contentPane.add(diaAplic);

		lblListaDeQuestes = new JLabel("Lista de Quest\u00F5es Selecionadas");
		lblListaDeQuestes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblListaDeQuestes.setBounds(595, 19, 293, 14);
		contentPane.add(lblListaDeQuestes);

		salvaPontuacao = new JButton("Salvar Pontuac\u00E3o");
		salvaPontuacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double c = 0.0;
				String a = "";
				double[] vetorNotas = new double[25];
				double notaTotal = 0.0;

				for (int j = 0; j <= quantidadeNotas; j++) {

					a = (String) modelo.getValueAt(j, 2);
					notasQuestoes.add(Double.parseDouble((String) modelo.getValueAt(j, 2)));
					System.out.println(modelo.getValueAt(j, 2));
					c = Double.parseDouble(a);
					vetorNotas[j] = c;
					notaTotal = c + notaTotal;
					System.out.println("valor do J: " + j);
				}

				try {
					int codigo = 0;
					double notaQuestao = 0;
					for (int foi = 0; foi <= quantidadeNotas; foi++) {
						codigo = codigoQuestao.get(foi);
						notaQuestao = vetorNotas[foi];
						QuestaoDAO dao = new QuestaoDAO();
						dao.guardaNota(codigo, notaQuestao);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Notas Salvas");

				notaProva.setText(String.valueOf(notaTotal));

			}
		});
		salvaPontuacao.setBounds(833, 352, 119, 23);
		contentPane.add(salvaPontuacao);

		lblNotaDaProva = new JLabel("Nota Geral:");
		lblNotaDaProva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNotaDaProva.setBounds(472, 356, 94, 14);
		contentPane.add(lblNotaDaProva);

		notaProva = new JTextField();
		notaProva.setEditable(false);
		notaProva.setColumns(10);
		notaProva.setBounds(579, 352, 99, 20);
		contentPane.add(notaProva);

	}

	public void exibir(ArrayList<Integer> i, int quantidadeQuestoes) throws Exception {
		QuestaoDAO dao = new QuestaoDAO();
		quantidadeNotas = quantidadeQuestoes;

		try {
			for (int c = 0; c <= quantidadeQuestoes; c++) {
				Questao questao = dao.previaProva(i.get(c));
				System.out.println(questao.getTipo());

				if (questao.getTipo().equalsIgnoreCase("Dissertativa")) {
					System.out.println("Entrou dissertativa");
					textArea.append("\nQuestao Dissertativa: " + (c + 1) + "\n");
					textArea.append(questao.getPergunta());
					textArea.append("\n");
					textArea.append("Resposta Esperada: " + questao.getRespEsperada());
					textArea.append("\n");
					textArea.append("\n");

				} else if (questao.getTipo().equalsIgnoreCase("optativa/Imagem")) {
					System.out.println("if(questao.getImgAltA()!=null){");
					textArea.append("\nQuestao: " + (c + 1) + "\n");
					textArea.append(questao.getPergunta());
					textArea.append("\n");
					textArea.append("A: IMAGEM");
					textArea.append("\n");
					textArea.append("B: IMAGEM");
					textArea.append("\n");
					textArea.append("C: IMAGEM");
					textArea.append("\n");
					textArea.append("D: IMAGEM");
					textArea.append("\n");
					textArea.append("E: IMAGEM");
					textArea.append("\n");
					textArea.append("\n");
				} else if (questao.getTipo().equalsIgnoreCase("optativa")) {
					System.out.println(" questao.getTipo().equalsIgnoreCase(optativa)");
					textArea.append("\nQuestao: " + (c + 1) + "\n");
					textArea.append(questao.getPergunta());
					textArea.append("\n");
					textArea.append("A: " + questao.getAltA());
					textArea.append("\n");
					textArea.append("B: " + questao.getAltB());
					textArea.append("\n");
					textArea.append("C: " + questao.getAltC());
					textArea.append("\n");
					textArea.append("D: " + questao.getAltD());
					textArea.append("\n");
					textArea.append("E: " + questao.getAltE());
					textArea.append("\n");
					textArea.append("\n");
				} else if (questao.getTipo().equalsIgnoreCase("dissertativa/Imagem")) {
					System.out.println("else");
					textArea.append("\nQuestao: " + (c + 1) + "\n");
					textArea.append(questao.getPergunta());

					textArea.append("\n");
					textArea.append("\n");
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void pesquisar(ArrayList<Integer> i, int quantidadeQuestoes) {
		modelo.setNumRows(0); // zerar as linhas da tabela

		try {
			QuestaoDAO dao = new QuestaoDAO();

			for (int d = 0; d <= quantidadeQuestoes; d++) {
				if (i.get(d) >= 0) {
					Questao questao = dao.previaProva(i.get(d));
					modelo.addRow(

							new Object[] { questao.getPergunta(), questao.getTipo() });

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void retornaCodigo(ArrayList<Integer> i, int quantidadeQuestoes) {

		codigoQuestao = i;
	}

	@SuppressWarnings("unchecked")
	public void gerarPDF(ArrayList<Questao> questoes) throws Exception {
		String arquivo;
		FileDialog salvar;
		Document doc = null;
		FileOutputStream os = null;
		String nomeProva = valorNomeProva.getText();
		
		Collections.sort(questoes,  (o1, o2) -> {
			Questao q1 = (Questao) o1;
			Questao q2 = (Questao) o2;
			
			if(q1.getTipo().equalsIgnoreCase("dissertativa")||q1.getTipo().equalsIgnoreCase("dissertativa/imagem")){
				return 1;
				
			}else{
				return 0;
			}
			
		});
		
		
		salvar = new FileDialog(this, "Salvar", FileDialog.SAVE);
		salvar.setVisible(true);

		if (salvar.getFile() == null) {
			return;
		}
		arquivo = salvar.getDirectory() + salvar.getFile();

		try {
			
			doc = new Document(PageSize.A4);
			doc.setMargins(35, 35, 35, 35);
			os = new FileOutputStream(arquivo);

			PdfWriter.getInstance(doc, os);
			doc.open();
			
			
			com.itextpdf.text.Font f3= new com.itextpdf.text.Font(FontFamily.HELVETICA, 25, Font.BOLD);

			doc.add(new Paragraph("NOME:__________________________________________________ TURMA:__________"));
			doc.add(new Paragraph("CURSO:_________________________________________________ DATA:__________"));
			doc.add(new Paragraph("DISCIPLINA:____________________________________________PROFESSOR:__________\n\n\n\n\n\n\n\n\n\n\n\n\n"));
			Paragraph nome = new Paragraph(nomeProva.toUpperCase()+"\n\n", f3);
			nome.setAlignment(Element.ALIGN_CENTER);
			doc.add(nome);
			doc.newPage();
			com.itextpdf.text.Font f = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10, Font.PLAIN);
			com.itextpdf.text.Font f2 = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10, Font.BOLD);
			com.itextpdf.text.Font white = com.itextpdf.text.FontFactory.getFont(com.itextpdf.text.FontFactory.HELVETICA, 15, Font.BOLD, new com.itextpdf.text.BaseColor(com.itextpdf.text.BaseColor.WHITE.getRGB()));
			
			int numeroQuestao = 1;
			for (Questao questao : questoes) {
				
				
				//EXIBE OPTATIVA/IMAGEM
				if(questao.getTipo().equals("Optativa/imagem")){
					doc.newPage();
					PdfPTable table = new PdfPTable(1);
					PdfPCell header = new PdfPCell(new Paragraph(" QUESTÃO " +numeroQuestao + "    -    " + notasQuestoes.get(numeroQuestao-1).toString() + " PONTOS", white));
					numeroQuestao++;
					header.setBackgroundColor(BaseColor.GRAY);
					header.setBorderWidthBottom(4.0f);
					header.setBorderColor(BaseColor.GRAY);
					table.addCell(header);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					doc.add(table);
					
					
					doc.add(new Paragraph(questao.getPergunta() + "\n", f2));
					
					if(questao.getImgEnunciado()!=null){
						Image imgPergunta = Image.getInstance(questao.getImgEnunciado());
						imgPergunta.scaleAbsolute(75, 75);
						doc.add(imgPergunta);
					}
					
					Paragraph p1 = new Paragraph("(A) ", f2);
					Image imgAltA = Image.getInstance(questao.getImgAltA());
					imgAltA.scaleAbsolute(75, 75);
					doc.add(p1);
					doc.add(imgAltA);
					
					Paragraph p2 = new Paragraph("(B) ", f2);
					Image imgAltB = Image.getInstance(questao.getImgAltB());
					imgAltB.scaleAbsolute(75, 75);
					doc.add(p2);
					doc.add(imgAltB);
					
					Paragraph p3 = new Paragraph("(C) ", f2);
					Image imgAltC = Image.getInstance(questao.getImgAltC());
					imgAltC.scaleAbsolute(75, 75);
					doc.add(p3);
					doc.add(imgAltC);
					
					Paragraph p4 = new Paragraph("(D) ", f2);
					Image imgAltD = Image.getInstance(questao.getImgAltD());
					imgAltD.scaleAbsolute(75, 75);
					doc.add(p4);
					doc.add(imgAltD);
					
					Paragraph p5 = new Paragraph("(E) ", f2);
					Image imgAltE = Image.getInstance(questao.getImgAltE());
					imgAltE.scaleAbsolute(75, 75);
					doc.add(p5);
					doc.add(imgAltE);
					
					doc.add(new Paragraph("\n\n"));
					
				}
				//EXIBE OPTATIVA
				else if(questao.getTipo().equalsIgnoreCase("optativa")){
					PdfPTable table = new PdfPTable(1);
					PdfPCell header = new PdfPCell(new Paragraph(" QUESTÃO " +numeroQuestao + "    -    " + notasQuestoes.get(numeroQuestao-1).toString()+ " PONTOS", white));
					numeroQuestao++;
					header.setBackgroundColor(BaseColor.GRAY);
					header.setBorderWidthBottom(4.0f);
					header.setBorderColor(BaseColor.GRAY);
					table.addCell(header);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					doc.add(table);
					
					
					doc.add(new Paragraph(  questao.getPergunta() + "\n", f2));
					
					Paragraph p1 = new Paragraph();
					Chunk letraA = new Chunk("(A) ", f2);
					Chunk altA = new Chunk(questao.getAltA(), f);
					p1.add(letraA);
					p1.add(altA);
					doc.add(p1);
					
					Paragraph p2 = new Paragraph();
					Chunk letraB = new Chunk("(B) ", f2);
					Chunk altB = new Chunk(questao.getAltB(), f);
					p2.add(letraB);
					p2.add(altB);
					doc.add(p2);
					
					Paragraph p3 = new Paragraph();
					Chunk letraC = new Chunk("(C) ", f2);
					Chunk altC = new Chunk(questao.getAltC(), f);
					p3.add(letraC);
					p3.add(altC);
					doc.add(p3);
					
					Paragraph p4 = new Paragraph();
					Chunk letraD = new Chunk("(D) ", f2);
					Chunk altD = new Chunk(questao.getAltD(), f);
					p4.add(letraD);
					p4.add(altD);
					doc.add(p4);
					
					Paragraph p5 = new Paragraph();
					Chunk letraE = new Chunk("(E) ", f2);
					Chunk altE = new Chunk(questao.getAltE()+"\n\n", f);
					p5.add(letraE);
					p5.add(altE);
					doc.add(p5);
					
				
					
					
					
				}
				//EXIBE DISSERTATIVA
				else if(questao.getTipo().equalsIgnoreCase("dissertativa")){
					doc.newPage();
					PdfPTable table = new PdfPTable(1);
					PdfPCell header = new PdfPCell(new Paragraph(" QUESTÃO " +numeroQuestao + "    -    " + notasQuestoes.get(numeroQuestao-1).toString()+ " PONTOS", white));
					numeroQuestao++;
					header.setBackgroundColor(BaseColor.GRAY);
					header.setBorderWidthBottom(4.0f);
					header.setBorderColor(BaseColor.GRAY);
					table.addCell(header);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					doc.add(table);
					
					
					doc.add(new Paragraph(  questao.getPergunta() + "\n", f2));			
					doc.newPage();
				}
				else if(questao.getTipo().equalsIgnoreCase("dissertativa/imagem")){
					doc.newPage();
					PdfPTable table = new PdfPTable(1);
					PdfPCell header = new PdfPCell(new Paragraph(" QUESTÃO " +numeroQuestao + "    -    " + notasQuestoes.get(numeroQuestao-1).toString()+ " PONTOS", white));
					numeroQuestao++;
					header.setBackgroundColor(BaseColor.GRAY);
					header.setBorderWidthBottom(4.0f);
					header.setBorderColor(BaseColor.GRAY);
					table.addCell(header);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					doc.add(table);
					
					
					doc.add(new Paragraph(questao.getPergunta() + "\n", f2));	
					Image image = Image.getInstance(questao.getImgEnunciado());
					image.scaleAbsolute(300, 200);
					doc.add(image);
					doc.newPage();
				}
				
			}
			JOptionPane.showMessageDialog(null, "Arquivo PDF gerado.");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo");
		}
		finally {
			if (doc != null) {
				// fechamento do documento
				doc.close();
			}
			if (os != null) {
				// fechamento da stream de saída
				os.close();
			}
		}

	}

	public void gerarPDFGabarito(ArrayList<Questao> questoes) throws IOException{
		String arquivo;
		FileDialog salvar;
		Document doc = null;
		FileOutputStream os = null;
		String nomeProva = valorNomeProva.getText();
		
		Collections.sort(questoes,  (o1, o2) -> {
			Questao q1 = (Questao) o1;
			Questao q2 = (Questao) o2;
			
			if(q1.getTipo().equalsIgnoreCase("dissertativa")||q1.getTipo().equalsIgnoreCase("dissertativa/imagem")){
				return 1;
				
			}else{
				return 0;
			}
			
		});
		
		
		salvar = new FileDialog(this, "Salvar", FileDialog.SAVE);
		salvar.setVisible(true);

		if (salvar.getFile() == null) {
			return;
		}
		arquivo = salvar.getDirectory() + salvar.getFile();

		try {
			
			doc = new Document(PageSize.A4);
			doc.setMargins(35, 35, 35, 35);
			os = new FileOutputStream(arquivo);

			PdfWriter.getInstance(doc, os);
			doc.open();
			
			

			Paragraph p = new Paragraph("GABARITO\n\n");
			p.setAlignment(Element.ALIGN_CENTER);
			doc.add(p);
			Paragraph nome = new Paragraph("PROVA: " + nomeProva.toUpperCase() + "\n\n");
			p.setAlignment(Element.ALIGN_CENTER);
			doc.add(new Paragraph("TURMA: " + valorTurma.getText()));
			doc.add(new Paragraph("DATA APLICAÇÃO: " + diaAplic.getText()));
			doc.add(nome);
			
			com.itextpdf.text.Font f = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10, Font.PLAIN);
			com.itextpdf.text.Font f2 = new com.itextpdf.text.Font(FontFamily.HELVETICA, 10, Font.BOLD);
			com.itextpdf.text.Font white = com.itextpdf.text.FontFactory.getFont(com.itextpdf.text.FontFactory.HELVETICA, 15, Font.BOLD, new com.itextpdf.text.BaseColor(com.itextpdf.text.BaseColor.WHITE.getRGB()));
			
			int numeroQuestao = 1;
			for (Questao questao : questoes) {
				
				
				//EXIBE OPTATIVA/IMAGEM
				if(questao.getTipo().equals("Optativa/imagem")){
					PdfPTable table = new PdfPTable(1);
					PdfPCell header = new PdfPCell(new Paragraph(" QUESTÃO " +numeroQuestao + "    -    " + notasQuestoes.get(numeroQuestao-1).toString(), white));
					numeroQuestao++;
					header.setBackgroundColor(BaseColor.GRAY);
					header.setBorderWidthBottom(4.0f);
					header.setBorderColor(BaseColor.GRAY);
					table.addCell(header);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					doc.add(table);
					
					
					doc.add(new Paragraph(questao.getPergunta() + "\n", f2));
					
					Paragraph p1 = new Paragraph("Alternativa Correta: " + questao.getAltCorreta(), f2);
					doc.add(p1);
					
					doc.add(new Paragraph("\n\n"));
					
				}
				//EXIBE OPTATIVA
				else if(questao.getTipo().equalsIgnoreCase("optativa")){
					PdfPTable table = new PdfPTable(1);
					PdfPCell header = new PdfPCell(new Paragraph(" QUESTÃO " +numeroQuestao + "    -    " + notasQuestoes.get(numeroQuestao-1).toString(), white));
					numeroQuestao++;
					header.setBackgroundColor(BaseColor.GRAY);
					header.setBorderWidthBottom(4.0f);
					header.setBorderColor(BaseColor.GRAY);
					table.addCell(header);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					doc.add(table);
					
					
					doc.add(new Paragraph(  questao.getPergunta() + "\n", f2));
					
					Paragraph p1 = new Paragraph("Alternativa Correta: " + questao.getAltCorreta(), f2);
					doc.add(p1);
					
					doc.add(new Paragraph("\n\n"));
					
				
					
					
					
				}
				//EXIBE DISSERTATIVA
				else if(questao.getTipo().equalsIgnoreCase("dissertativa")){
					PdfPTable table = new PdfPTable(1);
					PdfPCell header = new PdfPCell(new Paragraph(" QUESTÃO " +numeroQuestao + "    -    " + notasQuestoes.get(numeroQuestao-1).toString(), white));
					numeroQuestao++;
					header.setBackgroundColor(BaseColor.GRAY);
					header.setBorderWidthBottom(4.0f);
					header.setBorderColor(BaseColor.GRAY);
					table.addCell(header);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					doc.add(table);
					
					
					doc.add(new Paragraph(  questao.getPergunta() + "\n", f2));			
					doc.add(new Paragraph("Resposta esperada: " + questao.getRespEsperada()));
				}
				else if(questao.getTipo().equalsIgnoreCase("dissertativa/imagem")){
					PdfPTable table = new PdfPTable(1);
					PdfPCell header = new PdfPCell(new Paragraph(" QUESTÃO " +numeroQuestao + "    -    " + notasQuestoes.get(numeroQuestao-1).toString(), white));
					numeroQuestao++;
					header.setBackgroundColor(BaseColor.GRAY);
					header.setBorderWidthBottom(4.0f);
					header.setBorderColor(BaseColor.GRAY);
					table.addCell(header);
					table.setHorizontalAlignment(Element.ALIGN_LEFT);
					doc.add(table);
					
					
					doc.add(new Paragraph(questao.getPergunta() + "\n", f2));	
					Image image = Image.getInstance(questao.getImgRespEsp());
					image.scaleAbsolute(300, 200);
					doc.add(image);
					
					doc.add(new Paragraph("\n\n"));
				}
				
			}
			JOptionPane.showMessageDialog(null, "Arquivo PDF gerado.");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao gerar arquivo.");
		}
		finally {
			if (doc != null) {
				// fechamento do documento
				doc.close();
			}
			if (os != null) {
				// fechamento da stream de saída
				os.close();
			}
		}

		
	}
	
	
}

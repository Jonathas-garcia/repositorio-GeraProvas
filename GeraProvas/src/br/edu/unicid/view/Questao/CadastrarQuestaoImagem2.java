package br.edu.unicid.view.Questao;

import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;
import br.edu.unicid.dao.QuestaoDAO;

public class CadastrarQuestaoImagem2 extends JFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = -6204942805985819266L;
	static JTextPane textPane;
	static JTextPane valorAltA;
	static JTextPane valorAltB;
	static JTextPane valorAltC;
	static JTextPane valorAltD;
	static JTextPane valorAltE;
	private JComboBox comboBox;
	private JComboBox comboBoxNiveis;
	private FileDialog fabrir;
	private JComboBox boxAltCorreta;
	String caminhoEnunciado, caminhoAltA, caminhoAltB, caminhoAltC, caminhoAltD, caminhoAltE; 
	@SuppressWarnings("unchecked")
	public CadastrarQuestaoImagem2() {
		
		
		JFrame frmCadastrarQuesto = new JFrame("TextPane Example");
		frmCadastrarQuesto.setTitle("Cadastrar quest\u00E3o");
		frmCadastrarQuesto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		fabrir = new FileDialog(this, "Abrir", FileDialog.LOAD);
		
		comboBox = new JComboBox();
		comboBox.setBounds(582, 479, 202, 20);
		frmCadastrarQuesto.getContentPane().add(comboBox);
		
		comboBoxNiveis = new JComboBox();
		comboBoxNiveis.setBounds(582, 513, 202, 20);
		frmCadastrarQuesto.getContentPane().add(comboBoxNiveis);
		
		StyleContext context = new StyleContext();
		StyledDocument document = new DefaultStyledDocument(context);

		StyleContext context1 = new StyleContext();
		StyledDocument document1 = new DefaultStyledDocument(context1);

		StyleContext context2 = new StyleContext();
		StyledDocument document2 = new DefaultStyledDocument(context2);

		StyleContext context3 = new StyleContext();
		StyledDocument document3 = new DefaultStyledDocument(context3);

		StyleContext context4 = new StyleContext();
		StyledDocument document4 = new DefaultStyledDocument(context4);

		StyleContext context5 = new StyleContext();
		StyledDocument document5 = new DefaultStyledDocument(context5);

		Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);
		Style iconStyle = context.getStyle(StyleContext.DEFAULT_STYLE);

		Style labelStyle1 = context1.getStyle(StyleContext.DEFAULT_STYLE);
		Style iconStyle1 = context1.getStyle(StyleContext.DEFAULT_STYLE);

		Style labelStyle2 = context2.getStyle(StyleContext.DEFAULT_STYLE);
		Style iconStyle2 = context2.getStyle(StyleContext.DEFAULT_STYLE);

		Style labelStyle3 = context3.getStyle(StyleContext.DEFAULT_STYLE);
		Style iconStyle3 = context3.getStyle(StyleContext.DEFAULT_STYLE);

		Style labelStyle4 = context4.getStyle(StyleContext.DEFAULT_STYLE);
		Style iconStyle4 = context4.getStyle(StyleContext.DEFAULT_STYLE);

		Style labelStyle5 = context5.getStyle(StyleContext.DEFAULT_STYLE);
		Style iconStyle5 = context5.getStyle(StyleContext.DEFAULT_STYLE);

		Icon icon = new ImageIcon("C:/Users/Jonathas.garcia/Desktop/PROF.jpg");
		JLabel label = new JLabel(icon);
		StyleConstants.setComponent(labelStyle, label);

		try {
			document.insertString(document.getLength(), "Ignored", labelStyle);
		} catch (BadLocationException badLocationException) {
			System.err.println("Oops");
		}

		JButton addImgEnunciado = new JButton("Imagem");
		addImgEnunciado.setBounds(512, 43, 89, 23);
		addImgEnunciado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}
				caminhoEnunciado = fabrir.getDirectory() + fabrir.getFile();
				Icon img = new ImageIcon(caminhoEnunciado);
				JLabel label = new JLabel(img);
				StyleConstants.setComponent(labelStyle, label);
				try {
					document.insertString(document.getLength(), "Ignored", iconStyle);
				} catch (BadLocationException e) {
					e.printStackTrace();
					System.err.println("ERRROU");
				}
			}
		});
		frmCadastrarQuesto.getContentPane().setLayout(null);
		frmCadastrarQuesto.getContentPane().add(addImgEnunciado);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 36, 385, 107);
		frmCadastrarQuesto.getContentPane().add(scrollPane);

		textPane = new JTextPane(document);
		scrollPane.setViewportView(textPane);
		textPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textPane.setEditable(true);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(512, 77, 89, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText(null);
			}
		});
		frmCadastrarQuesto.getContentPane().add(btnLimpar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 181, 275, 107);
		frmCadastrarQuesto.getContentPane().add(scrollPane_1);

		valorAltA = new JTextPane(document1);
		scrollPane_1.setViewportView(valorAltA);

		JLabel label_1 = new JLabel("PERGUNTA");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(249, 11, 176, 14);
		frmCadastrarQuesto.getContentPane().add(label_1);

		JLabel lblAlternativaA = new JLabel("Alternativa A");
		lblAlternativaA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlternativaA.setBounds(59, 156, 89, 14);
		frmCadastrarQuesto.getContentPane().add(lblAlternativaA);

		JLabel lblAlternativaB = new JLabel("Alternativa B");
		lblAlternativaB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlternativaB.setBounds(59, 299, 89, 14);
		frmCadastrarQuesto.getContentPane().add(lblAlternativaB);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 326, 275, 107);
		frmCadastrarQuesto.getContentPane().add(scrollPane_2);

		valorAltB = new JTextPane(document2);
		scrollPane_2.setViewportView(valorAltB);

		JLabel lblAlternativaC = new JLabel("Alternativa C");
		lblAlternativaC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlternativaC.setBounds(59, 450, 89, 14);
		frmCadastrarQuesto.getContentPane().add(lblAlternativaC);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 475, 275, 107);
		frmCadastrarQuesto.getContentPane().add(scrollPane_3);

		valorAltC = new JTextPane(document3);
		scrollPane_3.setViewportView(valorAltC);

		JLabel lblAlternativaD = new JLabel("Alternativa D");
		lblAlternativaD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlternativaD.setBounds(471, 158, 89, 14);
		frmCadastrarQuesto.getContentPane().add(lblAlternativaD);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(410, 181, 275, 107);
		frmCadastrarQuesto.getContentPane().add(scrollPane_4);

		valorAltD = new JTextPane(document4);
		scrollPane_4.setViewportView(valorAltD);

		JLabel lblAlternativaE = new JLabel("Alternativa E");
		lblAlternativaE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlternativaE.setBounds(471, 301, 89, 14);
		frmCadastrarQuesto.getContentPane().add(lblAlternativaE);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(410, 326, 275, 107);
		frmCadastrarQuesto.getContentPane().add(scrollPane_5);

		valorAltE = new JTextPane(document5);
		scrollPane_5.setViewportView(valorAltE);

		JButton addImgAltA = new JButton("Imagem");
		addImgAltA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}
				caminhoAltA = fabrir.getDirectory() + fabrir.getFile();
				Icon img = new ImageIcon(caminhoAltA);
				JLabel label = new JLabel(img);
				StyleConstants.setComponent(labelStyle1, label);
				try {
					document1.insertString(document1.getLength(), "Ignored", iconStyle1);
				} catch (BadLocationException e) {
					e.printStackTrace();
					System.err.println("ERRROU");
				}
			}
		});
		addImgAltA.setBounds(292, 181, 89, 23);
		frmCadastrarQuesto.getContentPane().add(addImgAltA);

		JButton addImgAltB = new JButton("Imagem");
		addImgAltB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}
				caminhoAltB = fabrir.getDirectory() + fabrir.getFile();
				Icon img = new ImageIcon(caminhoAltB);
				JLabel label = new JLabel(img);
				StyleConstants.setComponent(labelStyle2, label);
				try {
					document2.insertString(document2.getLength(), "Ignored", iconStyle2);
				} catch (BadLocationException e) {
					e.printStackTrace();
					System.err.println("ERRROU");
				}
			}
		});
		addImgAltB.setBounds(292, 330, 89, 23);
		frmCadastrarQuesto.getContentPane().add(addImgAltB);

		JButton addImgAltC = new JButton("Imagem");
		addImgAltC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}
				caminhoAltC = fabrir.getDirectory() + fabrir.getFile();
				Icon img = new ImageIcon(caminhoAltC);
				JLabel label = new JLabel(img);
				StyleConstants.setComponent(labelStyle3, label);
				try {
					document3.insertString(document3.getLength(), "Ignored", iconStyle3);
				} catch (BadLocationException e) {
					e.printStackTrace();
					System.err.println("ERRROU");
				}
			}
		});
		addImgAltC.setBounds(292, 478, 89, 23);
		frmCadastrarQuesto.getContentPane().add(addImgAltC);

		JButton limparAltA = new JButton("Limpar");
		limparAltA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valorAltA.setText(null);
			}
		});
		limparAltA.setBounds(292, 215, 89, 23);
		frmCadastrarQuesto.getContentPane().add(limparAltA);

		JButton limparAltB = new JButton("Limpar");
		limparAltB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valorAltB.setText(null);
			}
		});
		limparAltB.setBounds(292, 364, 89, 23);
		frmCadastrarQuesto.getContentPane().add(limparAltB);

		JButton limparAltC = new JButton("Limpar");
		limparAltC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valorAltC.setText(null);
			}
		});
		limparAltC.setBounds(292, 512, 89, 23);
		frmCadastrarQuesto.getContentPane().add(limparAltC);

		JButton addImgAltD = new JButton("Imagem");
		addImgAltD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}
				caminhoAltD = fabrir.getDirectory() + fabrir.getFile();
				Icon img = new ImageIcon(caminhoAltD);
				JLabel label = new JLabel(img);
				StyleConstants.setComponent(labelStyle4, label);
				try {
					document4.insertString(document4.getLength(), "Ignored", iconStyle4);
				} catch (BadLocationException e) {
					e.printStackTrace();
					System.err.println("ERRROU");
				}
			}
		});
		addImgAltD.setBounds(695, 181, 89, 23);
		frmCadastrarQuesto.getContentPane().add(addImgAltD);

		JButton limparAltD = new JButton("Limpar");
		limparAltD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valorAltD.setText(null);
			}
		});
		limparAltD.setBounds(695, 215, 89, 23);
		frmCadastrarQuesto.getContentPane().add(limparAltD);

		JButton addImgAltE = new JButton("Imagem");
		addImgAltE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}
				caminhoAltE = fabrir.getDirectory() + fabrir.getFile();
				Icon img = new ImageIcon(caminhoAltE);
				JLabel label = new JLabel(img);
				StyleConstants.setComponent(labelStyle5, label);
				try {
					document5.insertString(document5.getLength(), "Ignored", iconStyle5);
				} catch (BadLocationException e) {
					e.printStackTrace();
					System.err.println("ERRROU");
				}
			}
		});
		addImgAltE.setBounds(695, 326, 89, 23);
		frmCadastrarQuesto.getContentPane().add(addImgAltE);

		JButton limparAltE = new JButton("Limpar");
		limparAltE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valorAltE.setText(null);
			}
		});
		limparAltE.setBounds(695, 360, 89, 23);
		frmCadastrarQuesto.getContentPane().add(limparAltE);
		
		JLabel lblAssunto = new JLabel("ASSUNTO:");
		lblAssunto.setBounds(512, 481, 59, 17);
		frmCadastrarQuesto.getContentPane().add(lblAssunto);
		
		JLabel lblNvel = new JLabel("N\u00CDVEL:");
		lblNvel.setBounds(526, 516, 46, 14);
		frmCadastrarQuesto.getContentPane().add(lblNvel);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon enunciado = new ImageIcon(caminhoEnunciado);
				ImageIcon altA = new ImageIcon(caminhoAltA);
				ImageIcon altB = new ImageIcon(caminhoAltB);
				ImageIcon altC = new ImageIcon(caminhoAltC);
				ImageIcon altD = new ImageIcon(caminhoAltD);
				ImageIcon altE = new ImageIcon(caminhoAltE);
				String altCorreta = (String) boxAltCorreta.getSelectedItem();
				String assunto = (String) comboBox.getSelectedItem();
				String nivel = (String) comboBoxNiveis.getSelectedItem();
				Questao questao = new Questao(enunciado,altA, altB, altC, altD, altE, altCorreta, assunto, nivel);
				try {
					QuestaoDAO dao = new QuestaoDAO();
					dao.salvarOptativa(questao);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnGravar.setBounds(485, 559, 89, 23);
		frmCadastrarQuesto.getContentPane().add(btnGravar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Teste");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(611, 559, 89, 23);
		frmCadastrarQuesto.getContentPane().add(btnCancelar);
		
		JLabel lblAlternativaCorreta = new JLabel("ALTERNATIVA CORRETA: ");
		lblAlternativaCorreta.setBounds(443, 452, 128, 14);
		frmCadastrarQuesto.getContentPane().add(lblAlternativaCorreta);
		
		boxAltCorreta = new JComboBox();
		boxAltCorreta.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E"}));
		boxAltCorreta.setBounds(582, 448, 103, 20);
		frmCadastrarQuesto.getContentPane().add(boxAltCorreta);
		frmCadastrarQuesto.setSize(822, 631);
		frmCadastrarQuesto.setVisible(true);
		
		try {
			AssuntoDAO dao = new AssuntoDAO();
			for (Assunto p : dao.todosAssuntos()) {
				comboBox.addItem(p.getTexto());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			NivelDificuldadeDAO dao = new NivelDificuldadeDAO();
			for (NivelDificuldade p : dao.todosNiveis()) {
				comboBoxNiveis.addItem(p.getTexto());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

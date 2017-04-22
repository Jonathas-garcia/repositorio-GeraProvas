package br.edu.unicid.view.Questao;

import java.awt.Button;
import java.awt.FileDialog;
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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;
import br.edu.unicid.dao.QuestaoDAO;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class CadastrarQuestao extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblAlternativaD;
	private JLabel lblAlternativaE;
	private JLabel lblAlternativaB;
	private JLabel lblAlternativaC;
	private Button cancelar;
	private Button gravar;
	private JLabel lblAlternativaCorreta;
	private JComboBox comboBox;
	private JButton pesquisarAssuntos;
	private JComboBox altCorreta;
	private JComboBox comboBoxNiveis;
	private JButton listarNiveis;
	private JTextArea textAreaPergunta;
	private JTextArea textAreaAltA;
	private JTextArea textAreaAltB;
	private JTextArea textAreaAltC;
	private JTextArea textAreaAltD;
	private JTextArea textAreaAltE;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JLabel lblNewLabel_1;
	private JLabel lblAssunto;
	private JLabel lblAnexado;
	private JTextField valorImgC;
	private JButton btnImgC;
	private JButton btnImgB;
	private JTextField valorImgB;
	private JLabel label;
	private JButton btnImgA;
	private JTextField valorImgA;
	private JLabel label_1;
	private JButton btnImgD;
	private JTextField valorImgD;
	private FileDialog fsalvar, fabrir;
	private JLabel label_2;
	private JButton btnImgE;
	private JTextField valorImgE;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField valorImgPergunta;
	private JButton btnImgPergunta;

	public CadastrarQuestao() {
		setTitle("Cadastrar quest\u00E3o");

		setBounds(230, 30, 722, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		fabrir = new FileDialog(this, "Abrir", FileDialog.LOAD);
		fsalvar = new FileDialog(this, "Salvar", FileDialog.SAVE);

		lblNewLabel = new JLabel("Alternativa A:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 187, 219, 14);
		contentPane.add(lblNewLabel);

		lblAlternativaD = new JLabel("Alternativa D:");
		lblAlternativaD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaD.setBounds(389, 162, 219, 14);
		contentPane.add(lblAlternativaD);

		lblAlternativaE = new JLabel("Alternativa E:");
		lblAlternativaE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaE.setBounds(389, 339, 219, 14);
		contentPane.add(lblAlternativaE);

		lblAlternativaB = new JLabel("Alternativa B:");
		lblAlternativaB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaB.setBounds(20, 350, 219, 14);
		contentPane.add(lblAlternativaB);

		lblAlternativaC = new JLabel("Alternativa C:");
		lblAlternativaC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaC.setBounds(20, 507, 219, 14);
		contentPane.add(lblAlternativaC);

		cancelar = new Button("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaPergunta.setText(" ");
				textAreaAltA.setText(" ");
				textAreaAltB.setText(" ");
				textAreaAltC.setText(" ");
				textAreaAltD.setText(" ");
				textAreaAltE.setText(" ");

				setVisible(false);

			}
		});
		cancelar.setBounds(578, 621, 110, 22);
		contentPane.add(cancelar);

		gravar = new Button("Gravar");

		gravar.setBounds(454, 621, 110, 22);
		contentPane.add(gravar);

		lblAlternativaCorreta = new JLabel("Alternativa Correta  :");
		lblAlternativaCorreta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaCorreta.setBounds(389, 521, 147, 14);
		contentPane.add(lblAlternativaCorreta);

		comboBox = new JComboBox();
		comboBox.setBounds(486, 577, 202, 20);
		contentPane.add(comboBox);

		pesquisarAssuntos = new JButton("Listar Assuntos");
		pesquisarAssuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					AssuntoDAO dao = new AssuntoDAO();
					for (Assunto p : dao.todosAssuntos()) {
						comboBox.addItem(p.getTexto());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		pesquisarAssuntos.setBounds(389, 506, 117, 23);
		// contentPane.add(pesquisarAssuntos);

		altCorreta = new JComboBox();
		altCorreta.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E" }));
		altCorreta.setBounds(530, 520, 50, 20);
		contentPane.add(altCorreta);

		comboBoxNiveis = new JComboBox();
		comboBoxNiveis.setBounds(486, 546, 202, 20);
		contentPane.add(comboBoxNiveis);

		listarNiveis = new JButton("Listar Niveis");
		listarNiveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					NivelDificuldadeDAO dao = new NivelDificuldadeDAO();
					for (NivelDificuldade p : dao.todosNiveis()) {
						comboBoxNiveis.addItem(p.getTexto());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		listarNiveis.setBounds(389, 472, 117, 23);
		// contentPane.add(listarNiveis);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 11, 665, 119);
		contentPane.add(scrollPane);

		textAreaPergunta = new JTextArea();
		scrollPane.setViewportView(textAreaPergunta);
		textAreaPergunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaPergunta.setLineWrap(true);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 202, 291, 100);
		contentPane.add(scrollPane_1);

		textAreaAltA = new JTextArea();
		scrollPane_1.setViewportView(textAreaAltA);
		textAreaAltA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAltA.setLineWrap(true);
		textAreaAltA.setIgnoreRepaint(true);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(389, 187, 291, 100);
		contentPane.add(scrollPane_2);

		textAreaAltD = new JTextArea();
		textAreaAltD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_2.setViewportView(textAreaAltD);
		textAreaAltD.setLineWrap(true);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 364, 291, 100);
		contentPane.add(scrollPane_3);

		textAreaAltB = new JTextArea();
		textAreaAltB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_3.setViewportView(textAreaAltB);
		textAreaAltB.setLineWrap(true);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(389, 364, 291, 100);
		contentPane.add(scrollPane_4);

		textAreaAltE = new JTextArea();
		scrollPane_4.setViewportView(textAreaAltE);
		textAreaAltE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAltE.setLineWrap(true);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(20, 522, 289, 100);
		contentPane.add(scrollPane_5);

		textAreaAltC = new JTextArea();
		scrollPane_5.setViewportView(textAreaAltC);
		textAreaAltC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAltC.setLineWrap(true);

		lblNewLabel_1 = new JLabel("Nivel:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(389, 547, 66, 14);
		contentPane.add(lblNewLabel_1);

		lblAssunto = new JLabel("Assunto:");
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAssunto.setBounds(389, 578, 66, 14);
		contentPane.add(lblAssunto);

		lblAnexado = new JLabel("Anexado:");
		lblAnexado.setBounds(20, 633, 66, 14);
		contentPane.add(lblAnexado);

		valorImgC = new JTextField();
		valorImgC.setBounds(71, 627, 210, 20);
		contentPane.add(valorImgC);
		valorImgC.setColumns(10);

		btnImgC = new JButton("");
		btnImgC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}

				valorImgC.setText(fabrir.getDirectory() + fabrir.getFile());

			}
		});
		btnImgC.setIcon(new ImageIcon("imagens\\icons_anexo.jpg"));
		btnImgC.setBounds(285, 621, 26, 26);
		contentPane.add(btnImgC);

		btnImgB = new JButton("");
		btnImgB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}

				valorImgB.setText(fabrir.getDirectory() + fabrir.getFile());
			}
		});
		btnImgB.setIcon(new ImageIcon("imagens\\icons_anexo.jpg"));
		btnImgB.setBounds(285, 470, 26, 26);
		contentPane.add(btnImgB);

		valorImgB = new JTextField();
		valorImgB.setColumns(10);
		valorImgB.setBounds(71, 476, 210, 20);
		contentPane.add(valorImgB);

		label = new JLabel("Anexado:");
		label.setBounds(20, 482, 66, 14);
		contentPane.add(label);

		btnImgA = new JButton("");
		btnImgA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}

				valorImgA.setText(fabrir.getDirectory() + fabrir.getFile());
			}
		});
		btnImgA.setIcon(new ImageIcon("imagens\\icons_anexo.jpg"));
		btnImgA.setBounds(285, 313, 26, 26);
		contentPane.add(btnImgA);

		valorImgA = new JTextField();
		valorImgA.setColumns(10);
		valorImgA.setBounds(72, 316, 210, 20);
		contentPane.add(valorImgA);

		label_1 = new JLabel("Anexado:");
		label_1.setBounds(21, 322, 66, 14);
		contentPane.add(label_1);

		btnImgD = new JButton("");
		btnImgD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}

				valorImgD.setText(fabrir.getDirectory() + fabrir.getFile());
			}
		});
		btnImgD.setIcon(new ImageIcon("imagens\\icons_anexo.jpg"));
		btnImgD.setBounds(653, 298, 26, 26);
		contentPane.add(btnImgD);

		valorImgD = new JTextField();
		valorImgD.setColumns(10);
		valorImgD.setBounds(440, 301, 210, 20);
		contentPane.add(valorImgD);

		label_2 = new JLabel("Anexado:");
		label_2.setBounds(389, 307, 66, 14);
		contentPane.add(label_2);

		btnImgE = new JButton("");
		btnImgE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}

				valorImgE.setText(fabrir.getDirectory() + fabrir.getFile());

			}
		});
		btnImgE.setIcon(new ImageIcon("imagens\\icons_anexo.jpg"));
		btnImgE.setBounds(654, 470, 26, 26);
		contentPane.add(btnImgE);

		valorImgE = new JTextField();
		valorImgE.setColumns(10);
		valorImgE.setBounds(441, 473, 210, 20);
		contentPane.add(valorImgE);

		label_3 = new JLabel("Anexado:");
		label_3.setBounds(390, 479, 66, 14);
		contentPane.add(label_3);

		label_4 = new JLabel("Anexado:");
		label_4.setBounds(20, 150, 66, 14);
		contentPane.add(label_4);

		valorImgPergunta = new JTextField();
		valorImgPergunta.setColumns(10);
		valorImgPergunta.setBounds(71, 144, 210, 20);
		contentPane.add(valorImgPergunta);

		btnImgPergunta = new JButton("");
		btnImgPergunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}

				valorImgPergunta.setText(fabrir.getDirectory() + fabrir.getFile());
			}
		});
		btnImgPergunta.setIcon(new ImageIcon("imagens\\icons_anexo.jpg"));
		btnImgPergunta.setBounds(284, 141, 26, 26);
		contentPane.add(btnImgPergunta);

		gravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String correta = (String) altCorreta.getSelectedItem();
				String assunto = (String) comboBox.getSelectedItem();
				String nivel = (String) comboBoxNiveis.getSelectedItem();
				
				
				String pergunta = textAreaPergunta.getText();
				String imgPergunta = valorImgPergunta.getText();
				System.out.println(imgPergunta);
				
				String altA = textAreaAltA.getText();
				String imgAltA = valorImgA.getText();
				System.out.println(imgAltA);

				String altB = textAreaAltB.getText();
				String imgAltB = valorImgB.getText();

				String altC = textAreaAltC.getText();
				String imgAltC = valorImgC.getText();

				String altD = textAreaAltD.getText();
				String imgAltD = valorImgD.getText();

				String altE = textAreaAltE.getText();
				String imgAltE = valorImgE.getText();

				if (!imgAltA.equals("") || !imgPergunta.equals("")) {
					System.out.println("Entrou no IF de salvar obj com imagem");
					Questao questao = new Questao(0, "Optativa/imagem", pergunta, imgPergunta, imgAltA, imgAltB, imgAltC, imgAltD, imgAltE, correta, assunto, nivel);
					QuestaoDAO dao = null;
					try {
						dao = new QuestaoDAO();
						dao.salvarObjetivaImg(questao);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				} else {

					System.out.println("Não entrou no IF de salvar obj com imagem");

					Questao questao = new Questao(0, pergunta, altA, altB, altC, altD, altE, correta, assunto, nivel);
					System.out.println(questao.toString());
					if (!textAreaPergunta.getText().equals("") && !textAreaAltA.getText().equals("")
							&& !textAreaAltB.getText().equals("") && !textAreaAltC.getText().equals("")
							&& !textAreaAltD.getText().equals("") && !textAreaAltE.getText().equals("")) {
						try {
							QuestaoDAO dao = new QuestaoDAO();
							dao.salvarOptativa(questao);
						} catch (Exception e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Erro!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Há campos obrigatórios a serem preenchidos");
					}

				}
			}
		});

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

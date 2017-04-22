package br.edu.unicid.view.Questao;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;
import br.edu.unicid.dao.QuestaoDAO;

public class CadastrarQuestaoDissertativa extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JTextField valorCaminhoRespEsp;
	private FileDialog fsalvar, fabrir;
	private JLabel label;
	private JTextPane textResposta;
	private JScrollPane scrollPane_1;
	private JTextField valorImagemEnunciado;
	String caminhoArquivos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarQuestaoDissertativa frame = new CadastrarQuestaoDissertativa();
					frame.setTitle("Teste");
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
	public CadastrarQuestaoDissertativa() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cadastrar quest\u00E3o - Dissertativa");
		setResizable(false);
		setBounds(100, 100, 531, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		fabrir = new FileDialog(this, "Abrir", FileDialog.LOAD);
		fsalvar = new FileDialog(this, "Salvar", FileDialog.SAVE);
		
		JLabel lblPergunta = new JLabel("Pergunta");
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPergunta.setBounds(234, -5, 59, 34);
		contentPane.add(lblPergunta);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 498, 120);
		contentPane.add(scrollPane);

		JTextPane textPergunta = new JTextPane();
		scrollPane.setViewportView(textPergunta);

		JComboBox comboBoxAssuntos = new JComboBox();
		comboBoxAssuntos.setBounds(343, 376, 172, 20);
		contentPane.add(comboBoxAssuntos);

		JComboBox comboBoxNiveis = new JComboBox();
		comboBoxNiveis.setBounds(343, 414, 172, 20);
		contentPane.add(comboBoxNiveis);

		try {
			AssuntoDAO dao = new AssuntoDAO();
			for (Assunto a : dao.listarAssuntos()) {
				comboBoxAssuntos.addItem(a.getTexto());

			}

			NivelDificuldadeDAO dao2 = new NivelDificuldadeDAO();
			for (NivelDificuldade n : dao2.listarNiveis()) {
				comboBoxNiveis.addItem(n.getTexto());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(295, 379, 73, 14);
		contentPane.add(lblAssunto);

		JLabel lblNivel = new JLabel(" Nivel:");
		lblNivel.setBounds(300, 417, 46, 14);
		contentPane.add(lblNivel);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(419, 470, 89, 23);
		contentPane.add(btnLimpar);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}
				caminhoArquivos = fabrir.getDirectory()+fabrir.getFile();
				valorCaminhoRespEsp.setText(caminhoArquivos);
			}
		});
		button.setIcon(new ImageIcon("imagens\\icons_anexo.jpg"));
		button.setBounds(256, 370, 26, 26);
		contentPane.add(button);

		valorCaminhoRespEsp = new JTextField();
		valorCaminhoRespEsp.setColumns(10);
		valorCaminhoRespEsp.setBounds(61, 376, 185, 20);
		contentPane.add(valorCaminhoRespEsp);

		label = new JLabel("Anexado:");
		label.setBounds(10, 382, 66, 14);
		contentPane.add(label);

		textResposta = new JTextPane();
		textResposta.setBounds(10, 247, 505, 118);
		contentPane.add(textResposta);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 245, 505, 120);
		contentPane.add(scrollPane_1);

		JLabel label_1 = new JLabel("Anexado:");
		label_1.setBounds(10, 174, 66, 14);
		contentPane.add(label_1);

		valorImagemEnunciado = new JTextField();
		valorImagemEnunciado.setColumns(10);
		valorImagemEnunciado.setBounds(61, 168, 185, 20);
		contentPane.add(valorImagemEnunciado);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fabrir.setVisible(true);
				if (fabrir.getDirectory() == null) {
					return;
				}
				caminhoArquivos = fabrir.getDirectory()+fabrir.getFile();
				valorImagemEnunciado.setText(caminhoArquivos);
			}
		});
		button_1.setIcon(new ImageIcon("imagens\\icons_anexo.jpg"));
		button_1.setBounds(256, 162, 26, 26);
		contentPane.add(button_1);

		JLabel lblRespostaEsperada = new JLabel("Resposta Esperada");
		lblRespostaEsperada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespostaEsperada.setBounds(213, 214, 133, 34);
		contentPane.add(lblRespostaEsperada);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			private AbstractButton valorImageEnunciado;

			public void actionPerformed(ActionEvent arg0) {
				
				String pergunta = textPergunta.getText();	
				String respEsperada = textResposta.getText();
				String assunto = (String) comboBoxAssuntos.getSelectedItem();
				String nivel = (String) comboBoxNiveis.getSelectedItem();
				
				if(valorCaminhoRespEsp.getText()==null||valorImagemEnunciado.getText().equals("")){
					System.out.println("SEM IMAGEM");
					Questao questao = new Questao(0, pergunta, " ", respEsperada, assunto, nivel, 0, true);
					try {
						QuestaoDAO dao = new QuestaoDAO();
						dao.salvarDissertativa(questao);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro!");
					}
				
				}else{
					System.out.println("COM IMAGEM");
					System.out.println(valorImagemEnunciado.getText());
					//ImageIcon ImageIconEnun = new ImageIcon(valorImagemEnunciado.getText());
					System.out.println(valorCaminhoRespEsp.getText());
					//ImageIcon ImageIconResp = new ImageIcon(valorCaminhoRespEsp.getText());
					//Questao questao = new Questao(0, ImageIconEnun, ImageIconResp, assunto, nivel);
					
					Questao questao = new Questao(0, "Dissertativa/imagem", textPergunta.getText(), valorImagemEnunciado.getText(), valorCaminhoRespEsp.getText(), textResposta.getText(), assunto, nivel);
					
					try {
						QuestaoDAO dao = new QuestaoDAO();
						if(dao.salvarDissImg(questao)){
							System.out.println("Sucesso");
						}
						
					} catch (Exception e) {
					}
					
				
				
			}
			}
		});
		
		
		btnGravar.setBounds(312, 470, 89, 23);
		contentPane.add(btnGravar);

	}
}

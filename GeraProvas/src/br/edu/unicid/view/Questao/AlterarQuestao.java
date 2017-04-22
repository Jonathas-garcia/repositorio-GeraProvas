package br.edu.unicid.view.Questao;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.bean.Questao;

import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;
import br.edu.unicid.dao.QuestaoDAO;

public class AlterarQuestao extends JFrame {

	private JPanel contentPane;
	private JLabel lblPergunta;
	private JLabel lblNewLabel;
	private JLabel lblAlternativaD;
	private JLabel lblAlternativaE;
	private JLabel lblAlternativaB;
	private JTextArea textAreaPergunta;
	private JTextArea textAreaAltA;
	private JTextArea textAreaAltD;
	private JTextArea textAreaAltB;
	private JTextArea textAreaAltE;
	private JTextArea textAreaAltC;
	private JLabel lblAlternativaC;
	private JLabel lblAlternativaCorreta;
	private JButton voltar;
	private JButton Gravar;
	private JComboBox comboBoxAssuntos;
	int questaoAlterada;
	private JButton listarAssunto;
	private JComboBox altCorreta;
	private JButton listarNiveis;
	private JComboBox comboBoxNiveis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		AlterarQuestao frame = new AlterarQuestao();
		frame.setVisible(true);
	}

	public AlterarQuestao() {
		alterarQuestao();

	}

	public void alterarQuestao() {

		setBounds(230, 30, 769, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAreaPergunta = new JTextArea();
		textAreaPergunta.setBounds(10, 36, 738, 125);
		contentPane.add(textAreaPergunta);
		textAreaPergunta.setLineWrap(true);

		lblPergunta = new JLabel("PERGUNTA");
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPergunta.setBounds(334, 11, 176, 14);
		contentPane.add(lblPergunta);

		lblNewLabel = new JLabel("Alternativa A:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 172, 219, 14);
		contentPane.add(lblNewLabel);

		lblAlternativaD = new JLabel("Alternativa D:");
		lblAlternativaD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaD.setBounds(389, 172, 219, 14);
		contentPane.add(lblAlternativaD);

		lblAlternativaE = new JLabel("Alternativa E:");
		lblAlternativaE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaE.setBounds(389, 293, 219, 14);
		contentPane.add(lblAlternativaE);

		lblAlternativaB = new JLabel("Alternativa B:");
		lblAlternativaB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaB.setBounds(10, 293, 219, 14);
		contentPane.add(lblAlternativaB);

		textAreaAltA = new JTextArea();
		textAreaAltA.setBounds(10, 197, 346, 85);
		contentPane.add(textAreaAltA);
		textAreaAltA.setLineWrap(true);

		textAreaAltD = new JTextArea();
		textAreaAltD.setBounds(389, 197, 359, 85);
		contentPane.add(textAreaAltD);
		textAreaAltD.setLineWrap(true);

		textAreaAltB = new JTextArea();
		textAreaAltB.setBounds(10, 318, 346, 85);
		contentPane.add(textAreaAltB);
		textAreaAltB.setLineWrap(true);

		textAreaAltE = new JTextArea();
		textAreaAltE.setBounds(389, 318, 346, 85);
		contentPane.add(textAreaAltE);
		textAreaAltE.setLineWrap(true);

		textAreaAltC = new JTextArea();
		textAreaAltC.setBounds(10, 439, 346, 85);
		contentPane.add(textAreaAltC);
		textAreaAltC.setLineWrap(true);

		lblAlternativaC = new JLabel("Alternativa C:");
		lblAlternativaC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaC.setBounds(10, 414, 219, 14);
		contentPane.add(lblAlternativaC);

		lblAlternativaCorreta = new JLabel("Alternativa Correta  :");
		lblAlternativaCorreta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaCorreta.setBounds(389, 444, 147, 14);
		contentPane.add(lblAlternativaCorreta);

		voltar = new JButton("Voltar");
		voltar.setBounds(269, 560, 89, 23);
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		contentPane.add(voltar);

		Gravar = new JButton("Salvar");
		Gravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod = questaoAlterada;
				String pergunta = textAreaPergunta.getText();
				String altA = textAreaAltA.getText();
				String altB = textAreaAltB.getText();
				String altC = textAreaAltC.getText();
				String altD = textAreaAltD.getText();
				String altE = textAreaAltE.getText();
				String correta = (String) altCorreta.getSelectedItem();
				String assunto = (String) comboBoxAssuntos.getSelectedItem();
				String nivel = (String) comboBoxNiveis.getSelectedItem();
				Questao questao = new Questao(cod, pergunta, altA, altB, altC, altD, altE, correta, assunto, nivel);

				try {
					QuestaoDAO dao = new QuestaoDAO();
					dao.atualizar(questao, cod);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
					setVisible(false);
			}
		});
		Gravar.setBounds(396, 560, 89, 23);
		contentPane.add(Gravar);

		comboBoxAssuntos = new JComboBox();
		comboBoxAssuntos.setBounds(533, 509, 202, 20);
		contentPane.add(comboBoxAssuntos);

		altCorreta = new JComboBox();
		altCorreta.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E" }));
		altCorreta.setBounds(533, 441, 50, 20);
		contentPane.add(altCorreta);

		comboBoxNiveis = new JComboBox();
		comboBoxNiveis.setBounds(533, 472, 202, 20);
		contentPane.add(comboBoxNiveis);

		try {
			AssuntoDAO dao = new AssuntoDAO();
			dao = new AssuntoDAO();
			for (Assunto p : dao.todosAssuntos()) {
				comboBoxAssuntos.addItem(p.getTexto());
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

	public void testando(Questao questao) throws Exception {
		textAreaPergunta.setText(questao.getPergunta());
		textAreaAltA.setText(questao.getAltA());
		textAreaAltB.setText(questao.getAltB());
		textAreaAltC.setText(questao.getAltC());
		textAreaAltD.setText(questao.getAltD());
		textAreaAltE.setText(questao.getAltE());
		// assunto.setText(questao.getAssunto());
		// nivelDificuldade.setText(Integer.toString(questao.getNivelDific()));
		// data.setText(questao.getData());
		questaoAlterada = questao.getCod();
		AssuntoDAO dao = new AssuntoDAO();
		int i = 0;
		String assuntoQuestao = questao.getAssunto();
		for (Assunto p : dao.todosAssuntos()) {
			if (p.getTexto().equals(assuntoQuestao)) {
				comboBoxAssuntos.setSelectedIndex(i);
			}
			i++;
		}
		
		
		String nivelQuestao = questao.getNivelDific();
		NivelDificuldadeDAO daoNV = new NivelDificuldadeDAO();
		int x =0;
		for(NivelDificuldade nv : daoNV.todosNiveis()){
			if(nv.getTexto().equals(nivelQuestao)){
				comboBoxNiveis.setSelectedIndex(x);
			}
			x++;
		}

	}
}
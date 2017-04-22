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
import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.QuestaoDAO;

public class ExibirQuestao extends JFrame {

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
	private JLabel lblNivelDeDificuldade;
	private JTextField nivelDificuldade;
	private JLabel lblAlternativaCorreta;
	private JLabel lblAssunto;
	private JTextField altCorreta;
	private JTextField assunto;
	private JButton voltar;
	private JLabel lblData;
	private JTextField data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ExibirQuestao frame = new ExibirQuestao();
		frame.setVisible(true);
	}

	public ExibirQuestao() {
		exibirQuestao();

	}

	public void exibirQuestao() {

		setBounds(230, 30, 769, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAreaPergunta = new JTextArea();
		textAreaPergunta.setEditable(false);
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
		textAreaAltA.setEditable(false);
		textAreaAltA.setBounds(10, 197, 346, 85);
		contentPane.add(textAreaAltA);
		textAreaAltA.setLineWrap(true);

		textAreaAltD = new JTextArea();
		textAreaAltD.setEditable(false);
		textAreaAltD.setBounds(389, 197, 359, 85);
		contentPane.add(textAreaAltD);
		textAreaAltD.setLineWrap(true);

		textAreaAltB = new JTextArea();
		textAreaAltB.setEditable(false);
		textAreaAltB.setBounds(10, 318, 346, 85);
		contentPane.add(textAreaAltB);
		textAreaAltB.setLineWrap(true);

		textAreaAltE = new JTextArea();
		textAreaAltE.setEditable(false);
		textAreaAltE.setBounds(389, 318, 346, 85);
		contentPane.add(textAreaAltE);
		textAreaAltE.setLineWrap(true);

		textAreaAltC = new JTextArea();
		textAreaAltC.setEditable(false);
		textAreaAltC.setBounds(10, 439, 346, 85);
		contentPane.add(textAreaAltC);
		textAreaAltC.setLineWrap(true);

		lblAlternativaC = new JLabel("Alternativa C:");
		lblAlternativaC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaC.setBounds(10, 414, 219, 14);
		contentPane.add(lblAlternativaC);

		lblNivelDeDificuldade = new JLabel("Nivel de Dificuldade :");
		lblNivelDeDificuldade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNivelDeDificuldade.setBounds(389, 477, 134, 14);
		contentPane.add(lblNivelDeDificuldade);

		nivelDificuldade = new JTextField();
		nivelDificuldade.setEditable(false);
		nivelDificuldade.setBounds(533, 476, 202, 20);
		contentPane.add(nivelDificuldade);
		nivelDificuldade.setColumns(10);

		lblAlternativaCorreta = new JLabel("Alternativa Correta  :");
		lblAlternativaCorreta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlternativaCorreta.setBounds(389, 444, 147, 14);
		contentPane.add(lblAlternativaCorreta);

		lblAssunto = new JLabel("Assunto :");
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAssunto.setBounds(389, 510, 192, 14);
		contentPane.add(lblAssunto);

		altCorreta = new JTextField();
		altCorreta.setEditable(false);
		altCorreta.setBounds(533, 441, 50, 20);
		contentPane.add(altCorreta);
		altCorreta.setColumns(10);

		assunto = new JTextField();
		assunto.setEditable(false);
		assunto.setBounds(459, 509, 276, 20);
		contentPane.add(assunto);
		assunto.setColumns(10);

		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		voltar.setBounds(334, 560, 89, 23);
		contentPane.add(voltar);

		lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setBounds(593, 444, 38, 14);
		contentPane.add(lblData);

		data = new JTextField();
		data.setEditable(false);
		data.setBounds(641, 441, 94, 20);
		contentPane.add(data);
		data.setColumns(10);

	}

	public void testando(Questao questao) {
		textAreaPergunta.setText(questao.getPergunta());
		textAreaAltA.setText(questao.getAltA());
		textAreaAltB.setText(questao.getAltB());
		textAreaAltC.setText(questao.getAltC());
		textAreaAltD.setText(questao.getAltD());
		textAreaAltE.setText(questao.getAltE());
		altCorreta.setText(questao.getAltCorreta());
		assunto.setText(questao.getAssunto());
		nivelDificuldade.setText(questao.getNivelDific());
		data.setText(questao.getData());

	}
}

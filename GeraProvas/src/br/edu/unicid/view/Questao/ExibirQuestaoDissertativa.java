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

public class ExibirQuestaoDissertativa extends JFrame {

	private JPanel contentPane;
	private JLabel lblPergunta;
	private JLabel lblNewLabel;
	private JTextArea textAreaPergunta;
	private JTextArea respEsperada;
	private JLabel lblNivelDeDificuldade;
	private JTextField nivelDificuldade;
	private JLabel lblAssunto;
	private JTextField assunto;
	private JButton voltar;
	private JLabel lblData;
	private JTextField data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ExibirQuestaoDissertativa frame = new ExibirQuestaoDissertativa();
		frame.setVisible(true);
	}

	public ExibirQuestaoDissertativa() {
		exibirQuestao();

	}

	public void exibirQuestao() {

		setBounds(230, 30, 769, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAreaPergunta = new JTextArea();
		textAreaPergunta.setEditable(false);
		textAreaPergunta.setBounds(10, 36, 738, 173);
		contentPane.add(textAreaPergunta);
		textAreaPergunta.setLineWrap(true);

		lblPergunta = new JLabel("PERGUNTA");
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPergunta.setBounds(334, 11, 176, 14);
		contentPane.add(lblPergunta);

		lblNewLabel = new JLabel("Resposta Esperada:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 220, 219, 14);
		contentPane.add(lblNewLabel);

		respEsperada = new JTextArea();
		respEsperada.setEditable(false);
		respEsperada.setBounds(10, 245, 733, 167);
		contentPane.add(respEsperada);
		respEsperada.setLineWrap(true);

		lblNivelDeDificuldade = new JLabel("Nivel de Dificuldade :");
		lblNivelDeDificuldade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNivelDeDificuldade.setBounds(10, 482, 134, 14);
		contentPane.add(lblNivelDeDificuldade);

		nivelDificuldade = new JTextField();
		nivelDificuldade.setEditable(false);
		nivelDificuldade.setBounds(154, 482, 225, 20);
		contentPane.add(nivelDificuldade);
		nivelDificuldade.setColumns(10);

		lblAssunto = new JLabel("Assunto :");
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAssunto.setBounds(389, 442, 192, 14);
		contentPane.add(lblAssunto);

		assunto = new JTextField();
		assunto.setEditable(false);
		assunto.setBounds(467, 441, 276, 20);
		contentPane.add(assunto);
		assunto.setColumns(10);

		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		voltar.setBounds(334, 515, 89, 23);
		contentPane.add(voltar);

		lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setBounds(10, 442, 38, 14);
		contentPane.add(lblData);

		data = new JTextField();
		data.setEditable(false);
		data.setBounds(157, 441, 94, 20);
		contentPane.add(data);
		data.setColumns(10);

	}

	public void testando(Questao questao) {
		
		textAreaPergunta.setText(questao.getPergunta());
		respEsperada.setText(questao.getRespEsperada());
		assunto.setText(questao.getAssunto());
		nivelDificuldade.setText(questao.getNivelDific());
		data.setText(questao.getData());

	}
}

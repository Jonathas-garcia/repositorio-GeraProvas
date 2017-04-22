package br.edu.unicid.view.Prova;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apresentar extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnSalvar;
	private JLabel lblQuantidadeDeQuestoes;
	private JLabel lblAssunto;
	private JLabel lblNivelDeDificuldade;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblLimiteDeVezes;
	private JLabel lblQtdDeQuestoes;
	private JLabel lblQtdDeQuestoes_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentar frame = new Apresentar();
					frame.setVisible(true);
					frame.setTitle("Filtrar Questoes");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Apresentar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 228, 89, 23);
		contentPane.add(btnNewButton);

		btnSalvar = new JButton("Gerar");
		btnSalvar.setBounds(167, 228, 89, 23);
		contentPane.add(btnSalvar);

		lblQuantidadeDeQuestoes = new JLabel("Quantidade de Questoes :");
		lblQuantidadeDeQuestoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidadeDeQuestoes.setBounds(10, 24, 191, 14);
		contentPane.add(lblQuantidadeDeQuestoes);

		lblAssunto = new JLabel("Assunto:");
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAssunto.setBounds(10, 145, 104, 14);
		contentPane.add(lblAssunto);

		lblNivelDeDificuldade = new JLabel("Nivel:");
		lblNivelDeDificuldade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNivelDeDificuldade.setBounds(10, 180, 191, 14);
		contentPane.add(lblNivelDeDificuldade);

		comboBox = new JComboBox();
		comboBox.setBounds(94, 179, 162, 20);
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(94, 144, 162, 20);
		contentPane.add(comboBox_1);

		lblLimiteDeVezes = new JLabel("Limite de vezes utilizada:");
		lblLimiteDeVezes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLimiteDeVezes.setBounds(10, 49, 191, 14);
		contentPane.add(lblLimiteDeVezes);

		lblQtdDeQuestoes = new JLabel("Qtd. de Questoes Dissertativas:");
		lblQtdDeQuestoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQtdDeQuestoes.setBounds(10, 76, 201, 14);
		contentPane.add(lblQtdDeQuestoes);

		lblQtdDeQuestoes_1 = new JLabel("Qtd. de Questoes Optativas:");
		lblQtdDeQuestoes_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQtdDeQuestoes_1.setBounds(10, 101, 201, 14);
		contentPane.add(lblQtdDeQuestoes_1);

		textField = new JTextField();
		textField.setBounds(206, 23, 50, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(206, 48, 50, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(206, 74, 50, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(206, 101, 50, 20);
		contentPane.add(textField_3);
	}
}

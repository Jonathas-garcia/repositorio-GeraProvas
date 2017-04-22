package br.edu.unicid.view.Questao;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class PainelSelecionaAssunto extends JFrame {

	String pesquisa;

	private JPanel contentPane;
	public static String assuntoDesejado;
	private JLabel lblSelecioneUmNivel;
	private JButton btnVoltar;
	private JLabel lblDataDeCadastro;
	private JTextField textField;
	private JLabel label_1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelSelecionaAssunto frame = new PainelSelecionaAssunto();
					frame.setVisible(true);
					frame.setTitle("Pesquisar Questoes");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public PainelSelecionaAssunto() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox nivel = new JComboBox();
		nivel.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		nivel.setBounds(10, 79, 232, 22);
		contentPane.add(nivel);

		JComboBox assunto = new JComboBox();
		assunto.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		assunto.setBounds(10, 157, 232, 22);
		AssuntoDAO dao = new AssuntoDAO();
		for (Assunto a : dao.listarAssuntos()) {
			assunto.addItem(a.getTexto());
		}

		NivelDificuldadeDAO dao2 = new NivelDificuldadeDAO();
		for (NivelDificuldade n : dao2.listarNiveis()) {
			nivel.addItem(n.getTexto());
		}

		contentPane.add(assunto);

		JLabel lblNewLabel = new JLabel("Selecione um Assunto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(52, 122, 168, 16);
		contentPane.add(lblNewLabel);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String valorNivel = (String) nivel.getSelectedItem().toString();
				String valorAssunto = (String) assunto.getSelectedItem().toString();
				
				System.out.println("NIVEL: " + valorNivel);
				System.out.println("ASSUNTO: " + valorAssunto);

			if (valorNivel.equals("Todos") && !valorAssunto.equals("Todos")) {
					pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND assunto = \"" + valorAssunto + "\"";

				}

				else if (valorAssunto.equals("Todos") && !valorNivel.equals("Todos")) {
					pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific = \"" + valorNivel + "\"";
				}

				else if (!valorAssunto.equals("Todos") && !valorNivel.equals("Todos")) {
					pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific =\"" + valorNivel + "\" AND assunto=\""
							+ valorAssunto + "\"";

				} else if (valorAssunto.equals("Todos") && valorNivel.equals("Todos")) {
					pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1";
					System.out.println("cheg");
				}
				
			/*	if (valorNivel.equals("Todos") && !valorAssunto.equals("Todos")){
					pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific = " + valorAssunto + "";
				}

				else if (valorAssunto.equals("Todos") && !valorNivel.equals("Todos")) {
					pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific = " + valorNivel + "";
				}

				else if (!valorAssunto.equals("Todos") && !valorNivel.equals("Todos")) {
					pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1 AND nivelDific = " + valorNivel + " AND assunto= " + "'"
							+ valorAssunto + "'";

				} else if (valorAssunto.equals("Todos") && valorNivel.equals("Todos")) {
					pesquisa = "SELECT `cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` FROM questao WHERE estatus = 1";
					System.out.println("cheg");
				}
			 	*/
				ListarQuestoes frameListar = new ListarQuestoes();
				frameListar.filtro(pesquisa);
				frameListar.setVisible(true);
				setVisible(false);
			}
		});
		btnListar.setBounds(149, 263, 97, 25);
		contentPane.add(btnListar);

		lblSelecioneUmNivel = new JLabel("Selecione um Nivel");
		lblSelecioneUmNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecioneUmNivel.setBounds(65, 38, 139, 16);
		contentPane.add(lblSelecioneUmNivel);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 264, 89, 23);
		contentPane.add(btnVoltar);
		
		lblDataDeCadastro = new JLabel("Periodo de cadastro  da  quest\u00E3o");
		lblDataDeCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDeCadastro.setBounds(10, 199, 232, 16);
		contentPane.add(lblDataDeCadastro);
		
		textField = new JTextField();
		textField.setBounds(10, 226, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		label_1 = new JLabel("\u00E1");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(122, 226, 24, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 226, 86, 20);
		contentPane.add(textField_1);

	}
}

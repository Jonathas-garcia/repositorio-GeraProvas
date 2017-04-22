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

public class AlterarQuestaoDissertativa extends JFrame {

	private JPanel contentPane;
	private JLabel lblPergunta;
	private JLabel lblNewLabel;
	private JTextArea textAreaPergunta;
	private JTextArea respEsperada;
	private JButton voltar;
	private JButton Gravar;
	private JComboBox comboBoxAssuntos;
	int questaoAlterada;
	private JButton listarAssunto;
	private JButton listarNiveis;
	private JComboBox comboBoxNiveis;
	private JButton button;
	private JTextField textField;
	private JLabel lblAlterarImagem;
	private JTextField textField_1;
	private JButton button_1;
	private JLabel label;
	private JLabel lblAssunto;
	private JLabel lblNivel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		AlterarQuestaoDissertativa frame = new AlterarQuestaoDissertativa();
		frame.setVisible(true);
	}

	public AlterarQuestaoDissertativa() {
		alterarQuestao();

	}

	public void alterarQuestao() {

		setBounds(230, 30, 769, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textAreaPergunta = new JTextArea();
		textAreaPergunta.setBounds(10, 36, 738, 149);
		contentPane.add(textAreaPergunta);
		textAreaPergunta.setLineWrap(true);

		lblPergunta = new JLabel("PERGUNTA");
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPergunta.setBounds(334, 11, 176, 14);
		contentPane.add(lblPergunta);

		lblNewLabel = new JLabel("Resposta Esperada");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 249, 219, 14);
		contentPane.add(lblNewLabel);

		respEsperada = new JTextArea();
		respEsperada.setBounds(10, 274, 733, 149);
		contentPane.add(respEsperada);
		respEsperada.setLineWrap(true);

		voltar = new JButton("Voltar");
		voltar.setBounds(271, 532, 89, 23);
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
				String resp = respEsperada.getText();
				String assunto = (String) comboBoxAssuntos.getSelectedItem();
				String nivel = (String) comboBoxNiveis.getSelectedItem();
				Questao questao = new Questao(cod, pergunta, resp, assunto, nivel);

				try {
					QuestaoDAO dao = new QuestaoDAO();
					dao.atualizarDissertativa(questao, cod);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
					setVisible(false);
			}
		});
		Gravar.setBounds(396, 532, 89, 23);
		contentPane.add(Gravar);

		comboBoxAssuntos = new JComboBox();
		comboBoxAssuntos.setBounds(541, 442, 202, 20);
		contentPane.add(comboBoxAssuntos);

		comboBoxNiveis = new JComboBox();
		comboBoxNiveis.setBounds(164, 489, 202, 20);
		contentPane.add(comboBoxNiveis);
		
		button = new JButton("");
		button.setBounds(340, 196, 26, 26);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 199, 210, 20);
		contentPane.add(textField);
		
		lblAlterarImagem = new JLabel("Alterar Imagem:");
		lblAlterarImagem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlterarImagem.setBounds(10, 205, 219, 14);
		contentPane.add(lblAlterarImagem);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 437, 210, 20);
		contentPane.add(textField_1);
		
		button_1 = new JButton("");
		button_1.setBounds(340, 434, 26, 26);
		contentPane.add(button_1);
		
		label = new JLabel("Alterar Imagem:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(10, 443, 219, 14);
		contentPane.add(label);
		
		lblAssunto = new JLabel("Assunto:");
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAssunto.setBounds(10, 492, 219, 14);
		contentPane.add(lblAssunto);
		
		lblNivel = new JLabel("Nivel:");
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNivel.setBounds(396, 445, 219, 14);
		contentPane.add(lblNivel);

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
		respEsperada.setText(questao.getRespEsperada());
		
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
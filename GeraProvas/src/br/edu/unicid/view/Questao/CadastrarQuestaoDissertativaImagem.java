package br.edu.unicid.view.Questao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CadastrarQuestaoDissertativaImagem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarQuestaoDissertativaImagem frame = new CadastrarQuestaoDissertativaImagem();
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
	public CadastrarQuestaoDissertativaImagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Pergunta");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(172, 11, 59, 34);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 51, -63, 34);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 47, 336, 98);
		contentPane.add(scrollPane_1);
		
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		
		JButton btnAdicionarImagem = new JButton("Adicionar imagem");
		btnAdicionarImagem.setBounds(158, 156, 115, 23);
		contentPane.add(btnAdicionarImagem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(222, 190, 202, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBoxNiveis = new JComboBox();
		comboBoxNiveis.setBounds(222, 221, 202, 20);
		contentPane.add(comboBoxNiveis);
		
		JLabel label_1 = new JLabel("Assunto:");
		label_1.setBounds(139, 193, 73, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Nivel:");
		label_2.setBounds(149, 224, 46, 14);
		contentPane.add(label_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(63, 266, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(222, 266, 89, 23);
		contentPane.add(btnLimpar);
	}

}

package br.edu.unicid.view.NivelDificuldade;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarNivel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblAssunto;
	private JLabel lblTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarNivel frame = new CadastrarNivel();
					frame.setVisible(true);
					frame.setTitle("Cadastrar Niveis de Dificuldade");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarNivel() {

		setBounds(100, 100, 263, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(49, 62, 186, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 105, 97, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = textField.getText();
				String b = " ";

				NivelDificuldade nivel = new NivelDificuldade(texto);

				try {
					NivelDificuldadeDAO dao = new NivelDificuldadeDAO();
					dao.salvar(nivel);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro!");
				}

			}
		});
		btnNewButton_1.setBounds(138, 105, 97, 23);
		contentPane.add(btnNewButton_1);

		lblAssunto = new JLabel("Nivel de Dificuldade:");
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAssunto.setBounds(39, 27, 161, 14);
		contentPane.add(lblAssunto);
		
		lblTexto = new JLabel("Texto :");
		lblTexto.setBounds(10, 65, 46, 14);
		contentPane.add(lblTexto);
	}
}

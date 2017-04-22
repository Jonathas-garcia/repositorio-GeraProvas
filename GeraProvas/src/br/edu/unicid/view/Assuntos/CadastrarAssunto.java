package br.edu.unicid.view.Assuntos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.dao.AssuntoDAO;

public class CadastrarAssunto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnVoltar;
	private JButton btnSalvar;
	private JLabel lblAssunto;
	private static CadastrarAssunto frame;
	private JLabel lblTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CadastrarAssunto();
					frame.setVisible(true);
					frame.setTitle("Cadastrar Assunto");
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarAssunto() {

		setBounds(100, 100, 277, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(54, 57, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 105, 97, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				setVisible(false);
			}
		});
		contentPane.add(btnVoltar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = textField.getText();

				if (!texto.equals("")) {
					Assunto assunto = new Assunto(texto);
					try {
						AssuntoDAO dao = new AssuntoDAO();
						dao.salvar(assunto);
						setVisible(false);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Há campos obrigatórios a serem preenchidos");
				}

			}
		});
		btnSalvar.setBounds(154, 105, 97, 23);
		contentPane.add(btnSalvar);

		lblAssunto = new JLabel("Incluir Assunto");
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAssunto.setBounds(77, 21, 127, 14);
		contentPane.add(lblAssunto);

		lblTexto = new JLabel("Texto:");
		lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTexto.setBounds(10, 58, 46, 14);
		contentPane.add(lblTexto);
	}
}

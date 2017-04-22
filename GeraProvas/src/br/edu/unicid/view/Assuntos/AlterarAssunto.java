package br.edu.unicid.view.Assuntos;

import java.awt.BorderLayout;
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

public class AlterarAssunto extends JFrame {

	private JPanel contentPane;
	private JTextField txtAssunto;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblAssunto;
	int assuntoAlterado;
	private JLabel lblTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarAssunto frame = new AlterarAssunto();
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
	public AlterarAssunto() {

		setBounds(100, 100, 305, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtAssunto = new JTextField();
		txtAssunto.setBounds(58, 62, 203, 20);
		contentPane.add(txtAssunto);
		txtAssunto.setColumns(10);

		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(22, 105, 97, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = txtAssunto.getText();
				int cod = assuntoAlterado;

				Assunto assunto = new Assunto(cod, texto);

				try {
					AssuntoDAO dao = new AssuntoDAO();
					dao.atualizar(assunto, cod);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(150, 105, 97, 23);
		contentPane.add(btnNewButton_1);

		lblAssunto = new JLabel("Assunto");
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAssunto.setBounds(99, 35, 105, 14);
		contentPane.add(lblAssunto);
		
		lblTexto = new JLabel("Texto:");
		lblTexto.setBounds(12, 64, 56, 16);
		contentPane.add(lblTexto);
	}

	public void pegarValor(Assunto assunto) {

		txtAssunto.setText(assunto.getTexto());
		assuntoAlterado = assunto.getCodAssunt();

	}

}

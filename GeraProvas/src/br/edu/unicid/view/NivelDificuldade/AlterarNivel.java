package br.edu.unicid.view.NivelDificuldade;

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

import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.dao.NivelDificuldadeDAO;

public class AlterarNivel extends JFrame {

	private JPanel contentPane;
	private JTextField txtNivel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNivel;
	int nivelAlterado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarNivel frame = new AlterarNivel();
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
	public AlterarNivel() {

		setBounds(100, 100, 277, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNivel = new JTextField();
		txtNivel.setBounds(44, 56, 203, 20);
		contentPane.add(txtNivel);
		txtNivel.setColumns(10);

		btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 89, 97, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto = txtNivel.getText();
				int cod = nivelAlterado;

				NivelDificuldade nivel = new NivelDificuldade(cod, texto);

				try {
					NivelDificuldadeDAO dao = new NivelDificuldadeDAO();
					dao.atualizar(nivel, cod);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(150, 89, 97, 23);
		contentPane.add(btnNewButton_1);

		lblNivel = new JLabel("Alterar Nivel de Dificuldade");
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNivel.setBounds(37, 27, 210, 14);
		contentPane.add(lblNivel);
		
		JLabel label = new JLabel("Texto:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(0, 58, 46, 14);
		contentPane.add(label);
	}

	public void pegarValor(NivelDificuldade nivel) {

		txtNivel.setText(nivel.getTexto());
		nivelAlterado = nivel.getcodNivel();

	}
}

package br.edu.unicid.view.NivelDificuldade;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.bean.Questao;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;
import br.edu.unicid.dao.QuestaoDAO;

public class ListarNiveis extends JFrame {
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTable tabela;
	private JButton btnEditar;
	private JButton btnVoltar;
	private JButton apagar;
	private JTextField textField;
	private JLabel lblNome;
	private JLabel lblCa;
	private JTextField textField_1;
	private JButton btnPesquisar;
	private String caAl;
	private String nomeAluno;

	public static void main(String[] args) {

		ListarNiveis frame = new ListarNiveis();
		frame.setVisible(true);

	}

	public ListarNiveis() {

		// montar janela
		tabela = new JTable(modelo);
		JScrollPane barraRoll = new JScrollPane(tabela);
		modelo.addColumn("CODIGO");
		modelo.addColumn("NIVEL");
		modelo.addColumn("DATA");

		tabela.getColumnModel().getColumn(0).setPreferredWidth(0);// NAO ESTA
																	// DIMINUINDO
																	// O TAMANHO
																	// DA COLUNA
		tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
		setBounds(100, 100, 853, 541);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 10, 817, 448);
		contentPane.add(scrollPane);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int linhaSelecionada = -1;
				linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada >= 0) {
					int cod = (int) tabela.getValueAt(linhaSelecionada, 0);
					try {
						AlterarNivel frame = new AlterarNivel();
						NivelDificuldadeDAO dao = new NivelDificuldadeDAO();
						NivelDificuldade nivel = dao.exibirNivel(cod);

						frame.pegarValor(nivel);
						frame.setVisible(true);
						frame.setTitle("Alterar Nivel");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA");
				}

			}
		});
		btnEditar.setBounds(738, 469, 89, 23);
		contentPane.add(btnEditar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}

		});
		btnVoltar.setBounds(639, 469, 89, 23);
		contentPane.add(btnVoltar);

		try {
			NivelDificuldadeDAO dao = new NivelDificuldadeDAO();

			for (NivelDificuldade c : dao.listarNiveis()) {
				System.out.println(c.toString());
				modelo.addRow(new Object[] { c.getcodNivel(), c.getTexto(), c.getData() });

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private Object listarNiveis() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0); // zerar as linhas da tabela

	}
}

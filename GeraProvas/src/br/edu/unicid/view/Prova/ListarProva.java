package br.edu.unicid.view.Prova;

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
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.view.Assuntos.AlterarAssunto;

public class ListarProva extends JFrame {

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

	private JPanel contentPane;
	private JButton btnExcluir;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProva frame = new ListarProva();
					frame.setVisible(true);
					frame.setTitle("Editar e Excluir Provas");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarProva() {

		// montar janela
		tabela = new JTable(modelo);
		JScrollPane barraRoll = new JScrollPane(tabela);
		modelo.addColumn("CODIGO");
		modelo.addColumn("TITULO");
		modelo.addColumn("DATA");

		tabela.getColumnModel().getColumn(0).setPreferredWidth(100);// NAO ESTA
																	// DIMINUINDO
																	// O TAMANHO
																	// DA COLUNA
		tabela.getColumnModel().getColumn(1).setPreferredWidth(-10);
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
						AlterarAssunto frame = new AlterarAssunto();
						AssuntoDAO dao = new AssuntoDAO();
						Assunto assunto = dao.exibirAssunto(cod);

						frame.pegarValor(assunto);
						frame.setVisible(true);
						frame.setTitle("Alterar Questao");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "SELECIONE UMA LINHA");
				}

			}
		});
		btnEditar.setBounds(639, 469, 89, 23);
		contentPane.add(btnEditar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}

		});
		btnVoltar.setBounds(738, 469, 89, 23);
		contentPane.add(btnVoltar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(540, 469, 89, 23);
		contentPane.add(btnExcluir);

		button_1 = new JButton("Exibir");
		button_1.setBounds(441, 469, 89, 23);
		contentPane.add(button_1);

	}

	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0); // zerar as linhas da tabela

	}

}

package br.edu.unicid.view.Prova;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.dao.AssuntoDAO;
import br.edu.unicid.dao.NivelDificuldadeDAO;

public class GerarProva extends JFrame {
	
	String assuntosSalvos ;
	ArrayList<String> niveisSalvos = new ArrayList<>();

	
	private JPanel contentPane;
	private JTextField textDissertativas;
	private JTextField textUtilizadas;
	private JTextField textQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarProva frame = new GerarProva();
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
	
	// VAI ENVIAR PARA UMA TELA INFORMANDO AS QUESTOES QUE FORAM ESCOLHIDAS 
	// 
	public GerarProva() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox assunto = new JComboBox();
		assunto.setBounds(119, 115, 182, 20);
		contentPane.add(assunto);
		
		JComboBox nivel = new JComboBox();
		nivel.setBounds(10, 182, 182, 20);
		contentPane.add(nivel);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 222, 291, 217);
		contentPane.add(textArea);
		textArea.append("NIVEIS ADICIONADOS \n");
		
		JButton adicionarNivel = new JButton("Adicionar");
		adicionarNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int intAux = (int) nivel.getSelectedIndex();
				String aux = (String) nivel.getSelectedItem();
				niveisSalvos.add(aux);
				
				if (aux == null){
					adicionarNivel.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Não há mais niveis");
				}
				else {
				textArea.append("\n \nNivel Adicionado");
				textArea.append("\n" + niveisSalvos.toString());
				nivel.removeItemAt(intAux);
				}
				
			
		
				
			
			}
		});
		adicionarNivel.setBounds(196, 181, 105, 23);
		contentPane.add(adicionarNivel);
		
		JLabel lblQuantidadeDeQuestoes = new JLabel("Quantidade de Quest\u00F5es:  ");
		lblQuantidadeDeQuestoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidadeDeQuestoes.setBounds(10, 22, 182, 14);
		contentPane.add(lblQuantidadeDeQuestoes);
		
		JLabel lblLimiteDeVezes = new JLabel("Limite de Vezes Ultilizadas:");
		lblLimiteDeVezes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLimiteDeVezes.setBounds(10, 72, 182, 14);
		contentPane.add(lblLimiteDeVezes);
		
		JLabel lblQuantidadeDeDissertativas = new JLabel("Quantidade de Dissertativas:");
		lblQuantidadeDeDissertativas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidadeDeDissertativas.setBounds(10, 47, 182, 14);
		contentPane.add(lblQuantidadeDeDissertativas);
		
		textDissertativas = new JTextField("0");
		textDissertativas.setBounds(215, 46, 86, 20);
		contentPane.add(textDissertativas);
		textDissertativas.setColumns(10);
		
		textUtilizadas = new JTextField("0");
		textUtilizadas.setBounds(215, 72, 86, 20);
		contentPane.add(textUtilizadas);
		textUtilizadas.setColumns(10);
		
		textQuantidade = new JTextField("0");
		textQuantidade.setBounds(215, 21, 86, 20);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JLabel lblAssuntos = new JLabel("Assunto :");
		lblAssuntos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAssuntos.setBounds(10, 116, 182, 14);
		contentPane.add(lblAssuntos);
		
		JLabel lblNiveis = new JLabel("Niveis:");
		lblNiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNiveis.setBounds(10, 157, 182, 14);
		contentPane.add(lblNiveis);
		
		JButton avancar = new JButton("Avan\u00E7ar");
		avancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				int qtdUtilizada = Integer.parseInt(textUtilizadas.getText());
				int qtdQuestoes = Integer.parseInt(textQuantidade.getText());
				int qtdDissertativas = Integer.parseInt(textDissertativas.getText());
				
				if (qtdDissertativas > qtdQuestoes){
					JOptionPane.showMessageDialog(null,"Qtd. de Questoes dissertativas não pode ser maior que a qtd. de questões");
				}
				else{
				assuntosSalvos = (String) assunto.getSelectedItem();
			
				ProvaGerada frameGerado = new ProvaGerada();
				frameGerado.pesquisaGerada(assuntosSalvos, niveisSalvos, qtdUtilizada, qtdQuestoes, qtdDissertativas);
				frameGerado.setVisible(true);
				setVisible(false);
				}
				
			}
		});
		avancar.setBounds(190, 445, 89, 23);
		contentPane.add(avancar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				setVisible(false);
			}
		});
		btnVoltar.setBounds(41, 445, 89, 23);
		contentPane.add(btnVoltar);
		
	
		
		try {
			AssuntoDAO dao = new AssuntoDAO();
			for (Assunto a : dao.listarAssuntos()) {
				assunto.addItem(a.getTexto());
			}

			NivelDificuldadeDAO dao2 = new NivelDificuldadeDAO();
			for (NivelDificuldade n : dao2.listarNiveis()) {
				nivel.addItem(n.getTexto());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// UM ARRAY DE STRING
		//CONTADOR DE VEZES ADICIONADO
		//
	}
}

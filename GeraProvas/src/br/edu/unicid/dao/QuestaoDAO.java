package br.edu.unicid.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.Questao;
import br.edu.unicid.util.ConnectionFactory;

public class QuestaoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Questao questao;

	public QuestaoDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	public void salvarOptativa(Questao questao) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		int cod = 0;
		if (questao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO questao (cod, pergunta, tipo, altA, altB, altC, altD, altE, altCorreta, assunto, nivelDific, data, estatus) values (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, questao.setCod2(cod));// auto INCREMENT
			ps.setString(2, questao.getPergunta());
			ps.setString(3, "Optativa");
			ps.setString(4, questao.getAltA());
			ps.setString(5, questao.getAltB());
			ps.setString(6, questao.getAltC());
			ps.setString(7, questao.getAltD());
			ps.setString(8, questao.getAltE());
			ps.setString(9, questao.getAltCorreta());
			ps.setString(10, questao.getAssunto());
			ps.setString(11, questao.getNivelDific());
			ps.setString(12, String.valueOf(dataFormatada));
			ps.setBoolean(13, true);

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questao cadastrada!");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);

		}
	}

	public void salvarDissertativa(Questao questao) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		int cod = 0;
		if (questao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO questao (cod, pergunta, tipo, respEsperada, assunto, nivelDific, data, estatus) values (?,?,?, ?, ?, ?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, questao.setCod2(cod));// auto INCREMENT
			ps.setString(2, questao.getPergunta());
			ps.setString(3, "Dissertativa");
			ps.setString(4, questao.getRespEsperada());
			ps.setString(5, questao.getAssunto());
			ps.setString(6, questao.getNivelDific());
			ps.setString(7, String.valueOf(dataFormatada));
			ps.setBoolean(8, true);

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questao cadastrada!");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);

		}
	}

	// SALVAR DISSERTATIVA COM IMAGEM
	public boolean salvarDissertativaImagem(Questao questao) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		int cod = 0;
		if (questao == null)
			try {
				throw new Exception("O valor passado nao pode ser nulo");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}

		String SQL = "INSERT INTO questao (cod, tipo, imgPergunta, imgResp,  assunto, nivelDific, data, estatus) values (?,?,?, ?, ?, ?, ?, ?)";
		conn = this.conn;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cod);
			ps.setString(2, "Dissertativa/imagem");
			ps.setString(5, questao.getAssunto());
			ps.setString(6, questao.getNivelDific());
			ps.setString(7, String.valueOf(dataFormatada));
			ps.setBoolean(8, true);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questao cadastrada!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			try {
				ConnectionFactory.closeConnection(conn, ps);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// SALVAR OBJETIVA COM IMAGEM

	public boolean salvarObjetivaImg(Questao questao) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		int cod = 0;
		if (questao == null)
			try {
				throw new Exception("O valor passado nao pode ser nulo");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}

		String SQL = "INSERT INTO questao (cod, tipo, pergunta, imgPergunta, imgAltA, imgAltB, imgAltC, imgAltD, imgAltE, altCorreta, "
				+ "assunto, nivelDific, data, estatus) " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		conn = this.conn;
		try {
			FileInputStream is = null;
			FileInputStream is2 = null;
			FileInputStream is3 = null;
			FileInputStream is4 = null;
			FileInputStream is5 = null;
			FileInputStream is6 = null;

			File arquivo = null;
			File arquivo2 = null;
			File arquivo3 = null;
			File arquivo4 = null;
			File arquivo5 = null;
			File arquivo6 = null;

			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cod);
			ps.setString(2, "Optativa/imagem");
			ps.setString(3, questao.getPergunta());

			try {
				arquivo = new File(questao.getStringImgEnun());
				is = new FileInputStream(arquivo);
			} catch (FileNotFoundException e) {
				is = null;
				// arquivo = new File(questao.getStringImgEnun());
			}

			try {
				arquivo2 = new File(questao.getStringImgAltA());
				is2 = new FileInputStream(arquivo2);
			} catch (FileNotFoundException e) {
				is2 = null;
			}

			try {
				arquivo3 = new File(questao.getStringImgAltB());
				is3 = new FileInputStream(arquivo3);
			} catch (FileNotFoundException e) {
				is3 = null;
			}

			try {
				arquivo4 = new File(questao.getStringImgAltC());
				is4 = new FileInputStream(arquivo4);
			} catch (FileNotFoundException e) {
				is4 = null;
			}

			try {
				arquivo5 = new File(questao.getStringImgAltD());
				is5 = new FileInputStream(arquivo5);
			} catch (FileNotFoundException e) {
				is5 = null;
			}

			try {
				arquivo6 = new File(questao.getStringImgAltE());
				is6 = new FileInputStream(arquivo6);
			} catch (FileNotFoundException e) {
				is6 = null;
			}

			ps.setBinaryStream(4, is, arquivo.length());
			ps.setBinaryStream(5, is2, arquivo2.length());
			ps.setBinaryStream(6, is3, arquivo3.length());
			ps.setBinaryStream(7, is4, arquivo4.length());
			ps.setBinaryStream(8, is5, arquivo5.length());
			ps.setBinaryStream(9, is6, arquivo6.length());

			ps.setString(10, questao.getAltCorreta());
			ps.setString(11, questao.getAssunto());
			ps.setString(12, questao.getNivelDific());
			ps.setString(13, String.valueOf(dataFormatada));
			ps.setBoolean(14, true);
			if (ps.executeUpdate() == 1) {
				JOptionPane.showMessageDialog(null, "Questão cadastrada!");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, ps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public Questao retornaObjImg(int codigo) {
		Questao questao = null;

		try {
			conn = this.conn;
			String SQL = "SELECT * FROM questao WHERE imgPergunta is not null and tipo = \"optativa/imagem\" and cod = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int cod = rs.getInt(1);
				String pergunta = rs.getString(2);
				String altCorreta = rs.getString(10);
				String tipo = rs.getString(3);
				String assunto = rs.getString(11);
				String nivelDific = rs.getString(12);

				Blob b1 = rs.getBlob(22);
				int blob1 = (int) b1.length();
				byte[] imgPergunta = b1.getBytes(1, blob1);

				Blob b2 = rs.getBlob(17);
				int blob2 = (int) b2.length();
				byte[] imgAltA = b2.getBytes(1, blob2);

				Blob b3 = rs.getBlob(18);
				int blob3 = (int) b3.length();
				byte[] imgAltB = b3.getBytes(1, blob3);

				Blob b4 = rs.getBlob(19);
				int blob4 = (int) b4.length();
				byte[] imgAltC = b4.getBytes(1, blob4);

				Blob b5 = rs.getBlob(20);
				int blob5 = (int) b5.length();
				byte[] imgAltD = b3.getBytes(1, blob5);

				Blob b6 = rs.getBlob(21);
				int blob6 = (int) b6.length();
				byte[] imgAltE = b6.getBytes(1, blob6);

				questao = new Questao(cod, tipo, pergunta, imgPergunta, imgAltA, imgAltB, imgAltC, imgAltD, imgAltE,
						altCorreta, assunto, nivelDific);

				return questao;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return questao;
	}

	// RETORNA DISSERTATIVA COM IMAGEM
	public Questao retornaDissImg(int codigo) {
		Questao questao = null;

		try {
			conn = this.conn;
			String SQL = "SELECT * FROM questao WHERE imgPergunta is not null and tipo = \"Dissertativa/imagem\" and cod = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int cod = rs.getInt(1);
				String pergunta = rs.getString(2);
				String tipo = rs.getString(3);
				String assunto = rs.getString(11);
				String nivelDific = rs.getString(12);

				Blob b1 = rs.getBlob(22);
				int blob1 = (int) b1.length();
				byte[] imgPergunta = b1.getBytes(1, blob1);

				Blob b2 = rs.getBlob(22);
				int blob2 = (int) b2.length();
				byte[] imgResp = b2.getBytes(1, blob2);

				questao = new Questao(cod, tipo, pergunta, imgPergunta, imgResp, assunto, nivelDific);
				return questao;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return questao;
	}

	// SALVAR DISSERTATIVA COM IMAGEM
	public boolean salvarDissImg(Questao questao) throws IOException {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		int cod = 0;
		if (questao == null)
			try {
				throw new Exception("O valor passado nao pode ser nulo");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}

		String SQL = "INSERT INTO questao (cod, tipo, imgPergunta, imgResp,  assunto, nivelDific, data, estatus, pergunta, respEsperada) values (?,?,?, ?, ?, ?, ?, ?, ?, ?)";
		conn = this.conn;
		try {
			File arquivo;
			FileInputStream is;
			File arquivo2;
			FileInputStream fis;

			ps = conn.prepareStatement(SQL);
			ps.setInt(1, cod);
			ps.setString(2, "Dissertativa/imagem");

			try {
				arquivo = new File(questao.getStringImgEnun());
				is = new FileInputStream(arquivo);
			} catch (FileNotFoundException e) {
				arquivo = null;
				is = null;
			}

			try {
				arquivo2 = new File(questao.getStringImgRespEsp());
				fis = new FileInputStream(arquivo2);
			} catch (FileNotFoundException e) {
				arquivo2 = null;
				fis = null;
			}

			ps.setBinaryStream(3, is, arquivo.length());
			ps.setBinaryStream(4, fis, arquivo2.length());

			ps.setString(5, questao.getAssunto());
			ps.setString(6, questao.getNivelDific());
			ps.setString(7, String.valueOf(dataFormatada));
			ps.setBoolean(8, true);
			ps.setString(9, questao.getPergunta());
			ps.setString(10, questao.getRespEsperada());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questao cadastrada!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			try {
				ConnectionFactory.closeConnection(conn, ps);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Questao> todasQuestoes() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM questao WHERE estatus = true");
			rs = ps.executeQuery();
			List<Questao> list = new ArrayList<Questao>();
			while (rs.next()) {
				int cod = rs.getInt(1);
				String pergunta = rs.getString(2);
				String tipo = rs.getString(3);
				String altA = rs.getString(5);
				String altB = rs.getString(6);
				String altC = rs.getString(7);
				String altD = rs.getString(8);
				String altE = rs.getString(9);
				String altCorreta = rs.getString(10);
				String assunto = rs.getString(11);
				String nivel = rs.getString(12);
				String data = rs.getString(13);
				boolean estatus = rs.getBoolean(14);
				int qtd = rs.getInt(15);

				list.add(new Questao(cod, pergunta, tipo, altA, altB, altC, altD, altE, altCorreta, assunto, nivel,
						data, estatus, qtd));
			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

	public List<Questao> listarQuestaoPorAssunto(String assuntoDesejado) throws Exception {
		List<Questao> list = new ArrayList<Questao>();
		try {
			conn = this.conn;
			String sql = "SELECT *  FROM questao WHERE estatus = 1 and assunto=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, assuntoDesejado);
			rs = ps.executeQuery();

			while (rs.next()) {
				int cod = rs.getInt(1);
				String pergunta = rs.getString(2);
				String altA = rs.getString(3);
				String altB = rs.getString(4);
				String altC = rs.getString(5);
				String altD = rs.getString(6);
				String altE = rs.getString(7);
				String altCorreta = rs.getString(8);
				String assunto = rs.getString(9);
				String nivel = rs.getString(10);
				String data = rs.getString(11);
				boolean estatus = rs.getBoolean(12);
				list.add(new Questao(cod, pergunta, altA, altB, altC, altD, altE, altCorreta, assunto, nivel, data,
						estatus));
			}
			if (!list.isEmpty()) {
				for (Questao q : list)
					System.out.println(q.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Nenhuma questão cadastrada neste assunto");
			}

		} catch (SQLException sqle) {
			throw new Exception(sqle);
		}

		return list;
	}
	// INATIVAR QUESTAO

	public void inativar(int cod) throws Exception {
		try {
			String SQL = "UPDATE questao set estatus= false  WHERE cod =" + cod;

			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questao Inativada");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// ATIVAR QUESTAO
	public void ativar(int cod) throws Exception {
		try {
			String SQL = "UPDATE questao set estatus= true  WHERE cod =" + cod;

			conn = this.conn;
			ps = conn.prepareStatement(SQL);

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questao Ativada!");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	///

	public Questao exibirQuestao(int cod) throws Exception {
		try {
			String SQL = "SELECT * FROM questao WHERE cod=" + cod;
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codQuestao = rs.getInt(1);
				String pergunta = rs.getString(2);
				String altA = rs.getString(5);
				String altB = rs.getString(6);
				String altC = rs.getString(7);
				String altD = rs.getString(8);
				String altE = rs.getString(9);
				String altCorreta = rs.getString(10);
				String assunto = rs.getString(11);
				String difi = rs.getString(12);
				String data = rs.getString(13);
				boolean est = rs.getBoolean(12);

				questao = new Questao(codQuestao, pergunta, altA, altB, altC, altD, altE, altCorreta, assunto, difi,
						data, est);
			}

			return questao;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		}
	}

	// exibir questao dissertativa
	public Questao exibirQuestaoDissertativa(int cod) throws Exception {
		try {
			String SQL = "SELECT cod,pergunta,respEsperada,assunto, nivelDific,data,estatus FROM questao WHERE cod="
					+ cod;
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codQuestao = rs.getInt(1);
				String pergunta = rs.getString(2);
				String respEsperada = rs.getString(3);
				String assunto = rs.getString(4);
				String difi = rs.getString(5);
				String data = rs.getString(6);
				boolean est = rs.getBoolean(7);

				questao = new Questao(codQuestao, pergunta, respEsperada, assunto, difi, data, est);
			}

			return questao;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		}
	}

	// EXCLUI PROVA
	public Questao tabelaExclui(int cod) throws Exception {
		try {
			String SQL = "SELECT cod, pergunta, tipo, assunto, nivelDific, data, qtdUtilizada FROM questao WHERE cod="
					+ cod;
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				int cod2 = rs.getInt(1);
				String pergunta = rs.getString(2);
				String tipo = rs.getString(3);
				String assunto = rs.getString(4);
				String nivel = rs.getString(5);
				String data = rs.getString(6);
				int qtd = rs.getInt(7);

				questao = new Questao(cod2, pergunta, tipo, assunto, nivel, data, qtd);
			}

			return questao;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		}
	}

	// PREVIA PROVA

	public Questao previaProva(int cod) throws Exception {
		Questao q = null;

		try {
			String SQL = "SELECT * FROM questao WHERE cod=" + cod;
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				String tipo = rs.getString(3);
				System.out.println(tipo);

				if (tipo.equalsIgnoreCase("Optativa/imagem")) {
					System.out.println("if(tipo.equals(Optativa/imagem)){");
					String pergunta = rs.getString(2);
					String altCorreta = rs.getString(10);

					Blob b1, b2, b3, b4, b5, b6;
					int blob1, blob2, blob3, blob4, blob5, blob6;
					byte[] imgPergunta, imgAltA, imgAltB, imgAltC, imgAltD, imgAltE;

					try {
						b1 = rs.getBlob(22);
						blob1 = (int) b1.length();
						imgPergunta = b1.getBytes(1, blob1);
					} catch (NullPointerException e) {
						b1 = null;
						blob1 = 1;
						imgPergunta = null;
					}

					try {
						b2 = rs.getBlob(17);
						blob2 = (int) b2.length();
						imgAltA = b2.getBytes(1, blob2);
					} catch (NullPointerException e) {
						b2 = null;
						blob2 = 1;
						imgAltA = null;
					}
					try {
						b3 = rs.getBlob(18);
						blob3 = (int) b3.length();
						imgAltB = b3.getBytes(1, blob3);
					} catch (NullPointerException e) {
						b3 = null;
						blob3 = 1;
						imgAltB = null;
					}
					try {
						b4 = rs.getBlob(19);
						blob4 = (int) b4.length();
						imgAltC = b4.getBytes(1, blob4);
					} catch (NullPointerException e) {
						b4 = null;
						blob4 = 1;
						imgAltC = null;
					}

					try {
						b5 = rs.getBlob(20);
						blob5 = (int) b5.length();
						imgAltD = b5.getBytes(1, blob5);
					} catch (NullPointerException e) {
						b5 = null;
						blob5 = 1;
						imgAltD = null;
					}
					try {
						b6 = rs.getBlob(21);
						blob6 = (int) b6.length();
						imgAltE = b6.getBytes(1, blob6);
					} catch (NullPointerException e) {
						b6 = null;
						blob6 = 1;
						imgAltE = null;
					}

					q = new Questao(cod, tipo, pergunta, imgPergunta, imgAltA, imgAltB, imgAltC, imgAltD, imgAltE,
							altCorreta, altCorreta, altCorreta);
					return q;
				} else if (tipo.equalsIgnoreCase("Dissertativa/Imagem")) {
					System.out.println("tipo.equals(Dissertativa/Imagem)");
					String pergunta = rs.getString(2);
					Blob b1 = rs.getBlob(22);
					int blob1 = (int) b1.length();
					byte[] imgPergunta = b1.getBytes(1, blob1);

					Blob b2 = rs.getBlob(22);
					int blob2 = (int) b2.length();
					byte[] imgResp = b2.getBytes(1, blob2);

					q = new Questao(cod, tipo, pergunta, imgPergunta, imgResp);
					return q;
				} else if (tipo.equalsIgnoreCase("Dissertativa")) {
					System.out.println("tipo.equals(Dissertativa)");
					String pergunta = rs.getString(2);
					String esperada = rs.getString(4);

					q = new Questao(cod, tipo, pergunta, esperada);
					return q;
				} else {
					System.out.println("ELSE");
					String pergunta = rs.getString(2);
					String altA = rs.getString(5);
					String altB = rs.getString(6);
					String altC = rs.getString(7);
					String altD = rs.getString(8);
					String altE = rs.getString(9);
					String altCorreta = rs.getString(10);
					q = new Questao(cod, tipo, pergunta, altA, altB, altC, altD, altE, altCorreta);
					return q;
				}

			}

			return q;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		}
	}

	// ATUALIZAR QUESTÃO

	public void atualizar(Questao questao, int cod) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		if (questao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE questao set pergunta=?, altA=?, altB=?, altC=?, altD=?, altE=?, altCorreta=?, assunto=?, nivelDific=?, data=? WHERE cod ="
					+ cod;

			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, questao.getPergunta());
			ps.setString(2, questao.getAltA());
			ps.setString(3, questao.getAltB());
			ps.setString(4, questao.getAltC());
			ps.setString(5, questao.getAltD());
			ps.setString(6, questao.getAltE());
			ps.setString(7, questao.getAltCorreta());
			ps.setString(8, questao.getAssunto());
			ps.setString(9, questao.getNivelDific());
			ps.setString(10, String.valueOf(dataFormatada));

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questão atualizado com sucesso!");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// atualizar dissertativa

	public void atualizarDissertativa(Questao questao, int cod) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		if (questao == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE questao set pergunta=?, respEsperada=?, assunto=?, nivelDific=?, data=? WHERE cod ="
					+ cod;

			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, questao.getPergunta());
			ps.setString(2, questao.getRespEsperada());
			ps.setString(3, questao.getAssunto());
			ps.setString(4, questao.getNivelDific());
			ps.setString(5, String.valueOf(dataFormatada));

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questão atualizado com sucesso!");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// PESQUISAR QUESTOES INATIVAS

	public List<Questao> todasQuestoesInativas() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM questao WHERE estatus = false");
			rs = ps.executeQuery();
			List<Questao> list = new ArrayList<Questao>();
			while (rs.next()) {
				int cod = rs.getInt(1);
				String pergunta = rs.getString(2);
				String tipo = rs.getString(3);
				String altA = rs.getString(5);
				String altB = rs.getString(6);
				String altC = rs.getString(7);
				String altD = rs.getString(8);
				String altE = rs.getString(9);
				String altCorreta = rs.getString(10);
				String assunto = rs.getString(11);
				String nivel = rs.getString(12);
				String data = rs.getString(13);
				boolean estatus = rs.getBoolean(14);
				int qtd = rs.getInt(15);

				list.add(new Questao(cod, pergunta, tipo, altA, altB, altC, altD, altE, altCorreta, assunto, nivel,
						data, estatus, qtd));
			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

	public List<Questao> filtrarQuestoes(String pesquisa) throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement(pesquisa);
			rs = ps.executeQuery();
			int qtd = 0;
			List<Questao> list = new ArrayList<Questao>();
			while (rs.next()) {

				if (pesquisa.contains("`cod`, `pergunta`, `assunto`, `nivelDific`, `data`, `qtdUtilizada` ")) {
					int cod = rs.getInt(1);
					String pergunta = rs.getString(2);
					String assunto = rs.getString(3);
					String nivel = rs.getString(4);
					String data = rs.getString(5);
					qtd = rs.getInt(6);
					list.add(new Questao(cod, pergunta, assunto, nivel, data, qtd));
				} else {
					int cod = rs.getInt(1);
					String pergunta = rs.getString(2);
					String assunto = rs.getString(3);
					String nivel = rs.getString(4);
					String data = rs.getString(5);
					qtd = rs.getInt(15);
					list.add(new Questao(cod, pergunta, assunto, nivel, data, qtd));
				}

			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

	public void guardaNota(int codigoQuestao, double notaQuestao) throws Exception {

		try {
			String SQL = "UPDATE questao set notaQuestao=?,  qtdUtilizada = qtdUtilizada+1  WHERE cod ="
					+ codigoQuestao;
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setDouble(1, notaQuestao);
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	public List<Questao> filtrarQuestoes2(String pesquisa) throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement(pesquisa);
			rs = ps.executeQuery();
			int qtd = 0;
			List<Questao> list = new ArrayList<Questao>();
			while (rs.next()) {

				int cod = rs.getInt(1);
				String pergunta = rs.getString(2);
				String tipo = rs.getString(3);
				String assunto = rs.getString(4);
				String nivel = rs.getString(5);
				String data = rs.getString(6);
				qtd = rs.getInt(7);
				list.add(new Questao(cod, pergunta, tipo, assunto, nivel, data, qtd));

			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

	public List<Questao> filtrarQuestaoEditar(String pesquisa) throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement(pesquisa);
			rs = ps.executeQuery();
			int qtd = 0;
			List<Questao> list = new ArrayList<Questao>();
			while (rs.next()) {

				int codQuestao = rs.getInt(1);
				String pergunta = rs.getString(2);
				String assunto = rs.getString(3);
				String difi = rs.getString(4);
				String data = rs.getString(5);
				int ultilizadas = rs.getInt(6);

				list.add(new Questao(codQuestao, pergunta, assunto, difi, data, ultilizadas));

			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

	public List<Questao> filtrarQuestoesProva(String pesquisa) throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement(pesquisa);
			rs = ps.executeQuery();
			int cod;
			String pergunta = "";
			String tipo = "";
			String assunto = "";
			String nivel = "";

			int qtd = 0;
			String data = "";

			List<Questao> list = new ArrayList<Questao>();
			while (rs.next()) {

				if (pesquisa.contains("tipo")) {
					cod = rs.getInt(1);
					pergunta = rs.getString(2);
					tipo = rs.getString(3);
					assunto = rs.getString(4);
					nivel = rs.getString(5);
					qtd = rs.getInt(7);
					data = rs.getString(6);
				} else {
					cod = rs.getInt(1);
					pergunta = rs.getString(2);
					assunto = rs.getString(3);
					nivel = rs.getString(4);
					data = rs.getString(5);
					qtd = rs.getInt(6);
				}

				list.add(new Questao(cod, pergunta, tipo, assunto, nivel, data, qtd));
			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

}

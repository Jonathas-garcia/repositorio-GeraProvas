package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.NivelDificuldade;
import br.edu.unicid.util.ConnectionFactory;

public class NivelDificuldadeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private NivelDificuldade nivel;

	public NivelDificuldadeDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	public void salvar(NivelDificuldade nivel) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		int cod = 0;
		if (nivel == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO nivel values (?,?,?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, nivel.setCodNivel2(cod));
			ps.setString(2, nivel.getTexto());
			ps.setString(3, String.valueOf(dataFormatada));
			ps.setBoolean(4, true);

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Nivel cadastrado !");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);

		}
	}

	public List<NivelDificuldade> todosNiveis() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT (texto) FROM `nivel` WHERE estatus = TRUE ");
			rs = ps.executeQuery();
			List<NivelDificuldade> list = new ArrayList<NivelDificuldade>();
			while (rs.next()) {
				String texto = rs.getString(1);
				list.add(new NivelDificuldade(texto));
			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

	public List<NivelDificuldade> listarNiveis() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM nivel WHERE estatus = TRUE ");
			rs = ps.executeQuery();
			List<NivelDificuldade> list = new ArrayList<NivelDificuldade>();
			while (rs.next()) {
				int cod = rs.getInt(1);
				String texto = rs.getString(2);
				String data = rs.getString(3);
				list.add(new NivelDificuldade(cod, texto, data));
			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}
	// EXIBIR Nivel

	public NivelDificuldade exibirNivel(int cod) throws Exception {
		try {
			String SQL = "SELECT * FROM nivel WHERE codNivel=" + cod;
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codAssunto = rs.getInt(1);
				String texto = rs.getString(2);
				String data = rs.getString(3);

				nivel = new NivelDificuldade(codAssunto, texto, data);
			}

			return nivel;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// atualizar Nivel
	public void atualizar(NivelDificuldade nivel, int cod) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		if (nivel == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE nivel set texto=?, data=? WHERE codNivel =" + cod;

			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, nivel.getTexto());
			ps.setString(2, String.valueOf(dataFormatada));

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questão atualizado com sucesso!");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// inativar
	public void inativar(int cod) throws Exception {
		try {
			String SQL = "UPDATE nivel set estatus= 0  WHERE codNivel =" + cod;

			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Nivel de Dificuldade Desativado");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// ATIVAR
	public void ativar(int cod) throws Exception {
		try {
			String SQL = "UPDATE nivel set estatus= 1  WHERE codNivel =" + cod;

			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Nivel de Dificuldade Ativado");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	public List<NivelDificuldade> niveisInativos() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM nivel WHERE estatus = 0 ");
			rs = ps.executeQuery();
			List<NivelDificuldade> list = new ArrayList<NivelDificuldade>();
			while (rs.next()) {
				int cod = rs.getInt(1);
				String texto = rs.getString(2);
				String data = rs.getString(3);
				list.add(new NivelDificuldade(cod, texto, data));
			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

}
package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.unicid.bean.Assunto;
import br.edu.unicid.util.ConnectionFactory;

public class AssuntoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Assunto assunto;

	public AssuntoDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	public void salvar(Assunto assunto) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		int cod = 0;
		if (assunto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO assunto (codAssunto, texto, data, estatus ) values (?,?,?,?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, assunto.setCod2(cod));
			ps.setString(2, assunto.getTexto());
			ps.setString(3, String.valueOf(dataFormatada));
			ps.setBoolean(4, true);

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Assunto cadastrado !");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);

		}
	}

	public List<Assunto> todosAssuntos() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM `assunto` WHERE estatus = TRUE ");
			rs = ps.executeQuery();
			List<Assunto> list = new ArrayList<Assunto>();
			while (rs.next()) {
				String texto = rs.getString(2);
				list.add(new Assunto(texto));
			}
			if (list.isEmpty())
				JOptionPane.showMessageDialog(null, "Não há assunto cadastrados");

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}

	public List<Assunto> listarAssuntos() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM assunto WHERE estatus = 1 ");
			rs = ps.executeQuery();
			List<Assunto> list = new ArrayList<Assunto>();
			while (rs.next()) {
				int cod = rs.getInt(1);
				String texto = rs.getString(2);
				String data = rs.getString(3);
				Assunto a = new Assunto(cod, texto, data);
				list.add(a);

			}

			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}

	}
	// EXIBIR ASSUNTO

	public Assunto exibirAssunto(int cod) throws Exception {
		try {
			String SQL = "SELECT * FROM assunto WHERE codAssunto=" + cod;
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codAssunto = rs.getInt(1);
				String texto = rs.getString(2);
				String data = rs.getString(3);

				assunto = new Assunto(codAssunto, texto, data);
			}

			return assunto;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// atualizar assunto
	public void atualizar(Assunto assunto, int cod) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		if (assunto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE assunto set texto=?, data=? WHERE codAssunto =" + cod;
			System.out.println(cod);
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, assunto.getTexto());
			ps.setString(2, String.valueOf(dataFormatada));

			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Questão atualizado com sucesso!");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	public void atualizarAssunto(Assunto assunto) throws Exception {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf2.format(hora);
		if (assunto == null)
			throw new Exception("O valor passado nao pode ser nulo");

		try {
			String SQL = "UPDATE assunto set texto=?, data=? WHERE codAssunto = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, assunto.getTexto());
			ps.setString(2, assunto.getData());
			ps.setInt(3, assunto.getCodAssunt());

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
			String SQL = "UPDATE assunto set estatus= 0  WHERE codAssunto =" + cod;
			
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Assunto Inativado");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	//ATIVAR ASSUNTO
	
	public void ativar(int cod) throws Exception {		
		try {
			String SQL = "UPDATE assunto set estatus= 1  WHERE codAssunto =" + cod;
			
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Assunto Ativado");
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	
	//Assuntos inativos 
	public List<Assunto> assuntosInativos() throws Exception {
			try {
				conn = this.conn;
				ps = conn.prepareStatement("SELECT * FROM assunto WHERE estatus = 0 ");
				rs = ps.executeQuery();
				List<Assunto> list = new ArrayList<Assunto>();
				while (rs.next()) {
					int cod = rs.getInt(1);
					String texto = rs.getString(2);
					String data = rs.getString(3);
					Assunto a = new Assunto(cod, texto, data);
					list.add(a);

				}

				return list;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
			} finally {
				ConnectionFactory.closeConnection(conn, ps, rs);
			}

		}
	
}
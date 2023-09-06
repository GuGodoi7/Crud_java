package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.fiap.bean.Cliente;

public class ClienteDAO {
	private Connection con;

	
	
	public ClienteDAO(Connection con) {
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Cliente cliente) {
		String sql = "insert into cliente(IdCliente,NomeCliente,placa) values(?,?,?)";
		System.out.println(sql);
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}	
	public String alterar(Cliente cliente) {
		String sql = "update cliente set nomecliente = ?, placa = ?";
		sql += "where idcliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getPlaca());
			ps.setInt(3, cliente.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Atualizado com sucesso.";
			} else {
				return "Erro ao Alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public String excluir(Cliente cliente) {
		String sql = "delete from cliente where placa = ?";
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso.";
			} else {
				return "Excluido ao Alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public ArrayList<Cliente> listarTodos() {
		String sql = "Select * from cliente ";
		ArrayList<Cliente> listacliente = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs!= null) {
				while (rs.next() ) {
					Cliente cb = new Cliente();
					cb.setPlaca(rs.getString(1));
					cb.setIdCliente(2);
					cb.setNomeCliente(rs.getString(3));
					listacliente.add(cb);
				}
				return listacliente;
			} else {
				return null;

			}
		} catch (SQLException e) {
			return null;
		}
	}

}

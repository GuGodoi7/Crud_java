package br.com.fiap.main;

import java.sql.Connection;

import br.com.fiap.bean.Carro;
import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.Conexao;

public class TesteExcluir {
	public static void main(String[] args) {
			Connection con = Conexao.abrirConexao();
			
			Carro cb = new Carro();
			CarroDAO cd = new CarroDAO(con);
			cb.setPlaca("Duo4805");
			System.out.println(cd.excluir(cb));
			
			Conexao.fecharConexao(con);
	}

}

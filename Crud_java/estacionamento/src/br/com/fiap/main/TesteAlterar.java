package br.com.fiap.main;

import java.sql.Connection;

import br.com.fiap.bean.Carro;
import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.Conexao;

public class TesteAlterar {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Carro cb = new Carro();
		CarroDAO cd = new CarroDAO(con);
		cb.setPlaca("Duo4805");
		cb.setCor("Cinza");
		cb.setDescricao("Carro Barbie");
		System.out.println(cd.alterar(cb));
		
		Conexao.fecharConexao(con);

	}

}

package br.com.fiap.main;

import java.sql.Connection;

import br.com.fiap.bean.Carro;
import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.Conexao;

public class TesteInserir {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		
		Carro cb = new Carro();
		CarroDAO cd = new CarroDAO(con);
		
		//Testetando Método inserir
		cb.setPlaca("zzz9999");
		cb.setCor("vermelho");
		cb.setDescricao("Carro 3");
		System.out.println(cd.inserir(cb));
		
		Conexao.fecharConexao(con);
	}

}

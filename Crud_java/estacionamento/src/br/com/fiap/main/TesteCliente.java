package br.com.fiap.main;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.fiap.bean.Cliente;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.Conexao;

public class TesteCliente {

	public static void main(String[] args) {
	Connection con = Conexao.abrirConexao();
			
			Cliente cb = new Cliente();
			ClienteDAO cd = new ClienteDAO(con);
//			
//			//Testetando Método inserir
//			cb.setPlaca("zzz9999");
//			cb.setIdCliente(1234);
//			cb.setNomeCliente("Gustavo");
//			System.out.println(cd.inserir(cb));
//			
//			//Testetando Método Alterar
//			cb.setIdCliente(1234);
//			cb.setPlaca("Duo4805");
//			cb.setNomeCliente("Matheus");
//			System.out.println(cd.alterar(cb));
			
//		//Testetando Método Excluir
//		cb.setIdCliente(2);;
//		System.out.println(cd.excluir(cb));
//			
			//Testetando Método 
		ArrayList<Cliente> lista = cd.listarTodos();
			
			if (lista != null) {
			for (Cliente cliente : lista) {
				System.out.println("placa: " + cliente.getPlaca());
				System.out.println("IdCliente: " + cliente.getIdCliente());
				System.out.println("Nome Cliente: " + cliente.getNomeCliente());
				}
			}
			
			Conexao.fecharConexao(con);
	
	

	}

}

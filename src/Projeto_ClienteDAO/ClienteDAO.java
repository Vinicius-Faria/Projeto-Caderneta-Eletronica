package Projeto_ClienteDAO;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import Projeto_Salva_Dados_textField_Cadastro.Cliente_add;
//
//public class ClienteDAO {
//	
//	private static List<Cliente_add> ClienteData;
//	
//	public ClienteDAO() {
//		ClienteData = new ArrayList<Cliente_add>();
//	}
//	
//	public void save(Cliente_add cliente) {
//		ClienteData.add(cliente);
//	}
//	
//	public List<Cliente_add> getAll(){
//		return ClienteData;
//	}
//	
//}

import Projeto_Salva_Dados_textField_Cadastro.Cliente_add;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {

	private Connection connection;
	
	public ClienteDAO() throws SQLException {
		connection = ConnectionDAO.getConnection();
	}
	
	public void save(Cliente_add cliente) {
		String sql = "INSERT INTO CLIENTES (NOME, CPF, RG, ENDERECO, CELL, LIMITE) "
				+ "values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 1;
			statement.setString(index++, cliente.getNome());
			statement.setString(index++, cliente.getCpf());
			statement.setString(index++, cliente.getRg());
			statement.setString(index++, cliente.getEndereco());
			statement.setString(index++, cliente.getCell());
			statement.setDouble(index++, cliente.getLimite());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente_add> getAll() {
		List<Cliente_add> clientes = new ArrayList<Cliente_add>();
		
		String sql = "SELECT * FROM CLIENTES";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Cliente_add cliente = new Cliente_add();
				cliente.setNome(result.getString("NOME"));
				cliente.setCpf(result.getString("CPF"));
				cliente.setRg(result.getString("RG"));
				cliente.setEndereco(result.getString("ENDERECO"));
				cliente.setCell(result.getString("CELL"));
				cliente.setLimite(result.getDouble("LIMITE"));
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public void update(Cliente_add cliente) {
		//Cliente_add clientes = new Cliente_add();
		
		String sql = "UPDATE CLIENTES"
				+" SET NOME = '"+cliente.getNome()
				+"',RG = '"+cliente.getRg()
				+"',ENDERECO = '"+cliente.getEndereco()
				+"',CELL = '"+cliente.getCell()
				+"',LIMITE = '"+cliente.getLimite()
				+"'WHERE CPF = '"+cliente.getCpf()
				+"'";
		
				try{
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.execute();
				}catch (SQLException e) {
					e.printStackTrace();
				}
	}

	public void excluir(Cliente_add cliente) {
		//Cliente_add clientes = new Cliente_add();
		
		String sql_excluir = "DELETE FROM CONTAS WHERE CPF_CLIENTE = '"
				+ cliente.getCpf() + "';"
		+"DELETE FROM CLIENTES WHERE CPF = '" + cliente.getCpf() + "'";
		
				try{
					PreparedStatement statement = connection.prepareStatement(sql_excluir);
					statement.execute();
				}catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	
}
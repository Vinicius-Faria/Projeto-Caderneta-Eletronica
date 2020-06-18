package Projeto_ClienteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Projeto_Salva_Dados_textField_Cadastro.Conta_add;

public class ContaDAO {
	
private Connection connection;
	
	public ContaDAO() throws SQLException {
		connection = ConnectionDAO.getConnection();
	}
	
	public void save(Conta_add conta) throws Exception {
		String sql = "INSERT INTO CONTAS (VALOR_RECEBIDO, PEGUE_POR, VALOR_PRAZO, CPF_CLIENTE,"
				+ "NOME_CLIENTE, DATA_PRAZO )"
				+ "values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 1;
			statement.setDouble(index++, conta.getValor_Recebido());
			statement.setString(index++, conta.getPegue_por());
			statement.setDouble(index++, conta.getValor_Prazo());
			statement.setString(index++, conta.getCpf_Cliente());
			statement.setString(index++, conta.getNome_Cliente());
			statement.setString(index++,conta.getData_Prazo());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Conta_add> getAll() {
		List<Conta_add> contas = new ArrayList<Conta_add>();
		
		String sql = "SELECT * FROM CONTAS";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Conta_add conta = new Conta_add();
				conta.setNome_Cliente(result.getString("NOME_CLIENTE"));
				conta.setCpf_Cliente(result.getString("CPF_CLIENTE"));
				conta.setPegue_por(result.getString("PEGUE_POR"));
				conta.setValor_Prazo(result.getDouble("VALOR_PRAZO"));
				conta.setValor_Recebido(result.getDouble("VALOR_RECEBIDO"));
				conta.setData_Prazo(result.getString("DATA_PRAZO"));
				contas.add(conta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contas;
	}
	
public List<Conta_add> SQL_TABLE(String Cpf) {
		
		List<Conta_add> contas = new ArrayList<Conta_add>();
		
		String sql = "SELECT VALOR_PRAZO, DATA_PRAZO, PEGUE_POR FROM CONTAS"
    			+ " WHERE CPF_CLIENTE = '" + Cpf + "'";
	
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){
				Conta_add conta = new Conta_add();
				conta.setData_Prazo(result.getString("DATA_PRAZO"));
				conta.setPegue_por(result.getString("PEGUE_POR"));
				conta.setValor_Prazo(result.getDouble("VALOR_PRAZO"));
				contas.add(conta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return contas;
	}


	public boolean SQL_VERIFICA(Conta_add conta){

		Double Total_Com=0.0;
		Double Total_Text=0.0;
		Double Sub_Text=0.0;
		Double Total=0.0;
		Double Total_pago=0.0;
		Double Lim=0.0;
		
		
		String sql = "SELECT SUM (VALOR_PRAZO) AS TOTAL, SUM (VALOR_RECEBIDO) AS TOTAL2 " 
					 +"FROM CONTAS " 
					 +"WHERE CPF_CLIENTE = '"
					 + conta.getCpf_Cliente() + "'" ;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);	
		    while(result.next()){
		    Total = result.getDouble("TOTAL");
			Total_pago = result.getDouble("TOTAL2");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Total_Text  = conta.getValor_Prazo();
		Sub_Text = conta.getValor_Recebido();
		
		String sql_limite = "SELECT LIMITE FROM CLIENTES WHERE CPF = '"
				 + conta.getCpf_Cliente() + "' ";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql_limite);	
		    while(result.next())
			Lim = result.getDouble("LIMITE");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Total_Com = ((Total_Text) + (Total - Total_pago))- Sub_Text;
		
		if(Total_Com < Lim)return true;
		
		return false;
		
	}

	public List<Conta_add> SQL_TABLE_Relatorio_Data(String data){
		
		List<Conta_add> contas = new ArrayList<Conta_add>();
		
		String sql = "SELECT DATA_PRAZO, NOME_CLIENTE, VALOR_PRAZO, VALOR_RECEBIDO FROM CONTAS"
    			+ " WHERE DATA_PRAZO = '" + data + "' ORDER BY NOME_CLIENTE";
	
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){
				Conta_add conta = new Conta_add();
				conta.setData_Prazo(result.getString("DATA_PRAZO"));
				conta.setNome_Cliente(result.getString("NOME_CLIENTE"));
				conta.setValor_Prazo(result.getDouble("VALOR_PRAZO"));
				conta.setValor_Recebido(result.getDouble("VALOR_RECEBIDO"));
				contas.add(conta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return contas;
		
		
	}
	
	
public List<Conta_add> SQL_TABLE_Relatorio_Cliente(String CPF){
		
		List<Conta_add> contas = new ArrayList<Conta_add>();
		
		String sql = "SELECT DATA_PRAZO, NOME_CLIENTE, VALOR_PRAZO, VALOR_RECEBIDO FROM CONTAS"
    			+ " WHERE CPF_CLIENTE = '" + CPF + "' ORDER BY DATA_PRAZO";
	
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()){
				Conta_add conta = new Conta_add();
				conta.setData_Prazo(result.getString("DATA_PRAZO"));
				conta.setNome_Cliente(result.getString("NOME_CLIENTE"));
				conta.setValor_Prazo(result.getDouble("VALOR_PRAZO"));
				conta.setValor_Recebido(result.getDouble("VALOR_RECEBIDO"));
				contas.add(conta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return contas;
		
		
	}

public List<Conta_add> SQL_TABLE_Relatorio_Data_Periodo(String data, String data1){
	
	List<Conta_add> contas = new ArrayList<Conta_add>();
	
	String sql = "SELECT DATA_PRAZO, NOME_CLIENTE, VALOR_PRAZO, VALOR_RECEBIDO FROM CONTAS WHERE DATA_PRAZO >= '"+ data +"'"
			+ "AND DATA_PRAZO <= '" + data1 + "' ORDER BY DATA_PRAZO";
		
	try {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()){
			Conta_add conta = new Conta_add();
			conta.setData_Prazo(result.getString("DATA_PRAZO"));
			conta.setNome_Cliente(result.getString("NOME_CLIENTE"));
			conta.setValor_Prazo(result.getDouble("VALOR_PRAZO"));
			conta.setValor_Recebido(result.getDouble("VALOR_RECEBIDO"));
			contas.add(conta);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return contas;
	
	
}
	
}

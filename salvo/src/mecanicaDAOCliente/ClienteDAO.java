package mecanicaDAOCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;


public class ClienteDAO {
	
private Connection connection;
	
	public ClienteDAO() throws SQLException {
		connection = ConnectionDAO.getConnection();
	}
	
	
	public void Insert(Cliente_add cliente) {
		
		String sql = "INSERT INTO CLIENTES ( NOME, CELL, FIXO, CPF, RG, ESTADO, CIDADE," +
				"CEP, BAIRRO, RUA, APT_CASA, NUMERO, BLOQUEAR)" +
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		int index = 1;
			statement.setString(index++, cliente.getNome());
			statement.setString(index++, cliente.getCell());
			statement.setString(index++, cliente.getFixo());
			statement.setString(index++, cliente.getCpf());
			statement.setString(index++, cliente.getRg());
			statement.setString(index++, cliente.getEstado());
			statement.setString(index++, cliente.getCidade());
			statement.setString(index++, cliente.getCep());
			statement.setString(index++, cliente.getBairro());
			statement.setString(index++, cliente.getRua());
			statement.setDouble(index++, cliente.getApt_Casa());
			statement.setString(index++, cliente.getNumero());
			statement.setDouble(index++, cliente.getBloquear());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public List<Cliente_add> getAll() {
		List<Cliente_add> clientes = new ArrayList<Cliente_add>();
		
		String sql = "SELECT * FROM CLIENTES ORDER BY NOME";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Cliente_add cliente = new Cliente_add();
				cliente.setNome(result.getString("NOME"));
				cliente.setCell(result.getString("CELL"));
				cliente.setFixo(result.getString("FIXO"));
				cliente.setCpf(result.getString("CPF"));
				cliente.setRg(result.getString("RG"));
				cliente.setEstado(result.getString("ESTADO"));
				cliente.setCidade(result.getString("CIDADE"));
				cliente.setCep(result.getString("CEP"));
				cliente.setBairro(result.getString("BAIRRO"));
				cliente.setRua(result.getString("RUA"));
				cliente.setApt_Casa(result.getDouble("APT_CASA"));
				cliente.setNumero(result.getString("NUMERO"));
				//cliente.setLimite(result.getDouble("LIMITE"));
				cliente.setBloquear(result.getDouble("BLOQUEAR"));
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	
	public void update_cliente(Cliente_add cliente) {
		
		String sql = "UPDATE CLIENTES"
				+" SET NOME ='" + cliente.getNome()
				+"',CELL ='" + cliente.getCell()
				+"',FIXO ='" + cliente.getFixo()
				+"',RG ='" + cliente.getRg()
				+"',ESTADO ='" + cliente.getEstado()
				+"',CIDADE ='" + cliente.getCidade()
				+"',CEP ='" + cliente.getCep()
				+"',BAIRRO ='" + cliente.getBairro()
				+"',RUA ='" + cliente.getRua()
				+"',APT_CASA ='" + cliente.getApt_Casa()
				+"',NUMERO ='" + cliente.getNumero()
				+"',BLOQUEAR ='" + cliente.getBloquear()
				+"'WHERE CPF = '"+cliente.getCpf()
				+"'";
		
				try{
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.execute();
				}catch (SQLException e) {
					e.printStackTrace();
				}
	}

}

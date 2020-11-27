package mecanicaDAOFuncionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Funcionario_add;

public class FuncionarioDAO {

private Connection connection;

public FuncionarioDAO() throws SQLException {
	connection = ConnectionDAO.getConnection();
}
	
	
public void Insert(Funcionario_add funcionario) {
			
	String sql = "INSERT INTO FUNCIONARIOS ( CPF, NOME, SENHA, BLOQUEAR)" +
			"VALUES (?,?,?,?)";
		
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		int index = 1;
			statement.setString(index++, funcionario.getCpf());
			statement.setString(index++, funcionario.getNome());
			statement.setString(index++, funcionario.getSenha());
			statement.setDouble(index++, funcionario.getBloquear());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}


public List<Funcionario_add> getAll() {
	List<Funcionario_add> funcionarios = new ArrayList<Funcionario_add>();
	
	String sql = "SELECT * FROM FUNCIONARIOS ORDER BY CPF";
	
	try {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next()){
			Funcionario_add funcionario = new Funcionario_add();
			funcionario.setCpf(result.getString("CPF"));
			funcionario.setNome(result.getString("NOME"));
			funcionario.setSenha(result.getString("SENHA"));
			funcionario.setBloquear(result.getDouble("BLOQUEAR"));		
			funcionarios.add(funcionario);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return funcionarios;
}

public void update_funcionarios(Funcionario_add funcionario) {

	String sql = "UPDATE FUNCIONARIOS "
			+"SET " 
			+"NOME ='" + funcionario.getNome()
			+"',SENHA ='" + funcionario.getSenha()
			+"',BLOQUEAR = '"+ funcionario.getBloquear()
			+"'WHERE CPF = '" + funcionario.getCpf()
			+"';";
	
	try{
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
	}catch (SQLException e) {
		e.printStackTrace();
		}
	}
}
package mecanicaDAOAgendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Agendamento_add;
import mecanicaDAO.Funcionario_add;

public class AgendamentoDAO {

private Connection connection;

public AgendamentoDAO() throws SQLException {
	connection = ConnectionDAO.getConnection();
}
	
	
public void Insert(Agendamento_add agendamento) {
		
		
	String sql = "INSERT INTO AGENDAMENTOS ( PLACA, NOME, DATA_AGENDA, DIA_SEMANA, SERVICO)" +
			"VALUES (?,?,?,?,?)";
		
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		int index = 1;
			statement.setString(index++, agendamento.getPlaca());
			statement.setString(index++, agendamento.getNome());
			statement.setDate(index++, agendamento.getData_Agenda());
			statement.setString(index++, agendamento.getDia_Semana());
			statement.setString(index++, agendamento.getServico());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}


public List<Agendamento_add> getAll() {
	List<Agendamento_add> agendamentos = new ArrayList<Agendamento_add>();
	
	String sql = "SELECT * FROM AGENDAMENTOS ORDER BY PLACA";
	
	try {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next()){
			Agendamento_add agendamento = new Agendamento_add();
			agendamento.setPlaca(result.getString("PLACA"));
			agendamento.setNome(result.getString("NOME"));
			agendamento.setData_Agenda(result.getDate("DATA_AGENDA"));
			agendamento.setDia_Semana(result.getString("DIA_SEMANA"));
			agendamento.setServico(result.getString("SERVICO"));
					
			agendamentos.add(agendamento);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return agendamentos;
}

public void update_agendamentos(Agendamento_add agendamento) {

	String sql = "UPDATE AGENDAMENTOS "
			+"SET PLACA = '" + agendamento.getPlaca()
			+"',NOME ='" + agendamento.getNome()
			+"',DATA_AGENDA ='" + agendamento.getData_Agenda()
			+"',DIA_SEMANA ='" + agendamento.getDia_Semana()
			+"',SERVICO ='" + agendamento.getServico()
			+"'WHERE PLACA = '" + agendamento.getPlaca()
			+"';";
	
	try{
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
	}catch (SQLException e) {
		e.printStackTrace();
		}
	}

}
package mecanicaDAOVeiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Veiculo_add;


public class VeiculoDAO {

private Connection connection;

public VeiculoDAO() throws SQLException {
	connection = ConnectionDAO.getConnection();
}
	
	
public void Insert(Veiculo_add veiculo) {
		
		
	String sql = "INSERT INTO placa_veiculos ( MODELO, PLACA, KM, CLIENTE)" +
			"VALUES (?,?,?,?)";
		
		try {
		PreparedStatement statement = connection.prepareStatement(sql);
		int index = 1;
			statement.setString(index++, veiculo.getModelo());
			statement.setString(index++, veiculo.getPlaca());
			statement.setString(index++, veiculo.getKm());
			statement.setString(index++, veiculo.getCliente());
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}


public List<Veiculo_add> getAll() {
	List<Veiculo_add> veiculos = new ArrayList<Veiculo_add>();
	
	String sql = "SELECT * FROM PLACA_VEICULOS ORDER BY PLACA";
	
	try {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next()){
			Veiculo_add veiculo = new Veiculo_add();
			veiculo.setModelo(result.getString("MODELO"));
			veiculo.setPlaca(result.getString("PLACA"));
			veiculo.setKm(result.getString("KM"));
			veiculo.setCliente(result.getString("CLIENTE"));			
			veiculos.add(veiculo);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return veiculos;
}

public void update_veiculos(Veiculo_add veiculo) {

	String sql = "UPDATE PLACA_VEICULOS "
			+"SET PLACA = '" + veiculo.getPlaca()
			+"',MODELO ='" + veiculo.getModelo()
			+"',KM ='" + veiculo.getKm()
			+"',CLIENTE ='" + veiculo.getCliente()
			+"'WHERE PLACA = '" + veiculo.getPlaca()
			+"';";
	
	try{
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
	}catch (SQLException e) {
		e.printStackTrace();
		}
	}
}

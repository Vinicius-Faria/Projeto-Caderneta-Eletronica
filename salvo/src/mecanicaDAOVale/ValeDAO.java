package mecanicaDAOVale;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Boleto_Add;
import mecanicaDAO.Vale_add;

public class ValeDAO {
	
	private Connection connection;
	
	public ValeDAO() throws SQLException{
		connection = ConnectionDAO.getConnection();
		
	}
	
	public void insert(Vale_add vale){
		String sql = "Insert into vale (Nome, data, valor) values (?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 1;
				statement.setString(index++, vale.getNome());
				statement.setDate(index++, (Date) vale.getData());
				statement.setString(index++, vale.getValor());
				statement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	public List<Vale_add> getAll() {
		List<Vale_add> vales = new ArrayList<Vale_add>();
		
		String sql = "SELECT * FROM VALE ORDER BY Data ";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Vale_add vale = new Vale_add();
				vale.setNome(result.getString("NOME"));
				vale.setData(result.getDate("DATA"));
				vale.setValor(result.getString("VALOR"));
				vales.add(vale);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vales;
	}


}

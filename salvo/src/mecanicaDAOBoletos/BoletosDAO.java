package mecanicaDAOBoletos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Boleto_Add;
import mecanicaDAO.Cliente_add;

public class BoletosDAO {
	
	private Connection connection;
	
	public BoletosDAO() throws SQLException{
		connection = ConnectionDAO.getConnection();
	}

	
	public void Insert(Boleto_Add boleto){
		
		
		String sql = " insert into boleto ( descricao, valor, data_vencimento, parcelas)"  
			+	"values (?,?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 1;
				statement.setString(index++, boleto.getDescricao());
				statement.setDouble(index++, boleto.getValor());
				statement.setDate(index++, boleto.getData_Vencimento());
				statement.setString(index++, boleto.getNum_Parcelas());
				
				statement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public List<Boleto_Add> getAll() {
		List<Boleto_Add> boletos = new ArrayList<Boleto_Add>();
		
		String sql = "SELECT * FROM BOLETO ORDER BY DATA_VENCIMENTO ";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Boleto_Add boleto = new Boleto_Add();
				boleto.setDescricao(result.getString("DESCRICAO"));
				boleto.setValor(result.getDouble("VALOR"));
				boleto.setData_Vencimento(result.getDate("DATA_VENCIMENTO"));
				boleto.setNum_Parcelas(result.getString("PARCELAS"));
				boletos.add(boleto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boletos;
	}
	
	
}

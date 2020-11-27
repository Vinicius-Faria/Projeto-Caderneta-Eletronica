package mecanicaDAOBoletosPagos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Boleto_Pago_add;

	public class Boletos_pagoDAO {
	
	private Connection connection;
	
	public Boletos_pagoDAO() throws SQLException{
		connection = ConnectionDAO.getConnection();
	}
	
	
	public void insert(Boleto_Pago_add boleto){
		
		String sql = " insert into Boletos_pago ( descricao, valor, data_vencimento)"  
				+	"values (?,?,?)";
			
			try {
				PreparedStatement statement = connection.prepareStatement(sql);
				int index = 1;
					statement.setString(index++, boleto.getDescricao());
					statement.setDouble(index++, boleto.getValor());
					statement.setString(index++, boleto.getData_Vencimento());
					
					statement.execute();
					
				} catch (SQLException e) {
					e.printStackTrace();
		
		
				}
	}	
}

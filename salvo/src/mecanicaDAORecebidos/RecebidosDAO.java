package mecanicaDAORecebidos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToLongFunction;

import javax.swing.JOptionPane;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Produto_Add;
import mecanicaDAO.Recebidos_Add;
import mecanicaDAO.Servico_Add;

public class RecebidosDAO {
	
	private Connection connection;

	public RecebidosDAO() throws SQLException {
		connection = ConnectionDAO.getConnection();
	}
	
	
	public void Insert(Recebidos_Add recebidos) {
		
		String sql = "INSERT INTO RECEBIDOS ( DATA_RECEBIDO, VALOR_RECEBIDO, CPF_RECEBIDO, PLACA_CARRO_RECEBIDO ) " +
				"VALUES (?,?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 1;
				statement.setDate(index++, recebidos.getData());
				statement.setDouble(index++, recebidos.getValor());
				statement.setString(index++, recebidos.getCpf());
				statement.setString(index++, recebidos.getPlaca());
				statement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}
	
	public List<Recebidos_Add>sql_gerar(){
		List<Recebidos_Add> recebidos = new ArrayList<Recebidos_Add>();
		 
		 String data = data();
		 String Data = data;
		 String [] DataSeparada = Data.split("/");
		 LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));

		 String sql = "select * from recebidos"
		 		+ " where data_recebido = '"+dia+"'";
		 	
		  try {
	    		Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()){
				Recebidos_Add recebido = new Recebidos_Add();
				recebido.setCpf(result.getString("cpf_recebido"));
				recebido.setPlaca(result.getString("placa_carro_recebido"));
				recebido.setValor(Double.valueOf(result.getString("valor_recebido")));				
				recebidos.add(recebido);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	 
		 return recebidos;
	 }
	
	
	 private String data() {
		 LocalDate atual_data = LocalDate.now();
		 
		    String data;
			int mes = atual_data.getMonthValue();
			int dia = atual_data.getDayOfMonth();
			
			
			if(dia < 10){
				data = "0" + String.valueOf(dia) + "/";
			} else {
				data = String.valueOf(dia) + "/";
			}
			if(mes < 10) {
				data = data + "0" + String.valueOf(mes) +  "/";
			} else {
				data = data +  String.valueOf(mes) + "/";
			}
			
			data = data + String.valueOf(atual_data.getYear());
			
			return data;
	 }
}

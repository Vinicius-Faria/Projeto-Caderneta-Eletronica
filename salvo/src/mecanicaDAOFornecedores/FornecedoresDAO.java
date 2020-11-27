package mecanicaDAOFornecedores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Fornecedor_add;

public class FornecedoresDAO {
	private Connection connection;
	
	 public FornecedoresDAO() throws SQLException {
		 
		 connection = ConnectionDAO.getConnection();
		 
	 }
	 
	 
		public void Insert(Fornecedor_add fornecedor) {
			
			String sql = "INSERT INTO FORNECEDOR ( RAZAO_SOCIAL, CNPJ, TELL, ESTADO, CIDADE, CEP, RUA," +
					"NUMERO)" +
					"VALUES (?,?,?,?,?,?,?,?)";
			
			try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 1;
				statement.setString(index++, fornecedor.getRazão_Social());
				statement.setString(index++, fornecedor.getCnpj());
				statement.setString(index++, fornecedor.getTell());
				statement.setString(index++, fornecedor.getEstado());
				statement.setString(index++, fornecedor.getCidade());
				statement.setString(index++, fornecedor.getCep());
				statement.setString(index++, fornecedor.getRua());
				statement.setString(index++, fornecedor.getNumero());
				statement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		public List<Fornecedor_add> getAll() {
			List<Fornecedor_add> fornecedores = new ArrayList<Fornecedor_add>();
			
			String sql = "SELECT * FROM FORNECEDOR";
			
			try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				
				while (result.next()){
					Fornecedor_add fornecedor = new Fornecedor_add();
					fornecedor.setRazão_Social(result.getString("RAZAO_SOCIAL"));
					fornecedor.setCnpj(result.getString("CNPJ"));
					fornecedor.setTell(result.getString("TELL"));
					fornecedor.setEstado(result.getString("ESTADO"));
					fornecedor.setCidade(result.getString("CIDADE"));
					fornecedor.setCep(result.getString("CEP"));
					fornecedor.setRua(result.getString("RUA"));
					fornecedor.setNumero(result.getString("NUMERO"));
					fornecedores.add(fornecedor);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return fornecedores;
		}
		
		
		public void update_Fornecedores(Fornecedor_add fornecedor) {
			
	    String sql = "UPDATE FORNECEDOR"
					+" SET CNPJ ='" + fornecedor.getCnpj()
					+"',RAZAO_SOCIAL ='" + fornecedor.getRazão_Social()
					+"',TELL ='" + fornecedor.getTell()
					+"',ESTADO ='" + fornecedor.getEstado()
					+"',CIDADE ='" + fornecedor.getCidade()
					+"',CEP ='" + fornecedor.getCep()
					+"',RUA ='" + fornecedor.getRua()
					+"',NUMERO ='" + fornecedor.getNumero()
					+"' WHERE CNPJ ='" + fornecedor.getCnpj() 
					+"'";
			
					try{
						PreparedStatement statement = connection.prepareStatement(sql);
						statement.execute();
					}catch (SQLException e) {
						e.printStackTrace();
					}
		}

}

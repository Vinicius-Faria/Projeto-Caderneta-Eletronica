package mecanicaDAOContas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Contas_add;

public class ContasDAO {
	
	private Connection connection;
	
	public ContasDAO() throws SQLException{
		connection = ConnectionDAO.getConnection();
	}

	public List<Contas_add> getAll_table(String cpf) {
		List<Contas_add> contas = new ArrayList<Contas_add>();
		
		String sql = "select sum(valor_total) as valor, "
				+ "cod_venda, cliente_venda, placa "
				+ "from vendas "
				+ "where cpf_venda = '"+cpf+"' and num_os = 'Conta' "
				+ "group by cod_venda, cliente_venda, placa "
				+ "order by cod_venda; ";
				//+ "group by cod_venda, cliente_venda, placa "
				//+ "order by cod_venda;";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Contas_add conta = new Contas_add();
				conta.setCod_servico(result.getString("COD_VENDA"));
				conta.setNome_cliente(result.getString("CLIENTE_VENDA"));
				conta.setPlaca_carro(result.getString("PLACA"));
				conta.setValor_venda(String.valueOf(result.getString("VALOR")));
				//conta.setQuant_prod(result.getString("QUANT_PROD"));
				contas.add(conta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contas;
	}
	
	public List<Contas_add> getAll_table_placa(String placa) {
		List<Contas_add> contas = new ArrayList<Contas_add>();
		
		String sql = "select sum(valor_total) as valor, "
				+ "cod_venda, cliente_venda, placa "
				+ "from vendas "
				+ "where placa = '"+placa+"' and num_os = 'Conta' "
				+ "group by cod_venda, cliente_venda, placa "
				+ "order by cod_venda; ";
				//+ "group by cod_venda, cliente_venda, placa "
				//+ "order by cod_venda;";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Contas_add conta = new Contas_add();
				conta.setCod_servico(result.getString("COD_VENDA"));
				conta.setNome_cliente(result.getString("CLIENTE_VENDA"));
				conta.setPlaca_carro(result.getString("PLACA"));
				conta.setValor_venda(String.valueOf(result.getString("VALOR")));
				//conta.setQuant_prod(result.getString("QUANT_PROD"));
				contas.add(conta);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return contas;
	}
	
	
}

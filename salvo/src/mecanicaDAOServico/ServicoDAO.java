package mecanicaDAOServico;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Funcionario_add;
import mecanicaDAO.Servico_Add;
import sun.print.resources.serviceui;

public class ServicoDAO {
	
	private Connection connection;
	
	public ServicoDAO() throws SQLException {
		connection = ConnectionDAO.getConnection();
	}
	
	public void Insert(Servico_Add servico) {
		
		String sql = 
		"INSERT INTO ordem_servico (Cod_Serv, Cliente, Placa_Carro, Funcionario, Produto, Valor_Produto, "
		+ "Qtd_Prod, servico, Valor_servico, Valor_Total, data_ordem)"
		+ " VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 1;
				statement.setString(index++, servico.getCod_Serv());
				statement.setString(index++, servico.getCliente());
				statement.setString(index++, servico.getPlaca_Carro());
				statement.setString(index++, servico.getFuncionario());
				statement.setString(index++, servico.getProduto());
				statement.setString(index++, servico.getValor_Produto());
				statement.setString(index++, servico.getQtd_Produto());
				statement.setString(index++, servico.getServico());
				statement.setString(index++, servico.getValor_servico());
				statement.setDouble(index++, servico.getValor_Total());
				statement.setDate(index++, (Date) servico.getData());
				statement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public List<Servico_Add> getAll() {
		List<Servico_Add> servicos = new ArrayList<Servico_Add>();
		
		String sql = "select * from ordem_servico";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Servico_Add servico = new Servico_Add();
				servico.setCod_Serv(result.getString("COD_SERV"));
				servico.setCliente(result.getString("CLIENTE"));
				servico.setPlaca_Carro(result.getString("PLACA_CARRO"));
				servico.setFuncionario(result.getString("FUNCIONARIO"));
				servico.setProduto(result.getString("PRODUTO"));
				servico.setValor_Produto(result.getString("VALOR_PRODUTO"));
				servico.setQtd_Produto(result.getString("QTD_PROD"));
				servico.setServico(result.getString("SERVICO"));
				servico.setValor_servico(result.getString("VALOR_SERVICO"));
				servico.setValor_Total(result.getDouble("VALOR_TOTAL"));
				servicos.add(servico);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return servicos;
	}
	
	public List<Servico_Add> getGroup() {
		List<Servico_Add> servicos = new ArrayList<Servico_Add>();
		
		String sql = "select cod_serv, cliente, placa_carro, valor_total from ordem_servico group by cod_serv, cliente, placa_carro,valor_total order by cod_serv";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Servico_Add servico = new Servico_Add();
				servico.setCod_Serv(result.getString("COD_SERV"));
				servico.setCliente(result.getString("CLIENTE"));
				servico.setPlaca_Carro(result.getString("PLACA_CARRO"));
				servico.setValor_Total(result.getDouble("VALOR_TOTAL"));
				servicos.add(servico);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return servicos;
	}
	

	public List<Servico_Add> getGroup_Tabela(String Cod) {
		List<Servico_Add> servicos = new ArrayList<Servico_Add>();
		

		String sql = "select produto, valor_produto, qtd_prod, servico, valor_servico from ordem_servico "
				+ " where cod_serv = '"+Cod+"' ";
				//+ "group by produto, valor_produto, qtd_prod, servico, valor_servico";
		System.out.println(Cod);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Servico_Add servico = new Servico_Add();
				servico.setProduto(result.getString("produto"));
				servico.setValor_Produto(result.getString("valor_produto"));
				servico.setQtd_Produto(result.getString("qtd_prod"));
				servico.setServico(result.getString("servico"));
				servico.setValor_servico(result.getString("valor_servico"));
				
				servicos.add(servico);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return servicos;
	}
	
	public List<Servico_Add> getGroup_Combo_Fields(String Cod) {
		List<Servico_Add> servicos = new ArrayList<Servico_Add>();
		
		String sql = "select Cod_serv, cliente  , placa_carro, funcionario, valor_total, data_ordem  from ordem_servico"
				+ " where cod_serv = '"+Cod+"' group by Cod_serv, cliente , placa_carro, funcionario, valor_total, data_ordem";
		
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()){
				Servico_Add servico = new Servico_Add();
				servico.setCod_Serv(result.getString("COD_SERV"));
				servico.setCliente(result.getString("CLIENTE"));
				servico.setPlaca_Carro(result.getString("PLACA_CARRO"));
				servico.setFuncionario(result.getString("FUNCIONARIO"));
				servico.setValor_Total(result.getDouble("VALOR_TOTAL"));
				servico.setData(result.getDate("DATA_ORDEM"));
				servicos.add(servico);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return servicos;
	}
	
public void update_Servico(Servico_Add servico, String Cod) {
		
		String sql = "UPDATE ORDEM_SERVICO"
				+ " SET"
				+ " CLIENTE ='" + servico.getCliente()
				+ "' ,PLACA_CARRO='" + servico.getPlaca_Carro()
				+ "' ,FUNCIONARIO='" + servico.getFuncionario()
				+ "' ,PRODUTO='" + servico.getProduto()
				+ "' ,VALOR_PRODUTO='" + servico.getValor_Produto()
				+ "' ,QTD_PROD='" + servico.getQtd_Produto()
				+ "' ,SERVICO='" + servico.getServico()
				+ "' ,VALOR_SERVICO='" + servico.getValor_servico()
				+ "' ,VALOR_TOTAL='" + servico.getValor_Total()
				+"' WHERE COD_SERV = '"+Cod+"'";
				
		
				try{
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.execute();
				}catch (SQLException e) {
					e.printStackTrace();
				}
	}


public List<Servico_Add> getGroup_Tabela_Servicos_finalizados(String Cod) {
	List<Servico_Add> servicos = new ArrayList<Servico_Add>();
	

	String sql = "select * from ordem_servico_finalizado "
			+ " where cod_serv = '"+Cod+"' ";
		
	try {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next()){
			Servico_Add servico = new Servico_Add();
			servico.setProduto(result.getString("produto"));
			servico.setValor_Produto(result.getString("valor_produto"));
			servico.setQtd_Produto(result.getString("qtd_prod"));
			servico.setServico(result.getString("servico"));
			servico.setValor_servico(result.getString("valor_servico"));
			servico.setCliente(result.getString("cliente"));
			servico.setPlaca_Carro(result.getString("placa_carro"));
			servico.setFuncionario(result.getString("funcionario"));
			servico.setData(Date.valueOf(result.getString("data_ordem")));
			servico.setValor_Total(result.getDouble("valor_total"));
			servicos.add(servico);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return servicos;
}

	
}

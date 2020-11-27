package mecanicaDAO;

import java.util.Date;

public class Servico_Add {
	
	private String Cod_Serv;
	private String Cliente;
	private String Placa_Carro;
	private String Funcionario;
	private String Produto;
	private String Valor_Produto;
	private String Qtd_Produto;
	private String servico;
	private String Valor_servico;
	private Double Valor_Total;
	private Date data;
	
	
	public String getCod_Serv() {
		return Cod_Serv;
	}
	public void setCod_Serv(String cod_Serv) {
		Cod_Serv = cod_Serv;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public String getPlaca_Carro() {
		return Placa_Carro;
	}
	public void setPlaca_Carro(String placa_Carro) {
		Placa_Carro = placa_Carro;
	}
	public String getFuncionario() {
		return Funcionario;
	}
	public void setFuncionario(String funcionario) {
		Funcionario = funcionario;
	}
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	public String getValor_Produto() {
		return Valor_Produto;
	}
	public void setValor_Produto(String valor_Produto) {
		Valor_Produto = valor_Produto;
	}
	public String getQtd_Produto() {
		return Qtd_Produto;
	}
	public void setQtd_Produto(String qtd_Produto) {
		Qtd_Produto = qtd_Produto;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public String getValor_servico() {
		return Valor_servico;
	}
	public void setValor_servico(String valor_servico) {
		Valor_servico = valor_servico;
	}
	public Double getValor_Total() {
		return Valor_Total;
	}
	public void setValor_Total(Double valor_Total) {
		Valor_Total = valor_Total;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}

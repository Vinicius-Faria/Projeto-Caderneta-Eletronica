package mecanicaDAO;

import java.util.Date;

public class Venda_add {
	
	private String cliente_venda;
	private String Placa;
	private String cod_venda;
	private Date   data_venda;
	private String num_os;
	private String cpf_venda;
	private String cod_barras;
	private String valor_venda;
	private String Produto;
	private String Quant; 
	private Double Valor_Total;
	
	
	public Double getValor_Total() {
		return Valor_Total;
	}
	public void setValor_Total(Double valor_Total) {
		Valor_Total = valor_Total;
	}
	public String getQuant() {
		return Quant;
	}
	public void setQuant(String quant) {
		this.Quant = quant;
	}
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	private int quant_prod;
	
	
	public String getCliente_venda() {
		return cliente_venda;
	}
	public void setCliente_venda(String cliente_venda) {
		this.cliente_venda = cliente_venda;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getCod_venda() {
		return cod_venda;
	}
	public void setCod_venda(String cod_venda) {
		this.cod_venda = cod_venda;
	}
	
	public String getNum_os() {
		return num_os;
	}
	public void setNum_os(String num_os) {
		this.num_os = num_os;
	}
	public String getCpf_venda() {
		return cpf_venda;
	}
	public void setCpf_venda(String cpf_venda) {
		this.cpf_venda = cpf_venda;
	}
	public String getCod_barras() {
		return cod_barras;
	}
	public Date getData_venda() {
		return data_venda;
	}
	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}
	public void setCod_barras(String cod_barras) {
		this.cod_barras = cod_barras;
	}
	public String getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(String valor_venda) {
		this.valor_venda = valor_venda;
	}
	public int getQuant_prod() {
		return quant_prod;
	}
	public void setQuant_prod(int quant_prod) {
		this.quant_prod = quant_prod;
	}
}
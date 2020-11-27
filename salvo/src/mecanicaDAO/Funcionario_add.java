package mecanicaDAO;

public class Funcionario_add {
	private String Cpf;
	private String Nome;
	private String Senha;
	private Double bloquear;
	
	
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public Double getBloquear() {
		return bloquear;
	}
	public void setBloquear(Double bloquear) {
		this.bloquear = bloquear;
	}
	
	
}

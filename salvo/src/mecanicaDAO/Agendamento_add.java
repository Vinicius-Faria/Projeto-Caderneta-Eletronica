package mecanicaDAO;

import java.sql.Date;

public class Agendamento_add {
	private String Placa;
	private String Nome;
	private Date Data_Agenda;
	private String Dia_Semana;
	private String Servico;
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Date getData_Agenda() {
		return Data_Agenda;
	}
	public void setData_Agenda(Date date) {
		Data_Agenda = date;
	}
	public String getDia_Semana() {
		return Dia_Semana;
	}
	public void setDia_Semana(String dia_Semana) {
		Dia_Semana = dia_Semana;
	}
	public String getServico() {
		return Servico;
	}
	public void setServico(String servico) {
		Servico = servico;
	}
	
	
	
	
	
}

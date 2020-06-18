package Projeto_ClienteDAO;

import java.util.ArrayList;
import java.util.List;
import Projeto_Salva_Dados_textField_Cadastro.Conta_add;


public class Conta_DAO {
	
	private static List<Conta_add> ClienteData;
	
	public Conta_DAO() {
		ClienteData = new ArrayList<Conta_add>();
	}
	
	public void save(Conta_add cliente) {
		ClienteData.add(cliente);
	}
	
	public List<Conta_add> getAll(){
		return ClienteData;
	}
	
	

}
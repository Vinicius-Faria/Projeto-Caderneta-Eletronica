package Start_App;

import java.sql.SQLException;

import javax.swing.JFrame;

import Projeto_TelaEntrada.Cadastros_Clientes;
import Projeto_TelaEntrada.Tela_Entrada;;

public class Main extends JFrame {
	
	public static void main(String[] args) throws SQLException {
		
		Tela_Entrada tela = new Tela_Entrada();
		tela.setVisible(true);
		
	}

}
 
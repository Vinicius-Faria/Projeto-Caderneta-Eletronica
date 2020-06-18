package Projeto_TelaEntrada;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;

import Projeto_ClienteDAO.ClienteDAO;
import Projeto_ClienteDAO.ConnectionDAO;
import Projeto_ClienteDAO.ContaDAO;
import Projeto_Salva_Dados_textField_Cadastro.Cliente_add;
import Projeto_Salva_Dados_textField_Cadastro.Conta_add;

public class Tela_Menu extends JPanel {
	
	private Connection connection;
	
	public Tela_Menu() throws SQLException {
		addConta = new Add_Conta_Cliente();
		contaDAO = new ContaDAO();
		conta = new Conta_add();
		cliente_add = new Cliente_add();
		clienteDAO = new ClienteDAO();
		connection = ConnectionDAO.getConnection();
        initComponents();
    }                      
    private void initComponents() {

        BV_Label = new javax.swing.JLabel("Informações");
        Qtd_label = new javax.swing.JLabel("Quantidade de Clientes cadastrados:");
        Qtd_Editavel = new javax.swing.JLabel();
        Atraso_Label = new javax.swing.JLabel("Clientes não bloqueados após limite excedido:");
        Atraso_Editavel = new javax.swing.JLabel();
        Bloquear_Button = new javax.swing.JButton("Bloquear");
        Total_Label = new javax.swing.JLabel("Total à receber: R$");
        Total_Editavel = new javax.swing.JLabel();
      //  Calcular_dados = new javax.swing.JButton("Atualizar");

        BV_Label.setFont(new java.awt.Font("MV Boli", 1, 24)); 
        BV_Label.setForeground(new java.awt.Color(255, 153, 0));
        BV_Label.setText("Informações");
        Qtd_label.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        Qtd_Editavel.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        Atraso_Label.setFont(new java.awt.Font("Tahoma", 0, 14));
        Atraso_Editavel.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        Bloquear_Button.setText("Bloquear");
        Total_Label.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        Total_Editavel.setFont(new java.awt.Font("Tahoma", 0, 14));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(BV_Label))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Qtd_label)
                                        .addGap(18, 18, 18)
                                        .addComponent(Qtd_Editavel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Atraso_Label)
                                        .addGap(18, 18, 18)
                                        .addComponent(Atraso_Editavel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Bloquear_Button))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Total_Label)
                                .addGap(18, 18, 18)
                                .addComponent(Total_Editavel)))
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                .addContainerGap())
       )));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BV_Label)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Qtd_label)
                    .addComponent(Qtd_Editavel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Atraso_Label)
                    .addComponent(Atraso_Editavel)
                    .addComponent(Bloquear_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total_Label)
                    .addComponent(Total_Editavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addContainerGap())
        );
    } 
    
    
    public void atualiza_panel() {
    	int Qtd_clientes = 0;
    	
		for(Cliente_add cliente_add : clienteDAO.getAll()) {
			Qtd_clientes++;
			Qtd_Editavel.setText(Integer.toString(Qtd_clientes));	
		}
		Atraso_Editavel.setText("0");
	
		//SQL PARA COLOCAR O VALAOR DE MARCADOS
    	String sql_total = "SELECT SUM (VALOR_PRAZO) AS TOTAL, SUM (VALOR_RECEBIDO) AS TOTAL2 FROM CONTAS";
    	Double total = 0.0;
    	Double total2 = 0.0;
    	float TOTALEDITAVEL;
    	try {
    		Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql_total);
			result.next();
			total = result.getDouble("TOTAL");
			total2 = result.getDouble("TOTAL2");
			//Total_Editavel.setText(String.valueOf(result.getDouble("TOTAL")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	TOTALEDITAVEL = (float) (total-total2);
    	Total_Editavel.setText(String.valueOf(TOTALEDITAVEL));
    	//----------------------------------------------
		
		
    }


    // Variables declaration - do not modify                     
    private javax.swing.JLabel Atraso_Editavel;
    private javax.swing.JLabel Atraso_Label;
    private javax.swing.JLabel BV_Label;
    private javax.swing.JButton Bloquear_Button;
   // private javax.swing.JButton Calcular_dados;
    private javax.swing.JLabel Qtd_Editavel;
    private javax.swing.JLabel Qtd_label;
    private javax.swing.JLabel Total_Editavel;
    private javax.swing.JLabel Total_Label;
    private Add_Conta_Cliente addConta;
    private Conta_add conta;
    private ContaDAO contaDAO;
    private Cliente_add cliente_add;
    private ClienteDAO clienteDAO;
    // End of variables declaration                   
}

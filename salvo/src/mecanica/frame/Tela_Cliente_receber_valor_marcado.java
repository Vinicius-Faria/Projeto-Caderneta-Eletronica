package mecanica.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import com.sun.xml.internal.ws.api.pipe.NextAction;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Contas_add;
import mecanicaDAO.Recebidos_Add;
import mecanicaDAO.Servico_Add;
import mecanicaDAOCliente.ClienteDAO;
import mecanicaDAOContas.ContasDAO;
import mecanicaDAORecebidos.RecebidosDAO;

public class Tela_Cliente_receber_valor_marcado extends JPanel {
	
	private Connection connection;
	
	 public Tela_Cliente_receber_valor_marcado() throws SQLException  {
		 connection = ConnectionDAO.getConnection();
		 conta_add = new Contas_add();
		 contaDAO = new ContasDAO();
		 cliente_add = new Cliente_add();
		 clienteDAO = new ClienteDAO();
		 recebidosDAO = new RecebidosDAO();
	     initComponents();
	    }
	 
	 
	 private void initComponents() {

		 	Label_Titulo = new javax.swing.JLabel("Vendas a Prazo");
	        jSeparator1 = new javax.swing.JSeparator();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTable1 = new javax.swing.JTable();
	        Label_cpf = new javax.swing.JLabel("Digite o cpf do Cliente");
	        Field_Cpf = new javax.swing.JFormattedTextField();
	        Btn_Buscar_Cpf = new javax.swing.JButton("Buscar");
	        Label_Placa = new javax.swing.JLabel("Digite a placa do Carro");
	        Field_Placa = new javax.swing.JFormattedTextField();
	        Btn_Busca_Placa = new javax.swing.JButton("Buscar");
	        Btn_Cancelar_Venda = new javax.swing.JButton("Excluir");
	        Label_Ed_Total = new javax.swing.JLabel("0.00");
	        Label_Total = new javax.swing.JLabel("Total");
	        Label_Titulo_Venda = new javax.swing.JLabel("Controle");
	        jSeparator2 = new javax.swing.JSeparator();
	        Btn_Bloquear = new javax.swing.JButton("Bloquear");
	        LabePago = new javax.swing.JLabel("Valor Pago");
	        Field_Valor_Pago = new javax.swing.JFormattedTextField();
	        Btn_Receber = new javax.swing.JButton("Receber");
	        jScrollPane2 = new javax.swing.JScrollPane();
	        jTable2 = new javax.swing.JTable();
	        Label_Movimentacao = new javax.swing.JLabel("Ver Recebidos do dia");
	        Btn_Movimento_1Mes = new javax.swing.JButton("Gerar");

	        Label_Titulo.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
	        
	        try {
	            Field_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        }


	        Label_Ed_Total.setFont(new java.awt.Font("Arial Black", 0, 18)); 
	        Label_Total.setFont(new java.awt.Font("Arial Black", 0, 18));
	        Label_Titulo_Venda.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N


	        //Coloca as especificações nos campos da tabela
	     	Vector<String> columnBoleto = new Vector<String>();
	     	columnBoleto.add("Cod Venda");
	     	columnBoleto.add("Nome");
	     	columnBoleto.add("Placa do Carro");
	     	columnBoleto.add("Valor da Venda");
			Vector<? extends Vector> vector = new Vector();
			jTable1 = new JTable(vector,columnBoleto);
			jScrollPane1 = new JScrollPane(jTable1);
			
			//Coloca as especificações nos campos da tabela
	        Vector<String> columnNames1 = new Vector<String>();
			columnNames1.add("Cpf Cliente");
			columnNames1.add("Placa do carro");
			columnNames1.add("Valor");
			Vector<? extends Vector> vector1 = new Vector();
			jTable2 = new JTable(vector1,columnNames1);
			jScrollPane2 = new JScrollPane(jTable2);

	        Btn_Buscar_Cpf.setBackground(Color.WHITE);
	        Btn_Buscar_Cpf.setToolTipText("Salvar");
	        ImageIcon image_Lupa = new ImageIcon(getClass().getResource("/search (1).png"));
	        Btn_Buscar_Cpf.setIcon(image_Lupa);
	           
	        Btn_Busca_Placa.setBackground(Color.WHITE);
	        Btn_Busca_Placa.setToolTipText("Salvar");
	        Btn_Busca_Placa.setIcon(image_Lupa);
	        
	        Btn_Cancelar_Venda.setBackground(Color.WHITE);
	        Btn_Cancelar_Venda.setToolTipText("Excluir Venda");
	        ImageIcon image_Excluir = new ImageIcon(getClass().getResource("/delete.png"));
	        Btn_Cancelar_Venda.setIcon(image_Excluir);
	           
	        Btn_Bloquear.setBackground(Color.WHITE);
	        Btn_Bloquear.setToolTipText("Bloquear");
	        ImageIcon image_bloquear = new ImageIcon(getClass().getResource("/blocked.png"));
	        Btn_Bloquear.setIcon(image_bloquear);
	        
	        Btn_Receber.setBackground(Color.WHITE);
	        Btn_Receber.setToolTipText("Receber");
	        ImageIcon image_receber = new ImageIcon(getClass().getResource("/accepted.png"));
	        Btn_Receber.setIcon(image_receber);
	        
	        Btn_Movimento_1Mes.setBackground(Color.WHITE);
	        Btn_Movimento_1Mes.setToolTipText("Gerar");
	        ImageIcon image_gerar = new ImageIcon(getClass().getResource("/tax.png"));
	        Btn_Movimento_1Mes.setIcon(image_gerar);
	           
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(Label_Titulo)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jSeparator1))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(Label_Placa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(Label_cpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(Field_Cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
	                            .addComponent(Field_Placa))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(Btn_Buscar_Cpf)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(Btn_Bloquear))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(Btn_Busca_Placa)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                .addComponent(Btn_Cancelar_Venda))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(LabePago)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(Field_Valor_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(Btn_Receber)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(Label_Total)
	                        .addGap(18, 18, 18)
	                        .addComponent(Label_Ed_Total))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addComponent(Label_Titulo_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jSeparator2))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(Label_Movimentacao)
	                            .addComponent(Btn_Movimento_1Mes))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Label_Titulo))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_cpf)
	                    .addComponent(Field_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Btn_Buscar_Cpf)
	                    .addComponent(Btn_Bloquear))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_Placa)
	                    .addComponent(Field_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Btn_Busca_Placa)
	                    .addComponent(Btn_Cancelar_Venda))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_Ed_Total)
	                    .addComponent(Label_Total)
	                    .addComponent(LabePago)
	                    .addComponent(Field_Valor_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Btn_Receber))
	                .addGap(31, 31, 31)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Label_Titulo_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(Label_Movimentacao)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(Btn_Movimento_1Mes)))
	                .addContainerGap(35, Short.MAX_VALUE))
	        );
	        Btn_Buscar_Cpf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Verifica_cliente()){
						Preenche_tabela();
						soma_total();
						Valor_Total_devedor();
					}
				}
			});

	        Btn_Busca_Placa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Preenche_tabela_placa();
					soma_total_Placa();
					Valor_Total_devedor();
				}
			});
	        
	        Btn_Receber.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(verifica()){
						Cad_recebido();
						//Valor_Total_devedor();
						Subtrai();
						Mensagem_recebido();
					}
				}
			});
	        
	        Btn_Cancelar_Venda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Verifica_Linha();
					Valor_Total_devedor();
				}
			});
	        
	        Btn_Movimento_1Mes.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Gerar();					
				}
			});
	        
	        Btn_Bloquear.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					bloq_cliente();
				}
			});
	 }
	 
	 private void Gerar(){
		 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable2.getModel();
	    	tablemodel_Cadastrados.setRowCount(0);

	        	for(Recebidos_Add recebidos : recebidosDAO.sql_gerar()){
	            	
	            		Object[] data = {
	            				recebidos.getCpf(),
	            				recebidos.getPlaca(),
	            				recebidos.getValor()
	            		};
	            			tablemodel_Cadastrados.addRow(data);
	            
	            	}   
	        	
	        	
		 
	 }
	 
	 private void bloq_cliente(){
		
		 String sql = "update CLIENTES "
		 		+ "set "
		 		+ "bloquear = '1'"
		 		+ "where cpf ='" +Field_Cpf.getText()+"'";
			 		
		 
		 try {
	    		Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}			 
		 JOptionPane.showMessageDialog(this, "Cliente bloqueado\nPara desbloquear, precisa ir no cadastro de cliente"
			 		, "Bloqueado", JOptionPane.WARNING_MESSAGE);
	 }
	 
	 private boolean verifica(){
		
		 if(Field_Cpf.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha o CPF", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Cpf.requestFocus();
				return false;
			}
		
		 return true;
	 }
	 
	 
	 private void Mensagem_recebido() {
		 JOptionPane.showMessageDialog(this, "Valor recebido! "
		 		+ "Verifique senão ficou negativo o valor TOTAL", "Sucesso", JOptionPane.WARNING_MESSAGE);
		 Field_Cpf.setText(null);
		 Field_Placa.setText(null);
		 Field_Valor_Pago.setText(null);
		
	 }
	 
	 private void Cad_recebido() {
		 
		String Data = data();
		String [] DataSeparada = Data.split("/");
		LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));
		
		String cpf ;
		String placa;
		
		if(Field_Cpf.getText().trim().isEmpty() || Field_Cpf.getText().equals("   .   .   -  ")){
		String senha = JOptionPane.showInputDialog(null, "Informe o Cpf desta placa :");
		Field_Cpf.setText(senha);
		}
		
		Recebidos_Add recebidos = new Recebidos_Add();
		recebidos.setCpf(Field_Cpf.getText());
		recebidos.setData(Date.valueOf(dia));
		recebidos.setPlaca(Field_Placa.getText());
		recebidos.setValor(Double.valueOf(Field_Valor_Pago.getText()));
		recebidosDAO.Insert(recebidos);
		
	 }
	 
	 private void Valor_Total_devedor() {
		 
		 Double valor_Pago = 0.00;
		 String valor_devedor = Label_Ed_Total.getText();
		 
		 String sql = "select sum (valor_recebido) as valor from recebidos where cpf_recebido = '"+Field_Cpf.getText()+"'";
		  
		  try {
	    		Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()){
				valor_Pago = result.getDouble("VALOR");
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  
		Double total = (Double.valueOf(Label_Ed_Total.getText())) - valor_Pago;  
		Label_Ed_Total.setText(String.valueOf(total));

	 }
	 
	 private void Subtrai() {
		 
		 Double total = (Double.valueOf(Label_Ed_Total.getText())) - (Double.valueOf(Field_Valor_Pago.getText())) ;  
			Label_Ed_Total.setText(String.valueOf(total));
		 
	 }
 
	 private void Verifica_Linha() {
		
		 int Numero_linha = jTable1.getSelectedRow();
		 if(Numero_linha == -1) {
			  JOptionPane.showMessageDialog(this, "Conta não encontrada", "Erro", JOptionPane.WARNING_MESSAGE);
		 }else{
			 int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Conta?", "Excluir", JOptionPane.YES_NO_OPTION);
			 if(resposta == JOptionPane.YES_OPTION){
				  if(Numero_linha >= 0){
					 Sql_delete();
					 soma_total();
					 Preenche_tabela();
				  }
				}
		 }
		 
	 }
	 
	 private void Sql_delete() {
	
		 int Numero_linha = jTable1.getSelectedRow();
		  String Cod = (String)jTable1.getModel().getValueAt(Numero_linha, 0);
		  String Cpf = Field_Cpf.getText();
		  
		  String sql = "delete from vendas where cod_venda = '" + Cod + "' and cpf_venda ='"+Cpf+"'";
		  
		  try {
	    		Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 JOptionPane.showMessageDialog(this, "Codigo " + Cod +" deletado da Tabela", "Excluído", JOptionPane.WARNING_MESSAGE);

		 
		 
		 
	 }
	 
	 private boolean Verifica_cliente(){

		 for(Cliente_add cliente_msm_Cpf : clienteDAO.getAll()) {
	    		if(Field_Cpf.getText().equals(cliente_msm_Cpf.getCpf())) {
	    			return true;
	    		}
	    	}
		 
		 JOptionPane.showMessageDialog(this, "Cpf não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
			Field_Cpf.requestFocus();
				return false;
	 }
	 
	 private void soma_total(){
		 
		 String sql = "select sum (valor_total) as valor_total "
					+ "from vendas "
	    			+ "where cpf_venda = '"
	    			+ Field_Cpf.getText() + "'"
	    			+ "and num_os ='Conta'" ;
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				result.next();
				Label_Ed_Total.setText(String.valueOf(result.getDouble("valor_total")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    
	 }
	 
	 private void Preenche_tabela(){
		 
			 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
	    	tablemodel_Cadastrados.setRowCount(0);
	    	
	    	 for(Contas_add conta : contaDAO.getAll_table(Field_Cpf.getText())) {
	        	Object[] data = {
	    				conta.getCod_servico(),
	    				conta.getNome_cliente(),
	    				conta.getPlaca_carro(),
	    				conta.getValor_venda()
	    				
	    		};
	        	
	    		tablemodel_Cadastrados.addRow(data);
	    		
	        	}
	    	
	 }
	 
	 private void Preenche_tabela_placa(){
		 
		 if(Field_Cpf.getText().trim().isEmpty() || Field_Cpf.getText().equals("   .   .   -  ")){
				String senha = JOptionPane.showInputDialog(null, "Informe o Cpf desta placa :");
				Field_Cpf.setText(senha);
				}
				
		 
		 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
    	tablemodel_Cadastrados.setRowCount(0);
    	
    	 for(Contas_add conta : contaDAO.getAll_table_placa(Field_Placa.getText())) {
        	Object[] data = {
    				conta.getCod_servico(),
    				conta.getNome_cliente(),
    				conta.getPlaca_carro(),
    				conta.getValor_venda()
    				
    		};
        	
    		tablemodel_Cadastrados.addRow(data);
    		
        	}
    	
 }
	 
	 private void soma_total_Placa(){
		 
		 String sql = "select sum (valor_total) as valor_total "
					+ "from vendas "
	    			+ "where placa = '"
	    			+ Field_Placa.getText() + "'"
	    			+ "and num_os ='Conta'" ;
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				result.next();
				Label_Ed_Total.setText(String.valueOf(result.getDouble("valor_total")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    
	 }
	 
	 private String data() {
		 LocalDate atual_data = LocalDate.now();
		 
		    String data;
			int mes = atual_data.getMonthValue();
			int dia = atual_data.getDayOfMonth();
			
			
			if(dia < 10){
				data = "0" + String.valueOf(dia) + "/";
			} else {
				data = String.valueOf(dia) + "/";
			}
			if(mes < 10) {
				data = data + "0" + String.valueOf(mes) +  "/";
			} else {
				data = data +  String.valueOf(mes) + "/";
			}
			
			data = data + String.valueOf(atual_data.getYear());
			
			return data;
	 }

	 // Variables declaration - do not modify                     
	    private javax.swing.JButton Btn_Bloquear;
	    private javax.swing.JButton Btn_Busca_Placa;
	    private javax.swing.JButton Btn_Buscar_Cpf;
	    private javax.swing.JButton Btn_Cancelar_Venda;
	    private javax.swing.JButton Btn_Movimento_1Mes;
	    private javax.swing.JButton Btn_Receber;
	    private javax.swing.JFormattedTextField Field_Cpf;
	    private javax.swing.JFormattedTextField Field_Placa;
	    private javax.swing.JFormattedTextField Field_Valor_Pago;
	    private javax.swing.JLabel LabePago;
	    private javax.swing.JLabel Label_Ed_Total;
	    private javax.swing.JLabel Label_Movimentacao;
	    private javax.swing.JLabel Label_Placa;
	    private javax.swing.JLabel Label_Titulo;
	    private javax.swing.JLabel Label_Titulo_Venda;
	    private javax.swing.JLabel Label_Total;
	    private javax.swing.JLabel Label_cpf;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JScrollPane jScrollPane2;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
	    private javax.swing.JTable jTable1;
	    private javax.swing.JTable jTable2;
	    private Contas_add conta_add;
	    private ContasDAO contaDAO;
	    private ClienteDAO clienteDAO;
	    private Cliente_add cliente_add;
	    private RecebidosDAO recebidosDAO;
	    // End of variables declaration                     
}

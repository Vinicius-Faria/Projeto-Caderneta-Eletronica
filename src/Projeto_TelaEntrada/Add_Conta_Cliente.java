package Projeto_TelaEntrada;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Projeto_ClienteDAO.ClienteDAO;
import Projeto_ClienteDAO.ConnectionDAO;
import Projeto_ClienteDAO.ContaDAO;
import Projeto_Salva_Dados_textField_Cadastro.Cliente_add;
import Projeto_Salva_Dados_textField_Cadastro.Conta_add;
import java.sql.Connection;

public class Add_Conta_Cliente extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	String Cpf_Text = null;
	
	public Add_Conta_Cliente() throws SQLException {
    	contaDAO = new ContaDAO();
    	clienteDAO = new ClienteDAO();
    	cliente_Add = new Cliente_add();
		connection = ConnectionDAO.getConnection();
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	 jComboBox1 = new javax.swing.JComboBox<String>();
	 	 jLabel1_Valor = new javax.swing.JLabel("Valor Prazo");
	 	 jLabel1_Valor.setForeground(Color.RED);
         jTextField1_Valor = new javax.swing.JFormattedTextField();
         jLabel2_Codigo = new javax.swing.JLabel("Cpf");
         jTextField1_Codigo = new javax.swing.JTextField();
         jScrollPane2 = new javax.swing.JScrollPane();
         jTable2 = new javax.swing.JTable();
         jLabel3_Valor_Recebido = new javax.swing.JLabel("Valor Recebido");
         jLabel3_Valor_Recebido.setForeground(Color.GREEN);
         jTextField2_Valor_Recebido = new javax.swing.JFormattedTextField();
         jLabel4_Total = new javax.swing.JLabel("Devendo");
         jTextField2_Total = new javax.swing.JTextField();
         jButton1_Receber = new javax.swing.JButton("Receber / Marcar");
         jLabel5_Pegue_por = new javax.swing.JLabel("Pegue por");
         jTextField3_Pegue_por = new javax.swing.JTextField();
         jTextField1_Codigo.setEditable(false);
         jTextField2_Total.setEditable(false);
         jTable2.setEnabled(false);
         
         jLabel1_Valor.setFont(new java.awt.Font("Tahoma", 0, 14)); 
         jLabel2_Codigo.setFont(new java.awt.Font("Tahoma", 0, 14)); 
         jLabel3_Valor_Recebido.setFont(new java.awt.Font("Tahoma", 0, 14)); 
         jLabel4_Total.setFont(new java.awt.Font("Tahoma", 0, 14)); 
         jLabel5_Pegue_por.setFont(new java.awt.Font("Tahoma", 0, 14));
         
        Vector<String> columnCampos = new Vector<String>();
 		columnCampos.add("Data");
 		columnCampos.add("Vendido P/");
 		columnCampos.add("Valor");
 		Vector<? extends Vector> vector1 = new Vector();
        jTable2 = new JTable(vector1, columnCampos);
 		jScrollPane2 = new JScrollPane(jTable2);
 		jTable2.setEnabled(false);
 		
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3_Valor_Recebido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2_Valor_Recebido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4_Total)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField2_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 5, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1_Receber, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5_Pegue_por)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField3_Pegue_por))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1_Valor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField1_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2_Codigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField1_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1_Valor)
                        .addComponent(jLabel2_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5_Pegue_por)
                        .addComponent(jTextField3_Pegue_por, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4_Total)
                        .addComponent(jTextField2_Valor_Recebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3_Valor_Recebido))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                    .addComponent(jButton1_Receber)
                    .addGap(20, 20, 20))
        );
                                
            jButton1_Receber.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Add_Conta();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
                   
            
            
            //Selecionar os dados pelo nome 
            jComboBox1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					clear();
					String str = "Seleciona";
				if(str.equals(jComboBox1.getSelectedItem())){
					clear();
					Bloq_campos();
				}else{
					jTextField1_Valor.setEditable(true);
					jTextField2_Valor_Recebido.setEditable(true);
					jTextField3_Pegue_por.setEditable(true);					
				}
				
				Select_Cpf_Codigo();
				Up_date_table2();
				}
			});
}  
    
    private void clear() {
    	jTextField1_Valor.setText(null);
    	jTextField2_Valor_Recebido.setText(null);
    	jTextField3_Pegue_por.setText(null);
    }
    
    private void Bloq_campos(){
    	jTextField1_Codigo.setText(null);
		jTextField1_Valor.setEditable(false);
		jTextField2_Valor_Recebido.setEditable(false);
		jTextField3_Pegue_por.setEditable(false);
    }

    private void Select_Cpf_Codigo(){
    	
    	clear();
    	for(Cliente_add cliente_cpf : clienteDAO.getAll()){
    		if(cliente_cpf.getNome().equals(jComboBox1.getSelectedItem())){
    		Cpf_Text = cliente_cpf.getCpf();
    		jTextField1_Codigo.setText(Cpf_Text);
    		jTextField3_Pegue_por.setText(cliente_cpf.getNome());
    		String Vazia = "0.0";
    		jTextField2_Valor_Recebido.setText(Vazia);
    		jTextField1_Valor.setText(Vazia);
    		}
    	}
    	
    	SQL_TOTAL();
    }
    
	private void Add_Conta() throws Exception {
		Conta_add conta = new Conta_add();
		String data = null;
    	String Nome = (String) jComboBox1.getSelectedItem();
    	String Data = Fun_Data(data);
    	System.out.println(data);
    	//String Cpf = conta.getCpf_Cliente();
    	
    	if(validate_Combo_pessoa()) {	
    		conta.setCpf_Cliente(jTextField1_Codigo.getText());
    		conta.setPegue_por(jTextField3_Pegue_por.getText());
    		conta.setValor_Prazo(Double.valueOf(jTextField1_Valor.getText()));
    		conta.setValor_Recebido(Double.valueOf(jTextField2_Valor_Recebido.getText()));
    		conta.setNome_Cliente(Nome);
    		conta.setData_Prazo(Data);
    		
    		if((boolean)contaDAO.SQL_VERIFICA(conta)) {
    			contaDAO.save(conta);
            	Nome = null;
            	Up_date_table2();
            	Fun_Accept();
            	SQL_TOTAL();
            	clear();
            	Select_Cpf_Codigo();
    		}else {
        	JOptionPane.showMessageDialog(this,"Valor ira Ultrapassar o limite"
    				+ "\nFavor Verifique no Cadastro de Cliente", "Limite",JOptionPane.OK_OPTION);
    		clear();
    		Select_Cpf_Codigo(); 
    		}
    		
    	}
}    
	
	private String Fun_Data(String data) {
			
		LocalDate atual_data = LocalDate.now();
		
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
    
	private void Fun_Accept() {
    	JOptionPane.showMessageDialog(this,"Verifique na tabela abaixo!","Dados Salvos",JOptionPane.INFORMATION_MESSAGE);
		
	}
    
    private void SQL_TOTAL(){
    	Double soma=null;
    	Double sub=null;
    	float TOTAL;
    	
    	String sql = "SELECT SUM (VALOR_PRAZO) AS TOTAL, SUM (VALOR_RECEBIDO) AS TOTAL2 FROM "
    			+ "CONTAS WHERE CPF_CLIENTE = '"
    			+ Cpf_Text + "'" ;
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			result.next();
			soma = result.getDouble("TOTAL");
			sub = result.getDouble("TOTAL2");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	TOTAL = (float) (soma-sub);
    	jTextField2_Total.setText(String.valueOf(TOTAL));
    }

	public void Up_date_table2() {
		Conta_add conta = new Conta_add();
		String Cpf = jTextField1_Codigo.getText();
    	DefaultTableModel TableModel_Adcionar = (DefaultTableModel) jTable2.getModel();
    	TableModel_Adcionar.setRowCount(0);
    	conta.setCpf_Cliente(Cpf);
    	
    	for(Conta_add contas : contaDAO.SQL_TABLE(Cpf)) {
        		Object[] Complete = {
        			contas.getData_Prazo(), 
        			contas.getPegue_por(),
        			contas.getValor_Prazo()
        			};
        		TableModel_Adcionar.addRow(Complete);
        	}  
   }

	private boolean validate_Combo_pessoa() {
		
		if(jComboBox1.getItemCount() == 0) {
			JOptionPane.showMessageDialog(this, "Escolha alguém para marcar", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			jComboBox1.requestFocus();
			return false;
		}
	return true;
	}
	
	public void updateCombo() {
		jComboBox1.removeAllItems();
		jComboBox1.addItem("Seleciona");		 
		 
		 String sql = "SELECT * FROM clientes ORDER BY nome";
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()){
				jComboBox1.addItem(result.getString("NOME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 
	}
		
	
	//Start of variables declaration           
    private javax.swing.JButton jButton1_Receber;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTextField jTextField1_Valor;
    private javax.swing.JTextField jTextField2_Valor_Recebido;
    private javax.swing.JLabel jLabel1_Valor;
    private javax.swing.JLabel jLabel2_Codigo;
    private javax.swing.JLabel jLabel3_Valor_Recebido;
    private javax.swing.JLabel jLabel4_Total;
    private javax.swing.JLabel jLabel5_Pegue_por;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1_Codigo;
    private javax.swing.JTextField jTextField2_Total;
    private javax.swing.JTextField jTextField3_Pegue_por;
    private ClienteDAO clienteDAO;
    private Cliente_add cliente_Add;
    private ContaDAO contaDAO;
	    // End of variables declaration                   
	}
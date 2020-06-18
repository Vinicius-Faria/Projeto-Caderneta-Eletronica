package Projeto_TelaEntrada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.security.acl.Group;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Projeto_ClienteDAO.ClienteDAO;
import Projeto_ClienteDAO.ConnectionDAO;
import Projeto_ClienteDAO.ContaDAO;
import Projeto_Salva_Dados_textField_Cadastro.Cliente_add;
import Projeto_Salva_Dados_textField_Cadastro.Conta_add;

public class Tela_relatorio extends JPanel{

	private Connection connection;
	
	public Tela_relatorio() throws SQLException {
		
		contaDAO = new ContaDAO();
    	clienteDAO = new ClienteDAO();
    	cliente_Add = new Cliente_add();
		connection = ConnectionDAO.getConnection();
		
		initialize();
		
	}
	

	@SuppressWarnings("deprecation")
	private void initialize(){
		    jScrollPane2 = new javax.swing.JScrollPane();
	        jTable2 = new javax.swing.JTable();
	        Btn_Gerar = new javax.swing.JButton();
	        Radio_Cliente = new javax.swing.JRadioButton();
	        Radio_Data = new javax.swing.JRadioButton();
	        Radio_Data_Periodo = new javax.swing.JRadioButton();
	        jComboBox1 = new javax.swing.JComboBox<>();
	        label1 = new java.awt.Label();
	        label2 = new java.awt.Label();
	        jFormattedTextField2 = new javax.swing.JFormattedTextField();
	        jFormattedTextField1 = new javax.swing.JFormattedTextField();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel6 = new javax.swing.JLabel();
	        
	        jLabel3.setText("Total Marcado:");
	        jLabel4.setText("Total Recebido:");
	       
	        
	        ButtonGroup btn_grupo = new ButtonGroup();
	        btn_grupo.add(Radio_Cliente);
	        btn_grupo.add(Radio_Data);
	        btn_grupo.add(Radio_Data_Periodo);
	        
	        Vector<String> columnCampos = new Vector<String>();
	 		columnCampos.add("Data");
	 		columnCampos.add("Nome");
	 		columnCampos.add("Marcado");
	 		columnCampos.add("Recebido");
	 		Vector<? extends Vector> vector1 = new Vector();
	        jTable2 = new JTable(vector1, columnCampos);
	 		jScrollPane2 = new JScrollPane(jTable2);
	 		jTable2.setEnabled(false);
	        
	        Btn_Gerar.setText("Gerar");
	        Radio_Cliente.setLabel("Por Cliente");
	        Radio_Data.setActionCommand("");
	        Radio_Data.setLabel("Por Data");
	        label1.setText("CLIENTES");
	        label2.setText("DATA");
	        jLabel1.setText("INICIAL");
	        jLabel2.setText("FINAL");
	        Radio_Data_Periodo.setLabel("Por Periodo");
	        
	        try {
	            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        }
	        jFormattedTextField2.setToolTipText("");
	        try {
	            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        }
	        jFormattedTextField1.setToolTipText("");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(10, 10, 10)
	                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel1)
	                            .addComponent(jLabel2)))
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(Radio_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(Radio_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(Radio_Data_Periodo)
	                            .addComponent(Btn_Gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel3)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel5))
	                            .addGroup(layout.createSequentialGroup()
	                                .addComponent(jLabel4)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jLabel6))
	                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(Radio_Cliente)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(Radio_Data)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(Radio_Data_Periodo)
	                        .addGap(2, 2, 2)
	                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(3, 3, 3)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel1))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel2))
	                        .addGap(2, 2, 2)
	                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel3)
	                            .addComponent(jLabel5))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jLabel4)
	                            .addComponent(jLabel6))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(Btn_Gerar)))
	                .addContainerGap())
	        );
	        
	        Btn_Gerar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Radio_Data.isSelected()) {	
						Relatorio_date();
					}
					if(Radio_Cliente.isSelected()) {
						Relatorio_cliente();
					}
					if(Radio_Data_Periodo.isSelected()) {
						Relatorio_periodo();
					}
				}
			});
	}
	
	public void Relatorio_date() {
		String Data = null;
		Data = jFormattedTextField2.getText();
		DefaultTableModel TableModel_Adcionar = (DefaultTableModel) jTable2.getModel();
    	TableModel_Adcionar.setRowCount(0);
    	
    	String sql_total = "SELECT SUM (VALOR_PRAZO) AS TOTAL, SUM (VALOR_RECEBIDO) AS TOTAL2 FROM CONTAS "
    			+ "WHERE DATA_PRAZO ='" + Data +"'";

    	try {
    		Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql_total);
			result.next();
			 jLabel5.setText(String.valueOf(result.getFloat("TOTAL")));
			 jLabel6.setText(String.valueOf(result.getFloat("TOTAL2")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    	for(Conta_add contas : contaDAO.SQL_TABLE_Relatorio_Data(Data)) {
    		Object[] Complete = {
    			contas.getData_Prazo(), 
    			contas.getNome_Cliente(),
    			contas.getValor_Prazo(),
    			contas.getValor_Recebido()
    			};
    		TableModel_Adcionar.addRow(Complete);
    	}  
		
	}
	
	
	public void Relatorio_periodo() {
		
		String Data = jFormattedTextField2.getText();
		String Data1 = jFormattedTextField1.getText();
		
		String sql_total = "SELECT SUM (VALOR_PRAZO) AS TOTAL, SUM (VALOR_RECEBIDO) AS TOTAL2 FROM CONTAS "
    			+ "WHERE DATA_PRAZO >='" + Data +"' AND DATA_PRAZO <= '" + Data1+ "'";

    	try {
    		Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql_total);
			result.next();
			 jLabel5.setText(String.valueOf(result.getFloat("TOTAL")));
			 jLabel6.setText(String.valueOf(result.getFloat("TOTAL2")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		DefaultTableModel TableModel_Adcionar = (DefaultTableModel) jTable2.getModel();
    	TableModel_Adcionar.setRowCount(0);
    	
    	for(Conta_add contas : contaDAO.SQL_TABLE_Relatorio_Data_Periodo(Data, Data1)) {
    		Object[] Complete = {
    			contas.getData_Prazo(), 
    			contas.getNome_Cliente(),
    			contas.getValor_Prazo(),
    			contas.getValor_Recebido()
    			};
    		TableModel_Adcionar.addRow(Complete);
    	}  
		
	}
	
	public void Relatorio_cliente() {
		String CPF = null;
		
		for(Cliente_add cliente_cpf : clienteDAO.getAll()){
    		if(cliente_cpf.getNome().equals(jComboBox1.getSelectedItem())){
    			CPF = cliente_cpf.getCpf();
    		}
    	}
		
		String sql = "SELECT SUM (VALOR_PRAZO) AS TOTAL, SUM (VALOR_RECEBIDO) AS TOTAL2 FROM CONTAS "
    			+ "WHERE CPF_CLIENTE = '" + CPF +"'";

		try {
    		Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			result.next();
			jLabel5.setText(String.valueOf(result.getDouble("TOTAL")));
			jLabel6.setText(String.valueOf(result.getDouble("TOTAL2")));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		DefaultTableModel TableModel_Adcionar = (DefaultTableModel) jTable2.getModel();
    	TableModel_Adcionar.setRowCount(0);
    	
    	for(Conta_add contas : contaDAO.SQL_TABLE_Relatorio_Cliente(CPF)) {
    		Object[] Complete = {
    			contas.getData_Prazo(), 
    			contas.getNome_Cliente(),
    			contas.getValor_Prazo(),
    			contas.getValor_Recebido()
    			};
    		TableModel_Adcionar.addRow(Complete);
    	}  
    		
		
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
	
	public void clear() {
		
		Radio_Cliente.setSelected(true);
		Radio_Data.setSelected(false);
		Radio_Data_Periodo.setSelected(false);
		jLabel5.setText("00.0");
		jLabel6.setText("00.0");
		jFormattedTextField1.setText(null);
		jFormattedTextField2.setText(null);
		
	}
		
	// Variables declaration - do not modify                     
    private javax.swing.JButton Btn_Gerar;
    private javax.swing.JRadioButton Radio_Cliente;
    private javax.swing.JRadioButton Radio_Data;
    private javax.swing.JRadioButton Radio_Data_Periodo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private ClienteDAO clienteDAO;
    private Cliente_add cliente_Add;
    private ContaDAO contaDAO;
    // End of variables declaration             
	
}




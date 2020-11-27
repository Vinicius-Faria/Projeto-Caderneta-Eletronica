package mecanica.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Fornecedor_add;
import mecanicaDAO.Produto_Add;
import mecanicaDAOFornecedores.FornecedoresDAO;

public class Tela_Cadastro_Fornecedor extends JPanel{
	
	  private Connection connection;
	
	 public Tela_Cadastro_Fornecedor() throws SQLException {
	        initComponents();
	        connection = ConnectionDAO.getConnection();
	        fornecedorDAO = new FornecedoresDAO();
	    }
	 
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        Label_titulo_fornecedor = new javax.swing.JLabel("Informações Fornecedor");
	        jSeparator1 = new javax.swing.JSeparator();
	        Label_Razao_Social = new javax.swing.JLabel("Razão Social");
	        Field_Razao_social = new javax.swing.JFormattedTextField();
	        Label_Cnpj = new javax.swing.JLabel("CNPJ");
	        Field_Cnpj = new javax.swing.JFormattedTextField();
	        Label_Titulo_Endereco = new javax.swing.JLabel("Endereço");
	        jSeparator2 = new javax.swing.JSeparator();
	        Label_Cidade = new javax.swing.JLabel("Cidade");
	        Label_cep = new javax.swing.JLabel("CEP");
	        Label_Rua = new javax.swing.JLabel("Rua");
	        Label_numero = new javax.swing.JLabel("Numero");
	        Label_Estado = new javax.swing.JLabel("Estado");
	        Field_Cidade = new javax.swing.JFormattedTextField();
	        Field_Cep = new javax.swing.JFormattedTextField();
	        Field_Rua = new javax.swing.JFormattedTextField();
	        Field_Numero = new javax.swing.JFormattedTextField();
	        jLabel1 = new javax.swing.JLabel("Cadastrados");
	        jSeparator3 = new javax.swing.JSeparator();
	        Btn_cancelar = new javax.swing.JButton("Cancelar");
	        Btn_Salvar = new javax.swing.JButton("Salvar");
	        ScrollPane_Cadastros_fornecedor = new javax.swing.JScrollPane();
	        Table_Cadastros_fornecedor = new javax.swing.JTable();
	        Btn_Buscar = new javax.swing.JButton();
	        Label_telefone = new javax.swing.JLabel("Telefone");
	        Field_telefone = new javax.swing.JFormattedTextField();
	        Combo_Estado = new javax.swing.JComboBox<>();
	        Btn_editar = new javax.swing.JButton("Editar");

	        Label_titulo_fornecedor.setFont(new java.awt.Font("Arial Black", 0, 12)); 
	        Label_Titulo_Endereco.setFont(new java.awt.Font("Arial Black", 0, 12));
	        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12));
	        
	        Btn_Salvar.setBackground(Color.WHITE);
	        Btn_Salvar.setToolTipText("Salvar");
	        ImageIcon image_Salvar = new ImageIcon(getClass().getResource("/tick.png"));
	        Btn_Salvar.setIcon(image_Salvar);
	        
	        Btn_cancelar.setBackground(Color.WHITE);
	        Btn_cancelar.setToolTipText("Cancelar");
	        ImageIcon image_Cancel = new ImageIcon(getClass().getResource("/close.png"));
	        Btn_cancelar.setIcon(image_Cancel);

	        Btn_Buscar.setBackground(Color.WHITE);
	        Btn_Buscar.setToolTipText("Buscar");
	        ImageIcon image_buscar = new ImageIcon(getClass().getResource("/search (1).png"));
	        Btn_Buscar.setIcon(image_buscar);
	        
	        Btn_editar.setBackground(Color.WHITE);
	        Btn_editar.setToolTipText("Salvar");
	        ImageIcon image_Editar = new ImageIcon(getClass().getResource("/pencil.png"));
	        Btn_editar.setIcon(image_Editar);
	        
	        Btn_editar.setEnabled(false);
	        
	        //Coloca as especificações nos campos da tabela
	     	Vector<String> columnNames = new Vector<String>();
			columnNames.add("Razão Social");
			columnNames.add("Cnpj");
			columnNames.add("Telefone");
			Vector<? extends Vector> vector = new Vector();
			Table_Cadastros_fornecedor = new JTable(vector,columnNames);
			ScrollPane_Cadastros_fornecedor = new JScrollPane(Table_Cadastros_fornecedor);
	        
	        try {
	            Field_Cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        }
	        
	        try {
	            Field_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        }
	        
	        try {
	            Field_Cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        }

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(ScrollPane_Cadastros_fornecedor)
	                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addComponent(Label_Cnpj)
	                                    .addComponent(Label_Razao_Social)
	                                    .addComponent(Label_titulo_fornecedor)
	                                    .addComponent(Label_telefone))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(jSeparator1)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                            .addComponent(Field_telefone, javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(Field_Razao_social, javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(Field_Cnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
	                                        .addGap(30, 30, 30)
	                                        .addComponent(Btn_Buscar)
	                                        .addGap(0, 0, Short.MAX_VALUE))))
	                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                                .addGap(19, 19, 19)
	                                .addComponent(Label_Titulo_Endereco)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jSeparator2))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(141, 141, 141)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                    .addComponent(Label_numero)
	                                    .addComponent(Label_Rua)
	                                    .addComponent(Label_cep)
	                                    .addComponent(Label_Cidade)
	                                    .addComponent(Label_Estado))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addComponent(Btn_cancelar)
	                                        .addGap(18, 18, 18)
	                                        .addComponent(Btn_Salvar)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                        .addComponent(Btn_editar))
	                                    .addComponent(Combo_Estado, 0, 406, Short.MAX_VALUE)
	                                    .addComponent(Field_Cidade)
	                                    .addComponent(Field_Cep)
	                                    .addComponent(Field_Rua)
	                                    .addComponent(Field_Numero)))
	                            .addGroup(layout.createSequentialGroup()
	                                .addContainerGap()
	                                .addComponent(jLabel1)
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Label_titulo_fornecedor))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_Razao_Social)
	                    .addComponent(Field_Razao_social, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(Label_Cnpj)
	                        .addComponent(Field_Cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(Btn_Buscar))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_telefone)
	                    .addComponent(Field_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(Label_Titulo_Endereco)
	                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(4, 4, 4)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_Estado)
	                    .addComponent(Combo_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_Cidade)
	                    .addComponent(Field_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_cep)
	                    .addComponent(Field_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_Rua)
	                    .addComponent(Field_Rua, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Label_numero)
	                    .addComponent(Field_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(Btn_cancelar)
	                            .addComponent(Btn_Salvar)
	                            .addComponent(Btn_editar))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jLabel1))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(ScrollPane_Cadastros_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(19, 19, 19))
	        );
	        //funcao buscar pelo cnpj do fornecedor
	        Btn_Buscar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Mostra_Cad()){
						Btn_Salvar.setEnabled(false);
						Btn_cancelar.setEnabled(false);
						Field_Cnpj.setEnabled(false);
						Btn_editar.setEnabled(true);
					}
					
					
				}
			});
          
	        //funcao salvar e update
	        Btn_Salvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(Verifica()) {
						Cad_Fornecedor();
						Update_Table_Fornecedor();
						Limpa_Campos();
					}
					
				}
			});
	        
	        //funcao cancelar cad
	        Btn_cancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Limpa_Campos();
					
				}
			});
	        
	        Btn_editar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Atualiza_dados();
					Limpa_Campos();
					Update_Table_Fornecedor();
					Btn_Salvar.setEnabled(true);
					Btn_cancelar.setEnabled(true);
					Field_Cnpj.setEnabled(true);
					Btn_editar.setEnabled(false);
				}
			});
	    
	 }
	 
	 private void Atualiza_dados(){
		 
		 
		 Fornecedor_add fornecedor = new Fornecedor_add();
		 fornecedor.setRazão_Social(Field_Razao_social.getText());
		 fornecedor.setCnpj(Field_Cnpj.getText());
		 fornecedor.setEstado(Combo_Estado.getSelectedItem().toString());
		 fornecedor.setCidade(Field_Cidade.getText());
		 fornecedor.setCep(Field_Cep.getText());
		 fornecedor.setCidade(Field_Cidade.getText());
		 fornecedor.setRua(Field_Rua.getText());
		 fornecedor.setNumero(Field_Numero.getText());
		 fornecedor.setTell(Field_telefone.getText());
		 fornecedorDAO.update_Fornecedores(fornecedor);
		 
		 JOptionPane.showMessageDialog(this, "Fornecedor Atualizado com sucesso! \n Verifique a tabela a baixo", "Sucesso", JOptionPane.WARNING_MESSAGE);
		 
		 
	 }
	 
	 
	 public void Update_Estado() {
			
			Combo_Estado.removeAllItems();
			Combo_Estado.addItem("Seleciona");		 
			 
			 String sql = "SELECT * FROM estados ORDER BY sigla";
		    	try {
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(sql);
					while(result.next()){
					Combo_Estado.addItem(result.getString("DESCRICAO"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	 
	 private void Limpa_Campos() {
		 Field_Cep.setText(null);
		 Field_Cidade.setText(null);
		 Field_Cnpj.setText(null);
		 Field_Numero.setText(null);
		 Field_Razao_social.setText(null);
		 Field_Rua.setText(null);
		 Field_telefone.setText(null);	
		 Combo_Estado.setSelectedItem("Seleciona");
	 }

	 private boolean Verifica() {
		 
		 if(Field_Razao_social.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha a Razão Social", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Razao_social.requestFocus();
				return false;
		 } 
		 if(Field_Cnpj.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha o Cnpj", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Cnpj.requestDefaultFocus();
				return false;
		 }
		 if(Field_telefone.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha o Telefone", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_telefone.requestFocus();
				return false;
		 }
		 if(Combo_Estado.getSelectedItem().equals("Seleciona")) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha um Estado valido", "Estado Inválido", JOptionPane.WARNING_MESSAGE);
				Combo_Estado.requestFocus();
				return false;
		 }
		 if(Field_Cidade.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha a Cidade", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Cidade.requestFocus();
				return false;
		 }
		 if(Field_Cep.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha o Cep", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Cep.requestFocus();
				return false;
		 }
		 if(Field_Rua.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha a Rua", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Rua.requestFocus();
				return false;
		 }
		 if(Field_Numero.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha o Numero", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Numero.requestFocus();
				return false;
		 }
		 for(Fornecedor_add fornecedor_msm_CNPJ : fornecedorDAO.getAll()) {
	    		if(Field_Cnpj.getText().equals(fornecedor_msm_CNPJ.getCnpj())) {
	    			JOptionPane.showMessageDialog(this, "CNPJ ja foi Cadastrado", "Erro", JOptionPane.WARNING_MESSAGE);
	    			Field_Cnpj.requestFocus();
	    			return false;
	    		}
	    	}
		 
		 
		 return true;
	 }
	 
	 private void Cad_Fornecedor() {
		 
		 Fornecedor_add fornecedor = new Fornecedor_add();
		 fornecedor.setRazão_Social(Field_Razao_social.getText());
		 fornecedor.setCnpj(Field_Cnpj.getText());
		 fornecedor.setEstado(Combo_Estado.getSelectedItem().toString());
		 fornecedor.setCidade(Field_Cidade.getText());
		 fornecedor.setCep(Field_Cep.getText());
		 fornecedor.setCidade(Field_Cidade.getText());
		 fornecedor.setRua(Field_Rua.getText());
		 fornecedor.setNumero(Field_Numero.getText());
		 fornecedor.setTell(Field_telefone.getText());
		 fornecedorDAO.Insert(fornecedor);
		 
		 JOptionPane.showMessageDialog(this, "Fornecedor Cadastrado com sucesso! \n Verifique a tabela a baixo", "Sucesso", JOptionPane.WARNING_MESSAGE);
		 
	 }
	 
	 public void Update_Table_Fornecedor() {
		 
		 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_Cadastros_fornecedor.getModel();
	    	tablemodel_Cadastrados.setRowCount(0);
	    	
	    	for(Fornecedor_add fornecedor : fornecedorDAO.getAll()){
	        	Object[] data = {
	    				fornecedor.getRazão_Social(),
	    				fornecedor.getCnpj(),
	    				fornecedor.getTell()
	    		};
	        	
	    		tablemodel_Cadastrados.addRow(data);
	    		
	        	}
		 
	 }
	 
	 private boolean Mostra_Cad(){
		 
		 
		 for(Fornecedor_add fornecedor : fornecedorDAO.getAll()){
			 if (Field_Cnpj.getText().equals(fornecedor.getCnpj())){
				 Field_Razao_social.setText(fornecedor.getRazão_Social());
				 Field_telefone.setText(fornecedor.getTell());
				 Combo_Estado.setSelectedItem(fornecedor.getEstado().toString());
				 Field_Cidade.setText(fornecedor.getCidade());
				 Field_Cep.setText(fornecedor.getCep());
				 Field_Rua.setText(fornecedor.getRua());
				 Field_Numero.setText(fornecedor.getNumero());
			 }
		 }
		 
		 if(Field_Razao_social.getText().trim().isEmpty()){
				JOptionPane.showMessageDialog(this, "Fornecedor não cadastrado", "Fornecedor Inválido", JOptionPane.WARNING_MESSAGE);
				Field_Cnpj.requestFocus();
				return false;
		 }
		 
		 return true;
	 }
	 
	 private void Update_Fornecedor(){
		 
		 Fornecedor_add fornecedor = new Fornecedor_add();
		 fornecedor.setRazão_Social(Field_Razao_social.getText());
		 fornecedor.setCnpj(Field_Cnpj.getText());
		 fornecedor.setTell(Field_telefone.getText());
		 fornecedor.setEstado(Combo_Estado.getSelectedItem().toString());
		 fornecedor.setCidade(Field_Cidade.getText());
		 fornecedor.setCep(Field_Cep.getText());
		 fornecedor.setRua(Field_Rua.getText());
		 fornecedor.setNumero(Field_Numero.getText());
		 fornecedorDAO.update_Fornecedores(fornecedor);

		 JOptionPane.showMessageDialog(this,"Dados Atualizados com Sucesso!","Concluido",JOptionPane.PLAIN_MESSAGE);
			
	 }
	 
	 
	 
	 // Variables declaration - do not modify                     
	 	private javax.swing.JButton Btn_Buscar;
	    private javax.swing.JButton Btn_Salvar;
	    private javax.swing.JButton Btn_cancelar;
	    private javax.swing.JButton Btn_editar;
	    private javax.swing.JComboBox<String> Combo_Estado;
	    private javax.swing.JFormattedTextField Field_Cep;
	    private javax.swing.JFormattedTextField Field_Cidade;
	    private javax.swing.JFormattedTextField Field_Cnpj;
	    private javax.swing.JFormattedTextField Field_Numero;
	    private javax.swing.JFormattedTextField Field_Razao_social;
	    private javax.swing.JFormattedTextField Field_Rua;
	    private javax.swing.JFormattedTextField Field_telefone;
	    private javax.swing.JLabel Label_Cidade;
	    private javax.swing.JLabel Label_Cnpj;
	    private javax.swing.JLabel Label_Estado;
	    private javax.swing.JLabel Label_Razao_Social;
	    private javax.swing.JLabel Label_Rua;
	    private javax.swing.JLabel Label_Titulo_Endereco;
	    private javax.swing.JLabel Label_cep;
	    private javax.swing.JLabel Label_numero;
	    private javax.swing.JLabel Label_telefone;
	    private javax.swing.JLabel Label_titulo_fornecedor;
	    private javax.swing.JScrollPane ScrollPane_Cadastros_fornecedor;
	    private javax.swing.JTable Table_Cadastros_fornecedor;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
	    private javax.swing.JSeparator jSeparator3;
	    private FornecedoresDAO fornecedorDAO;
	   
	    // End of variables declaration        

}

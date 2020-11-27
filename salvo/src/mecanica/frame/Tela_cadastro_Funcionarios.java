package mecanica.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Funcionario_add;
import mecanicaDAOFuncionario.FuncionarioDAO;

public class Tela_cadastro_Funcionarios extends JPanel {
	private Connection connection;
	
	public Tela_cadastro_Funcionarios() throws SQLException {
        initComponents();
        connection = ConnectionDAO.getConnection();
        funcionarioDAO = new FuncionarioDAO();
       
    }                      
	    private void initComponents() {

	        Label_Titulo_Cadastro = new javax.swing.JLabel("Cadastro Funcionários");
	        jSeparator1 = new javax.swing.JSeparator();
	        Label_nome = new javax.swing.JLabel("Nome");
	        Field_Nome = new javax.swing.JFormattedTextField();
	        label_Cpf = new javax.swing.JLabel("Cpf");
	        Field_Cpf = new javax.swing.JFormattedTextField();
	        jLabel1 = new javax.swing.JLabel("Senha do Sistema");
	        Field_senha = new javax.swing.JPasswordField();;
	        Btn_Buscar = new javax.swing.JButton();
	        Box_Vale = new javax.swing.JCheckBox("Habilitar Vale");
	        Label_cadastrados = new javax.swing.JLabel("Cadastrados");
	        jSeparator2 = new javax.swing.JSeparator();
	        Btn_Mostrar = new javax.swing.JButton();
	        ScrollPane_Cadastros = new javax.swing.JScrollPane();
	        Table_Cadastros = new javax.swing.JTable();
	        Btn_Cancelar = new javax.swing.JButton("Cancelar");
	        Btn_Salvar = new javax.swing.JButton("Salvar");

	        Label_Titulo_Cadastro.setFont(new java.awt.Font("Arial Black", 0, 12)); 
	        Label_cadastrados.setFont(new java.awt.Font("Arial Black", 0, 12)); 
	        
	        Btn_Mostrar.setVisible(false);
	        
	        Btn_Cancelar.setBackground(Color.WHITE);
	        Btn_Cancelar.setToolTipText("Cancelar");
	        ImageIcon image_Cancel = new ImageIcon(getClass().getResource("/close.png"));
	        Btn_Cancelar.setIcon(image_Cancel);  
	        
	        Btn_Buscar.setBackground(Color.WHITE);
	        Btn_Buscar.setToolTipText("Pesquisar");
	        ImageIcon image_Buscar = new ImageIcon(getClass().getResource("/search (1).png"));
	        Btn_Buscar.setIcon(image_Buscar);
	        
	        Btn_Salvar.setBackground(Color.WHITE);
	        Btn_Salvar.setToolTipText("Salvar");
	        ImageIcon image_Salvar = new ImageIcon(getClass().getResource("/tick.png"));
	        Btn_Salvar.setIcon(image_Salvar);
	        
	        Btn_Mostrar.setBackground(Color.WHITE);
	        Btn_Mostrar.setToolTipText("Ver Senha");
	        ImageIcon image_Mostrar = new ImageIcon(getClass().getResource("/look (1).png"));
	        Btn_Mostrar.setIcon(image_Mostrar);
	        
	        
	        
	        Vector<String> columnNames = new Vector<String>();
			columnNames.add("Cpf");
			columnNames.add("Nome");
			Vector<? extends Vector> vector = new Vector();
			Table_Cadastros = new JTable(vector,columnNames);
			ScrollPane_Cadastros = new JScrollPane(Table_Cadastros);

	        try {
	            Field_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        }
	      
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabel1)
	                            .addComponent(label_Cpf)
	                            .addComponent(Label_nome)
	                            .addComponent(Label_Titulo_Cadastro))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jSeparator1)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addComponent(Field_Nome)
	                                    .addComponent(Field_Cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
	                                    .addComponent(Field_senha, javax.swing.GroupLayout.Alignment.TRAILING))
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addGap(181, 181, 181)
	                                        .addComponent(Box_Vale))
	                                    .addGroup(layout.createSequentialGroup()
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                            .addComponent(Btn_Mostrar)
	                                            .addComponent(Btn_Buscar))))
	                                .addGap(0, 0, Short.MAX_VALUE))))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(Label_cadastrados)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(layout.createSequentialGroup()
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jSeparator2))
	                            .addGroup(layout.createSequentialGroup()
	                                .addGap(91, 91, 91)
	                                .addComponent(Btn_Cancelar)
	                                .addGap(18, 18, 18)
	                                .addComponent(Btn_Salvar)
	                                .addGap(0, 0, Short.MAX_VALUE))))
	                    .addComponent(ScrollPane_Cadastros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(Label_Titulo_Cadastro))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(Label_nome)
	                        .addComponent(Field_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addComponent(Box_Vale))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(label_Cpf)
	                    .addComponent(Btn_Buscar)
	                    .addComponent(Field_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel1)
	                        .addGap(25, 25, 25)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(Label_cadastrados)
	                            .addGroup(layout.createSequentialGroup()
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(Btn_Cancelar)
	                                    .addComponent(Btn_Salvar))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(Btn_Mostrar)
	                        .addComponent(Field_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(ScrollPane_Cadastros, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        
	        
	  
	  
	  //função de cancelar cadastro
	  Btn_Cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar o cadastro", "Cadastro de Funcionario", JOptionPane.YES_NO_OPTION);
				if(resposta == JOptionPane.YES_OPTION) {
					Limpa_campos();
				}
				
			}
		});
	     
	     // função de salvar
	     Btn_Salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					if(Editar == 0 && Verifica()) {
						Cad_Funcionario();
						Limpa_campos();
						update_tabela();
				}
					if(Editar == 1 ) {
						Update_funcionarios();
						Editar = 0 ;
						Limpa_campos();
						
					}
					
			}
		});
	 
	     //funcao de buscar cpf
		 Btn_Buscar.addActionListener(new ActionListener() {
			
			 @Override
				public void actionPerformed(ActionEvent e) {
					preenche_campos();		
				}
		});
		 }
	    
		 	 
		 
		 private void Update_funcionarios() {
			 Double bloq = 0.00;
			 
			 if(Box_Vale.isSelected()) bloq = 1.00;
			 
			 
			 Funcionario_add funcionario = new Funcionario_add();
			 funcionario.setNome(Field_Nome.getText());
			 funcionario.setCpf(Field_Cpf.getText());
			 funcionario.setSenha(Field_senha.getText());
			 funcionario.setBloquear(bloq);
			 funcionarioDAO.update_funcionarios(funcionario);
			 JOptionPane.showMessageDialog(this, "Atualizado com sucesso", "Atualizado", JOptionPane.WARNING_MESSAGE);
			 Btn_Buscar.setEnabled(true);
		 }
		 
		 private void erro() {
			 JOptionPane.showMessageDialog(this, "Por favor, preencha o Campo ao lado", "Campo vazio", JOptionPane.WARNING_MESSAGE);
		 }
		 
		 private void Cad_Funcionario() {
			 
			 Funcionario_add funcionario = new Funcionario_add();
			 funcionario.setCpf(Field_Cpf.getText());
			 funcionario.setNome(Field_Nome.getText());
			 funcionario.setSenha(Field_senha.getText());
			 funcionario.setBloquear(0.00);
			 funcionarioDAO.Insert(funcionario);
			 JOptionPane.showMessageDialog(this, "Funcionario cadastrado com sucesso! \n Verifique a tabela abaixo", "Sucesso", JOptionPane.WARNING_MESSAGE);
			
		 }
		 
		 
		 private void Limpa_campos() {
			 Field_Cpf.setText(null);
			  Field_Nome.setText(null);
			  Field_senha.setText(null);
		 }
		 
		 private boolean Verifica() {
			 
			 if(Field_Nome.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Por favor, preencha o NOME", "Campo vazio", JOptionPane.WARNING_MESSAGE);
					Field_Nome.requestFocus();
					return false;
			 }
			 if(Field_Cpf.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Por favor, preencha o CPF", "Campo vazio", JOptionPane.WARNING_MESSAGE);
					Field_Cpf.requestFocus();
					return false;
			 }
			 if(Field_senha.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Por favor, preencha a SENHA", "Campo vazio", JOptionPane.WARNING_MESSAGE);
					Field_senha.requestFocus();
					return false;
			 }
			 
			 		 
			 return true;
		 }
		 
		 public void update_tabela() {

		    	DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_Cadastros.getModel();
		    	tablemodel_Cadastrados.setRowCount(0);
		    	
		    	for(Funcionario_add funcionario : funcionarioDAO.getAll()){
		        	Object[] data = {
		    				funcionario.getNome(),
		    				funcionario.getCpf()
		    		};
		        	
		    		tablemodel_Cadastrados.addRow(data);
		    		
		        	}
		    	
			}
		 
		 public void preenche_campos() {
				
				for(Funcionario_add funcionario : funcionarioDAO.getAll()) {
					if(funcionario.getCpf().equals(Field_Cpf.getText())) {
						Field_Nome.setText(funcionario.getNome());
						Field_Cpf.setText(funcionario.getCpf());
						Field_senha.setText(funcionario.getSenha());
						if(funcionario.getBloquear() == 1.00) Box_Vale.setSelected(true);
						else Box_Vale.setSelected(false);
						Btn_Buscar.setEnabled(false);
						Editar =1;
					}
				}
				if(Field_Nome.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Funcionario não cadastrado", "Funcionario Inválido", JOptionPane.WARNING_MESSAGE);
				}
				
			}

	    // Variables declaration - do not modify                     
	  	private javax.swing.JCheckBox Box_Vale;
	    private javax.swing.JButton Btn_Buscar;
	    private javax.swing.JButton Btn_Cancelar;
	    private javax.swing.JButton Btn_Mostrar;
	    private javax.swing.JButton Btn_Salvar;
	    private javax.swing.JFormattedTextField Field_Cpf;
	    private javax.swing.JFormattedTextField Field_Nome;
	    private javax.swing.JPasswordField Field_senha;
	    private javax.swing.JLabel Label_Titulo_Cadastro;
	    private javax.swing.JLabel Label_cadastrados;
	    private javax.swing.JLabel Label_nome;
	    private javax.swing.JScrollPane ScrollPane_Cadastros;
	    private javax.swing.JTable Table_Cadastros;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
	    private javax.swing.JLabel label_Cpf;
	    private FuncionarioDAO funcionarioDAO;
	    private int Editar = 0 ;
	    // End of variables declaration       

}

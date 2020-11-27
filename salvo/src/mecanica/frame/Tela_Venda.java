package mecanica.frame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.nio.file.attribute.GroupPrincipal;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat.Field;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;
import java.util.function.DoubleToLongFunction;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.KeyEvent;
import com.sun.javafx.tk.Toolkit;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Produto_Add;
import mecanicaDAO.Servico_Add;
import mecanicaDAO.Venda_add;
import mecanicaDAOProduto.ProdutoDAO;
import mecanicaDAOServico.ServicoDAO;
import mecanicaDAOVenda.VendaDAO;

public class Tela_Venda extends JPanel{
	
	private Connection connection;
	int contador_Table = 0;
	Double Total = 0.00;

	
	public Tela_Venda() throws SQLException {
        initComponents();
        vendaDAO = new VendaDAO();
        produtoDAO = new ProdutoDAO();
        connection = ConnectionDAO.getConnection();
        servicoDAO = new ServicoDAO();
    }
	
	private void initComponents() {
		
			Label_Cod_Venda = new javax.swing.JLabel("Codigo");
	        Field_Codigo = new javax.swing.JTextField();
	        Label_Titulo = new javax.swing.JLabel("Venda");
	        jSeparator1 = new javax.swing.JSeparator();
	        Label_data = new javax.swing.JLabel("Data : ");
	        Label_Editavel_data = new javax.swing.JLabel();
	        Combo_Produto = new javax.swing.JComboBox<>();
	        Label_Prdouto = new javax.swing.JLabel("Produto");
	        Field_Cod_Barras = new javax.swing.JTextField();
	        Label_Cod_barras = new javax.swing.JLabel("Cod. Barras");
	        Label_Valor = new javax.swing.JLabel("Valor Venda");
	        Field_Preco_Venda = new javax.swing.JTextField();
	        Label_Quantidade = new javax.swing.JLabel("Quantidade");
	        Field_Quantidade = new javax.swing.JTextField();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTable1 = new javax.swing.JTable();
	        Btn_Add_Produto = new javax.swing.JButton("Adicionar produto - F1");
	        Btn_Cancelar = new javax.swing.JButton("Cancelar");
	        Btn_Finalizar = new javax.swing.JButton("Finalizar Venda");
	        Btn_Orcamento = new javax.swing.JButton(" Orçamento");
	        Label_Cliente = new javax.swing.JLabel("Cliente");
	        Combo_Cadastrado = new javax.swing.JComboBox<>();
	        Field_nao_cadastrado = new javax.swing.JTextField();
	        Label_Cadastrados = new javax.swing.JLabel("Cadastrado");
	        Label_nao_cadastrados = new javax.swing.JLabel("Não Cadastrados");
	        Label_Cpf = new javax.swing.JLabel("Cpf");
	        Label_Placa = new javax.swing.JLabel("Placa  ");
	        Field_Placa = new javax.swing.JComboBox<>();
	        Label_Total = new javax.swing.JLabel("Total");
	        Field_Total = new javax.swing.JTextField();
	        jLabel1 = new javax.swing.JLabel("Produtos");
	        jSeparator2 = new javax.swing.JSeparator();
	        Field_Cpf = new javax.swing.JFormattedTextField();
	        Btn_Remove = new javax.swing.JButton("Remover Produto");
	        Field_Quantidade.setText("1");
	        Label_Ordem = new javax.swing.JLabel("Numero da Ordem de Serviço");
	        Field_Ordem = new javax.swing.JFormattedTextField();
	        Btn_Ordem = new javax.swing.JButton("Gerar");
	        jRadioButton1 = new javax.swing.JCheckBox("Dinheiro");
	        jRadioButton2 = new javax.swing.JCheckBox("Em conta");
	        jRadioButton3 = new javax.swing.JCheckBox("Cartão");
	        Field_Codigo.setEnabled(false);
	        
	        ButtonGroup Btn_Grupo = new ButtonGroup();
	        Btn_Grupo.add(jRadioButton1);
	        Btn_Grupo.add(jRadioButton2);
	        Btn_Grupo.add(jRadioButton3);
	        
	        Label_Titulo.setFont(new java.awt.Font("Arial Black", 0, 12));
	        Label_Total.setFont(new java.awt.Font("Arial Black", 0, 12));
	        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12));
	        
	        Btn_Add_Produto.setBackground(Color.WHITE);
	        Btn_Add_Produto.setToolTipText("Adicionar");
	        ImageIcon image_Adcionar = new ImageIcon(getClass().getResource("/add.png"));
	        Btn_Add_Produto.setIcon(image_Adcionar);
	        
	        Btn_Cancelar.setBackground(Color.WHITE);
	        Btn_Cancelar.setToolTipText("Cancelar");
	        ImageIcon image_Cancel = new ImageIcon(getClass().getResource("/close.png"));
	        Btn_Cancelar.setIcon(image_Cancel);
	        
	        Btn_Ordem.setBackground(Color.WHITE);
	        Btn_Ordem.setToolTipText("Puxar Ordem de Serviço");
	        ImageIcon image_Ordem = new ImageIcon(getClass().getResource("/check-list.png"));
	        Btn_Ordem.setIcon(image_Ordem);
	        
	        Btn_Finalizar.setBackground(Color.GREEN);
	        Btn_Finalizar.setToolTipText("Finalizar Venda");
	        ImageIcon image_finalizar = new ImageIcon(getClass().getResource("/tick.png"));
	        Btn_Finalizar.setIcon(image_finalizar);
	        
	        Btn_Orcamento.setBackground(Color.WHITE);
	        Btn_Orcamento.setToolTipText("Orçamento");
	        ImageIcon image_orcamento = new ImageIcon(getClass().getResource("/project.png"));
	        Btn_Orcamento.setIcon(image_orcamento);
	        
	        Btn_Remove.setBackground(Color.WHITE);
	        Btn_Remove.setToolTipText("Remover");
	        ImageIcon image_Remover = new ImageIcon(getClass().getResource("/minus.png"));
	        Btn_Remove.setIcon(image_Remover);
	        
	      //Coloca as especificações nos campos da tabela
	     	Vector<String> columnVenda = new Vector<String>();
	     	columnVenda.add("Produto");
	     	columnVenda.add("Cod Barras");
	     	columnVenda.add("Quantidade");
	     	columnVenda.add("Valor");
			Vector<? extends Vector> vector = new Vector();
			jTable1= new JTable(vector,columnVenda);
			jScrollPane1 = new JScrollPane(jTable1);
			
	        
		
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_Cod_Venda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Field_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Label_data)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Label_Editavel_data, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Label_Placa)
                                        .addGap(18, 18, 18)
                                        .addComponent(Field_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Label_Ordem))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_Prdouto)
                                    .addComponent(Label_Cliente)
                                    .addComponent(Label_Cod_barras)))
                            .addComponent(Field_Ordem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Ordem))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Btn_Add_Produto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Btn_Remove)
                                        .addGap(48, 48, 48)
                                        .addComponent(Btn_Cancelar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(126, 126, 126)
                                        .addComponent(Label_Cadastrados)
                                        .addGap(257, 257, 257)
                                        .addComponent(Label_nao_cadastrados)))
                                .addGap(0, 21, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(Combo_Cadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Field_nao_cadastrado))
                                    .addComponent(Combo_Produto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Field_Cod_Barras))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(Label_Cpf))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Label_Quantidade)
                                            .addComponent(Label_Valor))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Field_Preco_Venda, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(Field_Quantidade)
                            .addComponent(Field_Cpf)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Btn_Orcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_Finalizar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Label_Total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Field_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_Titulo)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_nao_cadastrados, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Cadastrados))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Combo_Cadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Field_nao_cadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Cpf)
                            .addComponent(Field_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Field_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Cod_Venda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Cliente)
                            .addComponent(Label_Editavel_data)
                            .addComponent(Label_data))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Prdouto)
                    .addComponent(Combo_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Valor)
                    .addComponent(Field_Preco_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Placa)
                    .addComponent(Field_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Cod_barras)
                            .addComponent(Field_Cod_Barras, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Quantidade)
                            .addComponent(Field_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Add_Produto)
                            .addComponent(Btn_Cancelar)
                            .addComponent(Btn_Remove)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Ordem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Field_Ordem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Ordem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Total)
                            .addComponent(Field_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Finalizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jRadioButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Btn_Orcamento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)))
                .addGap(22, 22, 22))
        );
        
           
        Btn_Finalizar.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent e) {
			
					if(Cad_Servico()) {
						 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
						 tablemodel_Cadastrados.setRowCount(0);
						 contador_Table = 0;
						 Field_Preco_Venda.setText("0.00");
						 update_servico_feito();
						 Lib_Campos();
						 Total =0.0;
						 seleciona_Num_venda();
					}
			}	
	});    
        
        Btn_Cancelar.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent e) {
				if(contador_Table == 0)erro();
				else 
					Limpa_tabela();
					Limpa_Dados();
					Total =0.0;
				
			}
		});
        
        Btn_Ordem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gera_Venda();
					
		}
	});
        
        Btn_Orcamento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Cad_Orcamento()){
					 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
					 tablemodel_Cadastrados.setRowCount(0);
					 contador_Table = 0;
					 Field_Preco_Venda.setText("0.00");
					 Lib_Campos();
					 Total =0.0;
					 seleciona_Num_venda();
				}
					
		}
	});
        
        Btn_Remove.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent arg0) {
				Verica_Linha();
			}
	});
        
        Btn_Add_Produto.addActionListener(new ActionListener() {
			
        	@Override
			public void actionPerformed(ActionEvent e) {
				if(Verifica()){
					Bloq_Campos();
					update_tabela();
					soma_valor_serv_prod();
					Limpa_Dados();
					Combo_Produto.setSelectedItem("Seleciona");
				}
				
			}
	});
      //Funcao da combo box produto
        Combo_Produto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Mostra_Produto();
				
			}
		});
        
        //Funcao da combo box cliente
        Combo_Cadastrado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Mostrar_Cliente();
				
			}
		});
        
        Field_Cod_Barras.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {}
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {}
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {

				 java.awt.event.KeyEvent evt = null;
				 
				 if (e.getKeyCode() == Event.ENTER) {
						seleciona_Produto();
					}
			}
			
		});
        
    }
	
	private void update_servico_feito(){
				
		String sql_update = "UPDATE ordem_servico_finalizado "
				+"SET "
				+ "feito_venda = '1'" 
				+" WHERE Cod_serv = '" + Field_Ordem.getText() +"';";
		
		try{
			PreparedStatement statement = connection.prepareStatement(sql_update);
			statement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		}
		
	
	private void Gera_Venda(){
		
		String Cod_Serv;
		int feito_venda = 0;
		int Cad = 0;
		int verifica = 0;
		
		String sql_Orcamento = "select cod_serv, feito_venda from ordem_servico_finalizado "
				+ "group by cod_serv, feito_venda" ;
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql_Orcamento);
			while(result.next()){
				Cod_Serv = result.getString("COD_SERV");
				feito_venda = result.getInt("feito_venda");
				
				System.out.println(Cod_Serv + "COD_SERV");
				System.out.println(feito_venda + "FEITO VENDA");
				System.out.println();
				
				if(Field_Ordem.getText().equals(Cod_Serv)){
					verifica = 1;
						if(feito_venda == 1){
							Cad = 1;
					}	
				}			
			}
		} 
    catch (SQLException e) {
  e.printStackTrace();
 }
    	
    	System.out.println(verifica);
    	System.out.println(feito_venda);
    	    	
    	if(Field_Ordem.getText().trim().isEmpty() || verifica == 0 ){
			JOptionPane.showMessageDialog(this, "Nenhum Número de serviço foi "
					+ "encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
			
		}else if(Cad == 1){
	    		JOptionPane.showMessageDialog(this, "Este numero de serviço ja foi feita a venda ",
					 "Erro", JOptionPane.WARNING_MESSAGE);
	    			Field_Ordem.requestFocus();
	    	}else{
	    		Completa_table_Venda();
	    	}
		
    	    	
    	verifica = 3;	
		Cad = 3;
	}
	
	private void Completa_table_Venda(){
		
		DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
		tablemodel_Cadastrados.setRowCount(0);
		for(Servico_Add servico : servicoDAO.getGroup_Tabela_Servicos_finalizados(Field_Ordem.getText())){
        	
    		Object[] data = {
    				
    				servico.getProduto(),
    				"CODIGO BARRAS",
    				servico.getQtd_Produto(),
    				servico.getValor_Produto()
        			
    		};
    		contador_Table++;
    			tablemodel_Cadastrados.addRow(data);
    			 
		}
		
		for(Servico_Add servico : servicoDAO.getGroup_Tabela_Servicos_finalizados(Field_Ordem.getText())){
			
			Field_Total.setText(String.valueOf(servico.getValor_Total()));
			Combo_Cadastrado.setSelectedItem(servico.getCliente().toString());
			Field_Placa.setSelectedItem(servico.getPlaca_Carro().toString());
		}
		
		Bloq_Ordem();
	}
	
	private void Bloq_Ordem(){
		Combo_Cadastrado.setEnabled(false);
		Field_Cod_Barras.setEnabled(false);
		Field_Cpf.setEnabled(false);
		Field_nao_cadastrado.setEnabled(false);
		Field_Ordem.setEnabled(false);
		Field_Placa.setEnabled(false);
		Field_Preco_Venda.setEnabled(false);
		Field_Quantidade.setEnabled(false);
		Field_Total.setEnabled(false);
		Combo_Produto.setEnabled(false);
		Btn_Add_Produto.setEnabled(false);
		Btn_Cancelar.setEnabled(false);
		Btn_Orcamento.setEnabled(false);
		Btn_Ordem.setEnabled(false);
		Btn_Remove.setEnabled(false);
	}


	
	
	private boolean Cad_Orcamento(){
		String tipo = "venda";
	 	 if(jRadioButton1.isSelected()) tipo = "Dinheiro";
	 	 if(jRadioButton2.isSelected()) tipo = "Conta";
	 	 if(jRadioButton3.isSelected()) tipo = "Cartao";
	 	 
	 	 if(tipo.equals("venda")){
	 		JOptionPane.showMessageDialog(this, "Selecione uma forma de pagamento", "Erro", JOptionPane.WARNING_MESSAGE);
	 		return false;
	 	 }	 
	 	 
	 	 if(Field_Placa.getSelectedItem().equals("Seleciona")){
	 		JOptionPane.showMessageDialog(this, "Selecione uma placa Valida"
	 				+ "\n Ou cadastre uma placa para esse cliente", "Erro", JOptionPane.WARNING_MESSAGE);
	 		return false;
	 	 }
	 	 
		 Venda_add vendas = new Venda_add();
		 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
		
		 String Data = Label_Editavel_data.getText();
		 String [] DataSeparada = Data.split("/");
		 LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));

		 
		if(contador_Table == 1 ) {
			vendas.setCod_venda(Field_Codigo.getText());
			vendas.setCliente_venda(Combo_Cadastrado.getSelectedItem().toString());
			vendas.setProduto(String.valueOf(jTable1.getModel().getValueAt(0, 0)));
			vendas.setQuant(String.valueOf(jTable1.getModel().getValueAt(0, 2)));
			vendas.setValor_venda(String.valueOf(jTable1.getModel().getValueAt(0, 3)));
			vendas.setCpf_venda(String.valueOf(Field_Cpf.getText()));
			vendas.setCod_barras(String.valueOf(jTable1.getModel().getValueAt(0, 1)));
			vendas.setPlaca(Field_Placa.getSelectedItem().toString());
			vendas.setNum_os(tipo);
			vendas.setValor_Total(Double.valueOf(Field_Total.getText().replace(",", ".")));
			vendas.setData_venda(java.sql.Date.valueOf(dia));
			vendaDAO.Insert_Orcamento(vendas);
			JOptionPane.showMessageDialog(this, "Venda Finalizada!", "Sucesso", JOptionPane.WARNING_MESSAGE);
		}else if(contador_Table > 1) {
				while(contador_Table != 0) {
					vendas.setCod_venda(Field_Codigo.getText());
					vendas.setCliente_venda(Combo_Cadastrado.getSelectedItem().toString());
					vendas.setProduto(String.valueOf(jTable1.getModel().getValueAt(0, 0)));
					vendas.setQuant(String.valueOf(jTable1.getModel().getValueAt(0, 2)));
					vendas.setValor_venda(String.valueOf(jTable1.getModel().getValueAt(0, 3)));
					vendas.setCpf_venda(String.valueOf(Field_Cpf.getText()));
					vendas.setCod_barras(String.valueOf(jTable1.getModel().getValueAt(0, 1)));
					vendas.setPlaca(Field_Placa.getSelectedItem().toString());
					vendas.setValor_Total(Double.valueOf((String) jTable1.getModel().getValueAt(0, 3)) * 
							Double.valueOf((String) jTable1.getModel().getValueAt(0, 2)));
					vendas.setNum_os(tipo);
					vendas.setData_venda(java.sql.Date.valueOf(dia));
					vendaDAO.Insert_Orcamento(vendas);
				tablemodel_Cadastrados.removeRow(0);
				contador_Table --;
			}
			JOptionPane.showMessageDialog(this, "Orçamento Finalizado!", "Sucesso", JOptionPane.WARNING_MESSAGE);
		}else if(contador_Table == 0) {
			erro();				
			return false;
		}
		
		return true;
	}
	
	public void seleciona_Num_venda(){
		
		String Cod_venda = null;
		String Cod_orcamento = null;
		int cod_venda = 0;
		int cod_orcamento = 0;
		String sql = "SELECT cod_venda FROM VENDAS" ;
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				Cod_venda = result.getString("COD_VENDA");
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
    	
    	cod_venda = Integer.valueOf(Cod_venda);
    	
    	String sql_Orcamento = "SELECT cod_orcamento FROM ORCAMENTO" ;
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql_Orcamento);
			while(result.next()){
				Cod_orcamento = result.getString("COD_ORCAMENTO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
    	cod_orcamento = Integer.valueOf(Cod_orcamento);
    	    	
    if(cod_venda >= cod_orcamento){
    	if(cod_venda <= 9){
        	cod_venda = Integer.valueOf(Cod_venda) + 1;
        	Field_Codigo.setText("000"+String.valueOf(cod_venda));
        }
        else if(cod_venda > 9 && cod_venda < 100){
        	cod_venda = Integer.valueOf(Cod_venda) + 1;
        	Field_Codigo.setText("00"+String.valueOf(cod_venda));
        }
        else if( cod_venda > 100 && cod_venda <= 1000){
        	cod_venda = Integer.valueOf(Cod_venda) + 1;
        	Field_Codigo.setText(String.valueOf(cod_venda));
        }
    }else{
    	if(cod_orcamento <= 9){
    		cod_orcamento = Integer.valueOf(Cod_orcamento) + 1;
        	Field_Codigo.setText("000"+String.valueOf(cod_orcamento));
        }
        else if(cod_orcamento > 9 && cod_orcamento < 100){
        	cod_orcamento = Integer.valueOf(Cod_orcamento) + 1;
        	Field_Codigo.setText("00"+String.valueOf(cod_orcamento));
        }
        else if( cod_orcamento > 100 && cod_orcamento <= 1000){
        	cod_orcamento = Integer.valueOf(Cod_orcamento) + 1;
        	Field_Codigo.setText(String.valueOf(cod_orcamento));
        }
    }
       
}

	private void seleciona_Produto(){
		 
		String sql = "SELECT * FROM produtos where cod_barras = '" + Field_Cod_Barras.getText() +"'" ;
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				Field_Preco_Venda.setText(result.getString("preco_venda"));
				Field_Cod_Barras.setText(result.getString("cod_barras"));
				Combo_Produto.setSelectedItem(result.getString("descricao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

	}
	}
	
private void Bloq_Campos(){
	Combo_Cadastrado.setEnabled(false);
}



private void update_tabela() {

	DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
	tablemodel_Cadastrados.setRowCount(contador_Table);
	
	
    	Object[] data = {
				Combo_Produto.getSelectedItem(),
				Field_Cod_Barras.getText(),
				Field_Quantidade.getText(),
				Field_Preco_Venda.getText()
				
		};
    	
		tablemodel_Cadastrados.addRow(data);
		contador_Table ++;
}

private void soma_valor_serv_prod(){
	
	Double produto = Double.valueOf(Field_Preco_Venda.getText());
	Double Qtd = Double.valueOf(Field_Quantidade.getText());
	Total = Total + (produto * Qtd );
	Field_Total.setText(String.format("%.2f", Double.parseDouble(String.valueOf(Total))));
	
}


private void Limpa_Dados() {
	
	Field_Cod_Barras.setText(null);
	Field_Quantidade.setText("1");
	Field_Preco_Venda.setText("0.00");
	
}

 public void data() {
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
		
		Label_Editavel_data.setText(data);
	}
 
 
 public void Update_combo_cliente(){
	  Combo_Cadastrado.removeAllItems();
	  Combo_Cadastrado.addItem("Seleciona");
	  
	  String sql = "SELECT * FROM clientes "
	  		+ "where bloquear = '0'"
	  		+ " ORDER BY nome ";
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
			Combo_Cadastrado.addItem(result.getString("Nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
  }
 
 
 public void Update_combo_produto(){
	  Combo_Produto.removeAllItems();
	  Combo_Produto.addItem("Seleciona");
	  
	  String sql = "SELECT * FROM produtos ORDER BY descricao";
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				Combo_Produto.addItem(result.getString("Descricao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  
  }
 

 private boolean Cad_Servico() {
	 
	 	 String tipo = "venda";
	 	 if(jRadioButton1.isSelected()) tipo = "Dinheiro";
	 	 if(jRadioButton2.isSelected()) tipo = "Conta";
	 	 if(jRadioButton3.isSelected()) tipo = "Cartao";
	 	 
	 	 if(tipo.equals("venda")){
	 		JOptionPane.showMessageDialog(this, "Selecione uma forma de pagamento", "Erro", JOptionPane.WARNING_MESSAGE);
	 		return false;
	 	 }	 
	 	 
	 	 if(Field_Placa.getSelectedItem().equals("Seleciona")){
	 		JOptionPane.showMessageDialog(this, "Selecione uma placa Valida"
	 				+ "\n Ou cadastre uma placa para esse cliente", "Erro", JOptionPane.WARNING_MESSAGE);
	 		return false;
	 	 }
	 	 
		 Venda_add vendas = new Venda_add();
		 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
		
		 String Data = Label_Editavel_data.getText();
		 String [] DataSeparada = Data.split("/");
		 LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));

		 
		if(contador_Table == 1 ) {
			vendas.setCod_venda(Field_Codigo.getText());
			vendas.setCliente_venda(Combo_Cadastrado.getSelectedItem().toString());
			vendas.setProduto(String.valueOf(jTable1.getModel().getValueAt(0, 0)));
			vendas.setQuant(String.valueOf(jTable1.getModel().getValueAt(0, 2)));
			vendas.setValor_venda(String.valueOf(jTable1.getModel().getValueAt(0, 3)));
			vendas.setCpf_venda(String.valueOf(Field_Cpf.getText()));
			vendas.setCod_barras(String.valueOf(jTable1.getModel().getValueAt(0, 1)));
			vendas.setPlaca(Field_Placa.getSelectedItem().toString());
			vendas.setNum_os(tipo);
			vendas.setValor_Total(Double.valueOf(Field_Total.getText().replace(",", ".")));
			vendas.setData_venda(java.sql.Date.valueOf(dia));
			vendaDAO.Insert(vendas);
			JOptionPane.showMessageDialog(this, "Venda Finalizada!", "Sucesso", JOptionPane.WARNING_MESSAGE);
			update_quantidade();
		}else if(contador_Table > 1) {
				while(contador_Table != 0) {
					update_quantidade();
					vendas.setCod_venda(Field_Codigo.getText());
					vendas.setCliente_venda(Combo_Cadastrado.getSelectedItem().toString());
					vendas.setProduto(String.valueOf(jTable1.getModel().getValueAt(0, 0)));
					vendas.setQuant(String.valueOf(jTable1.getModel().getValueAt(0, 2)));
					vendas.setValor_venda(String.valueOf(jTable1.getModel().getValueAt(0, 3)));
					vendas.setCpf_venda(String.valueOf(Field_Cpf.getText()));
					vendas.setCod_barras(String.valueOf(jTable1.getModel().getValueAt(0, 1)));
					vendas.setPlaca(Field_Placa.getSelectedItem().toString());
					vendas.setValor_Total(Double.valueOf((String) jTable1.getModel().getValueAt(0, 3)) * 
							Double.valueOf((String) jTable1.getModel().getValueAt(0, 2)));
					vendas.setNum_os(tipo);
					vendas.setData_venda(java.sql.Date.valueOf(dia));
					vendaDAO.Insert(vendas);
				tablemodel_Cadastrados.removeRow(0);
				contador_Table --;
			}
			JOptionPane.showMessageDialog(this, "Venda Finalizada!", "Sucesso", JOptionPane.WARNING_MESSAGE);
		}else if(contador_Table == 0) {
			erro();				
			return false;
		}
		
		return true;
	}
 
 
 private void Lib_Campos(){
		Combo_Cadastrado.setEnabled(true);
		Combo_Produto.setEnabled(true);
		Combo_Cadastrado.setSelectedItem("Seleciona");
		Combo_Produto.setSelectedItem("Seleciona");
		Field_Cpf.setText(null);
		Total = 0.00;
		Btn_Add_Produto.setEnabled(true);
		Btn_Cancelar.setEnabled(true);
		Btn_Orcamento.setEnabled(true);
		Btn_Ordem.setEnabled(true);
		Btn_Remove.setEnabled(true);
		Combo_Cadastrado.setEnabled(true);
		Field_Cod_Barras.setEnabled(true);
		Field_Cpf.setEnabled(true);
		Field_nao_cadastrado.setEnabled(true);
		Field_Ordem.setEnabled(true);
		Field_Placa.setEnabled(true);
		Field_Preco_Venda.setEnabled(true);
		Field_Quantidade.setEnabled(true);
		Field_Total.setEnabled(true);
		Combo_Produto.setEnabled(true);
		Field_Ordem.setText(null);
		Field_Total.setText(null);
	}
 
 private void erro() {
		JOptionPane.showMessageDialog(this, "Nenhum produto ou serviço foi adicionado", "Erro", JOptionPane.WARNING_MESSAGE);
	}
 
 private boolean Verifica(){
		
		if(Combo_Cadastrado.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione um Cliente valido", "Erro", JOptionPane.WARNING_MESSAGE);
			Combo_Cadastrado.requestFocus();
			return false;
		}
		if(Combo_Produto.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione um Produto valido", "Erro", JOptionPane.WARNING_MESSAGE);
			Combo_Produto.requestFocus();
			return false;
		}
		if(Field_Cpf.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o cpf", "Erro", JOptionPane.WARNING_MESSAGE);
			Label_Cpf.requestFocus();
			return false;
		}
		
		if(Field_Cod_Barras.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Codigo de Barras", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cod_Barras.requestFocus();
			return false;
		}
		if(Field_Codigo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Codigo", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Codigo.requestFocus();
			return false;
		}
		
		if(Field_Quantidade.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha a Quantidade", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Quantidade.requestFocus();
			return false;
		}
		
		if(Field_Preco_Venda.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Preço de Venda", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Preco_Venda.requestFocus();
			return false;
		}
		
		if(Field_Placa.getSelectedItem().equals("Selecionar")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Placa", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Placa.requestFocus();
			return false;
		}
		return true;
	}

 
 private void Mostra_Produto(){
		
		String sql = "SELECT * FROM produtos where Descricao = '" + Combo_Produto.getSelectedItem() +"'" ;
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				Field_Preco_Venda.setText(result.getString("preco_venda"));
				Field_Cod_Barras.setText(result.getString("cod_barras"));
				//Field_Codigo.setText(result.getString("cod_sistema"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();

	}
}
 
 private void Mostrar_Cliente(){	
	 		
	 		Field_Placa.removeAllItems();
	 		Field_Placa.addItem("Seleciona");
	 
	 
			String sql = "SELECT * FROM placa_veiculos where cliente = '" + Combo_Cadastrado.getSelectedItem() +"';";
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()){
					Field_Placa.addItem(result.getString("placa"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}
	    	
			
				
			String sql_cpf = "SELECT CPF FROM CLIENTES WHERE NOME ='"+Combo_Cadastrado.getSelectedItem()+"'" ;
			try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql_cpf);
				while(result.next()){
					Field_Cpf.setText(result.getString("CPF"));
					}
				} catch (SQLException a) {
					a.printStackTrace();
				}
			
		}
	
 
 
 
 public void update_quantidade(){
	 
	 String qtd = "0";
	 String cod = (String) jTable1.getModel().getValueAt(0, 1);
	 Double total_novo = 0.0;
	 Produto_Add produto = new Produto_Add();
		String sql = "SELECT QUANTIDADE FROM PRODUTOS"
				+ " WHERE COD_BARRAS = '"+cod+"';";
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				qtd = result.getString("QUANTIDADE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
	}
		
		total_novo = Double.valueOf(qtd) - Double.valueOf((String) jTable1.getModel().getValueAt(0,2)); 
		
		String sql_qtd = "UPDATE PRODUTOS"
				+" SET " 
				+" QUANTIDADE ='" + total_novo
				+"' WHERE COD_BARRAS = '"+ cod
				+"'";
			
					try{
						PreparedStatement statement = connection.prepareStatement(sql_qtd);
						statement.execute();
					}catch (SQLException e) {
						e.printStackTrace();
					}
	}
 
 
 
 private void Limpa_tabela() {
	 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
	 int resposta = JOptionPane.showConfirmDialog(null, "Deseja as Informações da tabela ?", "Excluir", JOptionPane.YES_NO_OPTION);
	
	 if(resposta == JOptionPane.YES_OPTION){
		 tablemodel_Cadastrados.setRowCount(0);
		}
	 
	 contador_Table = 0;
	 Field_Total.setText("0.00");
	 Lib_Campos();
 }
 
 private void Verica_Linha(){
		DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
		int Numero_linha = jTable1.getSelectedRow();
		 if(Numero_linha == -1) {
			  JOptionPane.showMessageDialog(this, "Linha não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
		 }else{
			 int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Excluir", JOptionPane.YES_NO_OPTION);
			 if(resposta == JOptionPane.YES_OPTION){
				  if(Numero_linha >= 0){
					  
					  Double produto = Double.valueOf((String) jTable1.getModel().getValueAt(Numero_linha, 3));
					  Double Qtd = Double.valueOf((String)jTable1.getModel().getValueAt(Numero_linha, 2));
					  Total = (produto * Qtd);
					  double total_venda = Double.valueOf(Field_Total.getText().replace(",", "."));
					  Field_Total.setText(String.format("%.2f", Double.parseDouble(String.valueOf(total_venda - Total))));
					  tablemodel_Cadastrados.removeRow(Numero_linha);
					  contador_Table --;
					  if(contador_Table == 0 ) Lib_Campos();
				  }
				}
		 }
	}
	
	
	// Variables declaration - do not modify                     
	 	private javax.swing.JButton Btn_Add_Produto;
	    private javax.swing.JButton Btn_Cancelar;
	    private javax.swing.JButton Btn_Finalizar;
	    private javax.swing.JButton Btn_Ordem;
	    private javax.swing.JButton Btn_Orcamento;
	    private javax.swing.JButton Btn_Remove;
	    private javax.swing.JComboBox<String> Combo_Cadastrado;
	    private javax.swing.JComboBox<String> Combo_Produto;
	    private javax.swing.JTextField Field_Cod_Barras;
	    private javax.swing.JTextField Field_Codigo;
	    private javax.swing.JFormattedTextField Field_Cpf;
	    private javax.swing.JFormattedTextField Field_Ordem;
	    private javax.swing.JComboBox<String> Field_Placa;
	    private javax.swing.JTextField Field_Preco_Venda;
	    private javax.swing.JTextField Field_Quantidade;
	    private javax.swing.JTextField Field_Total;
	    private javax.swing.JTextField Field_nao_cadastrado;
	    private javax.swing.JLabel Label_Cadastrados;
	    private javax.swing.JLabel Label_Cliente;
	    private javax.swing.JLabel Label_Cod_Venda;
	    private javax.swing.JLabel Label_Cod_barras;
	    private javax.swing.JLabel Label_Cpf;
	    private javax.swing.JLabel Label_Ordem;
	    private javax.swing.JLabel Label_Placa;
	    private javax.swing.JLabel Label_Prdouto;
	    private javax.swing.JLabel Label_Quantidade;
	    private javax.swing.JLabel Label_Titulo;
	    private javax.swing.JLabel Label_Total;
	    private javax.swing.JLabel Label_Valor;
	    private javax.swing.JLabel Label_data;
	    private javax.swing.JLabel Label_Editavel_data;
	    private javax.swing.JLabel Label_nao_cadastrados;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
	    private javax.swing.JTable jTable1;
	    private javax.swing.JCheckBox jRadioButton1;
	    private javax.swing.JCheckBox jRadioButton2;
	    private javax.swing.JCheckBox jRadioButton3;
	    private VendaDAO vendaDAO;
	    private ProdutoDAO produtoDAO;
	    private ServicoDAO servicoDAO;
	    
    // End of variables declaration 
}
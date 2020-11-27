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
import java.util.concurrent.BlockingQueue;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.TabableView;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Funcionario_add;
import mecanicaDAO.Servico_Add;
import mecanicaDAOServico.ServicoDAO;

public class Tela_Ordem_Servico extends JPanel {
	private Connection connection;
	Double Total = 0.00;
	int contador_Table = 0;
	public Tela_Ordem_Servico() throws SQLException {
        initComponents();
        connection = ConnectionDAO.getConnection();
        servicoDAO = new ServicoDAO();
    }
	
	
	@SuppressWarnings("unchecked")
                     
    private void initComponents() {
	
        Label_Titulo_Ordem = new javax.swing.JLabel("Ordem de Serviço");
        jSeparator1 = new javax.swing.JSeparator();
        Label_Cod_Servico = new javax.swing.JLabel("Codigo do Serviço : ");
        Label_Cliente = new javax.swing.JLabel("Cliente");
        Combo_Nome_Cliente = new javax.swing.JComboBox<>();
        Label_Data = new javax.swing.JLabel("Data : ");
        Label_Editavel_data = new javax.swing.JLabel();
        Label_Serviço = new javax.swing.JLabel("Serviço");
        ScrollPane_add_Produto_Servico = new javax.swing.JScrollPane();
        Table_add_Prod_Serv = new javax.swing.JTable();
        Label_Produto = new javax.swing.JLabel("Produto");
        Combo_Produto = new javax.swing.JComboBox<>();
        Label_funcionario = new javax.swing.JLabel("Funcionário");
        Combo_Funcionario = new javax.swing.JComboBox<>();
        Btn_Selecionar = new javax.swing.JButton("Cancelar");
        Btn_Adicionar = new javax.swing.JButton("Adicionar");
        Label_Titulo_ordem_Aberto = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        ScrollPane_Serv_abert = new javax.swing.JScrollPane();
        Table_servico_aberto = new javax.swing.JTable();
        Label_Selecione_Linha_ou_Cod = new javax.swing.JLabel("Digite o Codigo do serviço :");
        Field_Cod_aberto = new javax.swing.JFormattedTextField();
        Btn_Busca_Senha = new javax.swing.JButton("Buscar Serviço");
        textArea1 = new javax.swing.JFormattedTextField();
        Label_valor = new javax.swing.JLabel("Valor Total do serviço : R$");
        Btn_gerar = new javax.swing.JButton("Gerar");
        Btn_Cancelar = new javax.swing.JButton("Cancelar");
        Label_Placa = new javax.swing.JLabel("Placa do Carro");
        Combo_Placa = new javax.swing.JComboBox<>();
        Btn_Remover = new javax.swing.JButton("Remover");
        Label_Quantidade = new javax.swing.JLabel("Quantidade");
        Field_Quantidade = new javax.swing.JFormattedTextField();
        field_editavel_total = new javax.swing.JFormattedTextField(0.00);
        Btn_Editar = new javax.swing.JButton("Editar Serviço");
        Btn_fazer_venda = new javax.swing.JButton("Finalizar Serviço");
        Field_Editavel_Cod_Servico = new javax.swing.JFormattedTextField();
        Label_valor_Serviço = new javax.swing.JLabel("Valor do Serviço");
        Field_Valor_serviço = new javax.swing.JFormattedTextField();
        Btn_Imprimir = new javax.swing.JButton("Imprimir");
        Label_valor_Produto = new javax.swing.JLabel("Valor");
        Field_Valor_Produto = new java.awt.TextField("0.00");
        Btn_Cancela_Busca = new javax.swing.JButton("Cancela Busca");

        Label_Titulo_Ordem.setFont(new java.awt.Font("Arial Black", 0, 12));
        Label_Cod_Servico.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Data.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        Label_Editavel_data.setFont(new java.awt.Font("Tahoma", 0, 12));
        Label_Titulo_ordem_Aberto.setFont(new java.awt.Font("Arial Black", 0, 12));
        Label_valor.setFont(new java.awt.Font("Arial Black", 0, 14));
        Field_Quantidade.setText("1");
        field_editavel_total.setPreferredSize(new java.awt.Dimension(70, 30));
        Field_Editavel_Cod_Servico.setEnabled(false);
        
        Btn_Editar.setEnabled(false);
        
        Btn_Adicionar.setBackground(Color.WHITE);
        Btn_Adicionar.setToolTipText("Adcionar");
        ImageIcon image_Adcionar = new ImageIcon(getClass().getResource("/add.png"));
        Btn_Adicionar.setIcon(image_Adcionar);
        
        Btn_Busca_Senha.setBackground(Color.WHITE);
        Btn_Busca_Senha.setToolTipText("Buscar");
        ImageIcon image_Buscar = new ImageIcon(getClass().getResource("/search (1).png"));
        Btn_Busca_Senha.setIcon(image_Buscar);
        
        Btn_Cancelar.setBackground(Color.WHITE);
        Btn_Cancelar.setToolTipText("Cancelar serviço");
        ImageIcon image_Cancel = new ImageIcon(getClass().getResource("/close.png"));
        Btn_Cancelar.setIcon(image_Cancel);
        
        Btn_Editar.setBackground(Color.WHITE);
        Btn_Editar.setToolTipText("Editar Serviço");
        ImageIcon image_Editar = new ImageIcon(getClass().getResource("/pencil.png"));
        Btn_Editar.setIcon(image_Editar);

        Btn_fazer_venda.setBackground(Color.WHITE);
        Btn_fazer_venda.setToolTipText("Finalizar");
        ImageIcon image_finalizar = new ImageIcon(getClass().getResource("/tick.png"));
        Btn_fazer_venda.setIcon(image_finalizar);
        
        Btn_gerar.setBackground(Color.WHITE);
        Btn_gerar.setToolTipText("Finalizar");
        ImageIcon image_gerar = new ImageIcon(getClass().getResource("/project.png"));
        Btn_gerar.setIcon(image_gerar);
        
        Btn_Imprimir.setBackground(Color.WHITE);
        Btn_Imprimir.setToolTipText("Imprimir");
        ImageIcon image_imprimir = new ImageIcon(getClass().getResource("/print.png"));
        Btn_Imprimir.setIcon(image_imprimir);
        
        Btn_Remover.setBackground(Color.WHITE);
        Btn_Remover.setToolTipText("Remover");
        ImageIcon image_tirar = new ImageIcon(getClass().getResource("/minus.png"));
        Btn_Remover.setIcon(image_tirar);
        
        Btn_Selecionar.setBackground(Color.WHITE);
        Btn_Selecionar.setToolTipText("Cancelar");
        Btn_Selecionar.setIcon(image_Cancel);
        
        Btn_Cancela_Busca.setBackground(Color.WHITE);
        Btn_Cancela_Busca.setToolTipText("Cancelar a Busca");
        Btn_Cancela_Busca.setEnabled(false);
   
        
        //Coloca as especificações nos campos da tabela de serviços
        Vector<String> columnNames = new Vector<String>();
		columnNames.add("Produto");
		columnNames.add("Valor do produto");
		columnNames.add("Qtd prod");
		columnNames.add("Serviço");
		columnNames.add("Valor Serviço");
		Vector<? extends Vector> vector = new Vector();
		Table_add_Prod_Serv = new JTable(vector,columnNames);
		ScrollPane_add_Produto_Servico = new JScrollPane(Table_add_Prod_Serv);
		
		 //Coloca as especificações nos campos da tabela de serviços em aberto
        Vector<String> columnNames1 = new Vector<String>();
		columnNames1.add("Numero");
		columnNames1.add("Cliente");
		columnNames1.add("Placa do Carro");
		columnNames1.add("Valor");
		columnNames1.add("Status");
		Vector<? extends Vector> vector1 = new Vector();
		Table_servico_aberto = new JTable(vector1,columnNames1);
		ScrollPane_Serv_abert = new JScrollPane(Table_servico_aberto);
        
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_Titulo_Ordem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Label_Titulo_ordem_Aberto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(288, 288, 288)
                                            .addComponent(Label_valor)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(field_editavel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                                            .addComponent(Btn_Cancelar)
                                            .addGap(18, 18, 18)
                                            .addComponent(Btn_gerar))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(116, 116, 116)
                                            .addComponent(ScrollPane_add_Produto_Servico, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(235, 235, 235)
                                                .addComponent(Label_Produto))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Label_Data)
                                                .addGap(18, 18, 18)
                                                .addComponent(Label_Editavel_data)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Label_Cliente)
                                                    .addComponent(Label_Serviço)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(Label_Cod_Servico)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Field_Editavel_Cod_Servico, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(Combo_Nome_Cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Combo_Produto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Btn_Adicionar)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_Remover)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_Selecionar)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Label_valor_Serviço)
                                            .addComponent(Label_Quantidade)
                                            .addComponent(Label_Placa)
                                            .addComponent(Label_funcionario))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Combo_Funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(Field_Valor_serviço, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                    .addComponent(Combo_Placa, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Field_Quantidade))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Label_valor_Produto)))))
                                .addGap(4, 4, 4)
                                .addComponent(Field_Valor_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollPane_Serv_abert, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Label_Selecione_Linha_ou_Cod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Field_Cod_aberto)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Btn_Busca_Senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn_Cancela_Busca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fazer_venda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Imprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Titulo_Ordem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Cliente)
                    .addComponent(Combo_Nome_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Placa)
                    .addComponent(Combo_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Label_Produto)
                        .addComponent(Combo_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Label_Quantidade)
                        .addComponent(Field_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Label_valor_Produto)
                        .addComponent(Field_Valor_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Field_Editavel_Cod_Servico, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_Cod_Servico))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Label_Serviço)
                                    .addComponent(Label_Data)
                                    .addComponent(Label_Editavel_data))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Selecionar)
                            .addComponent(Btn_Adicionar)
                            .addComponent(Btn_Remover)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_valor_Serviço)
                            .addComponent(Field_Valor_serviço, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Combo_Funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_funcionario))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane_add_Produto_Servico, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_valor)
                    .addComponent(Btn_gerar)
                    .addComponent(Btn_Cancelar)
                    .addComponent(field_editavel_total, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_Titulo_ordem_Aberto)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Selecione_Linha_ou_Cod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Editar)
                            .addComponent(Field_Cod_aberto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Busca_Senha)
                            .addComponent(Btn_fazer_venda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Imprimir)
                            .addComponent(Btn_Cancela_Busca)))
                    .addComponent(ScrollPane_Serv_abert, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        Btn_Imprimir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Imprimir();
				
			}
		});
		
		
        	//Botao de confirmar servico
        Btn_fazer_venda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gerar_pedido_venda();
				update_tabela_Servico_Aberto();
			}
		});
        
        	//Botao de cancelar a busca
        	Btn_Cancela_Busca.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Lib_All_Campos();
					
				}
			});
        
            //Botao de editar servico
            Btn_Editar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Update_servico();
				}
			});
            
            //Botao de pegar codigo
            Btn_Busca_Senha.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Pega_num_Servico();
				}
			});
            
            //Botao de gerar
            Btn_gerar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Cad_Servico()) {
						 update_tabela_Servico_Aberto();
						 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_add_Prod_Serv.getModel();
						 tablemodel_Cadastrados.setRowCount(0);
						 contador_Table = 0;
						 field_editavel_total.setText(null);
						 Lib_Campos();
						 Insert_Cod();
						 Btn_Editar.setEnabled(false);
						 Total = 0.00;
					}
					
				}
			});
            
            //Botao de remover item da table servico / produtos
            Btn_Remover.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Verica_Linha();
				}
			});
            
            //Botao de adicionar serviço / produtos
            Btn_Adicionar.addActionListener(new ActionListener() {
				
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
					Mostra_Valor_Produto();
					
				}
			});
            
            //Funcao da combo box cliente
            Combo_Nome_Cliente.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Mostrar_placa();
					
				}
			});
            
            //Botao do primeiro cancelar
            Btn_Selecionar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Limpa_Dados();
					
				}
			});
            
            //Botao de apagar todas as linhas da tabela
            Btn_Cancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(contador_Table == 0)erro();
					else Limpa_tabela();
					
				}
			});
        }      
	
	private void Imprimir(){
		
	}
	
	private void Gerar_pedido_venda(){
		  int Numero_linha = Table_servico_aberto.getSelectedRow();
		  if(Numero_linha == -1)JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela ao lado", "Concluído", JOptionPane.WARNING_MESSAGE);
		  String Linha = (String)Table_servico_aberto.getModel().getValueAt(Numero_linha, 0);
		  System.out.println(Numero_linha);
		  if(Numero_linha > 0 ){
			  String sql = "insert into ordem_servico_finalizado select * from ordem_servico"
				 		+ " where cod_serv = '"+Linha+"';";
					  try {
				    		Statement statement = connection.createStatement();
							ResultSet result = statement.executeQuery(sql);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					  JOptionPane.showMessageDialog(this, "Serviço foi Finalizado ", "Concluído", JOptionPane.WARNING_MESSAGE);
		  }else{
			  JOptionPane.showMessageDialog(this, "Serviço não encontrado\n Selecione uma linha da tabela ao lado", "Concluído", JOptionPane.WARNING_MESSAGE);
		  }
				
	}
	
	private void Update_servico(){
		
			String sql = "delete from ordem_servico where cod_serv = '" + Field_Cod_aberto.getText() + "'";
			  
			  try {
		    		Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 JOptionPane.showMessageDialog(this, "Ordem de serviço " + Field_Cod_aberto.getText() +" sera editada", "Atualizar", JOptionPane.WARNING_MESSAGE);
				 data();
				 update_tabela_Servico_Aberto();
				 Lib_All_update();
		
	}
	
	
	private void Pega_num_Servico(){
		int Cad = 0;
		int verifica = 0;
    	
		if(Field_Cod_aberto.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(this, "Nenhum Número de serviço foi informado", "Erro", JOptionPane.WARNING_MESSAGE);
		}else{
			while(verifica != 1){
				if((Table_servico_aberto.getModel().getValueAt(Cad, 0)).equals(Field_Cod_aberto.getText())){
					completa_Table();
					Bloq_All_Campos(); 
					verifica = 1;
				}
				Cad ++;
			}
			Btn_Editar.setEnabled(true);
		}
	}
	
	private void Bloq_All_Campos(){
		Combo_Nome_Cliente.setEnabled(false);
		Combo_Placa.setEnabled(false);
		Combo_Funcionario.setEnabled(false);
		Table_add_Prod_Serv.setEnabled(false);
		textArea1.setEnabled(false);
		Combo_Produto.setEnabled(false);
		Field_Quantidade.setEnabled(false);
		Field_Valor_serviço.setEnabled(false);
		Field_Valor_Produto.setEnabled(false);
		Btn_Adicionar.setEnabled(false);
		Btn_Cancelar.setEnabled(false);
		Btn_fazer_venda.setEnabled(false);
		Btn_gerar.setEnabled(false);
		Btn_Imprimir.setEnabled(false);
		Btn_Remover.setEnabled(false);
		Btn_Selecionar.setEnabled(false);
		Btn_Cancela_Busca.setEnabled(true);
		Btn_Busca_Senha.setEnabled(false);
	}
	
	private void Lib_All_Campos(){
		DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_add_Prod_Serv.getModel();
		Combo_Nome_Cliente.setEnabled(true);
		Combo_Placa.setEnabled(true);
		Combo_Funcionario.setEnabled(true);
		Table_add_Prod_Serv.setEnabled(true);
		Field_Editavel_Cod_Servico.setEnabled(true);
		textArea1.setEnabled(true);
		Combo_Produto.setEnabled(true);
		Field_Quantidade.setEnabled(true);
		Field_Valor_serviço.setEnabled(true);
		Field_Valor_Produto.setEnabled(true);
		Btn_Adicionar.setEnabled(true);
		Btn_Cancelar.setEnabled(true);
		Btn_fazer_venda.setEnabled(true);
		Btn_gerar.setEnabled(true);
		Btn_Imprimir.setEnabled(true);
		Btn_Remover.setEnabled(true);
		Btn_Selecionar.setEnabled(true);
		Btn_Cancela_Busca.setEnabled(false);
		Btn_Busca_Senha.setEnabled(true);
		Limpa_Dados();
		Lib_Campos();
		contador_Table = 0;
		field_editavel_total.setText("0.00");
		tablemodel_Cadastrados.setRowCount(0);
		Field_Cod_aberto.setText(null);
		Field_Editavel_Cod_Servico.setText(null);
		data();
		update_tabela_Servico_Aberto();
	}
	
	private void Lib_All_update(){
		Bloq_Campos();
		Table_add_Prod_Serv.setEnabled(true);
		textArea1.setEnabled(true);
		Combo_Produto.setEnabled(true);
		Field_Quantidade.setEnabled(true);
		Field_Valor_serviço.setEnabled(true);
		Field_Valor_Produto.setEnabled(true);
		Btn_Adicionar.setEnabled(true);
		Btn_Cancelar.setEnabled(true);
		Btn_fazer_venda.setEnabled(true);
		Btn_gerar.setEnabled(true);
		Btn_Imprimir.setEnabled(true);
		Btn_Remover.setEnabled(true);
		Btn_Selecionar.setEnabled(true);
		Btn_Cancela_Busca.setEnabled(false);
		Btn_Busca_Senha.setEnabled(true);
	}
	
	private void completa_Table(){
		
		DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_add_Prod_Serv.getModel();
		tablemodel_Cadastrados.setRowCount(0);
		String Cod = Field_Cod_aberto.getText();
		for(Servico_Add servico : servicoDAO.getGroup_Tabela(Cod)){
        	
    		Object[] data = {
    				
    				servico.getProduto(),
    				servico.getValor_Produto(),
    				servico.getQtd_Produto(),
    				servico.getServico(),
    				servico.getValor_servico()
        			
    		};
    		contador_Table ++;
    			tablemodel_Cadastrados.addRow(data);
    			 
    	}  
		
		for(Servico_Add servico : servicoDAO.getGroup_Combo_Fields(Cod)){
			
			Field_Editavel_Cod_Servico.setText(servico.getCod_Serv());
			field_editavel_total.setText(String.valueOf(servico.getValor_Total()));
			Combo_Nome_Cliente.setSelectedItem(servico.getCliente().toString());
			Combo_Placa.setSelectedItem(servico.getPlaca_Carro().toString());
			Combo_Funcionario.setSelectedItem(servico.getFuncionario().toString());
			String data ;
			data = String.valueOf(servico.getData());
			Label_Editavel_data.setText(data);
		}
		
		
		
	}

	public void update_tabela_Servico_Aberto() {
		
		DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_servico_aberto.getModel();
    	tablemodel_Cadastrados.setRowCount(0);
    	//int i = 1;
    	//String cad = (String) Table_add_Prod_Serv.getModel().getValueAt(i, 0);
    
        	for(Servico_Add servico : servicoDAO.getGroup()){
            	
            		Object[] data = {
            				servico.getCod_Serv(),
            				servico.getCliente(),
            				servico.getPlaca_Carro(),
            				servico.getValor_Total(),
            				"A"
                			
            		};
            			tablemodel_Cadastrados.addRow(data);
            
            	}   
        	
        	
	}
	
	private void erro() {
		JOptionPane.showMessageDialog(this, "Nenhum produto ou serviço foi adicionado", "Erro", JOptionPane.WARNING_MESSAGE);
	}
	
	private void Verica_Linha(){
		DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_add_Prod_Serv.getModel();
		int Numero_linha = Table_add_Prod_Serv.getSelectedRow();
		 if(Numero_linha == -1) {
			  JOptionPane.showMessageDialog(this, "Linha não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
		 }else{
			 int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Excluir", JOptionPane.YES_NO_OPTION);
			 if(resposta == JOptionPane.YES_OPTION){
				  if(Numero_linha >= 0){
					  Double Subtrai = 0.00;
					  Total = 0.00;
					  Total = Double.valueOf(field_editavel_total.getText().replace(",", "."));
					  Double produto = Double.valueOf((String) Table_add_Prod_Serv.getModel().getValueAt(Numero_linha, 1));
					  Double Qtd = Double.valueOf((String)Table_add_Prod_Serv.getModel().getValueAt(Numero_linha, 2));
					  Double servico = Double.valueOf((String)Table_add_Prod_Serv.getModel().getValueAt(Numero_linha, 4));
					  Subtrai =  ((produto * Qtd ) + servico);
					  field_editavel_total.setText(String.format("%.2f", Double.parseDouble(String.valueOf(Total-Subtrai).replace(",", "."))));
					  System.out.println(Numero_linha);
					  tablemodel_Cadastrados.removeRow(Numero_linha);
					  contador_Table --;
					  if(contador_Table == 0 ) Lib_Campos();  
				  }
				}
		 }
	}
	
	public void Insert_Cod(){
		
		String Cod_serv = null;
		int cod_serv = 0;
		
		String sql = "SELECT cod_serv FROM ORDEM_SERVICO";
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
				Cod_serv = result.getString("COD_SERV");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	cod_serv = Integer.valueOf(Cod_serv);   	
        	if(cod_serv <= 9){
        		cod_serv = Integer.valueOf(Cod_serv) + 1;
            	Field_Editavel_Cod_Servico.setText("000"+String.valueOf(cod_serv));
            }
            else if(cod_serv > 9 && cod_serv < 100){
            	cod_serv = Integer.valueOf(Cod_serv) + 1;
            	Field_Editavel_Cod_Servico.setText("00"+String.valueOf(cod_serv));
            }
            else if( cod_serv > 100 && cod_serv <= 1000){
            	cod_serv = Integer.valueOf(Cod_serv) + 1;
            	Field_Editavel_Cod_Servico.setText(String.valueOf(cod_serv));
            }
        
    	
	}
	
	private boolean Cad_Servico() {
		
		Servico_Add servico = new Servico_Add();
		DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_add_Prod_Serv.getModel();
		String Data = Label_Editavel_data.getText();
		String [] DataSeparada = Data.split("/");
		LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));
		 
		
		if(contador_Table == 1 ) {
			servico.setCod_Serv(Field_Editavel_Cod_Servico.getText());
			servico.setCliente(Combo_Nome_Cliente.getSelectedItem().toString());
			servico.setPlaca_Carro(Combo_Placa.getSelectedItem().toString());
			servico.setFuncionario(Combo_Funcionario.getSelectedItem().toString());
			servico.setData(Date.valueOf(dia));
			servico.setProduto(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 0)));
			servico.setValor_Produto(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 1)));
			servico.setQtd_Produto(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 2)));
			servico.setServico(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 3)));
			servico.setValor_servico(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 4)));
			servico.setValor_Total(Double.valueOf(field_editavel_total.getText().replace(",", ".")));
			servicoDAO.Insert(servico);
			JOptionPane.showMessageDialog(this, "Serviço cadastrado com sucesso! \n Verifique a tabela abaixo", "Sucesso", JOptionPane.WARNING_MESSAGE);
		}else if(contador_Table > 1) {
				while(contador_Table != 0) {
				servico.setCod_Serv(Field_Editavel_Cod_Servico.getText());
				servico.setCliente(Combo_Nome_Cliente.getSelectedItem().toString());
				servico.setPlaca_Carro(Combo_Placa.getSelectedItem().toString());
				servico.setFuncionario(Combo_Funcionario.getSelectedItem().toString());
				servico.setData(Date.valueOf(dia));
				servico.setProduto(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 0)));
				servico.setValor_Produto(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 1)));
				servico.setQtd_Produto(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 2)));
				servico.setServico(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 3)));
				servico.setValor_servico(String.valueOf(Table_add_Prod_Serv.getModel().getValueAt(0, 4)));
				servico.setValor_Total(Double.valueOf(field_editavel_total.getText().replace(",", ".")));
				servicoDAO.Insert(servico);
				tablemodel_Cadastrados.removeRow(0);
				contador_Table --;
				
			}
			JOptionPane.showMessageDialog(this, "Serviço cadastrado com sucesso! \n Verifique a tabela abaixo", "Sucesso", JOptionPane.WARNING_MESSAGE);
		}else if(contador_Table == 0) {
			erro();
			return false;
		}
		
		return true;
	}
	
	private void Limpa_tabela() {
			 DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_add_Prod_Serv.getModel();
			 int resposta = JOptionPane.showConfirmDialog(null, "Deseja as Excluir Informações da tabela ?", "Excluir", JOptionPane.YES_NO_OPTION);
			
			 if(resposta == JOptionPane.YES_OPTION){
				 tablemodel_Cadastrados.setRowCount(0);
				}
			 
			 contador_Table = 0;
			 field_editavel_total.setText("0.00");
			 Lib_Campos();
		 }
		
	
	
	private void Bloq_Campos(){
		Combo_Nome_Cliente.setEnabled(false);
		Combo_Placa.setEnabled(false);
		Combo_Funcionario.setEnabled(false);
	}
	private void Lib_Campos(){
		Combo_Nome_Cliente.setEnabled(true);
		Combo_Placa.setEnabled(true);
		Combo_Funcionario.setEnabled(true);
		Combo_Nome_Cliente.setSelectedItem("Seleciona");
		Combo_Placa.setSelectedItem("Seleciona");
		Combo_Funcionario.setSelectedItem("Seleciona");
		Combo_Produto.setSelectedItem("Seleciona");
		field_editavel_total.setText("0.00");
		Total = 0.00;
	}
	
	private void soma_valor_serv_prod(){
		
		Double produto = Double.valueOf(Field_Valor_Produto.getText().replace(",", "."));
		Double Qtd = Double.valueOf(Field_Quantidade.getText().replace(",", "."));
		Double servico = Double.valueOf(Field_Valor_serviço.getText().replace(",", "."));
		Total = Double.valueOf(field_editavel_total.getText().replace(",", "."));
		Total = Total + ((produto * Qtd ) + servico);
		System.out.println(Total);
		field_editavel_total.setText(String.format("%.2f", Double.parseDouble(String.valueOf(Total))));
		
	}
	
	
	private boolean Verifica(){
		
		if(Combo_Nome_Cliente.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione um Cliente valido", "Erro", JOptionPane.WARNING_MESSAGE);
			Combo_Nome_Cliente.requestFocus();
			return false;
		}
		if(Combo_Produto.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione um Produto valido", "Erro", JOptionPane.WARNING_MESSAGE);
			Combo_Produto.requestFocus();
			return false;
		}
		if(Combo_Placa.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione uma Placa valido", "Erro", JOptionPane.WARNING_MESSAGE);
			Combo_Placa.requestFocus();
			return false;
		}
		if(Combo_Funcionario.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione um Funcionario valido", "Erro", JOptionPane.WARNING_MESSAGE);
			Combo_Funcionario.requestFocus();
			return false;
		}
		if(textArea1.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Serviço", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			textArea1.requestFocus();
			return false;
		}
		if(Field_Valor_serviço.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Valor do Serviço", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Valor_serviço.requestFocus();
			return false;
		}
		return true;
	}
	
	private void Mostra_Valor_Produto(){
		
			String sql = "SELECT * FROM produtos where descricao = '" + Combo_Produto.getSelectedItem() +"'" ;
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()){
					Field_Valor_Produto.setText(result.getString("preco_venda"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			
			
		}
	}
	
	private void update_tabela() {

    	DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_add_Prod_Serv.getModel();
    	tablemodel_Cadastrados.setRowCount(contador_Table);
    	
    	
        	Object[] data = {
    				Combo_Produto.getSelectedItem(),
    				Field_Valor_Produto.getText(),
    				Field_Quantidade.getText(),
    				textArea1.getText(),
    				Field_Valor_serviço.getText()
    				
    		};
        	
    		tablemodel_Cadastrados.addRow(data);
    		contador_Table ++;
	}
	
	private void Mostrar_placa(){
		Combo_Placa.removeAllItems();
		Combo_Placa.addItem("Seleciona");	
		
		
			String sql = "SELECT * FROM placa_veiculos where cliente = '" + Combo_Nome_Cliente.getSelectedItem() +"'" ;
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()){
					Combo_Placa.addItem(result.getString("placa"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			
			
		}
	}
	
public void update_combo_funcionarios(){
		
		Combo_Funcionario.removeAllItems();
		Combo_Funcionario.addItem("Seleciona");	
		 
		 String sql = "SELECT * FROM funcionarios ORDER BY nome";
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()){
					Combo_Funcionario.addItem(result.getString("nome"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	
	public void Update_Combo_Produto(){
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
	
	public void Update_Combo_Cliente(){
		Table_servico_aberto.setSelectionBackground(Color.YELLOW);
        
		Combo_Nome_Cliente.removeAllItems();
		Combo_Nome_Cliente.addItem("Seleciona");	
		 
		 String sql = "SELECT * FROM clientes ORDER BY nome";
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()){
				Combo_Nome_Cliente.addItem(result.getString("Nome"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	private void Limpa_Dados() {
		
		textArea1.setText(" ");
		Field_Valor_serviço.setText(null);
		Field_Quantidade.setText("1");
		Field_Valor_Produto.setText("0.00");		
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
	
	

    // Variables declaration - do not modify                     
		private javax.swing.JButton Btn_Adicionar;
	    private javax.swing.JButton Btn_Busca_Senha;
	    private javax.swing.JButton Btn_Cancelar;
	    private javax.swing.JButton Btn_Editar;
	    private javax.swing.JButton Btn_Imprimir;
	    private javax.swing.JButton Btn_Remover;
	    private javax.swing.JButton Btn_Selecionar;
	    private javax.swing.JButton Btn_fazer_venda;
	    private javax.swing.JButton Btn_gerar;
	    private javax.swing.JButton Btn_Cancela_Busca;
	    private javax.swing.JComboBox<String> Combo_Funcionario;
	    private javax.swing.JComboBox<String> Combo_Nome_Cliente;
	    private javax.swing.JComboBox<String> Combo_Produto;
	    private javax.swing.JFormattedTextField Field_Cod_aberto;
	    private javax.swing.JFormattedTextField Field_Editavel_Cod_Servico;
	    private javax.swing.JFormattedTextField Field_Quantidade;
	    private java.awt.TextField Field_Valor_Produto;
	    private javax.swing.JFormattedTextField Field_Valor_serviço;
	    private javax.swing.JLabel Label_Cliente;
	    private javax.swing.JLabel Label_Cod_Servico;
	    private javax.swing.JLabel Label_Data;
	    private javax.swing.JLabel Label_Editavel_data;
	    private javax.swing.JLabel Label_Placa;
	    private javax.swing.JLabel Label_Produto;
	    private javax.swing.JLabel Label_Quantidade;
	    private javax.swing.JLabel Label_Selecione_Linha_ou_Cod;
	    private javax.swing.JLabel Label_Serviço;
	    private javax.swing.JLabel Label_Titulo_Ordem;
	    private javax.swing.JLabel Label_Titulo_ordem_Aberto;
	    private javax.swing.JLabel Label_funcionario;
	    private javax.swing.JLabel Label_valor;
	    private javax.swing.JLabel Label_valor_Produto;
	    private javax.swing.JLabel Label_valor_Serviço;
	    private javax.swing.JScrollPane ScrollPane_Serv_abert;
	    private javax.swing.JScrollPane ScrollPane_add_Produto_Servico;
	    private javax.swing.JTable Table_add_Prod_Serv;
	    private javax.swing.JTable Table_servico_aberto;
	    private javax.swing.JFormattedTextField field_editavel_total;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator3;
	    private javax.swing.JFormattedTextField  textArea1;
	    private javax.swing.JComboBox<String> Combo_Placa;
	    private ServicoDAO servicoDAO;
    // End of variables declaration   
	
}

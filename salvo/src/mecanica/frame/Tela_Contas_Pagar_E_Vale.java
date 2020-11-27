package mecanica.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat.Field;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Boleto_Add;
import mecanicaDAO.Boleto_Pago_add;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Funcionario_add;
import mecanicaDAO.Vale_add;
import mecanicaDAOBoletos.BoletosDAO;
import mecanicaDAOBoletosPagos.Boletos_pagoDAO;
import mecanicaDAOVale.ValeDAO;
import sun.text.resources.cldr.FormatData;

public class Tela_Contas_Pagar_E_Vale extends JPanel {
	
	private Connection connection;
	int num = 0;

	
	public Tela_Contas_Pagar_E_Vale() throws SQLException {
        initComponents();
        boletoDAO = new BoletosDAO();
        boletoPagoDAO = new Boletos_pagoDAO();
        valeDAO = new ValeDAO();
        connection = ConnectionDAO.getConnection();
    }
	
	
	  private void initComponents() {

	        Label_Titulo_Controle_Boleto = new javax.swing.JLabel("Controle de Boletos");
	        jSeparator1 = new javax.swing.JSeparator();
	        Label_descricao = new javax.swing.JLabel("Descrição");
	        Field_Descricao = new javax.swing.JFormattedTextField();
	        Label_Valor = new javax.swing.JLabel("Valor");
	        Field_valor = new javax.swing.JFormattedTextField();;
	        Label_Data_Vencimento = new javax.swing.JLabel("Data Vencimento");
	        Field_Data_Vencimento = new javax.swing.JFormattedTextField();;
	        Label_Num_Parcelas = new javax.swing.JLabel("Numeros de Parcelas");
	        Field_Num_Parcelas = new javax.swing.JFormattedTextField("1");;
	        Label_Titulo_Pago = new javax.swing.JLabel("Boletos Cadastrados      ");//Deixar com espaços
	        jSeparator2 = new javax.swing.JSeparator();
	        ScrollPane_Boletos = new javax.swing.JScrollPane();
	        Table_Boleto = new javax.swing.JTable();
	        jSeparator3 = new javax.swing.JSeparator();
	        Label_SubTitulo_Boleto = new javax.swing.JLabel();
	        Label_Titulo_Vale = new javax.swing.JLabel("Vale");
	        ScrollPane_Vales = new javax.swing.JScrollPane();
	        Table_Vales = new javax.swing.JTable();
	        Label_Inf_vale = new javax.swing.JLabel("Informações sobre quem pegou vale : ");
	        Label_Nome_vale = new javax.swing.JLabel("Nome");
	        Label_Valor_Vale = new javax.swing.JLabel("Valor");
	        Field_Vale_Valor = new javax.swing.JFormattedTextField();
	        Label_Data_Vale = new javax.swing.JLabel("Data");
	        Field_Vale_Data = new javax.swing.JFormattedTextField();
	        Btn_Salvar_Vale = new javax.swing.JButton("Salvar");
	        Btn_Cancelar_Vale = new javax.swing.JButton("Cancelar");
	        Btn_Zerar_Vale = new javax.swing.JButton("Recomeçar");
	        Btn_Cancelar_Boleto = new javax.swing.JButton("Cancelar");
	        Btn_Salvar_Boleto = new javax.swing.JButton("Salvar");
	        Label_Boleto_Pago = new javax.swing.JLabel("Marcar Boleto como pago: ");
	        Btn_Boleto_Pago = new javax.swing.JButton();
	        Label_Boleto_Cancelado = new javax.swing.JLabel("Cancelar Boleto: ");
	        Btn_Boleto_Cancelado = new javax.swing.JButton();
	        Label_total_Pagar = new javax.swing.JLabel("Total a Pagar : ");
	        Label_total_Editavel_Boletos = new javax.swing.JLabel("0.00");
	        Combo_Nome = new javax.swing.JComboBox<>();
	        


	        Label_Titulo_Controle_Boleto.setFont(new java.awt.Font("Arial Black", 0, 12));
	        Field_Num_Parcelas.setText("1");	     
	        Label_Titulo_Pago.setFont(new java.awt.Font("Arial Black", 0, 12));
	        Label_SubTitulo_Boleto.setFont(new java.awt.Font("Arial Black", 0, 11));
	        Label_Titulo_Vale.setFont(new java.awt.Font("Arial Black", 0, 12));
	        Label_Inf_vale.setFont(new java.awt.Font("Arial Black", 0, 11));
	        Label_Boleto_Pago.setFont(new java.awt.Font("Arial", 0, 15));
	        Label_Boleto_Cancelado.setFont(new java.awt.Font("Arial", 0, 15));
	        Label_total_Pagar.setFont(new java.awt.Font("Arial", 0, 15));
	        Label_total_Editavel_Boletos.setFont(new java.awt.Font("Arial", 0, 18));
	        
	        
	       Btn_Salvar_Boleto.setBackground(Color.WHITE);
	       Btn_Salvar_Boleto.setToolTipText("Salvar");
	       ImageIcon image_Salvar = new ImageIcon(getClass().getResource("/tick.png"));
	       Btn_Salvar_Boleto.setIcon(image_Salvar);
	       
	       Btn_Cancelar_Boleto.setBackground(Color.WHITE);
	       Btn_Cancelar_Boleto.setToolTipText("Cancelar");
	       ImageIcon image_Cancel = new ImageIcon(getClass().getResource("/close.png"));
	       Btn_Cancelar_Boleto.setIcon(image_Cancel);
	       
	       Btn_Salvar_Vale.setBackground(Color.WHITE);
	       Btn_Salvar_Vale.setToolTipText("Salvar");
	       Btn_Salvar_Vale.setIcon(image_Salvar);
	       
	       Btn_Cancelar_Vale.setBackground(Color.WHITE);
	       Btn_Cancelar_Vale.setToolTipText("Cancelar");
	       Btn_Cancelar_Vale.setIcon(image_Cancel);

	       Btn_Boleto_Cancelado.setBackground(Color.WHITE);
	       Btn_Boleto_Cancelado.setToolTipText("Cancelar Boleto");
	       ImageIcon image_boleto_nao_pago = new ImageIcon(getClass().getResource("/no-money.png"));
	       Btn_Boleto_Cancelado.setIcon(image_boleto_nao_pago);
	       
	       Btn_Boleto_Pago.setBackground(Color.WHITE);
	       ImageIcon image_boleto_pago = new ImageIcon(getClass().getResource("/accepted.png"));
	       Btn_Boleto_Pago.setToolTipText("Boleto Pago");
	       Btn_Boleto_Pago.setIcon(image_boleto_pago);
	       
	       Btn_Zerar_Vale.setBackground(Color.WHITE);
	       Btn_Zerar_Vale.setToolTipText("Zerar Vales");
	       ImageIcon image_zerar = new ImageIcon(getClass().getResource("/Zerar_Boleto.png"));
	       Btn_Zerar_Vale.setIcon(image_zerar);
	       
	       
	       //Coloca as especificações nos campos da tabela
	     	Vector<String> columnBoleto = new Vector<String>();
	     	columnBoleto.add("Descrição");
	     	columnBoleto.add("Data Vencimento");
	     	columnBoleto.add("Valor");
			Vector<? extends Vector> vector = new Vector();
			Table_Boleto = new JTable(vector,columnBoleto);
			ScrollPane_Boletos = new JScrollPane(Table_Boleto);
			
			//Coloca as especificações nos campos da tabela
	     	Vector<String> columnVales = new Vector<String>();
	     	columnVales.add("Nome");
	     	columnVales.add("Data");
	     	columnVales.add("Valor");
			Vector<? extends Vector> vector1 = new Vector();
			Table_Vales = new JTable(vector1, columnVales);
			ScrollPane_Vales = new JScrollPane(Table_Vales);
	       
	        try {
	            Field_Data_Vencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        } try {
	            Field_Vale_Data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
	        } catch (java.text.ParseException ex) {
	            ex.printStackTrace();
	        }
	        
	        
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                            .addContainerGap()
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addComponent(Label_Titulo_Controle_Boleto)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                    .addComponent(jSeparator1))
	                                .addGroup(layout.createSequentialGroup()
	                                    .addComponent(Label_Titulo_Vale)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                        .addGroup(layout.createSequentialGroup()
	                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                                .addGroup(layout.createSequentialGroup()
	                                                    .addComponent(Btn_Cancelar_Vale)
	                                                    .addGap(18, 18, 18)
	                                                    .addComponent(Btn_Salvar_Vale)
	                                                    .addGap(102, 102, 102))
	                                                .addGroup(layout.createSequentialGroup()
	                                                    .addComponent(Label_Nome_vale)
	                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                                        .addComponent(Label_Inf_vale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                                        .addComponent(Combo_Nome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                                                .addGroup(layout.createSequentialGroup()
	                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                                            .addComponent(Label_Data_Vale)
	                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
	                                                        .addGroup(layout.createSequentialGroup()
	                                                            .addComponent(Label_Valor_Vale)
	                                                            .addGap(18, 18, 18)))
	                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                                        .addComponent(Field_Vale_Valor, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
	                                                        .addComponent(Field_Vale_Data))))
	                                            .addGap(18, 18, Short.MAX_VALUE)
	                                            .addComponent(Btn_Zerar_Vale)
	                                            .addGap(18, 18, 18)
	                                            .addComponent(ScrollPane_Vales, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                        .addComponent(jSeparator3)))))
	                        .addGroup(layout.createSequentialGroup()
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                        .addGroup(layout.createSequentialGroup()
	                                            .addGap(13, 13, 13)
	                                            .addComponent(Label_Titulo_Pago))
	                                        .addGroup(layout.createSequentialGroup()
	                                            .addGap(23, 23, 23)
	                                            .addComponent(Label_total_Pagar)
	                                            .addGap(18, 18, 18)
	                                            .addComponent(Label_total_Editavel_Boletos)))
	                                    .addGap(18, 18, 18)
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                            .addComponent(Label_Boleto_Cancelado)
	                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                            .addComponent(Btn_Boleto_Cancelado, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addComponent(Label_Boleto_Pago)
	                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                                .addComponent(Btn_Boleto_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                            .addComponent(Label_SubTitulo_Boleto)))
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
	                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                        .addComponent(Label_descricao, javax.swing.GroupLayout.Alignment.TRAILING)
	                                        .addComponent(Label_Valor, javax.swing.GroupLayout.Alignment.TRAILING)
	                                        .addComponent(Label_Data_Vencimento, javax.swing.GroupLayout.Alignment.TRAILING)
	                                        .addComponent(Label_Num_Parcelas, javax.swing.GroupLayout.Alignment.TRAILING))
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                            .addGroup(layout.createSequentialGroup()
	                                                .addComponent(Field_Num_Parcelas, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
	                                                .addGap(62, 62, 62)
	                                                .addComponent(Btn_Cancelar_Boleto)
	                                                .addGap(18, 18, 18)
	                                                .addComponent(Btn_Salvar_Boleto))
	                                            .addComponent(Field_Descricao))
	                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                            .addComponent(Field_Data_Vencimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
	                                            .addComponent(Field_valor, javax.swing.GroupLayout.Alignment.LEADING)))
	                                    .addGap(58, 58, 58)))
	                            .addComponent(ScrollPane_Boletos, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addContainerGap())
	            );
	            layout.setVerticalGroup(
	                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addContainerGap()
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(Label_Titulo_Controle_Boleto))
	                    .addGap(18, 18, 18)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(Label_descricao)
	                                .addComponent(Field_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGap(10, 10, 10)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(Label_Valor)
	                                .addComponent(Field_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGap(10, 10, 10)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(Label_Data_Vencimento)
	                                .addComponent(Field_Data_Vencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGap(10, 10, 10)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                        .addComponent(Label_Num_Parcelas)
	                                        .addComponent(Field_Num_Parcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                    .addGap(22, 22, 22)
	                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                        .addComponent(Label_Titulo_Pago)
	                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(Btn_Cancelar_Boleto)
	                                    .addComponent(Btn_Salvar_Boleto)))
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(Label_SubTitulo_Boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(Btn_Boleto_Pago)
	                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                    .addComponent(Label_Boleto_Pago)
	                                    .addComponent(Label_total_Pagar)
	                                    .addComponent(Label_total_Editavel_Boletos)))
	                            .addGap(18, 18, 18)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addComponent(Btn_Boleto_Cancelado)
	                                .addComponent(Label_Boleto_Cancelado)))
	                        .addComponent(ScrollPane_Boletos, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGap(18, 18, 18)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(Label_Titulo_Vale))
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(26, 26, 26)
	                            .addComponent(Label_Inf_vale)
	                            .addGap(18, 18, 18)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(Label_Nome_vale)
	                                .addComponent(Combo_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGap(10, 10, 10)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(Label_Valor_Vale)
	                                .addComponent(Field_Vale_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGap(10, 10, 10)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(Label_Data_Vale)
	                                .addComponent(Field_Vale_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addGap(30, 30, 30)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                                .addComponent(Btn_Cancelar_Vale)
	                                .addComponent(Btn_Salvar_Vale)
	                                .addComponent(Btn_Zerar_Vale)))
	                        .addGroup(layout.createSequentialGroup()
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(ScrollPane_Vales, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
	                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            );
	            
	        //Salvar boleto   
	        Btn_Salvar_Boleto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						if(Verifica()){
							if(Integer.parseInt(Field_Num_Parcelas.getText()) > 1){
								num = Integer.parseInt(Field_Num_Parcelas.getText());
								while(num >= 0){
									if(Verifica_data()){
										Field_Num_Parcelas.setEditable(false);
										Field_Descricao.setEditable(false);
										Field_Num_Parcelas.setText(  String.valueOf(num) );
										Cad_Boleto();
										Field_Data_Vencimento.setText(null);
										num --;
									}
								}
							}
							Cad_Boleto();
							Limpa_Campos();
							Field_Num_Parcelas.setEditable(true);
							Field_Descricao.setEditable(true);
						}
			}
		});    
	        
	        //Cancelar Boleto
	        Btn_Cancelar_Boleto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Limpa_Campos();
					
				}
			});
	        
	        //Cancelar Vale
	        Btn_Cancelar_Vale.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Limpa_Campos_Vale();
					
				}
			});

	        //Cancelar boleto
	        Btn_Boleto_Cancelado.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Verificar_linha_boleto_delete();
				}
			});
	        
	        //Marcar boleto como pago
	        Btn_Boleto_Pago.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Verifica_linha_boleto_pago();
					
				}
			});
	        
	        //---------------Botoes do vale--------------------
	        
	        //Cancelar Vale
	        Btn_Cancelar_Vale.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Limpa_Campos_Vale();
					
				}
			});

	        //Salvar Vale
	        Btn_Salvar_Vale.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				if(Verifica_Vale()){	
					cad_vale();
					Limpa_Campos_Vale();
					update_Table_Vale();
				}
				}
			});

	        //Zerar vale
	        Btn_Zerar_Vale.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Verifica_Cancelamento_Vales()){
						String sql = "delete from vale";
						 try {
								Statement statement = connection.createStatement();
								ResultSet result = statement.executeQuery(sql);
								while(result.next()){
								}
							} catch (SQLException w) {
								w.printStackTrace();
							}
					}
					update_Table_Vale();
					
				}
			});
	        
	    }
	  
	  private boolean Verifica_Cancelamento_Vales(){
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o/os Vales?", "Excluir", JOptionPane.YES_NO_OPTION);
			 if(resposta == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(this, "Vales Zerados com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
				return true;
				 
				}
			return false;
		}
	  
	  private boolean Verifica_Vale(){
		  
		  if(Field_Vale_Valor.getText().trim().isEmpty()){
				JOptionPane.showMessageDialog(this, "Por favor, preencha o Valor do Vale", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Vale_Valor.requestFocus();
				return false;
		  }
		  if(Field_Vale_Data.equals("  /  /    ") || Field_Vale_Data.getText().trim().isEmpty()){
				JOptionPane.showMessageDialog(this, "Por favor, preencha a Data do Vale", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Vale_Data.requestFocus();
				return false;
		  }
		  if(Combo_Nome.getSelectedItem().equals("Seleciona")){
			  	JOptionPane.showMessageDialog(this, "Por favor, selecione um Funcionário valido", "Erro", JOptionPane.WARNING_MESSAGE);
				Combo_Nome.requestFocus();
				return false;
		  }
		  
		  return true;
		  
	  }
	  
	  public void Update_combo_vale(){
		  Combo_Nome.removeAllItems();
		  Combo_Nome.addItem("Seleciona");
		  
		  String sql = "Select * from funcionarios where bloquear = '1'";
		  
		  try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()){
				Combo_Nome.addItem(result.getString("NOME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  
	  }
	  
	  private boolean Verifica_data(){
		  if(Field_Data_Vencimento.getText().trim().isEmpty()){
			 JOptionPane.showMessageDialog(this, "Boleto não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
			 Field_Data_Vencimento.requestFocus();
			 return false;
		  }
		  return true;
	  }
	  
	  private void cad_vale(){
		  
		  String Data = Field_Vale_Data.getText();
		  String [] DataSeparada = Data.split("/");
		  LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));
			 
		  Vale_add vale = new Vale_add();
		  vale.setNome(Combo_Nome.getSelectedItem().toString());
		  vale.setData(Date.valueOf(dia));
		  vale.setValor(Field_Vale_Valor.getText());
		  valeDAO.insert(vale);
		  
	  }
	  
	  private void Verifica_linha_boleto_pago(){
		  
		  int Numero_linha = Table_Boleto.getSelectedRow();
		  if(Numero_linha == -1 ){
			  JOptionPane.showMessageDialog(this, "Boleto não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
		  }else{
			 int resposta = JOptionPane.showConfirmDialog(null, "Deseja marcar esse boleto como pago?", "Pago", JOptionPane.YES_NO_OPTION);
			  
			 if(resposta == JOptionPane.YES_OPTION){
			  if(Numero_linha >= 0){
				  Sql_Boleto_pago();
				  update_Table();
				  soma_boletos();
			  }
			 }
		  }
	  }
	  
	  private void Sql_Boleto_pago(){
		  int Numero_linha = Table_Boleto.getSelectedRow();
			  String Descricao = (String)Table_Boleto.getModel().getValueAt(Numero_linha, 0);
			  Date Data = (Date) Table_Boleto.getModel().getValueAt(Numero_linha, 1);
			  Double Valor = (Double) Table_Boleto.getModel().getValueAt(Numero_linha, 2);
			  
			  Boleto_Pago_add boleto = new Boleto_Pago_add();
			  boleto.setDescricao(Descricao);
			  boleto.setData_Vencimento(String.valueOf(Data));
			  boleto.setValor(Valor);
			  boletoPagoDAO.insert(boleto);
			  Sql_Delete();  
		  
		  
	  }
	  
	  private void Verificar_linha_boleto_delete(){
		  
		 int Numero_linha = Table_Boleto.getSelectedRow();
		 if(Numero_linha == -1) {
			  JOptionPane.showMessageDialog(this, "Boleto não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
		 }else{
			 int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o boleto?", "Excluir", JOptionPane.YES_NO_OPTION);
			 if(resposta == JOptionPane.YES_OPTION){
				  if(Numero_linha >= 0){
					  Sql_Delete();
					  update_Table();
					  soma_boletos();
				  }
				}
		 }
		 
		  
	  }
	  
	  private void Sql_Delete(){
		  int Numero_linha = Table_Boleto.getSelectedRow();
		  String Descricao = (String)Table_Boleto.getModel().getValueAt(Numero_linha, 0);
		  Date Data = (Date) Table_Boleto.getModel().getValueAt(Numero_linha, 1);
		  Double Valor = (Double) Table_Boleto.getModel().getValueAt(Numero_linha, 2);
		  //System.out.println(Data);
		  
		  String sql = "delete from boleto where descricao = '" + Descricao + "' and Data_vencimento = '" + Data + "' and "
		  		+ " valor = '" + Valor + "'";
		  
		  try {
	    		Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 JOptionPane.showMessageDialog(this, "Boleto " + Descricao +" deletado da Tabela", "Excluído", JOptionPane.WARNING_MESSAGE);

	  }
	  
	  private boolean Verifica() {
		 
		  
		  if(Field_Descricao.getText().trim().isEmpty()){
				JOptionPane.showMessageDialog(this, "Por favor, preencha a Descrição do Boleto", "Campo vazio", JOptionPane.WARNING_MESSAGE);
				Field_Descricao.requestFocus();
				return false;
		  }
		  if(Field_Data_Vencimento.getText().trim().isEmpty()){
			  JOptionPane.showMessageDialog(this, "Por favor, preencha a Data de Vencimento ", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			 Field_Data_Vencimento.requestFocus();
			 return false;
		  }
		  if(Field_Num_Parcelas.getText().trim().isEmpty()){
			  JOptionPane.showMessageDialog(this, "Por favor, preencha a Parcela", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			  Field_Num_Parcelas.requestFocus();
			  return false;
		  }
		  if(Field_valor.getText().trim().isEmpty()){
			  JOptionPane.showMessageDialog(this, "Por favor, preencha o Valor", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			  Field_valor.requestFocus();
			  return false;
		  }
		  
		  
		  return true;
	  }
	  
	  private void Cad_Boleto() {
		  
		 Double Valor = 0.0;
		 String Valor_Edt = Field_valor.getText().replace(",", ".");
		 Valor = Double.valueOf(Valor_Edt);
		 Valor_Edt = String.format("%.2f", Double.parseDouble(String.valueOf(Valor))).replace(",", ".");
		 		 
		 String Data = Field_Data_Vencimento.getText();
		 String [] DataSeparada = Data.split("/");
		 LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));
		  		 
		 Boleto_Add boleto = new Boleto_Add();
		 boleto.setDescricao(Field_Descricao.getText());
		 boleto.setValor(Double.valueOf(Valor_Edt));
		 boleto.setData_Vencimento(Date.valueOf(dia));
		 boleto.setNum_Parcelas(Field_Num_Parcelas.getText());
		 boletoDAO.Insert(boleto);
		 
		 update_Table();
		 soma_boletos();
	  }
	  
	  private void Limpa_Campos_Vale() {
		  
		  Field_Vale_Valor.setText(null);
		  Combo_Nome.setSelectedItem("Seleciona");
		  
	  }
	  
	  private void Limpa_Campos() {
		  
		  Field_Descricao.setText(null);
		  Field_Num_Parcelas.setText("1");
		  Field_valor.setText(null);
		  data();
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
			
			Field_Vale_Data.setText(data);
			Field_Data_Vencimento.setText(data);
			data_Atual = data;
	  }
	
	  public void update_Table(){
		  
		  DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_Boleto.getModel();
	    	tablemodel_Cadastrados.setRowCount(0);
	    	
	    	for(Boleto_Add boleto : boletoDAO.getAll()){
	        	Object[] data = {
	    				boleto.getDescricao(),
	    				boleto.getData_Vencimento(),
	    				boleto.getValor()
	    		};
	        	
	    		tablemodel_Cadastrados.addRow(data);
	    		
	        	}
		  
	  }
	  
	  public void update_Table_Vale(){
		  DefaultTableModel tablemodel_vale = (DefaultTableModel) Table_Vales.getModel();
	    	tablemodel_vale.setRowCount(0);
	    	
	    	for(Vale_add vale : valeDAO.getAll()){
	        	Object[] vale1 = {
	    				vale.getNome(),
	    				vale.getData(),
	    				vale.getValor()
	    		};
	        	
	        	tablemodel_vale.addRow(vale1);
	    		
	        	}
	  }
	  
	  public void soma_boletos(){
		  
		  String sql = "select sum (valor) as total from boleto";
		  
		  try {
	    		Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				result.next();
				 Label_total_Editavel_Boletos.setText(String.valueOf(result.getFloat("TOTAL")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  
		  
	  }
	  
	  
	 // Variables declaration - do not modify                     
	  	private javax.swing.JButton Btn_Boleto_Cancelado;
	    private javax.swing.JButton Btn_Boleto_Pago;
	    private javax.swing.JButton Btn_Cancelar_Boleto;
	    private javax.swing.JButton Btn_Cancelar_Vale;
	    private javax.swing.JButton Btn_Salvar_Boleto;
	    private javax.swing.JButton Btn_Salvar_Vale;
	    private javax.swing.JButton Btn_Zerar_Vale;
	    private javax.swing.JComboBox<String> Combo_Nome;
	    private javax.swing.JFormattedTextField Field_Data_Vencimento;
	    private javax.swing.JFormattedTextField Field_Descricao;
	    private javax.swing.JFormattedTextField Field_Num_Parcelas;
	    private javax.swing.JFormattedTextField Field_Vale_Data;
	    private javax.swing.JFormattedTextField Field_Vale_Valor;
	    private javax.swing.JFormattedTextField Field_valor;
	    private javax.swing.JLabel Label_Boleto_Cancelado;
	    private javax.swing.JLabel Label_Boleto_Pago;
	    private javax.swing.JLabel Label_Data_Vale;
	    private javax.swing.JLabel Label_Data_Vencimento;
	    private javax.swing.JLabel Label_Inf_vale;
	    private javax.swing.JLabel Label_Nome_vale;
	    private javax.swing.JLabel Label_Num_Parcelas;
	    private javax.swing.JLabel Label_SubTitulo_Boleto;
	    private javax.swing.JLabel Label_Titulo_Controle_Boleto;
	    private javax.swing.JLabel Label_Titulo_Pago;
	    private javax.swing.JLabel Label_Titulo_Vale;
	    private javax.swing.JLabel Label_Valor;
	    private javax.swing.JLabel Label_Valor_Vale;
	    private javax.swing.JLabel Label_descricao;
	    private javax.swing.JLabel Label_total_Editavel_Boletos;
	    private javax.swing.JLabel Label_total_Pagar;
	    private javax.swing.JScrollPane ScrollPane_Boletos;
	    private javax.swing.JScrollPane ScrollPane_Vales;
	    private javax.swing.JTable Table_Boleto;
	    private javax.swing.JTable Table_Vales;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
	    private javax.swing.JSeparator jSeparator3;
	    private String data_Atual;
	    private BoletosDAO boletoDAO;
	    private Boletos_pagoDAO boletoPagoDAO;
	    private ValeDAO valeDAO;
    // End of variables declaration             
	
}

package mecanica.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Agendamento_add;
import mecanicaDAOAgendamento.AgendamentoDAO;
import sun.security.util.Length;

public class Tela_Agendamento extends JPanel {
	
	private Connection connection;

	
	public Tela_Agendamento() throws SQLException {
        initComponents();
        agendamentoDAO = new AgendamentoDAO();
        connection = ConnectionDAO.getConnection();
    }                        
    private void initComponents() {

        Label_titulo_Agendamento = new javax.swing.JLabel("Agendamento");
        jSeparator1 = new javax.swing.JSeparator();
        Label_Placa = new javax.swing.JLabel("Placa do Veiculo");
        Field_Placa_Veiculo = new java.awt.TextField();
        Label_Nome = new javax.swing.JLabel("Nome ");
        Field_Nome_Pessoa = new java.awt.TextField();
        Label_Data = new javax.swing.JLabel("Data");
        Field_Data = new javax.swing.JFormattedTextField();
        Label_Data_Semana = new javax.swing.JLabel("Dia da Semana :");
        Radio_Segunda = new  javax.swing.JCheckBox("Segunda - Feira");
        Radio_terça = new javax.swing.JCheckBox("Terça - Feira");
        Radio_Quarta = new javax.swing.JCheckBox("Quarta - Feira");
        Radio_quinta = new javax.swing.JCheckBox("Quinta - Feira");
        Radio_sexta = new javax.swing.JCheckBox("Sexta - Feira");
        Radio_sabado = new javax.swing.JCheckBox("Sabádo");
        Radio_domingo = new javax.swing.JCheckBox("Domingo");
        Btn_Cancelar = new javax.swing.JButton("Cancelar");
        Btn_Salvar = new javax.swing.JButton("Salvar");
        Scroll_Agendamento = new javax.swing.JScrollPane();
        Table_Agendamento = new javax.swing.JTable();
        Label_Seleciona_Linha = new javax.swing.JLabel("Selecione uma linha e clique no botao para ver as informações");
        Btn_informações = new javax.swing.JButton("Serviço");
        Label_Servico = new javax.swing.JLabel("Serviço");
        Field_servico = new javax.swing.JFormattedTextField();
        Label_Edita_serviço = new javax.swing.JLabel("Serviço");
        Label_editavel_nome = new javax.swing.JLabel("Cliente");
        Label_data_editavel = new javax.swing.JLabel("Data");
        Label_Dia_editavel = new javax.swing.JLabel("Dia da Semana");
        Btn_excluir = new javax.swing.JButton("Excluir");
        Label_informacoes = new javax.swing.JLabel("Informações");
        jSeparator2 = new javax.swing.JSeparator();
        Btn_Gerar_dia = new javax.swing.JButton("Gerar Dia");

        Label_titulo_Agendamento.setFont(new java.awt.Font("Arial Black", 0, 11));
        Label_informacoes.setFont(new java.awt.Font("Arial Black", 0, 11));
        
        Btn_Cancelar.setBackground(Color.WHITE);
        Btn_Cancelar.setToolTipText("Cancelar");
        ImageIcon image_Cancel = new ImageIcon(getClass().getResource("/close.png"));
        Btn_Cancelar.setIcon(image_Cancel);
        
        Btn_Salvar.setBackground(Color.WHITE);
        Btn_Salvar.setToolTipText("Salvar");
        ImageIcon image_Salvar = new ImageIcon(getClass().getResource("/tick.png"));
        Btn_Salvar.setIcon(image_Salvar);
        
        Btn_excluir.setBackground(Color.WHITE);
        Btn_excluir.setToolTipText("Excluir");
        ImageIcon image_Excluir = new ImageIcon(getClass().getResource("/delete.png"));
        Btn_excluir.setIcon(image_Excluir);
        
        Btn_informações.setBackground(Color.WHITE);
        Btn_informações.setToolTipText("Mostrar Informações do Serviço");
        ImageIcon image_Informacoes= new ImageIcon(getClass().getResource("/project.png"));
        Btn_informações.setIcon(image_Informacoes);
        
        Btn_Gerar_dia.setBackground(Color.WHITE);
        Btn_Gerar_dia.setToolTipText("Gerar dia da semana");
        ImageIcon image_Dia = new ImageIcon(getClass().getResource("/tax.png"));
        Btn_Gerar_dia.setIcon(image_Dia);
        
        Radio_Segunda.setEnabled(false);
        Radio_terça.setEnabled(false);
        Radio_Quarta.setEnabled(false);
        Radio_quinta.setEnabled(false);
        Radio_sexta.setEnabled(false);
        Radio_sabado.setEnabled(false);
        Radio_domingo.setEnabled(false);
        
        ButtonGroup Btn_Group = new ButtonGroup();
        Btn_Group.add(Radio_Segunda);
        Btn_Group.add(Radio_terça);
        Btn_Group.add(Radio_Quarta);
        Btn_Group.add(Radio_quinta);
        Btn_Group.add(Radio_sexta);
        Btn_Group.add(Radio_sabado);
        Btn_Group.add(Radio_domingo);
        
        Vector<String> columnNames = new Vector<String>();
		columnNames.add("Placa");
		columnNames.add("Nome");
		columnNames.add("Data");
		columnNames.add("Servico");
		Vector<? extends Vector> vector = new Vector();
		Table_Agendamento = new JTable(vector,columnNames);
		Scroll_Agendamento= new JScrollPane(Table_Agendamento);
       
		try {
            Field_Data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
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
                            .addComponent(Label_Data_Semana)
                            .addComponent(Label_titulo_Agendamento)
                            .addComponent(Label_Placa)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Label_Data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Label_Nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Label_Servico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Field_servico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Radio_domingo)
                                            .addComponent(Radio_sabado)
                                            .addComponent(Radio_sexta)
                                            .addComponent(Radio_Segunda)
                                            .addComponent(Radio_terça)
                                            .addComponent(Radio_quinta)
                                            .addComponent(Radio_Quarta)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Btn_Cancelar)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_Salvar)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_excluir))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Field_Nome_Pessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(Field_Placa_Veiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(Field_Data, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Btn_Gerar_dia)))
                                        .addGap(0, 248, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Scroll_Agendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label_Seleciona_Linha)
                                    .addComponent(Btn_informações))
                                .addGap(99, 99, 99))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_Dia_editavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_data_editavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_editavel_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_Edita_serviço, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_informacoes)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_titulo_Agendamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_Placa)
                            .addComponent(Field_Placa_Veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_Nome)
                            .addComponent(Field_Nome_Pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_Data)
                            .addComponent(Field_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Gerar_dia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Data_Semana)
                            .addComponent(Radio_Segunda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Radio_terça)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Radio_Quarta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Radio_quinta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Radio_sexta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Radio_sabado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Radio_domingo)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_Servico)
                            .addComponent(Field_servico, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Scroll_Agendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Btn_Cancelar)
                        .addComponent(Btn_Salvar)
                        .addComponent(Btn_excluir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Seleciona_Linha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_informações)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_informacoes)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_editavel_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_data_editavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Dia_editavel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Edita_serviço, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
       //funcao de salvar
       Btn_Salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Editar == 0 && Verifica()) {
						Cad_Agendamento();
						data();
						update_tabela();
				}
				
				if(Editar == 1 && Verifica_update()) {
					if(Verifica_update()){
						Update_Agendamento();
						Field_Placa_Veiculo.setEnabled(true);
						Editar = 0;
						update_tabela();
						Limpa_dados();
						data();
					}
					
				}
				
			}
		});
        
       //Funcao de gerar dia
       Btn_Gerar_dia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String data = Field_Data.getText();
				String result;
				
				try {
					java.util.Date date = formatter.parse(data);
					data = String.valueOf(date);
				} catch (Exception e2) {
					
				}
				result = data.substring(0,3);
				if(result.equals("Mon")) Radio_Segunda.setSelected(true);
				if(result.equals("Tue")) Radio_terça.setSelected(true);
				if(result.equals("Wed")) Radio_Quarta.setSelected(true);
				if(result.equals("Thu")) Radio_quinta.setSelected(true);
				if(result.equals("Fri")) Radio_sexta.setSelected(true);
				if(result.equals("Sat")) Radio_sabado.setSelected(true);
				if(result.equals("Sun")) Radio_domingo.setSelected(true);
				
			}

			
		});
        
       //Funcao do liberar para editar
       Btn_excluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Verifica_Delete()){
					SQL_Delete();
					update_tabela();
					Editar = 0;
				}
				
			}
		});
        
        //Funcao de preencher campos 
       Btn_informações.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			preenche_campos();	
			Editar =1;
			Field_Placa_Veiculo.setEnabled(false);
		}
	});
    
       //Funcao de cancelar Cadastro
       Btn_Cancelar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar o agendamento", "Cadastro de Agendamentos", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				Limpa_dados();
				Editar = 0;
				Field_Placa_Veiculo.setEnabled(true);
			}
			
		}
	});
	
    };
	
	private void SQL_Delete(){
		
	      int Numero_linha = Table_Agendamento.getSelectedRow();
		  String placa = (String)Table_Agendamento.getModel().getValueAt(Numero_linha, 0);
		  Date Data = (Date) Table_Agendamento.getModel().getValueAt(Numero_linha, 2);
		 
		  
		  String sql = "delete from agendamentos where placa = '" + placa + "' and Data_agenda = '" + Data + "'";
		  		
		  
		  try {
	    		Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 JOptionPane.showMessageDialog(this, "Agendamento da placa : "  + placa + " foi deletado da Tabela", "Excluído", JOptionPane.WARNING_MESSAGE);
			 
	}
	
	private boolean Verifica_Delete(){
		 int Numero_linha = Table_Agendamento.getSelectedRow();
		 if(Numero_linha == -1) {
			  JOptionPane.showMessageDialog(this, "Agendamento não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);
		 }else{
			 int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Agendamento?", "Excluir", JOptionPane.YES_NO_OPTION);
			 if(resposta == JOptionPane.YES_OPTION){
				  if(Numero_linha >= 0){
					  return true;
				  }
				}
		 }
		return false;
	}
	
	private boolean Verifica_update(){
		
		
		if(Field_Placa_Veiculo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha a PLACA DO VEICULO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Placa_Veiculo.requestFocus();
			return false;
		}
		if(Field_Nome_Pessoa.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o NOME", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Nome_Pessoa.requestFocus();
			return false;
		}
		if(Field_Data.getText().trim().isEmpty() || Field_Data.getText().equals("  /  /    ")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha a DATA", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Data.requestFocus();
			return false;
		}
		
		if(Field_servico.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o SERVICO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_servico.requestFocus();
			return false;
		}
		
		
		
		return true;
		
	}
	
	private void Update_Agendamento(){
		
			String Data = Field_Data.getText();
			String [] DataSeparada = Data.split("/");
			LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));
			String Dia = null;
			 if(Radio_Segunda.isSelected()) Dia = "Segunda - Feira"; 		 
			 if(Radio_terça.isSelected()) Dia = "Terça - Feira";
			 if(Radio_Quarta.isSelected()) Dia = "Quarta - Feira";
			 if(Radio_quinta.isSelected()) Dia = "Quinta - Feira";
			 if(Radio_sexta.isSelected()) Dia = "Sexta - Feira";
			 if(Radio_sabado.isSelected()) Dia = "Sábado";
			 if(Radio_domingo.isSelected()) Dia = "Domingo";
			
			
			Agendamento_add agendamento = new Agendamento_add();
			agendamento.setPlaca(Field_Placa_Veiculo.getText());
			agendamento.setNome(Field_Nome_Pessoa.getText());
			agendamento.setData_Agenda(Date.valueOf(dia));
			agendamento.setDia_Semana(Dia);
			agendamento.setServico(Field_servico.getText());
			
			agendamentoDAO.update_agendamentos(agendamento);
			
			JOptionPane.showMessageDialog(this,"Dados Atualizados com Sucesso!","Concluido",JOptionPane.PLAIN_MESSAGE);
			
		}
	
	public void preenche_campos() {
		
		int Numero_linha = Table_Agendamento.getSelectedRow();
		String placa = (String)Table_Agendamento.getModel().getValueAt(Numero_linha, 0);
		Date Data = (Date) Table_Agendamento.getModel().getValueAt(Numero_linha, 2);
		
		String sql = "Select * from agendamentos where placa ='"
				+ placa +"' and data_agenda ='"
				+ Data +"'";
		
		try {
    		Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
			Field_Placa_Veiculo.setText(result.getString("PLACA"));
			Label_editavel_nome.setText(result.getString("NOME"));
			Field_Nome_Pessoa.setText(result.getString("NOME"));
			Label_data_editavel.setText(result.getString("DATA_AGENDA"));
			Label_Dia_editavel.setText(result.getString("DIA_SEMANA"));
			Label_Edita_serviço.setText(result.getString("SERVICO"));
			Field_servico.setText(result.getString("SERVICO"));
			Field_Data.setText(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void Cad_Agendamento() {
		
		 String Data = Field_Data.getText();
		 String [] DataSeparada = Data.split("/");
		 LocalDate dia = LocalDate.of(Integer.parseInt(DataSeparada[2]), Integer.parseInt(DataSeparada[1]), Integer.parseInt(DataSeparada[0]));
		 String Dia = null;
		 if(Radio_Segunda.isSelected()) Dia = "Segunda - Feira"; 		 
		 if(Radio_terça.isSelected()) Dia = "Terça - Feira";
		 if(Radio_Quarta.isSelected()) Dia = "Quarta - Feira";
		 if(Radio_quinta.isSelected()) Dia = "Quinta - Feira";
		 if(Radio_sexta.isSelected()) Dia = "Sexta - Feira";
		 if(Radio_sabado.isSelected()) Dia = "Sábado";
		 if(Radio_domingo.isSelected()) Dia = "Domingo";
		 		
		Agendamento_add agendamento = new Agendamento_add();
		agendamento.setPlaca(Field_Placa_Veiculo.getText());
		agendamento.setNome(Field_Nome_Pessoa.getText());
		agendamento.setData_Agenda(Date.valueOf(dia));
		agendamento.setDia_Semana(Dia);
		agendamento.setServico(Field_servico.getText());
		agendamentoDAO.Insert(agendamento);
		Limpa_dados();
		JOptionPane.showMessageDialog(this,agendamento.getNome() + " foi cadastrado"
	    + " com sucesso! \n Verifique na tabela ao lado !","Cadastro concluido",JOptionPane.INFORMATION_MESSAGE);
		update_tabela();
		
	}
	
	public void update_tabela() {

    	DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_Agendamento.getModel();
    	tablemodel_Cadastrados.setRowCount(0);
    	
    	for(Agendamento_add agendamento : agendamentoDAO.getAll()){
        	Object[] data = {
        			agendamento.getPlaca(),
        			agendamento.getNome(),
        			agendamento.getData_Agenda(),
        			//agendamento.getDia_Semana(),
        			agendamento.getServico()
    		};
        	
    		tablemodel_Cadastrados.addRow(data);
    		
        	}
    	
	}
	
	private boolean Verifica() {
		
		if(Field_Placa_Veiculo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha a PLACA DO VEICULO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Placa_Veiculo.requestFocus();
			return false;
		}
		if(Field_Nome_Pessoa.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o NOME", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Nome_Pessoa.requestFocus();
			return false;
		}
		if(Field_Data.getText().trim().isEmpty() || Field_Data.getText().equals("  /  /    ")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha a DATA", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Data.requestFocus();
			return false;
		}
		
		if(Field_servico.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o SERVICO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_servico.requestFocus();
			return false;
		}
		
		
		
		return true;
	}
	
	private void Limpa_dados() {
		Field_Placa_Veiculo.setText(null);
		Field_Nome_Pessoa.setText(null);
		Field_Data.setText(null);
		//Field_Data.setText(null);
		Field_servico.setText(null);
	}
	
	public void data() {
		
			LocalDate atual_data = LocalDate.now();
			 
		    String data;
			int mes = atual_data.getMonthValue();
			int dia = atual_data.getDayOfMonth();

			if(dia < 10){
				data = "0" + String.valueOf(dia + 1) + "/";
			} else {
				data = String.valueOf(dia + 1) + "/";
			}
			if(mes < 10) {
				data = data + "0" + String.valueOf(mes) +  "/";
			} else {
				data = data +  String.valueOf(mes) + "/";
			}
			
			data = data + String.valueOf(atual_data.getYear());
			
			Field_Data.setText(data);
		
	}

    // Variables declaration - do not modify                     
    private javax.swing.JButton Btn_Cancelar;
    private javax.swing.JButton Btn_Salvar;
    private javax.swing.JButton Btn_excluir;
    private javax.swing.JButton Btn_informações;
    private java.awt.TextField Field_Nome_Pessoa;
    private java.awt.TextField Field_Placa_Veiculo;
    private javax.swing.JFormattedTextField Field_servico;
    private javax.swing.JLabel Label_Data;
    private javax.swing.JLabel Label_Data_Semana;
    private javax.swing.JLabel Label_Dia_editavel;
    private javax.swing.JLabel Label_Edita_serviço;
    private javax.swing.JLabel Label_Nome;
    private javax.swing.JLabel Label_Placa;
    private javax.swing.JLabel Label_Seleciona_Linha;
    private javax.swing.JLabel Label_Servico;
    private javax.swing.JLabel Label_data_editavel;
    private javax.swing.JLabel Label_editavel_nome;
    private javax.swing.JLabel Label_informacoes;
    private javax.swing.JLabel Label_titulo_Agendamento;
    private javax.swing.JCheckBox Radio_Quarta;
    private javax.swing.JCheckBox Radio_Segunda;
    private javax.swing.JCheckBox Radio_domingo;
    private javax.swing.JCheckBox Radio_quinta;
    private javax.swing.JCheckBox Radio_sabado;
    private javax.swing.JCheckBox Radio_sexta;
    private javax.swing.JCheckBox Radio_terça;
    private javax.swing.JScrollPane Scroll_Agendamento;
    private javax.swing.JTable Table_Agendamento;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JFormattedTextField Field_Data;
    private javax.swing.JButton Btn_Gerar_dia;
    private AgendamentoDAO agendamentoDAO;
    private int Editar = 0 ;
    // End of variables declaration             

}
package Projeto_TelaEntrada;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Projeto_TelaEntrada.Cad_Cliente;
import Projeto_ClienteDAO.ClienteDAO;
import Projeto_ClienteDAO.ConnectionDAO;
import Projeto_ClienteDAO.ContaDAO;
import Projeto_Salva_Dados_textField_Cadastro.Cliente_add;
import Projeto_Salva_Dados_textField_Cadastro.Conta_add;

public class Cadastros_Clientes extends javax.swing.JPanel {

	private Connection connection;
	
	public Cadastros_Clientes() throws SQLException {
		clienteDAO = new ClienteDAO();
		contaDAO = new ContaDAO();
    	clienteDAO = new ClienteDAO();
    	cliente_Add = new Cliente_add();
    	connection = ConnectionDAO.getConnection();
		initComponents();
		}
	
	@SuppressWarnings("unchecked")
	 private void initComponents() {
		Combo_box1 = new javax.swing.JComboBox<>();
        Nome_label = new javax.swing.JLabel("Nome");
        Nome_TextField = new javax.swing.JTextField();
        Cpf_label = new javax.swing.JLabel("Cpf");
        Cpf_textfield = new javax.swing.JTextField();
        Rg_label = new javax.swing.JLabel("Rg");
        Rg_textField = new javax.swing.JTextField();
        En_Label = new javax.swing.JLabel("Endereço");
        En_TextField = new javax.swing.JTextField();
        Cell_Label = new javax.swing.JLabel("Cell");
        Cell_textField = new javax.swing.JTextField();
        limite_label = new javax.swing.JLabel("Saldo");
        Limite_textField = new javax.swing.JTextField();
        Edit_Button = new javax.swing.JButton("Editar");
        Excluir_Button = new javax.swing.JButton("Excluir");
        Salvar_Button = new javax.swing.JButton("Salvar");
        jRadioButton1 = new javax.swing.JLabel("Contas exluidas serão apagadas o credito automaticamente !");
      
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Combo_box1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Cell_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(En_Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Nome_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cpf_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Nome_TextField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cpf_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(Rg_label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Rg_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(En_TextField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Cell_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(limite_label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Limite_textField))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Edit_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Excluir_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salvar_Button))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Combo_box1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nome_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nome_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cpf_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cpf_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rg_label)
                    .addComponent(Rg_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(En_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(En_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cell_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cell_Label)
                    .addComponent(limite_label)
                    .addComponent(Limite_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edit_Button)
                    .addComponent(Excluir_Button)
                    .addComponent(Salvar_Button))
                .addGap(13, 13, 13))
        );
        Combo_box1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Bloq_Campos();
				Print_information();
			}
		});
        
        Edit_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Edit_action();
			}
		});
        
        Excluir_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Excluir_Button();
			}
		});
        
        Salvar_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Salvar_Action();
				
			}
		});

    }
	
	private void Excluir_Button() {
		Cliente_add Cliente = new Cliente_add();
		Cliente.setCpf(Cpf_textfield.getText());
		clienteDAO.excluir(Cliente);
		JOptionPane.showMessageDialog(this,"Contas Excluidas! \n Dados Excluidos com Sucesso!","Concluido",JOptionPane.YES_OPTION);
		UpdateCombo();
		Bloq_Campos();
	}
	
	private void Salvar_Action() {
		Cliente_add Cliente = new Cliente_add();
    	Cliente.setNome(Nome_TextField.getText());
    	Cliente.setCpf(Cpf_textfield.getText());
    	Cliente.setCell(Cell_textField.getText());
    	Cliente.setEndereço(En_TextField.getText());
    	Cliente.setRg(Rg_textField.getText());
    	Cliente.setLimite(Double.valueOf( Limite_textField.getText()));
		clienteDAO.update(Cliente);
		
		UpdateCombo();
		Bloq_Campos();
		
			JOptionPane.showMessageDialog(this,"Dados Atualizados com Sucesso!","Concluido",JOptionPane.PLAIN_MESSAGE);
		
	}
	
	private void Print_information() {
		clear();
		for(Cliente_add cliente : clienteDAO.getAll()){
			if(cliente.getNome().equals(Combo_box1.getSelectedItem())){
				Nome_TextField.setText(cliente.getNome());
				Cpf_textfield.setText(cliente.getCpf());
				Rg_textField.setText(cliente.getRg());
				En_TextField.setText(cliente.getEndereço());
				Cell_textField.setText(cliente.getCell());
				Limite_textField.setText(Double.toString(cliente.getLimite()));
			}
		}
	}
	
	private void Bloq_Campos() {
		Nome_TextField.setEditable(false);
		Cpf_textfield.setEditable(false);
		Rg_textField.setEditable(false);
		En_TextField.setEditable(false);
		Cell_textField.setEditable(false);
		Limite_textField.setEditable(false);
	}
	
	private void Lib_Campos() {
		Nome_TextField.setEditable(true);
		Rg_textField.setEditable(true);
		En_TextField.setEditable(true);
		Cell_textField.setEditable(true);
		Limite_textField.setEditable(true);
	}

	private void Edit_action() {
		
		Lib_Campos();
		}
	
	public void UpdateCombo() {
		Combo_box1.removeAllItems();
		Combo_box1.addItem("Seleciona");
		String sql = "SELECT * FROM clientes ORDER BY nome";
    	try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()){
			Combo_box1.addItem(result.getString("NOME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void clear() {
		Nome_TextField.setText(null);
		Cpf_textfield.setText(null);
		Rg_textField.setText(null);
		En_TextField.setText(null);
		Cell_textField.setText(null);
		Limite_textField.setText(null);
	}

    private javax.swing.JLabel Cell_Label;
    private javax.swing.JTextField Cell_textField;
    private javax.swing.JComboBox<String> Combo_box1;
    private javax.swing.JLabel Cpf_label;
    private javax.swing.JTextField Cpf_textfield;
    private javax.swing.JButton Edit_Button;
    private javax.swing.JLabel En_Label;
    private javax.swing.JTextField En_TextField;
	private javax.swing.JButton Excluir_Button;
    private javax.swing.JTextField Limite_textField;
    private javax.swing.JTextField Nome_TextField;
    private javax.swing.JLabel Nome_label;
    private javax.swing.JLabel Rg_label;
    private javax.swing.JTextField Rg_textField;
    private javax.swing.JButton Salvar_Button;
    private javax.swing.JLabel jRadioButton1;
    private javax.swing.JLabel limite_label;
    private ClienteDAO clienteDAO;
    private Cliente_add cliente_Add;
    private ContaDAO contaDAO;         
	
}
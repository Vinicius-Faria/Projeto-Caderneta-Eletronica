package mecanica.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mecanica.connection.ConnectionDAO;
import mecanicaDAO.Cliente_add;
import mecanicaDAO.Veiculo_add;
import mecanicaDAOCliente.ClienteDAO;
import mecanicaDAOVeiculo.VeiculoDAO;

	public class Tela_Cadastro_Cliente extends JPanel{
		
	private static final long serialVersionUID = 1L;
	private Connection connection;
	
	public Tela_Cadastro_Cliente() throws SQLException {
        initComponents();
        connection = ConnectionDAO.getConnection();
        clienteDAO = new ClienteDAO();
        veiculoDAO = new VeiculoDAO();
    }

	private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        Label_Nome = new javax.swing.JLabel("Nome");
        Label_Cpf = new javax.swing.JLabel("Cpf");
        Label_Rg = new javax.swing.JLabel("Rg");
        Field_Nome = new javax.swing.JFormattedTextField();
        Field_Cell = new javax.swing.JFormattedTextField();
        Field_Cpf = new javax.swing.JFormattedTextField();
        Label_Informações_Cliente = new javax.swing.JLabel("Informações Cliente");
        Label_Cell = new javax.swing.JLabel("Cell");
        Field_Rg = new javax.swing.JFormattedTextField();
        Label_Fixo = new javax.swing.JLabel("Fixo");
        Field_Fixo =new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Label_Endereco = new javax.swing.JLabel("Endereço");
        jSeparator3 = new javax.swing.JSeparator();
        Label_Cidade = new javax.swing.JLabel("Cidade");
        Label_Cep = new javax.swing.JLabel("Cep");
        Label_Rua = new javax.swing.JLabel("Rua");
        Label_Numero = new javax.swing.JLabel("Numero");
        Label_Bairro = new javax.swing.JLabel("Bairro");
        Label_Estado = new javax.swing.JLabel("Estado");
        Combo_Estado = new javax.swing.JComboBox<>();
        Field_Cidade = new javax.swing.JFormattedTextField();
        Field_Cep = new javax.swing.JFormattedTextField();
        Field_Bairro = new javax.swing.JFormattedTextField();
        Field_Rua = new javax.swing.JFormattedTextField();
        Field_Numero = new javax.swing.JFormattedTextField();
        Radio_Casa = new javax.swing.JCheckBox("Casa");
        jRadioButton1 = new javax.swing.JCheckBox("Apartamento");
        Label_editar = new javax.swing.JLabel("Editar Cliente");
        jSeparator4 = new javax.swing.JSeparator();
        Label_Edi_Seleciona = new javax.swing.JLabel("Seleciona Cliente : ");
        Combo_Edi_Nome = new javax.swing.JComboBox<>();
        Label_Edi_Cpf = new javax.swing.JLabel("Digite o Cpf : ");
        Field_Ed_Cpf = new javax.swing.JFormattedTextField();
        Label_Cadastrados = new javax.swing.JLabel("Cadastrados");
        jSeparator5 = new javax.swing.JSeparator();
        Label_Veiculo = new javax.swing.JLabel("Veiculo");
        jSeparator6 = new javax.swing.JSeparator();
        Label_Modelo_Carro = new javax.swing.JLabel("Modelo");
        Label_Placa_Carro = new javax.swing.JLabel("Placa");
        Label_Km_Carro = new javax.swing.JLabel("Km");
        Field_Placa_Carro = new javax.swing.JFormattedTextField();
        Field_Km_Carro = new javax.swing.JFormattedTextField();
        Btn_Cancelar = new javax.swing.JButton("Cancelar");
        Btn_Salvar = new javax.swing.JButton("Salvar");
        Btn_editar = new javax.swing.JButton("Editar");
        Btn_Procurar = new javax.swing.JButton();
        Scroll_Cadastrados = new javax.swing.JScrollPane();
        Table_Cadastrados = new javax.swing.JTable();
        Combo_Modelo_Carro = new javax.swing.JFormattedTextField();
        Label_Cliente_Veiculo = new javax.swing.JLabel("Cliente");
        Combo_Cliente = new javax.swing.JComboBox<>();
        Btn_Veiculo_Cancelar = new javax.swing.JButton("Cancelar");
        Btn_Salvar_Veiculo = new javax.swing.JButton("Salvar");
        Check_Bloquear = new javax.swing.JCheckBox("Bloquear");
        Label_Verifica_Placa = new javax.swing.JLabel("Verifica Placa");
        Combo_Placa = new javax.swing.JComboBox<>();

        Label_Informações_Cliente.setFont(new java.awt.Font("Arial Black", 0, 12));       
        Label_Endereco.setFont(new java.awt.Font("Arial Black", 0, 12));     
        Label_editar.setFont(new java.awt.Font("Arial Black", 0, 12)); 
        Label_Cadastrados.setFont(new java.awt.Font("Arial Black", 0, 12)); 
        Label_Veiculo.setFont(new java.awt.Font("Arial Black", 0, 12)); 
                
        Btn_Salvar.setBackground(Color.WHITE);
        Btn_Salvar.setToolTipText("Salvar");
        ImageIcon image_Salvar = new ImageIcon(getClass().getResource("/tick.png"));
        Btn_Salvar.setIcon(image_Salvar);
        
        Btn_Cancelar.setBackground(Color.WHITE);
        Btn_Cancelar.setToolTipText("Cancelar");
        ImageIcon image_Cancel = new ImageIcon(getClass().getResource("/close.png"));
        Btn_Cancelar.setIcon(image_Cancel);
        
        Btn_Procurar.setBackground(Color.WHITE);
        Btn_Procurar.setToolTipText("Procurar");
        ImageIcon image_Lupa= new ImageIcon(getClass().getResource("/search (1).png"));
        Btn_Procurar.setIcon(image_Lupa);
        
        Btn_editar.setBackground(Color.WHITE);
        Btn_editar.setToolTipText("Salvar");
        ImageIcon image_editar= new ImageIcon(getClass().getResource("/pencil.png"));
        Btn_editar.setIcon(image_editar);
        
        Btn_Salvar_Veiculo.setBackground(Color.white);
        Btn_Salvar_Veiculo.setToolTipText("Salvar");
        Btn_Salvar_Veiculo.setIcon(image_Salvar);
        
        Btn_Veiculo_Cancelar.setBackground(Color.WHITE);
        Btn_Veiculo_Cancelar.setToolTipText("Cancelar");
        Btn_Veiculo_Cancelar.setIcon(image_Cancel);
        
        //Field_Ed_Cpf.setEnabled(false);
        //Combo_Edi_Nome.setEnabled(false);
        //Combo_Placa.setEnabled(false);
        Btn_editar.setEnabled(false);
        
        ButtonGroup Btn_Grupo = new ButtonGroup();
        Btn_Grupo.add(jRadioButton1);
        Btn_Grupo.add(Radio_Casa);
        
      //Coloca as especificações nos campos da tabela
        Vector<String> columnNames = new Vector<String>();
		columnNames.add("Nome");
		columnNames.add("Cpf");
		columnNames.add("Cell");
		Vector<? extends Vector> vector = new Vector();
		Table_Cadastrados = new JTable(vector,columnNames);
		Scroll_Cadastrados = new JScrollPane(Table_Cadastrados);
        
        try {
            Field_Cell.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            Field_Fixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            Field_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            Field_Ed_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_Informações_Cliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_Endereco)
                            .addComponent(Label_Veiculo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Label_Cadastrados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(415, 415, 415)
                                .addComponent(Label_editar)
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(Label_Fixo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Label_Rg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Label_Cpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Label_Cell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Label_Nome, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(Field_Cell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                                    .addComponent(Field_Nome))
                                                .addComponent(Field_Cpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Field_Fixo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Field_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(137, 137, 137)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Btn_editar)
                                            .addComponent(Label_Edi_Seleciona)
                                            .addComponent(Label_Edi_Cpf)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Field_Ed_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Btn_Procurar))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Combo_Edi_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(104, 104, 104)
                                                .addComponent(Check_Bloquear))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Label_Modelo_Carro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Label_Km_Carro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Label_Placa_Carro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Field_Km_Carro)
                                            .addComponent(Combo_Modelo_Carro)
                                            .addComponent(Field_Placa_Carro, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(Label_Cliente_Veiculo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Btn_Veiculo_Cancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Btn_Salvar_Veiculo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Combo_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(77, 77, 77)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Label_Verifica_Placa)
                                                    .addComponent(Combo_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Label_Numero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Label_Estado)
                                            .addComponent(Label_Cep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Label_Cidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Label_Bairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Label_Rua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Radio_Casa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton1))
                                            .addComponent(Combo_Estado, 0, 290, Short.MAX_VALUE)
                                            .addComponent(Field_Cidade)
                                            .addComponent(Field_Cep)
                                            .addComponent(Field_Bairro)
                                            .addComponent(Field_Rua)
                                            .addComponent(Field_Numero))
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Cancelar)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Salvar)
                                        .addGap(18, 18, 18)
                                        .addComponent(Scroll_Cadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 311, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_Informações_Cliente)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_editar)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Nome)
                    .addComponent(Btn_editar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Field_Cell, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Cell))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Field_Fixo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Fixo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Field_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_Cpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Rg)
                            .addComponent(Field_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Endereco)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_Edi_Seleciona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Combo_Edi_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Check_Bloquear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_Edi_Cpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Field_Ed_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Procurar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_Cadastrados)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Label_Cidade)
                                    .addComponent(Field_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Label_Estado)
                                .addComponent(Combo_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Cep)
                            .addComponent(Field_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Bairro)
                            .addComponent(Field_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Rua)
                            .addComponent(Field_Rua, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Radio_Casa)
                            .addComponent(jRadioButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_Numero)
                            .addComponent(Field_Numero, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Cancelar)
                            .addComponent(Btn_Salvar)))
                    .addComponent(Scroll_Cadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Veiculo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Modelo_Carro)
                    .addComponent(Combo_Modelo_Carro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Cliente_Veiculo)
                    .addComponent(Combo_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Verifica_Placa))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Placa_Carro)
                    .addComponent(Field_Placa_Carro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Combo_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Km_Carro)
                    .addComponent(Field_Km_Carro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Veiculo_Cancelar)
                    .addComponent(Btn_Salvar_Veiculo))
                .addContainerGap())
        );
    
        
      //funcao de salvar
        Btn_Salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Verifica()) {
					Cad_Cliente();
				}
				
			}
		});
        
      //Funcao salva edição
        Btn_editar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Update_cliente();
				Limpa_dados();
				Btn_Salvar.setEnabled(true);
				Btn_Cancelar.setEnabled(true);
				Btn_Salvar_Veiculo.setEnabled(true);
				Btn_Veiculo_Cancelar.setEnabled(true);
				Combo_Cliente.setEnabled(true);
				Combo_Placa.setEnabled(true);
				Btn_editar.setEnabled(false);
				Field_Cpf.setEnabled(true);
				Btn_Procurar.setEnabled(true);
				Combo_Edi_Nome.setEnabled(true);
				update_tabela();
				update_Editar_Combo();
				
			}
		});
        
      //Funcao procurar o cpf 
       Btn_Procurar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Field_Ed_Cpf.getText().trim().isEmpty() || Field_Ed_Cpf.getText().equals("   .   .   -  ")){
				erro();
				
			}else{
				if(preenche_campos()){	
				Btn_Salvar.setEnabled(false);
				Btn_Cancelar.setEnabled(false);
				Btn_Salvar_Veiculo.setEnabled(false);
				Btn_Veiculo_Cancelar.setEnabled(false);
				Btn_Procurar.setEnabled(false);
				Combo_Cliente.setEnabled(false);
				Combo_Placa.setEnabled(false);
				Btn_editar.setEnabled(true);
				Field_Cpf.setEnabled(false);
				}
			}
			}
	});
    
      //Funcao de cancelar Cadastro
       Btn_Cancelar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar o cadastro", "Cadastro de Cliente", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				Limpa_dados();
				
			}
			
		}
	});
     
      //Funcao da combo box Editar
       Combo_Edi_Nome.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String str = "Seleciona";
			if(str.equals(Combo_Edi_Nome.getSelectedItem())){
				Limpa_dados();
				Btn_Salvar.setEnabled(true);
				Btn_Cancelar.setEnabled(true);
				Btn_Salvar_Veiculo.setEnabled(true);
				Btn_Veiculo_Cancelar.setEnabled(true);
				Combo_Cliente.setEnabled(true);
				Combo_Placa.setEnabled(true);
				Btn_editar.setEnabled(false);
				Field_Cpf.setEnabled(true);
				Radio_Casa.setSelected(false);
				jRadioButton1.setSelected(false);
				Field_Ed_Cpf.setEnabled(true);
				Btn_Procurar.setEnabled(true);
			}else {
				Mostrar_Cadastro();
				Btn_Salvar.setEnabled(false);
				Btn_Cancelar.setEnabled(false);
				Btn_Salvar_Veiculo.setEnabled(false);
				Btn_Veiculo_Cancelar.setEnabled(false);
				Combo_Cliente.setEnabled(false);
				Combo_Placa.setEnabled(false);
				Btn_editar.setEnabled(true);
				Field_Cpf.setEnabled(false);
				Field_Ed_Cpf.setEnabled(false);
				Btn_Procurar.setEnabled(false);
			}
			
		}
	});
       
       //Funcao da Combo box placa
       Combo_Placa.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = "Seleciona";
			if(str.equals(Combo_Placa.getSelectedItem())){
				Limpa_dados_Veiculo();
			}else {
				Mostrar_Cadastro_Veiculo();
			}
		}
	});
   
      //Funcao de salvar veiculo
       Btn_Salvar_Veiculo.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if( Verifica_Veiculos()) {
				Cad_Veiculo();
			
			}
		}
	});
	
      //Funcao de Cancelar Veiculo
       Btn_Veiculo_Cancelar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar o cadastro", "Cadastro de Veiculo", JOptionPane.YES_NO_OPTION);
			if(resposta == JOptionPane.YES_OPTION) {
				Limpa_dados_Veiculo();
				
			}
			
		}
	});
	
	}	
	
	private void erro(){
		 JOptionPane.showMessageDialog(this, "Por favor, preencha o Campo ao lado", "Campo vazio", JOptionPane.WARNING_MESSAGE);
		 Field_Ed_Cpf.requestFocus();
	}
	
	private boolean Verifica_update(){
		
		
		if(Field_Nome.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o NOME", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Nome.requestFocus();
			return false;
		}
		if(Field_Cell.getText().trim().isEmpty() || Field_Cell.getText().equals("(  )     -    ")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o CELL", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cell.requestFocus();
			return false;
		}
		if(Field_Fixo.getText().trim().isEmpty() || Field_Fixo.getText().equals("(  )    -    ")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o FIXO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Fixo.requestFocus();
			return false;
		}
		if(Field_Cpf.getText().trim().isEmpty() || Field_Cpf.getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o CPF", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cpf.requestFocus();
			return false;
		}
		if(Field_Rg.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o RG", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Rg.requestFocus();
			return false;
		}
		if(Combo_Estado.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione um ESTADO valido", "Campo Inválido", JOptionPane.WARNING_MESSAGE);
			Combo_Estado.requestFocus();
			return false;
		}
		if(Field_Cidade.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o CIDADE", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cidade.requestFocus();
			return false;
		}
		if(Field_Cep.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o CEP", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cep.requestFocus();
			return false;
		}
		if(Field_Bairro.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o BAIRRO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Bairro.requestFocus();
			return false;
		}
		if(Field_Rua.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o RUA", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Rua.requestFocus();
			return false;
		}
		if(Field_Numero.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o NUMERO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Numero.requestFocus();
			return false;
		}
		
		
		return true;
		
	}
	
	private void update_Veiculo() {
		
		Veiculo_add veiculo = new Veiculo_add();
		veiculo.setModelo(Combo_Modelo_Carro.getText());
		veiculo.setPlaca(Field_Placa_Carro.getText());
		veiculo.setKm(Field_Km_Carro.getText());
		veiculo.setCliente(Combo_Cliente.getSelectedItem().toString());
		veiculoDAO.update_veiculos(veiculo);
		JOptionPane.showMessageDialog(this,"Dados Atualizados com Sucesso!","Concluido",JOptionPane.PLAIN_MESSAGE);
	}
	
	private void Limpa_dados_Veiculo() {
		
		Field_Km_Carro.setText(null);
		Field_Placa_Carro.setText(null);
		Combo_Modelo_Carro.setText(null);
		Combo_Cliente.setSelectedItem("Seleciona");
		Combo_Placa.setSelectedItem("Seleciona");
		
	}
	
	private void Mostrar_Cadastro_Veiculo() {
		for(Veiculo_add veiculo : veiculoDAO.getAll()) {
			if(veiculo.getPlaca().equals(Combo_Placa.getSelectedItem())) {
				Combo_Modelo_Carro.setText(veiculo.getModelo());
				Field_Placa_Carro.setText(veiculo.getPlaca());
				Field_Km_Carro.setText(veiculo.getKm());
				Combo_Cliente.setSelectedItem(veiculo.getCliente());
			}
		}
	}
	
	private boolean Verifica_Veiculos() {
		
		if(Combo_Modelo_Carro.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o MODELO do carro", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Combo_Modelo_Carro.requestFocus();
			return false;
		}
		if(Field_Placa_Carro.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha a PLACA do carro", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Placa_Carro.requestFocus();
			return false;
		}
		if(Field_Km_Carro.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o KM do carro", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Km_Carro.requestFocus();
			return false;
		}
		if(Combo_Cliente.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione um CLIENTE valido", "Campo Inválido", JOptionPane.WARNING_MESSAGE);
			Combo_Cliente.requestFocus();
			return false;
		}
		
		
		return true;
	}
	
	private void Update_cliente(){
			Double apt_Casa = 0.0;
			Double block = 0.0;
			
			if(jRadioButton1.isSelected()) apt_Casa = 0.0;
			if(Radio_Casa.isSelected()) apt_Casa = 1.0;	
			
			if(Check_Bloquear.isSelected()) block = 1.0;
			else block = 0.0;
		
			Cliente_add cliente = new Cliente_add();
			cliente.setNome(Field_Nome.getText());
			cliente.setCell(Field_Cell.getText());
			cliente.setFixo(Field_Fixo.getText());
			cliente.setCpf(Field_Cpf.getText());
			cliente.setRg(Field_Rg.getText());
			cliente.setEstado(Combo_Estado.getSelectedItem().toString());
			cliente.setCidade(Field_Cidade.getText());
			cliente.setCep(Field_Cep.getText());
			cliente.setBairro(Field_Bairro.getText());
			cliente.setRua(Field_Rua.getText());
			cliente.setApt_Casa(apt_Casa);
			cliente.setNumero(Field_Numero.getText());
			cliente.setBloquear(block);
			clienteDAO.update_cliente(cliente);
			
			JOptionPane.showMessageDialog(this,"Dados Atualizados com Sucesso!","Concluido",JOptionPane.PLAIN_MESSAGE);
			
		}
	
	public boolean preenche_campos() {
		
		
		for(Cliente_add cliente : clienteDAO.getAll()) {
			
			if(cliente.getCpf().equals(Field_Ed_Cpf.getText())) {
				Field_Nome.setText(cliente.getNome());
				Field_Cell.setText(cliente.getCell());
				Field_Fixo.setText(cliente.getFixo());
				Field_Cpf.setText(cliente.getCpf());
				Field_Rg.setText(cliente.getRg());
				Combo_Estado.setSelectedItem(cliente.getEstado());
				Field_Cidade.setText(cliente.getCidade());
				Field_Cep.setText(cliente.getCep());
				Field_Bairro.setText(cliente.getBairro());
				Field_Rua.setText(cliente.getRua());
				Field_Numero.setText(cliente.getNumero());
				if(cliente.getApt_Casa() == 1.0 ) Radio_Casa.setSelected(true);
				if(cliente.getApt_Casa() == 0.0 ) jRadioButton1.setSelected(true);
				if(cliente.getBloquear() == 1.0) Check_Bloquear.setSelected(true);
				else Check_Bloquear.setSelected(false);
			}
			Combo_Edi_Nome.setEnabled(false);
		}
		if(Field_Cpf.getText().trim().isEmpty() || Field_Cpf.getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(this, "Cliente não cadastrado", "Cliente Inválido", JOptionPane.WARNING_MESSAGE);
			Field_Ed_Cpf.requestFocus();
			return false;
		}
		
		return true;
	}
	
	public void Mostrar_Cadastro() {
		for(Cliente_add cliente : clienteDAO.getAll()) {
			if(cliente.getNome().equals(Combo_Edi_Nome.getSelectedItem())) {
				Field_Nome.setText(cliente.getNome());
				Field_Cell.setText(cliente.getCell());
				Field_Fixo.setText(cliente.getFixo());
				Field_Cpf.setText(cliente.getCpf());
				Field_Rg.setText(cliente.getRg());
				Combo_Estado.setSelectedItem(cliente.getEstado());
				Field_Cidade.setText(cliente.getCidade());
				Field_Cep.setText(cliente.getCep());
				Field_Bairro.setText(cliente.getBairro());
				Field_Rua.setText(cliente.getRua());
				Field_Numero.setText(cliente.getNumero());
				if(cliente.getApt_Casa() == 1.0 ) Radio_Casa.setSelected(true);;
				if(cliente.getApt_Casa() == 0.0 ) jRadioButton1.setSelected(true);;
				if(cliente.getBloquear() == 1.0) Check_Bloquear.setSelected(true);
				else Check_Bloquear.setSelected(false);
			}
		}
	}
	
	public void update_Editar_Combo() {
		Combo_Edi_Nome.removeAllItems();
		Combo_Cliente.removeAllItems();
		Combo_Edi_Nome.addItem("Seleciona");	
		Combo_Cliente.addItem("Seleciona");
		 
		 String sql = "SELECT * FROM clientes ORDER BY NOME";
	    	try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next()){
				Combo_Edi_Nome.addItem(result.getString("NOME"));
				Combo_Cliente.addItem(result.getString("NOME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	private void Cad_Cliente() {
		 double C_APt = 0.0 ;
		
		if(Radio_Casa.isSelected()){
			C_APt = 1.0;
		}
		if(jRadioButton1.isSelected()){
			C_APt = 0.0;
		}
		
			Cliente_add cliente = new Cliente_add();
			cliente.setNome(Field_Nome.getText());
			cliente.setCell(Field_Cell.getText());
			cliente.setFixo(Field_Fixo.getText());
			cliente.setCpf(Field_Cpf.getText());
			cliente.setRg(Field_Rg.getText());
			cliente.setEstado(Combo_Estado.getSelectedItem().toString());
			cliente.setCidade(Field_Cidade.getText());
			cliente.setCep(Field_Cep.getText());
			cliente.setBairro(Field_Bairro.getText());
			cliente.setRua(Field_Rua.getText());
			cliente.setApt_Casa(Double.valueOf(C_APt));
			cliente.setNumero(Field_Numero.getText());
			cliente.setBloquear(0.00);
			clienteDAO.Insert(cliente);
			Limpa_dados();
			JOptionPane.showMessageDialog(this,cliente.getNome() + " foi cadastrado"
	    	+ " com sucesso! \n Verifique na tabela ao lado !","Cadastro concluido",JOptionPane.INFORMATION_MESSAGE);
			update_tabela();
			update_Editar_Combo();
		
		
	}
	
	private void Cad_Veiculo() {
		Veiculo_add veiculo = new Veiculo_add();
		veiculo.setModelo(Combo_Modelo_Carro.getText());
		veiculo.setPlaca(Field_Placa_Carro.getText());
		veiculo.setKm(Field_Km_Carro.getText());
		veiculo.setCliente(Combo_Cliente.getSelectedItem().toString());
		veiculoDAO.Insert(veiculo);
		Limpa_dados();
		JOptionPane.showMessageDialog(this,veiculo.getPlaca() + " foi cadastrado"
		    	+ " com sucesso!","Cadastro concluido",JOptionPane.INFORMATION_MESSAGE);
		update_Combo_placa();
	}
	
	public void update_Combo_placa() {
		Combo_Placa.removeAllItems();
		Combo_Placa.addItem("Seleciona");
		
		 String sql = "SELECT * FROM placa_veiculos ORDER BY placa";
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
	
	public void update_tabela() {

    	DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) Table_Cadastrados.getModel();
    	tablemodel_Cadastrados.setRowCount(0);
    	
    	for(Cliente_add cliente : clienteDAO.getAll()){
        	Object[] data = {
    				cliente.getNome(),
    				cliente.getCpf(),
    				cliente.getCell()
    		};
        	
    		tablemodel_Cadastrados.addRow(data);
    		
        	}
    	
	}
	
	private boolean Verifica() {
		
		if(Field_Nome.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o NOME", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Nome.requestFocus();
			return false;
		}
		if(Field_Cell.getText().trim().isEmpty() || Field_Cell.getText().equals("(  )     -    ")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o CELL", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cell.requestFocus();
			return false;
		}
		if(Field_Fixo.getText().trim().isEmpty() || Field_Fixo.getText().equals("(  )    -    ")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o FIXO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Fixo.requestFocus();
			return false;
		}
		if(Field_Cpf.getText().trim().isEmpty() || Field_Cpf.getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o CPF", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cpf.requestFocus();
			return false;
		}
		if(Field_Rg.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o RG", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Rg.requestFocus();
			return false;
		}
		if(Combo_Estado.getSelectedItem().equals("Seleciona")) {
			JOptionPane.showMessageDialog(this, "Por favor, Selecione um ESTADO valido", "Campo Inválido", JOptionPane.WARNING_MESSAGE);
			Combo_Estado.requestFocus();
			return false;
		}
		if(Field_Cidade.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o CIDADE", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cidade.requestFocus();
			return false;
		}
		if(Field_Cep.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o CEP", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Cep.requestFocus();
			return false;
		}
		if(Field_Bairro.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o BAIRRO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Bairro.requestFocus();
			return false;
		}
		if(Field_Rua.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o RUA", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Rua.requestFocus();
			return false;
		}
		if(Field_Numero.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o NUMERO", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			Field_Numero.requestFocus();
			return false;
		}
		for(Cliente_add cliente_msm_Cpf : clienteDAO.getAll()) {
    		if(Field_Cpf.getText().equals(cliente_msm_Cpf.getCpf())) {
    			JOptionPane.showMessageDialog(this, "CPF ja usado", "Cadastrado", JOptionPane.WARNING_MESSAGE);
    			Field_Cpf.requestFocus();
    			return false;
    		}
    	}
		for(Cliente_add cliente_msm_Nome : clienteDAO.getAll()) {
    		if(Field_Nome.getText().equals(cliente_msm_Nome.getNome())) {
    			JOptionPane.showMessageDialog(this, "Nome ja usado! Coloque uma sobrenome", "Cadastrado", JOptionPane.WARNING_MESSAGE);
    			Field_Nome.requestFocus();
    			return false;
    		}
    	}
		
		return true;
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
	
	private void Limpa_dados() {
		Field_Bairro.setText(null);
		Field_Cell.setText(null);
		Field_Cep.setText(null);
		Field_Cidade.setText(null);
		Field_Cpf.setText(null);
		Field_Ed_Cpf.setText(null);
		Field_Fixo.setText(null);
		Field_Km_Carro.setText(null);
		Field_Nome.setText(null);
		Field_Numero.setText(null);
		Field_Placa_Carro.setText(null);
		Field_Rg.setText(null);
		Field_Rua.setText(null);
		Combo_Estado.setSelectedItem("Seleciona");
		Radio_Casa.setSelected(false);
		jRadioButton1.setSelected(false);
	}
	
	private void Bloquea_Campos() {
		
		 Field_Ed_Cpf.setEnabled(false);
	     Combo_Edi_Nome.setEnabled(false);
		 Combo_Edi_Nome.setSelectedItem("Seleciona");
		 Combo_Placa.setEnabled(false);
	}
	
	private void Libera_Campos_edita() {
		
        Field_Ed_Cpf.setEnabled(true);
        Combo_Edi_Nome.setEnabled(true);
        Combo_Placa.setEnabled(true);
		
	}

		//Variables declaration - do not modify                     
	 	private javax.swing.JButton Btn_Cancelar;
	    private javax.swing.JButton Btn_Procurar;
	    private javax.swing.JButton Btn_Salvar;
	    private javax.swing.JButton Btn_Salvar_Veiculo;
	    private javax.swing.JButton Btn_Veiculo_Cancelar;
	    private javax.swing.JButton Btn_editar;
	    private javax.swing.JCheckBox Check_Bloquear;
	    private javax.swing.JComboBox<String> Combo_Cliente;
	    private javax.swing.JComboBox<String> Combo_Edi_Nome;
	    private javax.swing.JComboBox<String> Combo_Estado;
	    private javax.swing.JFormattedTextField Combo_Modelo_Carro;
	    private javax.swing.JFormattedTextField Field_Bairro;
	    private javax.swing.JFormattedTextField Field_Cell;
	    private javax.swing.JFormattedTextField Field_Cep;
	    private javax.swing.JFormattedTextField Field_Cidade;
	    private javax.swing.JFormattedTextField Field_Cpf;
	    private javax.swing.JFormattedTextField Field_Ed_Cpf;
	    private javax.swing.JFormattedTextField Field_Fixo;
	    private javax.swing.JFormattedTextField Field_Km_Carro;
	    private javax.swing.JFormattedTextField Field_Nome;
	    private javax.swing.JFormattedTextField Field_Numero;
	    private javax.swing.JFormattedTextField Field_Placa_Carro;
	    private javax.swing.JFormattedTextField Field_Rg;
	    private javax.swing.JFormattedTextField Field_Rua;
	    private javax.swing.JLabel Label_Verifica_Placa;
	    private javax.swing.JLabel Label_Bairro;
	    private javax.swing.JLabel Label_Cadastrados;
	    private javax.swing.JLabel Label_Cell;
	    private javax.swing.JLabel Label_Cep;
	    private javax.swing.JLabel Label_Cidade;
	    private javax.swing.JLabel Label_Cliente_Veiculo;
	    private javax.swing.JLabel Label_Cpf;
	    private javax.swing.JLabel Label_Edi_Cpf;
	    private javax.swing.JLabel Label_Edi_Seleciona;
	    private javax.swing.JLabel Label_Endereco;
	    private javax.swing.JLabel Label_Estado;
	    private javax.swing.JLabel Label_Fixo;
	    private javax.swing.JLabel Label_Informações_Cliente;
	    private javax.swing.JLabel Label_Km_Carro;
	    private javax.swing.JLabel Label_Modelo_Carro;
	    private javax.swing.JLabel Label_Nome;
	    private javax.swing.JLabel Label_Numero;
	    private javax.swing.JLabel Label_Placa_Carro;
	    private javax.swing.JLabel Label_Rg;
	    private javax.swing.JLabel Label_Rua;
	    private javax.swing.JLabel Label_Veiculo;
	    private javax.swing.JLabel Label_editar;
	    private javax.swing.JCheckBox Radio_Casa;
	    private javax.swing.JScrollPane Scroll_Cadastrados;
	    private javax.swing.JTable Table_Cadastrados;
	    private javax.swing.JCheckBox jRadioButton1;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
	    private javax.swing.JSeparator jSeparator3;
	    private javax.swing.JSeparator jSeparator4;
	    private javax.swing.JSeparator jSeparator5;
	    private javax.swing.JSeparator jSeparator6;
	    private javax.swing.JComboBox<String> Combo_Placa;
	    private ClienteDAO clienteDAO;
	    private VeiculoDAO veiculoDAO;
	   
	    // End of variables declaration    
}

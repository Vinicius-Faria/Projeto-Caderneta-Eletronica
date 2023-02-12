package Projeto_TelaEntrada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Cad_Cliente extends javax.swing.JPanel {

    
	private static final long serialVersionUID = 1L;
	public Cad_Cliente() throws SQLException {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        NomeLabel = new javax.swing.JLabel("Nome");
        CpfLabel = new javax.swing.JLabel("Cpf");
        RgLabel = new javax.swing.JLabel("Rg");
        EnderecoLabel = new javax.swing.JLabel("Endere�o");
        CellLabel = new javax.swing.JLabel("Cell");
        LimiteLabel = new javax.swing.JLabel("Limite");
        NomeTextField = new java.awt.TextField();
        CpfTextField = new java.awt.TextField();
        RgTextField = new java.awt.TextField();
        EnderecoTextField = new java.awt.TextField();
        CellTextField = new java.awt.TextField();
        LimiteTextField = new java.awt.TextField();
        CancelButton = new javax.swing.JButton("Cancelar");	
        SaveButton = new javax.swing.JButton("Salvar");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        RecemAddLabel = new javax.swing.JLabel("Adicionados");
        
        NomeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CpfLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CpfLabel.setToolTipText("");
        RgLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EnderecoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CellLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LimiteLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RecemAddLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        
        //Coloca as especifica��es nos campos da tabela
        Vector<String> columnNames = new Vector<String>();
		columnNames.add("Nome");
		columnNames.add("Cpf");
		columnNames.add("Cell");
		columnNames.add("Limite");
		Vector<? extends Vector> vector = new Vector();
		jTable1 = new JTable(vector,columnNames);
		jScrollPane1 = new JScrollPane(jTable1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CpfLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RgLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(RecemAddLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(SaveButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(CancelButton)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(EnderecoLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(EnderecoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(CellLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CellTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LimiteLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LimiteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(NomeLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(NomeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(NomeLabel)
                                        .addComponent(NomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(13, 13, 13)
                                            .addComponent(CpfLabel))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(RgLabel))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(RgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(CpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(EnderecoLabel))
                        .addComponent(EnderecoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CellLabel)
                            .addComponent(LimiteLabel))
                        .addComponent(CellTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LimiteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CancelButton)
                        .addComponent(SaveButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RecemAddLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23))
        		 );
            
            
           
    }     
    
    
    private void Cad_Cliente() {
    	
    	
    }
    
    private boolean Validate_Cad() {
    
    	if (NomeTextField.getText() == null || NomeTextField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Nome", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			NomeTextField.requestFocus();
			return false;
    	}
    	if (CpfTextField.getText() == null || CpfTextField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Cpf", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			CpfTextField.requestFocus();
			return false;
    	}
    	if (RgTextField.getText() == null || RgTextField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Rg", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			RgTextField.requestFocus();
			return false;
    	}
    	if (EnderecoTextField.getText() == null || EnderecoTextField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Endere�o", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			EnderecoTextField.requestFocus();
			return false;
    	}
    	if (CellTextField.getText() == null || CellTextField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Cell", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			CellTextField.requestFocus();
			return false;
    	}
    	if (LimiteTextField.getText() == null || LimiteTextField.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, preencha o Limite", "Campo vazio", JOptionPane.WARNING_MESSAGE);
			LimiteTextField.requestFocus();
			return false;
    	}
    	
    	return true;
    }
    
    private void Clear_cad() {
    	NomeTextField.setText(null);
    	CpfTextField.setText(null);
    	RgTextField.setText(null);
    	EnderecoTextField.setText(null);
    	CellTextField.setText(null);
    	LimiteTextField.setText(null);
    }
    
    public void Up_Data_Table() {
    	DefaultTableModel tablemodel_Cadastrados = (DefaultTableModel) jTable1.getModel();
    	tablemodel_Cadastrados.setRowCount(0);
    	
    	
    	
    }
    
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel CellLabel;
    private java.awt.TextField CellTextField;
    private javax.swing.JLabel CpfLabel;
    private java.awt.TextField CpfTextField;
    private javax.swing.JLabel EnderecoLabel;
    private java.awt.TextField EnderecoTextField;
    private javax.swing.JLabel LimiteLabel;
    private java.awt.TextField LimiteTextField;
    private javax.swing.JLabel NomeLabel;
    private java.awt.TextField NomeTextField;
    private javax.swing.JLabel RecemAddLabel;
    private javax.swing.JLabel RgLabel;
    private java.awt.TextField RgTextField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;   

    
}
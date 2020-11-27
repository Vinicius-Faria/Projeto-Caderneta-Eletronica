 package mecanica.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MecanicaFrame extends JFrame {

	//botao 1 : Logo Mecanica	 
	//botao 2 : AddClientes		 OK
	//botao 3 : AddProdutos		 OK
	//botao 4 : AddForcedor		 Ok
	//botao 5 : AddFuncionarios  OK
	//botao 6 : Boletos e Vales  OK
	//botao 7 : Ordem de Serviço OK
	//botao 8 : Caixa
	//botao 9 : Contas Receber	 
	//botao 10: Agendamento		 OK
	//botao 11: Relatorio
	
	private JPanel contentPane;
	private JPanel centerPanel;
	private JPanel Tela_Cadastro_Cliente;
	private JPanel Tela_Cadastro_Produto;
	private JPanel Tela_Contas_Pagar_E_Vale;
	private JPanel Tela_Cadastro_Fornecedor;
	private JPanel Tela_Ordem_Servico;
	private JPanel Tela_cadastro_Funcionarios;
	private JPanel Tela_Agendamento;
	private JPanel Tela_Venda;
	private JPanel Tela_Cliente_receber_valor_marcado;
	private JPanel Tela_Informações;
	
	public MecanicaFrame() throws SQLException {
		setSize(1920, 1080);
		setTitle("MECANICA E AUTO PEÇAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(true);
		setIcon();
		initialize();
	}
	
	public void setIcon(){
			setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/mechanic.png")));
		}
	
	private void initialize() throws SQLException {		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		Tela_Cadastro_Cliente = new Tela_Cadastro_Cliente();
		Tela_Cadastro_Produto = new Tela_Cadastro_Produto();
		Tela_Contas_Pagar_E_Vale = new Tela_Contas_Pagar_E_Vale();
		Tela_Cadastro_Fornecedor = new Tela_Cadastro_Fornecedor();	
		Tela_Ordem_Servico = new Tela_Ordem_Servico();
		Tela_cadastro_Funcionarios = new Tela_cadastro_Funcionarios();
		Tela_Agendamento = new Tela_Agendamento();
		Tela_Venda = new Tela_Venda();
		Tela_Cliente_receber_valor_marcado = new Tela_Cliente_receber_valor_marcado();
		Tela_Informações = new Tela_Informações();
		
		createNorthPanel();
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Color.WHITE);
		contentPane.add(centerPanel, BorderLayout.CENTER);
	}
	
	private void createNorthPanel() {
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(1920, 80));
		northPanel.setBackground(new Color(45,173,199));
		
		JButton logoMecanicaButton = new JButton();
		logoMecanicaButton.setPreferredSize(new Dimension(100, 70));
		logoMecanicaButton.setToolTipText("MECANICA E AUTO-PEÇAS");
		ImageIcon image1 = new ImageIcon(getClass().getResource("/logoMecanica.png"));
		logoMecanicaButton.setIcon(image1);
		logoMecanicaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_Informações);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Informações)Tela_Informações).conta_clientes();
				((mecanica.frame.Tela_Informações)Tela_Informações).Conta_Prd();
			}
		});
			
		northPanel.add(logoMecanicaButton);
		
		JButton addClientesButton = new JButton();
		addClientesButton.setPreferredSize(new Dimension(60,60));
		addClientesButton.setToolTipText("Adicionar Clientes");
		ImageIcon image2 = new ImageIcon(getClass().getResource("/addCliente.png"));
		addClientesButton.setIcon(image2);
		addClientesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_Cadastro_Cliente);
				//Tela_Cadastro_Cliente.setBackground(Color.WHITE);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Cadastro_Cliente)Tela_Cadastro_Cliente).Update_Estado();
				((mecanica.frame.Tela_Cadastro_Cliente)Tela_Cadastro_Cliente).update_tabela();
				((mecanica.frame.Tela_Cadastro_Cliente)Tela_Cadastro_Cliente).update_Editar_Combo();
				((mecanica.frame.Tela_Cadastro_Cliente)Tela_Cadastro_Cliente).update_Combo_placa();
			}
		});
			
		northPanel.add(addClientesButton);
		
		JButton addProdutoButton = new JButton();
		addProdutoButton.setPreferredSize(new Dimension(60, 60));
		addProdutoButton.setToolTipText("Adicionar Produtos");
		ImageIcon image3 = new ImageIcon(getClass().getResource("/addProduto.png"));
		addProdutoButton.setIcon(image3);
		addProdutoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
			    centerPanel.add(Tela_Cadastro_Produto);
				//Tela_Cadastro_Produto.setBackground(Color.green);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Cadastro_Produto) Tela_Cadastro_Produto).Update_Combo_fornecedor();
				((mecanica.frame.Tela_Cadastro_Produto) Tela_Cadastro_Produto).data();
				((mecanica.frame.Tela_Cadastro_Produto) Tela_Cadastro_Produto).update_tabela();
				
			}
		});
		
		JButton addFornecedorButton = new JButton();
		addFornecedorButton.setPreferredSize(new Dimension(60, 60));
		addFornecedorButton.setToolTipText("Adicionar Fornecedor");
		ImageIcon image4 = new ImageIcon(getClass().getResource("/fornecedor.png"));
		addFornecedorButton.setIcon(image4);
		addFornecedorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_Cadastro_Fornecedor);
				//Tela_Cadastro_Fornecedor.setBackground(Color.WHITE);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Cadastro_Fornecedor)Tela_Cadastro_Fornecedor).Update_Estado();
				((mecanica.frame.Tela_Cadastro_Fornecedor)Tela_Cadastro_Fornecedor).Update_Table_Fornecedor();
			}
		});
		
		northPanel.add(addProdutoButton);
		
		JButton addFuncionarioButton = new JButton();
		addFuncionarioButton.setPreferredSize(new Dimension(60,60));
		addFuncionarioButton.setToolTipText("Adicionar Funcionario");
		ImageIcon image5 = new ImageIcon(getClass().getResource("/funcionario.png"));
		addFuncionarioButton.setIcon(image5);
		addFuncionarioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_cadastro_Funcionarios);
				//Tela_cadastro_Funcionarios.setBackground(Color.WHITE);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_cadastro_Funcionarios)Tela_cadastro_Funcionarios).update_tabela();
			}
		});
		northPanel.add(addFuncionarioButton);
		
		
		northPanel.add(addFornecedorButton);
		
		JButton boletosAndValesButton = new JButton();
		boletosAndValesButton.setPreferredSize(new Dimension(60, 60));
		boletosAndValesButton.setToolTipText("Boletos e Vale");
		ImageIcon image6 = new ImageIcon(getClass().getResource("/boleto.png"));
		boletosAndValesButton.setIcon(image6);
		boletosAndValesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_Contas_Pagar_E_Vale);
				//Tela_Contas_Pagar_E_Vale.setBackground(Color.WHITE);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Contas_Pagar_E_Vale) Tela_Contas_Pagar_E_Vale).data();
				((mecanica.frame.Tela_Contas_Pagar_E_Vale) Tela_Contas_Pagar_E_Vale).update_Table();
				((mecanica.frame.Tela_Contas_Pagar_E_Vale) Tela_Contas_Pagar_E_Vale).soma_boletos();
				((mecanica.frame.Tela_Contas_Pagar_E_Vale) Tela_Contas_Pagar_E_Vale).Update_combo_vale();
				((mecanica.frame.Tela_Contas_Pagar_E_Vale) Tela_Contas_Pagar_E_Vale).update_Table_Vale();
			}
		});
		northPanel.add(boletosAndValesButton);
		
		JButton ordemServicoButton = new JButton();
		ordemServicoButton.setPreferredSize(new Dimension(60, 60));
		ordemServicoButton.setToolTipText("Ordem de Serviço");
		ImageIcon image7 = new ImageIcon(getClass().getResource("/ordemServico.png"));
		ordemServicoButton.setIcon(image7);
		ordemServicoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_Ordem_Servico);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Ordem_Servico)Tela_Ordem_Servico).data();
				((mecanica.frame.Tela_Ordem_Servico)Tela_Ordem_Servico).Update_Combo_Cliente();
				((mecanica.frame.Tela_Ordem_Servico)Tela_Ordem_Servico).Update_Combo_Produto();
				((mecanica.frame.Tela_Ordem_Servico)Tela_Ordem_Servico).update_combo_funcionarios();
				((mecanica.frame.Tela_Ordem_Servico)Tela_Ordem_Servico).update_tabela_Servico_Aberto();
				((mecanica.frame.Tela_Ordem_Servico)Tela_Ordem_Servico).Insert_Cod();
			}
		});
		northPanel.add(ordemServicoButton);
		
		JButton caixaButton = new JButton();
		caixaButton.setPreferredSize(new Dimension(60, 60));
		caixaButton.setToolTipText("Vendas");
		ImageIcon image8 = new ImageIcon(getClass().getResource("/caixaRegistradora.png"));
		caixaButton.setIcon(image8);
		caixaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_Venda);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Venda)Tela_Venda).data();
				((mecanica.frame.Tela_Venda)Tela_Venda).Update_combo_cliente();
				((mecanica.frame.Tela_Venda)Tela_Venda).Update_combo_produto();
				((mecanica.frame.Tela_Venda)Tela_Venda).seleciona_Num_venda();
			}
		
		});
		northPanel.add(caixaButton);
		
		JButton cliente_Receber_Button = new JButton();
		cliente_Receber_Button.setPreferredSize(new Dimension(60, 60));
		cliente_Receber_Button.setToolTipText("Marcados");
		ImageIcon image9 = new ImageIcon(getClass().getResource("/taxes (1).png"));
		cliente_Receber_Button.setIcon(image9);
		cliente_Receber_Button.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_Cliente_receber_valor_marcado);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Venda) Tela_Venda).seleciona_Num_venda();
			}
		});
		northPanel.add(cliente_Receber_Button);
		
		JButton agendamentoButton = new JButton();
		agendamentoButton.setPreferredSize(new Dimension(60,60));
		agendamentoButton.setToolTipText("Agendamentos");
		ImageIcon image10 = new ImageIcon(getClass().getResource("/agendamentos.png"));
		agendamentoButton.setIcon(image10);
		agendamentoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.removeAll();
				centerPanel.add(Tela_Agendamento);
				//Tela_Agendamento.setBackground(Color.WHITE);
				centerPanel.revalidate();
				MecanicaFrame.this.repaint();
				((mecanica.frame.Tela_Agendamento)Tela_Agendamento).data();
				((mecanica.frame.Tela_Agendamento) Tela_Agendamento).update_tabela();
			}
		});
		northPanel.add(agendamentoButton);
		
		JButton relatorioButton = new JButton();
		relatorioButton.setPreferredSize(new Dimension(60, 60));
		relatorioButton.setToolTipText("Relatório");
		ImageIcon image11 = new ImageIcon(getClass().getResource("/relatorio.png"));
		relatorioButton.setIcon(image11);
		/*addMedicamentoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listPanel3.updateTable();
				centerPanel.removeAll();
				centerPanel.add(addPanel3);
				centerPanel.revalidate();
				FarmaciaFrame.this.repaint();
			}
		});*/
		northPanel.add(relatorioButton);
		
		contentPane.add(northPanel, BorderLayout.NORTH);
	}
	
	
	
}
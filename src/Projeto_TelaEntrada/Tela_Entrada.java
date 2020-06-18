package Projeto_TelaEntrada;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.print.DocFlavor.URL;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Tela_Entrada extends JFrame {
	
	
	private JPanel contentPane;
	private JPanel centerPane;
	private Cad_Cliente cadastro_de_cliente;
	private Add_Conta_Cliente add_conta;
	private Cadastros_Clientes cad_clientes;
	private Tela_Menu tela_menu;
	private Tela_relatorio tela_relatorio;
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Tela_Entrada() throws SQLException {
		setSize(750	, 400);
		setTitle("Controle De Venda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initialize();
	}
	
	private void initialize() throws SQLException {
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		cadastro_de_cliente = new Cad_Cliente();
		add_conta = new Add_Conta_Cliente();
		cad_clientes = new Cadastros_Clientes();
		tela_menu = new Tela_Menu();
		tela_relatorio = new Tela_relatorio();
		
		Painel_de_comando();
		centerPane = new JPanel();
		centerPane.setLayout(new BorderLayout());
		contentPane.add(centerPane, BorderLayout.CENTER);
		
	}
	
	private void Painel_de_comando() {
		
		JPanel Menu_panel = new JPanel();
		Menu_panel.setLayout(new GridBagLayout());
		Menu_panel.setPreferredSize(new Dimension(200,100));
		Menu_panel.setBackground(Color.orange);
		
		JLabel Menu_Principal_Escrita = new JLabel("Menu");
		Menu_Principal_Escrita.setFont(new Font("Times Row Name", Font.ITALIC, 19));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets = new Insets(5, 5, 5, 5);
		Menu_panel.add(Menu_Principal_Escrita,gbc);
		

		JButton Menu_Principal = new JButton("FINANÇAS");
		Menu_Principal.setBackground(Color.WHITE);
		ImageIcon image6 = new ImageIcon(getClass().getResource("/informações.png"));
		Menu_Principal.setIcon(image6);
		Menu_Principal.setPreferredSize(new Dimension(150, 35));
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.insets = new Insets(5, 5, 5, 5);
		Menu_Principal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPane.removeAll();
				centerPane.add(tela_menu);
				centerPane.revalidate();
				Tela_Entrada.this.repaint();
				tela_menu.atualiza_panel();
				
			}
		});
		Menu_panel.add(Menu_Principal,gbc);
		
		//---------------------------------------------------------------------------
		
		JButton cadastro_Button = new JButton("Cad Cliente");
		cadastro_Button.setPreferredSize(new Dimension(150, 35));
		cadastro_Button.setBackground(Color.WHITE);
		gbc.gridy=2;
		gbc.insets = new Insets(5, 5, 5, 5);
		ImageIcon image1 = new ImageIcon(getClass().getResource("/Cliente_01.png"));
		cadastro_Button.setIcon(image1);
		cadastro_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPane.removeAll();
				centerPane.add(cadastro_de_cliente);
				centerPane.revalidate();
				Tela_Entrada.this.repaint();
				cadastro_de_cliente.Up_Data_Table();
				
			}
		});
		Menu_panel.add(cadastro_Button, gbc);
		//---------------------------------------------------------------------------
		
		JButton Marcar_Button = new JButton("Add / Pagar");
		Marcar_Button.setBackground(Color.WHITE);
		Marcar_Button.setPreferredSize(new Dimension(150, 35));
		gbc.gridy=3;
		ImageIcon image2 = new ImageIcon(getClass().getResource("/give-money.png"));
		Marcar_Button.setIcon(image2);
		Marcar_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPane.removeAll();
				centerPane.add(add_conta);
				centerPane.revalidate();
				Tela_Entrada.this.repaint();
				add_conta.updateCombo();
			}
		});
		Menu_panel.add(Marcar_Button,gbc);
		//---------------------------------------------------------------------------
		
		JLabel Menu_Espaço = new JLabel("Relatório");
		Menu_Espaço.setFont(new Font("Times Row Name", Font.ITALIC, 19));
		gbc.gridy=4;
		Menu_panel.add(Menu_Espaço,gbc);
		//---------------------------------------------------------------------------
		
		JButton Relatorio_Diario_Button = new JButton("Vendas");
		Relatorio_Diario_Button.setBackground(Color.WHITE);
		Relatorio_Diario_Button.setPreferredSize(new Dimension(150, 35));
		gbc.gridy=5;
		ImageIcon image3 = new ImageIcon(getClass().getResource("/signing-a-contract.png"));
		Relatorio_Diario_Button.setIcon(image3);
		Relatorio_Diario_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPane.removeAll();
				centerPane.add(tela_relatorio);
				centerPane.revalidate();
				Tela_Entrada.this.repaint();
				tela_relatorio.updateCombo();
				tela_relatorio.clear();
			}
		});
		Menu_panel.add(Relatorio_Diario_Button,gbc);
		//---------------------------------------------------------------------------
		
		
		JLabel cadastros = new JLabel("Cliente");
		cadastros.setFont(new Font("Times Row Name", Font.ITALIC, 19));
		gbc.gridy=7;
		Menu_panel.add(cadastros, gbc);
		//---------------------------------------------------------------------------
		
		JButton Ver_cadastros = new JButton("Cadastrados");
		Ver_cadastros.setBackground(Color.WHITE);
		Ver_cadastros.setPreferredSize(new Dimension(150, 35));
		gbc.gridy=8;
		ImageIcon image5 = new ImageIcon(getClass().getResource("/Users.png"));
		Ver_cadastros.setIcon(image5);
		Ver_cadastros.addActionListener(new ActionListener() {	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPane.removeAll();
				centerPane.add(cad_clientes);
				centerPane.revalidate();
				Tela_Entrada.this.repaint();
				cad_clientes.UpdateCombo();
			}
		});
		Menu_panel.add(Ver_cadastros,gbc);
		
		JLabel Menu_Versao = new JLabel("Versão 1.0.3");
		Menu_Versao.setFont(new Font("Times Row Name", Font.CENTER_BASELINE, 10));
		gbc.gridy=9;
		Menu_panel.add(Menu_Versao,gbc);
				
		contentPane.add(Menu_panel, BorderLayout.WEST);
		
	}

}
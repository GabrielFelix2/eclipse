
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfaceGrafica extends JFrame {
	
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblIdade;
	private JLabel lblRa;
	
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtIdade;
	private JTextField txtRa;
	
	private JButton btnInserir;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	
	private JTable tabela;
	
	private Container tela;
	
	final DefaultTableModel modelo;
	
	public CRUD controle = new CRUD();
	
	public InterfaceGrafica() {
		
		//configuracao da JFrame
		setSize(335 , 500);
		setTitle("Cadastro de Aluno");
		
		tela = getContentPane();
		tela.setLayout(null);
		
		//configuracao label = rotulos
		lblCodigo = new JLabel("Codigo");
		lblNome = new JLabel("Nome");
		lblIdade = new JLabel("Idade");
		lblRa = new JLabel("RA");
		
		//configuracao de tamanho de label
		lblCodigo.setBounds(10, 10, 80, 25);
		lblNome.setBounds(10, 45, 80, 25);
		lblIdade.setBounds(10, 80, 80, 25);
		lblRa.setBounds(10, 115, 80, 25);
		
		//incluir no container
		tela.add(lblCodigo);
		tela.add(lblNome);
		tela.add(lblIdade);
		tela.add(lblRa);
		
		//configuracao dos textfields
		txtCodigo = new JTextField();
		txtNome = new JTextField();
		txtIdade = new JTextField();
		txtRa = new JTextField();
		
		//configuracao do tamanho
		txtCodigo.setBounds(90, 10, 150, 25);
		txtNome.setBounds(90, 45, 150, 25);
		txtIdade.setBounds(90, 80, 150, 25);
		txtRa.setBounds(90, 115, 150, 25);
		
		//incluir no container
		tela.add(txtCodigo);
		tela.add(txtNome);
		tela.add(txtIdade);
		tela.add(txtRa);
		
		//configuracao do botao
		btnInserir = new JButton("Inserir");
		btnAtualizar = new JButton("Atualizar");
		btnExcluir = new JButton("Excluir");
		
		//configuracao de tamanho
		btnInserir.setBounds(10, 170, 100, 50);
		btnAtualizar.setBounds(110, 170, 100, 50);
		btnExcluir.setBounds(210, 170, 100, 50);
		
		//incluir no container
		tela.add(btnInserir);
		tela.add(btnAtualizar);
		tela.add(btnExcluir);
		
		//configuracao da tabela
		modelo = new DefaultTableModel();
		
		tabela = new JTable(modelo);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("RA");



		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(10, 240, 300, 200);

		tela.add(painel);

		carregarDados();
		

		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnInserir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.cadastrarAluno(txtNome.getText(), Integer.parseInt(txtIdade.getText()), txtRa.getText());
				
				carregarDados();
				
			}
		});
		
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.atualizarAluno(Integer.parseInt(txtCodigo.getText()),txtNome.getText(), Integer.parseInt(txtIdade.getText()), txtRa.getText());
			
				carregarDados();
			}
			
			
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.excluirAluno(Integer.parseInt(txtCodigo.getText()));
				
				carregarDados();
			}
			
		});
	
	
		}

		private void carregarDados() {
			//preencher dps
			modelo.setNumRows(0);
			try {
				ResultSet dados = controle.carregarAlunos();
				while(dados.next()) {
					int id = dados.getInt("id_aluno");
					String nome = dados.getString("nome");
					int idade = dados.getInt("idade");
					String ra = dados.getString("ra");
					
					modelo.addRow(new Object[] {new Integer(id),
								nome, new Integer(idade), ra});
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		public static void main(String[] args) {

		InterfaceGrafica tela1 = new InterfaceGrafica();
		}
	
}


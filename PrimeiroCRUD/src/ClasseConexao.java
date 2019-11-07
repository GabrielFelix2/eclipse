import java.sql.Connection;
import java.sql.DriverManager;

public class ClasseConexao {
	
	
	private Connection conexao;
	private String URLBD = "jdbc:mysql://localhost:3307/cadastro"; //?useSSL=false$serverTimezone=UTC";
	//private String URLBD = "jdbc:mysql://localhost:3307/cadastro?useSSL=false$serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "";
	
	public ClasseConexao() {
		try {
			conexao = DriverManager.getConnection(URLBD, usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conexao;
	}

	public Connection getConexao() {
		// TODO Auto-generated method stub
		return conexao;
	}
/*
 * Criar um banco de dados com o nome: cadastro
 * Uma tabela com o nome: aluno
 * Campos: id_aluno (incremental-primary key)
 * nome (varchar(45))
 * idade int
 * ra (varchar (45))
 * 
 * 
 */
}

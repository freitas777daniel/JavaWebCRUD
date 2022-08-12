package conexao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {

	
	
	//Essa é a string de conexão com o banco de daddos.
	public static Connection getConnection() {
		
		String url;
		String usuario;
		String senha;
		Connection con = null;
		
		url     = "jdbc:postgresql://localhost:5432/Treinamento";
		usuario = "postgres";
		senha   = "123456";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,usuario,senha);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	//---------------------------------------------------------------
	
}

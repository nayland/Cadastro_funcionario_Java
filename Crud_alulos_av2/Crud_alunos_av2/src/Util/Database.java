package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static String status = "N�o conectou...";

	// M�todo Construtor da Classe//
	public Database() {
		
}

//M�todo de Conex�o//

public static Connection ConexaoDB()  throws Exception {

   //Connection conn = null;          
   try {

		String driverDB = "com.mysql.jdbc.Driver";                        
		Class.forName(driverDB);
		
	   String server = "localhost:3306"; 
	   String tabela = "aluno";     
	   String url = "jdbc:mysql://" + server + "/" + tabela;
	
	   String nome = "root";        
	   String senha = "root"; 
	
	   //Gerenciado da minha conexao 
	   Connection conn = DriverManager.getConnection(url, nome, senha);
	
	   if (conn != null) {
	       status = ("STATUS--->Conectado com sucesso!");
	   } else {
	       status = ("STATUS--->N�o foi possivel realizar conex�o");
	   }
	   return conn;

   		} catch (ClassNotFoundException e) {  
   			System.out.println("O driver expecificado nao foi encontrado.");
   			return null;
   		} catch (SQLException e) {

   			
   			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
   			return null;
   		}
}

//M�todo que retorna o status da sua conex�o//

	public static String statusConection() {
		return status;
	}

	//M�todo que fecha sua conex�o//
	public static boolean FecharConexao() throws Exception {
		try {

			Database.ConexaoDB().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	//M�todo que reinicia sua conex�o//
	public static java.sql.Connection ReiniciarConexao() throws Exception {
		FecharConexao();
		return Database.ConexaoDB();
	}

}


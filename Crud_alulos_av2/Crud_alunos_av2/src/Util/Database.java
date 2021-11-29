package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static String status = "Não conectou...";

	// Método Construtor da Classe//
	public Database() {
		
}

//Método de Conexão//

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
	       status = ("STATUS--->Não foi possivel realizar conexão");
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

//Método que retorna o status da sua conexão//

	public static String statusConection() {
		return status;
	}

	//Método que fecha sua conexão//
	public static boolean FecharConexao() throws Exception {
		try {

			Database.ConexaoDB().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	//Método que reinicia sua conexão//
	public static java.sql.Connection ReiniciarConexao() throws Exception {
		FecharConexao();
		return Database.ConexaoDB();
	}

}


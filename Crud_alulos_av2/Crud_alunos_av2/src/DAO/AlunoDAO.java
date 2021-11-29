package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Util.Database;

public class AlunoDAO {
	
	public void inserir (Aluno aluno) throws Exception {
		Connection connection = Database.ConexaoDB();
		String sql = "INSERT INTO aluno (nome, email, cpf) VALUES (' " + aluno.getNome() + "','" + aluno.getEmail() + "','" + aluno.getCpf() + "')";
		
		Statement stmt;
		try {
			
			stmt = connection.createStatement();
			stmt.execute(sql);  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		Database.FecharConexao();
	}
	
	public void remover (Aluno aluno) throws Exception {
		Connection connection = Database.ConexaoDB();
		String sql = "delete from aluno where codigo="+ aluno.getCodigo();
		
		Statement stmt;
		try {
			
			stmt = connection.createStatement();
			stmt.execute(sql);  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
		Database.FecharConexao();
	}
	
	public void atualizar (Aluno aluno) throws Exception {
		Connection connection = Database.ConexaoDB();
		String sql = "update aluno set nome='"+ aluno.getNome() +"', email='" + aluno.getEmail() + "', cpf='" + aluno.getCpf() + "' where codigo=" + aluno.getCodigo();
		
		Statement stmt;
		
		try {	
			stmt = connection.createStatement();
			stmt.execute(sql);  
		} catch (SQLException e) {
			e.printStackTrace();
		}
	       
		Database.FecharConexao();
	}
	
	public List<Aluno> listar () throws Exception {
		Connection connection = Database.ConexaoDB();
		List<Aluno> alunos = new ArrayList<Aluno>();
		Statement stmt;
		try {
			
			String sql = "select * from aluno";
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);  
			
			while (rs.next()) {
				
				Aluno aluno = new Aluno();
				aluno.setCodigo(rs.getString("codigo"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setCpf(rs.getString("cpf"));
				alunos.add(aluno);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	       
		Database.FecharConexao();
		return alunos;
	}
	
	public Aluno getAluno (Aluno aluno) throws Exception {
		Aluno alunoRetorno = new Aluno();
		Connection connection = Database.ConexaoDB();
		Statement stmt;
		
		try {
			String sql = "select * from aluno WHERE codigo=" + aluno.getCodigo();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);  
			
			if (rs.next()) {
				
				alunoRetorno.setCodigo(rs.getString("codigo"));
				alunoRetorno.setNome(rs.getString("nome"));
				alunoRetorno.setEmail(rs.getString("email"));
				alunoRetorno.setCpf(rs.getString("cpf"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Database.FecharConexao();	
		return alunoRetorno;
	}
}

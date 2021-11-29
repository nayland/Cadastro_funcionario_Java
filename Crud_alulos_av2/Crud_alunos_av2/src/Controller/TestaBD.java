package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.AlunoDAO;
import Model.Aluno;

public class TestaBD {

	public static void main(String[] args) throws Exception {
		
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = new Aluno();
		
		int resp;
		String entrada;
		
		do {
			entrada = JOptionPane.showInputDialog("Cadastro de Alunos Express: \n\n"
					+ "1- Inserir usuário \n"
					+ "2- Alterar usuário \n"
					+ "3- Remover usuário \n"
					+ "4- Pesquisar usuário \n"
					+ "5- Listar usuário \n"
					+ "0- Sair \n\n"
					+ "R: ");
			resp = Integer.parseInt(entrada);
			
			
			if(resp != 0) {
				
				switch (resp){
				
				
					//incluir
					case 1:
						
						entrada = JOptionPane.showInputDialog("Codigo: ");
						aluno.setCodigo(entrada);
						
						entrada = JOptionPane.showInputDialog("Nome: ");
						aluno.setNome(entrada);
						
						entrada = JOptionPane.showInputDialog("Email: ");
						aluno.setEmail(entrada);
						
						entrada = JOptionPane.showInputDialog("CPF: ");
						aluno.setCpf(entrada);

						alunoDAO.inserir(aluno);
						
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
					break;
					
					
					
					//alterar
					case 2:
						
						entrada = JOptionPane.showInputDialog("informe o n° id que deseja alterar: ");
						aluno.setCodigo(entrada);
						
						entrada = JOptionPane.showInputDialog("Nome: ");
						aluno.setNome(entrada);
						
						entrada = JOptionPane.showInputDialog("Email: ");
						aluno.setEmail(entrada);
						
						entrada = JOptionPane.showInputDialog("Cpf: ");
						aluno.setCpf(entrada);
						
						
						alunoDAO.atualizar(aluno);
						JOptionPane.showMessageDialog(null, "Alterado com sucesso");
						break;
					
						
					//deletar
					case 3:
						entrada = JOptionPane.showInputDialog("informe o n° id que deseja remover: ");
						aluno.setCodigo(entrada);
						
						alunoDAO.remover(aluno);
						
						JOptionPane.showMessageDialog(null, "Excluído com sucesso");
					break;
					
					
					//pesquisar
					case 4:
						entrada = JOptionPane.showInputDialog("informe o codigo que deseja pesquisar: ");
						aluno.setCodigo(entrada);
						
						Aluno retorna = alunoDAO.getAluno(aluno);
						
					
					JOptionPane.showMessageDialog(null, "*1 Aluno(s) encontrado(s)\n\n"
								+ "ID: " + retorna.getCodigo() + "\n"
								+ "Nome: " + retorna.getNome() + "\n"
								+ "Email: " +retorna.getEmail() + "\n"
								+ "Cpf: "	+ retorna.getCpf());
							
					break;
					
					
					
					//read
					case 5:
						List<Aluno> alunos = alunoDAO.listar();
						
						for (Aluno alunoLista : alunos) {
							System.out.println("ID: " + alunoLista.getCodigo());
							System.out.println("Nome: " + alunoLista.getNome());
							System.out.println("Email: " + alunoLista.getEmail());
							System.out.println("Cpf: " + alunoLista.getCpf());
							System.out.printf("--------------------------- \n\n");
						}
					break;
				
				}
				
			}
			
		}while(resp != 0);
		
	}

}

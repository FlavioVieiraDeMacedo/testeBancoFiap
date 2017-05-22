package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.ConnectionFactory;
import Model.Livro;

public class LivroDAO {
	
	Connection conn = null;
	
	public LivroDAO(){
		
		try{
			conn = ConnectionFactory.getConnection();
		}
		catch(SQLException ex){ }
	}
	public void insert(Livro f){

		String sql = "INSERT INTO Livro(ID,NOME, DESCRICAO) VALUES(?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, 1);
			stmt.setString(2, f.getNome());
			stmt.setString(3, f.getDescricao());
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}
		
	}
	public void delete(String cpf){

		String sql = "DELETE FROM FUNCIONARIOS WHERE ID = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, cpf);
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}
		
	}
	public void udpate(Livro f){

		String sql = "UPDATE FUNCIONARIOS SET NOME = ?, DESCRICAO = ? WHERE ID = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getDescricao());
					
			stmt.executeUpdate();

		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}
	}
	public List<Livro> getAll(){

		String sql = "SELECT * FROM Livros";
		
		List<Livro> livros = new ArrayList<Livro>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
					
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Livro f = new Livro();
				
				f.setDescricao("DESCRICAO");
				
				livros.add(f);
			}
			
		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}

		return livros;		
	}
	/*
	public List<Livro> getLivroByPk(String id){

		String sql = "SELECT * FROM FUNCIONARIOS WHERE ID = ?";
		
		List<Livro> livros = new ArrayList<Livro>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);		
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Livro f = new Livro();
				
				f.setNome(rs.getString("CPF"));
				
				livros.add(f);
			}
			
		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}
		return livros;
	}
	public List<Livro> getFuncionarioByNome(String nome){

		String sql = "SELECT * FROM FUNCIONARIOS WHERE NOME LIKE ?";
		
		List<Livro> livros = new ArrayList<Livro>();
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");		
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Livro f = new Livro();
				
				f.setIsbn(rs.getString("CPF"));
				
				livros.add(f);
			}
			
		}
		catch(SQLException ex){ 
			
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) { }
		}

		return livros;		
	}*/
}

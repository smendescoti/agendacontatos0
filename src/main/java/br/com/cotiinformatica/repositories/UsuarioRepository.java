package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class UsuarioRepository {

	// m�todo para inserir um usu�rio no banco de dados
	public void create(Usuario usuario) throws Exception {

		// abrindo conex�o com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// executando o comando SQL
		PreparedStatement statement = connection
				.prepareStatement("insert into usuario(nome, email, senha) values(?, ?, md5(?))");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.execute();

		// fechando a conex�o
		connection.close();
	}
	
	//m�todo para atualizar um usu�rio no banco de dados
	public void update(Usuario usuario) throws Exception {
		
		//abrindo conex�o com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//executando o comando SQL
		PreparedStatement statement = connection
				.prepareStatement("update usuario set nome=?, email=?, senha=md5(?) where idusuario=?");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.setInt(4, usuario.getIdUsuario());
		statement.execute();
		
		//fechando a conex�o
		connection.close();
	}
	
	//m�todo para consultar 1 usu�rio no banco de dados atrav�s do email
	public Usuario findByEmail(String email) throws Exception {
		
		//abrindo conex�o com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//executando o comando SQL
		PreparedStatement statement = connection
				.prepareStatement("select * from usuario where email = ?");
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();
		
		Usuario usuario = null; //vazio
		
		//verificando se algum usu�rio foi encontrado
		if(resultSet.next()) {
			
			usuario = new Usuario();
			
			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));
		}
		
		connection.close(); //fechando a conex�o
		return usuario;
	}	
	
	//m�todo para consultar 1 usu�rio no banco de dados atrav�s do email e da senha
	public Usuario findByEmailAndSenha(String email, String senha) throws Exception {
		
		//abrido conex�o com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		//executando o comando SQL
		PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where email=? and senha=md5(?)");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, senha);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Usuario usuario = null;
		
		//verificando se algum registro foi encontrado
		if(resultSet.next()) {
			
			usuario = new Usuario();
			
			usuario.setIdUsuario(resultSet.getInt("idusuario"));
			usuario.setNome(resultSet.getString("nome"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setSenha(resultSet.getString("senha"));			
		}
		
		connection.close(); //fechando a conex�o
		return usuario;
	}

}









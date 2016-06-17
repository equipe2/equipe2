package gerenciador.dao;

import gerenciador.entidades.Cadastro;
import gerenciador.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roberto Alencar
 */
public class CadastroDao {

    private Connection connection;

    public CadastroDao() {

	try {
	    this.connection = new ConnectionFactory().getConnection();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public void salvar(Cadastro cadastro) {

	try {
	    String sql = "INSERT INTO usuario (login, nome, email, senha) VALUES (?,?,?,?)";
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setString(1, cadastro.getLogin());
	    stmt.setString(2, cadastro.getNome());
	    stmt.setString(3, cadastro.getEmail());
	    stmt.setString(4, cadastro.getSenha());
	    stmt.execute();
	    stmt.close();
	    connection.close();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public void alterar(Cadastro cadastro) {

	String sql = "UPDATE usuario SET login = ? , nome = ? , email = ? , senha = ? WHERE login = ?";

	try {

	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setString(1, cadastro.getLogin());
	    stmt.setString(2, cadastro.getNome());
	    stmt.setString(3, cadastro.getEmail());
	    stmt.setString(4, cadastro.getSenha());
	    
	    stmt.execute();
	    stmt.close();
	    connection.close();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public void remover(Cadastro cadastro) {

	try {
	    PreparedStatement stmt = connection.prepareStatement("DELETE FROM usuario WHERE login = ?");
	    stmt.setString(1, cadastro.getLogin());
	    stmt.execute();
	    stmt.close();
	    connection.close();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public Cadastro buscarPorLogin(String login) {

	try {
	    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE login = ?");
	    stmt.setString(1, login);
	    ResultSet rs = stmt.executeQuery();

	    Cadastro cadastro = null;
	    if (rs.next()) {
	    	cadastro = montarObjeto(rs);
	    }

	    rs.close();
	    stmt.close();
	    connection.close();
	    return cadastro;
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public List<Cadastro> pesquisarCadastro(String login, String nome, String email) {

	try {
	    List<Cadastro> listaCadastro = new ArrayList<Cadastro>();

	    PreparedStatement stmt = this.connection
		    .prepareStatement("SELECT * FROM usuario WHERE login like ? AND nome like ? AND email like ? ORDER BY nome");
	    stmt.setString(1, "%" + login + "%");
	    stmt.setString(1, "%" + nome + "%");
	    stmt.setString(2, "%" + email + "%");

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
	    listaCadastro.add(montarObjeto(rs));
	    }

	    rs.close();
	    stmt.close();
	    connection.close();

	    return listaCadastro;
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public List<Cadastro> getLista() {

	try {
	    List<Cadastro> listaCadastro = new ArrayList<Cadastro>();
	    PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario ORDER BY nome");

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
	    	listaCadastro.add(montarObjeto(rs));
	    }

	    rs.close();
	    stmt.close();
	    connection.close();

	    return listaCadastro;
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    private Cadastro montarObjeto(ResultSet rs) throws SQLException {

	Cadastro cadastro = new Cadastro();
	cadastro.setLogin(rs.getString("login"));
	cadastro.setNome(rs.getString("nome"));
	cadastro.setEmail(rs.getString("email"));
	cadastro.setSenha(rs.getString("senha"));
	return cadastro;
    }
    
    public Cadastro efetuarLogin(String login, String senha) {

    	try {
    	    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE login = ? AND senha = ?");
    	    stmt.setString(1, login);
    	    stmt.setString(2, senha);
    	    ResultSet rs = stmt.executeQuery();

    	    Cadastro cadastro = null;
    	    if (rs.next()) {
    	    	cadastro = montarObjeto(rs);
    	    }

    	    rs.close();
    	    stmt.close();
    	    connection.close();
    	    return cadastro;
    	} catch (SQLException e) {
    	    throw new RuntimeException(e);
    	}
        }
    
}


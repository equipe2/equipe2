package gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.dao.CadastroDao;
import gerenciador.entidades.Cadastro;

/**
 * @author Roberto Alencar
 *
 */
@WebServlet("/AdicionarUsuario")
public class AdicionarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 6535458257943051437L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	// pegando os parâmetros do request
	String login = request.getParameter("login");
	String nome = request.getParameter("nome");
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	String confirmesenha = request.getParameter("confirmesenha");
	
	if(!senha.equals(confirmesenha)){
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Senhas não conferem!");
		out.println("<br /> <a href='adicionarContato.html'> Voltar </a>");
		out.println("</body>");
		out.println("</html>");
	}
	else{
		Cadastro cadastro= new CadastroDao().buscarPorLogin(login);
		
		if (cadastro==null) {
	// monta um objeto contato
	cadastro = new Cadastro();	
	cadastro.setLogin(login);
	cadastro.setNome(nome);
	cadastro.setEmail(email);
	cadastro.setSenha(senha);
	// salva o contato
	CadastroDao dao = new CadastroDao();
	dao.salvar(cadastro);

	// imprime o nome do contato que foi adicionado
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<body>");
	out.println("Contato " + cadastro.getNome() + " Cadastrado com sucesso");
	out.println("<br /> <a href='/salao_tarde'> Início </a>");
	out.println("</body>");
	out.println("</html>");
    }else{
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
    	out.println("<body>");
    	out.println("Login já existente tente outro!");
    	out.println("<br /> <a href='adicionarContato.html'> Voltar </a>");
    	out.println("</body>");
    	out.println("</html>");
    }
}
}
}

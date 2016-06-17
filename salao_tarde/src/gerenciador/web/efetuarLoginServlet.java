package gerenciador.web;

import gerenciador.dao.CadastroDao;
import gerenciador.entidades.Cadastro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/efetuarLogin")
public class efetuarLoginServlet extends HttpServlet {

    private static final long serialVersionUID = -1275748307875519330L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

	Cadastro cadastro= new CadastroDao().efetuarLogin(login, senha);

	if (cadastro==null) {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Usuario ou Senha incorreto");
		out.println("<br /> <a href='/salao_tarde'> Voltar </a>");
		out.println("</body>");
		out.println("</html>");
    }else{
    	PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Usuario " + cadastro.getNome() + " logado com sucesso");
		out.println("<br /> <a href='/salao_tarde'> Início </a>");
		out.println("</body>");
		out.println("</html>");
    }
    }
}

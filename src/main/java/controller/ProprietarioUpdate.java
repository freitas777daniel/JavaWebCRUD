package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProprietarioDao;
import model.Proprietario;

/**
 * Servlet implementation class ProprietarioUpdate
 */
@WebServlet("/ProprietarioUpdate")
public class ProprietarioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProprietarioUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int id = Integer.parseInt(request.getParameter("id"));
		Proprietario proprietario = ProprietarioDao.getRegistroById(id);
		request.setAttribute("proprietario", proprietario);
		request.getRequestDispatcher("/editform.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String cpf_cnpj = request.getParameter("cpf_cnpj");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		Proprietario p = new Proprietario();
		p.setId(id);
		p.setCpf_cnpj(cpf_cnpj);
		p.setNome(nome);
		p.setEndereco(endereco);
		ProprietarioDao.updateProprietario(p);
		response.sendRedirect("index.jsp");
	}

}

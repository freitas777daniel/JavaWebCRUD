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
 * Servlet implementation class ProprietarioListAndCreate
 */
@WebServlet("/ProprietarioListAndCreate")
public class ProprietarioListAndCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProprietarioListAndCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("list", ProprietarioDao.getAllProprietarios());
		request.getRequestDispatcher("/viewproprietarios.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		//cadastrar o proprietario
		Proprietario p = new Proprietario();
		p.setCpf_cnpj(request.getParameter("cpf_cnpj"));
		p.setNome(request.getParameter("nome"));
		p.setEndereco(request.getParameter("endereco"));
		ProprietarioDao.salvarProprietario(p);
		response.sendRedirect("index.jsp");
	}
	
	
	
	

}




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
 * Servlet implementation class ProprietarioDelete
 */
@WebServlet("/ProprietarioDelete")
public class ProprietarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProprietarioDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Proprietario p = new Proprietario();
		p.setId(id);
		ProprietarioDao.deletarProprietario(p);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

	

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VeiculoDao;
import model.Proprietario;
import model.Veiculo;

/**
 * Servlet implementation class VeiculoListAndCreate
 */
@WebServlet("/VeiculoListAndCreate")
public class VeiculoListAndCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeiculoListAndCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setAttribute("list", VeiculoDao.getAllVeiculos());
		request.getRequestDispatcher("/ViewVeiculo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		//cadastrar o veiculo
				Veiculo v = new Veiculo();
				v.setPlaca(request.getParameter("placa"));
				v.setRenavam(request.getParameter("renavam"));
				
				Proprietario p = new Proprietario();
				p.setId(Integer.parseInt(request.getParameter("id_prop")));
				v.setProprietario(p);
				VeiculoDao.salvarVeiculo(v);
				response.sendRedirect("index.jsp");
				
				
	}

}

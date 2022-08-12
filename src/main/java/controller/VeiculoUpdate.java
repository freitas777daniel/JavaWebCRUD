package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProprietarioDao;
import dao.VeiculoDao;
import model.Proprietario;
import model.Veiculo;

/**
 * Servlet implementation class VeiculoUpdate
 */
@WebServlet("/VeiculoUpdate")
public class VeiculoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeiculoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("id"));
		Veiculo veiculo = VeiculoDao.getRegistroById(id);
		request.setAttribute("veiculo", veiculo);
		request.setAttribute("list", ProprietarioDao.getAllProprietarios());
		request.getRequestDispatcher("/EditVeiculo.jsp").forward(request, response);
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("id"));
		String placa = request.getParameter("placa");
		String renavam = request.getParameter("renavam");
		int id_prop = Integer.parseInt(request.getParameter("id_prop"));
		
		Veiculo v = new Veiculo();
		v.setId(id);
		v.setPlaca(placa);
		v.setRenavam(renavam);
		
		Proprietario p = new Proprietario();
		p.setId(id_prop);
		v.setProprietario(p);
		
		
		VeiculoDao.updateVeiculo(v);
		response.sendRedirect("index.jsp");
		
		
	}

}

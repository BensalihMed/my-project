package ControllersForm;

import JavaBeans.Formulaire;

import java.io.IOException;

import java.servlet.RequestDispatcher;
import java.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.httpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 

/**
 * Servlet implementation class ServQestions
 */
public class ServQestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServQestions() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Formulaire f = new Formulaire();
		int form = Integer.parseInt(request.getParameterValues("form")[0]);
		f.setIdForm(form);
		
		request.setAttribute("form", f);
		RequestDispatcher dispat = this.getServletContext().getRequestDispatcher("/question.jsp");
		dispat.forward(request,response);
	}

 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

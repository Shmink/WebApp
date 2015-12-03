package webApp;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("value"));
		String method = request.getParameter("method");
 
		Model m = new Model();
 
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
 
		if (method.equals("Fibonacci")){
			session.setAttribute("fibonacciDP", m.FibonacciDP(num));
			dispatcher = request.getRequestDispatcher("fibonacciDP.jsp");
		}
		else{
			//session.setAttribute("factorial", m.FactorialDB(num));
			request.setAttribute("factorial", m.FactorialDB(num));
			dispatcher = request.getRequestDispatcher("factorialDB.jsp");
		}
		dispatcher.forward(request, response);		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}

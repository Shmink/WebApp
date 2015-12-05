package email;

import java.io.IOException;

import javax.mail.MessagingException;
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
public class Controller extends HttpServlet {
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
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		
		//System.out.println(username + " " + password);
		
		HttpSession session = request.getSession(true);
		
		Model model = new Model();
		try 
		{
			if(model.loggedIn(username, password))
			{
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				dispatcher = request.getRequestDispatcher("successfulLogin.jsp");
			}
		} 
		catch (MessagingException e) 
		{
			dispatcher = request.getRequestDispatcher("index.jsp");
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}
		dispatcher.forward(request, response);	
		
		doGet(request, response);
	}

}

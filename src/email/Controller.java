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
/**
 * This is the controller servlet for the login procedure.
 * @author Tom Nicklin
 *
 */
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
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * doPost method in this class is used to log the user into their gmail account.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		
		/* Created session so we can pass username and password from 
		 * class to class without the user needing to input them again. 
		 * Later we set those attributes.
		 */
		HttpSession session = request.getSession(true);
		
		Model model = new Model();
		try 
		{
			//If the login goes smoothly we sent then open the successful login page.
			if(model.loggedIn(username, password))
			{
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				dispatcher = request.getRequestDispatcher("successfulLogin.jsp");
			}
		} 
		//If something does go wrong however just reopen the login page.
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

package email;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
/**
 * This servlet class is responsible for logging out the user.
 * @author Tom Nicklin
 *
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * doPost method in this class logs the user out by taking the session and terminating it
	 * then open the successful logout page.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		//Sent to logout page.
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("loggedOut.jsp");
		dispatcher.forward(request, response);
		

		doGet(request, response);
	}

}

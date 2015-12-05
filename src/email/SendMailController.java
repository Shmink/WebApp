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
 * Servlet implementation class SendMailController
 */
@WebServlet("/SendMailController")
/**
 * SendMailController class gathers all relevant information from user 
 * inputs and sends it to the relevant methods for the email to be sent.
 * @author Tom Nicklin
 *
 */
public class SendMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailController() {
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
	 * doPost method in this class gathers information from user inputs.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Get the users email and password from the session.
		HttpSession sesh = request.getSession();
		String username = sesh.getAttribute("username").toString();
		String password = sesh.getAttribute("password").toString();
		
		//Get the recipient, subject and body of the email.
		String recipient = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String messageBody = request.getParameter("messageBody");
		
		RequestDispatcher dispatcher = null;
		
		Model model = new Model();
		
		//Here we check if the mail goes through ok, if it does or does not open the relevant page.
		if(recipient == "" || subject == "" || messageBody == "") 
		{
			dispatcher = request.getRequestDispatcher("errorSendMail.jsp");
		}
		else 
		{
			if(model.sentMail(username, password, recipient, subject, messageBody))
			{
				dispatcher = request.getRequestDispatcher("emailSent.jsp");
			}
			else
			{
				dispatcher = request.getRequestDispatcher("errorSendMail.jsp");
			}
		}
		
		dispatcher.forward(request, response);	
		doGet(request, response);
	}

}

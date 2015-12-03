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
 * Servlet implementation class SendMailController
 */
@WebServlet("/SendMailController")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sesh = request.getSession();
		String username = sesh.getAttribute("username").toString();
		String password = sesh.getAttribute("password").toString();
		
		String recipient = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String messageBody = request.getParameter("messageBody");
		
		RequestDispatcher dispatcher = null;
		
		Model model = new Model();
		
		System.out.println(model.sentMail(username, password, recipient, subject, messageBody));
		
		if(model.sentMail(username, password, recipient, subject, messageBody))
		{
			//dispatcher = request.getRequestDispatcher("emailSent.jsp");
		}
		else
		{
			dispatcher = request.getRequestDispatcher("errorSendMail.jsp");
		}
		
		
		dispatcher.forward(request, response);	
		doGet(request, response);
	}

}

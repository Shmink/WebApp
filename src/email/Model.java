package email;

import java.io.IOException;
import java.util.Properties;

import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.mail.Multipart;
import com.sun.mail.imap.IMAPFolder;

import com.sun.mail.imap.IMAPFolder;

/**
 * Servlet implementation class Model
 */
@WebServlet("/Model")
public class Model extends HttpServlet 
{
	public boolean loggedIn(String username, String password) throws MessagingException
	{
		Store store = null;	        

		// Step 1.1:  set mail user properties using Properties object
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		
		// Set Property with username and password for authentication  
		props.setProperty("mail.user", username);
		props.setProperty("mail.password", password);

		//Step 1.2: Establish a mail session (java.mail.Session)
		Session session = Session.getDefaultInstance(props);

		try 
		{
			// Step 2: Get the Store object from the mail session
			// A store needs to connect to the IMAP server  
			store = session.getStore("imaps");
			store.connect("imap.googlemail.com",username, password);
		}
		catch (NoSuchProviderException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean sentMail(String username, String password, String recipient, String subject, String messageBody)
	{
		
		String smtphost = "smtp.gmail.com";
		// Set all Properties
		// Get system properties
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtphost);
		props.put("mail.smtp.port", "587");
		
		// Set Property with username and password for authentication  
		props.setProperty("mail.user", username);
		props.setProperty("mail.password", password);
		
		//Establish a mail session
		Session session = Session.getDefaultInstance(props);
		
		try 
		{

			// Create a message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText(messageBody);
			
			message.saveChanges();
			
			//Send the message by javax.mail.Transport .			
			Transport tr = session.getTransport("smtp");			// Get Transport object from session		
			tr.connect(smtphost, username, password); 				// We need to connect
			tr.sendMessage(message, message.getAllRecipients()); 	// Send message

			//Notify the user everything functioned fine.
			System.out.println("Your mail has been sent.");
			return true;

		} 
		catch (MessagingException e) 
		{
			//throw new RuntimeException(e);
			return false;
		}		
		
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Model() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

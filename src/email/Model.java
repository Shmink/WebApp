package email;

import java.util.Properties;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;

/**
 * This model class does most of the backend stuff for this whole application.
 * @author Tom Nicklin
 *
 */
public class Model
{
	/**
	 * loggedIn method takes the users credentials and then logs them in. If it all
	 * goes smoothly then the method is going to return true so other procedures can continue.
	 * @param username - Email of user.
	 * @param password - password of user
	 * @return true or false based on if the user logs in or not.
	 * @throws MessagingException
	 */
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
	
	/**
	 * sentMail method send actual emails after getting passed everything it needs.
	 * @param username - Email of user
	 * @param password - password of user
	 * @param recipient - recipient of the email
	 * @param subject - the subject of the email
	 * @param messageBody - the actual message of the email
	 * @return true or false based on if the mail has been sent
	 */
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
			// Save the changes of the mail
			message.saveChanges();
			
			//Send the message by javax.mail.Transport .			
			Transport tr = session.getTransport("smtp");			// Get Transport object from session		
			tr.connect(smtphost, username, password); 				// We need to connect
			tr.sendMessage(message, message.getAllRecipients()); 	// Send message
		} 
		catch (MessagingException e) 
		{	
			return false;
		}
		return true;
	}
}

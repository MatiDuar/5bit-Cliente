package com.controlador;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.entities.Usuario;

public class EmailSender 
	{

		//SETUP MAIL SERVER PROPERTIES
		//DRAFT AN EMAIL
		//SEND EMAIL
			
		Session newSession = null;
		MimeMessage mimeMessage = null;
		
		public static void main(String args[]) throws AddressException, MessagingException, IOException
		{
			EmailSender mail = new EmailSender();
			mail.setupServerProperties();
			mail.draftEmail(null);
			mail.sendEmail();
		}

		public void sendEmail() throws MessagingException {
			String fromUser = "polinogaymer@gmail.com";  //Enter sender email id
			String fromUserPassword = "xdbfujpiaxmhqidj";  //Enter sender gmail password , this will be authenticated by gmail smtp server
			String emailHost = "smtp.gmail.com";
			Transport transport = newSession.getTransport("smtp");
			transport.connect(emailHost, fromUser, fromUserPassword);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			System.out.println("Email successfully sent!!!");
		}

		public MimeMessage draftEmail(Usuario usuario) throws AddressException, MessagingException, IOException {
			String[] emailReceipients = {usuario.getMail()};  //Enter list of email recepients
			String emailSubject = "Validacion de cuenta";
			String emailBody = "<H1>Hello "+usuario.getNombre1()+ " "+ usuario.getApellido1()+"</H1> <br> su cuenta ha sido validada por un analista"
					+ "ASDASDASDASDAS";
			mimeMessage = new MimeMessage(newSession);
			
			for (int i =0 ;i<emailReceipients.length;i++)
			{
				mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
			}
			mimeMessage.setSubject(emailSubject);
			
	      // CREATE MIMEMESSAGE 
		    // CREATE MESSAGE BODY PARTS 
		    // CREATE MESSAGE MULTIPART 
		    // ADD MESSAGE BODY PARTS ----> MULTIPART 
		    // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object 
		    
		    
			 MimeBodyPart bodyPart = new MimeBodyPart();
			 bodyPart.setContent(emailBody,"text/html");
			 MimeMultipart multiPart = new MimeMultipart();
			 multiPart.addBodyPart(bodyPart);
			 mimeMessage.setContent(multiPart);
			 return mimeMessage;
		}

		public void setupServerProperties() {
			Properties properties = System.getProperties();
			properties.put("mail.smtp.port", "25");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			newSession = Session.getDefaultInstance(properties,null);
		}
		
	
}

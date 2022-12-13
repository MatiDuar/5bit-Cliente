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
			
		static Session newSession = null;
		MimeMessage mimeMessage = null;
		
		public static void main(String args[]) throws AddressException, MessagingException, IOException
		{
			EmailSender mail = new EmailSender();
			setupServerProperties();
			mail.draftEmail(null);
			mail.sendEmail();
		}

		public void sendEmail() throws MessagingException {
			String fromUser = "5bitutec@gmail.com";  //Email del emisor
			String fromUserPassword = "qjmwqsgvkpflzjvx";  //Este es la clave de aplicacion para poder mandar mail con la cuenta
			String emailHost = "smtp.gmail.com";
			Transport transport = newSession.getTransport("smtp");
			transport.connect(emailHost, fromUser, fromUserPassword);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			System.out.println("Email successfully sent!!!");
		}

		public MimeMessage draftEmail(Usuario usuario) throws AddressException, MessagingException, IOException {
			String[] emailReceipients = {usuario.getMail()};  //Se pasa por parametro el usuario para poder saber el mail personal
			String emailSubject = "Validacion de cuenta";
			String emailBody = "<H2>Detalles de tu cuenta UTEC</H2>se le informa que su cuenta de UTEC a sido validada.<br><br>"
					+ "si tiene algún inconveniente al ingresar a su cuenta puede comunicarse con secretaría para que releven su caso.";
			mimeMessage = new MimeMessage(newSession);
			
			for (int i =0 ;i<emailReceipients.length;i++)
			{
				mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
			}
			mimeMessage.setSubject(emailSubject);
			
		    
		    
			 MimeBodyPart bodyPart = new MimeBodyPart();
			 bodyPart.setContent(emailBody,"text/html");
			 MimeMultipart multiPart = new MimeMultipart();
			 multiPart.addBodyPart(bodyPart);
			 mimeMessage.setContent(multiPart);
			 return mimeMessage;
		}

		public static void setupServerProperties() {
			Properties properties = System.getProperties();
			properties.put("mail.smtp.port", "25");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			newSession = Session.getDefaultInstance(properties,null);
		}
		
	
}

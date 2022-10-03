package com.yash.notifications;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;
import org.springframework.stereotype.Component;  
  
@Component
public class Email {    
  
	public void email(String email){
		 String host="smtp.gmail.com";  
		  final String user="quiz.yash@gmail.com";
		  final String password="12345@Quiz"; 

		   Properties props = new Properties();  
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");  
		 
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		   //  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		     message.addRecipients(Message.RecipientType.TO,email);
		     message.setSubject("Quiz");  
		     message.setText("You are Successfully Registered : http://localhost:3000");
		     
		 
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();}  
		   
		 
	 }
  
}  

package com.pages;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public static void main(String[] args) {
		String recipient = "manojM5@hexaware.com"; 
	      
        // email ID of Sender. 
        String sender = "niranjanr1@hexaware.com"; 
        final String password = "Learnme@oct2001";
        
      
       
        
        
      
        // Getting system properties 
        Properties props = System.getProperties(); 
      
//        // Setting up mail server 
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.office365.com");
//        props.put("mail.smtp.port", "587");
//        props.put("mail.smtp.starttls.enable", "true"); // Enable TLS
//        props.put("mail.debug", "true");
//        props.put("mail.smtp.user", sender);
//        props.put("mail.smtp.password", password);
////        props.put("mail.smtp.connectiontimeout", "10000"); // 10 seconds
////        props.put("mail.smtp.timeout", "10000"); // 10 seconds
////        props.put("mail.smtp.writetimeout", "10000");
//      
//        // creating session object to get properties 
//        
//        
//        
////        Session session = Session.getInstance(props, new Authenticator() {
////            @Override
////            protected PasswordAuthentication getPasswordAuthentication() {
////            	System.out.println("Inside Authenticator - Password: " + password);
////                return new PasswordAuthentication(sender, password);
////            }
////        });
//        Session session = Session.getInstance(props);
//        
//        session.setDebug(true);
//        
//
//        try 
//        { 
//            // MimeMessage object. 
//            MimeMessage message = new MimeMessage(session); 
//      
//            // Set From Field: adding senders email to from field. 
//            message.setFrom(new InternetAddress(sender));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
//            message.setSubject("The Automated Report");
//
//            // Create a multipart message for the email body and attachment
//            MimeMultipart multipart = new MimeMultipart();
//
//            // Email body part
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText("I have attached the report for the AI fusion center");
//            multipart.addBodyPart(messageBodyPart);
//
//            // Attachment part
////            MimeBodyPart attachmentPart = new MimeBodyPart();
////            attachmentPart.attachFile(new File(attachmentPath));
////            multipart.addBodyPart(attachmentPart);
//
//            // Set the complete message parts
//            message.setContent(multipart);
//
//            // Send the message
//            Transport.send(message);
//
//            System.out.println("Email sent successfully with the report attachment.");
//
//        } 
//        catch (MessagingException mex)  
//        { 
//            mex.printStackTrace(); 
//        }         
        
        
        props.put("mail.smtp.host", "smtp.Hexaware.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        });
        
        

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Test Email");
            message.setText("This is a test email.");

            // Use the Transport.send method directly without explicitly calling connect
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
        
	}


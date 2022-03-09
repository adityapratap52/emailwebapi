package com.emailwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

@SpringBootApplication
public class EmailwebapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailwebapiApplication.class, args);

//		System.out.println("Preparing to send message.............");

//		String message = "Hello! This message is send only for testing purpose.";
//		String subject = "For Checking";
//		String to = "adityapratap1491@gmail.com";
//		String from = "adityapratap1490@gmail.com";

//		sendEmail(message, subject, to, from);

//		sendAttach(message, subject, to, from);
	}

	private static void sendAttach(String message, String subject, String to, String from) {

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println(properties);

		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1 : get the session obj
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("adityapratap1490@gmail.com", "Da@1234&as");
			}
		});

		session.setDebug(true);

		// Step 2 : compose the message [text, multi media]
		MimeMessage m = new MimeMessage(session);

		try {

			// from email
			m.setFrom(from);

			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message
			m.setSubject(subject);

			// add attachment

			// file path
			String path = "/home/adi/Pictures/img.png";

			MimeMultipart mimeMultipart = new MimeMultipart();

			// for text
			MimeBodyPart textMime = new MimeBodyPart();

			// for file
			MimeBodyPart fileMime = new MimeBodyPart();

			textMime.setText(message);

			File file = new File(path);

			fileMime.attachFile(file);

			mimeMultipart.addBodyPart(textMime);

			mimeMultipart.addBodyPart(fileMime);

			m.setContent(mimeMultipart);

			// Step 3 : send the message using Transport class
			Transport.send(m);

			System.out.println("Sent success.............");

		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.emailwebapi.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

     public boolean sendEmail(EmailRequest request) {

        boolean f = false;

        // get the system properties
        Properties properties = System.getProperties();

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
                return new PasswordAuthentication("<emailId>", "<password>");
            }
        });

        session.setDebug(true);

        // Step 2 : compose the message [text, multi media]
        MimeMessage m = new MimeMessage(session);

        try {

            // from email
            m.setFrom(request.getFrom());

            // adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(request.getTo()));

            // adding subject to message
            m.setSubject(request.getSubject());

            // adding text to message
            m.setText(request.getMessage());

            // Step 3 : send the message using Transport class
            Transport.send(m);

            System.out.println("Sent success.............");

            f = true;

        }catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}

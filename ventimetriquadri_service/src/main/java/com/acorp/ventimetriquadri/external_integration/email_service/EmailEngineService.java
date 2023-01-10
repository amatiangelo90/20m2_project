package com.acorp.ventimetriquadri.external_integration.email_service;

import com.sun.mail.smtp.SMTPAddressFailedException;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailEngineService {


    public EmailSenderResponse sendEmail(EmailEntity emailEntity) {
        try {
            System.out.println("Sendind email to : " + emailEntity.getSupplierEmail());
            System.out.println("message : " + emailEntity.getMessage());
            System.out.println("branch : " + emailEntity.getBranchName());
            System.out.println("Date delivery: " + emailEntity.getDeliveryDate());

            Properties props = new Properties();
            props.put("mail.smtp.auth", true);
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.starttls.enable", true);
            props.put("mail.trasport.protocol", "smpt");

            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("20m2.ordini@gmail.com","voloeiqcyooofxbc");
                }
            });

            Message msg = new MimeMessage(session);

            msg.setSubject("Ordine da " + emailEntity.getBranchName());
            msg.setContent(emailEntity.getMessage(), "text/html");

            Address addressTo = new InternetAddress(emailEntity.getSupplierEmail());

            msg.setRecipient(Message.RecipientType.TO, addressTo);

            Transport.send(msg);

            return EmailSenderResponse.builder()
                    .message("Email sent!")
                    .status("OK")
                    .build();
        } catch (AddressException e) {
            return EmailSenderResponse.builder()
                    .message(e.getMessage())
                    .status("KO")
                    .build();
        } catch(SMTPAddressFailedException e){
            return EmailSenderResponse.builder()
                    .message(e.getMessage())
                    .status("KO")
                    .build();
        } catch (MessagingException e) {
            return EmailSenderResponse.builder()
                    .message(e.getMessage())
                    .status("KO")
                    .build();
        } catch (Exception e) {
            return EmailSenderResponse.builder()
                    .message(e.getMessage())
                    .status("KO")
                    .build();
        }
    }
}

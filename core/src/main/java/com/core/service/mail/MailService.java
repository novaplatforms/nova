/*
 * @author Gnatyk Dmytro
 * This file is part of XAPP.
 *
 * XAPP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XAPP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with XAPP. If not, see <https://www.gnu.org/licenses/>.
 */

package com.core.service.mail;

import jakarta.annotation.PostConstruct;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Service for sending emails.
 */
@Service
public class MailService implements IMailService {

    @Value("${spring.mail.username}")
    private String userName;
    @Value("${spring.mail.password}")
    private String password;

    private final Properties prop = new Properties();
    private final Logger logger = LoggerFactory.getLogger(MailService.class);

    /**
     * Initializes the mail service with necessary SMTP properties.
     * This method is called after the bean's properties have been set.
     */

    @PostConstruct
    public void init() {
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    }

    /**
     * Sends an email to the specified recipient.
     *
     * @param to the recipient's email address
     * @param subject the subject of the email
     * @param body the body of the email
     */

    @Override
    public void sendMail(String to, String subject, String body) {
        Session session = Session.getDefaultInstance(prop);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(userName));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", userName, password);

            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (Exception e) {
            logger.error("Error while sending mail: {}", e.getMessage());
        }
    }
}

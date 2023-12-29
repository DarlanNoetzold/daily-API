package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.mail.*;
import java.util.Properties;

@Service
public class EmailReaderService {

    @Value("${spring.mail.receive.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    public void readInbox() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.host", host);
        properties.put("mail.imaps.port", "993");

        Session emailSession = Session.getDefaultInstance(properties);
        Store store = emailSession.getStore("imaps");
        store.connect(host, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        int messageCount = inbox.getMessageCount();
        int startMessage = Math.max(1, messageCount - 19);
        Message[] messages = inbox.getMessages(startMessage, messageCount);

        for (Message message : messages) {
            System.out.println("Email Subject: " + message.getSubject());
        }

        inbox.close(false);
        store.close();
    }
}
package tech.noetzold.dailyAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import tech.noetzold.dailyAPI.service.EmailReaderService;
import tech.noetzold.dailyAPI.service.EmailSenderService;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class DailyApiApplication {

	@Autowired
	private EmailSenderService senderService;

	@Autowired
	private EmailReaderService emailReaderService;

	public static void main(String[] args) {
		SpringApplication.run(DailyApiApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws Exception {

		emailReaderService.readInbox();

	}

}

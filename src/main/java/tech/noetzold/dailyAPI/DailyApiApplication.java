package tech.noetzold.dailyAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DailyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyApiApplication.class, args);
	}

}

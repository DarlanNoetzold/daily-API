package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.HomeAssistantFeignClient;
import tech.noetzold.dailyAPI.repository.HomeEntityRepository;

@Service
public class HomeEntityService {

    @Autowired
    private HomeAssistantFeignClient homeAssistantFeignClient;

    @Autowired
    private HomeEntityRepository homeEntityRepository;

    @Value("${spring.home.token}")
    private String token;

    public String isUp(){
        return homeAssistantFeignClient.isHomeAssistentUp(token);
    }
}

package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.HomeAssistantFeignClient;
import tech.noetzold.dailyAPI.model.HomeEntity;
import tech.noetzold.dailyAPI.model.dto.Command;

import java.util.List;

@Service
public class HomeEntityService {

    @Autowired
    private HomeAssistantFeignClient homeAssistantFeignClient;

    @Value("${spring.home.token}")
    private String token;

    public String isUp(){
        return homeAssistantFeignClient.isHomeAssistentUp(token);
    }

    public List<HomeEntity> getAllEntities(){
        return homeAssistantFeignClient.getStates(token);
    }

    public HomeEntity getState(String entityId){
        return homeAssistantFeignClient.getState(token, entityId);
    }

    public void turnOnLuz(tech.noetzold.dailyAPI.model.dto.Command command){
        homeAssistantFeignClient.turnOnLuz(command);
    }

    public void turnOffLuz(Command command){
        homeAssistantFeignClient.turnOffLuz(command);
    }

    public void turnOnSoquete(Command command){
        homeAssistantFeignClient.turnOnSoquete(command);
    }

    public void turnOffSoquete(Command command){
        homeAssistantFeignClient.turnOffSoquete(command);
    }


}

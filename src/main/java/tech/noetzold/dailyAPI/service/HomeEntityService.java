package tech.noetzold.dailyAPI.service;

import io.lettuce.core.protocol.Command;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.HomeAssistantFeignClient;
import tech.noetzold.dailyAPI.model.HomeEntity;
import tech.noetzold.dailyAPI.repository.HomeEntityRepository;

import java.util.List;

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

    @Transactional
    public List<HomeEntity> getAllEntities(){
        List<HomeEntity> entities = homeAssistantFeignClient.getStates(token);
        homeEntityRepository.saveAll(entities);

        return entities;
    }

    public HomeEntity getState(String entityId){
        return homeAssistantFeignClient.getState(token, entityId);
    }

    public void turnOnLuz(Command command){
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

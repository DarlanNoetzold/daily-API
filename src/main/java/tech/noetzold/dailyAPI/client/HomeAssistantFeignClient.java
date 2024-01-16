package tech.noetzold.dailyAPI.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import tech.noetzold.dailyAPI.model.HomeEntity;

import java.util.List;

@FeignClient(name = "homeAssistantClient", url = "http://192.168.18.75:8123/api")
public interface HomeAssistantFeignClient {

    @GetMapping("/")
    String isHomeAssistentUp(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/states")
    List<HomeEntity> getStates(@RequestHeader("Authorization") String bearerToken);
}

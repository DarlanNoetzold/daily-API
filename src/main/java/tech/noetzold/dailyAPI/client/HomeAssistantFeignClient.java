package tech.noetzold.dailyAPI.client;

import io.lettuce.core.protocol.Command;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tech.noetzold.dailyAPI.model.HomeEntity;

import java.util.List;

@FeignClient(name = "homeAssistantClient", url = "http://192.168.18.75:8123/api")
public interface HomeAssistantFeignClient {

    @GetMapping("/")
    String isHomeAssistentUp(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/states")
    List<HomeEntity> getStates(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/states/{entityId}")
    HomeEntity getState(@RequestHeader("Authorization") String bearerToken, @RequestParam String entityId);

    @PostMapping("/api/services/light/turn_on")
    void turnOnLuz(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_off")
    void turnOffLuz(@RequestBody Command command);

    @PostMapping("/api/services/switch/turn_on")
    void turnOnSoquete(@RequestBody Command command);

    @PostMapping("/api/services/switch/turn_off")
    void turnOffSoquete(@RequestBody Command command);

}

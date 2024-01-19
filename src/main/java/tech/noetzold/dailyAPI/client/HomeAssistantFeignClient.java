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
    void turnOnLuz_da_sala(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_off")
    void turnOffLuz_da_sala(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_on")
    void turnOnLuz_do_quarto(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_off")
    void turnOffLuz_do_quarto(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_on")
    void turnOnLuz_da_frente(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_off")
    void turnOffLuz_da_frente(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_on")
    void turnOnLuz_da_cozinha(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_off")
    void turnOffLuz_da_cozinha(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_on")
    void turnOnLuz_da_bancada(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_off")
    void turnOffLuz_da_bancada(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_on")
    void turnOnLuz_da_varanda(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_off")
    void turnOffLuz_da_varanda(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_on")
    void turnOnLuz_do_escritorio(@RequestBody Command command);

    @PostMapping("/api/services/light/turn_off")
    void turnOffLuz_do_escritorio(@RequestBody Command command);

    @PostMapping("/api/services/switch/turn_on")
    void turnOnRegua_cozinha_soquete_1(@RequestBody Command command);

    @PostMapping("/api/services/switch/turn_off")
    void turnOffRegua_cozinha_soquete_1(@RequestBody Command command);

    @PostMapping("/api/services/switch/turn_on")
    void turnOnRegua_cozinha_soquete_2(@RequestBody Command command);

    @PostMapping("/api/services/switch/turn_off")
    void turnOffRegua_cozinha_soquete_2(@RequestBody Command command);
}

package tech.noetzold.dailyAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.noetzold.dailyAPI.model.HomeEntity;
import tech.noetzold.dailyAPI.service.HomeEntityService;
import tech.noetzold.dailyAPI.model.dto.Command;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeEntityController {

    @Autowired
    private HomeEntityService homeEntityService;

    @GetMapping("/status")
    public String isUp() {
        return homeEntityService.isUp();
    }

    @GetMapping("/entities")
    public List<HomeEntity> getAllEntities() {
        return homeEntityService.getAllEntities();
    }

    @GetMapping("/entity/{entityId}")
    public HomeEntity getState(@PathVariable String entityId) {
        return homeEntityService.getState(entityId);
    }

    @PostMapping("/light/on")
    public void turnOnLuz(@RequestBody Command command) {
        homeEntityService.turnOnLuz(command);
    }

    @PostMapping("/light/off")
    public void turnOffLuz(@RequestBody Command command) {
        homeEntityService.turnOffLuz(command);
    }

    @PostMapping("/switch/on")
    public void turnOnSoquete(@RequestBody Command command) {
        homeEntityService.turnOnSoquete(command);
    }

    @PostMapping("/switch/off")
    public void turnOffSoquete(@RequestBody Command command) {
        homeEntityService.turnOffSoquete(command);
    }
}


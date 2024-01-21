package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(HomeEntityController.class);

    @GetMapping("/status")
    public String isUp() {
        logger.info("Status call.");
        return homeEntityService.isUp();
    }

    @GetMapping("/entities")
    public List<HomeEntity> getAllEntities() {
        logger.info("All entities on home call.");
        return homeEntityService.getAllEntities();
    }

    @GetMapping("/entity/{entityId}")
    public HomeEntity getState(@PathVariable String entityId) {
        logger.info("Get entity {} state", entityId);
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


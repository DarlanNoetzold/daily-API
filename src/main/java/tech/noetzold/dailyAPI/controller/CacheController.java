package tech.noetzold.dailyAPI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    private static final Logger logger = LoggerFactory.getLogger(AnimeController.class);

    @GetMapping
    public void clearAllCaches() {
        for(String name : cacheManager.getCacheNames()) {
            logger.info("Cleaning cache - " + name);
            cacheManager.getCache(name).clear();
        }
    }
}

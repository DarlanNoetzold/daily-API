package tech.noetzold.dailyAPI.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public void clearAllCaches() {
        for(String name : cacheManager.getCacheNames()) {
            cacheManager.getCache(name).clear();
        }
    }
}

package tech.noetzold.dailyAPI.cache;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisConfig {

    @Bean
    RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            configurationMap.put("anime", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
            configurationMap.put("game", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
            configurationMap.put("movie", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
            configurationMap.put("tvshow", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
            configurationMap.put("dollar", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
            configurationMap.put("weather", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
            configurationMap.put("news", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));

            builder.withInitialCacheConfigurations(configurationMap);
        };
    }

}

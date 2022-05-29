package com.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.management.timer.Timer;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {
    public static final String CHANNELS_CACHE = "offers";
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfig.class);

    @Scheduled(fixedRate = Timer.ONE_MINUTE)
    @CacheEvict(value = {CHANNELS_CACHE}, allEntries = true)
    public void clearChannels() {
        LOGGER.info("Clearing channels caches");
    }
}

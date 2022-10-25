package com.idanuda.simplespringapplication.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GeneralCacheManager {

    private final CacheManager cacheManager;

    @Autowired
    public GeneralCacheManager(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void clearCacheSchedule(){
        for(String name:cacheManager.getCacheNames()){
            cacheManager.getCache(name).clear();
        }
    }
}

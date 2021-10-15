package com.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    @Cacheable(value = "channels")
    public List<Channel> findAll() {
        System.out.println("Fetching from database");
        return channelRepository.findAll();
    }
}

package com.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OfferService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Cacheable(value = "offers")
    public Set<String> findAll() {
        System.out.println("Fetching from database");
        Criteria criteria = new Criteria();
        List<Offer> list = (List<Offer>) mongoTemplate.getCollection("offers")
                .distinct("type", Offer.class);
        return list.stream().map(o -> o.getType()).collect(Collectors.toSet());
    }
}

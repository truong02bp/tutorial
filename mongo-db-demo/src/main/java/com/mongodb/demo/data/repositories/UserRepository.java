package com.mongodb.demo.data.repositories;

import com.mongodb.demo.data.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}

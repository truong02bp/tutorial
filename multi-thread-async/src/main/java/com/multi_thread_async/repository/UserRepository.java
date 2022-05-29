package com.multi_thread_async.repository;

import com.multi_thread_async.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.id < ?1")
    List<User> findByCompareId(Long id);
}

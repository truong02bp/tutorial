package com.multi_thread_async.repository;

import com.multi_thread_async.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

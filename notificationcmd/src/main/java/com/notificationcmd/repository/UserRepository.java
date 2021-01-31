package com.notificationcmd.repository;

import com.notificationcmd.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repo for call database and query on it

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}

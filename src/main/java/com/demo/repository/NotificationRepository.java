package com.demo.repository;

import com.demo.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repo for call database and query on it

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {

}

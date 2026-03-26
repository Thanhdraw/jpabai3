package com.cybersoft.jpabai3.repository;

import com.cybersoft.jpabai3.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    List<OrderEntity> findTop5ByOrderByTotalAmountDesc();
}

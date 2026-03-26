package com.cybersoft.jpabai3.service;

import com.cybersoft.jpabai3.entity.OrderEntity;
import com.cybersoft.jpabai3.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderEntity> getTop5Orders() {
        return orderRepository.findTop5ByOrderByTotalAmountDesc();
    }

    public List<OrderEntity> getOrdersByDateRange(LocalDateTime start, LocalDateTime end) {
        return orderRepository.findByCreatedAtBetween(start, end);
    }
}

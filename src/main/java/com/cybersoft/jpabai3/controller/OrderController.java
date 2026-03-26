package com.cybersoft.jpabai3.controller;

import com.cybersoft.jpabai3.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/top")
    public ResponseEntity<?> getTopOrder() {
        return ResponseEntity.ok(orderService.getTop5Orders());
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getOrdersByDate(
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            LocalDateTime start,

            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            LocalDateTime end) {

        return ResponseEntity.ok(
                orderService.getOrdersByDateRange(start, end)
        );
    }
}

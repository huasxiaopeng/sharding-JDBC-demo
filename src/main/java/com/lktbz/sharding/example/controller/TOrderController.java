package com.lktbz.sharding.example.controller;


import com.lktbz.sharding.example.service.ITOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
        垂直分库分组
 */
@RestController
@RequestMapping("/t-order")
public class TOrderController {

    @Autowired
    ITOrderService orderService;

    @GetMapping
    public void init() throws SQLException {
        orderService.initEnvironment();
        orderService.processSuccess();
    }
}

package com.lktbz.sharding.example.controller;


import com.lktbz.sharding.example.service.ITOrderIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 *  根据时间进行水平分表
 *
 */
@RestController
@RequestMapping("/t-order-interval")
public class TOrderIntervalController {

    @Autowired
    ITOrderIntervalService orderService;

    @GetMapping
    public void init() throws SQLException {
        orderService.initEnvironment();
        orderService.processSuccess();
    }
}

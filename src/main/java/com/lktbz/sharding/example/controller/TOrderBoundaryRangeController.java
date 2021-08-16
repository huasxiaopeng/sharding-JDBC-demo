package com.lktbz.sharding.example.controller;


import com.lktbz.sharding.example.service.ITOrderBoundaryRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * <p>
 *     范围进行分片
 * </p>
 * 1000,20000,300000
 * 0~1000
 * 1000~20000
 * 20000~300000
 * 300000~无穷大
 *
 */
@RestController
@RequestMapping("/t-order-boundary-range")
public class TOrderBoundaryRangeController {

    @Autowired
    ITOrderBoundaryRangeService orderService;

    @GetMapping
    public void init() throws SQLException {
        orderService.initEnvironment();
        orderService.processSuccess();
    }
}

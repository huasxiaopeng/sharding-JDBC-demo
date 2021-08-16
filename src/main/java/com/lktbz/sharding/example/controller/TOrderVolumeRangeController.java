package com.lktbz.sharding.example.controller;


import com.lktbz.sharding.example.service.ITOrderVolumeRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * <p>
 *  范围
 * </p>
 *
 */
@RestController
@RequestMapping("/t-order-volume-range")
public class TOrderVolumeRangeController {
    @Autowired
    ITOrderVolumeRangeService volumeRangeService;
    @GetMapping
    public void init() throws SQLException {
        volumeRangeService.initEnvironment();
        volumeRangeService.processSuccess();
    }
}

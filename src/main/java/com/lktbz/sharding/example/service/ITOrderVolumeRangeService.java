package com.lktbz.sharding.example.service;

import com.lktbz.sharding.example.dal.model.TOrderVolumeRange;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.SQLException;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface ITOrderVolumeRangeService extends IService<TOrderVolumeRange> {

    void initEnvironment() throws SQLException;

    void processSuccess() throws SQLException;
}

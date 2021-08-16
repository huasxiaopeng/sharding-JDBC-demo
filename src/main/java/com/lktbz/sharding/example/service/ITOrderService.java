package com.lktbz.sharding.example.service;

import com.lktbz.sharding.example.dal.model.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.SQLException;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface ITOrderService extends IService<TOrder> {

    void initEnvironment() throws SQLException;

    void processSuccess() throws SQLException;

}

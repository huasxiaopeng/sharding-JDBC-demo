package com.lktbz.sharding.example.service.impl;

import com.lktbz.sharding.example.dal.model.TOrderStandard;
import com.lktbz.sharding.example.dal.mapper.TOrderStandardMapper;
import com.lktbz.sharding.example.service.ITOrderStandardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class TOrderStandardServiceImpl extends ServiceImpl<TOrderStandardMapper, TOrderStandard> implements ITOrderStandardService {

    @Autowired
    TOrderStandardMapper orderStandardMapper;

    Random random=new Random();
    @Override
    public void initEnvironment() throws SQLException {
        orderStandardMapper.createTableIfNotExists();
    }

    @Override
    public void processSuccess() throws SQLException {
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> orderIds = insertData();
        System.out.println("-------------- Process Success Finish --------------");
    }
    private List<Long> insertData() throws SQLException {
        System.out.println("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 100; i++) {
            TOrderStandard order = new TOrderStandard();
            order.setUserId(random.nextInt(10000));
            order.setAddressId(i);
            order.setStatus("INSERT_TEST");
            orderStandardMapper.insert(order);
            result.add(order.getOrderId());
        }
        return result;
    }
}

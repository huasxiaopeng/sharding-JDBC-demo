package com.lktbz.sharding.example.service.impl;

import com.lktbz.sharding.example.dal.model.TOrderBoundaryRange;
import com.lktbz.sharding.example.dal.mapper.TOrderBoundaryRangeMapper;
import com.lktbz.sharding.example.service.ITOrderBoundaryRangeService;
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
public class TOrderBoundaryRangeServiceImpl extends ServiceImpl<TOrderBoundaryRangeMapper, TOrderBoundaryRange> implements ITOrderBoundaryRangeService {
    @Autowired
    TOrderBoundaryRangeMapper orderBoundaryRangeMapper;

    Random random=new Random();
    @Override
    public void initEnvironment() throws SQLException {
        orderBoundaryRangeMapper.createTableIfNotExists();
    }

    @Override
    public void processSuccess() throws SQLException {
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> orderIds = insertData();
        System.out.println("-------------- Process Success Finish --------------");
    }
    private List<Long> insertData() throws SQLException {
        System.out.println("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(1024);
        for (int i = 1; i <= 10000; i++) {
            TOrderBoundaryRange order = new TOrderBoundaryRange();
            order.setUserId(Long.parseLong(random.nextInt(400000)+""));
            order.setAddressId(i);
            order.setStatus("INSERT_TEST");
            orderBoundaryRangeMapper.insert(order);
            result.add(order.getOrderId());
        }
        return result;
    }
}

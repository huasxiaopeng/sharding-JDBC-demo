package com.lktbz.sharding.example.dal.mapper;

import com.lktbz.sharding.example.dal.model.TOrderVolumeRange;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface TOrderVolumeRangeMapper extends BaseMapper<TOrderVolumeRange> {

    @Update("CREATE TABLE IF NOT EXISTS t_order_volume_range (order_id BIGINT AUTO_INCREMENT, user_id INT NOT NULL, address_id BIGINT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))")
    void createTableIfNotExists();
}

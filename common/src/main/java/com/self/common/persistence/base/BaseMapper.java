package com.self.common.persistence.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * @author chengfengfeng
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

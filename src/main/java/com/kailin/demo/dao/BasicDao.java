package com.kailin.demo.dao;  //改为你工程的相应package


import com.kailin.demo.entity.BasicVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis DAO基类
 */
public interface BasicDao {

    int save(BasicVo basicVo);

    int saveBatch(List list);

    int update(BasicVo basicVo);

    int updateIgnoreNull(BasicVo basicVo);

    int updateBatch(List list);

    int delete(BasicVo basicVo);

    int deleteBatch(List list);

    int deleteByPK(Long id);

    int deleteAll();

    long count();

    <T> T findByPK(Long id);

    <T> List<T> find(Map<String, Object> paramMap);
}

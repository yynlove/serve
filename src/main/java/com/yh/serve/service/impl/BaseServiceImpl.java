//package com.yh.serve.service.impl;
//
//import com.yh.serve.mappers.BaseMapper;
//
//import java.util.List;
//
//public abstract class BaseServiceImpl<T> implements BaseMapper<T> {
//
//    protected abstract BaseMapper<T> getMapper();
//
//    @Override
//    public int insert(T record) {
//        return getMapper().insert(record);
//    }
//
//    @Override
//    public int deleteByPrimaryKey(Object o) {
//        return getMapper().deleteByPrimaryKey(o);
//    }
//
//    @Override
//    public int delete(T t) {
//        return getMapper().delete(t);
//    }
//
//    @Override
//    public int insertSelective(T t) {
//        return getMapper().insertSelective(t);
//    }
//
//    @Override
//    public boolean existsWithPrimaryKey(Object o) {
//        return getMapper().existsWithPrimaryKey(o);
//    }
//
//    @Override
//    public List<T> selectAll() {
//        return getMapper().selectAll();
//    }
//
//    @Override
//    public T selectByPrimaryKey(Object o) {
//        return getMapper().selectByPrimaryKey(o);
//    }
//
//    @Override
//    public int selectCount(T t) {
//        return getMapper().selectCount(t);
//    }
//
//    @Override
//    public List<T> select(T t) {
//        return getMapper().select(t);
//    }
//
//    @Override
//    public T selectOne(T t) {
//        return getMapper().selectOne(t);
//    }
//
//    @Override
//    public int updateByPrimaryKey(T t) {
//        return getMapper().updateByPrimaryKey(t);
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(T t) {
//        return getMapper().updateByPrimaryKey(t);
//    }
//
//    @Override
//    public int deleteByCondition(Object o) {
//        return getMapper().deleteByCondition(o);
//    }
//
//    @Override
//    public List<T> selectByCondition(Object o) {
//        return getMapper().selectByCondition(o);
//    }
//
//    @Override
//    public int selectCountByCondition(Object o) {
//        return getMapper().selectCountByCondition(o);
//    }
//
//    @Override
//    public int updateByCondition(T t, Object o) {
//        return getMapper().updateByCondition(t,o);
//    }
//
//    @Override
//    public int updateByConditionSelective(T t, Object o) {
//        return getMapper().updateByConditionSelective(t,o);
//    }
//
//    @Override
//    public int deleteByExample(Object o) {
//        return getMapper().deleteByExample(o);
//    }
//
//    @Override
//    public List<T> selectByExample(Object o) {
//        return getMapper().selectByExample(o);
//    }
//
//    @Override
//    public int selectCountByExample(Object o) {
//        return getMapper().selectCountByExample(o);
//    }
//
//    @Override
//    public T selectOneByExample(Object o) {
//        return getMapper().selectOneByExample(o);
//    }
//
//    @Override
//    public int updateByExample(T t, Object o) {
//        return getMapper().updateByExample(t,o);
//    }
//
//    @Override
//    public int updateByExampleSelective(T t, Object o) {
//        return getMapper().updateByExampleSelective(t,o);
//    }
//
//    @Override
//    public int deleteByIds(String s) {
//        return getMapper().deleteByIds(s);
//    }
//
//    @Override
//    public List<T> selectByIds(String s) {
//        return getMapper().selectByIds(s);
//    }
//
//    @Override
//    public int insertList(List<T> list) {
//        return getMapper().insertList(list);
//    }
//
//    @Override
//    public int insertUseGeneratedKeys(T t) {
//        return getMapper().insertUseGeneratedKeys(t);
//    }
//}

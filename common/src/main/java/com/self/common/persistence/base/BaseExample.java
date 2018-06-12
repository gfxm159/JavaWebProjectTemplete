package com.self.common.persistence.base;


import com.self.common.constants.Constants;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Set;

/**
 * @author chengfengfeng
 */
public class BaseExample extends Example {


    public BaseExample(Class<?> entityClass) {
        super(entityClass);
    }

    public BaseExample(Class<?> entityClass, boolean exists) {
        super(entityClass, exists);
    }

    public BaseExample(Class<?> entityClass, boolean exists, boolean notNull) {
        super(entityClass, exists, notNull);
    }


    @Override
    public Class<?> getEntityClass() {
        return super.getEntityClass();
    }

    @Override
    public String getOrderByClause() {
        return super.getOrderByClause();
    }

    @Override
    public void setOrderByClause(String orderByClause) {
        super.setOrderByClause(orderByClause);
    }

    @Override
    public OrderBy orderBy(String property) {
        return super.orderBy(property);
    }

    @Override
    public Set<String> getSelectColumns() {
        return super.getSelectColumns();
    }

    @Override
    public Example selectProperties(String... properties) {
        return super.selectProperties(properties);
    }

    @Override
    public boolean isDistinct() {
        return super.isDistinct();
    }

    @Override
    public void setDistinct(boolean distinct) {
        super.setDistinct(distinct);
    }

    @Override
    public List<Criteria> getOredCriteria() {
        return super.getOredCriteria();
    }

    @Override
    public void or(Criteria criteria) {
        super.or(criteria);
    }

    @Override
    public BaseCriteria or() {
        BaseCriteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    @Override
    public BaseCriteria createCriteria() {
        BaseCriteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }
        return criteria;
    }

    @Override
    protected BaseCriteria createCriteriaInternal() {
        BaseCriteria criteria = new BaseCriteria(this.propertyMap, this.exists, this.notNull);
        return criteria;
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void setTableName(String tableName) {
        super.setTableName(tableName);
    }

    @Override
    public String getDynamicTableName() {
        return super.getDynamicTableName();
    }


    public Criteria buildPublishAndNotDelete(){
        return this.createCriteria()
                .andEqualTo("isPublish", Constants.True)
                .andEqualTo("isDelete", Constants.False);
    }

}

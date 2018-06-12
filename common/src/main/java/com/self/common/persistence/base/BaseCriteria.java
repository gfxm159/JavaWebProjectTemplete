package com.self.common.persistence.base;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;


/**
 * @author chengfengfeng
 */
public class BaseCriteria extends Example.Criteria {

    public BaseCriteria(Map<String, EntityColumn> propertyMap, boolean exists, boolean notNull) {
        super(propertyMap, exists, notNull);
    }

    public Example.Criteria andEqualTo(boolean isCondition, Object param) {
        if (!isCondition)
            return (Example.Criteria)this;
        return super.andEqualTo(param);
    }

    protected void addCriterion(boolean isCondition, String condition) {
        if (!isCondition)
            return ;
        super.addCriterion(condition);
    }

    protected void addCriterion(boolean isCondition, String condition, Object value, String property) {
        if (!isCondition)
            return ;
        super.addCriterion(condition, value, property);
    }

    protected void addCriterion(boolean isCondition, String condition, Object value1, Object value2, String property) {
        if (!isCondition)
            return ;
        super.addCriterion(condition, value1, value2, property);
    }

    public BaseCriteria andIsNull(boolean isCondition, String property) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andIsNull(property);
    }

    public BaseCriteria andIsNotNull(boolean isCondition, String property) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andIsNotNull(property);
    }

    public BaseCriteria andEqualTo(boolean isCondition, String property, Object value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andEqualTo(property, value);
    }

    public BaseCriteria andNotEqualTo(boolean isCondition, String property, Object value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andNotEqualTo(property, value);
    }

    public BaseCriteria andGreaterThan(boolean isCondition, String property, Object value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andGreaterThan(property, value);
    }

    public BaseCriteria andGreaterThanOrEqualTo(boolean isCondition, String property, Object value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andGreaterThanOrEqualTo(property, value);
    }

    public BaseCriteria andLessThan(boolean isCondition, String property, Object value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andLessThan(property, value);
    }

    public BaseCriteria andLessThanOrEqualTo(boolean isCondition, String property, Object value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andLessThanOrEqualTo(property, value);
    }

    public BaseCriteria andIn(boolean isCondition, String property, Iterable values) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andIn(property, values);
    }

    public BaseCriteria andNotIn(boolean isCondition, String property, Iterable values) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andNotIn(property, values);
    }

    public BaseCriteria andBetween(boolean isCondition, String property, Object value1, Object value2) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andBetween(property, value1, value2);
    }

    public BaseCriteria andNotBetween(boolean isCondition, String property, Object value1, Object value2) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andNotBetween(property, value1, value2);
    }

    public BaseCriteria andLike(boolean isCondition, String property, String value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andLike(property, "%" + value + "%");
    }

    public BaseCriteria andNotLike(boolean isCondition, String property, String value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andNotLike(property, "%" + value + "%");
    }

    public BaseCriteria andCondition(boolean isCondition, String condition) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andCondition(condition);
    }

    public BaseCriteria andCondition(boolean isCondition, String condition, Object value) {
        if (!isCondition)
            return (BaseCriteria)this;
        return (BaseCriteria)super.andCondition(condition, value);
    }
}

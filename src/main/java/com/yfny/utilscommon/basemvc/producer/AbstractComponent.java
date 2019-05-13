package com.yfny.utilscommon.basemvc.producer;

import java.util.List;

/**
 * 微服务抽象Component
 * Author jisongZhou
 * Date  2019-05-09
 */
public abstract class AbstractComponent<T> {

    public abstract void add(AbstractComponent component);

    public abstract void remove(AbstractComponent component);

    public abstract void clear();

    public abstract AbstractComponent getChild(int i);

    public abstract List<AbstractComponent> allList();

    public abstract T getParam();

    public abstract int insert();

    public abstract int insertSelective();

    public abstract int update();

    public abstract int updateSelective();

    public abstract int delete();

    public abstract int deleteByPrimaryKey(Object key);

}

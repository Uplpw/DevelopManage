package com.manage.daobase;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T, PK extends Serializable> {

	/**
	 * 
	 * @param pk 主键
	 * @return 一个实例对象
	 */
	public T get(PK pk);

	/**
	 * 
	 * @return 一个实例对象集合
	 */
	public List<T> getAll();

	/**
	 * 
	 * @param orderBy 排序字段
	 * @param isAsc 默认正序排序
	 * @return 一个排序后的实例对象集合
	 */
	public List<T> getAll(String orderBy, boolean isAsc);

	/**
	 * 
	 * @param propertyName 属性名字(表的字段名)
	 * @param value 属性值(表的字段值)
	 * @param orderBy 排序字段
	 * @param isAsc 默认正序排序
	 * @return 一个排序后的实例对象集合
	 */
	public List<T> findBy(String propertyName, Object value, String orderBy, boolean isAsc);

	/**
	 * 
	 * @param propertyName 属性名字(表的字段名)
	 * @param valueOne 属性下限值(表的字段值)
	 * @param valueTwo 属性上限值(表的字段值)
	 * @param orderBy 排序字段
	 * @param isAsc 默认正序排序
	 * @return 一个排序后的实例对象集合
	 */
	public List<T> findBetweenProperty(String propertyName, Object valueOne, Object valueTwo, String orderBy,
			boolean isAsc);

	/**
	 * 
	 * @param propertyName 属性名字(表的字段名)
	 * @param value 属性值(表的字段值)
	 * @param orderBy 排序字段
	 * @param isAsc 默认正序排序
	 * @return 一个排序后的实例对象集合
	 */
	public List<T> findLike(String propertyName, Object value, String orderBy, boolean isAsc);

	/**
	 * 
	 * @param entity 需要插入的实例，数据库中为一条数据
	 */
	public void save(T entity);

	/**
	 * 
	 * @param entity 需要更新的实例，数据库中为一条数据
	 */
	public void update(T entity);

	/**
	 * 
	 * @param entity 需要删除的实例，数据库中为一条数据
	 * @return 受影响的数据条数
	 */
	public int remove(T entity);

	/**
	 * 
	 * @param pk
	 */
	public void removeByPk(PK pk);

	/**
	 * 
	 * @param entity
	 */
	public void evit(T entity);

	public void flush();

	public void clear();

}

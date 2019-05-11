package com.manage.daobase;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.manage.util.DBUtil;

public class BaseDao<T, PK extends Serializable> implements IBaseDao<T, PK> {
	protected Class<T> entityClass;

	public BaseDao(Class<T> type) {
		this.entityClass = type;
	}

	public BaseDao() {
	}

	protected Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	public T get(PK pk) {
		String sql = "select * from " + entityClass.getSimpleName() + " where pk = " + pk;
		return getAll(sql).get(0);
	}

	@Override
	public List<T> getAll() {
		return getAll(null, true);
	}

	@Override
	public List<T> getAll(String orderBy, boolean isAsc) {
		String asc = "asc";
		if (!isAsc)
			asc = "desc";
		String sql = "select * from " + entityClass.getSimpleName() + " order by " + orderBy + " " + asc;
		//System.out.println(sql);
		return getAll(sql);
	}

	@Override
	public List<T> findBy(String propertyName, Object value, String orderBy, boolean isAsc) {
		String asc = "asc";
		if (isAsc)
			asc = "desc";
		
		String sql = "select * from " + entityClass.getSimpleName() + " where " + propertyName;
		
		if(value instanceof String) {
			sql = sql + " = '" + value + "' order by " + orderBy + " " + asc;
		}else if(value instanceof Integer){
			sql = sql + " = " + value + " order by " + orderBy + " " + asc;
		}else {
			System.out.println("类型转换尚未完成。");
		}
		System.out.println(sql);
		return getAll(sql);
	}
	
	/*
	 * 模糊查询(non-Javadoc)
	 * @see com.it.Agile.daoBase.IBaseDao#findLike(java.lang.String, java.lang.Object, java.lang.String, boolean)
	 */
	@Override
	public List<T> findLike(String propertyName, Object value, String orderBy, boolean isAsc) {
		// TODO Auto-generated method stub
		String asc = "asc";
		if (isAsc) {
			asc = "desc";
		}
		String sql = "select * from " + entityClass.getSimpleName() + " where " + propertyName + " like " +
				"'%"+ value +"%'" + " order by " + orderBy + " " + asc;
		System.out.println(sql);
		return getAll(sql);
		//return null;
	}
	
	@Override
	/**
	 * 
	 */
	public void save(T entity) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Field[] fields = entity.getClass().getDeclaredFields();
		String sql = "insert into " + entity.getClass().getSimpleName();
		try {
			String keys = "";
			String values = "";
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				keys += fields[i].getName();
				switch (fields[i].get(entity).getClass().getSimpleName()) {
				case "String":
					values += " '" + fields[i].get(entity) + "' ";
					break;
				case "Integer":
					values += fields[i].get(entity);
					break;
				case "BigDecimal":
					values += fields[i].get(entity);
					break;
				case "Long":
					values += fields[i].get(entity);
					break;
				default:
					System.out.println("类型转换尚未完成");
					break;
				}
				if (i != fields.length - 1) {
					keys += ",";
					values += ",";
				}
			}
			sql += " ( " + keys + " ) " + "values ( " + values + " ) ";
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(resultSet, preparedStatement, connection);
		}

	}

	@Override
	public void update(T entity) {
		/*Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Field[] fields = entity.getClass().getDeclaredFields();
		String sql = "update " + entity.getClass().getSimpleName();
		sql+=" set status = "+entity.*/

	}

	@Override
	public void remove(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeByPk(PK pk) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evit(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	private List<T> getAll(String sql) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Object> aList = null;
		try {
			//System.out.println(1);
			connection = DBUtil.getConnection();
			//System.out.println(2);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			aList = new ArrayList<>();
			Field[] fields = entityClass.getDeclaredFields();
			while (resultSet.next()) {
				T object = entityClass.newInstance();
				for (Field field : fields) {
					field.setAccessible(true);
					field.set(object, resultSet.getObject(field.getName()));
				}
				aList.add(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(resultSet, preparedStatement, connection);
		}
		return (List<T>) aList;
	}

	/* (non-Javadoc)
	 * @see com.it.Agile.daoBase.IBaseDao#findBetweenProperty(java.lang.String, java.lang.Object, java.lang.Object, java.lang.String, boolean)
	 */
	@Override
	public List<T> findBetweenProperty(String propertyName, Object valueOne, Object valueTwo, String orderBy,
			boolean isAsc) {
		String asc = "asc";
		if (isAsc)
			asc = "desc";
		
		String sql = "select * from " + entityClass.getSimpleName() + " where " + propertyName +
				" >= " + valueOne + " and " + propertyName +" < "+ valueTwo+ " order by " + orderBy + " " + asc;
		System.out.println(sql);
		return getAll(sql);
	}
}
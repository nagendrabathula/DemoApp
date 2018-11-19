package com.olive.repositories;

import java.util.List;

public interface UpiCommonDao {
	public void create(Object o);

	public void update(Object o);

	public void delete(Object o);
	
	public void deleteAll(List<Long> list,Class neededClass);

	public Object find(Class neededClass, long pk);
	public Object findByIdInt(Class neededClass, int pk);

	public List findAll(Class neededClass);
	
	public void SaveorUpdate(Object o);

	
}

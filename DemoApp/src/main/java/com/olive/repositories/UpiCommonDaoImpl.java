package com.olive.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service
@Transactional
public class UpiCommonDaoImpl implements UpiCommonDao{
	
	@PersistenceContext
    protected EntityManager entityManager;
	

	@Override
	public void create(Object o) {
		entityManager.persist(o);
	}

	@Override
	public void update(Object o) {
		System.out.println("********Update***********************"+o.getClass());
		entityManager.merge(o);
		System.out.println("********Update END***********************");
	}
   
	@Override
	public void delete(Object o) {
		entityManager.remove(entityManager.contains(o) ? o :entityManager.merge(o));
		
	}
	

	@Override
	public Object find(Class neededClass, long pk) {
		return entityManager.find(neededClass, pk);
	}

	@Override
	public List findAll(Class neededClass) {
		return entityManager.createQuery("Select t from " + neededClass.getSimpleName() + " t").getResultList();
	}

	@Override
	public void SaveorUpdate(Object o) {
		boolean flag = entityManager.contains(o);
		if(flag == true){
			entityManager.merge(o);
		}else if(flag == false){
			entityManager.persist(o);
		}
		
		
	}
	public void deleteAll(List<Long> list,Class neededClass) {
	    int i=0;
	    for(Long id : list) {
	        if(++i%49==0) {
	            entityManager.flush();
	        }
	        entityManager.remove(entityManager.find(neededClass, id));
	    }
	}
	
	@Override
	public Object findByIdInt(Class neededClass, int pk) {
		return entityManager.find(neededClass, pk);
	}
}

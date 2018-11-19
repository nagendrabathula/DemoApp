package com.olive.repositories;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.olive.entities.User;




@Repository
@Service
@Transactional
public class CustomerCrudImpl extends UpiCommonDaoImpl implements CustomerCrudRepository {


	@Override
	public User findByuserName(String name) {
		
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class);
		if(!StringUtils.isEmpty(name)){
			System.out.println("NAME"+name);
			criteria.add(Restrictions.eq("name",name));
			}
		return  (User) criteria.uniqueResult();
	}

}

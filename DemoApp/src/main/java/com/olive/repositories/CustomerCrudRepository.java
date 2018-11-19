package com.olive.repositories;



import com.olive.entities.User;



public interface CustomerCrudRepository extends UpiCommonDao  {

	User findByuserName(String name);

	
}

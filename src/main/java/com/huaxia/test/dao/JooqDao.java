package com.huaxia.test.dao;

import java.util.List;

import com.huaxia.generated.Tables;
import com.huaxia.generated.tables.*;
import com.huaxia.test.bean.MyUsers;
import com.huaxia.test.util.poll.DruidPool;

/**
 * Êý¾Ý¿â²Ù×÷Óï¾ä
 * @author lnb
 *
 */
public class JooqDao {
	public List<MyUsers> test(){
		DruidPool.getDSLContext().transaction(configuration -> {
			DruidPool.getDSLContext().update(Tables.ROLES)
		        .set(Roles.ROLES.ROLE_NAME, "test1")
		        .where(Roles.ROLES.ROLE_ID.eq(Integer.valueOf(2)))
		        .execute();
			DruidPool.getDSLContext().update(Tables.ROLES)
		        .set(Roles.ROLES.ROLE_NAME, "test")
		        .where(Roles.ROLES.ROLE_ID.eq(Integer.valueOf(1)))
		        .execute();
		     // int i = 1/0;
		      System.out.println("end");
		    });
		List<MyUsers> list = DruidPool.getDSLContext().selectFrom(Tables.USERS).fetch().map(record -> { 
		MyUsers users = record.into(MyUsers.class); 
		return users;
		});
		return list;
	}

	public boolean login(String userName, String pwd) {
		List<MyUsers> list = DruidPool.getDSLContext().selectFrom(Tables.USERS)
		.where(Tables.USERS.USER_NAME.eq(userName)).and(Tables.USERS.USER_PASSWORD.eq(pwd)).fetch().map(record -> { 
			MyUsers users = record.into(MyUsers.class); 
			return users;
			});
		if (!list.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}
}

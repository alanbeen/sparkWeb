package com.huaxia.test.service;

import java.util.List;

import com.huaxia.generated.tables.Users;
import com.huaxia.test.bean.MyUsers;
import com.huaxia.test.dao.JooqDao;

/**
 * ÒµÎñÂß¼­Óï¾ä
 * @author lnb
 *
 */
public class SparkService {
	private JooqDao jooqDao = new JooqDao();
	public List<MyUsers> listUsers() {
		return jooqDao.test();
	}

	public boolean login(String userName, String pwd) {
		return jooqDao.login(userName,pwd);
	}

}

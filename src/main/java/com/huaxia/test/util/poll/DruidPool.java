package com.huaxia.test.util.poll;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.vendor.MySqlValidConnectionChecker;
import com.huaxia.test.util.transaction.SpringTransactionProvider;

public class DruidPool{
public static DSLContext getDSLContext() {
    try {
    	Properties properties = new Properties();
    	String dd = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"/"+"jdbc.properties";
    	InputStream in = new BufferedInputStream (new FileInputStream(dd));  
    	properties.load(in);
    	String driverClassName = properties.getProperty("jdbc.driverClassName");
    	String url = properties.getProperty("jdbc.url");
    	String username = properties.getProperty("jdbc.username");
    	String password = properties.getProperty("jdbc.password");
    	DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(20_000);
        dataSource.setMinIdle(0);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setInitialSize(1);
        dataSource.setMinEvictableIdleTimeMillis(1000*60*10);
        dataSource.setTimeBetweenEvictionRunsMillis(60*1000);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setValidConnectionChecker(new MySqlValidConnectionChecker());
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(dataSource);
        DataSourceTransactionManager txMgr =  new DataSourceTransactionManager(dataSource);
        Configuration configuration = new DefaultConfiguration()
             .set(new DataSourceConnectionProvider(proxy))
             .set(new SpringTransactionProvider(txMgr))//spring事物管理
             .set(SQLDialect.MYSQL);
        return DSL.using(configuration);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
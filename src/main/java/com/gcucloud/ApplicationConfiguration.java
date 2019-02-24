package com.gcucloud;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcucloud.model.MessageModel;
import com.gcucloud.services.business.IMessageService;
import com.gcucloud.services.business.MessageService;
import com.gcucloud.services.data.IMessageDAO;
import com.gcucloud.services.data.MessageDAO;

/**
 * Trevor Moore
 * CST-323
 * 02/14/2019
 * This assignment was completed in collaboration with Connor Low
 * This is our own work.
 * 
 * ApplicationConfiguration class for defining all our SpringBeans.
 * @author Trevor
 *
 */
@Configuration
public class ApplicationConfiguration 
{
	/// BUSINESS SERVICES ///
	/**
	 * Getter for MessageService SpringBean (singleton scoped)
	 * @return type IMessageService
	 */
	@Bean(name="messageService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IMessageService getMessageService()
	{
		return new MessageService();
	}
	/// DATA SERVICES ///
	/**
	 * Getter for MessageDAO SpringBean (singleton scoped)
	 * @return type IMessageDAO
	 */
	@Bean(name="messageDAO")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public IMessageDAO<MessageModel> getMessageDAO()
	{
		return new MessageDAO();
	}
	/// DATA SOURCE ///
	/**
	 * Getter for DataSource SpringBean (singleton scoped)
	 * @return type DataSource
	 */
	@Bean(name="dataSource", destroyMethod = "close")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataSource getDataSource()
	{
		DataSource dataSource = new DataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://xq7t6tasopo9xxbs.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/hakd3acwmr7ozvcq");
	    dataSource.setUsername("g21ovhqube4cxlu3");
	    dataSource.setPassword("ui1enwdmoza4orqn"); 
	    dataSource.setInitialSize(2);
	    return dataSource;
	}
}

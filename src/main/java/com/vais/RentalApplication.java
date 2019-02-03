package com.vais;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@ComponentScan("com.vais")

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })

public class RentalApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}

	/**
	 * This method configures dataSource from application.properties file
	 * 
	 * @return sql DataSource
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: aplication.properties
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));

		System.out.println("## getDataSource: " + dataSource);

		return dataSource;
	}

	/**
	 * This method create Hibernate SessionFactory based on incoming dataSource
	 * 
	 * @param dataSource requires to configure sessionFactory
	 * @return Hibernate SessionFactory
	 * @throws Exception if pointed property doesn't exist
	 */
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		Properties properties = new Properties();

		// See: application.properties
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
		properties.put("current_session_context_class", //
				env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		// Fix Postgres JPA Error:
		// Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
		properties.put("hibernate.temp.use_jdbc_metadata_defaults", false);

		// Package contain entity classes
		factoryBean.setPackagesToScan(new String[] { "" });
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();

		SessionFactory sesf = factoryBean.getObject();
		System.out.println("## getSessionFactory: " + sesf);

		return sesf;

	}

	/**
	 * This method creates Hibernate TransactionManager based on given
	 * SessionFactory
	 * 
	 * @param sessionFactory requires to create TransactionManager
	 * @return TransactionManager
	 */
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
}

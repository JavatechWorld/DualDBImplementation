package com.db.implementation.config;


import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "studentEntityManagerFactory",
		basePackages 	 = {"com.db.implementation.repo1"},
		transactionManagerRef = "studentTransactionManager"
		)
public class DatabaseConfig {
	
	@Autowired
	Environment env;

	@Primary
	@Bean(name= "studentDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl(env.getProperty("student.datasource.url"));
		ds.setUsername(env.getProperty("student.datasource.username"));
		ds.setPassword(env.getProperty("student.datasource.password"));
		ds.setDriverClassName(env.getProperty("student.datasource.driver-class-name"));
		return ds;
	}

	
	@Primary
	@Bean(name= "studentEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
		HashMap<String,Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		bean.setJpaPropertyMap(properties);
		bean.setPackagesToScan("com.db.implementation.entity1");
		return bean;
		
	}
	
	@Primary
	@Bean("studentTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("studentEntityManagerFactory") EntityManagerFactory entityManagerFactory ) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}

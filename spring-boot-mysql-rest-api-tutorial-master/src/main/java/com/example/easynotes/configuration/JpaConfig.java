package com.example.easynotes.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableTransactionManagement
@Import( { DataSourceConfiguration.class })
public class JpaConfig {

	@Autowired
	private DataSourceConfiguration dataSourceConfiguration;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
 
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        try {
	
        	
        //For JNDI connection - uncomment below
       localContainerEntityManagerFactoryBean.setDataSource(dataSourceConfiguration.jndiSqldataSource());
     

       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       
       localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
       localContainerEntityManagerFactoryBean.setJpaProperties(additionalProperties());
  
      
		} catch (Exception e) {
			e.printStackTrace();
		}
        return localContainerEntityManagerFactoryBean;
        
    }
    
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        
        properties.setProperty("spring.jpa.show-sql","true");
        return properties;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){ 
         JpaTransactionManager tm = new JpaTransactionManager();
         tm.setEntityManagerFactory(entityManagerFactory);
         tm.afterPropertiesSet();
         return tm; 
    }
	
}

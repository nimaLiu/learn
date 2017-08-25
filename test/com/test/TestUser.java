package com.test;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.User;

public class TestUser {
	  private SessionFactory sessionFactory;
	  private Session session;
	  private  Transaction transaction;
	  
	@Before
	public void init(){
		Configuration configuration=new Configuration().configure();
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		session=sessionFactory.openSession();
		transaction= session.beginTransaction();
	}
	
	
    @Test
    public void test(){
    	User user=new User(1,"Áõº£²¨","ÄÐ",new Date(),"ºÓÄÏ");
    	session.save(user);
     }
    
    @After
    public void destory(){
    	transaction.commit();
    	session.close();
    	sessionFactory.close();
    }
}
